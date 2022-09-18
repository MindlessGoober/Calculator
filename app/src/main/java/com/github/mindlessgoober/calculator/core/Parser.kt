package com.github.mindlessgoober.calculator.core

import com.github.mindlessgoober.calculator.sealedClasses.*
import kotlin.math.pow

class Parser(private val expression: List<Token>, private var index: Int = 0) {
    fun evaluate(): String {
        val valResult = parsePlusMinus()
        if (valResult.isNaN()) {
            return ""
        }

        var valResultStr = valResult.toString()
        if (valResult % 1 == 0.0 && !valResult.toString().contains("E")) {
            valResultStr = valResultStr.substringBefore(delimiter = Point.symbol)
        }

        return valResultStr
    }

    private fun parsePlusMinus(): Double = parsePlusMinusPrime(parseMultiplyDivide())

    private fun parsePlusMinusPrime(valUntil: Double): Double = when (expression.getOrNull(index)) {
        is Operator.Plus -> {
            index++
            parsePlusMinusPrime(valUntil.add(parseMultiplyDivide()))
        }

        is Operator.Minus -> {
            index++
            parsePlusMinusPrime(valUntil.subtract(parseMultiplyDivide()))
        }

        else -> {
            valUntil
        }
    }

    private fun parseMultiplyDivide(): Double = parseMultiplyDividePrime(parsePower())

    private fun parseMultiplyDividePrime(valUntil: Double): Double =
        when (expression.getOrNull(index)) {
            is Operator.Multiply -> {
                index++
                parseMultiplyDividePrime(valUntil.multiply(parsePower()))
            }

            is Operator.Divide -> {
                index++
                parseMultiplyDividePrime(valUntil.divide(parsePower()))
            }

            else -> {
                valUntil
            }
        }

    private fun parsePower() = parsePowerPrime(parseUnaryPlusMinus())

    private fun parsePowerPrime(valUntil: Double): Double = when (expression.getOrNull(index)) {
        is Operator.Power -> {
            index++
            valUntil.pow(parsePower())
        }

        else -> {
            valUntil
        }
    }

    private fun parseUnaryPlusMinus(): Double = when (expression.getOrNull(index)) {
        is Operator.Minus -> {
            index++
            parseUnaryPlusMinusPrime(-parseBrace())
        }

        is Operator.Plus -> {
            index++
            parseUnaryPlusMinusPrime(parseBrace())
        }

        else -> {
            parseUnaryPlusMinusPrime(parseBrace())
        }
    }

    private fun parseUnaryPlusMinusPrime(valUntil: Double): Double {
        val valResult = parseBrace()

        if (valUntil.isNaN() && valResult.isNaN()) {
            return Double.NaN
        }

        if (valUntil.isNaN()) {
            return valResult
        }

        if (valResult.isNaN()) {
            return valUntil
        }

        return parseUnaryPlusMinusPrime(valUntil.multiply(valResult))
    }

    private fun parseBrace(): Double = when (expression.getOrNull(index)) {
        is Brace.Open -> {
            index++
            val valResult = parsePlusMinus()
            index++
            valResult
        }

        is Digit, Point -> {
            parseNumber()
        }

        else -> {
            Double.NaN
        }
    }


    private fun parseNumber(): Double {
        val numStartIdx = index
        while (expression.getOrNull(index) is Digit || expression.getOrNull(index) is Point) {
            index++
        }

        return expression.subList(numStartIdx, index).joinToString(separator = "") { it.symbol }
            .toDoubleSafe()
    }
}
package com.github.mindlessgoober.calculator.core

import com.github.mindlessgoober.calculator.sealedClasses.Digit
import com.github.mindlessgoober.calculator.sealedClasses.Point
import java.math.RoundingMode

fun Double.add(that: Double): Double {
    if (this.isNaN() || that.isNaN()) {
        return Double.NaN
    }

    if (this.isInfinite() || that.isInfinite()) {
        return if (this.isInfinite()) this else that
    }

    return this.toBigDecimal().plus(that.toBigDecimal()).toDouble()
}

fun Double.subtract(that: Double): Double {
    if (this.isNaN() || that.isNaN()) {
        return Double.NaN
    }

    if (this.isInfinite() || that.isInfinite()) {
        return if (this.isInfinite()) this else that
    }

    return this.toBigDecimal().minus(that.toBigDecimal()).toDouble()
}

fun Double.multiply(that: Double): Double {
    if (this.isNaN() || that.isNaN()) {
        return Double.NaN
    }

    if (this.isInfinite() || that.isInfinite()) {
        return if (this == that) Double.POSITIVE_INFINITY else Double.NEGATIVE_INFINITY
    }

    return this.toBigDecimal().times(that.toBigDecimal()).toDouble()
}

fun Double.divide(that: Double): Double {
    if (this.isNaN() || that.isNaN() || that == Digit.Zero.symbol.toDouble()) {
        return Double.NaN
    }

    if (this.isInfinite() || that.isInfinite()) {
        return if (this == that) Double.POSITIVE_INFINITY else Double.NEGATIVE_INFINITY
    }

    return this.toBigDecimal().divide(that.toBigDecimal(), 16, RoundingMode.HALF_EVEN).toDouble()
}

fun String.toDoubleSafe(): Double {
    if (this.isEmpty() || this == Point.symbol) {
        return Double.NaN
    }

    return this.toDouble()
}
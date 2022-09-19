package com.github.mindlessgoober.calculator.core

import com.github.mindlessgoober.calculator.sealedClasses.Digit
import com.github.mindlessgoober.calculator.sealedClasses.Point
import com.github.mindlessgoober.calculator.sealedClasses.Token

fun lexer(valResult: String): List<Token> {
    val tokenList = mutableListOf<Token>()
    if (valResult.contains("E")) {
        return tokenList
    }

    for (token in valResult) {
        when (token.toString()) {
            Point.symbol -> tokenList.add(Point)
            Digit.Zero.symbol -> tokenList.add(Digit.Zero)
            Digit.One.symbol -> tokenList.add(Digit.One)
            Digit.Two.symbol -> tokenList.add(Digit.Two)
            Digit.Three.symbol -> tokenList.add(Digit.Three)
            Digit.Four.symbol -> tokenList.add(Digit.Four)
            Digit.Five.symbol -> tokenList.add(Digit.Five)
            Digit.Six.symbol -> tokenList.add(Digit.Six)
            Digit.Seven.symbol -> tokenList.add(Digit.Seven)
            Digit.Eight.symbol -> tokenList.add(Digit.Eight)
            Digit.Nine.symbol -> tokenList.add(Digit.Nine)
        }
    }

    return tokenList
}
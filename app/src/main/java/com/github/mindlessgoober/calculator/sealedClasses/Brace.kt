package com.github.mindlessgoober.calculator.sealedClasses

sealed class Brace(symbol: String) : Token(symbol) {
    object Pair : Brace("( )")
    object Open : Brace("(")
    object Close : Brace(")")
}
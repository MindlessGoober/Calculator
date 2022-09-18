package com.github.mindlessgoober.calculator.sealedClasses

sealed class Operator(symbol: String) : Token(symbol) {
    object Power : Operator("^")
    object Divide : Operator("/")
    object Multiply : Operator("*")
    object Minus : Operator("-")
    object Plus : Operator("+")
}
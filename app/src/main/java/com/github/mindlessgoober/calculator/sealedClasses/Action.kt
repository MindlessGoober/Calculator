package com.github.mindlessgoober.calculator.sealedClasses

sealed class Action(symbol: String) : Token(symbol) {
    object CLear : Action("C")
    object Delete : Action("Del")
    object Equals : Action("=")
}
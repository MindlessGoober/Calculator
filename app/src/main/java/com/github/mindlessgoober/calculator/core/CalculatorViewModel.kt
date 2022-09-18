package com.github.mindlessgoober.calculator.core

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.github.mindlessgoober.calculator.sealedClasses.*

class CalculatorViewModel : ViewModel() {
    private val _expression = listOf<Token>().toMutableStateList()
    val expression: List<Token> get() = _expression

    fun onAction(action: Token): Any? = when (action) {
        is Brace -> pushBrace()
        is Operator -> pushOperator(action)
        is Action.Delete -> pop()
        is Action.CLear -> clear()
        is Point -> pushPoint()
        is Action.Equals -> equals()
        is Digit -> push(action)
    }

    private fun clear() = _expression.clear()

    private fun pop() = _expression.removeLastOrNull()

    private fun push(action: Token) = _expression.add(action)

    private fun equals() {
        val valResult = Parser(_expression).evaluate()
        clear()
        _expression.addAll(lexer(valResult))
    }

    private fun pushOperator(action: Token) {
        if (_expression.lastOrNull() is Point) {
            return
        }

        if (_expression.lastOrNull() is Digit || _expression.lastOrNull() is Brace.Close) {
            push(action)
            return
        }

        if (_expression.lastOrNull() is Operator.Power) {
            if (isUnaryOperator(action)) {
                push(action)
            }

            return
        }

        if (_expression.lastOrNull() is Operator && (_expression.getOrNull(_expression.size - 2) is Digit || _expression.getOrNull(
                _expression.size - 2
            ) is Brace.Close)
        ) {
            pop()
            push(action)
            return
        }

        if (!isUnaryOperator(action)) {
            return
        }

        if (_expression.lastOrNull() is Operator) {
            pop()
        }

        push(action)
    }

    private fun pushBrace() {
        if (_expression.count { it == Brace.Open } > _expression.count { it == Brace.Close } && _expression.lastOrNull() !is Operator && _expression.lastOrNull() !is Brace.Open) _expression.add(
            Brace.Close
        ) else _expression.add(Brace.Open)
    }

    private fun pushPoint() {
        if (!_expression.contains(Point) || _expression.subList(
                _expression.lastIndexOf(Point) + 1, _expression.size
            ).any { it !is Digit }
        ) {
            _expression.add(Point)
        }
    }
}
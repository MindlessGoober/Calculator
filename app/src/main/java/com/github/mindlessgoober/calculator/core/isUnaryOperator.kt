package com.github.mindlessgoober.calculator.core

import com.github.mindlessgoober.calculator.sealedClasses.Operator
import com.github.mindlessgoober.calculator.sealedClasses.Token

fun isUnaryOperator(action: Token): Boolean = action is Operator.Plus || action is Operator.Minus
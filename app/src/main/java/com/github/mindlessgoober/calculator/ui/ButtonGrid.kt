package com.github.mindlessgoober.calculator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.mindlessgoober.calculator.sealedClasses.*

@Composable
fun ButtonGrid(onClick: (Token) -> Unit) = Column(modifier = Modifier.fillMaxWidth()) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { onClick(Action.CLear) },
            symbol = Action.CLear.symbol,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.errorContainer
        )

        Button(
            onClick = { onClick(Brace.Pair) },
            symbol = Brace.Pair.symbol,
            modifier = Modifier.weight(1f),
        )

        Button(
            onClick = { onClick(Operator.Power) },
            symbol = Operator.Power.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Operator.Divide) },
            symbol = Operator.Divide.symbol,
            modifier = Modifier.weight(1f)
        )
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { onClick(Digit.Seven) },
            symbol = Digit.Seven.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Digit.Eight) },
            symbol = Digit.Eight.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Digit.Nine) },
            symbol = Digit.Nine.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Operator.Multiply) },
            symbol = Operator.Multiply.symbol,
            modifier = Modifier.weight(1f)
        )
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { onClick(Digit.Four) },
            symbol = Digit.Four.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Digit.Five) },
            symbol = Digit.Five.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Digit.Six) },
            symbol = Digit.Six.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Operator.Minus) },
            symbol = Operator.Minus.symbol,
            modifier = Modifier.weight(1f)
        )
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { onClick(Digit.One) },
            symbol = Digit.One.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Digit.Two) },
            symbol = Digit.Two.symbol,
            modifier = Modifier.weight(1f),
        )

        Button(
            onClick = { onClick(Digit.Three) },
            symbol = Digit.Three.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Operator.Plus) },
            symbol = Operator.Plus.symbol,
            modifier = Modifier.weight(1f)
        )
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = { onClick(Digit.Zero) },
            symbol = Digit.Zero.symbol,
            modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Point) }, symbol = Point.symbol, modifier = Modifier.weight(1f)
        )

        Button(
            onClick = { onClick(Action.Delete) },
            symbol = Action.Delete.symbol,
            modifier = Modifier.weight(1f),
        )

        Button(
            onClick = { onClick(Action.Equals) },
            symbol = Action.Equals.symbol,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.primaryContainer
        )
    }
}
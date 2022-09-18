package com.github.mindlessgoober.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.mindlessgoober.calculator.core.Parser
import com.github.mindlessgoober.calculator.sealedClasses.Token


@Composable
fun Display(expression: List<Token>, modifier: Modifier = Modifier) = Column(
    modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.inverseOnSurface)
        .then(modifier),
    verticalArrangement = Arrangement.Bottom
) {
    TextDisplay(
        text = expression.joinToString(separator = "") { it.symbol },
        modifier = Modifier.weight(1f)
    )
    TextDisplay(
        text = Parser(expression = expression).evaluate(),
        modifier = Modifier.weight(1f),
        toReverseScroll = false
    )
}
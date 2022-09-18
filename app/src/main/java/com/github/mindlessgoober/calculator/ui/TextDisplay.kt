package com.github.mindlessgoober.calculator.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.min

@Composable
fun TextDisplay(text: String, modifier: Modifier = Modifier, toReverseScroll: Boolean = true) =
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        Text(text = text,
            fontSize = LocalDensity.current.run { min(maxWidth, maxHeight).toSp() } * .75f,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxSize()
                .horizontalScroll(
                    state = rememberScrollState(),
                    reverseScrolling = toReverseScroll
                ))
    }
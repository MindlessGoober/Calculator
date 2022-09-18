package com.github.mindlessgoober.calculator.ui

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Button(
    onClick: () -> Unit,
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.background
) = ElevatedButton(
    modifier = Modifier
        .padding(4.dp)
        .aspectRatio(1f)
        .then(modifier),
    onClick = onClick,
    shape = CircleShape,
    colors = ButtonDefaults.elevatedButtonColors(containerColor = color)
) { Text(text = symbol, maxLines = 1, fontSize = 18.sp) }
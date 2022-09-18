package com.github.mindlessgoober.calculator.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.mindlessgoober.calculator.core.CalculatorViewModel

@Composable
fun CalculatorUI(calculatorViewModel: CalculatorViewModel = viewModel()) = Column(
    modifier = Modifier
        .padding(all = 8.dp)
        .fillMaxSize(),
    verticalArrangement = Arrangement.Bottom
) {
    Display(expression = calculatorViewModel.expression, modifier = Modifier.weight(weight = 1f))
    ButtonGrid(onClick = calculatorViewModel::onAction)
}
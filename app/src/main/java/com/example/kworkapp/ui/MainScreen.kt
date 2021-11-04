package com.example.kworkapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kworkapp.Calculator
import com.example.kworkapp.R
import com.example.kworkapp.fontDimensionResource
import com.example.kworkapp.joinToList
import com.example.kworkapp.ui.theme.AppTheme

@Composable
fun MainScreen() {
    MainScreenView(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) { Calculator.calculateAverageEvenListItemsInUnevenPosition() }
}

@Composable
private fun MainScreenView(modifier: Modifier = Modifier, calculation: () -> Float) {

    val regex = Regex("^\\d+(,\\s*\\d+)*")
    var inputError by remember { mutableStateOf(false) }
    var textResult by remember { mutableStateOf("-") }

    var textState by remember {
        mutableStateOf(
            TextFieldValue(
                Calculator.numbersList.joinToString(", ")
            )
        )
    }

    Column(modifier = modifier) {

        OutlinedTextField(
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = textState,
            onValueChange = {
                textState = it
                inputError  = !regex.matches(it.text)

            },
            isError = inputError,
            modifier = Modifier
                .padding(
                    start = 16.dp, end = 16.dp, top = 20.dp
                )
                .fillMaxWidth(),

            )


        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp),
            onClick = {
                if (!inputError) {
                    Calculator.numbersList = textState.text.joinToList()
                    textResult = calculation().toString()
                }
            }
        ) {
            Text(text = stringResource(id = R.string.result_button_title))
        }


        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp),
            text = textResult,
            fontSize = fontDimensionResource(id = R.dimen.text_result_font_size)
        )

    }


}

@Preview
@Composable
fun MainScreenPreview() {
    AppTheme {
        Surface(color = MaterialTheme.colors.background) {
            MainScreen()
        }
    }
}
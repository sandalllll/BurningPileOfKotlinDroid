package com.insigni.tiptime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.insigni.tiptime.ui.theme.TipTimeTheme
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Alignment
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import java.text.NumberFormat
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.material3.TextField
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Switch
import org.jetbrains.annotations.VisibleForTesting
import androidx.compose.ui.text.input.ImeAction
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipTimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        var amountInput by remember { mutableStateOf("") }
        val amount = amountInput.toDoubleOrNull() ?: 0.0
        var amountPercentInput by remember { mutableStateOf("") }
        val amountPercent = amountPercentInput.toDoubleOrNull() ?: 0.0
        var tipRoundInput by remember { mutableStateOf(false) }
        val tip = calculateTip(amount, amountPercent, tipRoundInput)
        EditNumberField(
            amountInput,
            {value: String -> amountInput = value},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
            imeAction = ImeAction.Next)
        EditNumberField(
            amountPercentInput,
            {value: String -> amountPercentInput = value},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
            textR = R.string.tip_percentage)
        LabeledSwitch(
            checked = tipRoundInput,
            onCheckedChange = {checked -> tipRoundInput = checked},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth())
        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

/**
 * Calculates the tip based on the user input and format the tip amount
 * according to the local currency.
 * Example would be "$10.00".
 */
@VisibleForTesting
internal fun calculateTip(amount: Double, tipPercent: Double = 15.0, doRound: Boolean = false): String {
    var tip = tipPercent / 100 * amount
    if (doRound)
        tip = ceil(tip)
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    TipTimeTheme {
        TipTimeLayout()
    }
}

@Composable
fun EditNumberField(value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textR: Int = R.string.bill_amount,
    imeAction: ImeAction = ImeAction.Done)
{
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(text = stringResource(textR)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = imeAction)
    )
}

@Composable
fun LabeledSwitch(checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    textR: Int = R.string.round_up_tip_q)
{
    Row(modifier = modifier) {
        Text(
            text = stringResource(textR)
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )
    }
}
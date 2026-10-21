package com.insigni.tiptime

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

class TipCalculatorTests {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.0;
        val tipPercent = 20.0;
        val expectedTip = NumberFormat.getCurrencyInstance().format(2);
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent)
        assertEquals(expectedTip, actualTip)
    }

}
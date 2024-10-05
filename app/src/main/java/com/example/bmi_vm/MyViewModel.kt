package com.example.bmi_vm

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*

class MyViewModel: ViewModel() {
    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")

    // Jäsenmuuttuja 'result' on luotu mutableStateOf-muuttujana,
    // koska sitä käytetään suoraan UI:ssa ja sen muuttumisen tulisi käynnistää rekompositio
    var result: Float by mutableStateOf(0.0f)
        private set

    // Ohjeesta poiketen tuloksen laskeminen suoritetaan aina kun syötteet muuttuvat
    fun changeHeightInput(value: String) {
        heightInput = value
        calculateBMI()  // <-
    }

    fun changeWeightInput(value: String) {
        weightInput = value
        calculateBMI()  // <-
    }

    private fun calculateBMI() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0.0f

        result = if (weight > 0 && height > 0) weight / (height * height) * 10000 else 0.0f
    }

}
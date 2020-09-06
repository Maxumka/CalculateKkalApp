package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_losing.view.*
import kotlin.random.Random

class FragmentLosing : Fragment() {

    private lateinit var editTextPersonHeight: EditText
    private lateinit var editTextPersonWeight: EditText
    private lateinit var editTextPersonAge: EditText

    private lateinit var spinnerActionLevel: Spinner

    private lateinit var radioButtonMale: RadioButton
    private lateinit var radioButtonFemale: RadioButton

    private lateinit var textViewCalorie: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View =  inflater.inflate(R.layout.fragment_losing, container, false)

        editTextPersonHeight = view.editTextPersonHeight
        editTextPersonWeight = view.editTextPersonWeight
        editTextPersonAge = view.editTextPersonAge

        spinnerActionLevel = view.spinnerActionLevel

        radioButtonMale = view.radioButtonMale
        radioButtonFemale = view.radioButtonFemale

        textViewCalorie = view.textViewCalorie


        view.buttonCalculate.setOnClickListener {
            textViewCalorie.text = getCalculatedCalorie()
        }

        return view
    }

    private fun getCalculatedCalorie(): String {
        // константы для расчета BMR по формуле Харриса – Бенедикта
        val constMale = arrayOf(66.5, 13.75, 5.003, 6.755)
        val constFemale = arrayOf(655.1, 9.563, 1.85, 4.676)

        val height = editTextPersonHeight.text.toString().toInt()
        val weight = editTextPersonWeight.text.toString().toInt()
        val age = editTextPersonAge.text.toString().toInt()

        var pal = 0.0 // уровень активности человека
        when (spinnerActionLevel.selectedItemId.toInt()) {
            0 -> pal = 1.2
            1 -> pal = 1.375
            2 -> pal = 1.7
        }

        var calorie = 0.0 // суточная норма калорий
        // считаю по формуле Харриса – Бенедикта BMR и затем умножаю BMR на PAL
        when {
            radioButtonMale.isChecked -> {
                calorie = (constMale[0] + (constMale[1] * weight) + (constMale[2] * height) - (constMale[3] * age)) * pal
            }
            radioButtonFemale.isChecked -> {
                calorie = (constFemale[0] + (constFemale[1] * weight) + (constFemale[2] * height) - (constFemale[3] * age)) * pal
            }
        }

        return (calorie.toInt() - Random.nextInt(200, 250)).toString()
    }
}
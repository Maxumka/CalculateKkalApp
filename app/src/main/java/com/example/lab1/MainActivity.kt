package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculatedCalorie(view: View) {
        // константы для расчета BMR по формуле Харриса – Бенедикта
        val constMale = arrayOf(66.5, 13.75, 5.003, 6.755)
        val constFemale = arrayOf(655.1, 9.563, 1.85, 4.676)

        val height = editTextTextPersonHeight.text.toString().toInt()
        val weight = editTextTextPersonWeight.text.toString().toInt()
        val age = editTextTextPersonAge.text.toString().toInt()
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
            else -> {
                val errorGenderToast = Toast.makeText(this, "выберите пол", Toast.LENGTH_SHORT)
                errorGenderToast.setGravity(Gravity.CENTER, 0, 0)
                errorGenderToast.show()
            }
        }

        textView2.text = calorie.toInt().toString()
    }
}
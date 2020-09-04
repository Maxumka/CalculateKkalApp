package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val stateString: String = "stateString" // ключ для сохранения переменной нормы калорий
    }

    private var mCalorie: String? = null // поле для хранения нормы калорий

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCalorie = textView2.text.toString()

        buttonCalculate.setOnClickListener {
            if (validation()) {
                mCalorie = getCalculatedCalorie()
                textView2.text = mCalorie
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { // метод для сохранения нормы калорий при уничтожени активности
        super.onSaveInstanceState(outState)
        mCalorie = textView2.text.toString()
        outState?.putString(stateString, mCalorie)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // метод для восстановления нормы калорий при уничтожени активности
        super.onRestoreInstanceState(savedInstanceState)
        mCalorie = savedInstanceState.getString(stateString)
        textView2.text = mCalorie
    }

    // метод отвечает за валидацию входных данных
    private fun validation(): Boolean {
        return when {
            // валидация поля роста
            editTextTextPersonHeight.text.toString().isEmpty() -> {
                editTextTextPersonHeight.error = "Рост не может быть пустым"
                false
            }
            editTextTextPersonHeight.text.toString().toInt() !in 130..210 -> {
                editTextTextPersonHeight.error = "Рост может быть в пределах от 130 до 210"
                false
            }

            // валидация поля веса
            editTextTextPersonWeight.text.toString().isEmpty() -> {
                editTextTextPersonWeight.error = "Вес не может быть пустым"
                false
            }
            editTextTextPersonWeight.text.toString().toInt() !in 30..200 -> {
                editTextTextPersonWeight.error = "Вес может быть в перелах от 30 до 200"
                false
            }

            // валидация поля возраста
            editTextTextPersonAge.text.toString().isEmpty() -> {
                editTextTextPersonAge.error = "Возраст не может быть пустым"
                false
            }
            editTextTextPersonAge.text.toString().toInt() !in 1..100 -> {
                editTextTextPersonAge.error = "Возраст может быть в пределах от 1 до 100"
                false
            }

            !radioButtonMale.isChecked and !radioButtonFemale.isChecked -> {
                createCustomToast("Выберите пол", Toast.LENGTH_SHORT, Gravity.CENTER, 0,0)
                false
            }

            else -> true
        }
    }

    private fun getCalculatedCalorie(): String {
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
        }

        return calorie.toInt().toString()
    }

    // Создание кастомного Toast
    private fun createCustomToast(text: String, toastLength: Int, gravity: Int, xOffset: Int, yOffset: Int) {
        val customToast = Toast.makeText(this, text, toastLength)
        customToast.setGravity(gravity, xOffset, yOffset)
        customToast.show()
    }
}

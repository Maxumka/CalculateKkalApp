package com.example.lab1.model.blogic

import androidx.lifecycle.LiveData
import kotlin.random.Random

class CalculatedCalorieBLogic {

    fun calculatedCalorie(_height: LiveData<String>, _weight: LiveData<String>, _age: LiveData<String>, _isLowLevel: LiveData<Boolean>,
    _isMidLevel: LiveData<Boolean>, _isHardLevel: LiveData<Boolean>,_isMale: LiveData<Boolean>, _isFemale: LiveData<Boolean>, _type: Int): String {

        val constMale = arrayOf(66.5, 13.75, 5.003, 6.755)
        val constFemale = arrayOf(655.1, 9.563, 1.85, 4.676)

        val height = _height.value?.toInt()
        val weight = _weight.value?.toInt()
        val age = _age.value?.toInt()

        var pal = 0.0
        when {
            _isLowLevel.value ?: false -> pal = 1.2
            _isMidLevel.value ?: false -> pal = 1.375
            _isHardLevel.value ?: false -> pal = 1.7
        }

        var calorie = 0.0
        when {
            _isMale.value ?: false -> {
                calorie = (constMale[0] + (constMale[1] * weight!!) + (constMale[2] * height!!) - (constMale[3] * age!!)) * pal
            }
            _isFemale.value ?: false -> {
                calorie = (constFemale[0] + (constFemale[1] * weight!!) + (constFemale[2] * height!!) - (constFemale[3] * age!!)) * pal
            }
        }

        calorie = when(_type) {
            0 -> (calorie - Random.nextInt(200, 250))
            1 -> calorie
            2 -> (calorie + Random.nextInt(200, 250))
            else -> 0.0
        }

        return calorie.toInt().toString()
    }
}
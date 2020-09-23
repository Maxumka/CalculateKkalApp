package com.example.lab1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lab1.model.blogic.CalculatedCalorieBLogic
import com.example.lab1.model.blogic.DatabaseBLogic

class FragmentLosingViewModel(val app: Application) : AndroidViewModel(app) {

    private val context = getApplication<Application>().applicationContext

    private var _personHeight = MutableLiveData<String>()
    val mPersonHeight: MutableLiveData<String> = _personHeight

    private var _personWeight = MutableLiveData<String>()
    val mPersonWeight: MutableLiveData<String> = _personWeight

    private var _personAge = MutableLiveData<String>()
    val mPersonAge: MutableLiveData<String> = _personAge

    private var _isLowLevel = MutableLiveData<Boolean>()
    val mIsLowLevel: MutableLiveData<Boolean> = _isLowLevel

    private var _isMidLevel = MutableLiveData<Boolean>()
    val mIsMidLevel: MutableLiveData<Boolean> = _isMidLevel

    private var _isHardLevel = MutableLiveData<Boolean>()
    val mIsHardLevel: MutableLiveData<Boolean> = _isHardLevel

    private var _isMale = MutableLiveData<Boolean>()
    val mIsMale: MutableLiveData<Boolean> = _isMale

    private var _isFemale = MutableLiveData<Boolean>()
    val mIsFemale: MutableLiveData<Boolean> = _isFemale

    val mCalorie = MutableLiveData<String>()

    private val mCalculatedCalorieBLogic = CalculatedCalorieBLogic()

    private val mType = 0

    fun calculatedCalorie() {
        mCalorie.value = mCalculatedCalorieBLogic.calculatedCalorie(mPersonHeight, mPersonWeight, mPersonAge, mIsLowLevel,
            mIsMidLevel, mIsHardLevel, mIsMale, mIsFemale, mType)

        DatabaseBLogic().addHistoryRecordToDatabase(context, mCalorie.value!!, "Losing")
    }
}
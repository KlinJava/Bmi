package com.hank.bmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel:ViewModel() {
    var result:Float = 0f
    val resultView = MutableLiveData<Float>()

    fun calculate(num:BmiWH) {
        result = num.weight / (num.height * num.height)
        resultView.value = result
    }
}

data class BmiWH(val weight:Float, val height:Float)
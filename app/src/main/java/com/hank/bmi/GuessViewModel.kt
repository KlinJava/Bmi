package com.hank.bmi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel方法練習，監控 counter的變化
class GuessViewModel:ViewModel() {
    var secret = (1..10).random()
    var secretData = MutableLiveData<Int>() //LiveData，有監視的功能)
    val counter3 = MutableLiveData<Int>() //LiveData，有監視的功能
    var status = MutableLiveData<GameStatus>() //LiveData，有監視的功能

    //建構子產矩時候，自動執行的方法
    init {
        counter3.value = 0 //初始化給0，避免發生 null值
        status.value = GameStatus.INIT
        secretData.value = secret
    }

    fun guess(num : Int) {
        status.value = when (num - secret) {
            in 1..Int.MAX_VALUE -> GameStatus.SMALLER
            0 -> GameStatus.NUMBER_RIGHT
            else -> GameStatus.BIGGER
        }
        var c = counter3.value ?: 0
        c++
        counter3.value = c
    }

    fun reset(){
        secret = (1..10).random()
        counter3.value = 0
        status.value = GameStatus.INIT
        secretData.value = secret
    }
}

enum class GameStatus { //參數「全部」用大寫
    INIT,BIGGER,SMALLER,NUMBER_RIGHT
}
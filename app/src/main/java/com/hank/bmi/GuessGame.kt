package com.hank.bmi

import kotlin.random.Random

class GuessGame {
    var secret = Random.nextInt(1,11) // 1,11 => 即 1-10的值
    var counter = 0 // var counter:Int = 0
    fun guess(n:Int) : Int { //第2個 Int，代表這個方法有「回傳值」，「無回傳值」則不用寫
        counter++
        return secret -n
    }
    fun reset() {
        secret = Random.nextInt(1,11)
        counter = 0
    }
}

fun main() {
    val game = GuessGame() //等於 java的 new物件功能
    val num =3
    val result = game.guess(num)

}
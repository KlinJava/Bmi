package com.hank.bmi

import java.util.Scanner
import kotlin.random.Random

fun main() {
    //猜數字的小遊戲

// java輸入數值的方式
/*val scanner = Scanner(System.`in`)
println(scanner.nextInt())*/

//    randomMethod()

    // Kotlin 輸入數值的方式
    val secret = (1..10).random()
    println("secret: $secret")
    var num:Int = 0
    guessForLoop(num, secret)
//    guessWhileLoop(num, secret)

}

//使用 For Loop猜數字，有次數限制
private fun guessForLoop(num: Int, secret: Int) {
    var num1 = num
    var bingo = false
    for (i in 1..3) {
        print("please enter a number: ")
        val input = readLine() //readLine()若沒輸入字串，按下 enter後會送出「空字串」，不是 null
        num1 = input?.toIntOrNull() ?: 0 // ?:貓王符號
        println("The number you entered: $num1")
//    println("The number length: ${input?.length}")
        //方法2，when語法
        val message = when {
            num1 < secret -> "Bigger"
            num1 > secret -> "Smaller"
            else -> {
                bingo = true
                "You got it!"
            }
        }
        println(message)
        if (bingo) break

        //方法1，if..else
        /*if (num1 < secret) {
            println("Bigger")
        } else if (num1 > secret) {
            println("Samller")
        } else {
            println("You got it!")
            bingo = true
            break
        }*/
    }
    if (!bingo) println("Failed, the secret number is $secret")
}

//使用 While Loop猜數字，直到猜對
private fun guessWhileLoop(num: Int, secret: Int) {
    var num1 = num
    while (num1 != secret) { // != 表示不等於(Not)
        print("please enter a number: ")
        val input = readLine() //readLine()若沒輸入字串，按下 enter後會送出「空字串」，不是 null
        num1 = input?.toIntOrNull() ?: 0 // ?:貓王符號
        println("The number you entered: $num1")
//    println("The number length: ${input?.length}")
        if (num1 < secret) {
            println("Bigger")
        } else if (num1 > secret) {
            println("Samller")
        } else {
            println("You got it!")
        }
    }
}

//亂數產生 3種方法
private fun randomMethod() {
    //亂數產生，方法 1
    println("亂數產生，方法1: ${Random.nextInt(1,11)}") //這是Kotlin的Random類別，until:11，表示產生 1-10的亂數
    //亂數產生，方法 2
    println("亂數產生，方法2: ${(1..10).random()}")
    //亂數產生，方法 3，使用 java類別
    val random = java.util.Random()
    println("亂數產生，方法3: ${random.nextInt(10)+1}") // bound:10產生0-9值，加1變成 1-10值
}
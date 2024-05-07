package com.hank.bmi.vending

import java.io.File

fun main() {
    val drinks = mutableListOf<Drink>()
    val input = File("order.txt").bufferedReader()
    var line = input.readLine()
    while (line != null) {
        println(line) //Black tea,0,50
        val tokens = line.split(",") //分割字串，使用逗號為分隔點
        try {
            val drink = Drink(tokens[0], tokens[1].toInt(), tokens[2].toInt()) //產生 drink物件
            drinks.add(drink) //寫入 drinks物件集合
        } catch (e:IndexOutOfBoundsException) {
            println("Invalid Line data format!!")
        }
        line = input.readLine() //讀下一行
    }
    println(drinks) //印出全部飲料物件
}
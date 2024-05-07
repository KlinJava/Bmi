package com.hank.bmi.vending

import java.net.URL

fun main() {
    /*
    https://api.jsonserve.com/AXh1ox，老師的網址有問題
    https://api.jsonserve.com/mJQIaX，自已做的OK
    URL()物件，只是定義網站的網址，openStream()連到網站+取資料流，openConnection()先聯繫再取得輸出入資料流
    openStream一次做完 openConnection+讀資料流的動作
     */

//    readTextJSON()
    bufferedReaderJSON()


}

//使用 readText()，一次全部讀回
private fun readTextJSON() {
    val input = URL("https://api.jsonserve.com/mJQIaX").readText() //全部讀回
    println(input)
}

//使用 bufferedReader，一行一行讀回
private fun bufferedReaderJSON() {
    val input = URL("https://api.jsonserve.com/mJQIaX").openStream()
    val reader = input.bufferedReader()
    var line = reader.readLine()
    while (line != null) {
        println(line)
        line = reader.readLine()
    }
}
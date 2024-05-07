package com.hank.bmi.vending

import java.io.File

fun main() {
    val drinks = listOf<Drink>(
        Drink("Black tea",0,50),
        Drink("Green tea",5,45),
        Drink("Wuloon tea",0,60)
    )
    bufferedWriter(drinks)
//    printWeriter(drinks)
}

//bufferedWriter 輸出資料，方法 2
private fun bufferedWriter(drinks: List<Drink>) {
    val out = File("order.txt").bufferedWriter() // bufferedWriter比較有效率，多了緩衝區
    for (d in drinks) {
        out.write("${d.name},${d.suger},${d.price}\n") //write()方法沒有跳行，要加 \n
    }
    out.flush()
}

//printWriter 輸出資料，方法 1
private fun printWeriter(drinks: List<Drink>) {
    val out = File("order.txt").printWriter() //開啟檔案
    for (d in drinks) {
        out.println("${d.name},${d.suger},${d.price}") //資料輸出緩衝區，未輸出資料
    }
    out.flush() //輸出資料至檔案中
}
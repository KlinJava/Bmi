package com.hank.bmi

import kotlin.random.Random
/*
第 2 章，作業 1 - 另一版本的猜數字遊戲設計
繳交方式: 請在github上使用"GIST"(如圖)，貼上程式碼後，將Gist小程式的網址貼上繳交。

猜數字遊戲方法:
1) 產生1-10的祕密數字(假設為7)
2) 遊戲提示以祕密數字可能的範圍
一開始是【1到10】，當使用者猜5之後，提示改為【5到10】
再輸入8後，提示改為【5到8】，直到猜對為止。
    Please enter a number(1-10): 5
    Please enter a number(5-10): 8
    Please enter a number(5-8): 7
    You got it!
 */

//第 2 章，作業 1 - 另一版本的猜數字遊戲設計
fun main() {
    val range = 1..10 //數字範圍 1-10
    val secret = range.random() //亂數取出一個數字
    println("secret: $secret") //秘密提示
    var min = range.first //range：最小值
    var max = range.last //range：最大值
    var count = 0 //猜的次數
    var input = 0 //初始輸入值
    while(input != secret) {
        print("Please enter a number($min-$max):")
        input = readLine()?.toIntOrNull() ?: 0 //如輸入是 null，則給 0
        if (input < secret) {
            min = input //取代最小值
            count++
        } else if (input > secret) {
            max = input //取代最大值
            count++
        } else {
            count++
            println("Guess count:$count\nYou got it!")
            break //答對，中斷 while loop
        }
    }
}


package com.hank.bmi

class Hello {
}

fun main() {
    println("Hello kotlin!")
    //Byte(8), Short(16), Int(32), Long(64)
    val age = 20 // val 為「不可變」變數，資料給定後就不可改變
    println("age+1: ${age.inc()}") //數值+1，但「age原始值」不會改變
    println("age: $age") //age原始值

    val name = "Hank" // val 為「不可變」變數，資料給定後就不可改變
    println("\n判斷是否字串「相同」: ${name.equals("Hank")}") //判斷是否字串「相同」
    println("字串第1個字: ${name.get(0)}")
    println("字串第2個字: ${name.get(1)}")
    println("附加字串變為: ${name.plus("123")}") //附加字串上去，變為 Hank123
    var name2 = "Tom" // var 為「可變」變數，資料給定後「可改變」
    name2 = "John"
    println("\nname2改變後為: $name2")

    //Float(32), Double(64)
    //true,false
    //Char

}
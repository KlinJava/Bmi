package com.hank.bmi

import com.hank.bmi.student.Student

class Hello {

}

fun main() {
    val p = Person("Jack",65.5f,1.7f)
    println("Bmi: ${p.bmi()}") // 如同 println("Bmi: " + p.bmi())
    val hank = Person("Hank",70f,1.75f)
    println(p.name + " " + p.bmi())
    println(hank.name + " " + hank.bmi())
    val idTest = Person("JIM",50f,1.77f,"33")
    idTest.idPrint()
    p.Hello()

//    BmiTest1()
//    primitiveTest()

}

//Bmi：寫在 Main方法裡面
private fun BmiTest1() {
    val p = Person("Tom",65.5f,1.7f)
    p.Hello()
    val w = 65.5f
    val h = 1.7f
    val bmi = w / (h * h)
    println("BMI: " + bmi)
}

//基本資料型態練習
private fun primitiveTest() {
    println("Hello kotlin!")
    //Byte(8), Short(16), Int(32), Long(64)
    val age = 20 // val 為「不可變」變數，資料給定後就不可改變
//    val age:Int = 20
    val population: Long = 9999 //未來人口數會破億，故用 Long 64bit較大，也可寫成 val population = 9999L
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
    val weight: Float = 65.5f
    //true,false
    val isAdult = false
    //Char
    val c = 'A'
    println(c)

}
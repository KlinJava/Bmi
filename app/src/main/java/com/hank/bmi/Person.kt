package com.hank.bmi

// Person 後面的 constructor字，可「省略」
class Person (val name:String, var weight:Float, var height:Float) {
    var id:String? = null
    //次要建構子
    constructor(name:String, weight:Float, height:Float, id:String ):this(name,weight,height){
        this.id = id
    }
    fun idPrint(){
        println("id: $id")
    }

    fun bmi():Float {
        val bmi = weight/(height*height) //bmi = 區域變數
        return bmi
    }
    fun Hello(){
        println("Hello")
    }
}
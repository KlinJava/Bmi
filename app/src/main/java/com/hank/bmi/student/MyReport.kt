package com.hank.bmi.student

//抽象方法練習

abstract class MyReport {
    abstract fun load() //interface 規範方法
    fun pprint() { //實作方法
        println("Abstract class Printing ")
    }
    fun init(){
        println("Init Abstract")

    }
}
package com.hank.bmi.student

interface Report {
    fun load() //不用加大括號 {..}，也不用實作程式內容
    fun print(title:String)

}
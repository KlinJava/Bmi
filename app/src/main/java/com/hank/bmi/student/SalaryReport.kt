package com.hank.bmi.student

class SalaryReport:MyReport(){
    override fun load() {
//        TODO("Not yet implemented")
        println("Loading abstract class")
        init()
        pprint()
    }
}

fun main() {
    val tes = SalaryReport()
    tes.pprint()
    tes.init()
    tes.load()
}
package com.hank.bmi.student

class FinanceReport:Report{ //繼承 Rpoert interface，故一定要「覆寫及實作」 load()及 print()
    override fun load() {
//        TODO("Not yet implemented")
        println("Loading Finance report..")
    }

    override fun print(title: String) {
//        TODO("Not yet implemented")
        println("Printing Finance report..")
    }
}
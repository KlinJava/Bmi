package com.hank.bmi.student

fun main() {
    val reports = listOf<Report>(
        FinanceReport(),
        HealthReport(),
        //匿名類別：不想建立新的類別檔，直接用匿名繼承 Report介面
        object : Report {
            override fun load() {
                println("EX Report")
            }

            override fun print(title: String) {
                println("Printing anonymous")
            }
        }
    )
    for (report in reports) {
        report.load()
        report.print("Test")
    }
}
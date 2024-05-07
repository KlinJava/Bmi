package com.hank.bmi.student

/*
學生有學號、姓名、英文、數學成績
印出學生資料
印出學生成績
印出學生等級(A,B,C,D,F)
*/

class Student(val id:String, val name:String, var english:Int, var math:Int) {  //Student 後面省略的 Constructor
//class Student Constructor(val id:String, val name:String, var english:Int, var math:Int)

    //類似 java 的  static功能
    companion object {
        var test1 = 0
        var test2 = "ABC"
        var pass = 60
    }

    //第2個建構子，它可以使用「主建構子」的方式，將變數授與「初始值」，即可達到相同效果
    // 如 class Student(val id:String, val name:String, var english:Int = 0, var math:Int = 0)
    constructor(id:String, name:String):this(id,name,0,0)
    fun print(){
        val mark = if (average() < pass) "*" else ""
        println("$id\t$name\t$english\t$math\t${average()}$mark\t${grading()}")
    }
    fun average() = (english + math)/2

    fun grading() = when(average()/10) {
            9,10 -> "A"
            8 -> "B"
            7 -> "C"
            6 -> "D"
            else -> "F"
        }
}

fun main() {
    Student.pass = 50

    //使用 list方式
    val students = listOf<Student>(
        Student("001","jack",95,99),
        Student("002","Hank",66,87),
        Student("003","Jane")
    )
    //for，由 list決定長度
    for (stu in students) {
        stu.print()
    }

    println()
    //for，自已設定範圍
    for (i in 0..2) {
        students.get(i).print()
    }
    println()
    val stu1 = Student("001","jack",95,99)
    val stu2 = Student("002","Hank",66,87)
    val stu3 = Student("003","Jane")
    stu1.print()
    stu2.print()
    stu3.print()
    println()


}
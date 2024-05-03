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
    }

    //第2個建構子
    constructor(id:String, name:String):this(id,name,0,0)
    fun print(){
        println("$id\t$name\t$english\t$math")
    }
}

fun main() {
    val stu1 = Student("001","jack",70,80)
    val stu2 = Student("002","Hank",66,87)
    val stu3 = Student("003","Jane")
    stu1.print()
    stu2.print()
    stu3.print()

}
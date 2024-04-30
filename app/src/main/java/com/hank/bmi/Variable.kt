package com.hank.bmi

fun main() {
    //產生 2個亂數，且「不會」重覆
    val nums = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10)
    println("原nums: $nums")
    nums.shuffle() //打亂
    println("打亂nums: $nums")
    val secret = nums.removeAt(0) //秘密數字，list長度10，移除打亂後 index0，並將 index0存入 secret
    println("移除index0: $nums")
    println("secret: $secret")
    val bomb = nums.removeAt(0) //地雷，承上，list長度9，移除打亂後 index0，並將 index0存入 bomb
    println("移除index0: $nums")
    println("bomb: $bomb")

//    listTest()
//    forLoopArray()
//    stringTest()
//    numberCheck()
}

//List練習
private fun listTest() {
    /* List：產生後
       Immutable：不能改變內容 listOf()
       Mutable：可改變內容  mu
     */
    val list: List<Int> = listOf<Int>(2, 5, 8) //Immutable list
    val list2 = mutableListOf<Int>(22, 55, 88) //Mutable list
    println(list)
    println("原 list: $list2")
    list2.add(6)
    println("新增6後List: $list2") // 22,55,88,6
    list2.removeAt(1)
    println("刪除index1=55後List: $list2") //22,88,6
    list2.replaceAll {
        it * 2
    }
    println("list全部*2: $list2") //44,176,12
}

//For迴圈+陣列Array 練習
private fun forLoopArray() {
    var array = intArrayOf(2, 5, 8)
    println("取數字index1: ${array[1]}") //取 index=1 的資料，為 5
    var ss = arrayOf("SUN", "MON", "TUE")
    println("取文字index0 : ${ss.get(0)}")
    println("取文字index1 : ${ss[1]}")
    for (day in ss) println(day) //只有一行，省略大括號 {..}

    val range = 0..10
    //列印星號，使用空隔隔開
    for (i in 1..30) {
        if (i % 2 == 1) {
            print("*")
        } else {
            print(" ")
        }
    }
    println()

    //方法 1：跳字輸出，如 1,3,5,7,9
    for (i in 1..10 step 2) { //步距 2
        print(i)
    }
    println()

    //方法 2：跳字輸出，如 1,3,5,7,9，因只有一行，不用寫大括號，if判斷式也是一樣
    for (i in 1..10 step 2) print(i)
}

//字串練習
private fun stringTest() {
    var name: String? = "Hank"
//    var name:String? = null
    println("長度: ${name?.length}")
    println("取第2個字: ${name?.get(1)}")
    println(name ?: 0) // ?: 貓王符號，左邊不是 null，給 Hank；左邊是 null，給 0
}

//數值運算、判斷
private fun numberCheck() {
    //數值運算，做一個計數器
    var counter: Int = 0
    counter = counter + 1 //等於 counter = counter + 1
    counter++
    counter-- //等於 counter = counter - 1
    println(counter)
    println("10/3取餘數: " + (10 % 3))
    println("10/3，還是整數: " + (10 / 3)) //因為 int/int 還是 int，去除小數
    println("10/3.0，會以最大型態顯示，即Double:" + (10 / 3.0))

    //布林值， boolean
    var b = false
    var a = true
    println("b = $b 的反向: ${!b}")
    println("a && b: " + (a && b)) //And (且)，2者皆真為真
    println("a && b: ${a && b}") //And (且)，2者皆真為真
    println("a || b: " + (a || b)) //Or (或)，2者其一為真即真
    println("a || b: ${a || b}") //Or (或)，2者其一為真即真
    //
    val num = 1
    println(num <= 5 && num >= -3)
    //
    println(num > 5)
    //
    println(num > 5 || num < -3)
}
package com.hank.bmi

fun main() {

    //Set集合：無索引值 index、不可重複資料，沒有順序
    val set = setOf(5,3,9,3,2,1,9) //會自動把重複的資料剔除，剩 5,3,9,2,1
    println(set)
    set.forEach { //可將 it改名，語法： 名稱 ->
        println(it)
    }
    //it 改名為 num
    set.forEach {num ->
        println(num)
    }

    //List集合：有索引值 index、可重複資料、有順序
    val list = listOf<Int>(5,3,8,5,3,2,1) //list內容是可「重覆」
    println(list)

    //Club(梅花),Diamond(方塊),紅心(Heart),Spade(黑桃)
    val deck = mutableListOf<Int>()
    for (i in 0 until 52) { //語法同 0..<52
        deck.add(i)
        if (i%13 == 0 && i!=0) println() // i=0不跳行，13張換一行
        val a = i/13 //取商，判斷花色
        //when方法
        var type = when(a) {
            0 -> "♧ "  //"C"
            1 -> "♦" //"D"
            2 -> "♡" //"H"
            else -> "♠" //"S"
        }
        print("${(i%13)+1}$type ")

//        ifElse(a)
//        ifElse2(a)
    }
    println()
    println(deck)
    /*
    打亂的方法，只有 mutable list才能用
    shuffle()，打亂原本的 list，list 內容位置(index)會被改變
    shuffled()，打亂原本的 list，產生一份新的 list，不會影響原本的 list
     */
    val deck2 = deck.shuffled()
    println(deck)
    println(deck2)

}

//if..else方法 2，此時 if..else是表達示 Expression
private fun ifElse2(a: Int) {
    var type = if (a == 0) {
        "C"
    } else if (a == 1) {
        "D"
    } else if (a == 2) {
        "H"
    } else "S"
}

//if..else方法 1
private fun ifElse(a: Int) {
    var type = "S"
    if (a == 0) {
        type = "C"
    } else if (a == 1) {
        type = "D"
    } else if (a == 2) {
        type = "H"
    }
}
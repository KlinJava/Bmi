package com.hank.bmi

fun main() {
    //飲料販賣機，綀習
    /*
    Map集合<key,value>：key不能重複，value可重複
    mapOf：僅讀取
    mutableMapOf：可新增、修改、刪除
     */
     val drinks = mutableMapOf<Int,String>(
        1 to "Coke", //真正語法是一對 Pair(1,"Coke")
        2 to "7-up",
        3 to "Wulong",
        4 to "Orange"
    )
    println(drinks)
    println("選第3種飲料: ${drinks.get(3)}")
    drinks.put(5,"Water")
    println(drinks)

}
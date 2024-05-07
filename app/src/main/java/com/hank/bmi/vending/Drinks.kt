package com.hank.bmi.vending

fun Drink.off20():Drink{
    return this.copy(price = (this.price *0.8).toInt())
}

fun main() {
    val s = "abcdef"
    println("字串長度大於等6: ${s.validate()}")
    val tea = Drink("Black tea",0,50)
    println("印出這杯茶的資訊: $tea")
    val discountTea = tea.off20()
    println("20% off後的費用: $discountTea")
    val tea2 = tea.copy(suger = 5) //透過物件 tea產生新的物件 tea2，這是 data class的功能之一
    println(tea2)

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

fun String.validate():Boolean{
    return this.length >= 6

}
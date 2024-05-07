package com.hank.bmi.vending
//一般類別，需繼承，透過覆寫，才能印出
/*class Drink(val name:String, val suger:Int, val price:Int) {
    override fun toString(): String {
        return "$name $suger $price"
    }*/

//具有一些基礎的功能
data class Drink(val name:String, val suger:Int, val price:Int) {

}
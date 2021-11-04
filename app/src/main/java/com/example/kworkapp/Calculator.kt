package com.example.app

object Calculator {


    var numbersList: List<Int> = getRandomList()

    fun getRandomList(): List<Int> {
        val list = arrayListOf<Int>()
        for (i in 0 until 10) {
            list.add((0..99).random())
        }
        return list
    }


    fun calculateAverageEvenListItemsInUnevenPosition(): Float {

        var sum = 0
        var count = 0

        (numbersList.indices step 2)
            .map(numbersList::get)
            .forEach { item ->
                if (item % 2 == 0) {
                    count++
                    sum += item
                }
            }

        if (count == 0) return 0f
        return sum / count.toFloat()
    }
}
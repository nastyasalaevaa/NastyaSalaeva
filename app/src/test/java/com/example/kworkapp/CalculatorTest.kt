package com.example.kworkapp

import org.junit.Assert
import org.junit.Test

class CalculatorTest {

    @Test
    fun `get random int list with size 20`() {
        val numbersList = Calculator.getRandomList()
        Assert.assertEquals(20, numbersList.size)

    }

    @Test
    fun `simple calculate test`() {
        Calculator.numbersList = arrayListOf(10, 13, 22, 34, 47, 57, 66, 78, 84, 95, 110) //58.4
        val result = Calculator.calculateAverageEvenListItemsInUnevenPosition()
        Assert.assertEquals(58.4f, result)


    }

    @Test
    fun `calculate test when sum even items is zero`() {
        Calculator.numbersList = arrayListOf(0, 13, 223, 34, 477) //0
        val result = Calculator.calculateAverageEvenListItemsInUnevenPosition()
        Assert.assertEquals(0f, result)
    }

    @Test
    fun `calculate test when not have even items`() {
        Calculator.numbersList = arrayListOf(123, 13, 223, 34, 477) //0
        val result = Calculator.calculateAverageEvenListItemsInUnevenPosition()
        Assert.assertEquals(0f, result)
    }

    @Test
    fun `calculate test when list is empty`() {
        Calculator.numbersList = emptyList()
        val result = Calculator.calculateAverageEvenListItemsInUnevenPosition()
        Assert.assertEquals(0f, result)
    }

}
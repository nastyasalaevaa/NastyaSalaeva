package com.example.kworkapp

import org.junit.Assert
import org.junit.Test

class StringFormatToListTest {


    @Test
    fun `testing method`() {

        val string = "10,5,.14..,54,18,--4 54"//10,5,14,54,18,4,54
        val result = string.joinToList()


        Assert.assertEquals(7, result.size)
        Assert.assertEquals(10, result[0])
        Assert.assertEquals(5, result[1])
        Assert.assertEquals(54, result[6])
    }
}
package com.example.kworkapp

import androidx.annotation.DimenRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.sp

@Composable
@ReadOnlyComposable
fun fontDimensionResource(@DimenRes id: Int) = dimensionResource(id = id).value.sp

fun String.joinToList(): List<Int> {
    if (this.isEmpty()) return emptyList()
    val form = this.replace(Regex("\\D+"), ",")
    return form.split(",").map { it.toInt() }
}
package com.example.prelim

import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class ViewActivityModel: ViewModel() {
    public var weight2: Double = 0.00
    public var weight3: Double = 0.00
    public var unitTxt: String = ""
    public var unitTxt2: String = ""


    fun computeWeight(weight1: Double, invert: Boolean): String {

        var weight2 = weight1 * 2.205
        unitTxt = "kgs"
        unitTxt2 = "lbs"

        if (invert) {
            var weight3 = weight1 / 2.205
            unitTxt = "lbs"
            unitTxt2 = "kgs"
            return NumberFormat.getNumberInstance().format(weight3)
        }
        return NumberFormat.getNumberInstance().format(weight2)
    }
}

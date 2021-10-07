package org.suggs.codewars.kata

import java.lang.Math.PI
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.tan

object TankTruck {

    fun tankVol(height: Int, diameter: Int, totalVolume: Int): Int {
        return when (height) {
            0 -> 0
            diameter -> totalVolume
            else -> calculateVolumeOfLiquidInTank(height.toDouble(), diameter.toDouble() / 2, totalVolume).toInt()
        }
    }

    private fun calculateVolumeOfLiquidInTank(height: Double, radius: Double, totalVolume: Int): Double {
        return areaOfLiquid(height, radius) / areaOfCircle(radius) * totalVolume
    }

    private fun areaOfLiquid(height: Double, radius: Double): Double {
        val diffRadiusAndHeight = radius - height
        val angleInRadians = acos(diffRadiusAndHeight / radius)
        return areaOfSegment(radius, angleInRadians) - areaOfTriangle(angleInRadians, diffRadiusAndHeight)
    }

    private fun areaOfSegment(radius: Double, angleInRadians: Double): Double {
        return radius.pow(2) * angleInRadians
    }

    private fun areaOfTriangle(angleInRadians: Double, diffRadiusAndHeight: Double): Double {
        return tan(angleInRadians) * diffRadiusAndHeight * diffRadiusAndHeight
    }

    fun createAngleFrom(height: Double, radius: Double): Double {
        return 2 * acos((radius - height) / radius)
    }

    private fun areaOfCircle(radius: Double) = PI * radius.pow(2)
}
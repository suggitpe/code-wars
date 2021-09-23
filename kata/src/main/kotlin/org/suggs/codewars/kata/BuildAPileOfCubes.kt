package org.suggs.codewars.kata

object BuildAPileOfCubes {
    fun findNb(cubes: Long): Long {
        return findNb(cubes, 1)
    }

    fun findNb(remainingCubes: Long, level: Long): Long {
        val cubeForThisLevel = level * level * level
        return when {
            cubeForThisLevel == remainingCubes -> level
            cubeForThisLevel > remainingCubes -> -1
            else -> findNb(remainingCubes-cubeForThisLevel, level + 1)
        }
    }
}
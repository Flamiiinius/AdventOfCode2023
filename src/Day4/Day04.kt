import java.lang.Math.pow
import kotlin.math.pow

fun main() {
    // test if implementation meets criteria from the description, like:
    val exampleInput1 = readInput("Day4/Day04_1")
    val result1 = Day04(exampleInput1).part1()
    println(result1)

    // test if implementation meets criteria from the description, like:
    val exampleInput2 = readInput("Day4/Day04_2")
    val result2 = Day04(exampleInput2).part2()
    println(result2)

}

class Day04(private val input: List<String>) {

    private val scratchcards = input.map { Card.build(it) }
    fun part1(): Int = scratchcards.sumOf {it.getPoints()}

    fun part2(): Int = scratchcards.sumOf {it.calculateInstances(scratchcards)}



    data class Card(val row: Int, val winningNumbers: List<Int>, var myNumbers: List<Int>,var instance:Int = 1) {
        companion object {
            fun build(row: String): Card {
                val strings: List<String> = row.split(":")
                val rowNumber: Int = strings[0].drop(5).trim().toInt()
                val bingo: List<String> = strings[1].split("|")
                val wins: List<Int> = bingo[0].trim().replace("\\s+".toRegex(), ",").split(",").map {
                    it.trim().toInt()
                }
                val mine: List<Int> = bingo[1].trim().replace("\\s+".toRegex(), ",").split(",").map {
                    it.trim().toInt()
                }
                return Card(rowNumber, wins, mine)
            }
        }

        private fun getNumberOfMatchingNumbers():Int = winningNumbers.intersect(myNumbers.toSet()).size

        fun getPoints(): Int = 2.toDouble().pow((getNumberOfMatchingNumbers()-1).toDouble()).toInt()

        fun calculateInstances(scratchcards:List<Card>):Int {
            for(i in 0 until getNumberOfMatchingNumbers()){
                scratchcards[row+i].instance += instance
            }
            return instance
        }
    }
}

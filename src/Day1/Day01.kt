fun main() {
    // test if implementation meets criteria from the description, like:
    val exampleInput1 = readInput("Day1/Day01_1")
    val result1 = Day01(exampleInput1).part1()
    println(result1)

    val exampleInput2 = readInput("Day1/Day01_2")
    val result2 = Day01(exampleInput2).part2()
    println(result2)
}

class Day01(private val input: List<String>) {

    // maps with words and numbers
    private val numbersInWords: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9,
        "1" to 1,
        "2" to 2,
        "3" to 3,
        "4" to 4,
        "5" to 5,
        "6" to 6,
        "7" to 7,
        "8" to 8,
        "9" to 9,
        "0" to 0
    )
    private val reversedNumbersInWords: Map<String, Int> = numbersInWords.map { it.key.reversed() to it.value }.toMap()

    fun part1(): Int = input.sumOf {
        val numbers: String = it.filter { it.isDigit() }
        // row total
        numbers.first().digitToInt() * 10 + numbers.last().digitToInt()
    }

    fun part2(): Int = input.sumOf {
        val first = getDigit(it, numbersInWords)
        val last = getDigit(it.reversed(), reversedNumbersInWords)
        // row total
        first * 10 + last
    }

    // find the 1st occurrence of a number/word in our row
    private fun getDigit(row: String, map: Map<String, Int>): Int {
        val result: Pair<Int, String> = row.findAnyOf(map.keys)!!
        return map[result.second]!!
    }
}
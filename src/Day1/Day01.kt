fun main() {
    // test if implementation meets criteria from the description, like:
    val exampleInput1 = readInput("Day1/Day01_1")
    val result1 = Day01().part1(exampleInput1)
    println(result1)

    val exampleInput2 = readInput("Day1/Day01_2")
    val result2 = Day01().part2(exampleInput2)
    println(result2)
}

class Day01 {


    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach {
            val number: String = it.filter { it.isDigit() }
            sum += number.first().digitToInt() * 10 + number.last().digitToInt()
        }
        return sum
    }


    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach {
            val first = getElement(it)
            val last = getElementReversed(it.reversed())
            sum += first *10 + last
        }
        return sum
    }


    fun getElement(input: String): Int {
        var indexOfFirst = 99999
        var valueOfFirst = -1
        validSequence.forEach {
            val r: Int = input.indexOf(it.key, 0, true)
            if (r != -1 && r < indexOfFirst) {
                indexOfFirst = r
                valueOfFirst = it.value
            }
        }
        return valueOfFirst
    }
    fun getElementReversed(input: String): Int {
        var indexOfFirst = 99999
        var valueOfFirst = -1
        validSequence.forEach {
            val r: Int = input.indexOf(it.key.reversed(), 0, true)
            if (r != -1 && r < indexOfFirst) {
                indexOfFirst = r
                valueOfFirst = it.value
            }
        }
        return valueOfFirst
    }


    val validSequence: Map<String, Int> = mapOf(
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
}
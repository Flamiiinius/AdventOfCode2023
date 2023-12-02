fun main() {
    // test if implementation meets criteria from the description, like:
    val exampleInput1 = readInput("Day2/Day02_1")
    val result1 = Day02(exampleInput1).part1()
    println(result1)

    // test if implementation meets criteria from the description, like:
    val exampleInput2 = readInput("Day2/Day02_2")
    val result2 = Day02(exampleInput2).part2()
    println(result2)

}

class Day02(private val input: List<String>) {

    fun part1(): Int = input.map { Game.build(it) }.filter { it.isValid() }.sumOf { it.id }

    fun part2(): Int = input.map { Game.build(it) }.sumOf { it.getMinimalSet().calculatePower() }

}

data class Game(val id: Int, var sets: List<GameSet>) {

    companion object {
        fun build(gameString: String): Game {
            val strings: List<String> = gameString.split(":")
            val gameNumber: Int = strings[0].drop(5).toInt()
            val sets =  strings[1].split(";").map { GameSet.build(it) }
            return Game(gameNumber,sets)
        }
    }

    fun isValid() = this.sets.all { it.isValid() }

    fun getMinimalSet(): GameSet = GameSet(
        blues = this.sets.maxBy { it.blues }.blues,
        reds = this.sets.maxBy { it.reds }.reds,
        greens = this.sets.maxBy { it.greens }.greens
    )
}

data class GameSet(var blues: Int, var greens: Int, var reds: Int) {

    companion object {
        fun build(setString: String): GameSet {
            val cubes = setString.split(",".toRegex())
            val gameSet = GameSet(0, 0, 0)
            for (c in cubes) {
                if ("blue" in c) gameSet.blues += c.dropLast(5).trim().toInt()
                else if ("red" in c) gameSet.reds += c.dropLast(4).trim().toInt()
                else gameSet.greens += c.dropLast(6).trim().toInt()
            }
            return gameSet
        }
    }

    fun isValid() = this.blues <= 14 && this.greens <= 13 && this.reds <= 12

    fun calculatePower() = this.blues * this.reds * this.greens
}


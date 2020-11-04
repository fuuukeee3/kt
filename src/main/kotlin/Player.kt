import java.io.File

class Player(
    _name: String,
    var healthPoint: Int = 100,
    val isBlessed: Boolean,
    private val isImmortal: Boolean
) {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown = selectHomeTown()

    init {
        require(healthPoint > 0) { "healthPoint must be greater then zero." }
        require(name.isNotBlank()) { "Player must have a name." }
    }

    constructor(name: String): this(
            name,
            isBlessed = true,
            isImmortal = false) {
        if (name.toLowerCase() == "kar") healthPoint = 40
    }

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoint > 50 || isImmortal
        return if (auraVisible) "Green" else "None"
    }

    fun formatHealthStatus() =
        when (healthPoint) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a fev scratchers."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly!."
            } else {
                "has some minor wounds."
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    private fun selectHomeTown() = File("/Users/takanori/study/2020/kotlin/kt/src/main/kotlin/data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
}

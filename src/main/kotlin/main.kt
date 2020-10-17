fun main(args: Array<String>) {
    val name = "fu"
    var healthPoint = 75
    val isBlessed = true
    val isImmortal = false

    val auraColor = auraColor(isBlessed, healthPoint, isImmortal)

    val healthStatus = formatHealthStatus(healthPoint, isBlessed)

    printPlayerStatus(auraColor = auraColor, isBlessed = isBlessed, name = name, healthStatus = healthStatus)

    castFireball()
}

private fun printPlayerStatus(
        auraColor: String,
        isBlessed: Boolean,
        name: String,
        healthStatus: String) {
    println("(Aura: $auraColor) (Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoint: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    return if (auraVisible) "Green" else "None"
}

private fun formatHealthStatus(healthPoint: Int, isBlessed: Boolean) =
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

private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")


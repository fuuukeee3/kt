fun main(args: Array<String>) {
    val name = "fu"
    var healthPoint = 75
    val isBlessed = true
    val isImmortal = false

    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = if (auraVisible) "Green" else "None"

    val healthStatus = when (healthPoint) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a fev scratchers."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!."
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in avful condition!"
    }

    println("(Aura: $auraColor) (Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

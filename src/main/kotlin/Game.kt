fun main(args: Array<String>) {

    val player = Player("Madrigal", isBlessed = true, isImmortal = false)
    player.castFireball()

    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}


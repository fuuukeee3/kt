open class Room(val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Room: $name \n" +
        "Danger level: $dangerLevel"
    open fun load() = "Nothing much to see here..."
}

open class TownSquare : Room("Town Square") {
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWOWG"

    final override fun load() = "The Villagers rally and cheer as you enter!\n${ringerBell()}"

    private fun ringerBell() = "The bell tower announces your arrival. $bellSound"
}

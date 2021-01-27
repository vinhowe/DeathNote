import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.plugin.java.JavaPlugin
import kotlin.math.roundToInt

class DeathNote : JavaPlugin(), Listener {
    override fun onEnable() {
        super.onEnable()
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onDeathEvent(event: PlayerDeathEvent) {
        val loc = event.entity.location
        event.deathMessage =
            event.deathMessage + " (${loc.x.roundToInt()}, ${loc.y.roundToInt()}, ${loc.z.roundToInt()})"
    }
}
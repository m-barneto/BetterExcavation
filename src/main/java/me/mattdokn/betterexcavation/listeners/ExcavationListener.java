package me.mattdokn.betterexcavation.listeners;

import org.bukkit.Location;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ExcavationListener implements Listener {
    private static class ExcavationBreakBlockEvent extends BlockBreakEvent {
        public ExcavationBreakBlockEvent(@NotNull Block theBlock, @NotNull Player player) {
            super(theBlock, player);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (e instanceof ExcavationBreakBlockEvent) return;

        Block block = e.getBlock();
        Player player = e.getPlayer();
        if (player.isSneaking()) return;

        ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();

        if (!block.getBlockData().getMaterial().hasGravity()) return;

        // Get blocks above and remove them if sand
        Location location = block.getLocation();

    }
}

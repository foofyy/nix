package net.foof.nix.block

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Material

class Bush {
    fun Bush() {
        (AbstractBlock.Settings.of(Material.PLANT).nonOpaque())
    }
}


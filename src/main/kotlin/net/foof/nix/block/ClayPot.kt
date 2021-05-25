package net.foof.nix.block

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Material

class ClayPot(settings: Settings?) : Block(settings) {
    fun ClayPot() {
        (AbstractBlock.Settings.of(Material.STONE).nonOpaque())
    }
}
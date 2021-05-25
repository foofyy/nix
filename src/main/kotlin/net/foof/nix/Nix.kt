package net.foof.nix

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.foof.nix.register.Blocks
import net.foof.nix.register.Blocks.BUSH
import net.foof.nix.register.Blocks.CLAY_POT
import net.foof.nix.register.Blocks.GODSTONE_GRASS
import net.foof.nix.register.Items
import net.minecraft.client.render.RenderLayer
import net.foof.nix.worldgen.Ores
import software.bernie.geckolib3.GeckoLib


val MOD_ID = "nix"
@Suppress("unused")
fun init () {
    Items.register()
    Blocks.register()
    Ores.onInitialize()
    clientInit()
    GeckoLib.initialize();
}
fun clientInit () {
    BlockRenderLayerMap.INSTANCE.putBlock(BUSH, RenderLayer.getCutout())
    BlockRenderLayerMap.INSTANCE.putBlock(GODSTONE_GRASS, RenderLayer.getCutoutMipped())
    BlockRenderLayerMap.INSTANCE.putBlock(CLAY_POT, RenderLayer.getCutout())
}


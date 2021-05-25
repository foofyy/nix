package net.foof.nix.register

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags
import net.foof.nix.MOD_ID
import net.foof.nix.block.ClayPot
import net.minecraft.block.*
import net.minecraft.client.color.world.BiomeColors
import net.minecraft.client.color.world.GrassColors
import net.minecraft.data.client.model.TextureKey.NORTH
import net.minecraft.data.client.model.TextureKey.EAST
import net.minecraft.data.client.model.TextureKey.SOUTH
import net.minecraft.data.client.model.TextureKey.WEST
import net.minecraft.item.ItemPlacementContext
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.Identifier
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.registry.Registry
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

object Blocks {
    val ROCKY_DIRT: Block = Block(FabricBlockSettings.of(Material.SOIL).strength(1.0f).sounds(BlockSoundGroup.GRAVEL).breakByTool(FabricToolTags.SHOVELS))
    val ADAMANTITE_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(10.0f).sounds(BlockSoundGroup.NETHER_GOLD_ORE).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool())
    val BUSH: Block = Block(FabricBlockSettings.of(Material.PLANT).strength(0.1f).sounds(BlockSoundGroup.GRASS).breakByTool(FabricToolTags.HOES).noCollision())
    val CLAY_POT: Block = ClayPot(FabricBlockSettings.of(Material.STONE).strength(1.0f).sounds(BlockSoundGroup.BONE).breakByTool(FabricToolTags.PICKAXES).nonOpaque())
    val ADAMANTITE_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).strength(10.0f).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool())
    val MYTHRIL_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(8.0f).sounds(BlockSoundGroup.GILDED_BLACKSTONE).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool())
    val MYTHRIL_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).strength(8.0f).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool())
    val COBALT_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(6.0f).sounds(BlockSoundGroup.NETHER_BRICKS).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool())
    val COBALT_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).strength(6.0f).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool())
    val TITANIUM_ORE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(10.0f).sounds(BlockSoundGroup.NETHER_GOLD_ORE).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool())
    val TITANIUM_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).strength(10.0f).sounds(BlockSoundGroup.METAL).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool())
    val GODSTONE: Block = Block(FabricBlockSettings.of(Material.STONE).strength(5.0f).sounds(BlockSoundGroup.NETHERRACK).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool())
    val GODSTONE_GRASS: Block = Block(FabricBlockSettings.of(Material.SOIL).strength(5.0f).sounds(BlockSoundGroup.WET_GRASS).breakByTool(FabricToolTags.SHOVELS, 1))
    val OTHERBARK_LOG: Block = PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(4.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 1))
    val OTHERBARK_PLANKS: Block = Block(FabricBlockSettings.of(Material.WOOD).strength(4.0f).sounds(BlockSoundGroup.WOOD).breakByTool(FabricToolTags.AXES, 3))
    val OTHERBARK_PINE_LEAVES: Block = Block(FabricBlockSettings.of(Material.LEAVES).strength(1.0f).sounds(BlockSoundGroup.CROP).breakByTool(FabricToolTags.SHEARS))

    fun register() {
        ColorProviderRegistry.BLOCK.register({ state, world, pos, tintIndex ->
            if (world != null && pos != null) BiomeColors.getGrassColor(
                world,
                pos
            ) else GrassColors.getColor(0.5, 1.0)
        }, GODSTONE_GRASS)
        ColorProviderRegistry.BLOCK.register({ state, world, pos, tintIndex ->
            if (world != null && pos != null) BiomeColors.getFoliageColor(
                world,
                pos
            ) else GrassColors.getColor(0.5, 1.0)
        }, OTHERBARK_PINE_LEAVES)
        ColorProviderRegistry.ITEM.register({ stack, tintIndex -> 0xb8ffc8 }, GODSTONE_GRASS)
        ColorProviderRegistry.ITEM.register({ stack, tintIndex -> 0xb8ffc8 }, OTHERBARK_PINE_LEAVES)

        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "rocky_dirt"), ROCKY_DIRT)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "bush"), BUSH)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "clay_pot"), CLAY_POT)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "adamantite_ore"), ADAMANTITE_ORE)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "adamantite_block"), ADAMANTITE_BLOCK)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "mythril_ore"), MYTHRIL_ORE)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "cobalt_ore"), COBALT_ORE)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "cobalt_block"), COBALT_BLOCK)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "mythril_block"), MYTHRIL_BLOCK)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "titanium_ore"), TITANIUM_ORE)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "titanium_block"), TITANIUM_BLOCK)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "godstone"), GODSTONE)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "godstone_grass"), GODSTONE_GRASS)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "otherbark_planks"), OTHERBARK_PLANKS)
        Registry.register(Registry.BLOCK, Identifier(MOD_ID, "otherbark_log"), OTHERBARK_LOG)
    }
}

package net.foof.nix.register

import net.minecraft.block.*
import net.minecraft.entity.EntityType
import net.minecraft.item.Item
import net.minecraft.item.PickaxeItem
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Rarity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import net.minecraft.world.BlockView


object toolClasses {

    class CustomPickaxeItem(material: ToolMaterial?, attackDamage: Int, attackSpeed: Float, settings: Settings?) :
        PickaxeItem(material, attackDamage, attackSpeed, settings)
    class CustomAxeItem(material: ToolMaterial?, attackDamage: Int, attackSpeed: Float, settings: Settings?) :
        PickaxeItem(material, attackDamage, attackSpeed, settings)
    class CustomHoeItem(material: ToolMaterial?, attackDamage: Int, attackSpeed: Float, settings: Settings?) :
        PickaxeItem(material, attackDamage, attackSpeed, settings)
    class NixSwordItem(material: ToolMaterial?) : SwordItem(material, 2, -2.4f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    class NixPickaxeItem(material: ToolMaterial?) : PickaxeItem(material, 0, -2.8f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    class NixAxeItem(material: ToolMaterial?) : PickaxeItem(material, 5, -3.0f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    class NixShovelItem(material: ToolMaterial?) : PickaxeItem(material,
        0.5f.toInt(), -3.0f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    class NixHoeItem(material: ToolMaterial?) : PickaxeItem(material, -4, 0.0f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))

}
object BlockClasses {
//    fun createLeavesBlock(): LeavesBlock {
//        return LeavesBlock(
//            AbstractBlock.Settings.of(Material.LEAVES).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS)
//                .nonOpaque()
//                .allowsSpawning { state: BlockState?, world: BlockView?, pos: BlockPos?, type: EntityType<*>? ->
//                    BlockClasses.canSpawnOnLeaves(
//                        state,
//                        world,
//                        pos,
//                        type
//                    )
//                }.suffocates { state: BlockState?, world: BlockView?, pos: BlockPos? ->
//                    BlockClasses.never(
//                        state,
//                        world,
//                        pos
//                    )
//                }.blockVision { state: BlockState?, world: BlockView?, pos: BlockPos? ->
//                    BlockClasses.never(
//                        state,
//                        world,
//                        pos
//                    )
//                })
//    }
//    private fun canSpawnOnLeaves(state: BlockState?, world: BlockView?, pos: BlockPos?, type: EntityType<*>?): Boolean {
//        return type === EntityType.OCELOT || type === EntityType.PARROT
//    }
//    private fun never(state: BlockState?, world: BlockView?, pos: BlockPos?): Boolean {
//        return false
//    }
//
//    fun register(id: String, block: Block): Block {
//        return Registry.register(Registry.BLOCK, id, block) as Block
//    }

}





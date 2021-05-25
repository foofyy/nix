package net.foof.nix.register

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.foof.nix.MOD_ID
import net.foof.nix.item.ThrowableSand
import net.foof.nix.item.WaraxeItem
import net.minecraft.item.*
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.item.ItemGroup
import net.minecraft.item.Item
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolItem
import net.minecraft.recipe.Ingredient
import net.minecraft.item.ToolMaterial
import net.minecraft.item.PickaxeItem
import net.minecraft.entity.EquipmentSlot
import net.minecraft.item.ShovelItem
import net.minecraft.util.Rarity
import net.minecraft.item.ArmorMaterial
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.item.ArmorItem
import net.minecraft.util.Formatting
import net.minecraft.text.TranslatableText
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.world.World
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import javax.print.attribute.Attribute

object Items {
    @JvmField

    //tools
    val ADAMANTITE_SWORD: ToolItem = SwordItem(AdamantiteToolMaterial, 2, -2.0f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val ADAMANTITE_PICKAXE: ToolItem = toolClasses.CustomPickaxeItem(AdamantiteToolMaterial, 0, -2.8f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val ADAMANTITE_AXE: ToolItem = toolClasses.CustomAxeItem(AdamantiteToolMaterial, 4, -2.8f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val ADAMANTITE_SHOVEL: ToolItem = ShovelItem(AdamantiteToolMaterial, 0.5f, -3.0f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val ADAMANTITE_HOE: ToolItem = toolClasses.CustomHoeItem(AdamantiteToolMaterial, -4, 0.0f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))

    val MYTHRIL_SWORD: ToolItem = toolClasses.NixSwordItem(MythrilToolMaterial)
    val MYTHRIL_PICKAXE: ToolItem = toolClasses.NixPickaxeItem(MythrilToolMaterial)
    val MYTHRIL_AXE: ToolItem = toolClasses.NixAxeItem(MythrilToolMaterial)
    val MYTHRIL_SHOVEL: ToolItem = toolClasses.NixShovelItem(MythrilToolMaterial)
    val MYTHRIL_HOE: ToolItem = toolClasses.NixHoeItem(MythrilToolMaterial)
    val COBALT_SWORD: ToolItem = toolClasses.NixSwordItem(CobaltToolMaterial)
    val COBALT_PICKAXE: ToolItem = toolClasses.NixPickaxeItem(CobaltToolMaterial)
    val COBALT_AXE: ToolItem = toolClasses.NixAxeItem(CobaltToolMaterial)
    val COBALT_SHOVEL: ToolItem = toolClasses.NixShovelItem(CobaltToolMaterial)
    val COBALT_HOE: ToolItem = toolClasses.NixHoeItem(CobaltToolMaterial)

    val TITANIUM_SWORD: ToolItem = SwordItem(TitaniumToolMaterial, 2, -2.0f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val TITANIUM_BROADSWORD: ToolItem = SwordItem(TitaniumToolMaterial, 3, -2.6f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val TITANIUM_PICKAXE: ToolItem = toolClasses.NixPickaxeItem(TitaniumToolMaterial)
    val TITANIUM_AXE: ToolItem = toolClasses.NixAxeItem(TitaniumToolMaterial)
    val TITANIUM_WARAXE: ToolItem = WaraxeItem(TitaniumToolMaterial, 4, -2.8f, Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val TITANIUM_SHOVEL: ToolItem = toolClasses.NixShovelItem(TitaniumToolMaterial)
    val TITANIUM_HOE: ToolItem = toolClasses.NixHoeItem(TitaniumToolMaterial)

    val AdamantiteArmorMaterial: ArmorMaterial = net.foof.nix.register.AdamantiteArmorMaterial
    val TitaniumArmorMaterial: ArmorMaterial = net.foof.nix.register.TitaniumArmorMaterial
    val MythrilArmorMaterial: ArmorMaterial = net.foof.nix.register.MythrilArmorMaterial
    val CobaltArmorMaterial: ArmorMaterial = net.foof.nix.register.CobaltArmorMaterial

    //normal items
    val THROWABLESAND = ThrowableSand(Item.Settings().group(GROUP))
    val ADAMANTITE_INGOT = Item(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val ADAMANTITE_GEM = Item(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val MYTHRIL_INGOT = Item(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val COBALT_INGOT = Item(Item.Settings().group(GROUP).rarity(Rarity.COMMON))
    val TITANIUM_INGOT = Item(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))
    val TITANIUM_SHARD = Item(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON))

    //armor items
    val ADAMANTITE_HELMET: Item = AdamantiteArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), AdamantiteArmorMaterial, EquipmentSlot.HEAD)
    val ADAMANTITE_CHESTPLATE: Item = AdamantiteArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), AdamantiteArmorMaterial, EquipmentSlot.CHEST)
    val ADAMANTITE_LEGGINGS: Item = AdamantiteArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), AdamantiteArmorMaterial, EquipmentSlot.LEGS)
    val ADAMANTITE_BOOTS: Item = AdamantiteArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), AdamantiteArmorMaterial, EquipmentSlot.FEET)
    val MYTHRIL_HELMET: Item = MythrilArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), MythrilArmorMaterial, EquipmentSlot.HEAD)
    val MYTHRIL_CHESTPLATE: Item = MythrilArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), MythrilArmorMaterial, EquipmentSlot.CHEST)
    val MYTHRIL_LEGGINGS: Item = MythrilArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), MythrilArmorMaterial, EquipmentSlot.LEGS)
    val MYTHRIL_BOOTS: Item = MythrilArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), MythrilArmorMaterial, EquipmentSlot.FEET)
    val COBALT_HELMET: Item = CobaltArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), CobaltArmorMaterial, EquipmentSlot.HEAD)
    val COBALT_CHESTPLATE: Item = CobaltArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), CobaltArmorMaterial, EquipmentSlot.CHEST)
    val COBALT_LEGGINGS: Item = CobaltArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), CobaltArmorMaterial, EquipmentSlot.LEGS)
    val COBALT_BOOTS: Item = CobaltArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), CobaltArmorMaterial, EquipmentSlot.FEET)
    val TITANIUM_HELMET: Item = AdamantiteArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), TitaniumArmorMaterial, EquipmentSlot.HEAD)
    val TITANIUM_CHESTPLATE: Item = TitaniumArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), TitaniumArmorMaterial, EquipmentSlot.CHEST)
    val TITANIUM_LEGGINGS: Item = TitaniumArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), TitaniumArmorMaterial, EquipmentSlot.LEGS)
    val TITANIUM_BOOTS: Item = TitaniumArmorItem(Item.Settings().group(GROUP).rarity(Rarity.UNCOMMON), TitaniumArmorMaterial, EquipmentSlot.FEET)


    //registry
    fun register() {
        //normal items
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "throwable_sand"), THROWABLESAND)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_ingot"), ADAMANTITE_INGOT)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_gem"), ADAMANTITE_GEM)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_ingot"), MYTHRIL_INGOT)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_ingot"), COBALT_INGOT)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_ingot"), TITANIUM_INGOT)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_shard"), TITANIUM_SHARD)
        //tools
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_sword"), ADAMANTITE_SWORD)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_shovel"), ADAMANTITE_SHOVEL)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_pickaxe"), ADAMANTITE_PICKAXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_axe"), ADAMANTITE_AXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_hoe"), ADAMANTITE_HOE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_sword"), MYTHRIL_SWORD)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_shovel"), MYTHRIL_SHOVEL)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_pickaxe"), MYTHRIL_PICKAXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_axe"), MYTHRIL_AXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_hoe"), MYTHRIL_HOE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_sword"), COBALT_SWORD)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_shovel"), COBALT_SHOVEL)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_pickaxe"), COBALT_PICKAXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_axe"), COBALT_AXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_hoe"), COBALT_HOE)

        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_sword"), TITANIUM_SWORD)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_broadsword"), TITANIUM_BROADSWORD)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_waraxe"), TITANIUM_WARAXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_shovel"), TITANIUM_SHOVEL)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_pickaxe"), TITANIUM_PICKAXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_axe"), TITANIUM_AXE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_hoe"), TITANIUM_HOE)

        //armour
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_helmet"), ADAMANTITE_HELMET)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_chestplate"), ADAMANTITE_CHESTPLATE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_leggings"), ADAMANTITE_LEGGINGS)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_boots"), ADAMANTITE_BOOTS)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_helmet"), MYTHRIL_HELMET)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_chestplate"), MYTHRIL_CHESTPLATE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_leggings"), MYTHRIL_LEGGINGS)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_boots"), MYTHRIL_BOOTS)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_helmet"), COBALT_HELMET)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_chestplate"), COBALT_CHESTPLATE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_leggings"), COBALT_LEGGINGS)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_boots"), COBALT_BOOTS)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_helmet"), TITANIUM_HELMET)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_chestplate"), TITANIUM_CHESTPLATE)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_leggings"), TITANIUM_LEGGINGS)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_boots"), TITANIUM_BOOTS)
        //block items
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "rocky_dirt"), BlockItem(Blocks.ROCKY_DIRT, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_ore"), BlockItem(Blocks.ADAMANTITE_ORE, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "bush"), BlockItem(Blocks.BUSH, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "clay_pot"), BlockItem(Blocks.CLAY_POT, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "adamantite_block"), BlockItem(Blocks.ADAMANTITE_BLOCK, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_ore"), BlockItem(Blocks.MYTHRIL_ORE, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "mythril_block"), BlockItem(Blocks.MYTHRIL_BLOCK, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_ore"), BlockItem(Blocks.COBALT_ORE, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cobalt_block"), BlockItem(Blocks.COBALT_BLOCK, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_ore"), BlockItem(Blocks.TITANIUM_ORE, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "titanium_block"), BlockItem(Blocks.TITANIUM_BLOCK, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "godstone"), BlockItem(Blocks.GODSTONE, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "godstone_grass"), BlockItem(Blocks.GODSTONE_GRASS, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "otherbark_log"), BlockItem(Blocks.OTHERBARK_LOG, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "otherbark_planks"), BlockItem(Blocks.OTHERBARK_PLANKS, FabricItemSettings().group(GROUP)))
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "otherbark_pine_leaves"), BlockItem(Blocks.OTHERBARK_PINE_LEAVES, FabricItemSettings().group(GROUP)))

    }

}

//tool materials
object AdamantiteToolMaterial : ToolMaterial {
    override fun getDurability(): Int {
        return 1000
    }
    override fun getMiningSpeedMultiplier(): Float {
        return 8.0f
    }
    override fun getAttackDamage(): Float {
        return 4.0f
    }
    override fun getMiningLevel(): Int {
        return 4
    }
    override fun getEnchantability(): Int {
        return 15
    }
    override fun getRepairIngredient(): Ingredient? {
        return Ingredient.ofItems(Items.ADAMANTITE_INGOT)
    }
}
object TitaniumToolMaterial : ToolMaterial {
    override fun getDurability(): Int {
        return 1000
    }
    override fun getMiningSpeedMultiplier(): Float {
        return 8.0f
    }
    override fun getAttackDamage(): Float {
        return 4.0f
    }
    override fun getMiningLevel(): Int {
        return 4
    }
    override fun getEnchantability(): Int {
        return 15
    }
    override fun getRepairIngredient(): Ingredient? {
        return Ingredient.ofItems(Items.TITANIUM_INGOT)
    }
}
object MythrilToolMaterial : ToolMaterial {
    override fun getDurability(): Int {
        return 1000
    }
    override fun getMiningSpeedMultiplier(): Float {
        return 7.0f
    }
    override fun getAttackDamage(): Float {
        return 4.0f
    }
    override fun getMiningLevel(): Int {
        return 3
    }
    override fun getEnchantability(): Int {
        return 15
    }
    override fun getRepairIngredient(): Ingredient? {
        return Ingredient.ofItems(Items.MYTHRIL_INGOT)
    }
}
object CobaltToolMaterial : ToolMaterial {
    override fun getDurability(): Int {
        return 1000
    }
    override fun getMiningSpeedMultiplier(): Float {
        return 7.0f
    }
    override fun getAttackDamage(): Float {
        return 3.0f
    }
    override fun getMiningLevel(): Int {
        return 1
    }
    override fun getEnchantability(): Int {
        return 15
    }
    override fun getRepairIngredient(): Ingredient? {
        return Ingredient.ofItems(Items.COBALT_INGOT)
    }
}
//armor materials
object AdamantiteArmorMaterial : ArmorMaterial {

    private const val X = 35

    private val BASE_DURABILITY = intArrayOf(13, 16, 15, 11)
    private val PROTECTION_VALUES = intArrayOf(3, 8, 6, 3)
    override fun getDurability(slot: EquipmentSlot?): Int {
        return BASE_DURABILITY[slot!!.getEntitySlotId()] * X
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        return PROTECTION_VALUES[slot!!.getEntitySlotId()]
    }

    override fun getEnchantability(): Int {
        return X
    }

    override fun getEquipSound(): SoundEvent {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(Items.ADAMANTITE_INGOT)
    }

    override fun getName(): String {
        return "adamantite"
    }

    override fun getToughness(): Float {
        return 2.0f
    }

    override fun getKnockbackResistance(): Float {
        return 0.0F
    }
}
object TitaniumArmorMaterial : ArmorMaterial {

    private const val X = 35

    private val BASE_DURABILITY = intArrayOf(13, 16, 15, 11)
    private val PROTECTION_VALUES = intArrayOf(3, 8, 6, 3)
    override fun getDurability(slot: EquipmentSlot?): Int {
        return BASE_DURABILITY[slot!!.getEntitySlotId()] * X
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        return PROTECTION_VALUES[slot!!.getEntitySlotId()]
    }

    override fun getEnchantability(): Int {
        return X
    }

    override fun getEquipSound(): SoundEvent {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(Items.TITANIUM_INGOT)
    }

    override fun getName(): String {
        return "titanium"
    }

    override fun getToughness(): Float {
        return 2.0f
    }

    override fun getKnockbackResistance(): Float {
        return 0.0F
    }
}
object MythrilArmorMaterial : ArmorMaterial {

    private const val X = 25

    private val BASE_DURABILITY = intArrayOf(12, 15, 14, 10)
    private val PROTECTION_VALUES = intArrayOf(2, 4, 5, 2)
    override fun getDurability(slot: EquipmentSlot?): Int {
        return BASE_DURABILITY[slot!!.getEntitySlotId()] * X
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        return PROTECTION_VALUES[slot!!.getEntitySlotId()]
    }

    override fun getEnchantability(): Int {
        return X
    }

    override fun getEquipSound(): SoundEvent {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(Items.MYTHRIL_INGOT)
    }

    override fun getName(): String {
        return "mythril"
    }

    override fun getToughness(): Float {
        return 1.0f
    }

    override fun getKnockbackResistance(): Float {
        return 0.0F
    }
}
object CobaltArmorMaterial : ArmorMaterial {

    private const val X = 20

    private val BASE_DURABILITY = intArrayOf(12, 15, 14, 10)
    private val PROTECTION_VALUES = intArrayOf(2, 3, 4, 2)
    override fun getDurability(slot: EquipmentSlot?): Int {
        return BASE_DURABILITY[slot!!.getEntitySlotId()] * X
    }

    override fun getProtectionAmount(slot: EquipmentSlot?): Int {
        return PROTECTION_VALUES[slot!!.getEntitySlotId()]
    }

    override fun getEnchantability(): Int {
        return X
    }

    override fun getEquipSound(): SoundEvent {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON
    }

    override fun getRepairIngredient(): Ingredient {
        return Ingredient.ofItems(Items.COBALT_INGOT)
    }

    override fun getName(): String {
        return "cobalt"
    }

    override fun getToughness(): Float {
        return 0.0f
    }

    override fun getKnockbackResistance(): Float {
        return 0.0F
    }
}
//special class for the armor items NEEDED FOR THE TOOLTIPS
class AdamantiteArmorItem(settings: Settings?, material: ArmorMaterial?, slot: EquipmentSlot?) : ArmorItem(material, slot, settings) {
    override fun appendTooltip(itemStack: ItemStack?, world: World?, tooltip: MutableList<Text?>, tooltipContext: TooltipContext?) {
        tooltip.add(TranslatableText("item.nix.adamantite_armor.tooltip"))
        tooltip.add(TranslatableText("item.nix.adamantite_armor.tooltip_2"))
    }
}
class TitaniumArmorItem(settings: Settings?, material: ArmorMaterial?, slot: EquipmentSlot?) : ArmorItem(material, slot, settings) {
    override fun appendTooltip(itemStack: ItemStack?, world: World?, tooltip: MutableList<Text?>, tooltipContext: TooltipContext?) {
        tooltip.add(TranslatableText("item.nix.titanium_armor.tooltip"))
        tooltip.add(TranslatableText("item.nix.titanium_armor.tooltip_2"))
    }
}
class MythrilArmorItem(settings: Settings?, material: ArmorMaterial?, slot: EquipmentSlot?) : ArmorItem(material, slot, settings) {
    override fun appendTooltip(itemStack: ItemStack?, world: World?, tooltip: MutableList<Text?>, tooltipContext: TooltipContext?) {
        tooltip.add(TranslatableText("item.nix.mythril_armor.tooltip"))
        tooltip.add(TranslatableText("item.nix.mythril_armor.tooltip_2"))
    }
}
class CobaltArmorItem(settings: Settings?, material: ArmorMaterial?, slot: EquipmentSlot?) : ArmorItem(material, slot, settings) {
    override fun appendTooltip(itemStack: ItemStack?, world: World?, tooltip: MutableList<Text?>, tooltipContext: TooltipContext?) {
        tooltip.add(TranslatableText("item.nix.cobalt_armor.tooltip"))
        tooltip.add(TranslatableText("item.nix.cobalt_armor.tooltip_2"))
    }
}
//creates the group for every item added by nix
val GROUP: ItemGroup = FabricItemGroupBuilder
    .create(Identifier(MOD_ID, "nix_items"))
    .icon { ItemStack(Items.COBALT_INGOT) }
    .build()
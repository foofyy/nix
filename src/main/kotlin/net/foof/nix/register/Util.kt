package net.foof.nix.register

import net.minecraft.item.*
import net.minecraft.util.Rarity


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





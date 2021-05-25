package net.foof.nix.item

import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.world.World
import java.util.*


/*class SpearItem(private val material: ToolMaterial, attackSpeed: Float, settings: Settings?) :
    SwordItem(material, (material.attackDamage+1).toInt(), attackSpeed, settings) {

    var attackDamage: Int = (material.attackDamage+1).toInt()

    val attributeModifiers: Multimap<EntityAttribute, EntityAttributeModifier>

    override fun getAttributeModifiers(equipmentSlot: EquipmentSlot): Multimap<EntityAttribute, EntityAttributeModifier> {
        return if (equipmentSlot == EquipmentSlot.MAINHAND) attributeModifiers else super.getAttributeModifiers(
            equipmentSlot
        )
    }

    override fun getMaterial(): ToolMaterial {
        return this.material
    }

    override fun inventoryTick(stack: ItemStack?, world: World, entity: Entity, slot: Int, selected: Boolean) {
        if (entity is PlayerEntity && !world.isClient) {
            val player = entity as PlayerEntity
            if (selected && player.hasVehicle() && !player.attributes
                    .hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)
            ) {
                val entityAttributeInstance = player
                    .getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE)
                entityAttributeInstance!!.addTemporaryModifier(ATTACK_BONUS_MODIFIER)
            } else if (player.attributes.hasModifierForAttribute(
                    EntityAttributes.GENERIC_ATTACK_DAMAGE,
                    ATTACK_BONUS_MODIFIER_ID
                ) && !player.hasVehicle()
            ) {
                player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE)
                    ?.removeModifier(ATTACK_BONUS_MODIFIER_ID)
            }
        }
    }

    companion object {
        val ATTACK_BONUS_MODIFIER_ID = UUID.fromString("fbd4e4e4-62f7-4108-9be3-eb6781231298")
        var ATTACK_BONUS_MODIFIER: EntityAttributeModifier? = null

        init {
            ATTACK_BONUS_MODIFIER = EntityAttributeModifier(
                ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0,
                EntityAttributeModifier.Operation.ADDITION
            )
        }
    }

    init {
        val builder = ImmutableMultimap.builder<EntityAttribute, EntityAttributeModifier>()
        builder.put(
            EntityAttributes.GENERIC_ATTACK_DAMAGE, EntityAttributeModifier(
                ATTACK_DAMAGE_MODIFIER_ID,
                "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION
            )
        )
        builder.put(
            EntityAttributes.GENERIC_ATTACK_SPEED, EntityAttributeModifier(
                ATTACK_SPEED_MODIFIER_ID,
                "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION
            )
        )
        builder.put(
            ReachEntityAttributes.ATTACK_RANGE,
            EntityAttributeModifier("Attack range", 1.5, EntityAttributeModifier.Operation.ADDITION)
        )
        this.attributeModifiers = builder.build()
    }
}

*///
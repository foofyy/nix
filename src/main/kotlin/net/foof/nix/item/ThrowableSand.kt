package net.foof.nix.item

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.util.TypedActionResult
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.world.World
import net.minecraft.item.ItemStack
import net.minecraft.item.Item
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial
import net.minecraft.particle.ParticleTypes
import net.minecraft.particle.ParticleTypes.DUST
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.text.Text
import net.minecraft.util.UseAction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box

class ThrowableSand(settings: Settings?) : Item(settings) {
    override fun getUseAction(stack: ItemStack?): UseAction? {
        return UseAction.SPEAR
    }
    override fun getMaxUseTime(stack: ItemStack?): Int {
        return 5
    }

    override fun finishUsing(stack: ItemStack?, world: World, user: LivingEntity): ItemStack? {
        val radius = 3
        user.playSound(SoundEvents.BLOCK_SAND_BREAK, 1.0F, 1.0F);
        if (!world.isClient && user is PlayerEntity) {
            val player = user

            (world as ServerWorld).spawnParticles(ParticleTypes.POOF, player.getX(), player.getBodyY(0.5), player.getZ(), 4, 2.0, 0.1, 2.0, 0.0)

            world.getEntitiesByClass(
                HostileEntity::class.java,
                Box(
                    user.getBlockPos().add(-radius - 2, -1, -radius - 2),
                    user.getBlockPos().add(radius + 2, 3, radius + 2)
                ),
                { entity -> true }).forEach { entity ->
                entity.damage(
                    DamageSource.player(player),  1.5f
                )
                entity.setVelocity(
                    entity.getPos().subtract(player.getPos()).multiply(0.1).add(0.0, 0.15, 0.0)
                )

            }

            player.itemCooldownManager[this] = 4 * 5 // 20 * 5
        }

        return super.finishUsing(stack, world, user)
    }

    override fun use(world: World?, user: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack>? {
        val itemStack = user.getStackInHand(hand)
        user.setCurrentHand(hand)
        return TypedActionResult.consume(itemStack)
    }
}


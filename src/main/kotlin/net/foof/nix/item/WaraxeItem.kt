package net.foof.nix.item

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.mob.HostileEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ToolMaterial
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.util.UseAction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Box
import net.minecraft.world.World

class WaraxeItem(material: ToolMaterial?, attackDamage: Int, attackSpeed: Float, settings: Settings?) : PickaxeItem(material, attackDamage, attackSpeed, settings) {
    override fun getUseAction(stack: ItemStack?): UseAction? {
        return UseAction.BOW
    }
    override fun getMaxUseTime(stack: ItemStack?): Int {
        return 20
    }

    override fun finishUsing(stack: ItemStack?, world: World, user: LivingEntity): ItemStack? {
        val radius = 3
        user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
        user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 0.5F, 0.5F);
        user.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, 0.5F, 2.0F);
        if (!world.isClient && user is PlayerEntity) {
            val player = user

            (world as ServerWorld).spawnParticles(ParticleTypes.SWEEP_ATTACK, player.getX(), player.getBodyY(0.5), player.getZ(), 4, 2.0, 0.1, 2.0, 0.0)
            world.playSound(user, BlockPos(player.getX(),player.getY(),player.getZ()), SoundEvents.ENTITY_BLAZE_HURT, SoundCategory.MASTER, 1.0f, 1.8f)

            world.getEntitiesByClass(
                HostileEntity::class.java,
                Box(
                    user.getBlockPos().add(-radius - 2, -1, -radius - 2),
                    user.getBlockPos().add(radius + 2, 3, radius + 2)
                ),
                { entity -> true }).forEach { entity ->
                entity.damage(
                    DamageSource.player(player), attackDamage * 1.5f
                )
                entity.setVelocity(
                    entity.getPos().subtract(player.getPos()).multiply(0.5).add(0.0, .35, 0.0)
                )
            }

            player.itemCooldownManager[this] = 10 * 5 // 20 * 5
        }

        return super.finishUsing(stack, world, user)
    }

    override fun use(world: World?, user: PlayerEntity, hand: Hand?): TypedActionResult<ItemStack>? {
        val itemStack = user.getStackInHand(hand)
        user.setCurrentHand(hand)
        return TypedActionResult.consume(itemStack)
    }
}
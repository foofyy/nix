package net.foof.nix.mixin;

import net.foof.nix.register.Items;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    @Shadow @Final public PlayerAbilities abilities;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void setBonuses(CallbackInfo ci) {

        Item helmet = getEquippedStack(EquipmentSlot.HEAD).getItem();
        Item chest = getEquippedStack(EquipmentSlot.CHEST).getItem();
        Item legs = getEquippedStack(EquipmentSlot.LEGS).getItem();
        Item boots = getEquippedStack(EquipmentSlot.FEET).getItem();

        if (helmet == Items.INSTANCE.getADAMANTITE_HELMET() && chest == Items.INSTANCE.getADAMANTITE_CHESTPLATE() && legs == Items.INSTANCE.getADAMANTITE_LEGGINGS() && boots == Items.INSTANCE.getADAMANTITE_BOOTS()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 42, 3, false, false));
        }
        if (helmet == Items.INSTANCE.getMYTHRIL_HELMET() && chest == Items.INSTANCE.getMYTHRIL_CHESTPLATE() && legs == Items.INSTANCE.getMYTHRIL_LEGGINGS() && boots == Items.INSTANCE.getMYTHRIL_BOOTS()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 42, 1, false, false));
        }
        if (helmet == Items.INSTANCE.getCOBALT_HELMET() && chest == Items.INSTANCE.getCOBALT_CHESTPLATE() && legs == Items.INSTANCE.getCOBALT_LEGGINGS() && boots == Items.INSTANCE.getCOBALT_BOOTS()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 42, 1, false, false));
        }
    }
    @Inject(method ="onDeath", at = @At("HEAD"))
    public void onDeath(DamageSource source, CallbackInfo ci) {
        //do stuff
    }

    @Inject(method ="damage", at = @At("HEAD"))
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        Item helmet = getEquippedStack(EquipmentSlot.HEAD).getItem();
        Item chest = getEquippedStack(EquipmentSlot.CHEST).getItem();
        Item legs = getEquippedStack(EquipmentSlot.LEGS).getItem();
        Item boots = getEquippedStack(EquipmentSlot.FEET).getItem();

        if (helmet == Items.INSTANCE.getTITANIUM_HELMET() && chest == Items.INSTANCE.getTITANIUM_CHESTPLATE() && legs == Items.INSTANCE.getCOBALT_LEGGINGS() && boots == Items.INSTANCE.getCOBALT_BOOTS()) {
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 42, 1, false, false));
        }
    }
}
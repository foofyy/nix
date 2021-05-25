package net.foof.nix.mixin;

import net.foof.nix.register.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class FeatureMixin {
    @Inject(method = "isSoil(Lnet/minecraft/block/Block;)Z", at = @At(value = "HEAD"), cancellable = true)
    private static void isSoil(Block block, CallbackInfoReturnable<Boolean> cir)
    {
        if (block == Blocks.INSTANCE.getGODSTONE_GRASS()) {
            cir.setReturnValue(true);
        }
    }
    @Inject(method = "isStone(Lnet/minecraft/block/Block;)Z", at = @At(value = "HEAD"), cancellable = true)
    private static void isStone(Block block, CallbackInfoReturnable<Boolean> cir)
    {
        if (block == Blocks.INSTANCE.getGODSTONE_GRASS()) {
            cir.setReturnValue(true);
        }
    }
}
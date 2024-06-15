package io.izzel.arclight.common.mixin.core.server.level;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Inject(
            method = "getDrops(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;)Ljava/util/List;",
            at = @At("RETURN"),
            cancellable = true
    )
    private static void sapling(BlockState p_49870_, ServerLevel p_49871_, BlockPos p_49872_, BlockEntity p_49873_, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> drops = new ArrayList<>(cir.getReturnValue());
        drops.removeIf(stack -> {
            String name = stack.getItem().getClass().getName().toLowerCase();
            return name.contains("sapling");
        });
        cir.setReturnValue(drops);
    }

    @Inject(
            method = "getDrops(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/item/ItemStack;)Ljava/util/List;",
            at = @At("RETURN"),
            cancellable = true
    )
    private static void sapling(BlockState p_49875_, ServerLevel p_49876_, BlockPos p_49877_, BlockEntity p_49878_, Entity p_49879_, ItemStack p_49880_, CallbackInfoReturnable<List<ItemStack>> cir) {
        List<ItemStack> drops = new ArrayList<>(cir.getReturnValue());
        drops.removeIf(stack -> {
            String name = stack.getItem().getClass().getName().toLowerCase();
            return name.contains("sapling");
        });
        cir.setReturnValue(drops);
    }
}

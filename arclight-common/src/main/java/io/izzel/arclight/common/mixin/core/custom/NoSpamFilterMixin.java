package io.izzel.arclight.common.mixin.core.custom;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class NoSpamFilterMixin {
    @Inject(
            method = "detectRateSpam",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void overrideDetectSpam(CallbackInfo ci) {
        ci.cancel();
    }
}

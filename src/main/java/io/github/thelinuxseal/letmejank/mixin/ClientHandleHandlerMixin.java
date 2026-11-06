package io.github.thelinuxseal.letmejank.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.simulated_team.simulated.content.blocks.handle.ClientHandleHandler;
import io.github.thelinuxseal.letmejank.GrabKeys;
import net.minecraft.client.KeyMapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientHandleHandler.class)
public class ClientHandleHandlerMixin {

    // 1) startHold: "am I in move-the-contraption mode?"
    @ModifyExpressionValue(
        method = "startHold",
        at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/entity/player/Player;isShiftKeyDown()Z"))
    private boolean letmejank$useGrabKey(boolean original) {
        return GrabKeys.GRAB_HANDLE.isDown();
    }

    // 2) clientTick: swap the sneak key for ours in the auto-grab guard
    @ModifyExpressionValue(
        method = "clientTick",
        at = @At(value = "FIELD",
            target = "Lnet/minecraft/client/Options;keyShift:Lnet/minecraft/client/KeyMapping;"))
    private KeyMapping letmejank$useGrabKeyMapping(KeyMapping original) {
        return GrabKeys.GRAB_HANDLE;
    }
}
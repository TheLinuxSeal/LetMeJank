package io.github.thelinuxseal.letmejank;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@EventBusSubscriber(modid = LetMeJank.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class GrabKeys {
    public static final KeyMapping GRAB_HANDLE = new KeyMapping(
        "key.grabkey.grab_handle", InputConstants.KEY_G, "key.categories.grabkey");

    @SubscribeEvent
    public static void register(RegisterKeyMappingsEvent e) {
        e.register(GRAB_HANDLE);
    }
}
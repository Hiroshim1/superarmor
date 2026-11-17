package com.example.superarmor.client;

import com.example.superarmor.SuperArmor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SuperArmor.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SamuraiArmorModel.LAYER, SamuraiArmorModel::createLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(SuperArmor.SAMURAI_WARRIOR.get(),
                ctx -> new SamuraiRenderer<>(ctx, "samurai_warrior", 1.0F));
        event.registerEntityRenderer(SuperArmor.RONIN.get(),
                ctx -> new SamuraiRenderer<>(ctx, "ronin", 1.0F));
        event.registerEntityRenderer(SuperArmor.ONI.get(),
                ctx -> new SamuraiRenderer<>(ctx, "oni", 1.6F));
    }
}

package com.example.superarmor;

import com.example.superarmor.entity.Oni;
import com.example.superarmor.entity.Ronin;
import com.example.superarmor.entity.SamuraiWarrior;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SuperArmor.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(SuperArmor.SAMURAI_WARRIOR.get(), SamuraiWarrior.createAttributes().build());
        event.put(SuperArmor.RONIN.get(), Ronin.createAttributes().build());
        event.put(SuperArmor.ONI.get(), Oni.createAttributes().build());
    }
}

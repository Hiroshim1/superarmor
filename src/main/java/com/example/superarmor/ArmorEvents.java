package com.example.superarmor;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ArmorEvents {
    private static final String FLY_TAG = "superarmor_flight";

    public static boolean hasFullSet(Player p) {
        return p.getItemBySlot(EquipmentSlot.HEAD).is(SuperArmor.TITAN_HELMET.get())
                && p.getItemBySlot(EquipmentSlot.CHEST).is(SuperArmor.TITAN_CHESTPLATE.get())
                && p.getItemBySlot(EquipmentSlot.LEGS).is(SuperArmor.TITAN_LEGGINGS.get())
                && p.getItemBySlot(EquipmentSlot.FEET).is(SuperArmor.TITAN_BOOTS.get());
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player.level().isClientSide) return;
        Player player = event.player;

        if (hasFullSet(player)) {
            // Auto-reparación
            for (EquipmentSlot slot : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST,
                    EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                ItemStack stack = player.getItemBySlot(slot);
                if (stack.isDamaged()) stack.setDamageValue(0);
            }

            // Efectos (se refrescan cada segundo)
            if (player.tickCount % 20 == 0) {
                give(player, MobEffects.NIGHT_VISION, 400, 0);
                give(player, MobEffects.MOVEMENT_SPEED, 100, 2);
                give(player, MobEffects.JUMP, 100, 2);
                give(player, MobEffects.DAMAGE_BOOST, 100, 3);
                give(player, MobEffects.DIG_SPEED, 100, 3);
                give(player, MobEffects.REGENERATION, 100, 2);
                give(player, MobEffects.DAMAGE_RESISTANCE, 100, 2);
                give(player, MobEffects.FIRE_RESISTANCE, 100, 0);
                give(player, MobEffects.WATER_BREATHING, 100, 0);
                player.getFoodData().setFoodLevel(20);
                player.getFoodData().setSaturation(20.0F);
                player.setAirSupply(player.getMaxAirSupply());
            }

            // Vuelo estilo creativo
            if (!player.getAbilities().mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
            }
            player.getPersistentData().putBoolean(FLY_TAG, true);

        } else if (player.getPersistentData().getBoolean(FLY_TAG)) {
            player.getPersistentData().putBoolean(FLY_TAG, false);
            if (!player.isCreative() && !player.isSpectator()) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.onUpdateAbilities();
            }
        }
    }

    /** Inmunidad a todo el daño excepto /kill y el vacío. */
    @SubscribeEvent
    public void onAttack(LivingAttackEvent event) {
        if (event.getEntity() instanceof Player player && hasFullSet(player)
                && !event.getSource().is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            event.setCanceled(true);
        }
    }

    private static void give(Player p, MobEffect effect, int duration, int amp) {
        p.addEffect(new MobEffectInstance(effect, duration, amp, true, false, false));
    }
}

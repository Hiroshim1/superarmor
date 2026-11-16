package com.example.superarmor;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    // nombre, mult. durabilidad (netherita = 37), defensa casco/pecho/pantalón/botas,
    // encantabilidad, sonido, dureza, resistencia al retroceso, material de reparación
    TITAN("titan", 500, 6, 10, 8, 6, 50, SoundEvents.ARMOR_EQUIP_NETHERITE, 20.0F, 1.0F,
            () -> Ingredient.of(Items.NETHER_STAR));

    private final String name;
    private final int durabilityMultiplier;
    private final int helmet, chest, legs, boots;
    private final int enchantability;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repair;

    ModArmorMaterials(String name, int durabilityMultiplier, int helmet, int chest, int legs, int boots,
                      int enchantability, SoundEvent sound, float toughness, float knockbackResistance,
                      Supplier<Ingredient> repair) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.helmet = helmet;
        this.chest = chest;
        this.legs = legs;
        this.boots = boots;
        this.enchantability = enchantability;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repair = repair;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        int base = switch (type) {
            case BOOTS -> 13;
            case LEGGINGS -> 15;
            case CHESTPLATE -> 16;
            case HELMET -> 11;
        };
        return base * durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return switch (type) {
            case BOOTS -> boots;
            case LEGGINGS -> legs;
            case CHESTPLATE -> chest;
            case HELMET -> helmet;
        };
    }

    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public SoundEvent getEquipSound() { return sound; }
    @Override public Ingredient getRepairIngredient() { return repair.get(); }
    @Override public String getName() { return SuperArmor.MODID + ":" + name; }
    @Override public float getToughness() { return toughness; }
    @Override public float getKnockbackResistance() { return knockbackResistance; }
}

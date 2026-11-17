package com.example.superarmor;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModTiers implements Tier {
    AKAGANE(4, 3000, 9.0F, 5.0F, 30);

    private final int level, uses, enchantability;
    private final float speed, damage;

    ModTiers(int level, int uses, float speed, float damage, int enchantability) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantability = enchantability;
    }

    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return damage; }
    @Override public int getLevel() { return level; }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public Ingredient getRepairIngredient() { return Ingredient.of(SuperArmor.AKAGANE_INGOT.get()); }
}

package com.example.superarmor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

/** Pieza de armadura Titán: siempre con brillo de encantamiento. */
public class TitanArmorItem extends ArmorItem {
    public TitanArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}

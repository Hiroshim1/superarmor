package com.example.superarmor;

import com.example.superarmor.client.SamuraiArmorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

/** Pieza de armadura samurai: modelo 3D propio y brillo de encantamiento. */
public class TitanArmorItem extends ArmorItem {
    public TitanArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return SuperArmor.MODID + ":textures/models/armor/samurai.png";
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private HumanoidModel<?> model;

            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack,
                                                          EquipmentSlot slot, HumanoidModel<?> original) {
                if (model == null) {
                    model = new SamuraiArmorModel(
                            Minecraft.getInstance().getEntityModels().bakeLayer(SamuraiArmorModel.LAYER),
                            TitanArmorItem.this.getEquipmentSlot());
                }
                return model;
            }
        });
    }
}

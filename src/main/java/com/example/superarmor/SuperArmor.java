package com.example.superarmor;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(SuperArmor.MODID)
public class SuperArmor {
    public static final String MODID = "superarmor";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    private static Item.Properties props() {
        return new Item.Properties().fireResistant().rarity(Rarity.EPIC);
    }

    public static final RegistryObject<Item> TITAN_HELMET = ITEMS.register("titan_helmet",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.HELMET, props()));
    public static final RegistryObject<Item> TITAN_CHESTPLATE = ITEMS.register("titan_chestplate",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.CHESTPLATE, props()));
    public static final RegistryObject<Item> TITAN_LEGGINGS = ITEMS.register("titan_leggings",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.LEGGINGS, props()));
    public static final RegistryObject<Item> TITAN_BOOTS = ITEMS.register("titan_boots",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.BOOTS, props()));

    public SuperArmor() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modBus);
        modBus.addListener(this::addToCreativeTab);
        MinecraftForge.EVENT_BUS.register(new ArmorEvents());
    }

    private void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(TITAN_HELMET);
            event.accept(TITAN_CHESTPLATE);
            event.accept(TITAN_LEGGINGS);
            event.accept(TITAN_BOOTS);
        }
    }
}

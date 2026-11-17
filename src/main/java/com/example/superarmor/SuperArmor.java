package com.example.superarmor;

import com.example.superarmor.entity.Oni;
import com.example.superarmor.entity.Ronin;
import com.example.superarmor.entity.SamuraiWarrior;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(SuperArmor.MODID)
public class SuperArmor {
    public static final String MODID = "superarmor";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // ---------------- bloques ----------------
    public static final RegistryObject<Block> AKAGANE_ORE = BLOCKS.register("akagane_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).strength(4.5F, 3.0F),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_AKAGANE_ORE = BLOCKS.register("deepslate_akagane_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).strength(6.0F, 3.0F),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> AKAGANE_BLOCK = BLOCKS.register("akagane_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).strength(5.0F, 6.0F)
                    .lightLevel(state -> 6)));

    // ---------------- entidades ----------------
    public static final RegistryObject<EntityType<SamuraiWarrior>> SAMURAI_WARRIOR = ENTITIES.register("samurai_warrior",
            () -> EntityType.Builder.of(SamuraiWarrior::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).clientTrackingRange(8).build(MODID + ":samurai_warrior"));
    public static final RegistryObject<EntityType<Ronin>> RONIN = ENTITIES.register("ronin",
            () -> EntityType.Builder.of(Ronin::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).clientTrackingRange(8).build(MODID + ":ronin"));
    public static final RegistryObject<EntityType<Oni>> ONI = ENTITIES.register("oni",
            () -> EntityType.Builder.of(Oni::new, MobCategory.MONSTER)
                    .sized(1.1F, 3.1F).fireImmune().clientTrackingRange(10).build(MODID + ":oni"));

    // ---------------- items ----------------
    private static Item.Properties props() {
        return new Item.Properties().fireResistant().rarity(Rarity.EPIC);
    }

    public static final RegistryObject<Item> AKAGANE_INGOT = ITEMS.register("akagane_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RAW_AKAGANE = ITEMS.register("raw_akagane",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> AKAGANE_ORE_ITEM = ITEMS.register("akagane_ore",
            () -> new BlockItem(AKAGANE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_AKAGANE_ORE_ITEM = ITEMS.register("deepslate_akagane_ore",
            () -> new BlockItem(DEEPSLATE_AKAGANE_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> AKAGANE_BLOCK_ITEM = ITEMS.register("akagane_block",
            () -> new BlockItem(AKAGANE_BLOCK.get(), new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> AKAGANE_KATANA = ITEMS.register("akagane_katana",
            () -> new SwordItem(ModTiers.AKAGANE, 3, -1.8F, props()) {
                @Override
                public boolean isFoil(ItemStack stack) {
                    return true;
                }
            });

    public static final RegistryObject<Item> TITAN_HELMET = ITEMS.register("titan_helmet",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.HELMET, props()));
    public static final RegistryObject<Item> TITAN_CHESTPLATE = ITEMS.register("titan_chestplate",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.CHESTPLATE, props()));
    public static final RegistryObject<Item> TITAN_LEGGINGS = ITEMS.register("titan_leggings",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.LEGGINGS, props()));
    public static final RegistryObject<Item> TITAN_BOOTS = ITEMS.register("titan_boots",
            () -> new TitanArmorItem(ModArmorMaterials.TITAN, ArmorItem.Type.BOOTS, props()));

    public static final RegistryObject<Item> SAMURAI_WARRIOR_EGG = ITEMS.register("samurai_warrior_spawn_egg",
            () -> new ForgeSpawnEggItem(SAMURAI_WARRIOR, 0x181820, 0xA81C26, new Item.Properties()));
    public static final RegistryObject<Item> RONIN_EGG = ITEMS.register("ronin_spawn_egg",
            () -> new ForgeSpawnEggItem(RONIN, 0x3E4C68, 0xC6A65E, new Item.Properties()));
    public static final RegistryObject<Item> ONI_EGG = ITEMS.register("oni_spawn_egg",
            () -> new ForgeSpawnEggItem(ONI, 0xB02624, 0xF0C432, new Item.Properties()));

    public SuperArmor() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modBus);
        ENTITIES.register(modBus);
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
            event.accept(AKAGANE_KATANA);
        } else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(AKAGANE_INGOT);
            event.accept(RAW_AKAGANE);
        } else if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(AKAGANE_ORE_ITEM);
            event.accept(DEEPSLATE_AKAGANE_ORE_ITEM);
        } else if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(AKAGANE_BLOCK_ITEM);
        } else if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(SAMURAI_WARRIOR_EGG);
            event.accept(RONIN_EGG);
            event.accept(ONI_EGG);
        }
    }
}

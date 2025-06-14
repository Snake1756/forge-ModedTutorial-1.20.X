package net.justus.pbossmod.item;

import net.justus.pbossmod.block.ModBlocks;
import net.justus.pbossmod.entity.ModEntities;
import net.justus.pbossmod.item.custom.FuelItem;
import net.justus.pbossmod.item.custom.MetalDetectorItem;
import net.justus.pbossmod.item.custom.ModArmorItem;
import net.justus.pbossmod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.justus.pbossmod.ExampleMod;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> Ruby = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Ruby_Nugget = ITEMS.register("ruby_nugget",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> PIGLIN_MEAT = ITEMS.register("piglin_meat",
            () -> new Item(new Item.Properties().food(ModFoods.PIGLIN_MEAT)));
    public static final RegistryObject<Item> PIGLIN_Flesh = ITEMS.register("piglin_flesh",
            () -> new FuelItem(new Item.Properties(),1800));
    public static final RegistryObject<Item> PIGLIN_AXE = ITEMS.register("piglin_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 8, -3f, new Item.Properties()));
    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new Item(new Item.Properties().food(ModFoods.ONION)));
    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(6, ModSounds.BAR_BRAWL, new Item.Properties().stacksTo(1), 2440));

    public static final RegistryObject<Item> PIGLIN_BOSS_SPAWN_EGG = ITEMS.register("piglin_boss_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PIGLINBOSS, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));


    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModToolTiers.RUBY, 4, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModToolTiers.RUBY, 3, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModToolTiers.RUBY, 1, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModToolTiers.RUBY, 1, -2.2f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModToolTiers.RUBY, 1, -2.2f, new Item.Properties()));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ONION_SEEDS = ITEMS.register("onion_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(), new Item.Properties()));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}


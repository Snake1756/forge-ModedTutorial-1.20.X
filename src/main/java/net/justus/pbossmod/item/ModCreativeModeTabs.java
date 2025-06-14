package net.justus.pbossmod.item;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PBoss_Tab = CREATIVE_MODE_TABS.register("pboss_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Ruby.get()))
                    .title(Component.translatable("creativetab.pboss_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.Ruby.get());
                        output.accept(ModItems.Ruby_Nugget.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.PIGLIN_MEAT.get());
                        output.accept(ModItems.PIGLIN_Flesh.get());
                        output.accept(ModItems.PIGLIN_AXE.get());
                        output.accept(ModItems.RUBY_SWORD.get());
                        output.accept(ModItems.RUBY_PICKAXE.get());
                        output.accept(ModItems.RUBY_AXE.get());
                        output.accept(ModItems.RUBY_SHOVEL.get());
                        output.accept(ModItems.RUBY_HOE.get());
                        output.accept(ModItems.RUBY_HELMET.get());
                        output.accept(ModItems.RUBY_CHESTPLATE.get());
                        output.accept(ModItems.RUBY_LEGGINGS.get());
                        output.accept(ModItems.RUBY_BOOTS.get());
                        output.accept(ModItems.ONION_SEEDS.get());
                        output.accept(ModItems.ONION.get());
                        output.accept(ModBlocks.WILD_ONION.get());
                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());
                        output.accept(ModItems.PIGLIN_BOSS_SPAWN_EGG.get());


                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.ALTAR_BLOCK.get());

                        output.accept(ModBlocks.RUBY_SLAB.get());
                        output.accept(ModBlocks.RUBY_TRAPDOOR.get());
                        output.accept(ModBlocks.RUBY_WALL.get());
                        output.accept(ModBlocks.RUBY_STAIRS.get());
                        output.accept(ModBlocks.RUBY_FENCE_GATE.get());
                        output.accept(ModBlocks.RUBY_FENCE.get());
                        output.accept(ModBlocks.RUBY_DOOR.get());
                        output.accept(ModBlocks.RUBY_BUTTON.get());
                        output.accept(ModBlocks.RUBY_PRESSURE_PLATE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}


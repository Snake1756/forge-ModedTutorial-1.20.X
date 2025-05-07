package net.justus.pbossmod.block;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.block.custom.Altar_Block;
import net.justus.pbossmod.block.custom.OnionCropBlock;
import net.justus.pbossmod.item.ModItems;
import net.justus.pbossmod.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).strength(4f)
                    .requiresCorrectToolForDrops(), UniformInt.of(35,50)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS).strength(12f)));
    public static final RegistryObject<Block> ALTAR_BLOCK = registerBlock("altar_block",
            () -> new Altar_Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).strength(12f).requiresCorrectToolForDrops().sound(ModSounds.ALTAR_BLOCK_SOUNDS)));

    public static final RegistryObject<Block> RUBY_STAIRS = registerBlock("ruby_stairs",
            () -> new StairBlock(() -> ModBlocks.RUBY_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
    public static final RegistryObject<Block> RUBY_SLAB = registerBlock("ruby_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> RUBY_BUTTON = registerBlock("ruby_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STONE_BUTTON).sound(SoundType.ANCIENT_DEBRIS),
                    BlockSetType.IRON, 10,true));
    public static final RegistryObject<Block> RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> RUBY_FENCE = registerBlock("ruby_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));
    public static final RegistryObject<Block> RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS),
                    SoundEvents.CHAIN_PLACE,SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> RUBY_WALL = registerBlock("ruby_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> RUBY_DOOR = registerBlock("ruby_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS).noOcclusion(),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.IRON_BLOCK).sound(SoundType.ANCIENT_DEBRIS).noOcclusion(),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> ONION_CROP = Blocks.register("onion_crop",
            () -> new OnionCropBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.WHEAT).noCollission().noOcclusion()));
    public static final RegistryObject<Block> WILD_ONION = registerBlock("wild_onion",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_WILD_ONION = Blocks.register("potted_wild_onion",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT), ModBlocks.WILD_ONION,
                    BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.POTTED_ALLIUM).noOcclusion()));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Blocks.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        Blocks.register(eventBus);
    }

}

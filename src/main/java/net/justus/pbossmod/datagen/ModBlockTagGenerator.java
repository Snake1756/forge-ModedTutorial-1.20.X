package net.justus.pbossmod.datagen;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.block.ModBlocks;
import net.justus.pbossmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExampleMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.RUBY_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.ALTAR_BLOCK.get(),

                        ModBlocks.RUBY_BUTTON.get(),
                        ModBlocks.RUBY_DOOR.get(),
                        ModBlocks.RUBY_FENCE_GATE.get(),
                        ModBlocks.RUBY_FENCE.get(),
                        ModBlocks.RUBY_WALL.get(),
                        ModBlocks.RUBY_TRAPDOOR.get(),
                        ModBlocks.RUBY_STAIRS.get(),
                        ModBlocks.RUBY_SLAB.get(),
                        ModBlocks.RUBY_PRESSURE_PLATE.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALTAR_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ALTAR_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ALTAR_BLOCK.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.RUBY_ORE.get(),
                        ModBlocks.RUBY_BUTTON.get(),
                        ModBlocks.RUBY_DOOR.get(),
                        ModBlocks.RUBY_FENCE_GATE.get(),
                        ModBlocks.RUBY_FENCE.get(),
                        ModBlocks.RUBY_WALL.get(),
                        ModBlocks.RUBY_TRAPDOOR.get(),
                        ModBlocks.RUBY_STAIRS.get(),
                        ModBlocks.RUBY_SLAB.get(),
                        ModBlocks.RUBY_PRESSURE_PLATE.get());
        this.tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .add(ModBlocks.RUBY_BLOCK.get());



        this.tag(BlockTags.FENCES)
                .add(ModBlocks.RUBY_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.RUBY_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.RUBY_WALL.get());



    }
}

package net.justus.pbossmod.datagen;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.block.ModBlocks;
import net.justus.pbossmod.block.custom.OnionCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExampleMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBY_BLOCK);

        blockWithItem(ModBlocks.RUBY_ORE);

        blockWithItem(ModBlocks.ALTAR_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.RUBY_STAIRS.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.RUBY_SLAB.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.RUBY_BUTTON.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.RUBY_PRESSURE_PLATE.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.RUBY_FENCE.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.RUBY_FENCE_GATE.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.RUBY_WALL.get()),blockTexture(ModBlocks.RUBY_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.RUBY_DOOR.get()), modLoc("block/ruby_door_bottom"), modLoc("block/ruby_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.RUBY_TRAPDOOR.get()), modLoc("block/ruby_trapdoor"),true,"cutout");

        makeOnionCrop((CropBlock) ModBlocks.ONION_CROP.get(), "onion_stage", "onion_stage");

        simpleBlockWithItem(ModBlocks.WILD_ONION.get(), models().cross(blockTexture(ModBlocks.WILD_ONION.get()).getPath(),
                blockTexture(ModBlocks.WILD_ONION.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_WILD_ONION.get(), models().singleTexture("potted_wild_onion", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.WILD_ONION.get())).renderType("cutout"));
    }

    public void makeOnionCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> onionStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] onionStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((OnionCropBlock) block).getAgeProperty()),
                new ResourceLocation(ExampleMod.MOD_ID, "block/" + textureName + state.getValue(((OnionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

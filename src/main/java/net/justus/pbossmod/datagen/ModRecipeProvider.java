package net.justus.pbossmod.datagen;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.block.ModBlocks;
import net.justus.pbossmod.item.ModItems;
import net.justus.pbossmod.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.Ruby_Nugget.get(), 25f, 300, "ruby_nugget");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.Ruby_Nugget.get(), 25f, 200, "ruby_nugget");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.Ruby.get())
                .unlockedBy(getHasName(ModItems.Ruby.get()), has(ModItems.Ruby.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.Ruby.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.Ruby_Nugget.get())
                .unlockedBy(getHasName(ModItems.Ruby_Nugget.get()), has(ModItems.Ruby_Nugget.get()))
                .save(pWriter, "pbossmod:ruby_from_nuggets");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALTAR_BLOCK.get())
                .pattern("CCC")
                .pattern("CHC")
                .pattern("CCC")
                .define('H', ModItems.Ruby.get())
                .define('C', Blocks.BLACKSTONE)
                .unlockedBy(getHasName(ModItems.Ruby.get()), has(ModItems.Ruby.get()))
                .save(pWriter, "pbossmod:altar_from_ruby");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Ruby.get(), 9)
                .requires(ModBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RUBY_BLOCK.get()), has(ModBlocks.RUBY_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ONION_SEEDS.get(), 2)
                .requires(ModBlocks.WILD_ONION.get())
                .unlockedBy(getHasName(ModBlocks.WILD_ONION.get()), has(ModBlocks.WILD_ONION.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.Ruby_Nugget.get(), 9)
                .requires(ModItems.Ruby.get())
                .unlockedBy(getHasName(ModItems.Ruby.get()), has(ModItems.Ruby.get()))
                .save(pWriter);

        smithingUpgrade(pWriter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_HELMET, ModItems.Ruby.get(), ModItems.RUBY_HELMET.get());
        smithingUpgrade(pWriter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_CHESTPLATE, ModItems.Ruby.get(), ModItems.RUBY_CHESTPLATE.get());
        smithingUpgrade(pWriter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_LEGGINGS, ModItems.Ruby.get(), ModItems.RUBY_LEGGINGS.get());
        smithingUpgrade(pWriter, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.NETHERITE_BOOTS, ModItems.Ruby.get(), ModItems.RUBY_BOOTS.get());
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  ExampleMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
    private void smithingUpgrade(Consumer<FinishedRecipe> writer,
                                 ItemLike template, ItemLike base, ItemLike addition, ItemLike result) {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(template),
                        Ingredient.of(base),
                        Ingredient.of(addition),
                        RecipeCategory.COMBAT,
                        result.asItem())
                .unlocks("has_" + getItemName(addition), has(addition))
                .save(writer, ExampleMod.MOD_ID + ":" + getItemName(result) + "_smithing");
    }
}
package net.justus.pbossmod.item;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(5, 3500, 16f, 7f, 25,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.Ruby.get())),
            new ResourceLocation(ExampleMod.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());

}

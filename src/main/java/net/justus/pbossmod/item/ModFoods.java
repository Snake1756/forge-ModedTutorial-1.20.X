package net.justus.pbossmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties PIGLIN_MEAT = new FoodProperties.Builder().nutrition(16).meat()
            .saturationMod(16f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1800, 2),1.0f).build();
    public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(16)
            .saturationMod(16f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 2),1.0f).build();

}

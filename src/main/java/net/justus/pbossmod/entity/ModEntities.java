package net.justus.pbossmod.entity;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.entity.custom.PiglinBossEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MOD_ID);

    public static final RegistryObject<EntityType<PiglinBossEntity>> PIGLINBOSS =
            ENTITY_TYPES.register("piglinboss", () -> EntityType.Builder.of(PiglinBossEntity::new, MobCategory.CREATURE)
                    .sized(2f, 3f).build("rhino"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
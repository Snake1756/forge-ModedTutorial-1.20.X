package net.justus.pbossmod.event;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.entity.ModEntities;
import net.justus.pbossmod.entity.custom.PiglinBossEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.PIGLINBOSS.get(), PiglinBossEntity.createAttributes().build());
    }
}
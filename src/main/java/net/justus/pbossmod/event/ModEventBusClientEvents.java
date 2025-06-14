package net.justus.pbossmod.event;

import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.entity.client.ModModelLayers;
import net.justus.pbossmod.entity.client.PiglinBoss;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PIGLINBOSS_LAYER, PiglinBoss::createBodyLayer);
    }
}
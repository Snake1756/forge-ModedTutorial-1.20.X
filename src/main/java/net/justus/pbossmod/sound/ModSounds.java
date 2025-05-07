package net.justus.pbossmod.sound;

import net.justus.pbossmod.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ExampleMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");

    public static final RegistryObject<SoundEvent> ALTAR_BLOCK_BREAK = registerSoundEvents("altar_block_break");
    public static final RegistryObject<SoundEvent> ALTAR_BLOCK_STEP = registerSoundEvents("altar_block_step");
    public static final RegistryObject<SoundEvent> ALTAR_BLOCK_FALL = registerSoundEvents("altar_block_fall");
    public static final RegistryObject<SoundEvent> ALTAR_BLOCK_PLACE = registerSoundEvents("altar_block_place");
    public static final RegistryObject<SoundEvent> ALTAR_BLOCK_HIT = registerSoundEvents("altar_block_hit");

    public static final RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvents("bar_brawl");


    public static final ForgeSoundType ALTAR_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.ALTAR_BLOCK_BREAK, ModSounds.ALTAR_BLOCK_STEP, ModSounds.ALTAR_BLOCK_PLACE,
            ModSounds.ALTAR_BLOCK_HIT, ModSounds.ALTAR_BLOCK_FALL);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ExampleMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
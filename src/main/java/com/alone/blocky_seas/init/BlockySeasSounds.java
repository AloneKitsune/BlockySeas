/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import com.alone.blocky_seas.BlockySeas;

public class BlockySeasSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BlockySeas.MOD_ID);
	public static final RegistryObject<SoundEvent> GAMEABILITY1 = REGISTRY.register("gameability1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("blocky_seas", "gameability1")));
}
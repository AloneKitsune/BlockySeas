/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import com.alone.blocky_seas.potion.SeasicknessMobEffect;
import com.alone.blocky_seas.BlockySeas;

public class BlockySeasMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BlockySeas.MOD_ID);
	public static final RegistryObject<MobEffect> SEASICKNESS = REGISTRY.register("seasickness", () -> new SeasicknessMobEffect());
}
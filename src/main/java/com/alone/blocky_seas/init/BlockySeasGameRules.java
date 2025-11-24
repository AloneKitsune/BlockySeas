/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockySeasGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> DO_SEASICKNESS = GameRules.register("doSeasickness", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}
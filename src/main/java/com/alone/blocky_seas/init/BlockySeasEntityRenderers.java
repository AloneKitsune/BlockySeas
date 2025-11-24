/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.alone.blocky_seas.client.renderer.GameAbility1GreenRenderer;
import com.alone.blocky_seas.client.renderer.GameAbility1WhiteRenderer;
import com.alone.blocky_seas.client.renderer.GameAbility1RedRenderer;
import com.alone.blocky_seas.client.renderer.GameAbility1BlueRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockySeasEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BlockySeasEntities.GAME_ABILITY_1_GREEN.get(), GameAbility1GreenRenderer::new);
		event.registerEntityRenderer(BlockySeasEntities.GAME_ABILITY_1_RED.get(), GameAbility1RedRenderer::new);
		event.registerEntityRenderer(BlockySeasEntities.GAME_ABILITY_1_WHITE.get(), GameAbility1WhiteRenderer::new);
		event.registerEntityRenderer(BlockySeasEntities.GAME_ABILITY_1_BLUE.get(), GameAbility1BlueRenderer::new);
	}
}
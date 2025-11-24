/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.alone.blocky_seas.client.model.Modelgameabil1_red;
import com.alone.blocky_seas.client.model.Modelgameabil1_green;
import com.alone.blocky_seas.client.model.Modelgameabil1_white;
import com.alone.blocky_seas.client.model.Modelgameabil1_blue;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BlockySeasModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelgameabil1_blue.LAYER_LOCATION, Modelgameabil1_blue::createBodyLayer);
		event.registerLayerDefinition(Modelgameabil1_green.LAYER_LOCATION, Modelgameabil1_green::createBodyLayer);
		event.registerLayerDefinition(Modelgameabil1_white.LAYER_LOCATION, Modelgameabil1_white::createBodyLayer);
		event.registerLayerDefinition(Modelgameabil1_red.LAYER_LOCATION, Modelgameabil1_red::createBodyLayer);
	}
}
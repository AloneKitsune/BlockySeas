/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.alone.blocky_seas.client.gui.MenuScreen;
import com.alone.blocky_seas.client.gui.AbilityMenuScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockySeasScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(BlockySeasMenus.MENU.get(), MenuScreen::new);
			MenuScreens.register(BlockySeasMenus.ABILITY_MENU.get(), AbilityMenuScreen::new);
		});
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}
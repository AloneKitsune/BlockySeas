package com.alone.blocky_seas.procedures;

import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.player.Player;

@Mod.EventBusSubscriber
public class OnFallProcedure 
{
	@SubscribeEvent
	public static void onFall(LivingFallEvent event) {
	    if (event.getEntity() instanceof Player player) {
	        boolean noFall = player.getPersistentData().getBoolean("NoFallDamage");
	
	        if (noFall) {
	            event.setCanceled(true);
	            player.getPersistentData().putBoolean("NoFallDamage", false);
	        }

	        
	    }
	}
}
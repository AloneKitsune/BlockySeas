package com.alone.blocky_seas.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class HelperMethods {
	public static void execute() {
	}

	public static String getFruit(Entity entity)
	{
		return (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).fruit;
	}

	public static boolean hasFlyingFruit(Entity entity)
	{
		if (entity == null)
			return false;
		String fruit = (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).fruit;
//		System.out.println(fruit);
		return fruit.equals("whirlwind");
	}

	public static boolean hasFruit(Entity entity)
	{
		if (entity == null)
			return false;
		return !((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).fruit).isEmpty();
	}

	public static boolean usingMove(Entity entity)
	{
		return (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).usingMove;
	}

	public static boolean isFlying(Entity entity)
	{
		if (entity instanceof Player _player) 
		{
			return _player.getAbilities().flying;
		}
		return false;
	}
	
}
package com.alone.blocky_seas.procedures;

import com.alone.blocky_seas.BlockySeas;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class HelperMethods {
	public static void execute() {
	}

	public static String getFruit(Entity entity) {
		return (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).fruit;
	}

	public static String getWeapon(Entity entity) {
		if (entity instanceof LivingEntity living) {
			ItemStack held = living.getMainHandItem();
			if (!held.isEmpty()) {
				return held.getHoverName().getString().replaceFirst(BlockySeas.MOD_ID+":","");
			}
		}
		return "";
	}

	public static void enableUsingMove(Entity player)
	{
		player.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.usingMove = true;
			capability.syncPlayerVariables(player);
		});
	}

	public static boolean holdingAbilityWeapon(Entity entity)
	{
		return switch (HelperMethods.getWeapon(entity).toLowerCase()) {
			case "cutlass","dagger" -> true;
			default        -> false;
		};

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
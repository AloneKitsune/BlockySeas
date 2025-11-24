package com.alone.blocky_seas.procedures;

import net.minecraft.world.entity.Entity;

import com.alone.blocky_seas.fruitdata.FruitAbilities;

public class Ability2OnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity player;
		player = entity;
		FruitAbilities.useAbility2(player);
	}
}
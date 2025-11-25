package com.alone.blocky_seas.procedures.keypressed;

import com.alone.blocky_seas.abilities.Abilities;
import net.minecraft.world.entity.Entity;

public class Ability5OnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		player = entity;
		Abilities.execute(player,5);
	}
}
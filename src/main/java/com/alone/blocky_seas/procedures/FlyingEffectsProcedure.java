package com.alone.blocky_seas.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FlyingEffectsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (HelperMethods.isFlying(entity)) {
			if (((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).fruit).equals("whirlwind")) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CLOUD, x, (y + 0.2), z, 1, 0, 0, 0, 0.1);
			}
		}
	}
}
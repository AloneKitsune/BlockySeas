package com.alone.blocky_seas.procedures;

import net.minecraft.world.entity.Entity;

import com.alone.blocky_seas.BlockySeas;

public class DarkrootPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "";
			entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.fruit = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = false;
			entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.usingMove = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockySeas.LOGGER.info((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).fruit);
	}
}
package com.alone.blocky_seas.procedures;

import com.alone.blocky_seas.init.BlockySeasGameRules;
import com.alone.blocky_seas.init.BlockySeasMobEffects;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		FruitMainProcedure.execute(world, x, y, z, entity);
		if (!((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).fruit).equals("")) {
			if (world.getLevelData().getGameRules().getBoolean(BlockySeasGameRules.DO_SEASICKNESS)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(BlockySeasMobEffects.SEASICKNESS.get(), 2, 0, false, false));
			}
		}
		if ((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability1 > 0) {
			{
				double _setval = (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability1 - 1;
				entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability2 > 0) {
			{
				double _setval = (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability2 - 1;
				entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability3 > 0) {
			{
				double _setval = (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability3 - 1;
				entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability3 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability4 > 0) {
			{
				double _setval = (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability4 - 1;
				entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability4 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability5 > 0) {
			{
				double _setval = (entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new com.alone.blocky_seas.network.BlockySeasModVariables.PlayerVariables())).ability5 - 1;
				entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability5 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
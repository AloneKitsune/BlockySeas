package com.alone.blocky_seas.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import com.alone.blocky_seas.entity.GameAbility1GreenEntity;
import com.alone.blocky_seas.entity.GameAbility1WhiteEntity;
import com.alone.blocky_seas.entity.GameAbility1RedEntity;
import com.alone.blocky_seas.entity.GameAbility1BlueEntity;
import com.alone.blocky_seas.BlockySeas;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Gameabil1WhileProjectileFlyingTickProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GameAbility1GreenEntity || entity instanceof GameAbility1RedEntity || entity instanceof GameAbility1WhiteEntity || entity instanceof GameAbility1BlueEntity) {
			BlockySeas.queueServerWork(40, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}
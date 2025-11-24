package com.alone.blocky_seas.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import com.alone.blocky_seas.BlockySeas;

public class Bombabil2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.usingMove = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		double[] yaw = {entity.getYRot()};
		double[] pitch = {entity.getXRot()};
		double[] speed = {5.0};
		double[] yawRad = {Math.toRadians(yaw[0])};
		double[] pitchRad = {Math.toRadians(pitch[0])};
		double[] vx = {-Math.sin(yawRad[0]) * Math.cos(pitchRad[0]) * (speed[0] * .4)};
		double[] vy = {-Math.sin(pitchRad[0]) * speed[0]};
		double[] vz = {Math.cos(yawRad[0]) * Math.cos(pitchRad[0]) * speed[0]};
		if (entity instanceof Player player && !player.level().isClientSide()) {
			player.setDeltaMovement(player.getDeltaMovement().add(vx[0], vy[0], vz[0]));
			player.hurtMarked = true;
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.EXPLOSION, x, (y + 0.1), z, 5, 0.5, 0.1, 0.5, 0);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5, false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 30, 255, false, false));
		BlockySeas.queueServerWork(30, () -> {
			double[] nx = {entity.getX()};
			double[] ny = {entity.getY()};
			double[] nz = {entity.getZ()};
			speed[0] = (speed[0] / 1.75);
			yaw[0] = entity.getYRot();
			pitch[0] = entity.getXRot();
			yawRad[0] = Math.toRadians(yaw[0]);
			pitchRad[0] = Math.toRadians(pitch[0]);
			vx[0] = -Math.sin(yawRad[0]) * Math.cos(pitchRad[0]) * (speed[0] * .4);
			vy[0] = -Math.sin(pitchRad[0]) * speed[0];
			vz[0] = Math.cos(yawRad[0]) * Math.cos(pitchRad[0]) * speed[0];
			if (entity instanceof Player player && !player.level().isClientSide()) {
				player.setDeltaMovement(player.getDeltaMovement().add(vx[0] - entity.getDeltaMovement().x, (vy[0] - entity.getDeltaMovement().y), vz[0] - entity.getDeltaMovement().z));
				player.hurtMarked = true;
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION, nx[0], ny[0] + .1, nz[0], 5, 0.5, 0.1, 0.5, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(nx[0], ny[0], nz[0]), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5);
				} else {
					_level.playLocalSound(nx[0], ny[0], nz[0], ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5, false);
				}
			}
			{
				boolean _setval = false;
				entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.usingMove = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		});
	}
}
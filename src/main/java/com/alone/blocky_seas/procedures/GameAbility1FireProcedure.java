package com.alone.blocky_seas.procedures;

import com.alone.blocky_seas.init.BlockySeasEntities;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import com.alone.blocky_seas.entity.GameAbility1GreenEntity;
import com.alone.blocky_seas.entity.GameAbility1WhiteEntity;
import com.alone.blocky_seas.entity.GameAbility1RedEntity;
import com.alone.blocky_seas.entity.GameAbility1BlueEntity;
import com.alone.blocky_seas.BlockySeas;

public class GameAbility1FireProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		for (int i = 0; i < 8; i++) {
			int delay = 5 * i;
			BlockySeas.queueServerWork(delay, () -> {
				// spawn code
				double[] pos = {entity.getX(), entity.getY(), entity.getZ()};
				int ran = (int) Math.floor(Math.random() * 4) + 1;
				if (ran == 1) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new GameAbility1GreenEntity(BlockySeasEntities.GAME_ABILITY_1_GREEN.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 5, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(pos[0], pos[1], pos[2]), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(pos[0], pos[1], pos[2], ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				else if (ran == 2) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new GameAbility1RedEntity(BlockySeasEntities.GAME_ABILITY_1_RED.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 5, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(pos[0], pos[1], pos[2]), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(pos[0], pos[1], pos[2], ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				else if (ran == 3) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new GameAbility1WhiteEntity(BlockySeasEntities.GAME_ABILITY_1_WHITE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 5, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(pos[0], pos[1], pos[2]), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(pos[0], pos[1], pos[2], ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				else {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new GameAbility1BlueEntity(BlockySeasEntities.GAME_ABILITY_1_BLUE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 5, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(pos[0], pos[1], pos[2]), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(pos[0], pos[1], pos[2], ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("blocky_seas:gameability1")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
			});
		}
	}
}
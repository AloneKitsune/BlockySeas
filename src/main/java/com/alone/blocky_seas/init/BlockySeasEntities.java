/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import com.alone.blocky_seas.entity.GameAbility1GreenEntity;
import com.alone.blocky_seas.entity.GameAbility1WhiteEntity;
import com.alone.blocky_seas.entity.GameAbility1RedEntity;
import com.alone.blocky_seas.entity.GameAbility1BlueEntity;
import com.alone.blocky_seas.BlockySeas;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockySeasEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BlockySeas.MOD_ID);
	public static final RegistryObject<EntityType<GameAbility1GreenEntity>> GAME_ABILITY_1_GREEN = register("game_ability_1_green", EntityType.Builder.<GameAbility1GreenEntity>of(GameAbility1GreenEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GameAbility1GreenEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GameAbility1RedEntity>> GAME_ABILITY_1_RED = register("game_ability_1_red", EntityType.Builder.<GameAbility1RedEntity>of(GameAbility1RedEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GameAbility1RedEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GameAbility1WhiteEntity>> GAME_ABILITY_1_WHITE = register("game_ability_1_white", EntityType.Builder.<GameAbility1WhiteEntity>of(GameAbility1WhiteEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GameAbility1WhiteEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GameAbility1BlueEntity>> GAME_ABILITY_1_BLUE = register("game_ability_1_blue", EntityType.Builder.<GameAbility1BlueEntity>of(GameAbility1BlueEntity::new, MobCategory.MISC)
			.setCustomClientFactory(GameAbility1BlueEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
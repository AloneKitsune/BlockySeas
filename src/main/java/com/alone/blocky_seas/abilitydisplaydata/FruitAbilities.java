package com.alone.blocky_seas.abilitydisplaydata;

import java.util.ArrayList;

import com.alone.blocky_seas.init.BlockySeasGameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;


import com.alone.blocky_seas.procedures.HelperMethods;
import com.alone.blocky_seas.procedures.Bombabil2Procedure;
import com.alone.blocky_seas.procedures.GameAbility1FireProcedure;


import java.util.concurrent.atomic.AtomicReference;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.phys.Vec3;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameType;
import net.minecraft.client.Minecraft;


public class FruitAbilities
{
	public static ArrayList<String> bomb_abilityTextures = new ArrayList<>();
	public static ArrayList<String> whirlwind_abilityTextures = new ArrayList<>();
	public static ArrayList<String> blank_abilityTextures = new ArrayList<>();
	public static ArrayList<String> sculk_abilityTextures = new ArrayList<>();
	public static ArrayList<String> game_abilityTextures = new ArrayList<>();


	public FruitAbilities()
	{
		// blank
		blank_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		blank_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		blank_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		blank_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		blank_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");

		// bomb
		bomb_abilityTextures.add("blocky_seas:textures/screens/bombability_1.png");
		bomb_abilityTextures.add("blocky_seas:textures/screens/bombability_2.png");
		bomb_abilityTextures.add("blocky_seas:textures/screens/bombability_3.png");

		// sculk
		sculk_abilityTextures.add("blocky_seas:textures/screens/sculkability_1.png");
		sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		sculk_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		
		// whirlwind
		whirlwind_abilityTextures.add("blocky_seas:textures/screens/whirlwindability_1.png");
		whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		whirlwind_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");

		// game
		game_abilityTextures.add("blocky_seas:textures/screens/gameability_1.png");
		game_abilityTextures.add("blocky_seas:textures/screens/gameability_2.png");
		game_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		game_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		game_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
		
	}

	public ArrayList<String> getFruitArrayList(Entity entity)
	{
		String fruit = HelperMethods.getFruit(entity);
		if(fruit.equals("bomb")) {return bomb_abilityTextures;}
		else if (fruit.equals("whirlwind")) {return whirlwind_abilityTextures;}
		else if (fruit.equals("sculk")) {return sculk_abilityTextures;}
		else if (fruit.equals("game")) {return game_abilityTextures;}
		
		else {return blank_abilityTextures;}
	}
	

	public String getAbilityTexture(ArrayList<String> arr, int index)
	{
		return arr.get(index);
	}


	public static void useAbility1(Entity entity)
	{
		if(HelperMethods.usingMove(entity) || HelperMethods.holdingAbilityWeapon(entity))
		{return;}
		
		if(entity.level().getLevelData().getGameRules().getBoolean(BlockySeasGameRules.DO_SEASICKNESS) && entity.isInWater() && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity)))
		{return;}


		// handles cooldown
		
		AtomicReference<Double> ability1Ref = new AtomicReference<>(0.0);

		entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap ->
		{
		    ability1Ref.set(cap.ability1);
		});

		// must not have cd
		if(!(ability1Ref.get()==0))
		{
			return;
		}
		double[] cd = {0};
		
		//


		String fruit = HelperMethods.getFruit(entity);
		// bomb ability
		if(fruit.equals("bomb"))
		{
			
			cd[0] = 100;
			if (entity instanceof Player player && !player.level().isClientSide()) 
			{
				Vec3 look = player.getLookAngle();
				double distance = 1.5D;
				double x = player.getX();
//				+ look.x * distance;
			    double y = player.getY();
//			    .getEyeY() + look.y * distance;
			    double z = player.getZ();
//			    + look.z * distance;


				((ServerLevel) player.level()).sendParticles(
		        ParticleTypes.EXPLOSION,  // or EXPLOSION_EMITTER / EXPLOSION_NORMAL
		        x, y, z,                  // position
		        10,                        // count
		        0.1, 0.1, 0.1,                  // speed offsets
		        0                         // particle speed
    			);

    			player.setDeltaMovement(player.getDeltaMovement().add(0,3,0));
    			player.hurtMarked = true;
    			player.level().playSound(
		        null,                                      // Player to exclude (null = everyone hears it)
		        entity.getX(), entity.getY(), entity.getZ(), // Position
		        SoundEvents.GENERIC_EXPLODE,               // Sound type
		        SoundSource.PLAYERS,                       // Sound category
		        1.0F,                                      // Volume
		        1.0F                                       // Pitch
		    	);

				if (!player.level().isClientSide()) {
				    player.getPersistentData().putBoolean("NoFallDamage", true);
				}
		    	
			}
			
		}
		else if (fruit.equals("sculk"))
		{
			cd[0] = 100;
			if (entity instanceof Player player && !player.level().isClientSide()) 
			{
				System.out.println("Sculk abil 1");
			}
		}
		else if (fruit.equals("game"))
		{
			cd[0] = 225;
			if (entity instanceof Player player && !player.level().isClientSide()) 
			{
				System.out.println("Game abil 1");
				GameAbility1FireProcedure.execute(entity.level(),entity);
			}
		}

		// handles setting cooldown
		entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability1 += cd[0];
					capability.syncPlayerVariables(entity);
				});
		//

	}

	public static void useAbility2(Entity entity)
	{
		if(HelperMethods.usingMove(entity) || HelperMethods.holdingAbilityWeapon(entity))
		{return;}
		if(entity.level().getLevelData().getGameRules().getBoolean(BlockySeasGameRules.DO_SEASICKNESS) && entity.isInWater() && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity) || new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity)))
		{return;}


		// handles cooldown
		
		AtomicReference<Double> ability2Ref = new AtomicReference<>(0.0);

		entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap ->
		{
		    ability2Ref.set(cap.ability2);
		});

		if(!(ability2Ref.get()==0))
		{
			return;
		}
		double[] cd = {0};
		
		//


		
		// bomb ability
		if(HelperMethods.getFruit(entity).equals("bomb"))
		{
			
			cd[0] = 350;
			if (entity instanceof Player player && !player.level().isClientSide()) 
			{
				
				if (entity == null)
					return;
				boolean _setval = true;
				entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.usingMove = _setval;
					capability.syncPlayerVariables(entity);
				});

				Bombabil2Procedure.execute(entity.level(),entity.getX(),entity.getY(),entity.getZ(),entity);
				


				if (!player.level().isClientSide()) 
				{
				    player.getPersistentData().putBoolean("NoFallDamage", true);
				}
		    	
			}
			
		}


		// handles setting cooldown
		entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability2 += cd[0];
					capability.syncPlayerVariables(entity);
				});
		//
	}

	public void flyingEffect(LevelAccessor world, double x, double y, double z, Entity entity)
	{
		return;
	}
}
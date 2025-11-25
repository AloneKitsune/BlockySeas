package com.alone.blocky_seas.abilities;

import com.alone.blocky_seas.abilitydisplaydata.DisplayData;
import com.alone.blocky_seas.init.BlockySeasGameRules;
import com.alone.blocky_seas.network.BlockySeasModVariables;
import com.alone.blocky_seas.procedures.HelperMethods;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Abilities
{
    private static final Map<String, Consumer<Entity>> abilityMap = new HashMap<>();

    static {
        // Bomb abilities
        abilityMap.put("bombability_1", Bomb::bomb1);
        abilityMap.put("bombability_2", Bomb::bomb2);

        // Game abilities
        abilityMap.put("gameability_1", Game::game1);
        //abilityMap.put("game2", Game::game2);
    }

    public static void execute(Entity entity, int slot)
    {
        // determines if the player can currently use moves
        if(!(entity instanceof Player) || HelperMethods.usingMove(entity) || HelperMethods.holdingAbilityWeapon(entity) || !canUseAbility(entity) || (slot < 1 || slot > 5)) return;

        String abilityName = DisplayData.getFruitAbilityName(entity,slot);

        // handles cd
        entity.getCapability(BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap -> {

            // Check if the ability in this slot is on cooldown
            double currentCD = switch(slot) {
                case 1 -> cap.ability1;
                case 2 -> cap.ability2;
                case 3 -> cap.ability3;
                case 4 -> cap.ability4;
                case 5 -> cap.ability5;
                default -> 0;
            };
            if (currentCD > 0) return;

            // sets cd
            double newCD = switch(abilityName.toLowerCase()) {
                case "bombability_1" -> 125;
                case "bombability_2" -> 225;
                case "gameability_1" -> 200;
                default -> 0;
            };

            // Run the ability

            Consumer<Entity> ability = abilityMap.get(abilityName.toLowerCase());
            if (ability != null) ability.accept(entity);


            // Set cooldown in the correct slot
            switch(slot){
                case 1 -> cap.ability1 = newCD;
                case 2 -> cap.ability2 = newCD;
                case 3 -> cap.ability3 = newCD;
                case 4 -> cap.ability4 = newCD;
                case 5 -> cap.ability5 = newCD;
            }

            // Sync with client
            cap.syncPlayerVariables(entity);
        });

    }

    private static boolean canUseAbility(Entity entity)
    {
        return !entity.level().getLevelData().getGameRules().getBoolean(BlockySeasGameRules.DO_SEASICKNESS) || !entity.isInWater() || (new Object() {
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
        }.checkGamemode(entity));
    }
}


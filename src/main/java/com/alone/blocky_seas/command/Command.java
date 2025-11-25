package com.alone.blocky_seas.command;


import com.alone.blocky_seas.abilitydisplaydata.DisplayData;
import com.alone.blocky_seas.network.BlockySeasModVariables;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Command
{
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("blockyseas")
                        .then(Commands.literal("setFruitAbility")
                                .then(Commands.argument("player", EntityArgument.player())
                                        // reset
                                        .then(Commands.literal("reset")
                                                .executes(ctx -> {
                                                    ServerPlayer player = EntityArgument.getPlayer(ctx, "player");

                                                    player.getCapability(BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                            .ifPresent(cap -> {
                                                                cap.fruitAbilityList.replaceAll(e ->"noabilityicon");
                                                                cap.syncPlayerVariables(player);
                                                            });
                                                    return 1;
                                                })
                                        )
                                        // none
                                        .then(Commands.literal("none")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "noabilityicon",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        // bomb fruit
                                        .then(Commands.literal("bomb1")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "bombability_1",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("bomb2")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "bombability_2",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("bomb3")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "bombability_3",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        // game fruit
                                        .then(Commands.literal("game1")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "gameability_1",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("game2")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "gameability_2",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("game3")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "gameability_3",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("game4")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "gameability_4",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("game5")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "gameability_5",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        // chop fruit
                                        .then(Commands.literal("chop1")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "chopability_1",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("chop2")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "chopability_2",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("chop3")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "chopability_3",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("chop4")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "chopability_4",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        // whirlwind fruit
                                        .then(Commands.literal("whirlwind1")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "whirlwindability_1",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("whirlwind2")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "whirlwindability_2",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("whirlwind3")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "whirlwindability_3",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("whirlwind4")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "whirlwindability_4",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )
                                        .then(Commands.literal("whirlwind5")
                                                .then(Commands.argument("slot", IntegerArgumentType.integer(1, 5))
                                                        .executes(ctx -> executeFruit(
                                                                EntityArgument.getPlayer(ctx, "player"),
                                                                "whirlwindability_5",
                                                                IntegerArgumentType.getInteger(ctx, "slot"))))
                                        )

                                )
                        )
                        .then(Commands.literal("setSwordAbility")
                                .then(Commands.argument("player", EntityArgument.player())
                                        .then(Commands.literal("reset")
                                                .executes(ctx -> {
                                                    ServerPlayer player = EntityArgument.getPlayer(ctx, "player");

                                                    player.getCapability(BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                                                            .ifPresent(cap -> {
                                                                cap.swordAbilityList.clear();
                                                                cap.syncPlayerVariables(player);
                                                            });
                                                    return 1;
                                                })
                                        )
                                )
                        )
        );
    }

    private static int executeFruit(ServerPlayer target, String ability, int slot) {
        // Call your method
        DisplayData.setPlayerFruitAbility(target, ability, slot);

        return 1;
    }
}
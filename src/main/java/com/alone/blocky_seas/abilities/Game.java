package com.alone.blocky_seas.abilities;

import com.alone.blocky_seas.procedures.GameAbility1FireProcedure;
import net.minecraft.world.entity.Entity;

public class Game
{
    protected static void game1(Entity player)
    {
        GameAbility1FireProcedure.execute(player.level(),player);
    }
}

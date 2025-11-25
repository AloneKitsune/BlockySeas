package com.alone.blocky_seas.abilities;


import com.alone.blocky_seas.procedures.Bombabil2Procedure;
import com.alone.blocky_seas.procedures.HelperMethods;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;


public class Bomb
{
    protected static void bomb1(Entity player)
    {
        if (player.level().isClientSide()) return;

        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();

        if (player.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(
                    ParticleTypes.EXPLOSION,
                    x, y, z,
                    10,
                    0.1, 0.1, 0.1,
                    0
            );
        }

        player.setDeltaMovement(player.getDeltaMovement().add(0,3,0));
        player.hurtMarked = true;

        player.level().playSound(
                null,
                x, y, z,
                SoundEvents.GENERIC_EXPLODE,
                SoundSource.PLAYERS,
                1.0F,
                1.0F
        );

        if (!player.level().isClientSide()) {
            player.getPersistentData().putBoolean("NoFallDamage", true);
        }
    }
    protected static void bomb2(Entity player)
    {
        HelperMethods.enableUsingMove(player);
        Bombabil2Procedure.execute(player.level(),player.getX(),player.getY(),player.getZ(),player);
        player.getPersistentData().putBoolean("NoFallDamage", true);

    }
}

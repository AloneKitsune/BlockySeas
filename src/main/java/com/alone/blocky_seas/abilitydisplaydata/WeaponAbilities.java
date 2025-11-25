package com.alone.blocky_seas.abilitydisplaydata;

import com.alone.blocky_seas.init.BlockySeasItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public class WeaponAbilities
{
    private static final ArrayList<String> cutlass_abilityTextures = new ArrayList<>();
    private static final ArrayList<String> dagger_abilityTextures = new ArrayList<>();

    static {
        cutlass_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        cutlass_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        cutlass_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");

        dagger_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        dagger_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
        dagger_abilityTextures.add("blocky_seas:textures/screens/noabilityicon.png");
    }

    public static ArrayList<String> getWeaponTextures(Entity entity)
    {
        if(!(entity instanceof LivingEntity)) {
            return null;
        }
        ItemStack held = ((LivingEntity) entity).getMainHandItem();

        if(held.is(BlockySeasItems.CUTLASS.get()))
        {
            return cutlass_abilityTextures;
        }
        else if (held.is(BlockySeasItems.DAGGER.get())) {
            return dagger_abilityTextures;
        }




        return null;
    }
}

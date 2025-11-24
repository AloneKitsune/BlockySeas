package com.alone.blocky_seas.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WhiteBerry extends Item {
    public WhiteBerry(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (!world.isClientSide && stack.hasCustomHoverName()) {
            if (stack.getHoverName().getString().equalsIgnoreCase("Cool Moonberry")) {
                stack.getOrCreateTag().putInt("CustomModelData", 1);
            } else {
                stack.getOrCreateTag().remove("CustomModelData");
            }
        }
    }
}

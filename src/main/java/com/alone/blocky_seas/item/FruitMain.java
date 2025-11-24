package com.alone.blocky_seas.item;

import net.minecraft.world.item.Item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;


public class FruitMain extends Item
{

	public FruitMain(Properties pProperties)
	{super(pProperties);}

	@Override
    public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
package com.alone.blocky_seas.item.fruits;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import java.util.List;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.LivingEntity;

import com.alone.blocky_seas.procedures.FruitBombPlayerFinishesUsingItemProcedure;



import net.minecraft.network.chat.Component;



public class FruitBombItem extends FruitMain {

	public FruitBombItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f).alwaysEat().build()));

	}

	
	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		FruitBombPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
		return retval;
	}



	
	

	

	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced)
	{
		pTooltipComponents.add(Component.translatable("tooltip.blocky_seas.common.tooltip").withStyle(ChatFormatting.GRAY));
		pTooltipComponents.add(Component.translatable("tooltip.blocky_seas.paramecia.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        pTooltipComponents.add(Component.translatable("tooltip.blocky_seas.fruit.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
	}
	
}
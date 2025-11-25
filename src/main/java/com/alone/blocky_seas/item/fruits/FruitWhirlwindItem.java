package com.alone.blocky_seas.item.fruits;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import java.util.List;

public class FruitWhirlwindItem extends FruitMain {
	public FruitWhirlwindItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		com.alone.blocky_seas.procedures.FruitWhirlwindPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
		return retval;
	}

	@Override
	public void appendHoverText(ItemStack pStack, Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
		pTooltipComponents.add(Component.translatable("tooltip.blocky_seas.legendary.tooltip").withStyle(ChatFormatting.GOLD));
		pTooltipComponents.add(Component.translatable("tooltip.blocky_seas.logia.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
		pTooltipComponents.add(Component.translatable("tooltip.blocky_seas.fruit.tooltip"));
		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
	}
}
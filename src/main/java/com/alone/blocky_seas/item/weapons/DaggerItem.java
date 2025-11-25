package com.alone.blocky_seas.item.weapons;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.antlr.v4.runtime.misc.NotNull;

import javax.annotation.Nullable;

import java.util.List;

public class DaggerItem extends SwordItem {

	public DaggerItem() {
		super(new Tier() {
			@Override
			public int getUses() {
				return 125;
			}

			@Override
			public float getSpeed() {
				return 0f;
			}

			@Override
			public float getAttackDamageBonus() {
				return 0f;
			}

			@Override
			public int getLevel() {
				return 2;
			}

			@Override
			public int getEnchantmentValue() {
				return 14;
			}

			@Override
			public @NotNull Ingredient getRepairIngredient() {
				return Ingredient.of(Items.IRON_NUGGET);
			}
		}, 3, 3, new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
		pTooltipComponents.add(Component.translatable("tooltip.blocky_seas.common.tooltip").withStyle(ChatFormatting.GRAY));
//        pTooltipComponents.add(Component.translatable("tooltip.onecraft.cutlass.tooltip"));
		super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
	}
}

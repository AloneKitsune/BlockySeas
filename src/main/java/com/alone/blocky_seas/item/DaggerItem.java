package com.alone.blocky_seas.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DaggerItem extends Item {
	public DaggerItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}
}
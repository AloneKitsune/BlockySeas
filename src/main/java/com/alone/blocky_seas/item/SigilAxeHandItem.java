package com.alone.blocky_seas.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SigilAxeHandItem extends Item {
	public SigilAxeHandItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
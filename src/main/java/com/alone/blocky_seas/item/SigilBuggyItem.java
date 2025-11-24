package com.alone.blocky_seas.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SigilBuggyItem extends Item {
	public SigilBuggyItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}
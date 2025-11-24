/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package com.alone.blocky_seas.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.food.FoodProperties;

import com.alone.blocky_seas.item.WhiteBerry;
import com.alone.blocky_seas.item.SigilBuggyItem;
import com.alone.blocky_seas.item.SigilAxeHandItem;
import com.alone.blocky_seas.item.SeaprismShardItem;
import com.alone.blocky_seas.item.FruitWhirlwindItem;
import com.alone.blocky_seas.item.FruitSculkItem;
import com.alone.blocky_seas.item.FruitGameItem;
import com.alone.blocky_seas.item.FruitBombItem;
import com.alone.blocky_seas.item.DarkrootItem;
import com.alone.blocky_seas.item.DaggerItem;
import com.alone.blocky_seas.item.CutlassItem;
import com.alone.blocky_seas.BlockySeas;

public class BlockySeasItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BlockySeas.MOD_ID);
	public static final RegistryObject<Item> FRUIT_WHIRLWIND = REGISTRY.register("fruit_whirlwind", () -> new FruitWhirlwindItem());
	public static final RegistryObject<Item> DARKROOT = REGISTRY.register("darkroot", () -> new DarkrootItem());
	public static final RegistryObject<Item> FRUIT_BOMB = REGISTRY.register("fruit_bomb", () -> new FruitBombItem());
	public static final RegistryObject<Item> FRUIT_SCULK = REGISTRY.register("fruit_sculk", () -> new FruitSculkItem());
	public static final RegistryObject<Item> SIGIL_BUGGY = REGISTRY.register("sigil_buggy", () -> new SigilBuggyItem());
	public static final RegistryObject<Item> SIGIL_AXEHAND = REGISTRY.register("sigil_axehand", () -> new SigilAxeHandItem());
	public static final RegistryObject<Item> SIGIL_ALTER = block(BlockySeasBlocks.SIGIL_ALTER, new Item.Properties().rarity(Rarity.EPIC));
	public static final RegistryObject<Item> CUTLASS = REGISTRY.register("cutlass", () -> new CutlassItem());
	public static final RegistryObject<Item> DAGGER = REGISTRY.register("dagger", () -> new DaggerItem());
	public static final RegistryObject<Item> SEAPRISM_SHARD = REGISTRY.register("seaprism_shard", () -> new SeaprismShardItem());
	public static final RegistryObject<Item> FRUIT_GAME = REGISTRY.register("fruit_game", () -> new FruitGameItem());

	public static final RegistryObject<Item> BERRY_BUSH = block(BlockySeasBlocks.BERRY_BUSH, new Item.Properties());
	public static final RegistryObject<Item> RED_BERRY = REGISTRY.register("red_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> ORANGE_BERRY = REGISTRY.register("orange_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> YELLOW_BERRY = REGISTRY.register("yellow_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> GREEN_BERRY = REGISTRY.register("green_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> BLUE_BERRY = REGISTRY.register("blue_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> PURPLE_BERRY = REGISTRY.register("purple_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> PINK_BERRY = REGISTRY.register("pink_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> WHITE_BERRY = REGISTRY.register("white_berry", () -> new WhiteBerry(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));
	public static final RegistryObject<Item> BLACK_BERRY = REGISTRY.register("black_berry", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(.4f).fast().build())));

	public static final RegistryObject<Item> FOOLS_IRON_BLOCK = block(BlockySeasBlocks.FOOLS_IRON_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_GOLD_BLOCK = block(BlockySeasBlocks.FOOLS_GOLD_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_COPPER_BLOCK = block(BlockySeasBlocks.FOOLS_COPPER_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_DIAMOND_BLOCK = block(BlockySeasBlocks.FOOLS_DIAMOND_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_EMERALD_BLOCK = block(BlockySeasBlocks.FOOLS_EMERALD_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_LAPIS_BLOCK = block(BlockySeasBlocks.FOOLS_LAPIS_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_COAL_BLOCK = block(BlockySeasBlocks.FOOLS_COAL_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_REDSTONE_BLOCK = block(BlockySeasBlocks.FOOLS_REDSTONE_BLOCK, new Item.Properties());
	public static final RegistryObject<Item> FOOLS_NETHERITE_BLOCK = block(BlockySeasBlocks.FOOLS_NETHERITE_BLOCK, new Item.Properties());


	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}
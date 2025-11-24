/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package com.alone.blocky_seas.init;

import com.alone.blocky_seas.block.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import com.alone.blocky_seas.BlockySeas;

public class BlockySeasBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BlockySeas.MOD_ID);
	public static final RegistryObject<Block> SIGIL_ALTER = REGISTRY.register("sigil_alter", () -> new SigilAlterBlock());
	public static final RegistryObject<Block> BUGGY_SIGIL_ALTER = REGISTRY.register("buggy_sigil_alter", () -> new BuggySigilAlterBlock());
	public static final RegistryObject<Block> AXEHAND_SIGIL_ALTER = REGISTRY.register("axehand_sigil_alter", () -> new AxehandAlterBlock());
	public static final RegistryObject<Block> BERRY_BUSH = REGISTRY.register("berry_bush", () -> new BerryBush());

	public static final RegistryObject<Block> FOOLS_IRON_BLOCK = REGISTRY.register("fools_iron_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
	public static final RegistryObject<Block> FOOLS_GOLD_BLOCK = REGISTRY.register("fools_gold_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));
	public static final RegistryObject<Block> FOOLS_COPPER_BLOCK = REGISTRY.register("fools_copper_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
	public static final RegistryObject<Block> FOOLS_DIAMOND_BLOCK = REGISTRY.register("fools_diamond_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
	public static final RegistryObject<Block> FOOLS_EMERALD_BLOCK = REGISTRY.register("fools_emerald_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK)));
	public static final RegistryObject<Block> FOOLS_LAPIS_BLOCK = REGISTRY.register("fools_lapis_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK)));
	public static final RegistryObject<Block> FOOLS_COAL_BLOCK = REGISTRY.register("fools_coal_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));
	public static final RegistryObject<Block> FOOLS_REDSTONE_BLOCK = REGISTRY.register("fools_redstone_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.REDSTONE_BLOCK)));
	public static final RegistryObject<Block> FOOLS_NETHERITE_BLOCK = REGISTRY.register("fools_netherite_block", () -> new FoolsBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));



	// temp
	public static final RegistryObject<Block> TEMPPORTAL = REGISTRY.register("tempportal", () -> new TempportalBlock());
}
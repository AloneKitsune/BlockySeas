/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.alone.blocky_seas.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;

import com.alone.blocky_seas.block.entity.BuggySigilAlterBlockEntity;
import com.alone.blocky_seas.block.entity.AxehandAlterBlockEntity;
import com.alone.blocky_seas.BlockySeas;

public class BlockySeasBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BlockySeas.MOD_ID);
	public static final RegistryObject<BlockEntityType<BuggySigilAlterBlockEntity>> BUGGY_SIGIL_ALTER = register("buggy_sigil_alter", BlockySeasBlocks.BUGGY_SIGIL_ALTER, BuggySigilAlterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<AxehandAlterBlockEntity>> AXEHAND_SIGIL_ALTER = register("axehand_sigil_alter", BlockySeasBlocks.AXEHAND_SIGIL_ALTER, AxehandAlterBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
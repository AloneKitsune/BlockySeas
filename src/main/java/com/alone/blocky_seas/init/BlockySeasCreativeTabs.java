package com.alone.blocky_seas.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import com.alone.blocky_seas.BlockySeas;

public class BlockySeasCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BlockySeas.MOD_ID);
    public static final RegistryObject<CreativeModeTab> BLOCKYSEAS = REGISTRY.register("blocky_seas",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.blocky_seas.blocky_seas")).icon(() -> new ItemStack(BlockySeasItems.SIGIL_BUGGY.get())).displayItems((parameters, tabData) -> {
                tabData.accept(BlockySeasItems.DARKROOT.get());
                tabData.accept(BlockySeasItems.FRUIT_WHIRLWIND.get());
                tabData.accept(BlockySeasItems.FRUIT_BOMB.get());
                tabData.accept(BlockySeasItems.FRUIT_SCULK.get());
                tabData.accept(BlockySeasItems.FRUIT_GAME.get());
                tabData.accept(BlockySeasItems.SIGIL_BUGGY.get());
                tabData.accept(BlockySeasItems.SIGIL_AXEHAND.get());
                tabData.accept(BlockySeasItems.SIGIL_ALTER.get());
                tabData.accept(BlockySeasItems.CUTLASS.get());
                tabData.accept(BlockySeasItems.DAGGER.get());
                tabData.accept(BlockySeasItems.SEAPRISM_SHARD.get());
                tabData.accept(BlockySeasItems.BERRY_BUSH.get());
                tabData.accept(BlockySeasItems.RED_BERRY.get());
                tabData.accept(BlockySeasItems.ORANGE_BERRY.get());
                tabData.accept(BlockySeasItems.YELLOW_BERRY.get());
                tabData.accept(BlockySeasItems.GREEN_BERRY.get());
                tabData.accept(BlockySeasItems.BLUE_BERRY.get());
                tabData.accept(BlockySeasItems.PURPLE_BERRY.get());
                tabData.accept(BlockySeasItems.PINK_BERRY.get());
                tabData.accept(BlockySeasItems.WHITE_BERRY.get());
                tabData.accept(BlockySeasItems.BLACK_BERRY.get());

                tabData.accept(BlockySeasItems.FOOLS_IRON_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_GOLD_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_COPPER_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_DIAMOND_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_EMERALD_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_LAPIS_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_COAL_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_REDSTONE_BLOCK.get());
                tabData.accept(BlockySeasItems.FOOLS_NETHERITE_BLOCK.get());
            }).build());
}
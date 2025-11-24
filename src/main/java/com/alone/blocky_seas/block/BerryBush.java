package com.alone.blocky_seas.block;

import com.alone.blocky_seas.BlockySeas;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;


import javax.annotation.Nullable;
import java.util.Random;



public class BerryBush extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);
    private static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(4, 0, 4, 12, 7, 12),  // age 0
            Block.box(3, 0, 3, 13, 10, 13),  // age 1
            Block.box(1, 0, 1, 15, 13.5, 15), // age 2
            Block.box(1, 0, 1, 15, 13.5, 15)  // age 3
    };
    private final static SoundEvent Sound = SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES;

    public BerryBush() {
        super(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).sound(SoundType.SWEET_BERRY_BUSH).noCollission().noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int i = pState.getValue(AGE);
        boolean flag = i == 3;

        if (!flag && pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;

        } else if (i > 1) {
            if(pState.getValue(AGE)==3) {
                if (!pLevel.isClientSide && pState.getValue(AGE) == 3) {
                    getLootTable(pLevel, pPlayer, pPos, pState); // only run on server
                    pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
                    BlockState newState = pState.setValue(AGE, 2);
                    pLevel.setBlock(pPos, newState, 2);
                    pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, newState));
                }
                return InteractionResult.sidedSuccess(pLevel.isClientSide);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(AGE)];
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        int i = pState.getValue(AGE);
        if (i < 3 && pLevel.getRawBrightness(pPos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt(25) == 0)) {
            BlockState blockstate = pState.setValue(AGE, Integer.valueOf(i + 1));
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(blockstate));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
        }

    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
        return state.getValue(AGE) < 3;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        int age = state.getValue(AGE);
        if (age < 3) {
            world.setBlock(pos, state.setValue(AGE, age + 1), 2);
        }
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        int age = state.getValue(AGE);
        if (!world.isClientSide && age == 3) {
            getLootTable(world,player,pos,state);
        }
        super.playerDestroy(world, player, pos, state, blockEntity, tool);
    }

    public void getLootTable(Level world, Player player, BlockPos pos, BlockState state) {
        ServerLevel serverLevel = (ServerLevel) world;

        LootParams.Builder paramsBuilder = new LootParams.Builder(serverLevel)
                .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                .withParameter(LootContextParams.BLOCK_STATE, state)
                .withParameter(LootContextParams.TOOL, player.getMainHandItem())
                .withParameter(LootContextParams.THIS_ENTITY, player);

        for (int count = 0; count < 2; count++)
        {
            LootTable lootTable;
            ResourceLocation lootTableId;
            Random random = new Random();
            if(random.nextInt(400) == 0)
            {
                lootTableId = new ResourceLocation(BlockySeas.MOD_ID, "strangefruits/strange_fruits");
                lootTable = serverLevel.getServer().getLootData().getLootTable(lootTableId);
            }
            else
            {
                lootTableId = new ResourceLocation(BlockySeas.MOD_ID, "special_blocks/berry_bush");
                lootTable = serverLevel.getServer().getLootData().getLootTable(lootTableId);
            }

            for (ItemStack drop : lootTable.getRandomItems(paramsBuilder.create(LootContextParamSets.BLOCK)))
            {
            popResource(serverLevel, pos, drop);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}

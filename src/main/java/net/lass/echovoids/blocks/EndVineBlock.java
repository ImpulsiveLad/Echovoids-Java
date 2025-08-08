package net.lass.echovoids.blocks;

import net.lass.echovoids.init.EchovoidsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EndVineBlock extends GrowingPlantHeadBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

    public EndVineBlock(BlockBehaviour.Properties state) {
        super(state, Direction.UP, SHAPE, false, 0.05D);
    }

    protected int getBlocksToGrowWhenBonemealed(RandomSource source) {
        return NetherVines.getBlocksToGrowWhenBonemealed(source);
    }

    protected Block getBodyBlock() {
        return EchovoidsBlocks.END_VINE_PLANT.get();
    }

    protected boolean canGrowInto(BlockState state) {
        return NetherVines.isValidGrowthState(state);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(AGE) < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos.relative(this.growthDirection), pLevel.getBlockState(pPos.relative(this.growthDirection)),pRandom.nextDouble() < 0.1D)) {
            BlockPos blockpos = pPos.relative(this.growthDirection);
            if (this.canGrowInto(pLevel.getBlockState(blockpos))) {
                pLevel.setBlockAndUpdate(blockpos, this.getGrowIntoState(pState, pLevel.random));
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, blockpos, pLevel.getBlockState(blockpos));
            }
        }
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.relative(this.growthDirection.getOpposite());
        BlockState belowState = level.getBlockState(belowPos);
        Block belowBlock = belowState.getBlock();

        return belowBlock == EchovoidsBlocks.YELLOW_LOG.get()
                || belowBlock == EchovoidsBlocks.YELLOW_WOOD.get()
                || belowBlock == EchovoidsBlocks.YELLOW_LEAVES.get()
                || belowBlock == EchovoidsBlocks.END_VINE.get()
                        || belowBlock == EchovoidsBlocks.END_VINE_PLANT.get();
    }
}
package net.lass.echovoids.blocks;

import net.lass.echovoids.init.EchovoidsBlocks;
import net.lass.echovoids.init.EchovoidsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class EndflowerBlock extends TallFlowerBlock {
    public EndflowerBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        Block belowBlock = belowState.getBlock();

        return belowBlock == EchovoidsBlocks.END_GRASS.get()
                || belowBlock == EchovoidsBlocks.ENDFLOWER.get();
    }
}

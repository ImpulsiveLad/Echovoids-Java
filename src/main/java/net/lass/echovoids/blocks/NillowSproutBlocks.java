package net.lass.echovoids.blocks;

import net.lass.echovoids.init.EchovoidsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class NillowSproutBlocks extends FlowerBlock {
    public NillowSproutBlocks(java.util.function.Supplier<MobEffect> effectSupplier, int pEffectDuration, BlockBehaviour.Properties pProperties) {
        super(effectSupplier, pEffectDuration, pProperties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        Block belowBlock = belowState.getBlock();

        return belowBlock == EchovoidsBlocks.END_GRASS.get();
    }
}

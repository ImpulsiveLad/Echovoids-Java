package net.lass.echovoids.features;

import com.mojang.serialization.Codec;
import net.lass.echovoids.init.EchovoidsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class megaGlowTube extends Feature<NoneFeatureConfiguration> {

    public megaGlowTube(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel world = context.level();
        RandomSource rand = context.random();
        BlockPos origin = context.origin();

        int placed = 0;
        int height = 8 + rand.nextInt(5);
        int currentHeight = 0;

        BlockPos currentPos = origin;
        boolean lastHadBranch = false;
        Direction.Axis previousaxis = null;

        for (int i = 0; i < height; i++) {
            if (!world.isEmptyBlock(currentPos)) break;

            boolean isHoles = rand.nextFloat() < 0.3f;
            BlockState blockToPlace = isHoles
                    ? EchovoidsBlocks.GLOWBUSH_HOLES.get().defaultBlockState()
                    : EchovoidsBlocks.GLOWBUSH.get().defaultBlockState();

            world.setBlock(currentPos, blockToPlace, 2);
            currentHeight++;
            placed++;

            if (i > 0 && !lastHadBranch && rand.nextFloat() < 0.9f) {
                Direction dir;
                if (previousaxis == Direction.Axis.X) {
                    dir = rand.nextBoolean() ? Direction.NORTH : Direction.SOUTH;
                } else if (previousaxis == Direction.Axis.Z) {
                    dir = rand.nextBoolean() ? Direction.EAST : Direction.WEST;
                } else {
                    dir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                }

                Direction.Axis axis = (dir == Direction.EAST || dir == Direction.WEST) ? Direction.Axis.X : Direction.Axis.Z;
                previousaxis = axis;

                int branchLength = 1;
                if (currentHeight >= 6) {
                    branchLength = 2 + rand.nextInt(2);
                }

                BlockPos branchPos = currentPos;
                boolean branchPlaced = false;

                for (int j = 0; j < branchLength; j++) {
                    branchPos = branchPos.relative(dir);
                    if (!world.isEmptyBlock(branchPos)) break;

                    boolean branchIsHoles = rand.nextFloat() < 0.3f;
                    BlockState branchBlock = branchIsHoles
                            ? EchovoidsBlocks.GLOWBUSH_HOLES.get().defaultBlockState()
                            : EchovoidsBlocks.GLOWBUSH.get().defaultBlockState();

                    branchBlock = branchBlock.setValue(RotatedPillarBlock.AXIS, axis);
                    world.setBlock(branchPos, branchBlock, 2);
                    currentHeight++;
                    placed++;
                    branchPlaced = true;
                }

                lastHadBranch = branchPlaced;
            } else {
                lastHadBranch = false;
            }

            currentPos = currentPos.above();
        }

        return placed > 0;
    }
}

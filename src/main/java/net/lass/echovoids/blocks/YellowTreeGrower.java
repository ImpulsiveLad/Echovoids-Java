package net.lass.echovoids.blocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static net.lass.echovoids.EchovoidsMod.MODID;

public class YellowTreeGrower extends AbstractTreeGrower {

    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource state, boolean bool) {
        ResourceKey<ConfiguredFeature<?, ?>> featureKey = ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                new ResourceLocation(MODID, "tree")
        );

        return featureKey;
    }
}
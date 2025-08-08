package net.lass.echovoids.init;

import net.lass.echovoids.features.megaGlowTube;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.lass.echovoids.EchovoidsMod.MODID;

public class EchovoidsFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MEGA_GLOW_TUBE = FEATURES.register("mega_glow_tube", () -> new megaGlowTube(NoneFeatureConfiguration.CODEC));
}

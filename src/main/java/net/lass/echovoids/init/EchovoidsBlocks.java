package net.lass.echovoids.init;

import net.lass.echovoids.blocks.*;
import net.lass.echovoids.blocks.YellowTreeGrower;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.lass.echovoids.EchovoidsMod.MODID;
import static net.minecraft.world.level.block.state.BlockBehaviour.*;

public class EchovoidsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> CORRODED_ENDSTONE = BLOCKS.register("corroded_endstone", () -> new Block(Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(3.0F, 9.0F)));
    public static final RegistryObject<Block> CORRODE_STONE = BLOCKS.register("corrode_stone", () -> new Block(Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(3.0F, 9.0F)));

    public static final RegistryObject<Block> GLOWBUSH = BLOCKS.register("glowbush", () -> new RotatedPillarBlock(Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STEM).instrument(NoteBlockInstrument.BASS).strength(1.0F,10.0F).lightLevel(state -> 15)));
    public static final RegistryObject<Block> GLOWBUSH_HOLES = BLOCKS.register("glowbush_holes", () -> new RotatedPillarBlock(Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STEM).instrument(NoteBlockInstrument.BASS).strength(1.0F,10.0F).lightLevel(state -> 15)));

    public static final RegistryObject<Block> YELLOW_WOOD = BLOCKS.register("yellow_wood", () -> new RotatedPillarBlock(Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F)));
    public static final RegistryObject<Block> YELLOW_LOG = BLOCKS.register("yellow_log", () -> new RotatedPillarBlock(Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.0F)));
    public static final RegistryObject<Block> YELLOW_LEAVES = BLOCKS.register("yellow_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false)));

    public static final RegistryObject<Block> YELLOW_PLANKS = BLOCKS.register("yellow_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> YELLOW_STAIRS = BLOCKS.register("yellow_stairs", () -> new StairBlock(YELLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(YELLOW_PLANKS.get())));
    public static final RegistryObject<Block> YELLOW_SLAB = BLOCKS.register("yellow_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(YELLOW_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> YELLOW_FENCE = BLOCKS.register("yellow_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(YELLOW_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> YELLOW_FENCE_GATE = BLOCKS.register("yellow_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(YELLOW_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F), WoodType.OAK));
    public static final RegistryObject<Block> YELLOW_PRESSURE_PLATE = BLOCKS.register("yellow_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(YELLOW_PLANKS.get().defaultMapColor()).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Block> YELLOW_BUTTON = BLOCKS.register("yellow_button", () -> woodenButton(BlockSetType.OAK));
    public static final RegistryObject<Block> YELLOW_DOOR = BLOCKS.register("yellow_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(YELLOW_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY), BlockSetType.OAK));
    public static final RegistryObject<Block> YELLOW_TRAPDOOR = BLOCKS.register("yellow_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(YELLOW_PLANKS.get().defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn((state, level, pos, entityType) -> false), BlockSetType.OAK));

    public static final RegistryObject<Block> END_GRASS = BLOCKS.register("end_grass", () -> new Block(Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(3.0F, 9.0F)));
    public static final RegistryObject<Block> ENDFLOWER = BLOCKS.register("endflower", () -> new EndflowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).lightLevel(state -> 7)));
    public static final RegistryObject<Block> ENDGRASSPLANT = BLOCKS.register("endgrassplant", () -> new NillowSproutBlocks(() -> MobEffects.NIGHT_VISION, 8, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TALL_ENDGRASSPLANT = BLOCKS.register("tall_endgrassplant", () -> new NillowSproutBlocks(() -> MobEffects.NIGHT_VISION, 8, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> END_VINE = BLOCKS.register("end_vine", () -> new EndVineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).randomTicks().noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY).lightLevel(state -> 7)));
    public static final RegistryObject<Block> END_VINE_PLANT = BLOCKS.register("end_vine_plant", () -> new EndVinePlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().instabreak().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> YELLOW_SAPLING = BLOCKS.register("yellow_sapling", () -> new YellowSaplingBlock(new YellowTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    private static ButtonBlock woodenButton(BlockSetType pSetType, FeatureFlag... pRequiredFeatures) {
        BlockBehaviour.Properties blockbehaviour$properties = BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
        if (pRequiredFeatures.length > 0) {
            blockbehaviour$properties = blockbehaviour$properties.requiredFeatures(pRequiredFeatures);
        }

        return new ButtonBlock(blockbehaviour$properties, pSetType, 30, true);
    }
}
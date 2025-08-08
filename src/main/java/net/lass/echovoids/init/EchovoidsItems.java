package net.lass.echovoids.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.lass.echovoids.EchovoidsMod.MODID;

public class EchovoidsItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> CORRODED_ENDSTONE = block(EchovoidsBlocks.CORRODED_ENDSTONE);
    public static final RegistryObject<Item> CORRODE_STONE = block(EchovoidsBlocks.CORRODE_STONE);

    public static final RegistryObject<Item> GLOWBUSH = block(EchovoidsBlocks.GLOWBUSH);
    public static final RegistryObject<Item> GLOWBUSH_HOLES = block(EchovoidsBlocks.GLOWBUSH_HOLES);

    public static final RegistryObject<Item> YELLOW_WOOD = block(EchovoidsBlocks.YELLOW_WOOD);
    public static final RegistryObject<Item> YELLOW_LOG = block(EchovoidsBlocks.YELLOW_LOG);
    public static final RegistryObject<Item> YELLOW_LEAVES = block(EchovoidsBlocks.YELLOW_LEAVES);

    public static final RegistryObject<Item> YELLOW_PLANKS = block(EchovoidsBlocks.YELLOW_PLANKS);
    public static final RegistryObject<Item> YELLOW_STAIRS = block(EchovoidsBlocks.YELLOW_STAIRS);
    public static final RegistryObject<Item> YELLOW_SLAB = block(EchovoidsBlocks.YELLOW_SLAB);
    public static final RegistryObject<Item> YELLOW_FENCE = block(EchovoidsBlocks.YELLOW_FENCE);
    public static final RegistryObject<Item> YELLOW_FENCE_GATE = block(EchovoidsBlocks.YELLOW_FENCE_GATE);
    public static final RegistryObject<Item> YELLOW_PRESSURE_PLATE = block(EchovoidsBlocks.YELLOW_PRESSURE_PLATE);
    public static final RegistryObject<Item> YELLOW_BUTTON = block(EchovoidsBlocks.YELLOW_BUTTON);
    public static final RegistryObject<Item> YELLOW_DOOR = doubleBlock(EchovoidsBlocks.YELLOW_DOOR);
    public static final RegistryObject<Item> YELLOW_TRAPDOOR = block(EchovoidsBlocks.YELLOW_TRAPDOOR);

    public static final RegistryObject<Item> END_GRASS = block(EchovoidsBlocks.END_GRASS);
    public static final RegistryObject<Item> ENDFLOWER = doubleBlock(EchovoidsBlocks.ENDFLOWER);
    public static final RegistryObject<Item> ENDGRASSPLANT = block(EchovoidsBlocks.ENDGRASSPLANT);
    public static final RegistryObject<Item> TALL_ENDGRASSPLANT = block(EchovoidsBlocks.TALL_ENDGRASSPLANT);

    public static final RegistryObject<Item> END_VINE = block(EchovoidsBlocks.END_VINE);
    public static final RegistryObject<Item> YELLOW_SAPLING = block(EchovoidsBlocks.YELLOW_SAPLING);

    private static RegistryObject<Item> block(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
    }
}
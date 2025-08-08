package net.lass.echovoids.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;

import static net.lass.echovoids.EchovoidsMod.MODID;

@EventBusSubscriber(
        bus = Bus.MOD
)
public class EchovoidsTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY;

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            tabData.accept(EchovoidsItems.CORRODED_ENDSTONE.get());
            tabData.accept(EchovoidsItems.CORRODE_STONE.get());
            tabData.accept(EchovoidsItems.GLOWBUSH.get());
            tabData.accept(EchovoidsItems.GLOWBUSH_HOLES.get());
            tabData.accept(EchovoidsItems.YELLOW_LOG.get());
            tabData.accept(EchovoidsItems.YELLOW_LEAVES.get());
            tabData.accept(EchovoidsItems.END_GRASS.get());
            tabData.accept(EchovoidsItems.ENDFLOWER.get());
            tabData.accept(EchovoidsItems.ENDGRASSPLANT.get());
            tabData.accept(EchovoidsItems.TALL_ENDGRASSPLANT.get());
            tabData.accept(EchovoidsItems.END_VINE.get());
            tabData.accept(EchovoidsItems.YELLOW_SAPLING.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            tabData.accept(EchovoidsItems.YELLOW_WOOD.get());
            tabData.accept(EchovoidsItems.YELLOW_LOG.get());
            tabData.accept(EchovoidsItems.YELLOW_PLANKS.get());
            tabData.accept(EchovoidsItems.YELLOW_STAIRS.get());
            tabData.accept(EchovoidsItems.YELLOW_SLAB.get());
            tabData.accept(EchovoidsItems.YELLOW_FENCE.get());
            tabData.accept(EchovoidsItems.YELLOW_FENCE_GATE.get());
            tabData.accept(EchovoidsItems.YELLOW_PRESSURE_PLATE.get());
            tabData.accept(EchovoidsItems.YELLOW_BUTTON.get());
            tabData.accept(EchovoidsItems.YELLOW_DOOR.get());
            tabData.accept(EchovoidsItems.YELLOW_TRAPDOOR.get());
        }
    }

    static {
        REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    }
}
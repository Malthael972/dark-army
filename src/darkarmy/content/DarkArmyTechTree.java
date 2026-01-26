package darkarmy.content;

import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.TechTree;
import mindustry.type.ItemStack;

import static mindustry.content.TechTree.node;

public class DarkArmyTechTree {

    public static void load() {

        // === UNITS ===
        node(Blocks.coreBastion, DarkArmyUnits.darkStell, ItemStack.with(
                Items.beryllium, 120,
                Items.tungsten, 80,
                Items.silicon, 60
        ), () -> {});

        // === BLOCKS ===
        node(Blocks.coreBastion, DarkArmyBlocks.darkTankFabricator, ItemStack.with(
                Items.beryllium, 200,
                Items.tungsten, 150,
                Items.oxide, 50
        ), () -> {

            node(DarkArmyBlocks.darkTankRefabricator, ItemStack.with(
                    Items.tungsten, 250,
                    Items.carbide, 120
            ), () -> {});
        });
    }
}

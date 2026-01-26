package darkarmy.content;

import mindustry.content.Blocks;
import mindustry.content.TechTree;
import mindustry.type.ItemStack;

import static mindustry.content.TechTree.node;

public class DarkArmyTechTree {

    public static void load() {

        TechTree.TechNode bastion = TechTree.get(Blocks.coreBastion);

        if (bastion == null) {
            throw new RuntimeException("Core Bastion tech node not found");
        }

        node(bastion, DarkArmyUnits.darkStell, ItemStack.with(
                mindustry.content.Items.beryllium, 120,
                mindustry.content.Items.tungsten, 80,
                mindustry.content.Items.silicon, 60
        ), () -> {});

        node(bastion, DarkArmyBlocks.darkTankFabricator, ItemStack.with(
                mindustry.content.Items.beryllium, 200,
                mindustry.content.Items.tungsten, 150,
                mindustry.content.Items.oxide, 50
        ), () -> {

            node(DarkArmyBlocks.darkTankRefabricator, ItemStack.with(
                    mindustry.content.Items.tungsten, 250,
                    mindustry.content.Items.carbide, 120
            ), () -> {});
        });
    }
}

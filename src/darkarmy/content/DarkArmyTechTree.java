package darkarmy.content;

import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.game.TechTree;

import static mindustry.game.TechTree.node;

public class DarkArmyTechTree {

    public static void load() {

        // Attach to Erekir campaign tech tree
        TechTree.TechNode erekirRoot = Planets.erekir.techTree;

        // Find Core: Bastion node
        TechTree.TechNode bastionNode = TechTree.getNode(Blocks.coreBastion);

        if (bastionNode == null) {
            throw new RuntimeException("Core Bastion tech node not found!");
        }

        // === UNITS ===
        node(bastionNode, DarkArmyUnits.darkStell, ItemStack.with(
                // example costs — adjust to taste
                mindustry.content.Items.beryllium, 120,
                mindustry.content.Items.tungsten, 80,
                mindustry.content.Items.silicon, 60
        ), () -> {

            // Optional: objectives
            // requires beating a sector, researching something else, etc.
            // objectives(
            //     new Objectives.SectorComplete(SectorPresets.basin)
            // );

        });

        // === BLOCKS (example) ===
        node(bastionNode, DarkArmyBlocks.darkTankFabricator, ItemStack.with(
                mindustry.content.Items.beryllium, 200,
                mindustry.content.Items.tungsten, 150,
                mindustry.content.Items.oxide, 50
        ), () -> {

            // Child node example
            node(DarkArmyBlocks.darkTankRefabricator, ItemStack.with(
                    mindustry.content.Items.tungsten, 250,
                    mindustry.content.Items.carbide, 120
            ), () -> {});
        });
    }
}

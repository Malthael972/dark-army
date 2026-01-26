package darkarmy.content;

import mindustry.content.Blocks;
import mindustry.content.Planets;
import mindustry.game.Objectives.OnPlanet;

import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {

    public static void load() {

        // Attach to Core Bastion (Erekir core)
        node(Blocks.coreBastion, () -> {

            // === DARK ARMY ROOT ===
            node(DarkArmyBlocks.darkBreach, () -> {

                // ---- BLOCKS ----
                node(DarkArmyBlocks.darkTankFabricator, () -> {});
                node(DarkArmyBlocks.darkTankRefabricator, () -> {});
                node(DarkArmyBlocks.darkMechFabricator, () -> {});
                node(DarkArmyBlocks.darkMechRefabricator, () -> {});
                node(DarkArmyBlocks.darkShipFabricator, () -> {});
                node(DarkArmyBlocks.darkShipRefabricator, () -> {});
                node(DarkArmyBlocks.darkPrimeRefabricator, () -> {});
                node(DarkArmyBlocks.darkTurbineCondenser, () -> {});
                node(DarkArmyBlocks.darkNode, () -> {});
            });

            // ---- UNITS ----
            node(DarkArmyUnits.darkStell, () -> {});
            node(DarkArmyUnits.darkLocus, () -> {});
            node(DarkArmyUnits.darkMerui, () -> {});
            node(DarkArmyUnits.darkCleroi, () -> {});
            node(DarkArmyUnits.darkQuell, () -> {});
            node(DarkArmyUnits.darkDisrupt, () -> {});
            node(DarkArmyUnits.darkPrecept, () -> {});
            node(DarkArmyUnits.darkAnthicus, () -> {});
        });
    }
}

package darkarmy.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.content.TechTree.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class DarkArmyTechTree {
    public static void load() {
        // Get Erekir's planet tech tree
        TechTree.TechNode erekir = TechTree.get(Planets.erekir);
        
        // Link your blocks into Erekir's tech tree
        // Example: Branch from tank fabricator
        nodeRoot("erekir", tankFabricator, () -> {
            node(DarkArmyBlocks.darkTankFabricator, () -> {
                node(DarkArmyBlocks.darkTankRefabricator, () -> {
                    // Further upgrades if needed
                });
            });
        });
        
        // Branch from mech fabricator
        nodeRoot("erekir", mechFabricator, () -> {
            node(DarkArmyBlocks.darkMechFabricator, () -> {
                node(DarkArmyBlocks.darkMechRefabricator, () -> {
                    // Further upgrades
                });
            });
        });
        
        // Branch from ship fabricator
        nodeRoot("erekir", shipFabricator, () -> {
            node(DarkArmyBlocks.darkShipFabricator, () -> {
                node(DarkArmyBlocks.darkShipRefabricator, () -> {
                    node(DarkArmyBlocks.darkPrimeRefabricator);
                });
            });
        });
    }
}

package darkarmy.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {
    
    public static void load() {
        // Add your units to vanilla tech tree
        
        // Tank units
        Blocks.tankFabricator.node(DarkArmyBlocks.darkTankFabricator, () -> {
            node(DarkArmyUnits.darkStell, () -> {});
        });
        
        UnitTypes.locus.node(DarkArmyUnits.darkLocus, () -> {});
        
        UnitTypes.precept.node(DarkArmyUnits.darkPrecept, () -> {});
        
        UnitTypes.vanquish.node(DarkArmyUnits.darkVanquish, () -> {});
        
        UnitTypes.conquer.node(DarkArmyUnits.darkConquer, () -> {});
        
        // Mech units
        Blocks.mechFabricator.node(DarkArmyBlocks.darkMechFabricator, () -> {
            node(DarkArmyUnits.darkMerui, () -> {});
        });
        
        UnitTypes.cleroi.node(DarkArmyUnits.darkCleroi, () -> {});
        
        UnitTypes.anthicus.node(DarkArmyUnits.darkAnthicus, () -> {});
        
        UnitTypes.tecta.node(DarkArmyUnits.darkTecta, () -> {});
        
        UnitTypes.collaris.node(DarkArmyUnits.darkCollaris, () -> {});
        
        // Ship units
        Blocks.shipFabricator.node(DarkArmyBlocks.darkShipFabricator, () -> {
            node(DarkArmyUnits.darkElude, () -> {});
        });
        
        UnitTypes.avert.node(DarkArmyUnits.darkAvert, () -> {});
        
        UnitTypes.obviate.node(DarkArmyUnits.darkObviate, () -> {});
        
        UnitTypes.quell.node(DarkArmyUnits.darkQuell, () -> {});
        
        UnitTypes.disrupt.node(DarkArmyUnits.darkDisrupt, () -> {});
        
        // Reconstructors
        Blocks.tankRefabricator.node(DarkArmyBlocks.darkTankRefabricator, () -> {});
        
        Blocks.mechRefabricator.node(DarkArmyBlocks.darkMechRefabricator, () -> {});
        
        Blocks.shipRefabricator.node(DarkArmyBlocks.darkShipRefabricator, () -> {});
        
        Blocks.primeRefabricator.node(DarkArmyBlocks.darkPrimeRefabricator, () -> {});
        
        // Power blocks
        Blocks.turbineCondenser.node(DarkArmyBlocks.darkTurbineCondenser, () -> {});
        
        Blocks.beamNode.node(DarkArmyBlocks.darkNode, () -> {});
    }
}


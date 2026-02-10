package darkarmy.content;

import arc.struct.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.ctype.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static darkarmy.content.DarkArmyBlocks.*;
import static darkarmy.content.DarkArmyUnits.*;

public class DarkArmyTechTree {

    public static void load() {
        // We need to manually create nodes and attach them to existing tech tree
        
        // Find turbine condenser node and add dark power
        TechNode turbineNode = turbineCondenser.techNode;
        if (turbineNode != null) {
            TechNode darkTurbineNode = new TechNode(turbineNode, darkTurbineCondenser, 
                darkTurbineCondenser.researchRequirements());
            darkTurbineNode.objectives.add(new OnSector(SectorPresets.aegis));
            
            TechNode darkNodeNode = new TechNode(darkTurbineNode, darkNode, 
                darkNode.researchRequirements());
        }
        
        // Find tank fabricator node and add dark tank line
        TechNode tankFabNode = tankFabricator.techNode;
        if (tankFabNode != null) {
            TechNode darkTankFabNode = new TechNode(tankFabNode, darkTankFabricator, 
                darkTankFabricator.researchRequirements());
            darkTankFabNode.objectives.add(new OnSector(SectorPresets.lake));
            
            // Add dark stell unit
            TechNode darkStellNode = new TechNode(darkTankFabNode, darkStell, 
                darkStell.researchRequirements());
            
            // Add dark tank refabricator
            TechNode darkTankRefabNode = new TechNode(darkTankFabNode, darkTankRefabricator, 
                darkTankRefabricator.researchRequirements());
            darkTankRefabNode.objectives.add(new OnSector(SectorPresets.marsh));
            
            // Add dark locus unit
            TechNode darkLocusNode = new TechNode(darkTankRefabNode, darkLocus, 
                darkLocus.researchRequirements());
            
            // Add dark prime refabricator
            TechNode darkPrimeRefabNode = new TechNode(darkTankRefabNode, darkPrimeRefabricator, 
                darkPrimeRefabricator.researchRequirements());
            darkPrimeRefabNode.objectives.add(new OnSector(SectorPresets.stronghold));
            
            // Add dark precept unit
            TechNode darkPreceptNode = new TechNode(darkPrimeRefabNode, darkPrecept, 
                darkPrecept.researchRequirements());
            
            // Add dark tank assembler
            TechNode darkTankAssemblerNode = new TechNode(darkTankRefabNode, darkTankAssembler, 
                darkTankAssembler.researchRequirements());
            darkTankAssemblerNode.objectives.add(new OnSector(SectorPresets.siege));
            darkTankAssemblerNode.objectives.add(new Research(Blocks.constructor));
            darkTankAssemblerNode.objectives.add(new Research(Blocks.atmosphericConcentrator));
            
            // Add dark vanquish and conquer
            TechNode darkVanquishNode = new TechNode(darkTankAssemblerNode, darkVanquish, 
                darkVanquish.researchRequirements());
            
            TechNode darkConquerNode = new TechNode(darkVanquishNode, darkConquer, 
                darkConquer.researchRequirements());
            darkConquerNode.objectives.add(new OnSector(SectorPresets.karst));
        }
        
        // Find mech fabricator node and add dark mech line
        TechNode mechFabNode = mechFabricator.techNode;
        if (mechFabNode != null) {
            TechNode darkMechFabNode = new TechNode(mechFabNode, darkMechFabricator, 
                darkMechFabricator.researchRequirements());
            darkMechFabNode.objectives.add(new OnSector(SectorPresets.intersect));
            
            // Add dark merui unit
            TechNode darkMeruiNode = new TechNode(darkMechFabNode, darkMerui, 
                darkMerui.researchRequirements());
            
            // Add dark mech refabricator
            TechNode darkMechRefabNode = new TechNode(darkMechFabNode, darkMechRefabricator, 
                darkMechRefabricator.researchRequirements());
            darkMechRefabNode.objectives.add(new OnSector(SectorPresets.basin));
            
            // Add dark cleroi unit
            TechNode darkCleroiNode = new TechNode(darkMechRefabNode, darkCleroi, 
                darkCleroi.researchRequirements());
            
            // Add dark mech assembler
            TechNode darkMechAssemblerNode = new TechNode(darkMechRefabNode, darkMechAssembler, 
                darkMechAssembler.researchRequirements());
            darkMechAssemblerNode.objectives.add(new OnSector(SectorPresets.crossroads));
            
            // Add dark tecta and collaris
            TechNode darkTectaNode = new TechNode(darkMechAssemblerNode, darkTecta, 
                darkTecta.researchRequirements());
            
            TechNode darkCollarisNode = new TechNode(darkTectaNode, darkCollaris, 
                darkCollaris.researchRequirements());
            darkCollarisNode.objectives.add(new OnSector(SectorPresets.karst));
            
            // Add anthicus to prime refabricator if it exists
            if (darkPrimeRefabricator.techNode != null) {
                TechNode darkAnthicusNode = new TechNode(darkPrimeRefabricator.techNode, darkAnthicus, 
                    darkAnthicus.researchRequirements());
            }
        }
        
        // Find ship fabricator node and add dark ship line
        TechNode shipFabNode = shipFabricator.techNode;
        if (shipFabNode != null) {
            TechNode darkShipFabNode = new TechNode(shipFabNode, darkShipFabricator, 
                darkShipFabricator.researchRequirements());
            darkShipFabNode.objectives.add(new OnSector(SectorPresets.lake));
            
            // Add dark elude unit
            TechNode darkEludeNode = new TechNode(darkShipFabNode, darkElude, 
                darkElude.researchRequirements());
            
            // Add dark ship refabricator
            TechNode darkShipRefabNode = new TechNode(darkShipFabNode, darkShipRefabricator, 
                darkShipRefabricator.researchRequirements());
            darkShipRefabNode.objectives.add(new OnSector(SectorPresets.peaks));
            
            // Add dark avert unit
            TechNode darkAvertNode = new TechNode(darkShipRefabNode, darkAvert, 
                darkAvert.researchRequirements());
            
            // Add obviate to prime refabricator if it exists
            if (darkPrimeRefabricator.techNode != null) {
                TechNode darkObviateNode = new TechNode(darkPrimeRefabricator.techNode, darkObviate, 
                    darkObviate.researchRequirements());
            }
            
            // Add dark ship assembler
            TechNode darkShipAssemblerNode = new TechNode(darkShipRefabNode, darkShipAssembler, 
                darkShipAssembler.researchRequirements());
            darkShipAssemblerNode.objectives.add(new OnSector(SectorPresets.crossroads));
            
            // Add dark quell and disrupt
            TechNode darkQuellNode = new TechNode(darkShipAssemblerNode, darkQuell, 
                darkQuell.researchRequirements());
            
            TechNode darkDisruptNode = new TechNode(darkQuellNode, darkDisrupt, 
                darkDisrupt.researchRequirements());
            darkDisruptNode.objectives.add(new OnSector(SectorPresets.karst));
        }
    }
}

package darkarmy.content;

import mindustry.content.*;
import mindustry.content.TechTree.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.UnitTypes.*;
import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {
    public static void load() {
        // Find the Erekir planet's tech tree root and add nodes to it
        TechNode erekirRoot = TechTree.all.find(t -> t.content == Planets.erekir);
        
        if(erekirRoot != null) {
            // Set context to the Erekir root temporarily
            TechNode prevContext = context();
            
            // Tank Units - add as children of vanilla tank units
            addAfter(stell, DarkArmyUnits.darkStell);
            addAfter(locus, DarkArmyUnits.darkLocus);
            addAfter(precept, DarkArmyUnits.darkPrecept);
            addAfter(vanquish, DarkArmyUnits.darkVanquish);
            addAfter(conquer, DarkArmyUnits.darkConquer);
            
            // Mech Units - add as children of vanilla mech units
            addAfter(merui, DarkArmyUnits.darkMerui);
            addAfter(cleroi, DarkArmyUnits.darkCleroi);
            addAfter(anthicus, DarkArmyUnits.darkAnthicus);
            addAfter(tecta, DarkArmyUnits.darkTecta);
            addAfter(collaris, DarkArmyUnits.darkCollaris);
            
            // Ship Units - add as children of vanilla ship units
            addAfter(elude, DarkArmyUnits.darkElude);
            addAfter(avert, DarkArmyUnits.darkAvert);
            addAfter(obviate, DarkArmyUnits.darkObviate);
            addAfter(quell, DarkArmyUnits.darkQuell);
            addAfter(disrupt, DarkArmyUnits.darkDisrupt);
            
            // Production Blocks - add as children of vanilla fabricators
            addAfter(tankFabricator, DarkArmyBlocks.darkTankFabricator);
            addAfter(DarkArmyBlocks.darkTankFabricator, DarkArmyBlocks.darkTankRefabricator);
            
            addAfter(mechFabricator, DarkArmyBlocks.darkMechFabricator);
            addAfter(DarkArmyBlocks.darkMechFabricator, DarkArmyBlocks.darkMechRefabricator);
            
            addAfter(shipFabricator, DarkArmyBlocks.darkShipFabricator);
            addAfter(DarkArmyBlocks.darkShipFabricator, DarkArmyBlocks.darkShipRefabricator);
            
            addAfter(primeRefabricator, DarkArmyBlocks.darkPrimeRefabricator);
        }
    }
    
    /** Adds a node as a child of the parent content's tech node. */
    private static void addAfter(mindustry.ctype.UnlockableContent parent, mindustry.ctype.UnlockableContent child) {
        // Find the parent's tech node
        TechNode parentNode = TechTree.all.find(t -> t.content == parent);
        if(parentNode == null) return;
        
        // Create a new tech node as a child of the parent
        TechNode node = new TechNode(parentNode, child, child.researchRequirements());
        
        // Copy research cost multipliers from parent if they exist
        if(parentNode.researchCostMultipliers != null) {
            node.researchCostMultipliers = parentNode.researchCostMultipliers;
        }
    }
}

package darkarmy.content;

import mindustry.content.*;
import mindustry.content.TechTree.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.UnitTypes.*;

public class DarkArmyTechTree {
    public static void load() {
        // Tank Units - parallel to vanilla tank line
        addToNode(stell, DarkArmyUnits.darkStell);
        addToNode(locus, DarkArmyUnits.darkLocus);
        addToNode(precept, DarkArmyUnits.darkPrecept);
        addToNode(vanquish, DarkArmyUnits.darkVanquish);
        addToNode(conquer, DarkArmyUnits.darkConquer);
        
        // Mech Units - parallel to vanilla mech line
        addToNode(merui, DarkArmyUnits.darkMerui);
        addToNode(cleroi, DarkArmyUnits.darkCleroi);
        addToNode(anthicus, DarkArmyUnits.darkAnthicus);
        addToNode(tecta, DarkArmyUnits.darkTecta);
        addToNode(collaris, DarkArmyUnits.darkCollaris);
        
        // Ship Units - parallel to vanilla ship line
        addToNode(elude, DarkArmyUnits.darkElude);
        addToNode(avert, DarkArmyUnits.darkAvert);
        addToNode(obviate, DarkArmyUnits.darkObviate);
        addToNode(quell, DarkArmyUnits.darkQuell);
        addToNode(disrupt, DarkArmyUnits.darkDisrupt);
        
        // Production Blocks - parallel to vanilla fabricators
        addToNode(tankFabricator, DarkArmyBlocks.darkTankFabricator);
        addToNode(DarkArmyBlocks.darkTankFabricator, DarkArmyBlocks.darkTankRefabricator);
        
        addToNode(mechFabricator, DarkArmyBlocks.darkMechFabricator);
        addToNode(DarkArmyBlocks.darkMechFabricator, DarkArmyBlocks.darkMechRefabricator);
        
        addToNode(shipFabricator, DarkArmyBlocks.darkShipFabricator);
        addToNode(DarkArmyBlocks.darkShipFabricator, DarkArmyBlocks.darkShipRefabricator);
        
        addToNode(primeRefabricator, DarkArmyBlocks.darkPrimeRefabricator);
    }
    
    private static void addToNode(mindustry.ctype.UnlockableContent parent, mindustry.ctype.UnlockableContent child) {
        TechNode parentNode = TechTree.all.find(t -> t.content == parent);
        if(parentNode == null) return;
        
        TechNode node = new TechNode(parentNode, child, child.researchRequirements());
        parentNode.children.add(node);
    }
}

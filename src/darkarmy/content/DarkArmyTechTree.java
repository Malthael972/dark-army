package darkarmy.content;

import mindustry.content.*;
import mindustry.content.TechTree.*;
import mindustry.game.Objectives.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.UnitTypes.*;
import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {
    public static void load() {
        // Tank Units - parallel to vanilla tank line
        TechNode stellNode = TechTree.all.find(t -> t.content == stell);
        if(stellNode != null) node(stellNode, DarkArmyUnits.darkStell, () -> {});
        
        TechNode locusNode = TechTree.all.find(t -> t.content == locus);
        if(locusNode != null) node(locusNode, DarkArmyUnits.darkLocus, () -> {});
        
        TechNode preceptNode = TechTree.all.find(t -> t.content == precept);
        if(preceptNode != null) node(preceptNode, DarkArmyUnits.darkPrecept, () -> {});
        
        TechNode vanquishNode = TechTree.all.find(t -> t.content == vanquish);
        if(vanquishNode != null) node(vanquishNode, DarkArmyUnits.darkVanquish, () -> {});
        
        TechNode conquerNode = TechTree.all.find(t -> t.content == conquer);
        if(conquerNode != null) node(conquerNode, DarkArmyUnits.darkConquer, () -> {});
        
        // Mech Units - parallel to vanilla mech line
        TechNode meruiNode = TechTree.all.find(t -> t.content == merui);
        if(meruiNode != null) node(meruiNode, DarkArmyUnits.darkMerui, () -> {});
        
        TechNode cleroiNode = TechTree.all.find(t -> t.content == cleroi);
        if(cleroiNode != null) node(cleroiNode, DarkArmyUnits.darkCleroi, () -> {});
        
        TechNode anthicusNode = TechTree.all.find(t -> t.content == anthicus);
        if(anthicusNode != null) node(anthicusNode, DarkArmyUnits.darkAnthicus, () -> {});
        
        TechNode tectaNode = TechTree.all.find(t -> t.content == tecta);
        if(tectaNode != null) node(tectaNode, DarkArmyUnits.darkTecta, () -> {});
        
        TechNode collarisNode = TechTree.all.find(t -> t.content == collaris);
        if(collarisNode != null) node(collarisNode, DarkArmyUnits.darkCollaris, () -> {});
        
        // Ship Units - parallel to vanilla ship line
        TechNode eludeNode = TechTree.all.find(t -> t.content == elude);
        if(eludeNode != null) node(eludeNode, DarkArmyUnits.darkElude, () -> {});
        
        TechNode avertNode = TechTree.all.find(t -> t.content == avert);
        if(avertNode != null) node(avertNode, DarkArmyUnits.darkAvert, () -> {});
        
        TechNode obviateNode = TechTree.all.find(t -> t.content == obviate);
        if(obviateNode != null) node(obviateNode, DarkArmyUnits.darkObviate, () -> {});
        
        TechNode quellNode = TechTree.all.find(t -> t.content == quell);
        if(quellNode != null) node(quellNode, DarkArmyUnits.darkQuell, () -> {});
        
        TechNode disruptNode = TechTree.all.find(t -> t.content == disrupt);
        if(disruptNode != null) node(disruptNode, DarkArmyUnits.darkDisrupt, () -> {});
        
        // Production Blocks - parallel to vanilla fabricators
        TechNode tankFabNode = TechTree.all.find(t -> t.content == tankFabricator);
        if(tankFabNode != null) {
            node(tankFabNode, DarkArmyBlocks.darkTankFabricator, () -> {
                node(DarkArmyBlocks.darkTankRefabricator, () -> {});
            });
        }
        
        TechNode mechFabNode = TechTree.all.find(t -> t.content == mechFabricator);
        if(mechFabNode != null) {
            node(mechFabNode, DarkArmyBlocks.darkMechFabricator, () -> {
                node(DarkArmyBlocks.darkMechRefabricator, () -> {});
            });
        }
        
        TechNode shipFabNode = TechTree.all.find(t -> t.content == shipFabricator);
        if(shipFabNode != null) {
            node(shipFabNode, DarkArmyBlocks.darkShipFabricator, () -> {
                node(DarkArmyBlocks.darkShipRefabricator, () -> {});
            });
        }
        
        TechNode primeRefabNode = TechTree.all.find(t -> t.content == primeRefabricator);
        if(primeRefabNode != null) {
            node(primeRefabNode, DarkArmyBlocks.darkPrimeRefabricator, () -> {});
        }
    }
}

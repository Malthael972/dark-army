package darkarmy.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.content.TechTree.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.UnitTypes.*;

public class DarkArmyTechTree {
    public static void load() {
        // Tank Units - parallel to vanilla tank line
        nodeRoot("erekir", stell, () -> {
            node(DarkArmyUnits.darkStell);
        });
        
        nodeRoot("erekir", locus, () -> {
            node(DarkArmyUnits.darkLocus);
        });
        
        nodeRoot("erekir", precept, () -> {
            node(DarkArmyUnits.darkPrecept);
        });
        
        nodeRoot("erekir", vanquish, () -> {
            node(DarkArmyUnits.darkVanquish);
        });
        
        nodeRoot("erekir", conquer, () -> {
            node(DarkArmyUnits.darkConquer);
        });
        
        // Mech Units - parallel to vanilla mech line
        nodeRoot("erekir", merui, () -> {
            node(DarkArmyUnits.darkMerui);
        });
        
        nodeRoot("erekir", cleroi, () -> {
            node(DarkArmyUnits.darkCleroi);
        });
        
        nodeRoot("erekir", anthicus, () -> {
            node(DarkArmyUnits.darkAnthicus);
        });
        
        nodeRoot("erekir", tecta, () -> {
            node(DarkArmyUnits.darkTecta);
        });
        
        nodeRoot("erekir", collaris, () -> {
            node(DarkArmyUnits.darkCollaris);
        });
        
        // Ship Units - parallel to vanilla ship line
        nodeRoot("erekir", elude, () -> {
            node(DarkArmyUnits.darkElude);
        });
        
        nodeRoot("erekir", avert, () -> {
            node(DarkArmyUnits.darkAvert);
        });
        
        nodeRoot("erekir", obviate, () -> {
            node(DarkArmyUnits.darkObviate);
        });
        
        nodeRoot("erekir", quell, () -> {
            node(DarkArmyUnits.darkQuell);
        });
        
        nodeRoot("erekir", disrupt, () -> {
            node(DarkArmyUnits.darkDisrupt);
        });
        
        // Production Blocks - parallel to vanilla fabricators
        nodeRoot("erekir", tankFabricator, () -> {
            node(DarkArmyBlocks.darkTankFabricator, () -> {
                node(DarkArmyBlocks.darkTankRefabricator);
            });
        });
        
        nodeRoot("erekir", mechFabricator, () -> {
            node(DarkArmyBlocks.darkMechFabricator, () -> {
                node(DarkArmyBlocks.darkMechRefabricator);
            });
        });
        
        nodeRoot("erekir", shipFabricator, () -> {
            node(DarkArmyBlocks.darkShipFabricator, () -> {
                node(DarkArmyBlocks.darkShipRefabricator);
            });
        });
        
        nodeRoot("erekir", primeRefabricator, () -> {
            node(DarkArmyBlocks.darkPrimeRefabricator);
        });
    }
}

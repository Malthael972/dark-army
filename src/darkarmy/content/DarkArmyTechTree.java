package darkarmy.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.type.*;

import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {
    
    public static void load() {
        // Tank units
        node(Blocks.tankFabricator, () -> {
            node(DarkArmyBlocks.darkTankFabricator, () -> {
                node(DarkArmyUnits.darkStell, () -> {});
            });
        });
        
        node(UnitTypes.locus, () -> {
            node(DarkArmyUnits.darkLocus, () -> {});
        });
        
        node(UnitTypes.precept, () -> {
            node(DarkArmyUnits.darkPrecept, () -> {});
        });
        
        node(UnitTypes.vanquish, () -> {
            node(DarkArmyUnits.darkVanquish, () -> {});
        });
        
        node(UnitTypes.conquer, () -> {
            node(DarkArmyUnits.darkConquer, () -> {});
        });
        
        // Mech units
        node(Blocks.mechFabricator, () -> {
            node(DarkArmyBlocks.darkMechFabricator, () -> {
                node(DarkArmyUnits.darkMerui, () -> {});
            });
        });
        
        node(UnitTypes.cleroi, () -> {
            node(DarkArmyUnits.darkCleroi, () -> {});
        });
        
        node(UnitTypes.anthicus, () -> {
            node(DarkArmyUnits.darkAnthicus, () -> {});
        });
        
        node(UnitTypes.tecta, () -> {
            node(DarkArmyUnits.darkTecta, () -> {});
        });
        
        node(UnitTypes.collaris, () -> {
            node(DarkArmyUnits.darkCollaris, () -> {});
        });
        
        // Ship units
        node(Blocks.shipFabricator, () -> {
            node(DarkArmyBlocks.darkShipFabricator, () -> {
                node(DarkArmyUnits.darkElude, () -> {});
            });
        });
        
        node(UnitTypes.avert, () -> {
            node(DarkArmyUnits.darkAvert, () -> {});
        });
        
        node(UnitTypes.obviate, () -> {
            node(DarkArmyUnits.darkObviate, () -> {});
        });
        
        node(UnitTypes.quell, () -> {
            node(DarkArmyUnits.darkQuell, () -> {});
        });
        
        node(UnitTypes.disrupt, () -> {
            node(DarkArmyUnits.darkDisrupt, () -> {});
        });
        
        // Reconstructors
        node(Blocks.tankRefabricator, () -> {
            node(DarkArmyBlocks.darkTankRefabricator, () -> {});
        });
        
        node(Blocks.mechRefabricator, () -> {
            node(DarkArmyBlocks.darkMechRefabricator, () -> {});
        });
        
        node(Blocks.shipRefabricator, () -> {
            node(DarkArmyBlocks.darkShipRefabricator, () -> {});
        });
        
        node(Blocks.primeRefabricator, () -> {
            node(DarkArmyBlocks.darkPrimeRefabricator, () -> {});
        });
        
        // Power blocks
        node(Blocks.turbineCondenser, () -> {
            node(DarkArmyBlocks.darkTurbineCondenser, () -> {});
        });
        
        node(Blocks.beamNode, () -> {
            node(DarkArmyBlocks.darkNode, () -> {});
        });
    }
}

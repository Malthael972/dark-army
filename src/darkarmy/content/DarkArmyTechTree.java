package darkarmy.content;

import mindustry.content.*;
import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {

    public static void load() {
        // These attach to EXISTING nodes in the vanilla tree
        // The node() call adds your content as a child
        
        node(Blocks.beamNode, () -> {
            node(DarkArmyBlocks.darkNode, () -> {});
            node(DarkArmyBlocks.darkTurbineCondenser, () -> {});
        });
        
        node(Blocks.tankFabricator, () -> {
            node(DarkArmyBlocks.darkTankFabricator, () -> {
                node(DarkArmyUnits.darkStell, () -> {});
            });
        });
        
        node(Blocks.tankRefabricator, () -> {
            node(DarkArmyBlocks.darkTankRefabricator, () -> {
                node(DarkArmyUnits.darkLocus, () -> {
                    node(DarkArmyUnits.darkPrecept, () -> {
                        node(DarkArmyUnits.darkVanquish, () -> {
                            node(DarkArmyUnits.darkConquer, () -> {});
                        });
                    });
                });
            });
        });
        
        node(Blocks.mechFabricator, () -> {
            node(DarkArmyBlocks.darkMechFabricator, () -> {
                node(DarkArmyUnits.darkMerui, () -> {});
            });
        });
        
        node(Blocks.mechRefabricator, () -> {
            node(DarkArmyBlocks.darkMechRefabricator, () -> {
                node(DarkArmyUnits.darkCleroi, () -> {
                    node(DarkArmyUnits.darkAnthicus, () -> {
                        node(DarkArmyUnits.darkTecta, () -> {
                            node(DarkArmyUnits.darkCollaris, () -> {});
                        });
                    });
                });
            });
        });
        
        node(Blocks.shipFabricator, () -> {
            node(DarkArmyBlocks.darkShipFabricator, () -> {
                node(DarkArmyUnits.darkElude, () -> {});
            });
        });
        
        node(Blocks.shipRefabricator, () -> {
            node(DarkArmyBlocks.darkShipRefabricator, () -> {
                node(DarkArmyUnits.darkAvert, () -> {
                    node(DarkArmyUnits.darkObviate, () -> {
                        node(DarkArmyUnits.darkQuell, () -> {
                            node(DarkArmyUnits.darkDisrupt, () -> {});
                        });
                    });
                });
            });
        });
        
        node(Blocks.primeRefabricator, () -> {
            node(DarkArmyBlocks.darkPrimeRefabricator, () -> {});
        });
    }
}

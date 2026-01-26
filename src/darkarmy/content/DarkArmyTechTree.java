package darkarmy.content;

import mindustry.content.Blocks;
import mindustry.content.UnitTypes;
import mindustry.game.Objectives.*;

import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {

    public static void load() {
        
        // Add your power blocks to vanilla power tree
        node(Blocks.beamNode, () -> {
            node(DarkArmyBlocks.darkNode, () -> {
                node(DarkArmyBlocks.darkTurbineCondenser, () -> {});
            });
        });
        
        // Add your tank line after vanilla tank fabricator
        node(Blocks.tankFabricator, () -> {
            node(DarkArmyBlocks.darkTankFabricator, () -> {
                node(DarkArmyUnits.darkStell, () -> {
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
            });
        });
        
        // Add your mech line after vanilla mech fabricator
        node(Blocks.mechFabricator, () -> {
            node(DarkArmyBlocks.darkMechFabricator, () -> {
                node(DarkArmyUnits.darkMerui, () -> {
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
            });
        });
        
        // Add your ship line after vanilla ship fabricator
        node(Blocks.shipFabricator, () -> {
            node(DarkArmyBlocks.darkShipFabricator, () -> {
                node(DarkArmyUnits.darkElude, () -> {
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
            });
        });
        
        // Add prime refabricator after vanilla prime refabricator
        node(Blocks.primeRefabricator, () -> {
            node(DarkArmyBlocks.darkPrimeRefabricator, () -> {});
        });
    }
}

package darkarmy.content;

import arc.struct.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import mindustry.content.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.ErekirTechTree.*;
import static darkarmy.content.DarkArmyBlocks.*;
import static darkarmy.content.DarkArmyUnits.*;

public class DarkArmyTechTree {

    public static void load() {
        // Find the core bastion node in Erekir's tech tree
        // and add Dark Army content as children
        
        // Add power generation branch
        coreBastion.techNode.children.each(node -> {
            if (node.content == turbineCondenser) {
                node(darkTurbineCondenser, Seq.with(new OnSector(SectorPresets.aegis)), () -> {
                    node(darkNode, () -> {
                        
                    });
                });
            }
            
            // Add tank fabricator branch after regular tank fabricator
            if (node.content == tankFabricator) {
                node(darkTankFabricator, Seq.with(new OnSector(SectorPresets.lake)), () -> {
                    node(darkStell);
                    
                    node(darkTankRefabricator, Seq.with(new OnSector(SectorPresets.marsh)), () -> {
                        node(darkLocus);
                        
                        node(darkPrimeRefabricator, Seq.with(new OnSector(SectorPresets.stronghold)), () -> {
                            node(darkPrecept);
                        });
                        
                        node(darkTankAssembler, Seq.with(
                            new OnSector(SectorPresets.siege),
                            new Research(Blocks.constructor),
                            new Research(Blocks.atmosphericConcentrator)
                        ), () -> {
                            node(darkVanquish, () -> {
                                node(darkConquer, Seq.with(new OnSector(SectorPresets.karst)), () -> {
                                    
                                });
                            });
                        });
                    });
                });
            }
            
            // Add mech fabricator branch after regular mech fabricator  
            if (node.content == mechFabricator) {
                node(darkMechFabricator, Seq.with(new OnSector(SectorPresets.intersect)), () -> {
                    node(darkMerui);
                    
                    node(darkMechRefabricator, Seq.with(new OnSector(SectorPresets.basin)), () -> {
                        node(darkCleroi);
                        
                        node(darkMechAssembler, Seq.with(
                            new OnSector(SectorPresets.crossroads),
                            new Research(darkTankAssembler)
                        ), () -> {
                            node(darkTecta, () -> {
                                node(darkCollaris, Seq.with(new OnSector(SectorPresets.karst)), () -> {
                                    
                                });
                            });
                        });
                    });
                });
            }
            
            // Add ship fabricator branch after regular ship fabricator
            if (node.content == shipFabricator) {
                node(darkShipFabricator, Seq.with(new OnSector(SectorPresets.lake)), () -> {
                    node(darkElude);
                    
                    node(darkShipRefabricator, Seq.with(new OnSector(SectorPresets.peaks)), () -> {
                        node(darkAvert);
                        
                        // Connect to prime refabricator if not already created
                        node(darkPrimeRefabricator, Seq.with(new OnSector(SectorPresets.stronghold)), () -> {
                            node(darkObviate);
                        });
                        
                        node(darkShipAssembler, Seq.with(
                            new OnSector(SectorPresets.crossroads),
                            new Research(darkTankAssembler)
                        ), () -> {
                            node(darkQuell, () -> {
                                node(darkDisrupt, Seq.with(new OnSector(SectorPresets.karst)), () -> {
                                    
                                });
                            });
                        });
                    });
                });
            }
        });
    }
}

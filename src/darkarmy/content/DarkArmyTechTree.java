package darkarmy.content;

import mindustry.content.*;
import mindustry.game.Objectives;
import mindustry.type.SectorPreset;

import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {

    public static void load() {

        /* ----------------------------
           CORE BRANCH
        -----------------------------*/

        node(Blocks.coreBastion, () -> {

            node(DarkArmyBlocks.darkCore, () -> {
                objectives.add(
                    new Objectives.SectorComplete(SectorPresets.basaltFields)
                );
            });
        });

        /* ----------------------------
           TANK LINE
        -----------------------------*/

        node(Blocks.tankFabricator, () -> {

            // Dark Tank Fabricator
            node(DarkArmyBlocks.darkTankFabricator, () -> {
                objectives.add(
                    new Objectives.SectorComplete(SectorPresets.basaltFields)
                );

                // T1 Tank
                node(DarkArmyUnits.darkStell, () -> {
                    objectives.add(
                        new Objectives.Research(DarkArmyBlocks.darkTankFabricator)
                    );
                });
            });
        });

        // Refabricator (T2)
        node(Blocks.tankRefabricator, () -> {

            node(DarkArmyBlocks.darkTankRefabricator, () -> {
                objectives.add(
                    new Objectives.Research(DarkArmyBlocks.darkTankFabricator)
                );

                node(DarkArmyUnits.darkLocus, () -> {
                    objectives.add(
                        new Objectives.Research(DarkArmyBlocks.darkTankRefabricator)
                    );
                });
            });
        });

        /* ----------------------------
           MECH LINE
        -----------------------------*/

        node(Blocks.mechFabricator, () -> {

            node(DarkArmyBlocks.darkMechFabricator, () -> {
                objectives.add(
                    new Objectives.SectorComplete(SectorPresets.oxideFields)
                );

                node(DarkArmyUnits.darkPrecept, () -> {
                    objectives.add(
                        new Objectives.Research(DarkArmyBlocks.darkMechFabricator)
                    );
                });
            });
        });

        /* ----------------------------
           SHIP LINE
        -----------------------------*/

        node(Blocks.shipFabricator, () -> {

            node(DarkArmyBlocks.darkShipFabricator, () -> {
                objectives.add(
                    new Objectives.SectorComplete(SectorPresets.carbideCliffs)
                );

                node(DarkArmyUnits.darkVanquish, () -> {
                    objectives.add(
                        new Objectives.Research(DarkArmyBlocks.darkShipFabricator)
                    );
                });
            });
        });

        /* ----------------------------
           ENDGAME UNIT
        -----------------------------*/

        node(Blocks.primeRefabricator, () -> {

            node(DarkArmyUnits.darkConquer, () -> {
                objectives.add(
                    new Objectives.Research(Blocks.primeRefabricator)
                );
            });
        });
    }
}

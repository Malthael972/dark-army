package darkarmy.content;

import arc.struct.Seq;
import mindustry.ctype.UnlockableContent;
import mindustry.content.Blocks;
import mindustry.content.UnitTypes;
import mindustry.game.Objectives.Research;
import mindustry.content.TechTree;
import mindustry.content.TechTree.TechNode;

import static mindustry.content.TechTree.*;

public class DarkArmyTechTree {

    public static void load() {

        // =====================
        // UNITS
        // =====================

        addAfter(UnitTypes.stell,     DarkArmyUnits.darkStell);
        addAfter(UnitTypes.locus,     DarkArmyUnits.darkLocus);

        addAfter(UnitTypes.merui,     DarkArmyUnits.darkMerui);
        addAfter(UnitTypes.cleroi,    DarkArmyUnits.darkCleroi);

        addAfter(UnitTypes.elude,     DarkArmyUnits.darkElude);
        addAfter(UnitTypes.avert,     DarkArmyUnits.darkAvert);
        addAfter(UnitTypes.obviate,   DarkArmyUnits.darkObviate);

        addAfter(UnitTypes.quell,     DarkArmyUnits.darkQuell);
        addAfter(UnitTypes.disrupt,   DarkArmyUnits.darkDisrupt);

        addAfter(UnitTypes.precept,   DarkArmyUnits.darkPrecept);
        addAfter(UnitTypes.anthicus,  DarkArmyUnits.darkAnthicus);


        // =====================
        // BLOCKS
        // =====================

        addAfter(Blocks.tankFabricator,    DarkArmyBlocks.darkTankFabricator);
        addAfter(Blocks.tankRefabricator,  DarkArmyBlocks.darkTankRefabricator);

        addAfter(Blocks.mechFabricator,    DarkArmyBlocks.darkMechFabricator);
        addAfter(Blocks.mechRefabricator,  DarkArmyBlocks.darkMechRefabricator);

        addAfter(Blocks.shipFabricator,    DarkArmyBlocks.darkShipFabricator);
        addAfter(Blocks.shipRefabricator,  DarkArmyBlocks.darkShipRefabricator);

        addAfter(Blocks.primeRefabricator, DarkArmyBlocks.darkPrimeRefabricator);

        addAfter(Blocks.turbineCondenser,  DarkArmyBlocks.darkTurbineCondenser);
        addAfter(Blocks.beamNode,          DarkArmyBlocks.darkNode);
    }

    /**
     * Adds mod content directly after vanilla content
     * using identical cost and requirements.
     */
    private static void addAfter(UnlockableContent vanilla, UnlockableContent mod) {

        TechNode parent = vanilla.techNode;

        if (parent == null) {
            throw new RuntimeException(
                "TechNode missing for vanilla content: " + vanilla.name +
                " (load order issue)"
            );
        }

        // Save old context
        TechNode prev = context();

        // Set parent context
        TechTree.context = parent;

        // Create node
        node(
            mod,
            vanilla.researchRequirements(),
            Seq.with(new Research(vanilla)),
            () -> {}
        );

        // Restore context
        TechTree.context = prev;
    }
}

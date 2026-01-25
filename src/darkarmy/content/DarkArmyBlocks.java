package darkarmy.content;

import arc.*;
import arc.graphics.*;
import arc.struct.*;
import arc.math.*;

import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.type.*;

import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.*;

import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;

import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import static mindustry.type.ItemStack.with;

public class DarkArmyBlocks {
  public static Block darkTankFabricator;
  public static Block darkTankRefabricator;

  public static void load(){
// tank production
    darkTankFabricator = new UnitFactory("dark-tank-fabricator"){{
            requirements(Category.units, with(Items.silicon, 200, Items.beryllium, 150));
            size = 3;
            configurable = false;
            plans.add(new UnitPlan(DarkArmyUnits.darkStell, 60f * 35f, with(Items.beryllium, 40, Items.silicon, 50)));
            researchCost = with(Items.beryllium, 200, Items.graphite, 80, Items.silicon, 80);
            regionSuffix = "-dark";
            fogRadius = 3;
            consumePower(1.5f);
        }};

    darkTankRefabricator = new Reconstructor("dark-tank-refabricator"){{
            requirements(Category.units, with(Items.beryllium, 200, Items.tungsten, 80, Items.silicon, 100));
            regionSuffix = "-dark";

            size = 3;
            consumePower(3f);
            consumeLiquid(Liquids.hydrogen, 3f / 60f);
            consumeItems(with(Items.silicon, 40, Items.tungsten, 30));

            constructTime = 60f * 30f;
            researchCostMultiplier = 0.75f;

            upgrades.addAll(
            new UnitType[]{DarkArmyUnits.darkStell, DarkArmyUnits.darkLocus}
            );
        }};

    //mech production

    //Ship production
   
    //prime fabricator

    DarkPrimeRefabricator = new Reconstructor("dark-prime-refabricator"){{
            requirements(Category.units, with(Items.thorium, 250, Items.oxide, 200, Items.tungsten, 200, Items.silicon, 400));
            regionSuffix = "-dark";

            researchCostMultipliers.put(Items.thorium, 0.2f);

            size = 5;
            consumePower(4.5f);
            consumeLiquid(Liquids.nitrogen, 10f / 60f);
            consumeItems(with(Items.thorium, 80, Items.silicon, 100));

            constructTime = 60f * 60f;

            upgrades.addAll(
            new UnitType[]{UnitTypes.locus, UnitTypes.precept},
            new UnitType[]{UnitTypes.cleroi, UnitTypes.anthicus},
            new UnitType[]{UnitTypes.avert, UnitTypes.obviate}
            );
        }};
  }
}

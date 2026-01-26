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
  public static Block darkMechFabricator;
  public static Block darkMechRefabricator;
  public static Block darkShipFabricator;
  public static Block darkShipRefabricator;
  public static Block darkPrimeRefabricator;
  public static Block darkNode;
  public static Block darkTurbineCondenser;
  
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
            darkMechFabricator = new UnitFactory("dark-mech-fabricator"){{
            requirements(Category.units, with(Items.silicon, 200, Items.beryllium, 250, Items.tungsten, 10));
            size = 3;
            configurable = false;
            plans.add(new UnitPlan(DarkArmyUnits.darkMerui, 60f * 40f, with(Items.beryllium, 50, Items.silicon, 70)));
            regionSuffix = "-dark";
            fogRadius = 3;
            researchCostMultiplier = 0.65f;
            consumePower(1.5f);
        }};
    
            darkMechRefabricator = new Reconstructor("dark-mech-refabricator"){{
            requirements(Category.units, with(Items.beryllium, 250, Items.tungsten, 175, Items.silicon, 150));
            regionSuffix = "-dark";

            size = 3;
            consumePower(2.5f);
            consumeLiquid(Liquids.hydrogen, 3f / 60f);
            consumeItems(with(Items.silicon, 50, Items.tungsten, 40));

            constructTime = 60f * 45f;
            researchCostMultiplier = 0.75f;

            upgrades.addAll(
            new UnitType[]{DarkArmyUnits.darkMerui, DarkArmyUnits.darkCleroi}
            );
        }};

    //Ship production
    darkShipFabricator = new UnitFactory("dark-ship-fabricator"){{
            requirements(Category.units, with(Items.silicon, 250, Items.beryllium, 200));

            size = 3;
            configurable = false;
            plans.add(new UnitPlan(DarkArmyUnits.darkElude, 60f * 40f, with(Items.graphite, 50, Items.silicon, 70)));
            regionSuffix = "-dark";
            fogRadius = 3;
            researchCostMultiplier = 0.5f;
            consumePower(1.5f);
        }};

    darkShipRefabricator = new Reconstructor("dark-ship-refabricator"){{
            requirements(Category.units, with(Items.beryllium, 250, Items.tungsten, 120, Items.silicon, 150, Items.oxide, 15));
            regionSuffix = "-dark";

            size = 3;
            consumePower(2.5f);
            consumeLiquid(Liquids.hydrogen, 3f / 60f);
            consumeItems(with(Items.silicon, 60, Items.tungsten, 40));

            constructTime = 60f * 50f;

            upgrades.addAll(
            new UnitType[]{DarkArmyUnits.darkElude, DarkArmyUnits.darkAvert}
            );

            researchCost = with(Items.beryllium, 500, Items.tungsten, 200, Items.silicon, 300, Items.oxide, 80);
        }};
   
    //prime fabricator

    darkPrimeRefabricator = new Reconstructor("dark-prime-refabricator"){{
            requirements(Category.units, with(Items.thorium, 250, Items.oxide, 200, Items.tungsten, 200, Items.silicon, 400));
            regionSuffix = "-dark";

            researchCostMultipliers.put(Items.thorium, 0.2f);

            size = 5;
            consumePower(4.5f);
            consumeLiquid(Liquids.nitrogen, 10f / 60f);
            consumeItems(with(Items.thorium, 80, Items.silicon, 100));

            constructTime = 60f * 60f;

            upgrades.addAll(
            new UnitType[]{DarkArmyUnits.darkLocus, DarkArmyUnits.darkPrecept},
            new UnitType[]{DarkArmyUnits.darkCleroi, DarkArmyUnits.darkAnthicus},
            new UnitType[]{DarkArmyUnits.darkAvert, DarkArmyUnits.darkObviate}
            );
        }};

  // power

  darkTurbineCondenser = new ThermalGenerator("dark-turbine-condenser"){{
            requirements(Category.power, with(Items.beryllium, 60));
            attribute = Attribute.steam;
            group = BlockGroup.liquids;
            displayEfficiencyScale = 1f / 9f;
            minEfficiency = 9f - 0.0001f;
            powerProduction = 3f / 9f;
            displayEfficiency = false;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.04f;
            size = 3;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;

            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 0.6f * 9f){{
                blurThresh = 0.01f;
            }});

            hasLiquids = true;
            outputLiquid = new LiquidStack(Liquids.water, 5f / 60f / 9f);
            liquidCapacity = 20f;
            fogRadius = 3;
            researchCost = with(Items.beryllium, 15);
        }};

  darkNode = new BeamNode("dark-node"){{
            requirements(Category.power, with(Items.beryllium, 8));
            consumesPower = outputsPower = true;
            health = 90;
            range = 10;
            fogRadius = 1;
            researchCost = with(Items.beryllium, 5);
            buildCostMultiplier = 2.5f;

            consumePowerBuffered(1000f);
  }
}

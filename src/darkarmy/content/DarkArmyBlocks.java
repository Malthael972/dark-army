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

public class DarkArmyBlocks {
  public static Block darkTankFabricator;

  public static void load(){
// tank production
    darkTankFabricator = new UnitFactory("dark-tank-fabricator"){{
            requirements(Category.units, with(Items.silicon, 200, Items.beryllium, 150));
            size = 3;
            configurable = false;
            plans.add(new UnitPlan(UnitTypes.darkStell, 60f * 35f, with(Items.beryllium, 40, Items.silicon, 50)));
            researchCost = with(Items.beryllium, 200, Items.graphite, 80, Items.silicon, 80);
            regionSuffix = "-dark";
            fogRadius = 3;
            consumePower(1.5f);
        }};
    
  }
}

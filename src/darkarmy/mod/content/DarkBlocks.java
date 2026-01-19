
package darkarmy.content;

import mindustry.world.*;
import mindustry.world.blocks.units.*;
import mindustry.type.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class Blocks {

    public static Block darklingFabricator;

    public static void load(){

        darklingFabricator = new UnitFactory("darkling-fabricator"){{
            requirements(Category.units,
                with(
                    Items.beryllium, 60,
                    Items.tungsten, 40
                )
            );

            size = 3;
            health = 600;

            consumePower(2.5f);

            plans.add(
                new UnitPlan(
                    Units.darkling,
                    60f * 25f,
                    with(
                        Items.beryllium, 30,
                        Items.tungsten, 20
                    )
                )
            );
        }};
    }
}

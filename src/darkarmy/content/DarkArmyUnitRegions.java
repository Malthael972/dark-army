package darkarmy.content;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import mindustry.type.UnitType;
import arc.Events;
import arc.util.Log;

import mindustry.game.EventType;

import darkarmy.content.DarkArmyUnits;


public class DarkArmyUnitRegions {

    public static void load() {

        Events.on(EventType.ClientLoadEvent.class, e -> {

            DarkArmyUnits.darkStell.region =
                Core.atlas.find("dark-stell");

            DarkArmyUnits.darkStell.cellRegion =
                Core.atlas.find("dark-stell-cell");

            DarkArmyUnits.darkStell.treadRegion =
                Core.atlas.find("dark-stell-treads");

            DarkArmyUnits.darkStell.shadowRegion =
                Core.atlas.find("dark-stell-shadow");

            // weapons
            DarkArmyUnits.darkStell.weapons.each(w ->
                w.region = Core.atlas.find(w.name)
            );
        });
    }
}

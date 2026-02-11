package darkarmy.content;

import arc.Core;
import arc.Events;
import arc.util.Log;

import mindustry.game.EventType;

public class DarkUnitRegions {

    public static void load() {

        Events.on(EventType.ClientLoadEvent.class, e -> {

            DarkUnits.darkStell.region =
                Core.atlas.find("dark-stell");

            DarkUnits.darkStell.cellRegion =
                Core.atlas.find("dark-stell-cell");

            DarkUnits.darkStell.treadRegion =
                Core.atlas.find("dark-stell-treads");

            DarkUnits.darkStell.shadowRegion =
                Core.atlas.find("dark-stell-shadow");

            // weapons
            DarkUnits.darkStell.weapons.each(w ->
                w.region = Core.atlas.find(w.name)
            );
        });
    }
}

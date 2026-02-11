package darkarmy.content;

import arc.Core;
import arc.Events;
import arc.graphics.g2d.TextureRegion;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.type.UnitType;

public class DarkArmyUnitRegions {

    public static void load() {

        Events.on(EventType.ClientLoadEvent.class, e -> {

            for(UnitType unit : Vars.content.units()) {

                // Only touch your mod’s units
                if(!unit.name.startsWith("dark-")) continue;

                unit.region       = find(unit.name);
                unit.shadowRegion = find(unit.name + "-shadow");
                unit.cellRegion   = find(unit.name + "-cell");
                unit.treadRegion  = find(unit.name + "-treads");

                // Legs / mechs
                unit.legRegion        = find(unit.name + "-leg");
                unit.legShadowRegion = find(unit.name + "-leg-shadow");
                unit.footRegion      = find(unit.name + "-foot");

                // Blades / rotors
                unit.bladeRegion = find(unit.name + "-blade");

                // Weapons (same as vanilla)
                unit.weapons.each(w ->
                    w.region = find(w.name)
                );
            }
        });
    }

    private static TextureRegion find(String name){
        TextureRegion r = Core.atlas.find(name);
        return r.found() ? r : Core.atlas.find("clear");
    }
}

package darkarmy.content;

import arc.Core;
import arc.Events;
import arc.graphics.g2d.TextureRegion;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.type.UnitType;

public class DarkArmyUnitRegions {

    public static void load() {
        // Wait until client loads all assets
        Events.on(EventType.ClientLoadEvent.class, e -> {

            // Loop through all units in the game
            for(UnitType unit : Vars.content.units()) {

                // Only assign your mod’s units (optional)
                if(!unit.name.startsWith("dark-")) continue;

                // Assign the main unit textures (vanilla fields)
                unit.region       = find(unit.name);               // main sprite
                unit.shadowRegion = find(unit.name + "-shadow");  // shadow
                unit.cellRegion   = find(unit.name + "-cell");    // mech energy cell
                unit.treadRegion  = find(unit.name + "-treads");  // treads/tracks

                // Assign weapon textures
                if(unit.weapons != null){
                    unit.weapons.each(w -> w.region = find(w.name));
                }
            }
        });
    }

    // Helper method to find a TextureRegion by name
    private static TextureRegion find(String name){
        TextureRegion r = Core.atlas.find(name);
        return r.found() ? r : Core.atlas.find("clear"); // fallback if not found
    }
}

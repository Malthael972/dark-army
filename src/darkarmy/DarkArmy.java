package darkarmy;


import arc.*;
import mindustry.mod.Mod;
import mindustry.game.EventType;
import darkarmy.content.DarkArmyUnits;
import darkarmy.content.DarkArmyBlocks;
import darkarmy.content.DarkArmyTechTree;


public class DarkArmy extends Mod {
  @Override
public void loadContent() {
    DarkArmyBlocks.load();
    DarkArmyUnits.load();
    
    // Load tech tree AFTER vanilla content is loaded
    Events.on(EventType.ContentInitEvent.class, e -> {
        DarkArmyTechTree.load();
    });
}
}

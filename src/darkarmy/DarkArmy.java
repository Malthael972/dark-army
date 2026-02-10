package darkarmy;


import arc.*;
import mindustry.mod.Mod;
import mindustry.game.EventType;
import darkarmy.content.DarkArmyUnits;
import darkarmy.content.DarkArmyBlocks;
import darkarmy.content.DarkArmyTechTree.java;


public class DarkArmy extends Mod {
  @Override
public void loadContent() {
    DarkArmyUnits.load();
    DarkArmyBlocks.load();
    DarkArmyTechTree.load();
  
    
}
}

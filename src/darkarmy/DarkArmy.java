package darkarmy;

import mindustry.mod.Mod;
import darkarmy.content.DarkArmyUnits;
import darkarmy.content.DarkArmyBlocks;
import darkarmy.content.DarkArmyTechTree;


public class DarkArmy extends Mod {
  @Override
  public void loadContent() {
    DarkArmyUnits.load();
    DarkArmyBlocks.load();
  }
  @Override
    public void init() {
        // Call tech tree AFTER vanilla content is fully loaded
        DarkArmyTechTree.load();
    }
}  

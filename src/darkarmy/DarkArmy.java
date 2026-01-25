package darkarmy;

import mindustry.mod.Mod;
import darkarmy.content.DarkArmyUnits;

public class DarkArmy extends Mod {
  @Override
  public void loadContent() {
    DarkArmyUnits.load();
    DarkArmyBlocks.load();
  }
}  

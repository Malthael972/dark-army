package darkarmy.mod;

import mindustry.mod.Mod;
import darkarmy.mod.content.DarkUnits;

pulic class DarkArmy extends Mod {
  @override
  public void loadContent() {
    Units.load();
  }
}  

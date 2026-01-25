package darkarmy.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.content.Fx;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class DarkArmyUnits {
  public static UnitType darkStell;
  public static UnitType darkLocus;

  public static void load(){
    darkStell = new TankUnitType("dark-stell"){{
        constructor = UnitEntity::create;
      
            hitSize = 12f;
            treadPullOffset = 3;
            speed = 0.75f;
            rotateSpeed = 3.5f;
            health = 850;
            armor = 6f;
            itemCapacity = 0;
            floorMultiplier = 0.95f;
            treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
            researchCostMultiplier = 0f;
            tankMoveVolume *= 0.32f;
            tankMoveSound = Sounds.tankMoveSmall;

            weapons.add(new Weapon("dark-stell-weapon"){{
                shootSound = Sounds.shootStell;
                layerOffset = 0.0001f;
                reload = 50f;
                shootY = 4.5f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 2.2f;
                mirror = false;
                x = 0f;
                y = -0.75f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                bullet = new BasicBulletType(4f, 40){{
                    sprite = "missile-large";
                    smokeEffect = Fx.shootBigSmoke;
                    shootEffect = Fx.shootBigColor;
                    width = 5f;
                    height = 7f;
                    lifetime = 40f;
                    hitSize = 4f;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 1.7f;
                    trailLength = 5;
                    despawnEffect = hitEffect = Fx.hitBulletColor;
                }};
            }});
        }};

     darkLocus = new TankUnitType("dark-locus"){{
            hitSize = 18f;
            treadPullOffset = 5;
            speed = 0.7f;
            rotateSpeed = 2.6f;
            health = 2100;
            armor = 8f;
            itemCapacity = 0;
            floorMultiplier = 0.8f;
            treadRects = new Rect[]{new Rect(17 - 96f/2f, 10 - 96f/2f, 19, 76)};
            researchCostMultiplier = 0f;

            tankMoveVolume *= 0.55f;
            tankMoveSound = Sounds.tankMove;

            weapons.add(new Weapon("dark-locus-weapon"){{
                shootSound = Sounds.shootLocus;
                layerOffset = 0.0001f;
                reload = 18f;
                shootY = 10f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 1.4f;
                mirror = false;
                shootCone = 2f;
                x = 0f;
                y = 0f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;

                shoot = new ShootAlternate(3.5f);

                bullet = new RailBulletType(){{
                    length = 160f;
                    damage = 48f;
                    hitColor = Color.valueOf("feb380");
                    hitEffect = endEffect = Fx.hitBulletColor;
                    pierceDamageFactor = 0.8f;

                    smokeEffect = Fx.colorSpark;

                    endEffect = new Effect(14f, e -> {
                        color(e.color);
                        Drawf.tri(e.x, e.y, e.fout() * 1.5f, 5f, e.rotation);
                    });

                    shootEffect = new Effect(10, e -> {
                        color(e.color);
                        float w = 1.2f + 7 * e.fout();

                        Drawf.tri(e.x, e.y, w, 30f * e.fout(), e.rotation);
                        color(e.color);

                        for(int i : Mathf.signs){
                            Drawf.tri(e.x, e.y, w * 0.9f, 18f * e.fout(), e.rotation + i * 90f);
                        }

                        Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
                    });

                    lineEffect = new Effect(20f, e -> {
                        if(!(e.data instanceof Vec2 v)) return;

                        color(e.color);
                        stroke(e.fout() * 0.9f + 0.6f);

                        Fx.rand.setSeed(e.id);
                        for(int i = 0; i < 7; i++){
                            Fx.v.trns(e.rotation, Fx.rand.random(8f, v.dst(e.x, e.y) - 8f));
                            Lines.lineAngleCenter(e.x + Fx.v.x, e.y + Fx.v.y, e.rotation + e.finpow(), e.foutpowdown() * 20f * Fx.rand.random(0.5f, 1f) + 0.3f);
                        }

                        e.scaled(14f, b -> {
                            stroke(b.fout() * 1.5f);
                            color(e.color);
                            Lines.line(e.x, e.y, v.x, v.y);
                        });
                    });
                }};
            }});
        }};
  }
}

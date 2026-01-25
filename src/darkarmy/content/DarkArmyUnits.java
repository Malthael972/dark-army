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
import mindustry.content.StatusEffects;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class DarkArmyUnits {
  public static UnitType darkStell;
  public static UnitType darkLocus;
  public static UnitType darkPrecept;
  public static UnitType darkVanquish;
  public static UnitType darkConquer;

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

     darkPrecept = new TankUnitType("dark-precept"){{
            hitSize = 24f;
            treadPullOffset = 5;
            speed = 0.64f;
            rotateSpeed = 1.5f;
            health = 5000;
            armor = 11f;
            itemCapacity = 0;
            floorMultiplier = 0.65f;
            drownTimeMultiplier = 1.2f;
            immunities.addAll(StatusEffects.burning, StatusEffects.melting);
            treadRects = new Rect[]{new Rect(16 - 60f, 48 - 70f, 30, 75), new Rect(44 - 60f, 17 - 70f, 17, 60)};
            researchCostMultiplier = 0f;

            weapons.add(new Weapon("dark-precept-weapon"){{
                shootSound = Sounds.explosionDull;
                layerOffset = 0.0001f;
                reload = 80f;
                shootY = 16f;
                recoil = 3f;
                rotate = true;
                rotateSpeed = 1.625f;
                mirror = false;
                shootCone = 2f;
                x = 0f;
                y = -1f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 30f;
                bullet = new BasicBulletType(7f, 120){{
                    sprite = "missile-large";
                    width = 7.5f;
                    height = 13f;
                    lifetime = 28f;
                    hitSize = 6f;
                    pierceCap = 2;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 2.8f;
                    trailLength = 8;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    shootEffect = Fx.shootTitan;
                    smokeEffect = Fx.shootSmokeTitan;
                    splashDamageRadius = 20f;
                    splashDamage = 50f;

                    trailEffect = Fx.hitSquaresColor;
                    trailRotation = true;
                    trailInterval = 3f;

                    fragBullets = 4;

                    fragBullet = new BasicBulletType(5f, 35){{
                        sprite = "missile-large";
                        width = 5f;
                        height = 7f;
                        lifetime = 15f;
                        hitSize = 4f;
                        pierceCap = 3;
                        pierce = true;
                        pierceBuilding = true;
                        hitColor = backColor = trailColor = Color.valueOf("feb380");
                        frontColor = Color.white;
                        trailWidth = 1.7f;
                        trailLength = 3;
                        drag = 0.01f;
                        despawnEffect = hitEffect = Fx.hitBulletColor;
                    }};
                }};
            }});
        }};

     darkVanquish = new TankUnitType("dark-vanquish"){{
            hitSize = 28f;
            treadPullOffset = 4;
            speed = 0.63f;
            health = 11000;
            armor = 20f;
            itemCapacity = 0;
            crushDamage = 13f / 5f;
            floorMultiplier = 0.5f;
            drownTimeMultiplier = 1.25f;
            immunities.addAll(StatusEffects.burning, StatusEffects.melting);
            treadRects = new Rect[]{new Rect(22 - 154f/2f, 16 - 154f/2f, 28, 130)};

            tankMoveVolume *= 1.25f;
            tankMoveSound = Sounds.tankMoveHeavy;

            weapons.add(new Weapon("dark-vanquish-weapon"){{
                shootSound = Sounds.shootTank;
                layerOffset = 0.0001f;
                reload = 70f;
                shootY = 71f / 4f;
                shake = 5f;
                recoil = 4f;
                rotate = true;
                rotateSpeed = 1f;
                mirror = false;
                x = 0f;
                y = 0;
                shadow = 28f;
                heatColor = Color.valueOf("f9350f");
                cooldownTime = 80f;

                bullet = new BasicBulletType(8f, 190){{
                    sprite = "missile-large";
                    width = 9.5f;
                    height = 13f;
                    lifetime = 18f;
                    hitSize = 6f;
                    shootEffect = Fx.shootTitan;
                    smokeEffect = Fx.shootSmokeTitan;
                    pierceCap = 2;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 3.1f;
                    trailLength = 8;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    splashDamageRadius = 20f;
                    splashDamage = 50f;

                    fragOnHit = false;
                    fragRandomSpread = 0f;
                    fragSpread = 10f;
                    fragBullets = 5;
                    fragVelocityMin = 1f;
                    despawnSound = Sounds.explosionDull;

                    fragBullet = new BasicBulletType(8f, 35){{
                        sprite = "missile-large";
                        width = 8f;
                        height = 12f;
                        lifetime = 15f;
                        hitSize = 4f;
                        hitColor = backColor = trailColor = Color.valueOf("feb380");
                        frontColor = Color.white;
                        trailWidth = 2.8f;
                        trailLength = 6;
                        hitEffect = despawnEffect = Fx.blastExplosion;
                        splashDamageRadius = 10f;
                        splashDamage = 20f;
                    }};
                }};
            }});

            int i = 0;
            for(float f : new float[]{34f / 4f, -36f / 4f}){
                int fi = i ++;
                weapons.add(new Weapon("dark-vanquish-point-weapon"){{
                    reload = 35f + fi * 5;
                    x = 48f / 4f;
                    y = f;
                    shootY = 5.5f;
                    recoil = 2f;
                    rotate = true;
                    rotateSpeed = 2f;
                    shootSound = Sounds.shootStell;

                    bullet = new BasicBulletType(4.5f, 25){{
                        width = 6.5f;
                        height = 11f;
                        shootEffect = Fx.sparkShoot;
                        smokeEffect = Fx.shootBigSmoke;
                        hitColor = backColor = trailColor = Color.valueOf("feb380");
                        frontColor = Color.white;
                        trailWidth = 1.5f;
                        trailLength = 4;
                        hitEffect = despawnEffect = Fx.hitBulletColor;
                    }};
                }});
            }
        }};

    darkConquer = new TankUnitType("dark-conquer"){{
            hitSize = 46f;
            treadPullOffset = 1;
            speed = 0.48f;
            health = 22000;
            armor = 26f;
            crushDamage = 25f / 5f;
            rotateSpeed = 0.8f;
            floorMultiplier = 0.3f;
            immunities.addAll(StatusEffects.burning, StatusEffects.melting);

            tankMoveVolume *= 1.5f;
            tankMoveSound = Sounds.tankMoveHeavy;

            float xo = 231f/2f, yo = 231f/2f;
            treadRects = new Rect[]{new Rect(27 - xo, 152 - yo, 56, 73), new Rect(24 - xo, 51 - 9 - yo, 29, 17), new Rect(59 - xo, 18 - 9 - yo, 39, 19)};

            weapons.add(new Weapon("dark-conquer-weapon"){{
                shootSound = Sounds.shootConquer;
                layerOffset = 0.1f;
                reload = 100f;
                shootY = 32.5f;
                shake = 5f;
                recoil = 5f;
                rotate = true;
                rotateSpeed = 0.6f;
                mirror = false;
                x = 0f;
                y = -2f;
                shadow = 50f;
                heatColor = Color.valueOf("f9350f");
                shootWarmupSpeed = 0.06f;
                cooldownTime = 110f;
                heatColor = Color.valueOf("f9350f");
                minWarmup = 0.9f;

                parts.addAll(
                new RegionPart("-glow"){{
                    color = Color.red;
                    blending = Blending.additive;
                    outline = mirror = false;
                }},
                new RegionPart("-sides"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    under = true;
                    moveX = 0.75f;
                    moveY = 0.75f;
                    moveRot = 82f;
                    x = 37 / 4f;
                    y = 8 / 4f;
                }},
                new RegionPart("-sinks"){{
                    progress = PartProgress.warmup;
                    mirror = true;
                    under = true;
                    heatColor = new Color(1f, 0.1f, 0.1f);
                    moveX = 17f / 4f;
                    moveY = -15f / 4f;
                    x = 32 / 4f;
                    y = -34 / 4f;
                }},
                new RegionPart("-sinks-heat"){{
                    blending = Blending.additive;
                    progress = PartProgress.warmup;
                    mirror = true;
                    outline = false;
                    colorTo = new Color(1f, 0f, 0f, 0.5f);
                    color = colorTo.cpy().a(0f);
                    moveX = 17f / 4f;
                    moveY = -15f / 4f;
                    x = 32 / 4f;
                    y = -34 / 4f;
                }}
                );

                for(int i = 1; i <= 3; i++){
                    int fi = i;
                    parts.add(new RegionPart("-blade"){{
                        progress = PartProgress.warmup.delay((3 - fi) * 0.3f).blend(PartProgress.reload, 0.3f);
                        heatProgress = PartProgress.heat.add(0.3f).min(PartProgress.warmup);
                        heatColor = new Color(1f, 0.1f, 0.1f);
                        mirror = true;
                        under = true;
                        moveRot = -40f * fi;
                        moveX = 3f;
                        layerOffset = -0.002f;

                        x = 11 / 4f;
                    }});
                }

                bullet = new BasicBulletType(8f, 360f){{
                    sprite = "missile-large";
                    width = 12f;
                    height = 20f;
                    lifetime = 35f;
                    hitSize = 6f;

                    smokeEffect = Fx.shootSmokeTitan;
                    pierceCap = 3;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("feb380");
                    frontColor = Color.white;
                    trailWidth = 4f;
                    trailLength = 9;
                    hitEffect = despawnEffect = Fx.massiveExplosion;

                    shootEffect = new ExplosionEffect(){{
                        lifetime = 40f;
                        waveStroke = 4f;
                        waveColor = sparkColor = trailColor;
                        waveRad = 15f;
                        smokeSize = 5f;
                        smokes = 8;
                        smokeSizeBase = 0f;
                        smokeColor = trailColor;
                        sparks = 8;
                        sparkRad = 40f;
                        sparkLen = 4f;
                        sparkStroke = 3f;
                    }};

                    int count = 6;
                    for(int j = 0; j < count; j++){
                        int s = j;
                        for(int i : Mathf.signs){
                            float fin = 0.05f + (j + 1) / (float)count;
                            float spd = speed;
                            float life = lifetime / Mathf.lerp(fin, 1f, 0.5f);
                            spawnBullets.add(new BasicBulletType(spd * fin, 60){{
                                drag = 0.002f;
                                width = 12f;
                                height = 11f;
                                lifetime = life + 5f;
                                weaveRandom = false;
                                hitSize = 5f;
                                pierceCap = 2;
                                pierce = true;
                                pierceBuilding = true;
                                hitColor = backColor = trailColor = Color.valueOf("feb380");
                                frontColor = Color.white;
                                trailWidth = 2.5f;
                                trailLength = 7;
                                weaveScale = (3f + s/2f) / 1.2f;
                                weaveMag = i * (4f - fin * 2f);

                                splashDamage = 65f;
                                splashDamageRadius = 30f;
                                despawnEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 4f;
                                    waveColor = sparkColor = trailColor;
                                    waveRad = 30f;
                                    smokeSize = 7f;
                                    smokes = 6;
                                    smokeSizeBase = 0f;
                                    smokeColor = trailColor;
                                    sparks = 5;
                                    sparkRad = 30f;
                                    sparkLen = 3f;
                                    sparkStroke = 1.5f;
                                }};
                            }});
                        }
                    }
                }};
            }});

            parts.add(new RegionPart("-glow"){{
                color = Color.red;
                blending = Blending.additive;
                layer = -1f;
                outline = false;
            }});
        }};
  }
}

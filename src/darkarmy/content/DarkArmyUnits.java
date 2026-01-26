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
import mindustry.entities.units.weapon;
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
  public static UnitType darkMerui;
  public static UnitType darkCleroi;
  public static UnitType darkAnthicus;
  public static UnitType darkTecta;
  public static UnitType darkCollaris;
  public static UnitType darkElude;
  public static UnitType darkAvert;
  public static UnitType darkObviate;
  public static UnitType darkQuell;
  public static UnitType darkDisrupt;

  public static void load(){
    // tank units
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

            unit.weapons.add(new Weapon("dark-stell-weapon"){{
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
       constructor = UnitEntity::create;
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
       constructor = UnitEntity::create;
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
       constructor = UnitEntity::create;
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
      constructor = UnitEntity::create;
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

    // mech units
    
     darkMerui = new ErekirUnitType("dark-merui"){{
       constructor = UnitEntity::create;
            speed = 0.72f;
            drag = 0.11f;
            hitSize = 9f;
            rotateSpeed = 3f;
            health = 680;
            armor = 4f;
            legStraightness = 0.3f;
            stepShake = 0f;
            stepSound = Sounds.walkerStepTiny;
            stepSoundVolume = 0.4f;

            legCount = 6;
            legLength = 8f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 3;
            rippleScale = 0.2f;

            legMoveSpace = 1f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;
            researchCostMultiplier = 0f;

            weapons.add(new Weapon("dark-merui-weapon"){{
                shootSound = Sounds.shootMerui;
                mirror = false;
                showStatSprite = false;
                x = 0f;
                y = 1f;
                shootY = 4f;
                reload = 63f;
                cooldownTime = 42f;
                heatColor = Pal.turretHeat;

                bullet = new ArtilleryBulletType(3f, 40){{
                    shootEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));

                    collidesTiles = true;
                    backColor = hitColor = Pal.techBlue;
                    frontColor = Color.white;

                    knockback = 0.8f;
                    lifetime = 46f;
                    width = height = 9f;
                    splashDamageRadius = 19f;
                    splashDamage = 30f;

                    trailLength = 27;
                    trailWidth = 2.5f;
                    trailEffect = Fx.none;
                    trailColor = backColor;

                    trailInterp = Interp.slope;

                    shrinkX = 0.6f;
                    shrinkY = 0.2f;

                    hitEffect = despawnEffect = new MultiEffect(Fx.hitSquaresColor, new WaveEffect(){{
                        colorFrom = colorTo = Pal.techBlue;
                        sizeTo = splashDamageRadius + 2f;
                        lifetime = 9f;
                        strokeFrom = 2f;
                    }});
                }};
            }});

        }};

        darkCleroi = new ErekirUnitType("dark-cleroi"){{
          constructor = UnitEntity::create;
            speed = 0.6f;
            drag = 0.1f;
            hitSize = 14f;
            rotateSpeed = 3f;
            health = 1100;
            armor = 5f;
            stepShake = 0f;

            stepSound = Sounds.walkerStepSmall;

            legCount = 4;
            legLength = 14f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 5f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.7f;

            legMoveSpace = 1f;
            hovering = true;

            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;

            for(int i = 0; i < 5; i++){
                int fi = i;
                parts.add(new RegionPart("-spine"){{
                    y = 21f / 4f - 45f / 4f * fi / 4f;
                    moveX = 21f / 4f + Mathf.slope(fi / 4f) * 1.25f;
                    moveRot = 10f - fi * 14f;
                    float fin = fi  / 4f;
                    progress = PartProgress.reload.inv().mul(1.3f).add(0.1f).sustain(fin * 0.34f, 0.14f, 0.14f);
                    layerOffset = -0.001f;
                    mirror = true;
                }});
            }

            weapons.add(new Weapon("dark-cleroi-weapon"){{
                shootSound = Sounds.shootCleroi;
                x = 14f / 4f;
                y = 33f / 4f;
                reload = 33f;
                layerOffset = -0.002f;
                alternate = false;
                heatColor = Color.red;
                cooldownTime = 25f;
                smoothReloadSpeed = 0.15f;
                recoil = 2f;

                bullet = new BasicBulletType(3.5f, 30){{
                    backColor = trailColor = hitColor = Pal.techBlue;
                    frontColor = Color.white;
                    width = 7.5f;
                    height = 10f;
                    lifetime = 40f;
                    trailWidth = 2f;
                    trailLength = 4;
                    shake = 1f;

                    trailEffect = Fx.missileTrail;
                    trailParam = 1.8f;
                    trailInterval = 6f;

                    splashDamageRadius = 30f;
                    splashDamage = 43f;

                    despawnSound = Sounds.explosionCleroi;

                    hitEffect = despawnEffect = new MultiEffect(Fx.hitBulletColor, new WaveEffect(){{
                        colorFrom = colorTo = Pal.techBlue;
                        sizeTo = splashDamageRadius + 3f;
                        lifetime = 9f;
                        strokeFrom = 3f;
                    }});

                    shootEffect = new MultiEffect(Fx.shootBigColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));
                    smokeEffect = Fx.shootSmokeSquare;
                    ammoMultiplier = 2;
                }};
            }});

            weapons.add(new PointDefenseWeapon("dark-cleroi-point-defense"){{
                x = 16f / 4f;
                y = -20f / 4f;
                reload = 9f;

                targetInterval = 9f;
                targetSwitchInterval = 12f;
                recoil = 0.5f;

                bullet = new BulletType(){{
                    shootSound = Sounds.shootLaser;
                    shootEffect = Fx.sparkShoot;
                    hitEffect = Fx.pointHit;
                    maxRange = 100f;
                    damage = 38f;
                }};
            }});
        }};

        darkAnthicus = new ErekirUnitType("dark-anthicus"){{
          constructor = UnitEntity::create;
            speed = 0.65f;
            drag = 0.1f;
            hitSize = 21f;
            rotateSpeed = 3f;
            health = 2900;
            armor = 7f;
            fogRadius = 40f;
            stepShake = 0f;

            stepSound = Sounds.walkerStepSmall;
            stepSoundPitch = 0.78f;

            legCount = 6;
            legLength = 18f;
            legGroupSize = 3;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 7f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.95f;
            legForwardScl = 0.9f;

            legMoveSpace = 1f;
            hovering = true;

            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;

            for(int j = 0; j < 3; j++){
                int i = j;
                parts.add(new RegionPart("-blade"){{
                    layerOffset = -0.01f;
                    heatLayerOffset = 0.005f;
                    x = 2f;
                    moveX = 6f + i * 1.9f;
                    moveY = 8f + -4f * i;
                    moveRot = 40f - i * 25f;
                    mirror = true;
                    progress = PartProgress.warmup.delay(i * 0.2f);
                    heatProgress = p -> Mathf.absin(Time.time + i * 14f, 7f, 1f);

                    heatColor = Pal.techBlue;
                }});
            }

            weapons.add(new Weapon("dark-anthicus-weapon"){{
                shootSound = Sounds.shootMissileLarge;
                shootSoundVolume = 0.5f;
                x = 29f / 4f;
                y = -11f / 4f;
                shootY = 1.5f;
                showStatSprite = false;
                reload = 130f;
                layerOffset = 0.01f;
                heatColor = Color.red;
                cooldownTime = 60f;
                smoothReloadSpeed = 0.15f;
                shootWarmupSpeed = 0.05f;
                minWarmup = 0.9f;
                rotationLimit = 70f;
                rotateSpeed = 2f;
                inaccuracy = 20f;
                shootStatus = StatusEffects.slow;
                alwaysShootWhenMoving = true;

                rotate = true;

                shoot = new ShootPattern(){{
                    shots = 2;
                    shotDelay = 6f;
                }};

                parts.add(new RegionPart("-blade"){{
                    mirror = true;
                    moveRot = -25f;
                    under = true;
                    moves.add(new PartMove(PartProgress.reload, 1f, 0f, 0f));

                    heatColor = Color.red;
                    cooldownTime = 60f;
                }});

                parts.add(new RegionPart("-blade"){{
                    mirror = true;
                    moveRot = -50f;
                    moveY = -2f;
                    moves.add(new PartMove(PartProgress.reload.shorten(0.5f), 1f, 0f, -15f));
                    under = true;

                    heatColor = Color.red;
                    cooldownTime = 60f;
                }});

                bullet = new BulletType(){{
                    shootEffect = new MultiEffect(Fx.shootBigColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.7f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 45f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }), new WaveEffect(){{
                        colorFrom = colorTo = Pal.techBlue;
                        sizeTo = 15f;
                        lifetime = 12f;
                        strokeFrom = 3f;
                    }});

                    smokeEffect = Fx.shootBigSmoke2;
                    shake = 2f;
                    speed = 0f;
                    keepVelocity = false;
                    inaccuracy = 2f;

                    spawnUnit = new MissileUnitType("anthicus-missile"){{
                        trailColor = engineColor = Pal.techBlue;
                        engineSize = 1.75f;
                        engineLayer = Layer.effect;
                        speed = 3.7f;
                        maxRange = 6f;
                        lifetime = 60f * 1.5f;
                        outlineColor = Pal.darkOutline;
                        health = 55;
                        lowAltitude = true;

                        parts.add(new FlarePart(){{
                            progress = PartProgress.life.slope().curve(Interp.pow2In);
                            radius = 0f;
                            radiusTo = 35f;
                            stroke = 3f;
                            rotation = 45f;
                            y = -5f;
                            followRotation = true;
                        }});

                        weapons.add(new Weapon(){{
                            shootSound = Sounds.none;
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(140f, 25f){{
                                shootEffect = new MultiEffect(Fx.massiveExplosion, new WrapEffect(Fx.dynamicSpikes, Pal.techBlue, 24f), new WaveEffect(){{
                                    colorFrom = colorTo = Pal.techBlue;
                                    sizeTo = 40f;
                                    lifetime = 12f;
                                    strokeFrom = 4f;
                                }});
                            }};
                        }});
                    }};
                }};
            }});
        }};

        darkTecta = new ErekirUnitType("dark-tecta"){{
          constructor = UnitEntity::create;
            drag = 0.1f;
            speed = 0.6f;
            hitSize = 30f;
            health = 6500;
            armor = 5f;

            lockLegBase = true;
            legContinuousMove = true;
            legGroupSize = 3;
            legStraightness = 0.4f;
            baseLegStraightness = 0.5f;
            legMaxLength = 1.3f;
            researchCostMultiplier = 0f;

            stepSound = Sounds.walkerStep;
            stepSoundVolume = 1f;
            stepSoundPitch = 1f;

            abilities.add(new ShieldArcAbility(){{
                region = "tecta-shield";
                radius = 45f;
                angle = 82f;
                regen = 40f / 60f;
                cooldown = 60f * 8f;
                max = 2200f;
                y = -20f;
                width = 8f;
                whenShooting = false;
                chanceDeflect = 1f;
            }});

            rotateSpeed = 2.1f;

            legCount = 6;
            legLength = 15f;
            legForwardScl = 0.45f;
            legMoveSpace = 1.4f;
            rippleScale = 2f;
            stepShake = 0.5f;
            legExtension = -5f;
            legBaseOffset = 5f;

            ammoType = new PowerAmmoType(2000);

            legSplashDamage = 32;
            legSplashRange = 30;
            drownTimeMultiplier = 0.5f;

            hovering = true;
            shadowElevation = 0.4f;
            groundLayer = Layer.legUnit;

            weapons.add(new Weapon("dark-tecta-weapon"){{
                shootSound = Sounds.shootMalign;
                mirror = true;
                top = false;

                x = 62/4f;
                y = 1f;
                shootY = 47 / 4f;
                recoil = 3f;
                reload = 40f;
                shake = 3f;
                cooldownTime = 40f;

                shoot.shots = 3;
                inaccuracy = 3f;
                velocityRnd = 0.33f;
                heatColor = Color.red;

                bullet = new MissileBulletType(4.2f, 60){{
                    homingPower = 0.2f;
                    weaveMag = 4;
                    weaveScale = 4;
                    lifetime = 55f;
                    shootEffect = Fx.shootBig2;
                    smokeEffect = Fx.shootSmokeTitan;
                    splashDamage = 70f;
                    splashDamageRadius = 30f;
                    frontColor = Color.white;
                    hitSound = Sounds.none;
                    width = height = 10f;

                    lightColor = trailColor = backColor = Pal.techBlue;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;

                    trailWidth = 2.8f;
                    trailLength = 20;
                    trailChance = -1f;
                    despawnSound = Sounds.explosionDull;

                    despawnEffect = Fx.none;
                    hitEffect = new ExplosionEffect(){{
                        lifetime = 20f;
                        waveStroke = 2f;
                        waveColor = sparkColor = trailColor;
                        waveRad = 12f;
                        smokeSize = 0f;
                        smokeSizeBase = 0f;
                        sparks = 10;
                        sparkRad = 35f;
                        sparkLen = 4f;
                        sparkStroke = 1.5f;
                    }};
                }};
            }});
        }};

        darkCollaris = new ErekirUnitType("dark-collaris"){{
          constructor = UnitEntity::create;
            drag = 0.1f;
            speed = 1.1f;
            hitSize = 44f;
            health = 18000;
            armor = 9f;
            rotateSpeed = 1.6f;
            lockLegBase = true;
            legContinuousMove = true;
            legStraightness = 0.6f;
            baseLegStraightness = 0.5f;

            stepSound = Sounds.walkerStep;
            stepSoundVolume = 1.1f;
            stepSoundPitch = 0.9f;

            legCount = 8;
            legLength = 30f;
            legForwardScl = 2.1f;
            legMoveSpace = 1.05f;
            rippleScale = 1.2f;
            stepShake = 0.5f;
            legGroupSize = 2;
            legExtension = -6f;
            legBaseOffset = 19f;
            legStraightLength = 0.9f;
            legMaxLength = 1.2f;

            ammoType = new PowerAmmoType(2000);

            legSplashDamage = 32;
            legSplashRange = 32;
            drownTimeMultiplier = 0.5f;

            hovering = true;
            shadowElevation = 0.4f;
            groundLayer = Layer.legUnit;

            targetAir = false;
            alwaysShootWhenMoving = true;

            weapons.add(new Weapon("dark-collaris-weapon"){{
                shootSound = Sounds.shootCollaris;
                mirror = true;
                rotationLimit = 30f;
                rotateSpeed = 0.4f;
                rotate = true;

                x = 48 / 4f;
                y = -28f / 4f;
                shootY = 64f / 4f;
                recoil = 4f;
                reload = 130f;
                cooldownTime = reload * 1.2f;
                shake = 7f;
                layerOffset = 0.02f;
                shadow = 10f;

                shootStatus = StatusEffects.slow;
                shootStatusDuration = reload + 1f;

                shoot.shots = 1;
                heatColor = Color.red;

                for(int i = 0; i < 5; i++){
                    int fi = i;
                    parts.add(new RegionPart("-blade"){{
                        under = true;
                        layerOffset = -0.001f;
                        heatColor = Pal.techBlue;
                        heatProgress = PartProgress.heat.add(0.2f).min(PartProgress.warmup);
                        progress = PartProgress.warmup.blend(PartProgress.reload, 0.1f);
                        x = 13.5f / 4f;
                        y = 10f / 4f - fi * 2f;
                        moveY = 1f - fi * 1f;
                        moveX = fi * 0.3f;
                        moveRot = -45f - fi * 17f;

                        moves.add(new PartMove(PartProgress.reload.inv().mul(1.8f).inv().curve(fi / 5f, 0.2f), 0f, 0f, 36f));
                    }});
                }

                bullet = new ArtilleryBulletType(5.5f, 260){{
                    collidesTiles = collides = true;
                    lifetime = 60f;
                    shootEffect = Fx.shootBigColor;
                    smokeEffect = Fx.shootSmokeSquareBig;
                    frontColor = Color.white;
                    trailEffect = new MultiEffect(Fx.artilleryTrail, Fx.artilleryTrailSmoke);
                    hitSound = Sounds.none;
                    width = 18f;
                    height = 24f;
                    rangeOverride = 385f;

                    lightColor = trailColor = hitColor = backColor = Pal.techBlue;
                    lightRadius = 40f;
                    lightOpacity = 0.7f;

                    trailWidth = 4.5f;
                    trailLength = 19;
                    trailChance = -1f;

                    despawnEffect = Fx.none;
                    despawnSound = Sounds.explosionDull;

                    hitEffect = despawnEffect = new ExplosionEffect(){{
                        lifetime = 50f;
                        waveStroke = 5f;
                        waveColor = sparkColor = trailColor;
                        waveRad = 45f;
                        smokeSize = 0f;
                        smokeSizeBase = 0f;
                        sparks = 10;
                        sparkRad = 25f;
                        sparkLen = 8f;
                        sparkStroke = 3f;
                    }};

                    splashDamage = 120f;
                    splashDamageRadius = 36f;

                    fragBullets = 15;
                    fragVelocityMin = 0.5f;
                    fragRandomSpread = 130f;
                    fragLifeMin = 0.3f;
                    despawnShake = 5f;

                    fragBullet = new BasicBulletType(5.5f, 37){{
                        pierceCap = 2;
                        pierceBuilding = true;

                        homingPower = 0.09f;
                        homingRange = 150f;

                        lifetime = 40f;
                        shootEffect = Fx.shootBigColor;
                        smokeEffect = Fx.shootSmokeSquareBig;
                        frontColor = Color.white;
                        hitSound = Sounds.none;
                        width = 12f;
                        height = 20f;

                        lightColor = trailColor = hitColor = backColor = Pal.techBlue;
                        lightRadius = 40f;
                        lightOpacity = 0.7f;

                        trailWidth = 2.2f;
                        trailLength = 7;
                        trailChance = -1f;

                        collidesAir = false;

                        despawnEffect = Fx.none;
                        splashDamage = 35f;
                        splashDamageRadius = 30f;

                        hitEffect = despawnEffect = new MultiEffect(new ExplosionEffect(){{
                            lifetime = 30f;
                            waveStroke = 2f;
                            waveColor = sparkColor = trailColor;
                            waveRad = 5f;
                            smokeSize = 0f;
                            smokeSizeBase = 0f;
                            sparks = 5;
                            sparkRad = 20f;
                            sparkLen = 6f;
                            sparkStroke = 2f;
                        }}, Fx.blastExplosion);
                    }};
                }};
            }});
        }};

    // ship units

  darkElude = new ErekirUnitType("dark-elude"){{
    constructor = UnitEntity::create;
            hovering = true;
            canDrown = false;
            shadowElevation = 0.1f;

            drag = 0.07f;
            speed = 1.8f;
            rotateSpeed = 5f;

            accel = 0.09f;
            health = 600f;
            armor = 1f;
            hitSize = 11f;
            engineOffset = 7f;
            engineSize = 2f;
            itemCapacity = 0;
            useEngineElevation = false;
            researchCostMultiplier = 0f;
            moveSound = Sounds.loopExtract;
            moveSoundVolume = 0.25f;
            moveSoundPitchMin = 0.7f;
            moveSoundPitchMax = 1.5f;

            abilities.add(new MoveEffectAbility(0f, -7f, Pal.sapBulletBack, Fx.missileTrailShort, 4f){{
                teamColor = true;
            }});

            for(float f : new float[]{-3f, 3f}){
                parts.add(new HoverPart(){{
                    x = 3.9f;
                    y = f;
                    mirror = true;
                    radius = 6f;
                    phase = 90f;
                    stroke = 2f;
                    layerOffset = -0.001f;
                    color = Color.valueOf("bf92f9");
                }});
            }

            weapons.add(new Weapon("dark-elude-weapon"){{
                shootSound = Sounds.shootElude;
                y = -2f;
                x = 4f;
                top = true;
                mirror = true;
                reload = 40f;
                baseRotation = -35f;
                shootCone = 360f;

                shoot = new ShootSpread(2, 11f);

                bullet = new BasicBulletType(5f, 16){{
                    homingPower = 0.19f;
                    homingDelay = 4f;
                    width = 7f;
                    height = 12f;
                    lifetime = 30f;
                    shootEffect = Fx.sparkShoot;
                    smokeEffect = Fx.shootBigSmoke;
                    hitColor = backColor = trailColor = Pal.suppress;
                    frontColor = Color.white;
                    trailWidth = 1.5f;
                    trailLength = 5;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});
        }};

        darkAvert = new ErekirUnitType("dark-avert"){{
          constructor = UnitEntity::create;
            lowAltitude = false;
            flying = true;
            drag = 0.08f;
            speed = 2f;
            rotateSpeed = 8f;
            accel = 0.09f;
            health = 1100f;
            armor = 3f;
            hitSize = 12f;
            engineSize = 0;
            fogRadius = 25;
            itemCapacity = 0;

            setEnginesMirror(
            new UnitEngine(35 / 4f, -38 / 4f, 3f, 315f),
            new UnitEngine(39 / 4f, -16 / 4f, 3f, 315f)
            );

            weapons.add(new Weapon("dark-avert-weapon"){{
                shootSound = Sounds.shootAvert;
                reload = 35f;
                x = 0f;
                y = 6.5f;
                shootY = 5f;
                recoil = 1f;
                top = false;
                layerOffset = -0.01f;
                rotate = false;
                mirror = false;
                shoot = new ShootHelix();

                bullet = new BasicBulletType(5f, 34){{
                    width = 7f;
                    height = 12f;
                    lifetime = 18f;
                    shootEffect = Fx.sparkShoot;
                    smokeEffect = Fx.shootBigSmoke;
                    hitColor = backColor = trailColor = Pal.suppress;
                    frontColor = Color.white;
                    trailWidth = 1.5f;
                    trailLength = 5;
                    hitEffect = despawnEffect = Fx.hitBulletColor;
                }};
            }});
        }};

        darkObviate = new ErekirUnitType("dark-obviate"){{
          constructor = UnitEntity::create;
            flying = true;
            drag = 0.08f;
            speed = 1.8f;
            rotateSpeed = 2.5f;
            accel = 0.09f;
            health = 2300f;
            armor = 6f;
            hitSize = 25f;
            engineSize = 4.3f;
            engineOffset = 54f / 4f;
            fogRadius = 25;
            itemCapacity = 0;
            lowAltitude = true;

            setEnginesMirror(
            new UnitEngine(38 / 4f, -46 / 4f, 3.1f, 315f)
            );

            parts.add(
            new RegionPart("-blade"){{
                moveRot = -10f;
                moveX = -1f;
                moves.add(new PartMove(PartProgress.reload, 2f, 1f, -5f));
                progress = PartProgress.warmup;
                mirror = true;

                children.add(new RegionPart("-side"){{
                    moveX = 2f;
                    moveY = -2f;
                    progress = PartProgress.warmup;
                    under = true;
                    mirror = true;
                    moves.add(new PartMove(PartProgress.reload, -2f, 2f, 0f));
                }});
            }});

            weapons.add(new Weapon(){{
                shootSound = Sounds.explosionObviate;
                x = 0f;
                y = -2f;
                shootY = 0f;
                reload = 140f;
                mirror = false;
                minWarmup = 0.95f;
                shake = 3f;
                cooldownTime = reload - 10f;

                bullet = new BasicBulletType(){{
                    shoot = new ShootHelix(){{
                        mag = 1f;
                        scl = 5f;
                    }};

                    shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
                        colorTo = Pal.sapBulletBack;
                        sizeTo = 26f;
                        lifetime = 14f;
                        strokeFrom = 4f;
                    }});
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Pal.sapBullet;
                    despawnSound = Sounds.explosionArtilleryShock;

                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    speed = 3f;
                    damage = 75f;
                    lifetime = 60f;
                    width = height = 15f;
                    backColor = Pal.sapBulletBack;
                    frontColor = Pal.sapBullet;
                    shrinkX = shrinkY = 0f;
                    trailColor = Pal.sapBulletBack;
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = hitEffect = new ExplosionEffect(){{
                        waveColor = Pal.sapBullet;
                        smokeColor = Color.gray;
                        sparkColor = Pal.sap;
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};

                    intervalBullet = new LightningBulletType(){{
                        damage = 16;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = Pal.sapBullet;
                        lightningLength = 3;
                        lightningLengthRand = 6;

                        //for visual stats only.
                        buildingDamageMultiplier = 0.25f;

                        lightningType = new BulletType(0.0001f, 0f){{
                            lifetime = Fx.lightning.lifetime;
                            hitEffect = Fx.hitLancer;
                            despawnEffect = Fx.none;
                            status = StatusEffects.shocked;
                            statusDuration = 10f;
                            hittable = false;
                            lightColor = Color.white;
                            buildingDamageMultiplier = 0.25f;
                        }};
                    }};

                    bulletInterval = 4f;

                    lightningColor = Pal.sapBullet;
                    lightningDamage = 17;
                    lightning = 8;
                    lightningLength = 2;
                    lightningLengthRand = 8;
                }};

            }});
        }};

        darkQuell = new ErekirUnitType("dark-quell"){{
          constructor = UnitEntity::create;
            aiController = FlyingFollowAI::new;
            envDisabled = 0;

            lowAltitude = false;
            flying = true;
            drag = 0.06f;
            speed = 1.1f;
            rotateSpeed = 3.2f;
            accel = 0.1f;
            health = 6000f;
            armor = 4f;
            hitSize = 36f;
            payloadCapacity = Mathf.sqr(3f) * tilePayload;
            researchCostMultiplier = 0f;
            targetAir = false;

            engineSize = 4.8f;
            engineOffset = 61 / 4f;
            range = 4.3f * 60f * 1.4f;

            loopSoundVolume = 0.85f;
            loopSound = Sounds.loopHover;

            abilities.add(new SuppressionFieldAbility(){{
                reload = 60f * 8f;
                orbRadius = 5.3f;
                y = 1f;
            }});

            weapons.add(new Weapon("dark-quell-weapon"){{
                shootSound = Sounds.shootMissileSmall;
                x = 51 / 4f;
                y = 5 / 4f;
                rotate = true;
                rotateSpeed = 2f;
                reload = 55f;
                layerOffset = -0.001f;
                recoil = 1f;
                rotationLimit = 60f;

                bullet = new BasicBulletType(4.3f, 70f, "missile-large"){{
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke2;
                    shake = 1f;
                    lifetime = 60 * 0.496f;
                    rangeOverride = 361.2f;
                    followAimSpeed = 5f;

                    width = 12f;
                    height = 22f;
                    hitSize = 7f;
                    hitColor = backColor = trailColor = Pal.sapBulletBack;
                    trailWidth = 3f;
                    trailLength = 12;
                    hitEffect = despawnEffect = Fx.hitBulletColor;

                    keepVelocity = false;
                    collidesGround = true;
                    collidesAir = false;

                    //workaround to get the missile to behave like in spawnUnit while still spawning on death
                    fragRandomSpread = 0;
                    fragBullets = 1;
                    fragVelocityMin = 1f;
                    fragOffsetMax = 1f;

                    fragBullet = new BulletType(){{
                        speed = 0f;
                        keepVelocity = false;
                        collidesAir = false;
                        spawnUnit = new MissileUnitType("quell-missile"){{
                            targetAir = false;
                            speed = 4.3f;
                            maxRange = 6f;
                            lifetime = 60f * (1.4f - 0.496f);
                            outlineColor = Pal.darkOutline;
                            engineColor = trailColor = Pal.sapBulletBack;
                            engineLayer = Layer.effect;
                            health = 45;
                            loopSoundVolume = 0.1f;

                            weapons.add(new Weapon() {{
                                shootSound = Sounds.none;
                                shootCone = 360f;
                                mirror = false;
                                reload = 1f;
                                shootOnDeath = true;
                                bullet = new ExplosionBulletType(110f, 25f) {{
                                    shootEffect = Fx.massiveExplosion;
                                    collidesAir = false;
                                }};
                            }});
                        }};
                    }};
                }};
            }});

            setEnginesMirror(
            new UnitEngine(62 / 4f, -60 / 4f, 3.9f, 315f),
            new UnitEngine(72 / 4f, -29 / 4f, 3f, 315f)
            );
        }};

        darkDisrupt = new ErekirUnitType("dark-disrupt"){{
          constructor = UnitEntity::create;
            aiController = FlyingFollowAI::new;
            envDisabled = 0;

            lowAltitude = false;
            flying = true;
            drag = 0.07f;
            speed = 1f;
            rotateSpeed = 2f;
            accel = 0.1f;
            health = 12000f;
            armor = 9f;
            hitSize = 46f;
            payloadCapacity = Mathf.sqr(6f) * tilePayload;
            targetAir = false;

            engineSize = 6f;
            engineOffset = 25.25f;

            loopSound = Sounds.loopHover;

            float orbRad = 5f, partRad = 3f;
            int parts = 10;

            abilities.add(new SuppressionFieldAbility(){{
                reload = 60 * 15f;
                range = 320f;
                orbRadius = orbRad;
                particleSize = partRad;
                y = 10f;
                particles = parts;
            }});

            for(int i : Mathf.signs){
                abilities.add(new SuppressionFieldAbility(){{
                    orbRadius = orbRad;
                    particleSize = partRad;
                    y = -32f / 4f;
                    x = 43f * i / 4f;
                    particles = parts;
                    //visual only, the middle one does the actual suppressing
                    active = false;
                }});
            }

            weapons.add(new Weapon("dark-disrupt-weapon"){{
                shootSound = Sounds.shootMissileLarge;
                shootSoundVolume = 0.6f;
                x = 78f / 4f;
                y = -10f / 4f;
                mirror = true;
                rotate = true;
                rotateSpeed = 0.4f;
                reload = 70f;
                layerOffset = -20f;
                recoil = 1f;
                rotationLimit = 22f;
                minWarmup = 0.95f;
                shootWarmupSpeed = 0.1f;
                shootY = 2f;
                shootCone = 40f;
                shoot.shots = 3;
                shoot.shotDelay = 5f;
                inaccuracy = 28f;

                parts.add(new RegionPart("-blade"){{
                    heatProgress = PartProgress.warmup;
                    progress = PartProgress.warmup.blend(PartProgress.reload, 0.15f);
                    heatColor = Color.valueOf("9c50ff");
                    x = 5 / 4f;
                    y = 0f;
                    moveRot = -33f;
                    moveY = -1f;
                    moveX = -1f;
                    under = true;
                    mirror = true;
                }});

                bullet = new BulletType(){{
                    shootEffect = Fx.sparkShoot;
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Pal.suppress;
                    shake = 1f;
                    speed = 0f;
                    keepVelocity = false;
                    collidesAir = false;

                    spawnUnit = new MissileUnitType("disrupt-missile"){{
                        targetAir = false;
                        speed = 4.6f;
                        maxRange = 5f;
                        outlineColor = Pal.darkOutline;
                        health = 70;
                        homingDelay = 10f;
                        lowAltitude = true;
                        engineSize = 3f;
                        engineColor = trailColor = Pal.sapBulletBack;
                        engineLayer = Layer.effect;
                        deathExplosionEffect = Fx.none;
                        loopSoundVolume = 0.1f;

                        parts.add(new ShapePart(){{
                            layer = Layer.effect;
                            circle = true;
                            y = -0.25f;
                            radius = 1.5f;
                            color = Pal.suppress;
                            colorTo = Color.white;
                            progress = PartProgress.life.curve(Interp.pow5In);
                        }});

                        parts.add(new RegionPart("-fin"){{
                            mirror = true;
                            progress = PartProgress.life.mul(3f).curve(Interp.pow5In);
                            moveRot = 32f;
                            rotation = -6f;
                            moveY = 1.5f;
                            x = 3f / 4f;
                            y = -6f / 4f;
                        }});

                        weapons.add(new Weapon(){{
                            shootCone = 360f;
                            mirror = false;
                            reload = 1f;
                            shootOnDeath = true;
                            bullet = new ExplosionBulletType(140f, 25f){{
                                collidesAir = false;
                                suppressionRange = 140f;
                                shootEffect = new ExplosionEffect(){{
                                    lifetime = 50f;
                                    waveStroke = 5f;
                                    waveLife = 8f;
                                    waveColor = Color.white;
                                    sparkColor = smokeColor = Pal.suppress;
                                    waveRad = 40f;
                                    smokeSize = 4f;
                                    smokes = 7;
                                    smokeSizeBase = 0f;
                                    sparks = 10;
                                    sparkRad = 40f;
                                    sparkLen = 6f;
                                    sparkStroke = 2f;
                                }};
                            }};
                        }});
                    }};
                }};
            }});

            setEnginesMirror(
            new UnitEngine(95 / 4f, -56 / 4f, 5f, 330f),
            new UnitEngine(89 / 4f, -95 / 4f, 4f, 315f)
            );
        }};
  }
}

package me.sparky983.vision;

import java.util.Optional;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import net.kyori.adventure.translation.Translatable;
import org.jspecify.annotations.NullMarked;

/**
 * An item type.
 * <p>
 * All items are included as constants in this interface.
 *
 * @since 0.1
 */
@SuppressWarnings("unused")
@NullMarked
public sealed interface ItemType extends Keyed, Translatable permits ItemTypeImpl {
  // <editor-fold desc="ItemTypes" defaultstate="collapsed">
  // @formatter:off
  /**
   * The minecraft:acacia_boat item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_BOAT = item(Key.key("acacia_boat"));

  /**
   * The minecraft:acacia_button item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_BUTTON = block(Key.key("acacia_button"));

  /**
   * The minecraft:acacia_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_CHEST_BOAT = item(Key.key("acacia_chest_boat"));

  /**
   * The minecraft:acacia_door item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_DOOR = block(Key.key("acacia_door"));

  /**
   * The minecraft:acacia_fence item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_FENCE = block(Key.key("acacia_fence"));

  /**
   * The minecraft:acacia_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_FENCE_GATE = block(Key.key("acacia_fence_gate"));

  /**
   * The minecraft:acacia_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_HANGING_SIGN = block(Key.key("acacia_hanging_sign"));

  /**
   * The minecraft:acacia_leaves item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_LEAVES = block(Key.key("acacia_leaves"));

  /**
   * The minecraft:acacia_log item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_LOG = block(Key.key("acacia_log"));

  /**
   * The minecraft:acacia_planks item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_PLANKS = block(Key.key("acacia_planks"));

  /**
   * The minecraft:acacia_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_PRESSURE_PLATE = block(Key.key("acacia_pressure_plate"));

  /**
   * The minecraft:acacia_sapling item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_SAPLING = block(Key.key("acacia_sapling"));

  /**
   * The minecraft:acacia_sign item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_SIGN = block(Key.key("acacia_sign"));

  /**
   * The minecraft:acacia_slab item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_SLAB = block(Key.key("acacia_slab"));

  /**
   * The minecraft:acacia_stairs item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_STAIRS = block(Key.key("acacia_stairs"));

  /**
   * The minecraft:acacia_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_TRAPDOOR = block(Key.key("acacia_trapdoor"));

  /**
   * The minecraft:acacia_wood item type.
   *
   * @since 0.1
   */
  ItemType ACACIA_WOOD = block(Key.key("acacia_wood"));

  /**
   * The minecraft:activator_rail item type.
   *
   * @since 0.1
   */
  ItemType ACTIVATOR_RAIL = block(Key.key("activator_rail"));

  /**
   * The minecraft:allay_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ALLAY_SPAWN_EGG = item(Key.key("allay_spawn_egg"));

  /**
   * The minecraft:allium item type.
   *
   * @since 0.1
   */
  ItemType ALLIUM = block(Key.key("allium"));

  /**
   * The minecraft:amethyst_block item type.
   *
   * @since 0.1
   */
  ItemType AMETHYST_BLOCK = block(Key.key("amethyst_block"));

  /**
   * The minecraft:amethyst_cluster item type.
   *
   * @since 0.1
   */
  ItemType AMETHYST_CLUSTER = block(Key.key("amethyst_cluster"));

  /**
   * The minecraft:amethyst_shard item type.
   *
   * @since 0.1
   */
  ItemType AMETHYST_SHARD = item(Key.key("amethyst_shard"));

  /**
   * The minecraft:ancient_debris item type.
   *
   * @since 0.1
   */
  ItemType ANCIENT_DEBRIS = block(Key.key("ancient_debris"));

  /**
   * The minecraft:andesite item type.
   *
   * @since 0.1
   */
  ItemType ANDESITE = block(Key.key("andesite"));

  /**
   * The minecraft:andesite_slab item type.
   *
   * @since 0.1
   */
  ItemType ANDESITE_SLAB = block(Key.key("andesite_slab"));

  /**
   * The minecraft:andesite_stairs item type.
   *
   * @since 0.1
   */
  ItemType ANDESITE_STAIRS = block(Key.key("andesite_stairs"));

  /**
   * The minecraft:andesite_wall item type.
   *
   * @since 0.1
   */
  ItemType ANDESITE_WALL = block(Key.key("andesite_wall"));

  /**
   * The minecraft:angler_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType ANGLER_POTTERY_SHERD = item(Key.key("angler_pottery_sherd"));

  /**
   * The minecraft:anvil item type.
   *
   * @since 0.1
   */
  ItemType ANVIL = block(Key.key("anvil"));

  /**
   * The minecraft:apple item type.
   *
   * @since 0.1
   */
  ItemType APPLE = item(Key.key("apple"));

  /**
   * The minecraft:archer_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType ARCHER_POTTERY_SHERD = item(Key.key("archer_pottery_sherd"));

  /**
   * The minecraft:armor_stand item type.
   *
   * @since 0.1
   */
  ItemType ARMOR_STAND = item(Key.key("armor_stand"));

  /**
   * The minecraft:arms_up_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType ARMS_UP_POTTERY_SHERD = item(Key.key("arms_up_pottery_sherd"));

  /**
   * The minecraft:arrow item type.
   *
   * @since 0.1
   */
  ItemType ARROW = item(Key.key("arrow"));

  /**
   * The minecraft:axolotl_bucket item type.
   *
   * @since 0.1
   */
  ItemType AXOLOTL_BUCKET = item(Key.key("axolotl_bucket"));

  /**
   * The minecraft:axolotl_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType AXOLOTL_SPAWN_EGG = item(Key.key("axolotl_spawn_egg"));

  /**
   * The minecraft:azalea item type.
   *
   * @since 0.1
   */
  ItemType AZALEA = block(Key.key("azalea"));

  /**
   * The minecraft:azalea_leaves item type.
   *
   * @since 0.1
   */
  ItemType AZALEA_LEAVES = block(Key.key("azalea_leaves"));

  /**
   * The minecraft:azure_bluet item type.
   *
   * @since 0.1
   */
  ItemType AZURE_BLUET = block(Key.key("azure_bluet"));

  /**
   * The minecraft:baked_potato item type.
   *
   * @since 0.1
   */
  ItemType BAKED_POTATO = item(Key.key("baked_potato"));

  /**
   * The minecraft:bamboo item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO = block(Key.key("bamboo"));

  /**
   * The minecraft:bamboo_block item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_BLOCK = block(Key.key("bamboo_block"));

  /**
   * The minecraft:bamboo_button item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_BUTTON = block(Key.key("bamboo_button"));

  /**
   * The minecraft:bamboo_chest_raft item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_CHEST_RAFT = item(Key.key("bamboo_chest_raft"));

  /**
   * The minecraft:bamboo_door item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_DOOR = block(Key.key("bamboo_door"));

  /**
   * The minecraft:bamboo_fence item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_FENCE = block(Key.key("bamboo_fence"));

  /**
   * The minecraft:bamboo_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_FENCE_GATE = block(Key.key("bamboo_fence_gate"));

  /**
   * The minecraft:bamboo_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_HANGING_SIGN = block(Key.key("bamboo_hanging_sign"));

  /**
   * The minecraft:bamboo_mosaic item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_MOSAIC = block(Key.key("bamboo_mosaic"));

  /**
   * The minecraft:bamboo_mosaic_slab item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_MOSAIC_SLAB = block(Key.key("bamboo_mosaic_slab"));

  /**
   * The minecraft:bamboo_mosaic_stairs item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_MOSAIC_STAIRS = block(Key.key("bamboo_mosaic_stairs"));

  /**
   * The minecraft:bamboo_planks item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_PLANKS = block(Key.key("bamboo_planks"));

  /**
   * The minecraft:bamboo_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_PRESSURE_PLATE = block(Key.key("bamboo_pressure_plate"));

  /**
   * The minecraft:bamboo_raft item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_RAFT = item(Key.key("bamboo_raft"));

  /**
   * The minecraft:bamboo_sign item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_SIGN = block(Key.key("bamboo_sign"));

  /**
   * The minecraft:bamboo_slab item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_SLAB = block(Key.key("bamboo_slab"));

  /**
   * The minecraft:bamboo_stairs item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_STAIRS = block(Key.key("bamboo_stairs"));

  /**
   * The minecraft:bamboo_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType BAMBOO_TRAPDOOR = block(Key.key("bamboo_trapdoor"));

  /**
   * The minecraft:barrel item type.
   *
   * @since 0.1
   */
  ItemType BARREL = block(Key.key("barrel"));

  /**
   * The minecraft:barrier item type.
   *
   * @since 0.1
   */
  ItemType BARRIER = block(Key.key("barrier"));

  /**
   * The minecraft:basalt item type.
   *
   * @since 0.1
   */
  ItemType BASALT = block(Key.key("basalt"));

  /**
   * The minecraft:bat_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType BAT_SPAWN_EGG = item(Key.key("bat_spawn_egg"));

  /**
   * The minecraft:beacon item type.
   *
   * @since 0.1
   */
  ItemType BEACON = block(Key.key("beacon"));

  /**
   * The minecraft:bedrock item type.
   *
   * @since 0.1
   */
  ItemType BEDROCK = block(Key.key("bedrock"));

  /**
   * The minecraft:bee_nest item type.
   *
   * @since 0.1
   */
  ItemType BEE_NEST = block(Key.key("bee_nest"));

  /**
   * The minecraft:bee_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType BEE_SPAWN_EGG = item(Key.key("bee_spawn_egg"));

  /**
   * The minecraft:beef item type.
   *
   * @since 0.1
   */
  ItemType BEEF = item(Key.key("beef"));

  /**
   * The minecraft:beehive item type.
   *
   * @since 0.1
   */
  ItemType BEEHIVE = block(Key.key("beehive"));

  /**
   * The minecraft:beetroot item type.
   *
   * @since 0.1
   */
  ItemType BEETROOT = item(Key.key("beetroot"));

  /**
   * The minecraft:beetroot_seeds item type.
   *
   * @since 0.1
   */
  ItemType BEETROOT_SEEDS = item(Key.key("beetroot_seeds"));

  /**
   * The minecraft:beetroot_soup item type.
   *
   * @since 0.1
   */
  ItemType BEETROOT_SOUP = item(Key.key("beetroot_soup"));

  /**
   * The minecraft:bell item type.
   *
   * @since 0.1
   */
  ItemType BELL = block(Key.key("bell"));

  /**
   * The minecraft:big_dripleaf item type.
   *
   * @since 0.1
   */
  ItemType BIG_DRIPLEAF = block(Key.key("big_dripleaf"));

  /**
   * The minecraft:birch_boat item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_BOAT = item(Key.key("birch_boat"));

  /**
   * The minecraft:birch_button item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_BUTTON = block(Key.key("birch_button"));

  /**
   * The minecraft:birch_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_CHEST_BOAT = item(Key.key("birch_chest_boat"));

  /**
   * The minecraft:birch_door item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_DOOR = block(Key.key("birch_door"));

  /**
   * The minecraft:birch_fence item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_FENCE = block(Key.key("birch_fence"));

  /**
   * The minecraft:birch_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_FENCE_GATE = block(Key.key("birch_fence_gate"));

  /**
   * The minecraft:birch_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_HANGING_SIGN = block(Key.key("birch_hanging_sign"));

  /**
   * The minecraft:birch_leaves item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_LEAVES = block(Key.key("birch_leaves"));

  /**
   * The minecraft:birch_log item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_LOG = block(Key.key("birch_log"));

  /**
   * The minecraft:birch_planks item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_PLANKS = block(Key.key("birch_planks"));

  /**
   * The minecraft:birch_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_PRESSURE_PLATE = block(Key.key("birch_pressure_plate"));

  /**
   * The minecraft:birch_sapling item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_SAPLING = block(Key.key("birch_sapling"));

  /**
   * The minecraft:birch_sign item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_SIGN = block(Key.key("birch_sign"));

  /**
   * The minecraft:birch_slab item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_SLAB = block(Key.key("birch_slab"));

  /**
   * The minecraft:birch_stairs item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_STAIRS = block(Key.key("birch_stairs"));

  /**
   * The minecraft:birch_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_TRAPDOOR = block(Key.key("birch_trapdoor"));

  /**
   * The minecraft:birch_wood item type.
   *
   * @since 0.1
   */
  ItemType BIRCH_WOOD = block(Key.key("birch_wood"));

  /**
   * The minecraft:black_banner item type.
   *
   * @since 0.1
   */
  ItemType BLACK_BANNER = block(Key.key("black_banner"));

  /**
   * The minecraft:black_bed item type.
   *
   * @since 0.1
   */
  ItemType BLACK_BED = block(Key.key("black_bed"));

  /**
   * The minecraft:black_candle item type.
   *
   * @since 0.1
   */
  ItemType BLACK_CANDLE = block(Key.key("black_candle"));

  /**
   * The minecraft:black_carpet item type.
   *
   * @since 0.1
   */
  ItemType BLACK_CARPET = block(Key.key("black_carpet"));

  /**
   * The minecraft:black_concrete item type.
   *
   * @since 0.1
   */
  ItemType BLACK_CONCRETE = block(Key.key("black_concrete"));

  /**
   * The minecraft:black_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType BLACK_CONCRETE_POWDER = block(Key.key("black_concrete_powder"));

  /**
   * The minecraft:black_dye item type.
   *
   * @since 0.1
   */
  ItemType BLACK_DYE = item(Key.key("black_dye"));

  /**
   * The minecraft:black_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType BLACK_GLAZED_TERRACOTTA = block(Key.key("black_glazed_terracotta"));

  /**
   * The minecraft:black_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType BLACK_SHULKER_BOX = block(Key.key("black_shulker_box"));

  /**
   * The minecraft:black_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType BLACK_STAINED_GLASS = block(Key.key("black_stained_glass"));

  /**
   * The minecraft:black_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType BLACK_STAINED_GLASS_PANE = block(Key.key("black_stained_glass_pane"));

  /**
   * The minecraft:black_terracotta item type.
   *
   * @since 0.1
   */
  ItemType BLACK_TERRACOTTA = block(Key.key("black_terracotta"));

  /**
   * The minecraft:black_wool item type.
   *
   * @since 0.1
   */
  ItemType BLACK_WOOL = block(Key.key("black_wool"));

  /**
   * The minecraft:blackstone item type.
   *
   * @since 0.1
   */
  ItemType BLACKSTONE = block(Key.key("blackstone"));

  /**
   * The minecraft:blackstone_slab item type.
   *
   * @since 0.1
   */
  ItemType BLACKSTONE_SLAB = block(Key.key("blackstone_slab"));

  /**
   * The minecraft:blackstone_stairs item type.
   *
   * @since 0.1
   */
  ItemType BLACKSTONE_STAIRS = block(Key.key("blackstone_stairs"));

  /**
   * The minecraft:blackstone_wall item type.
   *
   * @since 0.1
   */
  ItemType BLACKSTONE_WALL = block(Key.key("blackstone_wall"));

  /**
   * The minecraft:blade_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType BLADE_POTTERY_SHERD = item(Key.key("blade_pottery_sherd"));

  /**
   * The minecraft:blast_furnace item type.
   *
   * @since 0.1
   */
  ItemType BLAST_FURNACE = block(Key.key("blast_furnace"));

  /**
   * The minecraft:blaze_powder item type.
   *
   * @since 0.1
   */
  ItemType BLAZE_POWDER = item(Key.key("blaze_powder"));

  /**
   * The minecraft:blaze_rod item type.
   *
   * @since 0.1
   */
  ItemType BLAZE_ROD = item(Key.key("blaze_rod"));

  /**
   * The minecraft:blaze_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType BLAZE_SPAWN_EGG = item(Key.key("blaze_spawn_egg"));

  /**
   * The minecraft:blue_banner item type.
   *
   * @since 0.1
   */
  ItemType BLUE_BANNER = block(Key.key("blue_banner"));

  /**
   * The minecraft:blue_bed item type.
   *
   * @since 0.1
   */
  ItemType BLUE_BED = block(Key.key("blue_bed"));

  /**
   * The minecraft:blue_candle item type.
   *
   * @since 0.1
   */
  ItemType BLUE_CANDLE = block(Key.key("blue_candle"));

  /**
   * The minecraft:blue_carpet item type.
   *
   * @since 0.1
   */
  ItemType BLUE_CARPET = block(Key.key("blue_carpet"));

  /**
   * The minecraft:blue_concrete item type.
   *
   * @since 0.1
   */
  ItemType BLUE_CONCRETE = block(Key.key("blue_concrete"));

  /**
   * The minecraft:blue_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType BLUE_CONCRETE_POWDER = block(Key.key("blue_concrete_powder"));

  /**
   * The minecraft:blue_dye item type.
   *
   * @since 0.1
   */
  ItemType BLUE_DYE = item(Key.key("blue_dye"));

  /**
   * The minecraft:blue_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType BLUE_GLAZED_TERRACOTTA = block(Key.key("blue_glazed_terracotta"));

  /**
   * The minecraft:blue_ice item type.
   *
   * @since 0.1
   */
  ItemType BLUE_ICE = block(Key.key("blue_ice"));

  /**
   * The minecraft:blue_orchid item type.
   *
   * @since 0.1
   */
  ItemType BLUE_ORCHID = block(Key.key("blue_orchid"));

  /**
   * The minecraft:blue_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType BLUE_SHULKER_BOX = block(Key.key("blue_shulker_box"));

  /**
   * The minecraft:blue_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType BLUE_STAINED_GLASS = block(Key.key("blue_stained_glass"));

  /**
   * The minecraft:blue_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType BLUE_STAINED_GLASS_PANE = block(Key.key("blue_stained_glass_pane"));

  /**
   * The minecraft:blue_terracotta item type.
   *
   * @since 0.1
   */
  ItemType BLUE_TERRACOTTA = block(Key.key("blue_terracotta"));

  /**
   * The minecraft:blue_wool item type.
   *
   * @since 0.1
   */
  ItemType BLUE_WOOL = block(Key.key("blue_wool"));

  /**
   * The minecraft:bone item type.
   *
   * @since 0.1
   */
  ItemType BONE = item(Key.key("bone"));

  /**
   * The minecraft:bone_block item type.
   *
   * @since 0.1
   */
  ItemType BONE_BLOCK = block(Key.key("bone_block"));

  /**
   * The minecraft:bone_meal item type.
   *
   * @since 0.1
   */
  ItemType BONE_MEAL = item(Key.key("bone_meal"));

  /**
   * The minecraft:book item type.
   *
   * @since 0.1
   */
  ItemType BOOK = item(Key.key("book"));

  /**
   * The minecraft:bookshelf item type.
   *
   * @since 0.1
   */
  ItemType BOOKSHELF = block(Key.key("bookshelf"));

  /**
   * The minecraft:bow item type.
   *
   * @since 0.1
   */
  ItemType BOW = item(Key.key("bow"));

  /**
   * The minecraft:bowl item type.
   *
   * @since 0.1
   */
  ItemType BOWL = item(Key.key("bowl"));

  /**
   * The minecraft:brain_coral item type.
   *
   * @since 0.1
   */
  ItemType BRAIN_CORAL = block(Key.key("brain_coral"));

  /**
   * The minecraft:brain_coral_block item type.
   *
   * @since 0.1
   */
  ItemType BRAIN_CORAL_BLOCK = block(Key.key("brain_coral_block"));

  /**
   * The minecraft:brain_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType BRAIN_CORAL_FAN = block(Key.key("brain_coral_fan"));

  /**
   * The minecraft:bread item type.
   *
   * @since 0.1
   */
  ItemType BREAD = item(Key.key("bread"));

  /**
   * The minecraft:brewer_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType BREWER_POTTERY_SHERD = item(Key.key("brewer_pottery_sherd"));

  /**
   * The minecraft:brewing_stand item type.
   *
   * @since 0.1
   */
  ItemType BREWING_STAND = block(Key.key("brewing_stand"));

  /**
   * The minecraft:brick item type.
   *
   * @since 0.1
   */
  ItemType BRICK = item(Key.key("brick"));

  /**
   * The minecraft:brick_slab item type.
   *
   * @since 0.1
   */
  ItemType BRICK_SLAB = block(Key.key("brick_slab"));

  /**
   * The minecraft:brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType BRICK_STAIRS = block(Key.key("brick_stairs"));

  /**
   * The minecraft:brick_wall item type.
   *
   * @since 0.1
   */
  ItemType BRICK_WALL = block(Key.key("brick_wall"));

  /**
   * The minecraft:bricks item type.
   *
   * @since 0.1
   */
  ItemType BRICKS = block(Key.key("bricks"));

  /**
   * The minecraft:brown_banner item type.
   *
   * @since 0.1
   */
  ItemType BROWN_BANNER = block(Key.key("brown_banner"));

  /**
   * The minecraft:brown_bed item type.
   *
   * @since 0.1
   */
  ItemType BROWN_BED = block(Key.key("brown_bed"));

  /**
   * The minecraft:brown_candle item type.
   *
   * @since 0.1
   */
  ItemType BROWN_CANDLE = block(Key.key("brown_candle"));

  /**
   * The minecraft:brown_carpet item type.
   *
   * @since 0.1
   */
  ItemType BROWN_CARPET = block(Key.key("brown_carpet"));

  /**
   * The minecraft:brown_concrete item type.
   *
   * @since 0.1
   */
  ItemType BROWN_CONCRETE = block(Key.key("brown_concrete"));

  /**
   * The minecraft:brown_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType BROWN_CONCRETE_POWDER = block(Key.key("brown_concrete_powder"));

  /**
   * The minecraft:brown_dye item type.
   *
   * @since 0.1
   */
  ItemType BROWN_DYE = item(Key.key("brown_dye"));

  /**
   * The minecraft:brown_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType BROWN_GLAZED_TERRACOTTA = block(Key.key("brown_glazed_terracotta"));

  /**
   * The minecraft:brown_mushroom item type.
   *
   * @since 0.1
   */
  ItemType BROWN_MUSHROOM = block(Key.key("brown_mushroom"));

  /**
   * The minecraft:brown_mushroom_block item type.
   *
   * @since 0.1
   */
  ItemType BROWN_MUSHROOM_BLOCK = block(Key.key("brown_mushroom_block"));

  /**
   * The minecraft:brown_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType BROWN_SHULKER_BOX = block(Key.key("brown_shulker_box"));

  /**
   * The minecraft:brown_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType BROWN_STAINED_GLASS = block(Key.key("brown_stained_glass"));

  /**
   * The minecraft:brown_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType BROWN_STAINED_GLASS_PANE = block(Key.key("brown_stained_glass_pane"));

  /**
   * The minecraft:brown_terracotta item type.
   *
   * @since 0.1
   */
  ItemType BROWN_TERRACOTTA = block(Key.key("brown_terracotta"));

  /**
   * The minecraft:brown_wool item type.
   *
   * @since 0.1
   */
  ItemType BROWN_WOOL = block(Key.key("brown_wool"));

  /**
   * The minecraft:brush item type.
   *
   * @since 0.1
   */
  ItemType BRUSH = item(Key.key("brush"));

  /**
   * The minecraft:bubble_coral item type.
   *
   * @since 0.1
   */
  ItemType BUBBLE_CORAL = block(Key.key("bubble_coral"));

  /**
   * The minecraft:bubble_coral_block item type.
   *
   * @since 0.1
   */
  ItemType BUBBLE_CORAL_BLOCK = block(Key.key("bubble_coral_block"));

  /**
   * The minecraft:bubble_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType BUBBLE_CORAL_FAN = block(Key.key("bubble_coral_fan"));

  /**
   * The minecraft:bucket item type.
   *
   * @since 0.1
   */
  ItemType BUCKET = item(Key.key("bucket"));

  /**
   * The minecraft:budding_amethyst item type.
   *
   * @since 0.1
   */
  ItemType BUDDING_AMETHYST = block(Key.key("budding_amethyst"));

  /**
   * The minecraft:bundle item type.
   *
   * @since 0.1
   */
  ItemType BUNDLE = item(Key.key("bundle"));

  /**
   * The minecraft:burn_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType BURN_POTTERY_SHERD = item(Key.key("burn_pottery_sherd"));

  /**
   * The minecraft:cactus item type.
   *
   * @since 0.1
   */
  ItemType CACTUS = block(Key.key("cactus"));

  /**
   * The minecraft:cake item type.
   *
   * @since 0.1
   */
  ItemType CAKE = block(Key.key("cake"));

  /**
   * The minecraft:calcite item type.
   *
   * @since 0.1
   */
  ItemType CALCITE = block(Key.key("calcite"));

  /**
   * The minecraft:calibrated_sculk_sensor item type.
   *
   * @since 0.2
   */
  ItemType CALIBRATED_SCULK_SENSOR = block(Key.key("calibrated_sculk_sensor"));

  /**
   * The minecraft:camel_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType CAMEL_SPAWN_EGG = item(Key.key("camel_spawn_egg"));

  /**
   * The minecraft:campfire item type.
   *
   * @since 0.1
   */
  ItemType CAMPFIRE = block(Key.key("campfire"));

  /**
   * The minecraft:candle item type.
   *
   * @since 0.1
   */
  ItemType CANDLE = block(Key.key("candle"));

  /**
   * The minecraft:carrot item type.
   *
   * @since 0.1
   */
  ItemType CARROT = item(Key.key("carrot"));

  /**
   * The minecraft:carrot_on_a_stick item type.
   *
   * @since 0.1
   */
  ItemType CARROT_ON_A_STICK = item(Key.key("carrot_on_a_stick"));

  /**
   * The minecraft:cartography_table item type.
   *
   * @since 0.1
   */
  ItemType CARTOGRAPHY_TABLE = block(Key.key("cartography_table"));

  /**
   * The minecraft:carved_pumpkin item type.
   *
   * @since 0.1
   */
  ItemType CARVED_PUMPKIN = block(Key.key("carved_pumpkin"));

  /**
   * The minecraft:cat_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType CAT_SPAWN_EGG = item(Key.key("cat_spawn_egg"));

  /**
   * The minecraft:cauldron item type.
   *
   * @since 0.1
   */
  ItemType CAULDRON = block(Key.key("cauldron"));

  /**
   * The minecraft:cave_spider_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType CAVE_SPIDER_SPAWN_EGG = item(Key.key("cave_spider_spawn_egg"));

  /**
   * The minecraft:chain item type.
   *
   * @since 0.1
   */
  ItemType CHAIN = block(Key.key("chain"));

  /**
   * The minecraft:chain_command_block item type.
   *
   * @since 0.1
   */
  ItemType CHAIN_COMMAND_BLOCK = block(Key.key("chain_command_block"));

  /**
   * The minecraft:chainmail_boots item type.
   *
   * @since 0.1
   */
  ItemType CHAINMAIL_BOOTS = item(Key.key("chainmail_boots"));

  /**
   * The minecraft:chainmail_chestplate item type.
   *
   * @since 0.1
   */
  ItemType CHAINMAIL_CHESTPLATE = item(Key.key("chainmail_chestplate"));

  /**
   * The minecraft:chainmail_helmet item type.
   *
   * @since 0.1
   */
  ItemType CHAINMAIL_HELMET = item(Key.key("chainmail_helmet"));

  /**
   * The minecraft:chainmail_leggings item type.
   *
   * @since 0.1
   */
  ItemType CHAINMAIL_LEGGINGS = item(Key.key("chainmail_leggings"));

  /**
   * The minecraft:charcoal item type.
   *
   * @since 0.1
   */
  ItemType CHARCOAL = item(Key.key("charcoal"));

  /**
   * The minecraft:cherry_boat item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_BOAT = item(Key.key("cherry_boat"));

  /**
   * The minecraft:cherry_button item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_BUTTON = block(Key.key("cherry_button"));

  /**
   * The minecraft:cherry_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_CHEST_BOAT = item(Key.key("cherry_chest_boat"));

  /**
   * The minecraft:cherry_door item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_DOOR = block(Key.key("cherry_door"));

  /**
   * The minecraft:cherry_fence item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_FENCE = block(Key.key("cherry_fence"));

  /**
   * The minecraft:cherry_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_FENCE_GATE = block(Key.key("cherry_fence_gate"));

  /**
   * The minecraft:cherry_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_HANGING_SIGN = block(Key.key("cherry_hanging_sign"));

  /**
   * The minecraft:cherry_leaves item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_LEAVES = block(Key.key("cherry_leaves"));

  /**
   * The minecraft:cherry_log item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_LOG = block(Key.key("cherry_log"));

  /**
   * The minecraft:cherry_planks item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_PLANKS = block(Key.key("cherry_planks"));

  /**
   * The minecraft:cherry_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_PRESSURE_PLATE = block(Key.key("cherry_pressure_plate"));

  /**
   * The minecraft:cherry_sapling item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_SAPLING = block(Key.key("cherry_sapling"));

  /**
   * The minecraft:cherry_sign item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_SIGN = block(Key.key("cherry_sign"));

  /**
   * The minecraft:cherry_slab item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_SLAB = block(Key.key("cherry_slab"));

  /**
   * The minecraft:cherry_stairs item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_STAIRS = block(Key.key("cherry_stairs"));

  /**
   * The minecraft:cherry_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_TRAPDOOR = block(Key.key("cherry_trapdoor"));

  /**
   * The minecraft:cherry_wood item type.
   *
   * @since 0.1
   */
  ItemType CHERRY_WOOD = block(Key.key("cherry_wood"));

  /**
   * The minecraft:chest item type.
   *
   * @since 0.1
   */
  ItemType CHEST = block(Key.key("chest"));

  /**
   * The minecraft:chest_minecart item type.
   *
   * @since 0.1
   */
  ItemType CHEST_MINECART = item(Key.key("chest_minecart"));

  /**
   * The minecraft:chicken item type.
   *
   * @since 0.1
   */
  ItemType CHICKEN = item(Key.key("chicken"));

  /**
   * The minecraft:chicken_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType CHICKEN_SPAWN_EGG = item(Key.key("chicken_spawn_egg"));

  /**
   * The minecraft:chipped_anvil item type.
   *
   * @since 0.1
   */
  ItemType CHIPPED_ANVIL = block(Key.key("chipped_anvil"));

  /**
   * The minecraft:chiseled_bookshelf item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_BOOKSHELF = block(Key.key("chiseled_bookshelf"));

  /**
   * The minecraft:chiseled_deepslate item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_DEEPSLATE = block(Key.key("chiseled_deepslate"));

  /**
   * The minecraft:chiseled_nether_bricks item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_NETHER_BRICKS = block(Key.key("chiseled_nether_bricks"));

  /**
   * The minecraft:chiseled_polished_blackstone item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_POLISHED_BLACKSTONE = block(Key.key("chiseled_polished_blackstone"));

  /**
   * The minecraft:chiseled_quartz_block item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_QUARTZ_BLOCK = block(Key.key("chiseled_quartz_block"));

  /**
   * The minecraft:chiseled_red_sandstone item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_RED_SANDSTONE = block(Key.key("chiseled_red_sandstone"));

  /**
   * The minecraft:chiseled_sandstone item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_SANDSTONE = block(Key.key("chiseled_sandstone"));

  /**
   * The minecraft:chiseled_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType CHISELED_STONE_BRICKS = block(Key.key("chiseled_stone_bricks"));

  /**
   * The minecraft:chorus_flower item type.
   *
   * @since 0.1
   */
  ItemType CHORUS_FLOWER = block(Key.key("chorus_flower"));

  /**
   * The minecraft:chorus_fruit item type.
   *
   * @since 0.1
   */
  ItemType CHORUS_FRUIT = item(Key.key("chorus_fruit"));

  /**
   * The minecraft:chorus_plant item type.
   *
   * @since 0.1
   */
  ItemType CHORUS_PLANT = block(Key.key("chorus_plant"));

  /**
   * The minecraft:clay item type.
   *
   * @since 0.1
   */
  ItemType CLAY = block(Key.key("clay"));

  /**
   * The minecraft:clay_ball item type.
   *
   * @since 0.1
   */
  ItemType CLAY_BALL = item(Key.key("clay_ball"));

  /**
   * The minecraft:clock item type.
   *
   * @since 0.1
   */
  ItemType CLOCK = item(Key.key("clock"));

  /**
   * The minecraft:coal item type.
   *
   * @since 0.1
   */
  ItemType COAL = item(Key.key("coal"));

  /**
   * The minecraft:coal_block item type.
   *
   * @since 0.1
   */
  ItemType COAL_BLOCK = block(Key.key("coal_block"));

  /**
   * The minecraft:coal_ore item type.
   *
   * @since 0.1
   */
  ItemType COAL_ORE = block(Key.key("coal_ore"));

  /**
   * The minecraft:coarse_dirt item type.
   *
   * @since 0.1
   */
  ItemType COARSE_DIRT = block(Key.key("coarse_dirt"));

  /**
   * The minecraft:coast_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType COAST_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("coast_armor_trim_smithing_template"));

  /**
   * The minecraft:cobbled_deepslate item type.
   *
   * @since 0.1
   */
  ItemType COBBLED_DEEPSLATE = block(Key.key("cobbled_deepslate"));

  /**
   * The minecraft:cobbled_deepslate_slab item type.
   *
   * @since 0.1
   */
  ItemType COBBLED_DEEPSLATE_SLAB = block(Key.key("cobbled_deepslate_slab"));

  /**
   * The minecraft:cobbled_deepslate_stairs item type.
   *
   * @since 0.1
   */
  ItemType COBBLED_DEEPSLATE_STAIRS = block(Key.key("cobbled_deepslate_stairs"));

  /**
   * The minecraft:cobbled_deepslate_wall item type.
   *
   * @since 0.1
   */
  ItemType COBBLED_DEEPSLATE_WALL = block(Key.key("cobbled_deepslate_wall"));

  /**
   * The minecraft:cobblestone item type.
   *
   * @since 0.1
   */
  ItemType COBBLESTONE = block(Key.key("cobblestone"));

  /**
   * The minecraft:cobblestone_slab item type.
   *
   * @since 0.1
   */
  ItemType COBBLESTONE_SLAB = block(Key.key("cobblestone_slab"));

  /**
   * The minecraft:cobblestone_stairs item type.
   *
   * @since 0.1
   */
  ItemType COBBLESTONE_STAIRS = block(Key.key("cobblestone_stairs"));

  /**
   * The minecraft:cobblestone_wall item type.
   *
   * @since 0.1
   */
  ItemType COBBLESTONE_WALL = block(Key.key("cobblestone_wall"));

  /**
   * The minecraft:cobweb item type.
   *
   * @since 0.1
   */
  ItemType COBWEB = block(Key.key("cobweb"));

  /**
   * The minecraft:cocoa_beans item type.
   *
   * @since 0.1
   */
  ItemType COCOA_BEANS = item(Key.key("cocoa_beans"));

  /**
   * The minecraft:cod item type.
   *
   * @since 0.1
   */
  ItemType COD = item(Key.key("cod"));

  /**
   * The minecraft:cod_bucket item type.
   *
   * @since 0.1
   */
  ItemType COD_BUCKET = item(Key.key("cod_bucket"));

  /**
   * The minecraft:cod_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType COD_SPAWN_EGG = item(Key.key("cod_spawn_egg"));

  /**
   * The minecraft:command_block item type.
   *
   * @since 0.1
   */
  ItemType COMMAND_BLOCK = block(Key.key("command_block"));

  /**
   * The minecraft:command_block_minecart item type.
   *
   * @since 0.1
   */
  ItemType COMMAND_BLOCK_MINECART = item(Key.key("command_block_minecart"));

  /**
   * The minecraft:comparator item type.
   *
   * @since 0.1
   */
  ItemType COMPARATOR = block(Key.key("comparator"));

  /**
   * The minecraft:compass item type.
   *
   * @since 0.1
   */
  ItemType COMPASS = item(Key.key("compass"));

  /**
   * The minecraft:composter item type.
   *
   * @since 0.1
   */
  ItemType COMPOSTER = block(Key.key("composter"));

  /**
   * The minecraft:conduit item type.
   *
   * @since 0.1
   */
  ItemType CONDUIT = block(Key.key("conduit"));

  /**
   * The minecraft:cooked_beef item type.
   *
   * @since 0.1
   */
  ItemType COOKED_BEEF = item(Key.key("cooked_beef"));

  /**
   * The minecraft:cooked_chicken item type.
   *
   * @since 0.1
   */
  ItemType COOKED_CHICKEN = item(Key.key("cooked_chicken"));

  /**
   * The minecraft:cooked_cod item type.
   *
   * @since 0.1
   */
  ItemType COOKED_COD = item(Key.key("cooked_cod"));

  /**
   * The minecraft:cooked_mutton item type.
   *
   * @since 0.1
   */
  ItemType COOKED_MUTTON = item(Key.key("cooked_mutton"));

  /**
   * The minecraft:cooked_porkchop item type.
   *
   * @since 0.1
   */
  ItemType COOKED_PORKCHOP = item(Key.key("cooked_porkchop"));

  /**
   * The minecraft:cooked_rabbit item type.
   *
   * @since 0.1
   */
  ItemType COOKED_RABBIT = item(Key.key("cooked_rabbit"));

  /**
   * The minecraft:cooked_salmon item type.
   *
   * @since 0.1
   */
  ItemType COOKED_SALMON = item(Key.key("cooked_salmon"));

  /**
   * The minecraft:cookie item type.
   *
   * @since 0.1
   */
  ItemType COOKIE = item(Key.key("cookie"));

  /**
   * The minecraft:copper_block item type.
   *
   * @since 0.1
   */
  ItemType COPPER_BLOCK = block(Key.key("copper_block"));

  /**
   * The minecraft:copper_ingot item type.
   *
   * @since 0.1
   */
  ItemType COPPER_INGOT = item(Key.key("copper_ingot"));

  /**
   * The minecraft:copper_ore item type.
   *
   * @since 0.1
   */
  ItemType COPPER_ORE = block(Key.key("copper_ore"));

  /**
   * The minecraft:cornflower item type.
   *
   * @since 0.1
   */
  ItemType CORNFLOWER = block(Key.key("cornflower"));

  /**
   * The minecraft:cow_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType COW_SPAWN_EGG = item(Key.key("cow_spawn_egg"));

  /**
   * The minecraft:cracked_deepslate_bricks item type.
   *
   * @since 0.1
   */
  ItemType CRACKED_DEEPSLATE_BRICKS = block(Key.key("cracked_deepslate_bricks"));

  /**
   * The minecraft:cracked_deepslate_tiles item type.
   *
   * @since 0.1
   */
  ItemType CRACKED_DEEPSLATE_TILES = block(Key.key("cracked_deepslate_tiles"));

  /**
   * The minecraft:cracked_nether_bricks item type.
   *
   * @since 0.1
   */
  ItemType CRACKED_NETHER_BRICKS = block(Key.key("cracked_nether_bricks"));

  /**
   * The minecraft:cracked_polished_blackstone_bricks item type.
   *
   * @since 0.1
   */
  ItemType CRACKED_POLISHED_BLACKSTONE_BRICKS =
      block(Key.key("cracked_polished_blackstone_bricks"));

  /**
   * The minecraft:cracked_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType CRACKED_STONE_BRICKS = block(Key.key("cracked_stone_bricks"));

  /**
   * The minecraft:crafting_table item type.
   *
   * @since 0.1
   */
  ItemType CRAFTING_TABLE = block(Key.key("crafting_table"));

  /**
   * The minecraft:creeper_banner_pattern item type.
   *
   * @since 0.1
   */
  ItemType CREEPER_BANNER_PATTERN = item(Key.key("creeper_banner_pattern"));

  /**
   * The minecraft:creeper_head item type.
   *
   * @since 0.1
   */
  ItemType CREEPER_HEAD = block(Key.key("creeper_head"));

  /**
   * The minecraft:creeper_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType CREEPER_SPAWN_EGG = item(Key.key("creeper_spawn_egg"));

  /**
   * The minecraft:crimson_button item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_BUTTON = block(Key.key("crimson_button"));

  /**
   * The minecraft:crimson_door item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_DOOR = block(Key.key("crimson_door"));

  /**
   * The minecraft:crimson_fence item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_FENCE = block(Key.key("crimson_fence"));

  /**
   * The minecraft:crimson_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_FENCE_GATE = block(Key.key("crimson_fence_gate"));

  /**
   * The minecraft:crimson_fungus item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_FUNGUS = block(Key.key("crimson_fungus"));

  /**
   * The minecraft:crimson_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_HANGING_SIGN = block(Key.key("crimson_hanging_sign"));

  /**
   * The minecraft:crimson_hyphae item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_HYPHAE = block(Key.key("crimson_hyphae"));

  /**
   * The minecraft:crimson_nylium item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_NYLIUM = block(Key.key("crimson_nylium"));

  /**
   * The minecraft:crimson_planks item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_PLANKS = block(Key.key("crimson_planks"));

  /**
   * The minecraft:crimson_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_PRESSURE_PLATE = block(Key.key("crimson_pressure_plate"));

  /**
   * The minecraft:crimson_roots item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_ROOTS = block(Key.key("crimson_roots"));

  /**
   * The minecraft:crimson_sign item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_SIGN = block(Key.key("crimson_sign"));

  /**
   * The minecraft:crimson_slab item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_SLAB = block(Key.key("crimson_slab"));

  /**
   * The minecraft:crimson_stairs item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_STAIRS = block(Key.key("crimson_stairs"));

  /**
   * The minecraft:crimson_stem item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_STEM = block(Key.key("crimson_stem"));

  /**
   * The minecraft:crimson_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType CRIMSON_TRAPDOOR = block(Key.key("crimson_trapdoor"));

  /**
   * The minecraft:crossbow item type.
   *
   * @since 0.1
   */
  ItemType CROSSBOW = item(Key.key("crossbow"));

  /**
   * The minecraft:crying_obsidian item type.
   *
   * @since 0.1
   */
  ItemType CRYING_OBSIDIAN = block(Key.key("crying_obsidian"));

  /**
   * The minecraft:cut_copper item type.
   *
   * @since 0.1
   */
  ItemType CUT_COPPER = block(Key.key("cut_copper"));

  /**
   * The minecraft:cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType CUT_COPPER_SLAB = block(Key.key("cut_copper_slab"));

  /**
   * The minecraft:cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType CUT_COPPER_STAIRS = block(Key.key("cut_copper_stairs"));

  /**
   * The minecraft:cut_red_sandstone item type.
   *
   * @since 0.1
   */
  ItemType CUT_RED_SANDSTONE = block(Key.key("cut_red_sandstone"));

  /**
   * The minecraft:cut_red_sandstone_slab item type.
   *
   * @since 0.1
   */
  ItemType CUT_RED_SANDSTONE_SLAB = block(Key.key("cut_red_sandstone_slab"));

  /**
   * The minecraft:cut_sandstone item type.
   *
   * @since 0.1
   */
  ItemType CUT_SANDSTONE = block(Key.key("cut_sandstone"));

  /**
   * The minecraft:cut_sandstone_slab item type.
   *
   * @since 0.1
   */
  ItemType CUT_SANDSTONE_SLAB = block(Key.key("cut_sandstone_slab"));

  /**
   * The minecraft:cyan_banner item type.
   *
   * @since 0.1
   */
  ItemType CYAN_BANNER = block(Key.key("cyan_banner"));

  /**
   * The minecraft:cyan_bed item type.
   *
   * @since 0.1
   */
  ItemType CYAN_BED = block(Key.key("cyan_bed"));

  /**
   * The minecraft:cyan_candle item type.
   *
   * @since 0.1
   */
  ItemType CYAN_CANDLE = block(Key.key("cyan_candle"));

  /**
   * The minecraft:cyan_carpet item type.
   *
   * @since 0.1
   */
  ItemType CYAN_CARPET = block(Key.key("cyan_carpet"));

  /**
   * The minecraft:cyan_concrete item type.
   *
   * @since 0.1
   */
  ItemType CYAN_CONCRETE = block(Key.key("cyan_concrete"));

  /**
   * The minecraft:cyan_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType CYAN_CONCRETE_POWDER = block(Key.key("cyan_concrete_powder"));

  /**
   * The minecraft:cyan_dye item type.
   *
   * @since 0.1
   */
  ItemType CYAN_DYE = item(Key.key("cyan_dye"));

  /**
   * The minecraft:cyan_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType CYAN_GLAZED_TERRACOTTA = block(Key.key("cyan_glazed_terracotta"));

  /**
   * The minecraft:cyan_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType CYAN_SHULKER_BOX = block(Key.key("cyan_shulker_box"));

  /**
   * The minecraft:cyan_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType CYAN_STAINED_GLASS = block(Key.key("cyan_stained_glass"));

  /**
   * The minecraft:cyan_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType CYAN_STAINED_GLASS_PANE = block(Key.key("cyan_stained_glass_pane"));

  /**
   * The minecraft:cyan_terracotta item type.
   *
   * @since 0.1
   */
  ItemType CYAN_TERRACOTTA = block(Key.key("cyan_terracotta"));

  /**
   * The minecraft:cyan_wool item type.
   *
   * @since 0.1
   */
  ItemType CYAN_WOOL = block(Key.key("cyan_wool"));

  /**
   * The minecraft:damaged_anvil item type.
   *
   * @since 0.1
   */
  ItemType DAMAGED_ANVIL = block(Key.key("damaged_anvil"));

  /**
   * The minecraft:dandelion item type.
   *
   * @since 0.1
   */
  ItemType DANDELION = block(Key.key("dandelion"));

  /**
   * The minecraft:danger_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType DANGER_POTTERY_SHERD = item(Key.key("danger_pottery_sherd"));

  /**
   * The minecraft:dark_oak_boat item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_BOAT = item(Key.key("dark_oak_boat"));

  /**
   * The minecraft:dark_oak_button item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_BUTTON = block(Key.key("dark_oak_button"));

  /**
   * The minecraft:dark_oak_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_CHEST_BOAT = item(Key.key("dark_oak_chest_boat"));

  /**
   * The minecraft:dark_oak_door item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_DOOR = block(Key.key("dark_oak_door"));

  /**
   * The minecraft:dark_oak_fence item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_FENCE = block(Key.key("dark_oak_fence"));

  /**
   * The minecraft:dark_oak_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_FENCE_GATE = block(Key.key("dark_oak_fence_gate"));

  /**
   * The minecraft:dark_oak_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_HANGING_SIGN = block(Key.key("dark_oak_hanging_sign"));

  /**
   * The minecraft:dark_oak_leaves item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_LEAVES = block(Key.key("dark_oak_leaves"));

  /**
   * The minecraft:dark_oak_log item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_LOG = block(Key.key("dark_oak_log"));

  /**
   * The minecraft:dark_oak_planks item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_PLANKS = block(Key.key("dark_oak_planks"));

  /**
   * The minecraft:dark_oak_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_PRESSURE_PLATE = block(Key.key("dark_oak_pressure_plate"));

  /**
   * The minecraft:dark_oak_sapling item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_SAPLING = block(Key.key("dark_oak_sapling"));

  /**
   * The minecraft:dark_oak_sign item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_SIGN = block(Key.key("dark_oak_sign"));

  /**
   * The minecraft:dark_oak_slab item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_SLAB = block(Key.key("dark_oak_slab"));

  /**
   * The minecraft:dark_oak_stairs item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_STAIRS = block(Key.key("dark_oak_stairs"));

  /**
   * The minecraft:dark_oak_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_TRAPDOOR = block(Key.key("dark_oak_trapdoor"));

  /**
   * The minecraft:dark_oak_wood item type.
   *
   * @since 0.1
   */
  ItemType DARK_OAK_WOOD = block(Key.key("dark_oak_wood"));

  /**
   * The minecraft:dark_prismarine item type.
   *
   * @since 0.1
   */
  ItemType DARK_PRISMARINE = block(Key.key("dark_prismarine"));

  /**
   * The minecraft:dark_prismarine_slab item type.
   *
   * @since 0.1
   */
  ItemType DARK_PRISMARINE_SLAB = block(Key.key("dark_prismarine_slab"));

  /**
   * The minecraft:dark_prismarine_stairs item type.
   *
   * @since 0.1
   */
  ItemType DARK_PRISMARINE_STAIRS = block(Key.key("dark_prismarine_stairs"));

  /**
   * The minecraft:daylight_detector item type.
   *
   * @since 0.1
   */
  ItemType DAYLIGHT_DETECTOR = block(Key.key("daylight_detector"));

  /**
   * The minecraft:dead_brain_coral item type.
   *
   * @since 0.1
   */
  ItemType DEAD_BRAIN_CORAL = block(Key.key("dead_brain_coral"));

  /**
   * The minecraft:dead_brain_coral_block item type.
   *
   * @since 0.1
   */
  ItemType DEAD_BRAIN_CORAL_BLOCK = block(Key.key("dead_brain_coral_block"));

  /**
   * The minecraft:dead_brain_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType DEAD_BRAIN_CORAL_FAN = block(Key.key("dead_brain_coral_fan"));

  /**
   * The minecraft:dead_bubble_coral item type.
   *
   * @since 0.1
   */
  ItemType DEAD_BUBBLE_CORAL = block(Key.key("dead_bubble_coral"));

  /**
   * The minecraft:dead_bubble_coral_block item type.
   *
   * @since 0.1
   */
  ItemType DEAD_BUBBLE_CORAL_BLOCK = block(Key.key("dead_bubble_coral_block"));

  /**
   * The minecraft:dead_bubble_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType DEAD_BUBBLE_CORAL_FAN = block(Key.key("dead_bubble_coral_fan"));

  /**
   * The minecraft:dead_bush item type.
   *
   * @since 0.1
   */
  ItemType DEAD_BUSH = block(Key.key("dead_bush"));

  /**
   * The minecraft:dead_fire_coral item type.
   *
   * @since 0.1
   */
  ItemType DEAD_FIRE_CORAL = block(Key.key("dead_fire_coral"));

  /**
   * The minecraft:dead_fire_coral_block item type.
   *
   * @since 0.1
   */
  ItemType DEAD_FIRE_CORAL_BLOCK = block(Key.key("dead_fire_coral_block"));

  /**
   * The minecraft:dead_fire_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType DEAD_FIRE_CORAL_FAN = block(Key.key("dead_fire_coral_fan"));

  /**
   * The minecraft:dead_horn_coral item type.
   *
   * @since 0.1
   */
  ItemType DEAD_HORN_CORAL = block(Key.key("dead_horn_coral"));

  /**
   * The minecraft:dead_horn_coral_block item type.
   *
   * @since 0.1
   */
  ItemType DEAD_HORN_CORAL_BLOCK = block(Key.key("dead_horn_coral_block"));

  /**
   * The minecraft:dead_horn_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType DEAD_HORN_CORAL_FAN = block(Key.key("dead_horn_coral_fan"));

  /**
   * The minecraft:dead_tube_coral item type.
   *
   * @since 0.1
   */
  ItemType DEAD_TUBE_CORAL = block(Key.key("dead_tube_coral"));

  /**
   * The minecraft:dead_tube_coral_block item type.
   *
   * @since 0.1
   */
  ItemType DEAD_TUBE_CORAL_BLOCK = block(Key.key("dead_tube_coral_block"));

  /**
   * The minecraft:dead_tube_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType DEAD_TUBE_CORAL_FAN = block(Key.key("dead_tube_coral_fan"));

  /**
   * The minecraft:debug_stick item type.
   *
   * @since 0.1
   */
  ItemType DEBUG_STICK = item(Key.key("debug_stick"));

  /**
   * The minecraft:decorated_pot item type.
   *
   * @since 0.1
   */
  ItemType DECORATED_POT = block(Key.key("decorated_pot"));

  /**
   * The minecraft:deepslate item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE = block(Key.key("deepslate"));

  /**
   * The minecraft:deepslate_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_BRICK_SLAB = block(Key.key("deepslate_brick_slab"));

  /**
   * The minecraft:deepslate_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_BRICK_STAIRS = block(Key.key("deepslate_brick_stairs"));

  /**
   * The minecraft:deepslate_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_BRICK_WALL = block(Key.key("deepslate_brick_wall"));

  /**
   * The minecraft:deepslate_bricks item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_BRICKS = block(Key.key("deepslate_bricks"));

  /**
   * The minecraft:deepslate_coal_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_COAL_ORE = block(Key.key("deepslate_coal_ore"));

  /**
   * The minecraft:deepslate_copper_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_COPPER_ORE = block(Key.key("deepslate_copper_ore"));

  /**
   * The minecraft:deepslate_diamond_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_DIAMOND_ORE = block(Key.key("deepslate_diamond_ore"));

  /**
   * The minecraft:deepslate_emerald_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_EMERALD_ORE = block(Key.key("deepslate_emerald_ore"));

  /**
   * The minecraft:deepslate_gold_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_GOLD_ORE = block(Key.key("deepslate_gold_ore"));

  /**
   * The minecraft:deepslate_iron_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_IRON_ORE = block(Key.key("deepslate_iron_ore"));

  /**
   * The minecraft:deepslate_lapis_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_LAPIS_ORE = block(Key.key("deepslate_lapis_ore"));

  /**
   * The minecraft:deepslate_redstone_ore item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_REDSTONE_ORE = block(Key.key("deepslate_redstone_ore"));

  /**
   * The minecraft:deepslate_tile_slab item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_TILE_SLAB = block(Key.key("deepslate_tile_slab"));

  /**
   * The minecraft:deepslate_tile_stairs item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_TILE_STAIRS = block(Key.key("deepslate_tile_stairs"));

  /**
   * The minecraft:deepslate_tile_wall item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_TILE_WALL = block(Key.key("deepslate_tile_wall"));

  /**
   * The minecraft:deepslate_tiles item type.
   *
   * @since 0.1
   */
  ItemType DEEPSLATE_TILES = block(Key.key("deepslate_tiles"));

  /**
   * The minecraft:detector_rail item type.
   *
   * @since 0.1
   */
  ItemType DETECTOR_RAIL = block(Key.key("detector_rail"));

  /**
   * The minecraft:diamond item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND = item(Key.key("diamond"));

  /**
   * The minecraft:diamond_axe item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_AXE = item(Key.key("diamond_axe"));

  /**
   * The minecraft:diamond_block item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_BLOCK = block(Key.key("diamond_block"));

  /**
   * The minecraft:diamond_boots item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_BOOTS = item(Key.key("diamond_boots"));

  /**
   * The minecraft:diamond_chestplate item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_CHESTPLATE = item(Key.key("diamond_chestplate"));

  /**
   * The minecraft:diamond_helmet item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_HELMET = item(Key.key("diamond_helmet"));

  /**
   * The minecraft:diamond_hoe item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_HOE = item(Key.key("diamond_hoe"));

  /**
   * The minecraft:diamond_horse_armor item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_HORSE_ARMOR = item(Key.key("diamond_horse_armor"));

  /**
   * The minecraft:diamond_leggings item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_LEGGINGS = item(Key.key("diamond_leggings"));

  /**
   * The minecraft:diamond_ore item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_ORE = block(Key.key("diamond_ore"));

  /**
   * The minecraft:diamond_pickaxe item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_PICKAXE = item(Key.key("diamond_pickaxe"));

  /**
   * The minecraft:diamond_shovel item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_SHOVEL = item(Key.key("diamond_shovel"));

  /**
   * The minecraft:diamond_sword item type.
   *
   * @since 0.1
   */
  ItemType DIAMOND_SWORD = item(Key.key("diamond_sword"));

  /**
   * The minecraft:diorite item type.
   *
   * @since 0.1
   */
  ItemType DIORITE = block(Key.key("diorite"));

  /**
   * The minecraft:diorite_slab item type.
   *
   * @since 0.1
   */
  ItemType DIORITE_SLAB = block(Key.key("diorite_slab"));

  /**
   * The minecraft:diorite_stairs item type.
   *
   * @since 0.1
   */
  ItemType DIORITE_STAIRS = block(Key.key("diorite_stairs"));

  /**
   * The minecraft:diorite_wall item type.
   *
   * @since 0.1
   */
  ItemType DIORITE_WALL = block(Key.key("diorite_wall"));

  /**
   * The minecraft:dirt item type.
   *
   * @since 0.1
   */
  ItemType DIRT = block(Key.key("dirt"));

  /**
   * The minecraft:dirt_path item type.
   *
   * @since 0.1
   */
  ItemType DIRT_PATH = block(Key.key("dirt_path"));

  /**
   * The minecraft:disc_fragment_5 item type.
   *
   * @since 0.1
   */
  ItemType DISC_FRAGMENT_5 = item(Key.key("disc_fragment_5"));

  /**
   * The minecraft:dispenser item type.
   *
   * @since 0.1
   */
  ItemType DISPENSER = block(Key.key("dispenser"));

  /**
   * The minecraft:dolphin_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType DOLPHIN_SPAWN_EGG = item(Key.key("dolphin_spawn_egg"));

  /**
   * The minecraft:donkey_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType DONKEY_SPAWN_EGG = item(Key.key("donkey_spawn_egg"));

  /**
   * The minecraft:dragon_breath item type.
   *
   * @since 0.1
   */
  ItemType DRAGON_BREATH = item(Key.key("dragon_breath"));

  /**
   * The minecraft:dragon_egg item type.
   *
   * @since 0.1
   */
  ItemType DRAGON_EGG = block(Key.key("dragon_egg"));

  /**
   * The minecraft:dragon_head item type.
   *
   * @since 0.1
   */
  ItemType DRAGON_HEAD = block(Key.key("dragon_head"));

  /**
   * The minecraft:dried_kelp item type.
   *
   * @since 0.1
   */
  ItemType DRIED_KELP = item(Key.key("dried_kelp"));

  /**
   * The minecraft:dried_kelp_block item type.
   *
   * @since 0.1
   */
  ItemType DRIED_KELP_BLOCK = block(Key.key("dried_kelp_block"));

  /**
   * The minecraft:dripstone_block item type.
   *
   * @since 0.1
   */
  ItemType DRIPSTONE_BLOCK = block(Key.key("dripstone_block"));

  /**
   * The minecraft:dropper item type.
   *
   * @since 0.1
   */
  ItemType DROPPER = block(Key.key("dropper"));

  /**
   * The minecraft:drowned_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType DROWNED_SPAWN_EGG = item(Key.key("drowned_spawn_egg"));

  /**
   * The minecraft:dune_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType DUNE_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("dune_armor_trim_smithing_template"));

  /**
   * The minecraft:echo_shard item type.
   *
   * @since 0.1
   */
  ItemType ECHO_SHARD = item(Key.key("echo_shard"));

  /**
   * The minecraft:egg item type.
   *
   * @since 0.1
   */
  ItemType EGG = item(Key.key("egg"));

  /**
   * The minecraft:elder_guardian_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ELDER_GUARDIAN_SPAWN_EGG = item(Key.key("elder_guardian_spawn_egg"));

  /**
   * The minecraft:elytra item type.
   *
   * @since 0.1
   */
  ItemType ELYTRA = item(Key.key("elytra"));

  /**
   * The minecraft:emerald item type.
   *
   * @since 0.1
   */
  ItemType EMERALD = item(Key.key("emerald"));

  /**
   * The minecraft:emerald_block item type.
   *
   * @since 0.1
   */
  ItemType EMERALD_BLOCK = block(Key.key("emerald_block"));

  /**
   * The minecraft:emerald_ore item type.
   *
   * @since 0.1
   */
  ItemType EMERALD_ORE = block(Key.key("emerald_ore"));

  /**
   * The minecraft:enchanted_book item type.
   *
   * @since 0.1
   */
  ItemType ENCHANTED_BOOK = item(Key.key("enchanted_book"));

  /**
   * The minecraft:enchanted_golden_apple item type.
   *
   * @since 0.1
   */
  ItemType ENCHANTED_GOLDEN_APPLE = item(Key.key("enchanted_golden_apple"));

  /**
   * The minecraft:enchanting_table item type.
   *
   * @since 0.1
   */
  ItemType ENCHANTING_TABLE = block(Key.key("enchanting_table"));

  /**
   * The minecraft:end_crystal item type.
   *
   * @since 0.1
   */
  ItemType END_CRYSTAL = item(Key.key("end_crystal"));

  /**
   * The minecraft:end_portal_frame item type.
   *
   * @since 0.1
   */
  ItemType END_PORTAL_FRAME = block(Key.key("end_portal_frame"));

  /**
   * The minecraft:end_rod item type.
   *
   * @since 0.1
   */
  ItemType END_ROD = block(Key.key("end_rod"));

  /**
   * The minecraft:end_stone item type.
   *
   * @since 0.1
   */
  ItemType END_STONE = block(Key.key("end_stone"));

  /**
   * The minecraft:end_stone_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType END_STONE_BRICK_SLAB = block(Key.key("end_stone_brick_slab"));

  /**
   * The minecraft:end_stone_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType END_STONE_BRICK_STAIRS = block(Key.key("end_stone_brick_stairs"));

  /**
   * The minecraft:end_stone_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType END_STONE_BRICK_WALL = block(Key.key("end_stone_brick_wall"));

  /**
   * The minecraft:end_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType END_STONE_BRICKS = block(Key.key("end_stone_bricks"));

  /**
   * The minecraft:ender_chest item type.
   *
   * @since 0.1
   */
  ItemType ENDER_CHEST = block(Key.key("ender_chest"));

  /**
   * The minecraft:ender_dragon_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ENDER_DRAGON_SPAWN_EGG = item(Key.key("ender_dragon_spawn_egg"));

  /**
   * The minecraft:ender_eye item type.
   *
   * @since 0.1
   */
  ItemType ENDER_EYE = item(Key.key("ender_eye"));

  /**
   * The minecraft:ender_pearl item type.
   *
   * @since 0.1
   */
  ItemType ENDER_PEARL = item(Key.key("ender_pearl"));

  /**
   * The minecraft:enderman_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ENDERMAN_SPAWN_EGG = item(Key.key("enderman_spawn_egg"));

  /**
   * The minecraft:endermite_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ENDERMITE_SPAWN_EGG = item(Key.key("endermite_spawn_egg"));

  /**
   * The minecraft:evoker_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType EVOKER_SPAWN_EGG = item(Key.key("evoker_spawn_egg"));

  /**
   * The minecraft:experience_bottle item type.
   *
   * @since 0.1
   */
  ItemType EXPERIENCE_BOTTLE = item(Key.key("experience_bottle"));

  /**
   * The minecraft:explorer_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType EXPLORER_POTTERY_SHERD = item(Key.key("explorer_pottery_sherd"));

  /**
   * The minecraft:exposed_copper item type.
   *
   * @since 0.1
   */
  ItemType EXPOSED_COPPER = block(Key.key("exposed_copper"));

  /**
   * The minecraft:exposed_cut_copper item type.
   *
   * @since 0.1
   */
  ItemType EXPOSED_CUT_COPPER = block(Key.key("exposed_cut_copper"));

  /**
   * The minecraft:exposed_cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType EXPOSED_CUT_COPPER_SLAB = block(Key.key("exposed_cut_copper_slab"));

  /**
   * The minecraft:exposed_cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType EXPOSED_CUT_COPPER_STAIRS = block(Key.key("exposed_cut_copper_stairs"));

  /**
   * The minecraft:eye_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType EYE_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("eye_armor_trim_smithing_template"));

  /**
   * The minecraft:farmland item type.
   *
   * @since 0.1
   */
  ItemType FARMLAND = block(Key.key("farmland"));

  /**
   * The minecraft:feather item type.
   *
   * @since 0.1
   */
  ItemType FEATHER = item(Key.key("feather"));

  /**
   * The minecraft:fermented_spider_eye item type.
   *
   * @since 0.1
   */
  ItemType FERMENTED_SPIDER_EYE = item(Key.key("fermented_spider_eye"));

  /**
   * The minecraft:fern item type.
   *
   * @since 0.1
   */
  ItemType FERN = block(Key.key("fern"));

  /**
   * The minecraft:filled_map item type.
   *
   * @since 0.1
   */
  ItemType FILLED_MAP = item(Key.key("filled_map"));

  /**
   * The minecraft:fire_charge item type.
   *
   * @since 0.1
   */
  ItemType FIRE_CHARGE = item(Key.key("fire_charge"));

  /**
   * The minecraft:fire_coral item type.
   *
   * @since 0.1
   */
  ItemType FIRE_CORAL = block(Key.key("fire_coral"));

  /**
   * The minecraft:fire_coral_block item type.
   *
   * @since 0.1
   */
  ItemType FIRE_CORAL_BLOCK = block(Key.key("fire_coral_block"));

  /**
   * The minecraft:fire_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType FIRE_CORAL_FAN = block(Key.key("fire_coral_fan"));

  /**
   * The minecraft:firework_rocket item type.
   *
   * @since 0.1
   */
  ItemType FIREWORK_ROCKET = item(Key.key("firework_rocket"));

  /**
   * The minecraft:firework_star item type.
   *
   * @since 0.1
   */
  ItemType FIREWORK_STAR = item(Key.key("firework_star"));

  /**
   * The minecraft:fishing_rod item type.
   *
   * @since 0.1
   */
  ItemType FISHING_ROD = item(Key.key("fishing_rod"));

  /**
   * The minecraft:fletching_table item type.
   *
   * @since 0.1
   */
  ItemType FLETCHING_TABLE = block(Key.key("fletching_table"));

  /**
   * The minecraft:flint item type.
   *
   * @since 0.1
   */
  ItemType FLINT = item(Key.key("flint"));

  /**
   * The minecraft:flint_and_steel item type.
   *
   * @since 0.1
   */
  ItemType FLINT_AND_STEEL = item(Key.key("flint_and_steel"));

  /**
   * The minecraft:flower_banner_pattern item type.
   *
   * @since 0.1
   */
  ItemType FLOWER_BANNER_PATTERN = item(Key.key("flower_banner_pattern"));

  /**
   * The minecraft:flower_pot item type.
   *
   * @since 0.1
   */
  ItemType FLOWER_POT = block(Key.key("flower_pot"));

  /**
   * The minecraft:flowering_azalea item type.
   *
   * @since 0.1
   */
  ItemType FLOWERING_AZALEA = block(Key.key("flowering_azalea"));

  /**
   * The minecraft:flowering_azalea_leaves item type.
   *
   * @since 0.1
   */
  ItemType FLOWERING_AZALEA_LEAVES = block(Key.key("flowering_azalea_leaves"));

  /**
   * The minecraft:fox_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType FOX_SPAWN_EGG = item(Key.key("fox_spawn_egg"));

  /**
   * The minecraft:friend_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType FRIEND_POTTERY_SHERD = item(Key.key("friend_pottery_sherd"));

  /**
   * The minecraft:frog_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType FROG_SPAWN_EGG = item(Key.key("frog_spawn_egg"));

  /**
   * The minecraft:frogspawn item type.
   *
   * @since 0.1
   */
  ItemType FROGSPAWN = block(Key.key("frogspawn"));

  /**
   * The minecraft:furnace item type.
   *
   * @since 0.1
   */
  ItemType FURNACE = block(Key.key("furnace"));

  /**
   * The minecraft:furnace_minecart item type.
   *
   * @since 0.1
   */
  ItemType FURNACE_MINECART = item(Key.key("furnace_minecart"));

  /**
   * The minecraft:ghast_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType GHAST_SPAWN_EGG = item(Key.key("ghast_spawn_egg"));

  /**
   * The minecraft:ghast_tear item type.
   *
   * @since 0.1
   */
  ItemType GHAST_TEAR = item(Key.key("ghast_tear"));

  /**
   * The minecraft:gilded_blackstone item type.
   *
   * @since 0.1
   */
  ItemType GILDED_BLACKSTONE = block(Key.key("gilded_blackstone"));

  /**
   * The minecraft:glass item type.
   *
   * @since 0.1
   */
  ItemType GLASS = block(Key.key("glass"));

  /**
   * The minecraft:glass_bottle item type.
   *
   * @since 0.1
   */
  ItemType GLASS_BOTTLE = item(Key.key("glass_bottle"));

  /**
   * The minecraft:glass_pane item type.
   *
   * @since 0.1
   */
  ItemType GLASS_PANE = block(Key.key("glass_pane"));

  /**
   * The minecraft:glistering_melon_slice item type.
   *
   * @since 0.1
   */
  ItemType GLISTERING_MELON_SLICE = item(Key.key("glistering_melon_slice"));

  /**
   * The minecraft:globe_banner_pattern item type.
   *
   * @since 0.1
   */
  ItemType GLOBE_BANNER_PATTERN = item(Key.key("globe_banner_pattern"));

  /**
   * The minecraft:glow_berries item type.
   *
   * @since 0.1
   */
  ItemType GLOW_BERRIES = item(Key.key("glow_berries"));

  /**
   * The minecraft:glow_ink_sac item type.
   *
   * @since 0.1
   */
  ItemType GLOW_INK_SAC = item(Key.key("glow_ink_sac"));

  /**
   * The minecraft:glow_item_frame item type.
   *
   * @since 0.1
   */
  ItemType GLOW_ITEM_FRAME = item(Key.key("glow_item_frame"));

  /**
   * The minecraft:glow_lichen item type.
   *
   * @since 0.1
   */
  ItemType GLOW_LICHEN = block(Key.key("glow_lichen"));

  /**
   * The minecraft:glow_squid_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType GLOW_SQUID_SPAWN_EGG = item(Key.key("glow_squid_spawn_egg"));

  /**
   * The minecraft:glowstone item type.
   *
   * @since 0.1
   */
  ItemType GLOWSTONE = block(Key.key("glowstone"));

  /**
   * The minecraft:glowstone_dust item type.
   *
   * @since 0.1
   */
  ItemType GLOWSTONE_DUST = item(Key.key("glowstone_dust"));

  /**
   * The minecraft:goat_horn item type.
   *
   * @since 0.1
   */
  ItemType GOAT_HORN = item(Key.key("goat_horn"));

  /**
   * The minecraft:goat_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType GOAT_SPAWN_EGG = item(Key.key("goat_spawn_egg"));

  /**
   * The minecraft:gold_block item type.
   *
   * @since 0.1
   */
  ItemType GOLD_BLOCK = block(Key.key("gold_block"));

  /**
   * The minecraft:gold_ingot item type.
   *
   * @since 0.1
   */
  ItemType GOLD_INGOT = item(Key.key("gold_ingot"));

  /**
   * The minecraft:gold_nugget item type.
   *
   * @since 0.1
   */
  ItemType GOLD_NUGGET = item(Key.key("gold_nugget"));

  /**
   * The minecraft:gold_ore item type.
   *
   * @since 0.1
   */
  ItemType GOLD_ORE = block(Key.key("gold_ore"));

  /**
   * The minecraft:golden_apple item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_APPLE = item(Key.key("golden_apple"));

  /**
   * The minecraft:golden_axe item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_AXE = item(Key.key("golden_axe"));

  /**
   * The minecraft:golden_boots item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_BOOTS = item(Key.key("golden_boots"));

  /**
   * The minecraft:golden_carrot item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_CARROT = item(Key.key("golden_carrot"));

  /**
   * The minecraft:golden_chestplate item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_CHESTPLATE = item(Key.key("golden_chestplate"));

  /**
   * The minecraft:golden_helmet item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_HELMET = item(Key.key("golden_helmet"));

  /**
   * The minecraft:golden_hoe item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_HOE = item(Key.key("golden_hoe"));

  /**
   * The minecraft:golden_horse_armor item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_HORSE_ARMOR = item(Key.key("golden_horse_armor"));

  /**
   * The minecraft:golden_leggings item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_LEGGINGS = item(Key.key("golden_leggings"));

  /**
   * The minecraft:golden_pickaxe item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_PICKAXE = item(Key.key("golden_pickaxe"));

  /**
   * The minecraft:golden_shovel item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_SHOVEL = item(Key.key("golden_shovel"));

  /**
   * The minecraft:golden_sword item type.
   *
   * @since 0.1
   */
  ItemType GOLDEN_SWORD = item(Key.key("golden_sword"));

  /**
   * The minecraft:granite item type.
   *
   * @since 0.1
   */
  ItemType GRANITE = block(Key.key("granite"));

  /**
   * The minecraft:granite_slab item type.
   *
   * @since 0.1
   */
  ItemType GRANITE_SLAB = block(Key.key("granite_slab"));

  /**
   * The minecraft:granite_stairs item type.
   *
   * @since 0.1
   */
  ItemType GRANITE_STAIRS = block(Key.key("granite_stairs"));

  /**
   * The minecraft:granite_wall item type.
   *
   * @since 0.1
   */
  ItemType GRANITE_WALL = block(Key.key("granite_wall"));

  /**
   * The minecraft:grass item type.
   *
   * @since 0.1
   */
  ItemType GRASS = block(Key.key("grass"));

  /**
   * The minecraft:grass_block item type.
   *
   * @since 0.1
   */
  ItemType GRASS_BLOCK = block(Key.key("grass_block"));

  /**
   * The minecraft:gravel item type.
   *
   * @since 0.1
   */
  ItemType GRAVEL = block(Key.key("gravel"));

  /**
   * The minecraft:gray_banner item type.
   *
   * @since 0.1
   */
  ItemType GRAY_BANNER = block(Key.key("gray_banner"));

  /**
   * The minecraft:gray_bed item type.
   *
   * @since 0.1
   */
  ItemType GRAY_BED = block(Key.key("gray_bed"));

  /**
   * The minecraft:gray_candle item type.
   *
   * @since 0.1
   */
  ItemType GRAY_CANDLE = block(Key.key("gray_candle"));

  /**
   * The minecraft:gray_carpet item type.
   *
   * @since 0.1
   */
  ItemType GRAY_CARPET = block(Key.key("gray_carpet"));

  /**
   * The minecraft:gray_concrete item type.
   *
   * @since 0.1
   */
  ItemType GRAY_CONCRETE = block(Key.key("gray_concrete"));

  /**
   * The minecraft:gray_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType GRAY_CONCRETE_POWDER = block(Key.key("gray_concrete_powder"));

  /**
   * The minecraft:gray_dye item type.
   *
   * @since 0.1
   */
  ItemType GRAY_DYE = item(Key.key("gray_dye"));

  /**
   * The minecraft:gray_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType GRAY_GLAZED_TERRACOTTA = block(Key.key("gray_glazed_terracotta"));

  /**
   * The minecraft:gray_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType GRAY_SHULKER_BOX = block(Key.key("gray_shulker_box"));

  /**
   * The minecraft:gray_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType GRAY_STAINED_GLASS = block(Key.key("gray_stained_glass"));

  /**
   * The minecraft:gray_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType GRAY_STAINED_GLASS_PANE = block(Key.key("gray_stained_glass_pane"));

  /**
   * The minecraft:gray_terracotta item type.
   *
   * @since 0.1
   */
  ItemType GRAY_TERRACOTTA = block(Key.key("gray_terracotta"));

  /**
   * The minecraft:gray_wool item type.
   *
   * @since 0.1
   */
  ItemType GRAY_WOOL = block(Key.key("gray_wool"));

  /**
   * The minecraft:green_banner item type.
   *
   * @since 0.1
   */
  ItemType GREEN_BANNER = block(Key.key("green_banner"));

  /**
   * The minecraft:green_bed item type.
   *
   * @since 0.1
   */
  ItemType GREEN_BED = block(Key.key("green_bed"));

  /**
   * The minecraft:green_candle item type.
   *
   * @since 0.1
   */
  ItemType GREEN_CANDLE = block(Key.key("green_candle"));

  /**
   * The minecraft:green_carpet item type.
   *
   * @since 0.1
   */
  ItemType GREEN_CARPET = block(Key.key("green_carpet"));

  /**
   * The minecraft:green_concrete item type.
   *
   * @since 0.1
   */
  ItemType GREEN_CONCRETE = block(Key.key("green_concrete"));

  /**
   * The minecraft:green_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType GREEN_CONCRETE_POWDER = block(Key.key("green_concrete_powder"));

  /**
   * The minecraft:green_dye item type.
   *
   * @since 0.1
   */
  ItemType GREEN_DYE = item(Key.key("green_dye"));

  /**
   * The minecraft:green_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType GREEN_GLAZED_TERRACOTTA = block(Key.key("green_glazed_terracotta"));

  /**
   * The minecraft:green_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType GREEN_SHULKER_BOX = block(Key.key("green_shulker_box"));

  /**
   * The minecraft:green_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType GREEN_STAINED_GLASS = block(Key.key("green_stained_glass"));

  /**
   * The minecraft:green_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType GREEN_STAINED_GLASS_PANE = block(Key.key("green_stained_glass_pane"));

  /**
   * The minecraft:green_terracotta item type.
   *
   * @since 0.1
   */
  ItemType GREEN_TERRACOTTA = block(Key.key("green_terracotta"));

  /**
   * The minecraft:green_wool item type.
   *
   * @since 0.1
   */
  ItemType GREEN_WOOL = block(Key.key("green_wool"));

  /**
   * The minecraft:grindstone item type.
   *
   * @since 0.1
   */
  ItemType GRINDSTONE = block(Key.key("grindstone"));

  /**
   * The minecraft:guardian_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType GUARDIAN_SPAWN_EGG = item(Key.key("guardian_spawn_egg"));

  /**
   * The minecraft:gunpowder item type.
   *
   * @since 0.1
   */
  ItemType GUNPOWDER = item(Key.key("gunpowder"));

  /**
   * The minecraft:hanging_roots item type.
   *
   * @since 0.1
   */
  ItemType HANGING_ROOTS = block(Key.key("hanging_roots"));

  /**
   * The minecraft:hay_block item type.
   *
   * @since 0.1
   */
  ItemType HAY_BLOCK = block(Key.key("hay_block"));

  /**
   * The minecraft:heart_of_the_sea item type.
   *
   * @since 0.1
   */
  ItemType HEART_OF_THE_SEA = item(Key.key("heart_of_the_sea"));

  /**
   * The minecraft:heart_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType HEART_POTTERY_SHERD = item(Key.key("heart_pottery_sherd"));

  /**
   * The minecraft:heartbreak_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType HEARTBREAK_POTTERY_SHERD = item(Key.key("heartbreak_pottery_sherd"));

  /**
   * The minecraft:heavy_weighted_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType HEAVY_WEIGHTED_PRESSURE_PLATE = block(Key.key("heavy_weighted_pressure_plate"));

  /**
   * The minecraft:hoglin_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType HOGLIN_SPAWN_EGG = item(Key.key("hoglin_spawn_egg"));

  /**
   * The minecraft:honey_block item type.
   *
   * @since 0.1
   */
  ItemType HONEY_BLOCK = block(Key.key("honey_block"));

  /**
   * The minecraft:honey_bottle item type.
   *
   * @since 0.1
   */
  ItemType HONEY_BOTTLE = item(Key.key("honey_bottle"));

  /**
   * The minecraft:honeycomb item type.
   *
   * @since 0.1
   */
  ItemType HONEYCOMB = item(Key.key("honeycomb"));

  /**
   * The minecraft:honeycomb_block item type.
   *
   * @since 0.1
   */
  ItemType HONEYCOMB_BLOCK = block(Key.key("honeycomb_block"));

  /**
   * The minecraft:hopper item type.
   *
   * @since 0.1
   */
  ItemType HOPPER = block(Key.key("hopper"));

  /**
   * The minecraft:hopper_minecart item type.
   *
   * @since 0.1
   */
  ItemType HOPPER_MINECART = item(Key.key("hopper_minecart"));

  /**
   * The minecraft:horn_coral item type.
   *
   * @since 0.1
   */
  ItemType HORN_CORAL = block(Key.key("horn_coral"));

  /**
   * The minecraft:horn_coral_block item type.
   *
   * @since 0.1
   */
  ItemType HORN_CORAL_BLOCK = block(Key.key("horn_coral_block"));

  /**
   * The minecraft:horn_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType HORN_CORAL_FAN = block(Key.key("horn_coral_fan"));

  /**
   * The minecraft:horse_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType HORSE_SPAWN_EGG = item(Key.key("horse_spawn_egg"));

  /**
   * The minecraft:host_armor_trim_smithing_template item type.
   *
   * @since 0.2
   */
  ItemType HOST_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("host_armor_trim_smithing_template"));

  /**
   * The minecraft:howl_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType HOWL_POTTERY_SHERD = item(Key.key("howl_pottery_sherd"));

  /**
   * The minecraft:husk_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType HUSK_SPAWN_EGG = item(Key.key("husk_spawn_egg"));

  /**
   * The minecraft:ice item type.
   *
   * @since 0.1
   */
  ItemType ICE = block(Key.key("ice"));

  /**
   * The minecraft:infested_chiseled_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType INFESTED_CHISELED_STONE_BRICKS = block(Key.key("infested_chiseled_stone_bricks"));

  /**
   * The minecraft:infested_cobblestone item type.
   *
   * @since 0.1
   */
  ItemType INFESTED_COBBLESTONE = block(Key.key("infested_cobblestone"));

  /**
   * The minecraft:infested_cracked_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType INFESTED_CRACKED_STONE_BRICKS = block(Key.key("infested_cracked_stone_bricks"));

  /**
   * The minecraft:infested_deepslate item type.
   *
   * @since 0.1
   */
  ItemType INFESTED_DEEPSLATE = block(Key.key("infested_deepslate"));

  /**
   * The minecraft:infested_mossy_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType INFESTED_MOSSY_STONE_BRICKS = block(Key.key("infested_mossy_stone_bricks"));

  /**
   * The minecraft:infested_stone item type.
   *
   * @since 0.1
   */
  ItemType INFESTED_STONE = block(Key.key("infested_stone"));

  /**
   * The minecraft:infested_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType INFESTED_STONE_BRICKS = block(Key.key("infested_stone_bricks"));

  /**
   * The minecraft:ink_sac item type.
   *
   * @since 0.1
   */
  ItemType INK_SAC = item(Key.key("ink_sac"));

  /**
   * The minecraft:iron_axe item type.
   *
   * @since 0.1
   */
  ItemType IRON_AXE = item(Key.key("iron_axe"));

  /**
   * The minecraft:iron_bars item type.
   *
   * @since 0.1
   */
  ItemType IRON_BARS = block(Key.key("iron_bars"));

  /**
   * The minecraft:iron_block item type.
   *
   * @since 0.1
   */
  ItemType IRON_BLOCK = block(Key.key("iron_block"));

  /**
   * The minecraft:iron_boots item type.
   *
   * @since 0.1
   */
  ItemType IRON_BOOTS = item(Key.key("iron_boots"));

  /**
   * The minecraft:iron_chestplate item type.
   *
   * @since 0.1
   */
  ItemType IRON_CHESTPLATE = item(Key.key("iron_chestplate"));

  /**
   * The minecraft:iron_door item type.
   *
   * @since 0.1
   */
  ItemType IRON_DOOR = block(Key.key("iron_door"));

  /**
   * The minecraft:iron_golem_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType IRON_GOLEM_SPAWN_EGG = item(Key.key("iron_golem_spawn_egg"));

  /**
   * The minecraft:iron_helmet item type.
   *
   * @since 0.1
   */
  ItemType IRON_HELMET = item(Key.key("iron_helmet"));

  /**
   * The minecraft:iron_hoe item type.
   *
   * @since 0.1
   */
  ItemType IRON_HOE = item(Key.key("iron_hoe"));

  /**
   * The minecraft:iron_horse_armor item type.
   *
   * @since 0.1
   */
  ItemType IRON_HORSE_ARMOR = item(Key.key("iron_horse_armor"));

  /**
   * The minecraft:iron_ingot item type.
   *
   * @since 0.1
   */
  ItemType IRON_INGOT = item(Key.key("iron_ingot"));

  /**
   * The minecraft:iron_leggings item type.
   *
   * @since 0.1
   */
  ItemType IRON_LEGGINGS = item(Key.key("iron_leggings"));

  /**
   * The minecraft:iron_nugget item type.
   *
   * @since 0.1
   */
  ItemType IRON_NUGGET = item(Key.key("iron_nugget"));

  /**
   * The minecraft:iron_ore item type.
   *
   * @since 0.1
   */
  ItemType IRON_ORE = block(Key.key("iron_ore"));

  /**
   * The minecraft:iron_pickaxe item type.
   *
   * @since 0.1
   */
  ItemType IRON_PICKAXE = item(Key.key("iron_pickaxe"));

  /**
   * The minecraft:iron_shovel item type.
   *
   * @since 0.1
   */
  ItemType IRON_SHOVEL = item(Key.key("iron_shovel"));

  /**
   * The minecraft:iron_sword item type.
   *
   * @since 0.1
   */
  ItemType IRON_SWORD = item(Key.key("iron_sword"));

  /**
   * The minecraft:iron_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType IRON_TRAPDOOR = block(Key.key("iron_trapdoor"));

  /**
   * The minecraft:item_frame item type.
   *
   * @since 0.1
   */
  ItemType ITEM_FRAME = item(Key.key("item_frame"));

  /**
   * The minecraft:jack_o_lantern item type.
   *
   * @since 0.1
   */
  ItemType JACK_O_LANTERN = block(Key.key("jack_o_lantern"));

  /**
   * The minecraft:jigsaw item type.
   *
   * @since 0.1
   */
  ItemType JIGSAW = block(Key.key("jigsaw"));

  /**
   * The minecraft:jukebox item type.
   *
   * @since 0.1
   */
  ItemType JUKEBOX = block(Key.key("jukebox"));

  /**
   * The minecraft:jungle_boat item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_BOAT = item(Key.key("jungle_boat"));

  /**
   * The minecraft:jungle_button item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_BUTTON = block(Key.key("jungle_button"));

  /**
   * The minecraft:jungle_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_CHEST_BOAT = item(Key.key("jungle_chest_boat"));

  /**
   * The minecraft:jungle_door item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_DOOR = block(Key.key("jungle_door"));

  /**
   * The minecraft:jungle_fence item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_FENCE = block(Key.key("jungle_fence"));

  /**
   * The minecraft:jungle_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_FENCE_GATE = block(Key.key("jungle_fence_gate"));

  /**
   * The minecraft:jungle_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_HANGING_SIGN = block(Key.key("jungle_hanging_sign"));

  /**
   * The minecraft:jungle_leaves item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_LEAVES = block(Key.key("jungle_leaves"));

  /**
   * The minecraft:jungle_log item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_LOG = block(Key.key("jungle_log"));

  /**
   * The minecraft:jungle_planks item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_PLANKS = block(Key.key("jungle_planks"));

  /**
   * The minecraft:jungle_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_PRESSURE_PLATE = block(Key.key("jungle_pressure_plate"));

  /**
   * The minecraft:jungle_sapling item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_SAPLING = block(Key.key("jungle_sapling"));

  /**
   * The minecraft:jungle_sign item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_SIGN = block(Key.key("jungle_sign"));

  /**
   * The minecraft:jungle_slab item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_SLAB = block(Key.key("jungle_slab"));

  /**
   * The minecraft:jungle_stairs item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_STAIRS = block(Key.key("jungle_stairs"));

  /**
   * The minecraft:jungle_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_TRAPDOOR = block(Key.key("jungle_trapdoor"));

  /**
   * The minecraft:jungle_wood item type.
   *
   * @since 0.1
   */
  ItemType JUNGLE_WOOD = block(Key.key("jungle_wood"));

  /**
   * The minecraft:kelp item type.
   *
   * @since 0.1
   */
  ItemType KELP = block(Key.key("kelp"));

  /**
   * The minecraft:knowledge_book item type.
   *
   * @since 0.1
   */
  ItemType KNOWLEDGE_BOOK = item(Key.key("knowledge_book"));

  /**
   * The minecraft:ladder item type.
   *
   * @since 0.1
   */
  ItemType LADDER = block(Key.key("ladder"));

  /**
   * The minecraft:lantern item type.
   *
   * @since 0.1
   */
  ItemType LANTERN = block(Key.key("lantern"));

  /**
   * The minecraft:lapis_block item type.
   *
   * @since 0.1
   */
  ItemType LAPIS_BLOCK = block(Key.key("lapis_block"));

  /**
   * The minecraft:lapis_lazuli item type.
   *
   * @since 0.1
   */
  ItemType LAPIS_LAZULI = item(Key.key("lapis_lazuli"));

  /**
   * The minecraft:lapis_ore item type.
   *
   * @since 0.1
   */
  ItemType LAPIS_ORE = block(Key.key("lapis_ore"));

  /**
   * The minecraft:large_amethyst_bud item type.
   *
   * @since 0.1
   */
  ItemType LARGE_AMETHYST_BUD = block(Key.key("large_amethyst_bud"));

  /**
   * The minecraft:large_fern item type.
   *
   * @since 0.1
   */
  ItemType LARGE_FERN = block(Key.key("large_fern"));

  /**
   * The minecraft:lava_bucket item type.
   *
   * @since 0.1
   */
  ItemType LAVA_BUCKET = item(Key.key("lava_bucket"));

  /**
   * The minecraft:lead item type.
   *
   * @since 0.1
   */
  ItemType LEAD = item(Key.key("lead"));

  /**
   * The minecraft:leather item type.
   *
   * @since 0.1
   */
  ItemType LEATHER = item(Key.key("leather"));

  /**
   * The minecraft:leather_boots item type.
   *
   * @since 0.1
   */
  ItemType LEATHER_BOOTS = item(Key.key("leather_boots"));

  /**
   * The minecraft:leather_chestplate item type.
   *
   * @since 0.1
   */
  ItemType LEATHER_CHESTPLATE = item(Key.key("leather_chestplate"));

  /**
   * The minecraft:leather_helmet item type.
   *
   * @since 0.1
   */
  ItemType LEATHER_HELMET = item(Key.key("leather_helmet"));

  /**
   * The minecraft:leather_horse_armor item type.
   *
   * @since 0.1
   */
  ItemType LEATHER_HORSE_ARMOR = item(Key.key("leather_horse_armor"));

  /**
   * The minecraft:leather_leggings item type.
   *
   * @since 0.1
   */
  ItemType LEATHER_LEGGINGS = item(Key.key("leather_leggings"));

  /**
   * The minecraft:lectern item type.
   *
   * @since 0.1
   */
  ItemType LECTERN = block(Key.key("lectern"));

  /**
   * The minecraft:lever item type.
   *
   * @since 0.1
   */
  ItemType LEVER = block(Key.key("lever"));

  /**
   * The minecraft:light item type.
   *
   * @since 0.1
   */
  ItemType LIGHT = block(Key.key("light"));

  /**
   * The minecraft:light_blue_banner item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_BANNER = block(Key.key("light_blue_banner"));

  /**
   * The minecraft:light_blue_bed item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_BED = block(Key.key("light_blue_bed"));

  /**
   * The minecraft:light_blue_candle item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_CANDLE = block(Key.key("light_blue_candle"));

  /**
   * The minecraft:light_blue_carpet item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_CARPET = block(Key.key("light_blue_carpet"));

  /**
   * The minecraft:light_blue_concrete item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_CONCRETE = block(Key.key("light_blue_concrete"));

  /**
   * The minecraft:light_blue_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_CONCRETE_POWDER = block(Key.key("light_blue_concrete_powder"));

  /**
   * The minecraft:light_blue_dye item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_DYE = item(Key.key("light_blue_dye"));

  /**
   * The minecraft:light_blue_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_GLAZED_TERRACOTTA = block(Key.key("light_blue_glazed_terracotta"));

  /**
   * The minecraft:light_blue_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_SHULKER_BOX = block(Key.key("light_blue_shulker_box"));

  /**
   * The minecraft:light_blue_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_STAINED_GLASS = block(Key.key("light_blue_stained_glass"));

  /**
   * The minecraft:light_blue_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_STAINED_GLASS_PANE = block(Key.key("light_blue_stained_glass_pane"));

  /**
   * The minecraft:light_blue_terracotta item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_TERRACOTTA = block(Key.key("light_blue_terracotta"));

  /**
   * The minecraft:light_blue_wool item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_BLUE_WOOL = block(Key.key("light_blue_wool"));

  /**
   * The minecraft:light_gray_banner item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_BANNER = block(Key.key("light_gray_banner"));

  /**
   * The minecraft:light_gray_bed item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_BED = block(Key.key("light_gray_bed"));

  /**
   * The minecraft:light_gray_candle item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_CANDLE = block(Key.key("light_gray_candle"));

  /**
   * The minecraft:light_gray_carpet item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_CARPET = block(Key.key("light_gray_carpet"));

  /**
   * The minecraft:light_gray_concrete item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_CONCRETE = block(Key.key("light_gray_concrete"));

  /**
   * The minecraft:light_gray_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_CONCRETE_POWDER = block(Key.key("light_gray_concrete_powder"));

  /**
   * The minecraft:light_gray_dye item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_DYE = item(Key.key("light_gray_dye"));

  /**
   * The minecraft:light_gray_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_GLAZED_TERRACOTTA = block(Key.key("light_gray_glazed_terracotta"));

  /**
   * The minecraft:light_gray_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_SHULKER_BOX = block(Key.key("light_gray_shulker_box"));

  /**
   * The minecraft:light_gray_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_STAINED_GLASS = block(Key.key("light_gray_stained_glass"));

  /**
   * The minecraft:light_gray_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_STAINED_GLASS_PANE = block(Key.key("light_gray_stained_glass_pane"));

  /**
   * The minecraft:light_gray_terracotta item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_TERRACOTTA = block(Key.key("light_gray_terracotta"));

  /**
   * The minecraft:light_gray_wool item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_GRAY_WOOL = block(Key.key("light_gray_wool"));

  /**
   * The minecraft:light_weighted_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType LIGHT_WEIGHTED_PRESSURE_PLATE = block(Key.key("light_weighted_pressure_plate"));

  /**
   * The minecraft:lightning_rod item type.
   *
   * @since 0.1
   */
  ItemType LIGHTNING_ROD = block(Key.key("lightning_rod"));

  /**
   * The minecraft:lilac item type.
   *
   * @since 0.1
   */
  ItemType LILAC = block(Key.key("lilac"));

  /**
   * The minecraft:lily_of_the_valley item type.
   *
   * @since 0.1
   */
  ItemType LILY_OF_THE_VALLEY = block(Key.key("lily_of_the_valley"));

  /**
   * The minecraft:lily_pad item type.
   *
   * @since 0.1
   */
  ItemType LILY_PAD = block(Key.key("lily_pad"));

  /**
   * The minecraft:lime_banner item type.
   *
   * @since 0.1
   */
  ItemType LIME_BANNER = block(Key.key("lime_banner"));

  /**
   * The minecraft:lime_bed item type.
   *
   * @since 0.1
   */
  ItemType LIME_BED = block(Key.key("lime_bed"));

  /**
   * The minecraft:lime_candle item type.
   *
   * @since 0.1
   */
  ItemType LIME_CANDLE = block(Key.key("lime_candle"));

  /**
   * The minecraft:lime_carpet item type.
   *
   * @since 0.1
   */
  ItemType LIME_CARPET = block(Key.key("lime_carpet"));

  /**
   * The minecraft:lime_concrete item type.
   *
   * @since 0.1
   */
  ItemType LIME_CONCRETE = block(Key.key("lime_concrete"));

  /**
   * The minecraft:lime_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType LIME_CONCRETE_POWDER = block(Key.key("lime_concrete_powder"));

  /**
   * The minecraft:lime_dye item type.
   *
   * @since 0.1
   */
  ItemType LIME_DYE = item(Key.key("lime_dye"));

  /**
   * The minecraft:lime_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType LIME_GLAZED_TERRACOTTA = block(Key.key("lime_glazed_terracotta"));

  /**
   * The minecraft:lime_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType LIME_SHULKER_BOX = block(Key.key("lime_shulker_box"));

  /**
   * The minecraft:lime_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType LIME_STAINED_GLASS = block(Key.key("lime_stained_glass"));

  /**
   * The minecraft:lime_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType LIME_STAINED_GLASS_PANE = block(Key.key("lime_stained_glass_pane"));

  /**
   * The minecraft:lime_terracotta item type.
   *
   * @since 0.1
   */
  ItemType LIME_TERRACOTTA = block(Key.key("lime_terracotta"));

  /**
   * The minecraft:lime_wool item type.
   *
   * @since 0.1
   */
  ItemType LIME_WOOL = block(Key.key("lime_wool"));

  /**
   * The minecraft:lingering_potion item type.
   *
   * @since 0.1
   */
  ItemType LINGERING_POTION = item(Key.key("lingering_potion"));

  /**
   * The minecraft:llama_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType LLAMA_SPAWN_EGG = item(Key.key("llama_spawn_egg"));

  /**
   * The minecraft:lodestone item type.
   *
   * @since 0.1
   */
  ItemType LODESTONE = block(Key.key("lodestone"));

  /**
   * The minecraft:loom item type.
   *
   * @since 0.1
   */
  ItemType LOOM = block(Key.key("loom"));

  /**
   * The minecraft:magenta_banner item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_BANNER = block(Key.key("magenta_banner"));

  /**
   * The minecraft:magenta_bed item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_BED = block(Key.key("magenta_bed"));

  /**
   * The minecraft:magenta_candle item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_CANDLE = block(Key.key("magenta_candle"));

  /**
   * The minecraft:magenta_carpet item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_CARPET = block(Key.key("magenta_carpet"));

  /**
   * The minecraft:magenta_concrete item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_CONCRETE = block(Key.key("magenta_concrete"));

  /**
   * The minecraft:magenta_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_CONCRETE_POWDER = block(Key.key("magenta_concrete_powder"));

  /**
   * The minecraft:magenta_dye item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_DYE = item(Key.key("magenta_dye"));

  /**
   * The minecraft:magenta_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_GLAZED_TERRACOTTA = block(Key.key("magenta_glazed_terracotta"));

  /**
   * The minecraft:magenta_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_SHULKER_BOX = block(Key.key("magenta_shulker_box"));

  /**
   * The minecraft:magenta_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_STAINED_GLASS = block(Key.key("magenta_stained_glass"));

  /**
   * The minecraft:magenta_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_STAINED_GLASS_PANE = block(Key.key("magenta_stained_glass_pane"));

  /**
   * The minecraft:magenta_terracotta item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_TERRACOTTA = block(Key.key("magenta_terracotta"));

  /**
   * The minecraft:magenta_wool item type.
   *
   * @since 0.1
   */
  ItemType MAGENTA_WOOL = block(Key.key("magenta_wool"));

  /**
   * The minecraft:magma_block item type.
   *
   * @since 0.1
   */
  ItemType MAGMA_BLOCK = block(Key.key("magma_block"));

  /**
   * The minecraft:magma_cream item type.
   *
   * @since 0.1
   */
  ItemType MAGMA_CREAM = item(Key.key("magma_cream"));

  /**
   * The minecraft:magma_cube_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType MAGMA_CUBE_SPAWN_EGG = item(Key.key("magma_cube_spawn_egg"));

  /**
   * The minecraft:mangrove_boat item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_BOAT = item(Key.key("mangrove_boat"));

  /**
   * The minecraft:mangrove_button item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_BUTTON = block(Key.key("mangrove_button"));

  /**
   * The minecraft:mangrove_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_CHEST_BOAT = item(Key.key("mangrove_chest_boat"));

  /**
   * The minecraft:mangrove_door item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_DOOR = block(Key.key("mangrove_door"));

  /**
   * The minecraft:mangrove_fence item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_FENCE = block(Key.key("mangrove_fence"));

  /**
   * The minecraft:mangrove_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_FENCE_GATE = block(Key.key("mangrove_fence_gate"));

  /**
   * The minecraft:mangrove_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_HANGING_SIGN = block(Key.key("mangrove_hanging_sign"));

  /**
   * The minecraft:mangrove_leaves item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_LEAVES = block(Key.key("mangrove_leaves"));

  /**
   * The minecraft:mangrove_log item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_LOG = block(Key.key("mangrove_log"));

  /**
   * The minecraft:mangrove_planks item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_PLANKS = block(Key.key("mangrove_planks"));

  /**
   * The minecraft:mangrove_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_PRESSURE_PLATE = block(Key.key("mangrove_pressure_plate"));

  /**
   * The minecraft:mangrove_propagule item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_PROPAGULE = block(Key.key("mangrove_propagule"));

  /**
   * The minecraft:mangrove_roots item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_ROOTS = block(Key.key("mangrove_roots"));

  /**
   * The minecraft:mangrove_sign item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_SIGN = block(Key.key("mangrove_sign"));

  /**
   * The minecraft:mangrove_slab item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_SLAB = block(Key.key("mangrove_slab"));

  /**
   * The minecraft:mangrove_stairs item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_STAIRS = block(Key.key("mangrove_stairs"));

  /**
   * The minecraft:mangrove_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_TRAPDOOR = block(Key.key("mangrove_trapdoor"));

  /**
   * The minecraft:mangrove_wood item type.
   *
   * @since 0.1
   */
  ItemType MANGROVE_WOOD = block(Key.key("mangrove_wood"));

  /**
   * The minecraft:map item type.
   *
   * @since 0.1
   */
  ItemType MAP = item(Key.key("map"));

  /**
   * The minecraft:medium_amethyst_bud item type.
   *
   * @since 0.1
   */
  ItemType MEDIUM_AMETHYST_BUD = block(Key.key("medium_amethyst_bud"));

  /**
   * The minecraft:melon item type.
   *
   * @since 0.1
   */
  ItemType MELON = block(Key.key("melon"));

  /**
   * The minecraft:melon_seeds item type.
   *
   * @since 0.1
   */
  ItemType MELON_SEEDS = item(Key.key("melon_seeds"));

  /**
   * The minecraft:melon_slice item type.
   *
   * @since 0.1
   */
  ItemType MELON_SLICE = item(Key.key("melon_slice"));

  /**
   * The minecraft:milk_bucket item type.
   *
   * @since 0.1
   */
  ItemType MILK_BUCKET = item(Key.key("milk_bucket"));

  /**
   * The minecraft:minecart item type.
   *
   * @since 0.1
   */
  ItemType MINECART = item(Key.key("minecart"));

  /**
   * The minecraft:miner_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType MINER_POTTERY_SHERD = item(Key.key("miner_pottery_sherd"));

  /**
   * The minecraft:mojang_banner_pattern item type.
   *
   * @since 0.1
   */
  ItemType MOJANG_BANNER_PATTERN = item(Key.key("mojang_banner_pattern"));

  /**
   * The minecraft:mooshroom_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType MOOSHROOM_SPAWN_EGG = item(Key.key("mooshroom_spawn_egg"));

  /**
   * The minecraft:moss_block item type.
   *
   * @since 0.1
   */
  ItemType MOSS_BLOCK = block(Key.key("moss_block"));

  /**
   * The minecraft:moss_carpet item type.
   *
   * @since 0.1
   */
  ItemType MOSS_CARPET = block(Key.key("moss_carpet"));

  /**
   * The minecraft:mossy_cobblestone item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_COBBLESTONE = block(Key.key("mossy_cobblestone"));

  /**
   * The minecraft:mossy_cobblestone_slab item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_COBBLESTONE_SLAB = block(Key.key("mossy_cobblestone_slab"));

  /**
   * The minecraft:mossy_cobblestone_stairs item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_COBBLESTONE_STAIRS = block(Key.key("mossy_cobblestone_stairs"));

  /**
   * The minecraft:mossy_cobblestone_wall item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_COBBLESTONE_WALL = block(Key.key("mossy_cobblestone_wall"));

  /**
   * The minecraft:mossy_stone_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_STONE_BRICK_SLAB = block(Key.key("mossy_stone_brick_slab"));

  /**
   * The minecraft:mossy_stone_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_STONE_BRICK_STAIRS = block(Key.key("mossy_stone_brick_stairs"));

  /**
   * The minecraft:mossy_stone_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_STONE_BRICK_WALL = block(Key.key("mossy_stone_brick_wall"));

  /**
   * The minecraft:mossy_stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType MOSSY_STONE_BRICKS = block(Key.key("mossy_stone_bricks"));

  /**
   * The minecraft:mourner_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType MOURNER_POTTERY_SHERD = item(Key.key("mourner_pottery_sherd"));

  /**
   * The minecraft:mud item type.
   *
   * @since 0.1
   */
  ItemType MUD = block(Key.key("mud"));

  /**
   * The minecraft:mud_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType MUD_BRICK_SLAB = block(Key.key("mud_brick_slab"));

  /**
   * The minecraft:mud_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType MUD_BRICK_STAIRS = block(Key.key("mud_brick_stairs"));

  /**
   * The minecraft:mud_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType MUD_BRICK_WALL = block(Key.key("mud_brick_wall"));

  /**
   * The minecraft:mud_bricks item type.
   *
   * @since 0.1
   */
  ItemType MUD_BRICKS = block(Key.key("mud_bricks"));

  /**
   * The minecraft:muddy_mangrove_roots item type.
   *
   * @since 0.1
   */
  ItemType MUDDY_MANGROVE_ROOTS = block(Key.key("muddy_mangrove_roots"));

  /**
   * The minecraft:mule_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType MULE_SPAWN_EGG = item(Key.key("mule_spawn_egg"));

  /**
   * The minecraft:mushroom_stem item type.
   *
   * @since 0.1
   */
  ItemType MUSHROOM_STEM = block(Key.key("mushroom_stem"));

  /**
   * The minecraft:mushroom_stew item type.
   *
   * @since 0.1
   */
  ItemType MUSHROOM_STEW = item(Key.key("mushroom_stew"));

  /**
   * The minecraft:music_disc_11 item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_11 = item(Key.key("music_disc_11"));

  /**
   * The minecraft:music_disc_13 item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_13 = item(Key.key("music_disc_13"));

  /**
   * The minecraft:music_disc_5 item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_5 = item(Key.key("music_disc_5"));

  /**
   * The minecraft:music_disc_blocks item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_BLOCKS = item(Key.key("music_disc_blocks"));

  /**
   * The minecraft:music_disc_cat item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_CAT = item(Key.key("music_disc_cat"));

  /**
   * The minecraft:music_disc_chirp item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_CHIRP = item(Key.key("music_disc_chirp"));

  /**
   * The minecraft:music_disc_far item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_FAR = item(Key.key("music_disc_far"));

  /**
   * The minecraft:music_disc_mall item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_MALL = item(Key.key("music_disc_mall"));

  /**
   * The minecraft:music_disc_mellohi item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_MELLOHI = item(Key.key("music_disc_mellohi"));

  /**
   * The minecraft:music_disc_otherside item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_OTHERSIDE = item(Key.key("music_disc_otherside"));

  /**
   * The minecraft:music_disc_pigstep item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_PIGSTEP = item(Key.key("music_disc_pigstep"));

  /**
   * The minecraft:music_disc_relic item type.
   *
   * @since 0.2
   */
  ItemType MUSIC_DISC_RELIC = item(Key.key("music_disc_relic"));

  /**
   * The minecraft:music_disc_stal item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_STAL = item(Key.key("music_disc_stal"));

  /**
   * The minecraft:music_disc_strad item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_STRAD = item(Key.key("music_disc_strad"));

  /**
   * The minecraft:music_disc_wait item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_WAIT = item(Key.key("music_disc_wait"));

  /**
   * The minecraft:music_disc_ward item type.
   *
   * @since 0.1
   */
  ItemType MUSIC_DISC_WARD = item(Key.key("music_disc_ward"));

  /**
   * The minecraft:mutton item type.
   *
   * @since 0.1
   */
  ItemType MUTTON = item(Key.key("mutton"));

  /**
   * The minecraft:mycelium item type.
   *
   * @since 0.1
   */
  ItemType MYCELIUM = block(Key.key("mycelium"));

  /**
   * The minecraft:name_tag item type.
   *
   * @since 0.1
   */
  ItemType NAME_TAG = item(Key.key("name_tag"));

  /**
   * The minecraft:nautilus_shell item type.
   *
   * @since 0.1
   */
  ItemType NAUTILUS_SHELL = item(Key.key("nautilus_shell"));

  /**
   * The minecraft:nether_brick item type.
   *
   * @since 0.1
   */
  ItemType NETHER_BRICK = item(Key.key("nether_brick"));

  /**
   * The minecraft:nether_brick_fence item type.
   *
   * @since 0.1
   */
  ItemType NETHER_BRICK_FENCE = block(Key.key("nether_brick_fence"));

  /**
   * The minecraft:nether_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType NETHER_BRICK_SLAB = block(Key.key("nether_brick_slab"));

  /**
   * The minecraft:nether_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType NETHER_BRICK_STAIRS = block(Key.key("nether_brick_stairs"));

  /**
   * The minecraft:nether_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType NETHER_BRICK_WALL = block(Key.key("nether_brick_wall"));

  /**
   * The minecraft:nether_bricks item type.
   *
   * @since 0.1
   */
  ItemType NETHER_BRICKS = block(Key.key("nether_bricks"));

  /**
   * The minecraft:nether_gold_ore item type.
   *
   * @since 0.1
   */
  ItemType NETHER_GOLD_ORE = block(Key.key("nether_gold_ore"));

  /**
   * The minecraft:nether_quartz_ore item type.
   *
   * @since 0.1
   */
  ItemType NETHER_QUARTZ_ORE = block(Key.key("nether_quartz_ore"));

  /**
   * The minecraft:nether_sprouts item type.
   *
   * @since 0.1
   */
  ItemType NETHER_SPROUTS = block(Key.key("nether_sprouts"));

  /**
   * The minecraft:nether_star item type.
   *
   * @since 0.1
   */
  ItemType NETHER_STAR = item(Key.key("nether_star"));

  /**
   * The minecraft:nether_wart item type.
   *
   * @since 0.1
   */
  ItemType NETHER_WART = block(Key.key("nether_wart"));

  /**
   * The minecraft:nether_wart_block item type.
   *
   * @since 0.1
   */
  ItemType NETHER_WART_BLOCK = block(Key.key("nether_wart_block"));

  /**
   * The minecraft:netherite_axe item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_AXE = item(Key.key("netherite_axe"));

  /**
   * The minecraft:netherite_block item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_BLOCK = block(Key.key("netherite_block"));

  /**
   * The minecraft:netherite_boots item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_BOOTS = item(Key.key("netherite_boots"));

  /**
   * The minecraft:netherite_chestplate item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_CHESTPLATE = item(Key.key("netherite_chestplate"));

  /**
   * The minecraft:netherite_helmet item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_HELMET = item(Key.key("netherite_helmet"));

  /**
   * The minecraft:netherite_hoe item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_HOE = item(Key.key("netherite_hoe"));

  /**
   * The minecraft:netherite_ingot item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_INGOT = item(Key.key("netherite_ingot"));

  /**
   * The minecraft:netherite_leggings item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_LEGGINGS = item(Key.key("netherite_leggings"));

  /**
   * The minecraft:netherite_pickaxe item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_PICKAXE = item(Key.key("netherite_pickaxe"));

  /**
   * The minecraft:netherite_scrap item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_SCRAP = item(Key.key("netherite_scrap"));

  /**
   * The minecraft:netherite_shovel item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_SHOVEL = item(Key.key("netherite_shovel"));

  /**
   * The minecraft:netherite_sword item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_SWORD = item(Key.key("netherite_sword"));

  /**
   * The minecraft:netherite_upgrade_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType NETHERITE_UPGRADE_SMITHING_TEMPLATE =
      item(Key.key("netherite_upgrade_smithing_template"));

  /**
   * The minecraft:netherrack item type.
   *
   * @since 0.1
   */
  ItemType NETHERRACK = block(Key.key("netherrack"));

  /**
   * The minecraft:note_block item type.
   *
   * @since 0.1
   */
  ItemType NOTE_BLOCK = block(Key.key("note_block"));

  /**
   * The minecraft:oak_boat item type.
   *
   * @since 0.1
   */
  ItemType OAK_BOAT = item(Key.key("oak_boat"));

  /**
   * The minecraft:oak_button item type.
   *
   * @since 0.1
   */
  ItemType OAK_BUTTON = block(Key.key("oak_button"));

  /**
   * The minecraft:oak_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType OAK_CHEST_BOAT = item(Key.key("oak_chest_boat"));

  /**
   * The minecraft:oak_door item type.
   *
   * @since 0.1
   */
  ItemType OAK_DOOR = block(Key.key("oak_door"));

  /**
   * The minecraft:oak_fence item type.
   *
   * @since 0.1
   */
  ItemType OAK_FENCE = block(Key.key("oak_fence"));

  /**
   * The minecraft:oak_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType OAK_FENCE_GATE = block(Key.key("oak_fence_gate"));

  /**
   * The minecraft:oak_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType OAK_HANGING_SIGN = block(Key.key("oak_hanging_sign"));

  /**
   * The minecraft:oak_leaves item type.
   *
   * @since 0.1
   */
  ItemType OAK_LEAVES = block(Key.key("oak_leaves"));

  /**
   * The minecraft:oak_log item type.
   *
   * @since 0.1
   */
  ItemType OAK_LOG = block(Key.key("oak_log"));

  /**
   * The minecraft:oak_planks item type.
   *
   * @since 0.1
   */
  ItemType OAK_PLANKS = block(Key.key("oak_planks"));

  /**
   * The minecraft:oak_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType OAK_PRESSURE_PLATE = block(Key.key("oak_pressure_plate"));

  /**
   * The minecraft:oak_sapling item type.
   *
   * @since 0.1
   */
  ItemType OAK_SAPLING = block(Key.key("oak_sapling"));

  /**
   * The minecraft:oak_sign item type.
   *
   * @since 0.1
   */
  ItemType OAK_SIGN = block(Key.key("oak_sign"));

  /**
   * The minecraft:oak_slab item type.
   *
   * @since 0.1
   */
  ItemType OAK_SLAB = block(Key.key("oak_slab"));

  /**
   * The minecraft:oak_stairs item type.
   *
   * @since 0.1
   */
  ItemType OAK_STAIRS = block(Key.key("oak_stairs"));

  /**
   * The minecraft:oak_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType OAK_TRAPDOOR = block(Key.key("oak_trapdoor"));

  /**
   * The minecraft:oak_wood item type.
   *
   * @since 0.1
   */
  ItemType OAK_WOOD = block(Key.key("oak_wood"));

  /**
   * The minecraft:observer item type.
   *
   * @since 0.1
   */
  ItemType OBSERVER = block(Key.key("observer"));

  /**
   * The minecraft:obsidian item type.
   *
   * @since 0.1
   */
  ItemType OBSIDIAN = block(Key.key("obsidian"));

  /**
   * The minecraft:ocelot_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType OCELOT_SPAWN_EGG = item(Key.key("ocelot_spawn_egg"));

  /**
   * The minecraft:ochre_froglight item type.
   *
   * @since 0.1
   */
  ItemType OCHRE_FROGLIGHT = block(Key.key("ochre_froglight"));

  /**
   * The minecraft:orange_banner item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_BANNER = block(Key.key("orange_banner"));

  /**
   * The minecraft:orange_bed item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_BED = block(Key.key("orange_bed"));

  /**
   * The minecraft:orange_candle item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_CANDLE = block(Key.key("orange_candle"));

  /**
   * The minecraft:orange_carpet item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_CARPET = block(Key.key("orange_carpet"));

  /**
   * The minecraft:orange_concrete item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_CONCRETE = block(Key.key("orange_concrete"));

  /**
   * The minecraft:orange_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_CONCRETE_POWDER = block(Key.key("orange_concrete_powder"));

  /**
   * The minecraft:orange_dye item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_DYE = item(Key.key("orange_dye"));

  /**
   * The minecraft:orange_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_GLAZED_TERRACOTTA = block(Key.key("orange_glazed_terracotta"));

  /**
   * The minecraft:orange_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_SHULKER_BOX = block(Key.key("orange_shulker_box"));

  /**
   * The minecraft:orange_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_STAINED_GLASS = block(Key.key("orange_stained_glass"));

  /**
   * The minecraft:orange_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_STAINED_GLASS_PANE = block(Key.key("orange_stained_glass_pane"));

  /**
   * The minecraft:orange_terracotta item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_TERRACOTTA = block(Key.key("orange_terracotta"));

  /**
   * The minecraft:orange_tulip item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_TULIP = block(Key.key("orange_tulip"));

  /**
   * The minecraft:orange_wool item type.
   *
   * @since 0.1
   */
  ItemType ORANGE_WOOL = block(Key.key("orange_wool"));

  /**
   * The minecraft:oxeye_daisy item type.
   *
   * @since 0.1
   */
  ItemType OXEYE_DAISY = block(Key.key("oxeye_daisy"));

  /**
   * The minecraft:oxidized_copper item type.
   *
   * @since 0.1
   */
  ItemType OXIDIZED_COPPER = block(Key.key("oxidized_copper"));

  /**
   * The minecraft:oxidized_cut_copper item type.
   *
   * @since 0.1
   */
  ItemType OXIDIZED_CUT_COPPER = block(Key.key("oxidized_cut_copper"));

  /**
   * The minecraft:oxidized_cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType OXIDIZED_CUT_COPPER_SLAB = block(Key.key("oxidized_cut_copper_slab"));

  /**
   * The minecraft:oxidized_cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType OXIDIZED_CUT_COPPER_STAIRS = block(Key.key("oxidized_cut_copper_stairs"));

  /**
   * The minecraft:packed_ice item type.
   *
   * @since 0.1
   */
  ItemType PACKED_ICE = block(Key.key("packed_ice"));

  /**
   * The minecraft:packed_mud item type.
   *
   * @since 0.1
   */
  ItemType PACKED_MUD = block(Key.key("packed_mud"));

  /**
   * The minecraft:painting item type.
   *
   * @since 0.1
   */
  ItemType PAINTING = item(Key.key("painting"));

  /**
   * The minecraft:panda_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PANDA_SPAWN_EGG = item(Key.key("panda_spawn_egg"));

  /**
   * The minecraft:paper item type.
   *
   * @since 0.1
   */
  ItemType PAPER = item(Key.key("paper"));

  /**
   * The minecraft:parrot_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PARROT_SPAWN_EGG = item(Key.key("parrot_spawn_egg"));

  /**
   * The minecraft:pearlescent_froglight item type.
   *
   * @since 0.1
   */
  ItemType PEARLESCENT_FROGLIGHT = block(Key.key("pearlescent_froglight"));

  /**
   * The minecraft:peony item type.
   *
   * @since 0.1
   */
  ItemType PEONY = block(Key.key("peony"));

  /**
   * The minecraft:petrified_oak_slab item type.
   *
   * @since 0.1
   */
  ItemType PETRIFIED_OAK_SLAB = block(Key.key("petrified_oak_slab"));

  /**
   * The minecraft:phantom_membrane item type.
   *
   * @since 0.1
   */
  ItemType PHANTOM_MEMBRANE = item(Key.key("phantom_membrane"));

  /**
   * The minecraft:phantom_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PHANTOM_SPAWN_EGG = item(Key.key("phantom_spawn_egg"));

  /**
   * The minecraft:pig_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PIG_SPAWN_EGG = item(Key.key("pig_spawn_egg"));

  /**
   * The minecraft:piglin_banner_pattern item type.
   *
   * @since 0.1
   */
  ItemType PIGLIN_BANNER_PATTERN = item(Key.key("piglin_banner_pattern"));

  /**
   * The minecraft:piglin_brute_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PIGLIN_BRUTE_SPAWN_EGG = item(Key.key("piglin_brute_spawn_egg"));

  /**
   * The minecraft:piglin_head item type.
   *
   * @since 0.1
   */
  ItemType PIGLIN_HEAD = block(Key.key("piglin_head"));

  /**
   * The minecraft:piglin_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PIGLIN_SPAWN_EGG = item(Key.key("piglin_spawn_egg"));

  /**
   * The minecraft:pillager_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PILLAGER_SPAWN_EGG = item(Key.key("pillager_spawn_egg"));

  /**
   * The minecraft:pink_banner item type.
   *
   * @since 0.1
   */
  ItemType PINK_BANNER = block(Key.key("pink_banner"));

  /**
   * The minecraft:pink_bed item type.
   *
   * @since 0.1
   */
  ItemType PINK_BED = block(Key.key("pink_bed"));

  /**
   * The minecraft:pink_candle item type.
   *
   * @since 0.1
   */
  ItemType PINK_CANDLE = block(Key.key("pink_candle"));

  /**
   * The minecraft:pink_carpet item type.
   *
   * @since 0.1
   */
  ItemType PINK_CARPET = block(Key.key("pink_carpet"));

  /**
   * The minecraft:pink_concrete item type.
   *
   * @since 0.1
   */
  ItemType PINK_CONCRETE = block(Key.key("pink_concrete"));

  /**
   * The minecraft:pink_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType PINK_CONCRETE_POWDER = block(Key.key("pink_concrete_powder"));

  /**
   * The minecraft:pink_dye item type.
   *
   * @since 0.1
   */
  ItemType PINK_DYE = item(Key.key("pink_dye"));

  /**
   * The minecraft:pink_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType PINK_GLAZED_TERRACOTTA = block(Key.key("pink_glazed_terracotta"));

  /**
   * The minecraft:pink_petals item type.
   *
   * @since 0.1
   */
  ItemType PINK_PETALS = block(Key.key("pink_petals"));

  /**
   * The minecraft:pink_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType PINK_SHULKER_BOX = block(Key.key("pink_shulker_box"));

  /**
   * The minecraft:pink_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType PINK_STAINED_GLASS = block(Key.key("pink_stained_glass"));

  /**
   * The minecraft:pink_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType PINK_STAINED_GLASS_PANE = block(Key.key("pink_stained_glass_pane"));

  /**
   * The minecraft:pink_terracotta item type.
   *
   * @since 0.1
   */
  ItemType PINK_TERRACOTTA = block(Key.key("pink_terracotta"));

  /**
   * The minecraft:pink_tulip item type.
   *
   * @since 0.1
   */
  ItemType PINK_TULIP = block(Key.key("pink_tulip"));

  /**
   * The minecraft:pink_wool item type.
   *
   * @since 0.1
   */
  ItemType PINK_WOOL = block(Key.key("pink_wool"));

  /**
   * The minecraft:piston item type.
   *
   * @since 0.1
   */
  ItemType PISTON = block(Key.key("piston"));

  /**
   * The minecraft:pitcher_plant item type.
   *
   * @since 0.2
   */
  ItemType PITCHER_PLANT = block(Key.key("pitcher_plant"));

  /**
   * The minecraft:pitcher_pod item type.
   *
   * @since 0.2
   */
  ItemType PITCHER_POD = item(Key.key("pitcher_pod"));

  /**
   * The minecraft:player_head item type.
   *
   * @since 0.1
   */
  ItemType PLAYER_HEAD = block(Key.key("player_head"));

  /**
   * The minecraft:plenty_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType PLENTY_POTTERY_SHERD = item(Key.key("plenty_pottery_sherd"));

  /**
   * The minecraft:podzol item type.
   *
   * @since 0.1
   */
  ItemType PODZOL = block(Key.key("podzol"));

  /**
   * The minecraft:pointed_dripstone item type.
   *
   * @since 0.1
   */
  ItemType POINTED_DRIPSTONE = block(Key.key("pointed_dripstone"));

  /**
   * The minecraft:poisonous_potato item type.
   *
   * @since 0.1
   */
  ItemType POISONOUS_POTATO = item(Key.key("poisonous_potato"));

  /**
   * The minecraft:polar_bear_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType POLAR_BEAR_SPAWN_EGG = item(Key.key("polar_bear_spawn_egg"));

  /**
   * The minecraft:polished_andesite item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_ANDESITE = block(Key.key("polished_andesite"));

  /**
   * The minecraft:polished_andesite_slab item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_ANDESITE_SLAB = block(Key.key("polished_andesite_slab"));

  /**
   * The minecraft:polished_andesite_stairs item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_ANDESITE_STAIRS = block(Key.key("polished_andesite_stairs"));

  /**
   * The minecraft:polished_basalt item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BASALT = block(Key.key("polished_basalt"));

  /**
   * The minecraft:polished_blackstone item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE = block(Key.key("polished_blackstone"));

  /**
   * The minecraft:polished_blackstone_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_BRICK_SLAB = block(Key.key("polished_blackstone_brick_slab"));

  /**
   * The minecraft:polished_blackstone_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_BRICK_STAIRS = block(Key.key("polished_blackstone_brick_stairs"));

  /**
   * The minecraft:polished_blackstone_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_BRICK_WALL = block(Key.key("polished_blackstone_brick_wall"));

  /**
   * The minecraft:polished_blackstone_bricks item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_BRICKS = block(Key.key("polished_blackstone_bricks"));

  /**
   * The minecraft:polished_blackstone_button item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_BUTTON = block(Key.key("polished_blackstone_button"));

  /**
   * The minecraft:polished_blackstone_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_PRESSURE_PLATE =
      block(Key.key("polished_blackstone_pressure_plate"));

  /**
   * The minecraft:polished_blackstone_slab item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_SLAB = block(Key.key("polished_blackstone_slab"));

  /**
   * The minecraft:polished_blackstone_stairs item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_STAIRS = block(Key.key("polished_blackstone_stairs"));

  /**
   * The minecraft:polished_blackstone_wall item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_BLACKSTONE_WALL = block(Key.key("polished_blackstone_wall"));

  /**
   * The minecraft:polished_deepslate item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_DEEPSLATE = block(Key.key("polished_deepslate"));

  /**
   * The minecraft:polished_deepslate_slab item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_DEEPSLATE_SLAB = block(Key.key("polished_deepslate_slab"));

  /**
   * The minecraft:polished_deepslate_stairs item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_DEEPSLATE_STAIRS = block(Key.key("polished_deepslate_stairs"));

  /**
   * The minecraft:polished_deepslate_wall item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_DEEPSLATE_WALL = block(Key.key("polished_deepslate_wall"));

  /**
   * The minecraft:polished_diorite item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_DIORITE = block(Key.key("polished_diorite"));

  /**
   * The minecraft:polished_diorite_slab item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_DIORITE_SLAB = block(Key.key("polished_diorite_slab"));

  /**
   * The minecraft:polished_diorite_stairs item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_DIORITE_STAIRS = block(Key.key("polished_diorite_stairs"));

  /**
   * The minecraft:polished_granite item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_GRANITE = block(Key.key("polished_granite"));

  /**
   * The minecraft:polished_granite_slab item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_GRANITE_SLAB = block(Key.key("polished_granite_slab"));

  /**
   * The minecraft:polished_granite_stairs item type.
   *
   * @since 0.1
   */
  ItemType POLISHED_GRANITE_STAIRS = block(Key.key("polished_granite_stairs"));

  /**
   * The minecraft:popped_chorus_fruit item type.
   *
   * @since 0.1
   */
  ItemType POPPED_CHORUS_FRUIT = item(Key.key("popped_chorus_fruit"));

  /**
   * The minecraft:poppy item type.
   *
   * @since 0.1
   */
  ItemType POPPY = block(Key.key("poppy"));

  /**
   * The minecraft:porkchop item type.
   *
   * @since 0.1
   */
  ItemType PORKCHOP = item(Key.key("porkchop"));

  /**
   * The minecraft:potato item type.
   *
   * @since 0.1
   */
  ItemType POTATO = item(Key.key("potato"));

  /**
   * The minecraft:potion item type.
   *
   * @since 0.1
   */
  ItemType POTION = item(Key.key("potion"));

  /**
   * The minecraft:powder_snow_bucket item type.
   *
   * @since 0.1
   */
  ItemType POWDER_SNOW_BUCKET = item(Key.key("powder_snow_bucket"));

  /**
   * The minecraft:powered_rail item type.
   *
   * @since 0.1
   */
  ItemType POWERED_RAIL = block(Key.key("powered_rail"));

  /**
   * The minecraft:prismarine item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE = block(Key.key("prismarine"));

  /**
   * The minecraft:prismarine_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_BRICK_SLAB = block(Key.key("prismarine_brick_slab"));

  /**
   * The minecraft:prismarine_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_BRICK_STAIRS = block(Key.key("prismarine_brick_stairs"));

  /**
   * The minecraft:prismarine_bricks item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_BRICKS = block(Key.key("prismarine_bricks"));

  /**
   * The minecraft:prismarine_crystals item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_CRYSTALS = item(Key.key("prismarine_crystals"));

  /**
   * The minecraft:prismarine_shard item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_SHARD = item(Key.key("prismarine_shard"));

  /**
   * The minecraft:prismarine_slab item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_SLAB = block(Key.key("prismarine_slab"));

  /**
   * The minecraft:prismarine_stairs item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_STAIRS = block(Key.key("prismarine_stairs"));

  /**
   * The minecraft:prismarine_wall item type.
   *
   * @since 0.1
   */
  ItemType PRISMARINE_WALL = block(Key.key("prismarine_wall"));

  /**
   * The minecraft:prize_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType PRIZE_POTTERY_SHERD = item(Key.key("prize_pottery_sherd"));

  /**
   * The minecraft:pufferfish item type.
   *
   * @since 0.1
   */
  ItemType PUFFERFISH = item(Key.key("pufferfish"));

  /**
   * The minecraft:pufferfish_bucket item type.
   *
   * @since 0.1
   */
  ItemType PUFFERFISH_BUCKET = item(Key.key("pufferfish_bucket"));

  /**
   * The minecraft:pufferfish_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType PUFFERFISH_SPAWN_EGG = item(Key.key("pufferfish_spawn_egg"));

  /**
   * The minecraft:pumpkin item type.
   *
   * @since 0.1
   */
  ItemType PUMPKIN = block(Key.key("pumpkin"));

  /**
   * The minecraft:pumpkin_pie item type.
   *
   * @since 0.1
   */
  ItemType PUMPKIN_PIE = item(Key.key("pumpkin_pie"));

  /**
   * The minecraft:pumpkin_seeds item type.
   *
   * @since 0.1
   */
  ItemType PUMPKIN_SEEDS = item(Key.key("pumpkin_seeds"));

  /**
   * The minecraft:purple_banner item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_BANNER = block(Key.key("purple_banner"));

  /**
   * The minecraft:purple_bed item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_BED = block(Key.key("purple_bed"));

  /**
   * The minecraft:purple_candle item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_CANDLE = block(Key.key("purple_candle"));

  /**
   * The minecraft:purple_carpet item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_CARPET = block(Key.key("purple_carpet"));

  /**
   * The minecraft:purple_concrete item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_CONCRETE = block(Key.key("purple_concrete"));

  /**
   * The minecraft:purple_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_CONCRETE_POWDER = block(Key.key("purple_concrete_powder"));

  /**
   * The minecraft:purple_dye item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_DYE = item(Key.key("purple_dye"));

  /**
   * The minecraft:purple_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_GLAZED_TERRACOTTA = block(Key.key("purple_glazed_terracotta"));

  /**
   * The minecraft:purple_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_SHULKER_BOX = block(Key.key("purple_shulker_box"));

  /**
   * The minecraft:purple_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_STAINED_GLASS = block(Key.key("purple_stained_glass"));

  /**
   * The minecraft:purple_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_STAINED_GLASS_PANE = block(Key.key("purple_stained_glass_pane"));

  /**
   * The minecraft:purple_terracotta item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_TERRACOTTA = block(Key.key("purple_terracotta"));

  /**
   * The minecraft:purple_wool item type.
   *
   * @since 0.1
   */
  ItemType PURPLE_WOOL = block(Key.key("purple_wool"));

  /**
   * The minecraft:purpur_block item type.
   *
   * @since 0.1
   */
  ItemType PURPUR_BLOCK = block(Key.key("purpur_block"));

  /**
   * The minecraft:purpur_pillar item type.
   *
   * @since 0.1
   */
  ItemType PURPUR_PILLAR = block(Key.key("purpur_pillar"));

  /**
   * The minecraft:purpur_slab item type.
   *
   * @since 0.1
   */
  ItemType PURPUR_SLAB = block(Key.key("purpur_slab"));

  /**
   * The minecraft:purpur_stairs item type.
   *
   * @since 0.1
   */
  ItemType PURPUR_STAIRS = block(Key.key("purpur_stairs"));

  /**
   * The minecraft:quartz item type.
   *
   * @since 0.1
   */
  ItemType QUARTZ = item(Key.key("quartz"));

  /**
   * The minecraft:quartz_block item type.
   *
   * @since 0.1
   */
  ItemType QUARTZ_BLOCK = block(Key.key("quartz_block"));

  /**
   * The minecraft:quartz_bricks item type.
   *
   * @since 0.1
   */
  ItemType QUARTZ_BRICKS = block(Key.key("quartz_bricks"));

  /**
   * The minecraft:quartz_pillar item type.
   *
   * @since 0.1
   */
  ItemType QUARTZ_PILLAR = block(Key.key("quartz_pillar"));

  /**
   * The minecraft:quartz_slab item type.
   *
   * @since 0.1
   */
  ItemType QUARTZ_SLAB = block(Key.key("quartz_slab"));

  /**
   * The minecraft:quartz_stairs item type.
   *
   * @since 0.1
   */
  ItemType QUARTZ_STAIRS = block(Key.key("quartz_stairs"));

  /**
   * The minecraft:rabbit item type.
   *
   * @since 0.1
   */
  ItemType RABBIT = item(Key.key("rabbit"));

  /**
   * The minecraft:rabbit_foot item type.
   *
   * @since 0.1
   */
  ItemType RABBIT_FOOT = item(Key.key("rabbit_foot"));

  /**
   * The minecraft:rabbit_hide item type.
   *
   * @since 0.1
   */
  ItemType RABBIT_HIDE = item(Key.key("rabbit_hide"));

  /**
   * The minecraft:rabbit_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType RABBIT_SPAWN_EGG = item(Key.key("rabbit_spawn_egg"));

  /**
   * The minecraft:rabbit_stew item type.
   *
   * @since 0.1
   */
  ItemType RABBIT_STEW = item(Key.key("rabbit_stew"));

  /**
   * The minecraft:rail item type.
   *
   * @since 0.1
   */
  ItemType RAIL = block(Key.key("rail"));

  /**
   * The minecraft:raiser_armor_trim_smithing_template item type.
   *
   * @since 0.2
   */
  ItemType RAISER_ARMOR_TRIM_SMITHING_TEMPLATE =
      item(Key.key("raiser_armor_trim_smithing_template"));

  /**
   * The minecraft:ravager_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType RAVAGER_SPAWN_EGG = item(Key.key("ravager_spawn_egg"));

  /**
   * The minecraft:raw_copper item type.
   *
   * @since 0.1
   */
  ItemType RAW_COPPER = item(Key.key("raw_copper"));

  /**
   * The minecraft:raw_copper_block item type.
   *
   * @since 0.1
   */
  ItemType RAW_COPPER_BLOCK = block(Key.key("raw_copper_block"));

  /**
   * The minecraft:raw_gold item type.
   *
   * @since 0.1
   */
  ItemType RAW_GOLD = item(Key.key("raw_gold"));

  /**
   * The minecraft:raw_gold_block item type.
   *
   * @since 0.1
   */
  ItemType RAW_GOLD_BLOCK = block(Key.key("raw_gold_block"));

  /**
   * The minecraft:raw_iron item type.
   *
   * @since 0.1
   */
  ItemType RAW_IRON = item(Key.key("raw_iron"));

  /**
   * The minecraft:raw_iron_block item type.
   *
   * @since 0.1
   */
  ItemType RAW_IRON_BLOCK = block(Key.key("raw_iron_block"));

  /**
   * The minecraft:recovery_compass item type.
   *
   * @since 0.1
   */
  ItemType RECOVERY_COMPASS = item(Key.key("recovery_compass"));

  /**
   * The minecraft:red_banner item type.
   *
   * @since 0.1
   */
  ItemType RED_BANNER = block(Key.key("red_banner"));

  /**
   * The minecraft:red_bed item type.
   *
   * @since 0.1
   */
  ItemType RED_BED = block(Key.key("red_bed"));

  /**
   * The minecraft:red_candle item type.
   *
   * @since 0.1
   */
  ItemType RED_CANDLE = block(Key.key("red_candle"));

  /**
   * The minecraft:red_carpet item type.
   *
   * @since 0.1
   */
  ItemType RED_CARPET = block(Key.key("red_carpet"));

  /**
   * The minecraft:red_concrete item type.
   *
   * @since 0.1
   */
  ItemType RED_CONCRETE = block(Key.key("red_concrete"));

  /**
   * The minecraft:red_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType RED_CONCRETE_POWDER = block(Key.key("red_concrete_powder"));

  /**
   * The minecraft:red_dye item type.
   *
   * @since 0.1
   */
  ItemType RED_DYE = item(Key.key("red_dye"));

  /**
   * The minecraft:red_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType RED_GLAZED_TERRACOTTA = block(Key.key("red_glazed_terracotta"));

  /**
   * The minecraft:red_mushroom item type.
   *
   * @since 0.1
   */
  ItemType RED_MUSHROOM = block(Key.key("red_mushroom"));

  /**
   * The minecraft:red_mushroom_block item type.
   *
   * @since 0.1
   */
  ItemType RED_MUSHROOM_BLOCK = block(Key.key("red_mushroom_block"));

  /**
   * The minecraft:red_nether_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType RED_NETHER_BRICK_SLAB = block(Key.key("red_nether_brick_slab"));

  /**
   * The minecraft:red_nether_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType RED_NETHER_BRICK_STAIRS = block(Key.key("red_nether_brick_stairs"));

  /**
   * The minecraft:red_nether_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType RED_NETHER_BRICK_WALL = block(Key.key("red_nether_brick_wall"));

  /**
   * The minecraft:red_nether_bricks item type.
   *
   * @since 0.1
   */
  ItemType RED_NETHER_BRICKS = block(Key.key("red_nether_bricks"));

  /**
   * The minecraft:red_sand item type.
   *
   * @since 0.1
   */
  ItemType RED_SAND = block(Key.key("red_sand"));

  /**
   * The minecraft:red_sandstone item type.
   *
   * @since 0.1
   */
  ItemType RED_SANDSTONE = block(Key.key("red_sandstone"));

  /**
   * The minecraft:red_sandstone_slab item type.
   *
   * @since 0.1
   */
  ItemType RED_SANDSTONE_SLAB = block(Key.key("red_sandstone_slab"));

  /**
   * The minecraft:red_sandstone_stairs item type.
   *
   * @since 0.1
   */
  ItemType RED_SANDSTONE_STAIRS = block(Key.key("red_sandstone_stairs"));

  /**
   * The minecraft:red_sandstone_wall item type.
   *
   * @since 0.1
   */
  ItemType RED_SANDSTONE_WALL = block(Key.key("red_sandstone_wall"));

  /**
   * The minecraft:red_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType RED_SHULKER_BOX = block(Key.key("red_shulker_box"));

  /**
   * The minecraft:red_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType RED_STAINED_GLASS = block(Key.key("red_stained_glass"));

  /**
   * The minecraft:red_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType RED_STAINED_GLASS_PANE = block(Key.key("red_stained_glass_pane"));

  /**
   * The minecraft:red_terracotta item type.
   *
   * @since 0.1
   */
  ItemType RED_TERRACOTTA = block(Key.key("red_terracotta"));

  /**
   * The minecraft:red_tulip item type.
   *
   * @since 0.1
   */
  ItemType RED_TULIP = block(Key.key("red_tulip"));

  /**
   * The minecraft:red_wool item type.
   *
   * @since 0.1
   */
  ItemType RED_WOOL = block(Key.key("red_wool"));

  /**
   * The minecraft:redstone item type.
   *
   * @since 0.1
   */
  ItemType REDSTONE = item(Key.key("redstone"));

  /**
   * The minecraft:redstone_block item type.
   *
   * @since 0.1
   */
  ItemType REDSTONE_BLOCK = block(Key.key("redstone_block"));

  /**
   * The minecraft:redstone_lamp item type.
   *
   * @since 0.1
   */
  ItemType REDSTONE_LAMP = block(Key.key("redstone_lamp"));

  /**
   * The minecraft:redstone_ore item type.
   *
   * @since 0.1
   */
  ItemType REDSTONE_ORE = block(Key.key("redstone_ore"));

  /**
   * The minecraft:redstone_torch item type.
   *
   * @since 0.1
   */
  ItemType REDSTONE_TORCH = block(Key.key("redstone_torch"));

  /**
   * The minecraft:reinforced_deepslate item type.
   *
   * @since 0.1
   */
  ItemType REINFORCED_DEEPSLATE = block(Key.key("reinforced_deepslate"));

  /**
   * The minecraft:repeater item type.
   *
   * @since 0.1
   */
  ItemType REPEATER = block(Key.key("repeater"));

  /**
   * The minecraft:repeating_command_block item type.
   *
   * @since 0.1
   */
  ItemType REPEATING_COMMAND_BLOCK = block(Key.key("repeating_command_block"));

  /**
   * The minecraft:respawn_anchor item type.
   *
   * @since 0.1
   */
  ItemType RESPAWN_ANCHOR = block(Key.key("respawn_anchor"));

  /**
   * The minecraft:rib_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType RIB_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("rib_armor_trim_smithing_template"));

  /**
   * The minecraft:rooted_dirt item type.
   *
   * @since 0.1
   */
  ItemType ROOTED_DIRT = block(Key.key("rooted_dirt"));

  /**
   * The minecraft:rose_bush item type.
   *
   * @since 0.1
   */
  ItemType ROSE_BUSH = block(Key.key("rose_bush"));

  /**
   * The minecraft:rotten_flesh item type.
   *
   * @since 0.1
   */
  ItemType ROTTEN_FLESH = item(Key.key("rotten_flesh"));

  /**
   * The minecraft:saddle item type.
   *
   * @since 0.1
   */
  ItemType SADDLE = item(Key.key("saddle"));

  /**
   * The minecraft:salmon item type.
   *
   * @since 0.1
   */
  ItemType SALMON = item(Key.key("salmon"));

  /**
   * The minecraft:salmon_bucket item type.
   *
   * @since 0.1
   */
  ItemType SALMON_BUCKET = item(Key.key("salmon_bucket"));

  /**
   * The minecraft:salmon_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SALMON_SPAWN_EGG = item(Key.key("salmon_spawn_egg"));

  /**
   * The minecraft:sand item type.
   *
   * @since 0.1
   */
  ItemType SAND = block(Key.key("sand"));

  /**
   * The minecraft:sandstone item type.
   *
   * @since 0.1
   */
  ItemType SANDSTONE = block(Key.key("sandstone"));

  /**
   * The minecraft:sandstone_slab item type.
   *
   * @since 0.1
   */
  ItemType SANDSTONE_SLAB = block(Key.key("sandstone_slab"));

  /**
   * The minecraft:sandstone_stairs item type.
   *
   * @since 0.1
   */
  ItemType SANDSTONE_STAIRS = block(Key.key("sandstone_stairs"));

  /**
   * The minecraft:sandstone_wall item type.
   *
   * @since 0.1
   */
  ItemType SANDSTONE_WALL = block(Key.key("sandstone_wall"));

  /**
   * The minecraft:scaffolding item type.
   *
   * @since 0.1
   */
  ItemType SCAFFOLDING = block(Key.key("scaffolding"));

  /**
   * The minecraft:sculk item type.
   *
   * @since 0.1
   */
  ItemType SCULK = block(Key.key("sculk"));

  /**
   * The minecraft:sculk_catalyst item type.
   *
   * @since 0.1
   */
  ItemType SCULK_CATALYST = block(Key.key("sculk_catalyst"));

  /**
   * The minecraft:sculk_sensor item type.
   *
   * @since 0.1
   */
  ItemType SCULK_SENSOR = block(Key.key("sculk_sensor"));

  /**
   * The minecraft:sculk_shrieker item type.
   *
   * @since 0.1
   */
  ItemType SCULK_SHRIEKER = block(Key.key("sculk_shrieker"));

  /**
   * The minecraft:sculk_vein item type.
   *
   * @since 0.1
   */
  ItemType SCULK_VEIN = block(Key.key("sculk_vein"));

  /**
   * The minecraft:scute item type.
   *
   * @since 0.1
   */
  ItemType SCUTE = item(Key.key("scute"));

  /**
   * The minecraft:sea_lantern item type.
   *
   * @since 0.1
   */
  ItemType SEA_LANTERN = block(Key.key("sea_lantern"));

  /**
   * The minecraft:sea_pickle item type.
   *
   * @since 0.1
   */
  ItemType SEA_PICKLE = block(Key.key("sea_pickle"));

  /**
   * The minecraft:seagrass item type.
   *
   * @since 0.1
   */
  ItemType SEAGRASS = block(Key.key("seagrass"));

  /**
   * The minecraft:sentry_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE =
      item(Key.key("sentry_armor_trim_smithing_template"));

  /**
   * The minecraft:shaper_armor_trim_smithing_template item type.
   *
   * @since 0.2
   */
  ItemType SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE =
      item(Key.key("shaper_armor_trim_smithing_template"));

  /**
   * The minecraft:sheaf_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType SHEAF_POTTERY_SHERD = item(Key.key("sheaf_pottery_sherd"));

  /**
   * The minecraft:shears item type.
   *
   * @since 0.1
   */
  ItemType SHEARS = item(Key.key("shears"));

  /**
   * The minecraft:sheep_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SHEEP_SPAWN_EGG = item(Key.key("sheep_spawn_egg"));

  /**
   * The minecraft:shelter_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType SHELTER_POTTERY_SHERD = item(Key.key("shelter_pottery_sherd"));

  /**
   * The minecraft:shield item type.
   *
   * @since 0.1
   */
  ItemType SHIELD = item(Key.key("shield"));

  /**
   * The minecraft:shroomlight item type.
   *
   * @since 0.1
   */
  ItemType SHROOMLIGHT = block(Key.key("shroomlight"));

  /**
   * The minecraft:shulker_box item type.
   *
   * @since 0.1
   */
  ItemType SHULKER_BOX = block(Key.key("shulker_box"));

  /**
   * The minecraft:shulker_shell item type.
   *
   * @since 0.1
   */
  ItemType SHULKER_SHELL = item(Key.key("shulker_shell"));

  /**
   * The minecraft:shulker_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SHULKER_SPAWN_EGG = item(Key.key("shulker_spawn_egg"));

  /**
   * The minecraft:silence_armor_trim_smithing_template item type.
   *
   * @since 0.2
   */
  ItemType SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE =
      item(Key.key("silence_armor_trim_smithing_template"));

  /**
   * The minecraft:silverfish_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SILVERFISH_SPAWN_EGG = item(Key.key("silverfish_spawn_egg"));

  /**
   * The minecraft:skeleton_horse_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SKELETON_HORSE_SPAWN_EGG = item(Key.key("skeleton_horse_spawn_egg"));

  /**
   * The minecraft:skeleton_skull item type.
   *
   * @since 0.1
   */
  ItemType SKELETON_SKULL = block(Key.key("skeleton_skull"));

  /**
   * The minecraft:skeleton_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SKELETON_SPAWN_EGG = item(Key.key("skeleton_spawn_egg"));

  /**
   * The minecraft:skull_banner_pattern item type.
   *
   * @since 0.1
   */
  ItemType SKULL_BANNER_PATTERN = item(Key.key("skull_banner_pattern"));

  /**
   * The minecraft:skull_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType SKULL_POTTERY_SHERD = item(Key.key("skull_pottery_sherd"));

  /**
   * The minecraft:slime_ball item type.
   *
   * @since 0.1
   */
  ItemType SLIME_BALL = item(Key.key("slime_ball"));

  /**
   * The minecraft:slime_block item type.
   *
   * @since 0.1
   */
  ItemType SLIME_BLOCK = block(Key.key("slime_block"));

  /**
   * The minecraft:slime_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SLIME_SPAWN_EGG = item(Key.key("slime_spawn_egg"));

  /**
   * The minecraft:small_amethyst_bud item type.
   *
   * @since 0.1
   */
  ItemType SMALL_AMETHYST_BUD = block(Key.key("small_amethyst_bud"));

  /**
   * The minecraft:small_dripleaf item type.
   *
   * @since 0.1
   */
  ItemType SMALL_DRIPLEAF = block(Key.key("small_dripleaf"));

  /**
   * The minecraft:smithing_table item type.
   *
   * @since 0.1
   */
  ItemType SMITHING_TABLE = block(Key.key("smithing_table"));

  /**
   * The minecraft:smoker item type.
   *
   * @since 0.1
   */
  ItemType SMOKER = block(Key.key("smoker"));

  /**
   * The minecraft:smooth_basalt item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_BASALT = block(Key.key("smooth_basalt"));

  /**
   * The minecraft:smooth_quartz item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_QUARTZ = block(Key.key("smooth_quartz"));

  /**
   * The minecraft:smooth_quartz_slab item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_QUARTZ_SLAB = block(Key.key("smooth_quartz_slab"));

  /**
   * The minecraft:smooth_quartz_stairs item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_QUARTZ_STAIRS = block(Key.key("smooth_quartz_stairs"));

  /**
   * The minecraft:smooth_red_sandstone item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_RED_SANDSTONE = block(Key.key("smooth_red_sandstone"));

  /**
   * The minecraft:smooth_red_sandstone_slab item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_RED_SANDSTONE_SLAB = block(Key.key("smooth_red_sandstone_slab"));

  /**
   * The minecraft:smooth_red_sandstone_stairs item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_RED_SANDSTONE_STAIRS = block(Key.key("smooth_red_sandstone_stairs"));

  /**
   * The minecraft:smooth_sandstone item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_SANDSTONE = block(Key.key("smooth_sandstone"));

  /**
   * The minecraft:smooth_sandstone_slab item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_SANDSTONE_SLAB = block(Key.key("smooth_sandstone_slab"));

  /**
   * The minecraft:smooth_sandstone_stairs item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_SANDSTONE_STAIRS = block(Key.key("smooth_sandstone_stairs"));

  /**
   * The minecraft:smooth_stone item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_STONE = block(Key.key("smooth_stone"));

  /**
   * The minecraft:smooth_stone_slab item type.
   *
   * @since 0.1
   */
  ItemType SMOOTH_STONE_SLAB = block(Key.key("smooth_stone_slab"));

  /**
   * The minecraft:sniffer_egg item type.
   *
   * @since 0.2
   */
  ItemType SNIFFER_EGG = block(Key.key("sniffer_egg"));

  /**
   * The minecraft:sniffer_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SNIFFER_SPAWN_EGG = item(Key.key("sniffer_spawn_egg"));

  /**
   * The minecraft:snort_pottery_sherd item type.
   *
   * @since 0.2
   */
  ItemType SNORT_POTTERY_SHERD = item(Key.key("snort_pottery_sherd"));

  /**
   * The minecraft:snout_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("snout_armor_trim_smithing_template"));

  /**
   * The minecraft:snow item type.
   *
   * @since 0.1
   */
  ItemType SNOW = block(Key.key("snow"));

  /**
   * The minecraft:snow_block item type.
   *
   * @since 0.1
   */
  ItemType SNOW_BLOCK = block(Key.key("snow_block"));

  /**
   * The minecraft:snow_golem_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SNOW_GOLEM_SPAWN_EGG = item(Key.key("snow_golem_spawn_egg"));

  /**
   * The minecraft:snowball item type.
   *
   * @since 0.1
   */
  ItemType SNOWBALL = item(Key.key("snowball"));

  /**
   * The minecraft:soul_campfire item type.
   *
   * @since 0.1
   */
  ItemType SOUL_CAMPFIRE = block(Key.key("soul_campfire"));

  /**
   * The minecraft:soul_lantern item type.
   *
   * @since 0.1
   */
  ItemType SOUL_LANTERN = block(Key.key("soul_lantern"));

  /**
   * The minecraft:soul_sand item type.
   *
   * @since 0.1
   */
  ItemType SOUL_SAND = block(Key.key("soul_sand"));

  /**
   * The minecraft:soul_soil item type.
   *
   * @since 0.1
   */
  ItemType SOUL_SOIL = block(Key.key("soul_soil"));

  /**
   * The minecraft:soul_torch item type.
   *
   * @since 0.1
   */
  ItemType SOUL_TORCH = block(Key.key("soul_torch"));

  /**
   * The minecraft:spawner item type.
   *
   * @since 0.1
   */
  ItemType SPAWNER = block(Key.key("spawner"));

  /**
   * The minecraft:spectral_arrow item type.
   *
   * @since 0.1
   */
  ItemType SPECTRAL_ARROW = item(Key.key("spectral_arrow"));

  /**
   * The minecraft:spider_eye item type.
   *
   * @since 0.1
   */
  ItemType SPIDER_EYE = item(Key.key("spider_eye"));

  /**
   * The minecraft:spider_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SPIDER_SPAWN_EGG = item(Key.key("spider_spawn_egg"));

  /**
   * The minecraft:spire_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("spire_armor_trim_smithing_template"));

  /**
   * The minecraft:splash_potion item type.
   *
   * @since 0.1
   */
  ItemType SPLASH_POTION = item(Key.key("splash_potion"));

  /**
   * The minecraft:sponge item type.
   *
   * @since 0.1
   */
  ItemType SPONGE = block(Key.key("sponge"));

  /**
   * The minecraft:spore_blossom item type.
   *
   * @since 0.1
   */
  ItemType SPORE_BLOSSOM = block(Key.key("spore_blossom"));

  /**
   * The minecraft:spruce_boat item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_BOAT = item(Key.key("spruce_boat"));

  /**
   * The minecraft:spruce_button item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_BUTTON = block(Key.key("spruce_button"));

  /**
   * The minecraft:spruce_chest_boat item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_CHEST_BOAT = item(Key.key("spruce_chest_boat"));

  /**
   * The minecraft:spruce_door item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_DOOR = block(Key.key("spruce_door"));

  /**
   * The minecraft:spruce_fence item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_FENCE = block(Key.key("spruce_fence"));

  /**
   * The minecraft:spruce_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_FENCE_GATE = block(Key.key("spruce_fence_gate"));

  /**
   * The minecraft:spruce_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_HANGING_SIGN = block(Key.key("spruce_hanging_sign"));

  /**
   * The minecraft:spruce_leaves item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_LEAVES = block(Key.key("spruce_leaves"));

  /**
   * The minecraft:spruce_log item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_LOG = block(Key.key("spruce_log"));

  /**
   * The minecraft:spruce_planks item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_PLANKS = block(Key.key("spruce_planks"));

  /**
   * The minecraft:spruce_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_PRESSURE_PLATE = block(Key.key("spruce_pressure_plate"));

  /**
   * The minecraft:spruce_sapling item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_SAPLING = block(Key.key("spruce_sapling"));

  /**
   * The minecraft:spruce_sign item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_SIGN = block(Key.key("spruce_sign"));

  /**
   * The minecraft:spruce_slab item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_SLAB = block(Key.key("spruce_slab"));

  /**
   * The minecraft:spruce_stairs item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_STAIRS = block(Key.key("spruce_stairs"));

  /**
   * The minecraft:spruce_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_TRAPDOOR = block(Key.key("spruce_trapdoor"));

  /**
   * The minecraft:spruce_wood item type.
   *
   * @since 0.1
   */
  ItemType SPRUCE_WOOD = block(Key.key("spruce_wood"));

  /**
   * The minecraft:spyglass item type.
   *
   * @since 0.1
   */
  ItemType SPYGLASS = item(Key.key("spyglass"));

  /**
   * The minecraft:squid_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType SQUID_SPAWN_EGG = item(Key.key("squid_spawn_egg"));

  /**
   * The minecraft:stick item type.
   *
   * @since 0.1
   */
  ItemType STICK = item(Key.key("stick"));

  /**
   * The minecraft:sticky_piston item type.
   *
   * @since 0.1
   */
  ItemType STICKY_PISTON = block(Key.key("sticky_piston"));

  /**
   * The minecraft:stone item type.
   *
   * @since 0.1
   */
  ItemType STONE = block(Key.key("stone"));

  /**
   * The minecraft:stone_axe item type.
   *
   * @since 0.1
   */
  ItemType STONE_AXE = item(Key.key("stone_axe"));

  /**
   * The minecraft:stone_brick_slab item type.
   *
   * @since 0.1
   */
  ItemType STONE_BRICK_SLAB = block(Key.key("stone_brick_slab"));

  /**
   * The minecraft:stone_brick_stairs item type.
   *
   * @since 0.1
   */
  ItemType STONE_BRICK_STAIRS = block(Key.key("stone_brick_stairs"));

  /**
   * The minecraft:stone_brick_wall item type.
   *
   * @since 0.1
   */
  ItemType STONE_BRICK_WALL = block(Key.key("stone_brick_wall"));

  /**
   * The minecraft:stone_bricks item type.
   *
   * @since 0.1
   */
  ItemType STONE_BRICKS = block(Key.key("stone_bricks"));

  /**
   * The minecraft:stone_button item type.
   *
   * @since 0.1
   */
  ItemType STONE_BUTTON = block(Key.key("stone_button"));

  /**
   * The minecraft:stone_hoe item type.
   *
   * @since 0.1
   */
  ItemType STONE_HOE = item(Key.key("stone_hoe"));

  /**
   * The minecraft:stone_pickaxe item type.
   *
   * @since 0.1
   */
  ItemType STONE_PICKAXE = item(Key.key("stone_pickaxe"));

  /**
   * The minecraft:stone_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType STONE_PRESSURE_PLATE = block(Key.key("stone_pressure_plate"));

  /**
   * The minecraft:stone_shovel item type.
   *
   * @since 0.1
   */
  ItemType STONE_SHOVEL = item(Key.key("stone_shovel"));

  /**
   * The minecraft:stone_slab item type.
   *
   * @since 0.1
   */
  ItemType STONE_SLAB = block(Key.key("stone_slab"));

  /**
   * The minecraft:stone_stairs item type.
   *
   * @since 0.1
   */
  ItemType STONE_STAIRS = block(Key.key("stone_stairs"));

  /**
   * The minecraft:stone_sword item type.
   *
   * @since 0.1
   */
  ItemType STONE_SWORD = item(Key.key("stone_sword"));

  /**
   * The minecraft:stonecutter item type.
   *
   * @since 0.1
   */
  ItemType STONECUTTER = block(Key.key("stonecutter"));

  /**
   * The minecraft:stray_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType STRAY_SPAWN_EGG = item(Key.key("stray_spawn_egg"));

  /**
   * The minecraft:strider_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType STRIDER_SPAWN_EGG = item(Key.key("strider_spawn_egg"));

  /**
   * The minecraft:string item type.
   *
   * @since 0.1
   */
  ItemType STRING = item(Key.key("string"));

  /**
   * The minecraft:stripped_acacia_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_ACACIA_LOG = block(Key.key("stripped_acacia_log"));

  /**
   * The minecraft:stripped_acacia_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_ACACIA_WOOD = block(Key.key("stripped_acacia_wood"));

  /**
   * The minecraft:stripped_bamboo_block item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_BAMBOO_BLOCK = block(Key.key("stripped_bamboo_block"));

  /**
   * The minecraft:stripped_birch_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_BIRCH_LOG = block(Key.key("stripped_birch_log"));

  /**
   * The minecraft:stripped_birch_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_BIRCH_WOOD = block(Key.key("stripped_birch_wood"));

  /**
   * The minecraft:stripped_cherry_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_CHERRY_LOG = block(Key.key("stripped_cherry_log"));

  /**
   * The minecraft:stripped_cherry_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_CHERRY_WOOD = block(Key.key("stripped_cherry_wood"));

  /**
   * The minecraft:stripped_crimson_hyphae item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_CRIMSON_HYPHAE = block(Key.key("stripped_crimson_hyphae"));

  /**
   * The minecraft:stripped_crimson_stem item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_CRIMSON_STEM = block(Key.key("stripped_crimson_stem"));

  /**
   * The minecraft:stripped_dark_oak_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_DARK_OAK_LOG = block(Key.key("stripped_dark_oak_log"));

  /**
   * The minecraft:stripped_dark_oak_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_DARK_OAK_WOOD = block(Key.key("stripped_dark_oak_wood"));

  /**
   * The minecraft:stripped_jungle_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_JUNGLE_LOG = block(Key.key("stripped_jungle_log"));

  /**
   * The minecraft:stripped_jungle_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_JUNGLE_WOOD = block(Key.key("stripped_jungle_wood"));

  /**
   * The minecraft:stripped_mangrove_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_MANGROVE_LOG = block(Key.key("stripped_mangrove_log"));

  /**
   * The minecraft:stripped_mangrove_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_MANGROVE_WOOD = block(Key.key("stripped_mangrove_wood"));

  /**
   * The minecraft:stripped_oak_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_OAK_LOG = block(Key.key("stripped_oak_log"));

  /**
   * The minecraft:stripped_oak_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_OAK_WOOD = block(Key.key("stripped_oak_wood"));

  /**
   * The minecraft:stripped_spruce_log item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_SPRUCE_LOG = block(Key.key("stripped_spruce_log"));

  /**
   * The minecraft:stripped_spruce_wood item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_SPRUCE_WOOD = block(Key.key("stripped_spruce_wood"));

  /**
   * The minecraft:stripped_warped_hyphae item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_WARPED_HYPHAE = block(Key.key("stripped_warped_hyphae"));

  /**
   * The minecraft:stripped_warped_stem item type.
   *
   * @since 0.1
   */
  ItemType STRIPPED_WARPED_STEM = block(Key.key("stripped_warped_stem"));

  /**
   * The minecraft:structure_block item type.
   *
   * @since 0.1
   */
  ItemType STRUCTURE_BLOCK = block(Key.key("structure_block"));

  /**
   * The minecraft:structure_void item type.
   *
   * @since 0.1
   */
  ItemType STRUCTURE_VOID = block(Key.key("structure_void"));

  /**
   * The minecraft:sugar item type.
   *
   * @since 0.1
   */
  ItemType SUGAR = item(Key.key("sugar"));

  /**
   * The minecraft:sugar_cane item type.
   *
   * @since 0.1
   */
  ItemType SUGAR_CANE = block(Key.key("sugar_cane"));

  /**
   * The minecraft:sunflower item type.
   *
   * @since 0.1
   */
  ItemType SUNFLOWER = block(Key.key("sunflower"));

  /**
   * The minecraft:suspicious_gravel item type.
   *
   * @since 0.2
   */
  ItemType SUSPICIOUS_GRAVEL = block(Key.key("suspicious_gravel"));

  /**
   * The minecraft:suspicious_sand item type.
   *
   * @since 0.1
   */
  ItemType SUSPICIOUS_SAND = block(Key.key("suspicious_sand"));

  /**
   * The minecraft:suspicious_stew item type.
   *
   * @since 0.1
   */
  ItemType SUSPICIOUS_STEW = item(Key.key("suspicious_stew"));

  /**
   * The minecraft:sweet_berries item type.
   *
   * @since 0.1
   */
  ItemType SWEET_BERRIES = item(Key.key("sweet_berries"));

  /**
   * The minecraft:tadpole_bucket item type.
   *
   * @since 0.1
   */
  ItemType TADPOLE_BUCKET = item(Key.key("tadpole_bucket"));

  /**
   * The minecraft:tadpole_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType TADPOLE_SPAWN_EGG = item(Key.key("tadpole_spawn_egg"));

  /**
   * The minecraft:tall_grass item type.
   *
   * @since 0.1
   */
  ItemType TALL_GRASS = block(Key.key("tall_grass"));

  /**
   * The minecraft:target item type.
   *
   * @since 0.1
   */
  ItemType TARGET = block(Key.key("target"));

  /**
   * The minecraft:terracotta item type.
   *
   * @since 0.1
   */
  ItemType TERRACOTTA = block(Key.key("terracotta"));

  /**
   * The minecraft:tide_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType TIDE_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("tide_armor_trim_smithing_template"));

  /**
   * The minecraft:tinted_glass item type.
   *
   * @since 0.1
   */
  ItemType TINTED_GLASS = block(Key.key("tinted_glass"));

  /**
   * The minecraft:tipped_arrow item type.
   *
   * @since 0.1
   */
  ItemType TIPPED_ARROW = item(Key.key("tipped_arrow"));

  /**
   * The minecraft:tnt item type.
   *
   * @since 0.1
   */
  ItemType TNT = block(Key.key("tnt"));

  /**
   * The minecraft:tnt_minecart item type.
   *
   * @since 0.1
   */
  ItemType TNT_MINECART = item(Key.key("tnt_minecart"));

  /**
   * The minecraft:torch item type.
   *
   * @since 0.1
   */
  ItemType TORCH = block(Key.key("torch"));

  /**
   * The minecraft:torchflower item type.
   *
   * @since 0.1
   */
  ItemType TORCHFLOWER = block(Key.key("torchflower"));

  /**
   * The minecraft:torchflower_seeds item type.
   *
   * @since 0.1
   */
  ItemType TORCHFLOWER_SEEDS = item(Key.key("torchflower_seeds"));

  /**
   * The minecraft:totem_of_undying item type.
   *
   * @since 0.1
   */
  ItemType TOTEM_OF_UNDYING = item(Key.key("totem_of_undying"));

  /**
   * The minecraft:trader_llama_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType TRADER_LLAMA_SPAWN_EGG = item(Key.key("trader_llama_spawn_egg"));

  /**
   * The minecraft:trapped_chest item type.
   *
   * @since 0.1
   */
  ItemType TRAPPED_CHEST = block(Key.key("trapped_chest"));

  /**
   * The minecraft:trident item type.
   *
   * @since 0.1
   */
  ItemType TRIDENT = item(Key.key("trident"));

  /**
   * The minecraft:tripwire_hook item type.
   *
   * @since 0.1
   */
  ItemType TRIPWIRE_HOOK = block(Key.key("tripwire_hook"));

  /**
   * The minecraft:tropical_fish item type.
   *
   * @since 0.1
   */
  ItemType TROPICAL_FISH = item(Key.key("tropical_fish"));

  /**
   * The minecraft:tropical_fish_bucket item type.
   *
   * @since 0.1
   */
  ItemType TROPICAL_FISH_BUCKET = item(Key.key("tropical_fish_bucket"));

  /**
   * The minecraft:tropical_fish_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType TROPICAL_FISH_SPAWN_EGG = item(Key.key("tropical_fish_spawn_egg"));

  /**
   * The minecraft:tube_coral item type.
   *
   * @since 0.1
   */
  ItemType TUBE_CORAL = block(Key.key("tube_coral"));

  /**
   * The minecraft:tube_coral_block item type.
   *
   * @since 0.1
   */
  ItemType TUBE_CORAL_BLOCK = block(Key.key("tube_coral_block"));

  /**
   * The minecraft:tube_coral_fan item type.
   *
   * @since 0.1
   */
  ItemType TUBE_CORAL_FAN = block(Key.key("tube_coral_fan"));

  /**
   * The minecraft:tuff item type.
   *
   * @since 0.1
   */
  ItemType TUFF = block(Key.key("tuff"));

  /**
   * The minecraft:turtle_egg item type.
   *
   * @since 0.1
   */
  ItemType TURTLE_EGG = block(Key.key("turtle_egg"));

  /**
   * The minecraft:turtle_helmet item type.
   *
   * @since 0.1
   */
  ItemType TURTLE_HELMET = item(Key.key("turtle_helmet"));

  /**
   * The minecraft:turtle_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType TURTLE_SPAWN_EGG = item(Key.key("turtle_spawn_egg"));

  /**
   * The minecraft:twisting_vines item type.
   *
   * @since 0.1
   */
  ItemType TWISTING_VINES = block(Key.key("twisting_vines"));

  /**
   * The minecraft:verdant_froglight item type.
   *
   * @since 0.1
   */
  ItemType VERDANT_FROGLIGHT = block(Key.key("verdant_froglight"));

  /**
   * The minecraft:vex_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType VEX_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("vex_armor_trim_smithing_template"));

  /**
   * The minecraft:vex_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType VEX_SPAWN_EGG = item(Key.key("vex_spawn_egg"));

  /**
   * The minecraft:villager_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType VILLAGER_SPAWN_EGG = item(Key.key("villager_spawn_egg"));

  /**
   * The minecraft:vindicator_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType VINDICATOR_SPAWN_EGG = item(Key.key("vindicator_spawn_egg"));

  /**
   * The minecraft:vine item type.
   *
   * @since 0.1
   */
  ItemType VINE = block(Key.key("vine"));

  /**
   * The minecraft:wandering_trader_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType WANDERING_TRADER_SPAWN_EGG = item(Key.key("wandering_trader_spawn_egg"));

  /**
   * The minecraft:ward_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType WARD_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("ward_armor_trim_smithing_template"));

  /**
   * The minecraft:warden_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType WARDEN_SPAWN_EGG = item(Key.key("warden_spawn_egg"));

  /**
   * The minecraft:warped_button item type.
   *
   * @since 0.1
   */
  ItemType WARPED_BUTTON = block(Key.key("warped_button"));

  /**
   * The minecraft:warped_door item type.
   *
   * @since 0.1
   */
  ItemType WARPED_DOOR = block(Key.key("warped_door"));

  /**
   * The minecraft:warped_fence item type.
   *
   * @since 0.1
   */
  ItemType WARPED_FENCE = block(Key.key("warped_fence"));

  /**
   * The minecraft:warped_fence_gate item type.
   *
   * @since 0.1
   */
  ItemType WARPED_FENCE_GATE = block(Key.key("warped_fence_gate"));

  /**
   * The minecraft:warped_fungus item type.
   *
   * @since 0.1
   */
  ItemType WARPED_FUNGUS = block(Key.key("warped_fungus"));

  /**
   * The minecraft:warped_fungus_on_a_stick item type.
   *
   * @since 0.1
   */
  ItemType WARPED_FUNGUS_ON_A_STICK = item(Key.key("warped_fungus_on_a_stick"));

  /**
   * The minecraft:warped_hanging_sign item type.
   *
   * @since 0.1
   */
  ItemType WARPED_HANGING_SIGN = block(Key.key("warped_hanging_sign"));

  /**
   * The minecraft:warped_hyphae item type.
   *
   * @since 0.1
   */
  ItemType WARPED_HYPHAE = block(Key.key("warped_hyphae"));

  /**
   * The minecraft:warped_nylium item type.
   *
   * @since 0.1
   */
  ItemType WARPED_NYLIUM = block(Key.key("warped_nylium"));

  /**
   * The minecraft:warped_planks item type.
   *
   * @since 0.1
   */
  ItemType WARPED_PLANKS = block(Key.key("warped_planks"));

  /**
   * The minecraft:warped_pressure_plate item type.
   *
   * @since 0.1
   */
  ItemType WARPED_PRESSURE_PLATE = block(Key.key("warped_pressure_plate"));

  /**
   * The minecraft:warped_roots item type.
   *
   * @since 0.1
   */
  ItemType WARPED_ROOTS = block(Key.key("warped_roots"));

  /**
   * The minecraft:warped_sign item type.
   *
   * @since 0.1
   */
  ItemType WARPED_SIGN = block(Key.key("warped_sign"));

  /**
   * The minecraft:warped_slab item type.
   *
   * @since 0.1
   */
  ItemType WARPED_SLAB = block(Key.key("warped_slab"));

  /**
   * The minecraft:warped_stairs item type.
   *
   * @since 0.1
   */
  ItemType WARPED_STAIRS = block(Key.key("warped_stairs"));

  /**
   * The minecraft:warped_stem item type.
   *
   * @since 0.1
   */
  ItemType WARPED_STEM = block(Key.key("warped_stem"));

  /**
   * The minecraft:warped_trapdoor item type.
   *
   * @since 0.1
   */
  ItemType WARPED_TRAPDOOR = block(Key.key("warped_trapdoor"));

  /**
   * The minecraft:warped_wart_block item type.
   *
   * @since 0.1
   */
  ItemType WARPED_WART_BLOCK = block(Key.key("warped_wart_block"));

  /**
   * The minecraft:water_bucket item type.
   *
   * @since 0.1
   */
  ItemType WATER_BUCKET = item(Key.key("water_bucket"));

  /**
   * The minecraft:waxed_copper_block item type.
   *
   * @since 0.1
   */
  ItemType WAXED_COPPER_BLOCK = block(Key.key("waxed_copper_block"));

  /**
   * The minecraft:waxed_cut_copper item type.
   *
   * @since 0.1
   */
  ItemType WAXED_CUT_COPPER = block(Key.key("waxed_cut_copper"));

  /**
   * The minecraft:waxed_cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType WAXED_CUT_COPPER_SLAB = block(Key.key("waxed_cut_copper_slab"));

  /**
   * The minecraft:waxed_cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType WAXED_CUT_COPPER_STAIRS = block(Key.key("waxed_cut_copper_stairs"));

  /**
   * The minecraft:waxed_exposed_copper item type.
   *
   * @since 0.1
   */
  ItemType WAXED_EXPOSED_COPPER = block(Key.key("waxed_exposed_copper"));

  /**
   * The minecraft:waxed_exposed_cut_copper item type.
   *
   * @since 0.1
   */
  ItemType WAXED_EXPOSED_CUT_COPPER = block(Key.key("waxed_exposed_cut_copper"));

  /**
   * The minecraft:waxed_exposed_cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType WAXED_EXPOSED_CUT_COPPER_SLAB = block(Key.key("waxed_exposed_cut_copper_slab"));

  /**
   * The minecraft:waxed_exposed_cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType WAXED_EXPOSED_CUT_COPPER_STAIRS = block(Key.key("waxed_exposed_cut_copper_stairs"));

  /**
   * The minecraft:waxed_oxidized_copper item type.
   *
   * @since 0.1
   */
  ItemType WAXED_OXIDIZED_COPPER = block(Key.key("waxed_oxidized_copper"));

  /**
   * The minecraft:waxed_oxidized_cut_copper item type.
   *
   * @since 0.1
   */
  ItemType WAXED_OXIDIZED_CUT_COPPER = block(Key.key("waxed_oxidized_cut_copper"));

  /**
   * The minecraft:waxed_oxidized_cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType WAXED_OXIDIZED_CUT_COPPER_SLAB = block(Key.key("waxed_oxidized_cut_copper_slab"));

  /**
   * The minecraft:waxed_oxidized_cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType WAXED_OXIDIZED_CUT_COPPER_STAIRS = block(Key.key("waxed_oxidized_cut_copper_stairs"));

  /**
   * The minecraft:waxed_weathered_copper item type.
   *
   * @since 0.1
   */
  ItemType WAXED_WEATHERED_COPPER = block(Key.key("waxed_weathered_copper"));

  /**
   * The minecraft:waxed_weathered_cut_copper item type.
   *
   * @since 0.1
   */
  ItemType WAXED_WEATHERED_CUT_COPPER = block(Key.key("waxed_weathered_cut_copper"));

  /**
   * The minecraft:waxed_weathered_cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType WAXED_WEATHERED_CUT_COPPER_SLAB = block(Key.key("waxed_weathered_cut_copper_slab"));

  /**
   * The minecraft:waxed_weathered_cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType WAXED_WEATHERED_CUT_COPPER_STAIRS = block(Key.key("waxed_weathered_cut_copper_stairs"));

  /**
   * The minecraft:wayfinder_armor_trim_smithing_template item type.
   *
   * @since 0.2
   */
  ItemType WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE =
      item(Key.key("wayfinder_armor_trim_smithing_template"));

  /**
   * The minecraft:weathered_copper item type.
   *
   * @since 0.1
   */
  ItemType WEATHERED_COPPER = block(Key.key("weathered_copper"));

  /**
   * The minecraft:weathered_cut_copper item type.
   *
   * @since 0.1
   */
  ItemType WEATHERED_CUT_COPPER = block(Key.key("weathered_cut_copper"));

  /**
   * The minecraft:weathered_cut_copper_slab item type.
   *
   * @since 0.1
   */
  ItemType WEATHERED_CUT_COPPER_SLAB = block(Key.key("weathered_cut_copper_slab"));

  /**
   * The minecraft:weathered_cut_copper_stairs item type.
   *
   * @since 0.1
   */
  ItemType WEATHERED_CUT_COPPER_STAIRS = block(Key.key("weathered_cut_copper_stairs"));

  /**
   * The minecraft:weeping_vines item type.
   *
   * @since 0.1
   */
  ItemType WEEPING_VINES = block(Key.key("weeping_vines"));

  /**
   * The minecraft:wet_sponge item type.
   *
   * @since 0.1
   */
  ItemType WET_SPONGE = block(Key.key("wet_sponge"));

  /**
   * The minecraft:wheat item type.
   *
   * @since 0.1
   */
  ItemType WHEAT = block(Key.key("wheat"));

  /**
   * The minecraft:wheat_seeds item type.
   *
   * @since 0.1
   */
  ItemType WHEAT_SEEDS = item(Key.key("wheat_seeds"));

  /**
   * The minecraft:white_banner item type.
   *
   * @since 0.1
   */
  ItemType WHITE_BANNER = block(Key.key("white_banner"));

  /**
   * The minecraft:white_bed item type.
   *
   * @since 0.1
   */
  ItemType WHITE_BED = block(Key.key("white_bed"));

  /**
   * The minecraft:white_candle item type.
   *
   * @since 0.1
   */
  ItemType WHITE_CANDLE = block(Key.key("white_candle"));

  /**
   * The minecraft:white_carpet item type.
   *
   * @since 0.1
   */
  ItemType WHITE_CARPET = block(Key.key("white_carpet"));

  /**
   * The minecraft:white_concrete item type.
   *
   * @since 0.1
   */
  ItemType WHITE_CONCRETE = block(Key.key("white_concrete"));

  /**
   * The minecraft:white_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType WHITE_CONCRETE_POWDER = block(Key.key("white_concrete_powder"));

  /**
   * The minecraft:white_dye item type.
   *
   * @since 0.1
   */
  ItemType WHITE_DYE = item(Key.key("white_dye"));

  /**
   * The minecraft:white_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType WHITE_GLAZED_TERRACOTTA = block(Key.key("white_glazed_terracotta"));

  /**
   * The minecraft:white_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType WHITE_SHULKER_BOX = block(Key.key("white_shulker_box"));

  /**
   * The minecraft:white_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType WHITE_STAINED_GLASS = block(Key.key("white_stained_glass"));

  /**
   * The minecraft:white_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType WHITE_STAINED_GLASS_PANE = block(Key.key("white_stained_glass_pane"));

  /**
   * The minecraft:white_terracotta item type.
   *
   * @since 0.1
   */
  ItemType WHITE_TERRACOTTA = block(Key.key("white_terracotta"));

  /**
   * The minecraft:white_tulip item type.
   *
   * @since 0.1
   */
  ItemType WHITE_TULIP = block(Key.key("white_tulip"));

  /**
   * The minecraft:white_wool item type.
   *
   * @since 0.1
   */
  ItemType WHITE_WOOL = block(Key.key("white_wool"));

  /**
   * The minecraft:wild_armor_trim_smithing_template item type.
   *
   * @since 0.1
   */
  ItemType WILD_ARMOR_TRIM_SMITHING_TEMPLATE = item(Key.key("wild_armor_trim_smithing_template"));

  /**
   * The minecraft:witch_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType WITCH_SPAWN_EGG = item(Key.key("witch_spawn_egg"));

  /**
   * The minecraft:wither_rose item type.
   *
   * @since 0.1
   */
  ItemType WITHER_ROSE = block(Key.key("wither_rose"));

  /**
   * The minecraft:wither_skeleton_skull item type.
   *
   * @since 0.1
   */
  ItemType WITHER_SKELETON_SKULL = block(Key.key("wither_skeleton_skull"));

  /**
   * The minecraft:wither_skeleton_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType WITHER_SKELETON_SPAWN_EGG = item(Key.key("wither_skeleton_spawn_egg"));

  /**
   * The minecraft:wither_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType WITHER_SPAWN_EGG = item(Key.key("wither_spawn_egg"));

  /**
   * The minecraft:wolf_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType WOLF_SPAWN_EGG = item(Key.key("wolf_spawn_egg"));

  /**
   * The minecraft:wooden_axe item type.
   *
   * @since 0.1
   */
  ItemType WOODEN_AXE = item(Key.key("wooden_axe"));

  /**
   * The minecraft:wooden_hoe item type.
   *
   * @since 0.1
   */
  ItemType WOODEN_HOE = item(Key.key("wooden_hoe"));

  /**
   * The minecraft:wooden_pickaxe item type.
   *
   * @since 0.1
   */
  ItemType WOODEN_PICKAXE = item(Key.key("wooden_pickaxe"));

  /**
   * The minecraft:wooden_shovel item type.
   *
   * @since 0.1
   */
  ItemType WOODEN_SHOVEL = item(Key.key("wooden_shovel"));

  /**
   * The minecraft:wooden_sword item type.
   *
   * @since 0.1
   */
  ItemType WOODEN_SWORD = item(Key.key("wooden_sword"));

  /**
   * The minecraft:writable_book item type.
   *
   * @since 0.1
   */
  ItemType WRITABLE_BOOK = item(Key.key("writable_book"));

  /**
   * The minecraft:written_book item type.
   *
   * @since 0.1
   */
  ItemType WRITTEN_BOOK = item(Key.key("written_book"));

  /**
   * The minecraft:yellow_banner item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_BANNER = block(Key.key("yellow_banner"));

  /**
   * The minecraft:yellow_bed item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_BED = block(Key.key("yellow_bed"));

  /**
   * The minecraft:yellow_candle item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_CANDLE = block(Key.key("yellow_candle"));

  /**
   * The minecraft:yellow_carpet item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_CARPET = block(Key.key("yellow_carpet"));

  /**
   * The minecraft:yellow_concrete item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_CONCRETE = block(Key.key("yellow_concrete"));

  /**
   * The minecraft:yellow_concrete_powder item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_CONCRETE_POWDER = block(Key.key("yellow_concrete_powder"));

  /**
   * The minecraft:yellow_dye item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_DYE = item(Key.key("yellow_dye"));

  /**
   * The minecraft:yellow_glazed_terracotta item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_GLAZED_TERRACOTTA = block(Key.key("yellow_glazed_terracotta"));

  /**
   * The minecraft:yellow_shulker_box item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_SHULKER_BOX = block(Key.key("yellow_shulker_box"));

  /**
   * The minecraft:yellow_stained_glass item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_STAINED_GLASS = block(Key.key("yellow_stained_glass"));

  /**
   * The minecraft:yellow_stained_glass_pane item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_STAINED_GLASS_PANE = block(Key.key("yellow_stained_glass_pane"));

  /**
   * The minecraft:yellow_terracotta item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_TERRACOTTA = block(Key.key("yellow_terracotta"));

  /**
   * The minecraft:yellow_wool item type.
   *
   * @since 0.1
   */
  ItemType YELLOW_WOOL = block(Key.key("yellow_wool"));

  /**
   * The minecraft:zoglin_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ZOGLIN_SPAWN_EGG = item(Key.key("zoglin_spawn_egg"));

  /**
   * The minecraft:zombie_head item type.
   *
   * @since 0.1
   */
  ItemType ZOMBIE_HEAD = block(Key.key("zombie_head"));

  /**
   * The minecraft:zombie_horse_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ZOMBIE_HORSE_SPAWN_EGG = item(Key.key("zombie_horse_spawn_egg"));

  /**
   * The minecraft:zombie_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ZOMBIE_SPAWN_EGG = item(Key.key("zombie_spawn_egg"));

  /**
   * The minecraft:zombie_villager_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ZOMBIE_VILLAGER_SPAWN_EGG = item(Key.key("zombie_villager_spawn_egg"));

  /**
   * The minecraft:zombified_piglin_spawn_egg item type.
   *
   * @since 0.1
   */
  ItemType ZOMBIFIED_PIGLIN_SPAWN_EGG = item(Key.key("zombified_piglin_spawn_egg"));
  // @formatter:on
  // </editor-fold>

  /**
   * Creates a new item type for the given {@link Key}.
   *
   * @param key the key
   * @return the new item type
   * @throws NullPointerException if the key is {@code null}.
   */
  private static ItemType item(final Key key) {
    return ItemTypeImpl.of(key, false);
  }

  /**
   * Creates a new block item type for the given {@link Key}.
   *
   * @param key the key
   * @return the new item type
   * @throws NullPointerException if the key is {@code null}.
   */
  private static ItemType block(final Key key) {
    return ItemTypeImpl.of(key, true);
  }

  /**
   * Finds an {@link ItemType} by its key.
   *
   * @param key the key
   * @return the found {@link ItemType} or {@link Optional#empty()} if no {@link ItemType} by the
   * specified id was found
   * @throws NullPointerException if the key is {@code null}.
   * @since 0.1
   */
  static Optional<ItemType> findByKey(final Key key) {
    return ItemTypeImpl.findByKey(key);
  }
}

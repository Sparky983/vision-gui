package me.sparky983.vision;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import org.jspecify.nullness.NullMarked;

import java.util.Optional;

/**
 * An item type.
 * <p>
 * All items are included as constants in this interface.
 *
 * @since 0.1
 */
@SuppressWarnings("unused")
@NullMarked
public sealed interface ItemType extends Keyed permits ItemTypeImpl {

    // <editor-fold desc="ItemTypes" defaultstate="collapsed">
    // @formatter:off
    /**
     * The minecraft:acacia_boat item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_BOAT = ItemType.of(Key.key("acacia_boat"));

    /**
     * The minecraft:acacia_button item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_BUTTON = ItemType.of(Key.key("acacia_button"));

    /**
     * The minecraft:acacia_door item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_DOOR = ItemType.of(Key.key("acacia_door"));

    /**
     * The minecraft:acacia_fence item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_FENCE = ItemType.of(Key.key("acacia_fence"));

    /**
     * The minecraft:acacia_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_FENCE_GATE = ItemType.of(Key.key("acacia_fence_gate"));

    /**
     * The minecraft:acacia_leaves item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_LEAVES = ItemType.of(Key.key("acacia_leaves"));

    /**
     * The minecraft:acacia_log item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_LOG = ItemType.of(Key.key("acacia_log"));

    /**
     * The minecraft:acacia_planks item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_PLANKS = ItemType.of(Key.key("acacia_planks"));

    /**
     * The minecraft:acacia_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_PRESSURE_PLATE = ItemType.of(Key.key("acacia_pressure_plate"));

    /**
     * The minecraft:acacia_sapling item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_SAPLING = ItemType.of(Key.key("acacia_sapling"));

    /**
     * The minecraft:acacia_sign item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_SIGN = ItemType.of(Key.key("acacia_sign"));

    /**
     * The minecraft:acacia_slab item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_SLAB = ItemType.of(Key.key("acacia_slab"));

    /**
     * The minecraft:acacia_stairs item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_STAIRS = ItemType.of(Key.key("acacia_stairs"));

    /**
     * The minecraft:acacia_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_TRAPDOOR = ItemType.of(Key.key("acacia_trapdoor"));

    /**
     * The minecraft:acacia_wood item type.
     *
     * @since 0.1
     */
    ItemType ACACIA_WOOD = ItemType.of(Key.key("acacia_wood"));

    /**
     * The minecraft:activator_rail item type.
     *
     * @since 0.1
     */
    ItemType ACTIVATOR_RAIL = ItemType.of(Key.key("activator_rail"));

    /**
     * The minecraft:allium item type.
     *
     * @since 0.1
     */
    ItemType ALLIUM = ItemType.of(Key.key("allium"));

    /**
     * The minecraft:amethyst_block item type.
     *
     * @since 0.1
     */
    ItemType AMETHYST_BLOCK = ItemType.of(Key.key("amethyst_block"));

    /**
     * The minecraft:amethyst_cluster item type.
     *
     * @since 0.1
     */
    ItemType AMETHYST_CLUSTER = ItemType.of(Key.key("amethyst_cluster"));

    /**
     * The minecraft:amethyst_shard item type.
     *
     * @since 0.1
     */
    ItemType AMETHYST_SHARD = ItemType.of(Key.key("amethyst_shard"));

    /**
     * The minecraft:ancient_debris item type.
     *
     * @since 0.1
     */
    ItemType ANCIENT_DEBRIS = ItemType.of(Key.key("ancient_debris"));

    /**
     * The minecraft:andesite item type.
     *
     * @since 0.1
     */
    ItemType ANDESITE = ItemType.of(Key.key("andesite"));

    /**
     * The minecraft:andesite_slab item type.
     *
     * @since 0.1
     */
    ItemType ANDESITE_SLAB = ItemType.of(Key.key("andesite_slab"));

    /**
     * The minecraft:andesite_stairs item type.
     *
     * @since 0.1
     */
    ItemType ANDESITE_STAIRS = ItemType.of(Key.key("andesite_stairs"));

    /**
     * The minecraft:andesite_wall item type.
     *
     * @since 0.1
     */
    ItemType ANDESITE_WALL = ItemType.of(Key.key("andesite_wall"));

    /**
     * The minecraft:anvil item type.
     *
     * @since 0.1
     */
    ItemType ANVIL = ItemType.of(Key.key("anvil"));

    /**
     * The minecraft:apple item type.
     *
     * @since 0.1
     */
    ItemType APPLE = ItemType.of(Key.key("apple"));

    /**
     * The minecraft:armor_stand item type.
     *
     * @since 0.1
     */
    ItemType ARMOR_STAND = ItemType.of(Key.key("armor_stand"));

    /**
     * The minecraft:arrow item type.
     *
     * @since 0.1
     */
    ItemType ARROW = ItemType.of(Key.key("arrow"));

    /**
     * The minecraft:axolotl_bucket item type.
     *
     * @since 0.1
     */
    ItemType AXOLOTL_BUCKET = ItemType.of(Key.key("axolotl_bucket"));

    /**
     * The minecraft:axolotl_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType AXOLOTL_SPAWN_EGG = ItemType.of(Key.key("axolotl_spawn_egg"));

    /**
     * The minecraft:azalea item type.
     *
     * @since 0.1
     */
    ItemType AZALEA = ItemType.of(Key.key("azalea"));

    /**
     * The minecraft:azalea_leaves item type.
     *
     * @since 0.1
     */
    ItemType AZALEA_LEAVES = ItemType.of(Key.key("azalea_leaves"));

    /**
     * The minecraft:azure_bluet item type.
     *
     * @since 0.1
     */
    ItemType AZURE_BLUET = ItemType.of(Key.key("azure_bluet"));

    /**
     * The minecraft:baked_potato item type.
     *
     * @since 0.1
     */
    ItemType BAKED_POTATO = ItemType.of(Key.key("baked_potato"));

    /**
     * The minecraft:bamboo item type.
     *
     * @since 0.1
     */
    ItemType BAMBOO = ItemType.of(Key.key("bamboo"));

    /**
     * The minecraft:barrel item type.
     *
     * @since 0.1
     */
    ItemType BARREL = ItemType.of(Key.key("barrel"));

    /**
     * The minecraft:barrier item type.
     *
     * @since 0.1
     */
    ItemType BARRIER = ItemType.of(Key.key("barrier"));

    /**
     * The minecraft:basalt item type.
     *
     * @since 0.1
     */
    ItemType BASALT = ItemType.of(Key.key("basalt"));

    /**
     * The minecraft:bat_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType BAT_SPAWN_EGG = ItemType.of(Key.key("bat_spawn_egg"));

    /**
     * The minecraft:beacon item type.
     *
     * @since 0.1
     */
    ItemType BEACON = ItemType.of(Key.key("beacon"));

    /**
     * The minecraft:bedrock item type.
     *
     * @since 0.1
     */
    ItemType BEDROCK = ItemType.of(Key.key("bedrock"));

    /**
     * The minecraft:bee_nest item type.
     *
     * @since 0.1
     */
    ItemType BEE_NEST = ItemType.of(Key.key("bee_nest"));

    /**
     * The minecraft:bee_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType BEE_SPAWN_EGG = ItemType.of(Key.key("bee_spawn_egg"));

    /**
     * The minecraft:beef item type.
     *
     * @since 0.1
     */
    ItemType BEEF = ItemType.of(Key.key("beef"));

    /**
     * The minecraft:beehive item type.
     *
     * @since 0.1
     */
    ItemType BEEHIVE = ItemType.of(Key.key("beehive"));

    /**
     * The minecraft:beetroot item type.
     *
     * @since 0.1
     */
    ItemType BEETROOT = ItemType.of(Key.key("beetroot"));

    /**
     * The minecraft:beetroot_seeds item type.
     *
     * @since 0.1
     */
    ItemType BEETROOT_SEEDS = ItemType.of(Key.key("beetroot_seeds"));

    /**
     * The minecraft:beetroot_soup item type.
     *
     * @since 0.1
     */
    ItemType BEETROOT_SOUP = ItemType.of(Key.key("beetroot_soup"));

    /**
     * The minecraft:bell item type.
     *
     * @since 0.1
     */
    ItemType BELL = ItemType.of(Key.key("bell"));

    /**
     * The minecraft:big_dripleaf item type.
     *
     * @since 0.1
     */
    ItemType BIG_DRIPLEAF = ItemType.of(Key.key("big_dripleaf"));

    /**
     * The minecraft:birch_boat item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_BOAT = ItemType.of(Key.key("birch_boat"));

    /**
     * The minecraft:birch_button item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_BUTTON = ItemType.of(Key.key("birch_button"));

    /**
     * The minecraft:birch_door item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_DOOR = ItemType.of(Key.key("birch_door"));

    /**
     * The minecraft:birch_fence item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_FENCE = ItemType.of(Key.key("birch_fence"));

    /**
     * The minecraft:birch_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_FENCE_GATE = ItemType.of(Key.key("birch_fence_gate"));

    /**
     * The minecraft:birch_leaves item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_LEAVES = ItemType.of(Key.key("birch_leaves"));

    /**
     * The minecraft:birch_log item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_LOG = ItemType.of(Key.key("birch_log"));

    /**
     * The minecraft:birch_planks item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_PLANKS = ItemType.of(Key.key("birch_planks"));

    /**
     * The minecraft:birch_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_PRESSURE_PLATE = ItemType.of(Key.key("birch_pressure_plate"));

    /**
     * The minecraft:birch_sapling item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_SAPLING = ItemType.of(Key.key("birch_sapling"));

    /**
     * The minecraft:birch_sign item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_SIGN = ItemType.of(Key.key("birch_sign"));

    /**
     * The minecraft:birch_slab item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_SLAB = ItemType.of(Key.key("birch_slab"));

    /**
     * The minecraft:birch_stairs item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_STAIRS = ItemType.of(Key.key("birch_stairs"));

    /**
     * The minecraft:birch_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_TRAPDOOR = ItemType.of(Key.key("birch_trapdoor"));

    /**
     * The minecraft:birch_wood item type.
     *
     * @since 0.1
     */
    ItemType BIRCH_WOOD = ItemType.of(Key.key("birch_wood"));

    /**
     * The minecraft:black_banner item type.
     *
     * @since 0.1
     */
    ItemType BLACK_BANNER = ItemType.of(Key.key("black_banner"));

    /**
     * The minecraft:black_bed item type.
     *
     * @since 0.1
     */
    ItemType BLACK_BED = ItemType.of(Key.key("black_bed"));

    /**
     * The minecraft:black_candle item type.
     *
     * @since 0.1
     */
    ItemType BLACK_CANDLE = ItemType.of(Key.key("black_candle"));

    /**
     * The minecraft:black_carpet item type.
     *
     * @since 0.1
     */
    ItemType BLACK_CARPET = ItemType.of(Key.key("black_carpet"));

    /**
     * The minecraft:black_concrete item type.
     *
     * @since 0.1
     */
    ItemType BLACK_CONCRETE = ItemType.of(Key.key("black_concrete"));

    /**
     * The minecraft:black_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType BLACK_CONCRETE_POWDER = ItemType.of(Key.key("black_concrete_powder"));

    /**
     * The minecraft:black_dye item type.
     *
     * @since 0.1
     */
    ItemType BLACK_DYE = ItemType.of(Key.key("black_dye"));

    /**
     * The minecraft:black_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType BLACK_GLAZED_TERRACOTTA = ItemType.of(Key.key("black_glazed_terracotta"));

    /**
     * The minecraft:black_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType BLACK_SHULKER_BOX = ItemType.of(Key.key("black_shulker_box"));

    /**
     * The minecraft:black_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType BLACK_STAINED_GLASS = ItemType.of(Key.key("black_stained_glass"));

    /**
     * The minecraft:black_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType BLACK_STAINED_GLASS_PANE = ItemType.of(Key.key("black_stained_glass_pane"));

    /**
     * The minecraft:black_terracotta item type.
     *
     * @since 0.1
     */
    ItemType BLACK_TERRACOTTA = ItemType.of(Key.key("black_terracotta"));

    /**
     * The minecraft:black_wool item type.
     *
     * @since 0.1
     */
    ItemType BLACK_WOOL = ItemType.of(Key.key("black_wool"));

    /**
     * The minecraft:blackstone item type.
     *
     * @since 0.1
     */
    ItemType BLACKSTONE = ItemType.of(Key.key("blackstone"));

    /**
     * The minecraft:blackstone_slab item type.
     *
     * @since 0.1
     */
    ItemType BLACKSTONE_SLAB = ItemType.of(Key.key("blackstone_slab"));

    /**
     * The minecraft:blackstone_stairs item type.
     *
     * @since 0.1
     */
    ItemType BLACKSTONE_STAIRS = ItemType.of(Key.key("blackstone_stairs"));

    /**
     * The minecraft:blackstone_wall item type.
     *
     * @since 0.1
     */
    ItemType BLACKSTONE_WALL = ItemType.of(Key.key("blackstone_wall"));

    /**
     * The minecraft:blast_furnace item type.
     *
     * @since 0.1
     */
    ItemType BLAST_FURNACE = ItemType.of(Key.key("blast_furnace"));

    /**
     * The minecraft:blaze_powder item type.
     *
     * @since 0.1
     */
    ItemType BLAZE_POWDER = ItemType.of(Key.key("blaze_powder"));

    /**
     * The minecraft:blaze_rod item type.
     *
     * @since 0.1
     */
    ItemType BLAZE_ROD = ItemType.of(Key.key("blaze_rod"));

    /**
     * The minecraft:blaze_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType BLAZE_SPAWN_EGG = ItemType.of(Key.key("blaze_spawn_egg"));

    /**
     * The minecraft:blue_banner item type.
     *
     * @since 0.1
     */
    ItemType BLUE_BANNER = ItemType.of(Key.key("blue_banner"));

    /**
     * The minecraft:blue_bed item type.
     *
     * @since 0.1
     */
    ItemType BLUE_BED = ItemType.of(Key.key("blue_bed"));

    /**
     * The minecraft:blue_candle item type.
     *
     * @since 0.1
     */
    ItemType BLUE_CANDLE = ItemType.of(Key.key("blue_candle"));

    /**
     * The minecraft:blue_carpet item type.
     *
     * @since 0.1
     */
    ItemType BLUE_CARPET = ItemType.of(Key.key("blue_carpet"));

    /**
     * The minecraft:blue_concrete item type.
     *
     * @since 0.1
     */
    ItemType BLUE_CONCRETE = ItemType.of(Key.key("blue_concrete"));

    /**
     * The minecraft:blue_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType BLUE_CONCRETE_POWDER = ItemType.of(Key.key("blue_concrete_powder"));

    /**
     * The minecraft:blue_dye item type.
     *
     * @since 0.1
     */
    ItemType BLUE_DYE = ItemType.of(Key.key("blue_dye"));

    /**
     * The minecraft:blue_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType BLUE_GLAZED_TERRACOTTA = ItemType.of(Key.key("blue_glazed_terracotta"));

    /**
     * The minecraft:blue_ice item type.
     *
     * @since 0.1
     */
    ItemType BLUE_ICE = ItemType.of(Key.key("blue_ice"));

    /**
     * The minecraft:blue_orchid item type.
     *
     * @since 0.1
     */
    ItemType BLUE_ORCHID = ItemType.of(Key.key("blue_orchid"));

    /**
     * The minecraft:blue_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType BLUE_SHULKER_BOX = ItemType.of(Key.key("blue_shulker_box"));

    /**
     * The minecraft:blue_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType BLUE_STAINED_GLASS = ItemType.of(Key.key("blue_stained_glass"));

    /**
     * The minecraft:blue_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType BLUE_STAINED_GLASS_PANE = ItemType.of(Key.key("blue_stained_glass_pane"));

    /**
     * The minecraft:blue_terracotta item type.
     *
     * @since 0.1
     */
    ItemType BLUE_TERRACOTTA = ItemType.of(Key.key("blue_terracotta"));

    /**
     * The minecraft:blue_wool item type.
     *
     * @since 0.1
     */
    ItemType BLUE_WOOL = ItemType.of(Key.key("blue_wool"));

    /**
     * The minecraft:bone item type.
     *
     * @since 0.1
     */
    ItemType BONE = ItemType.of(Key.key("bone"));

    /**
     * The minecraft:bone_block item type.
     *
     * @since 0.1
     */
    ItemType BONE_BLOCK = ItemType.of(Key.key("bone_block"));

    /**
     * The minecraft:bone_meal item type.
     *
     * @since 0.1
     */
    ItemType BONE_MEAL = ItemType.of(Key.key("bone_meal"));

    /**
     * The minecraft:book item type.
     *
     * @since 0.1
     */
    ItemType BOOK = ItemType.of(Key.key("book"));

    /**
     * The minecraft:bookshelf item type.
     *
     * @since 0.1
     */
    ItemType BOOKSHELF = ItemType.of(Key.key("bookshelf"));

    /**
     * The minecraft:bow item type.
     *
     * @since 0.1
     */
    ItemType BOW = ItemType.of(Key.key("bow"));

    /**
     * The minecraft:bowl item type.
     *
     * @since 0.1
     */
    ItemType BOWL = ItemType.of(Key.key("bowl"));

    /**
     * The minecraft:brain_coral item type.
     *
     * @since 0.1
     */
    ItemType BRAIN_CORAL = ItemType.of(Key.key("brain_coral"));

    /**
     * The minecraft:brain_coral_block item type.
     *
     * @since 0.1
     */
    ItemType BRAIN_CORAL_BLOCK = ItemType.of(Key.key("brain_coral_block"));

    /**
     * The minecraft:brain_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType BRAIN_CORAL_FAN = ItemType.of(Key.key("brain_coral_fan"));

    /**
     * The minecraft:bread item type.
     *
     * @since 0.1
     */
    ItemType BREAD = ItemType.of(Key.key("bread"));

    /**
     * The minecraft:brewing_stand item type.
     *
     * @since 0.1
     */
    ItemType BREWING_STAND = ItemType.of(Key.key("brewing_stand"));

    /**
     * The minecraft:brick item type.
     *
     * @since 0.1
     */
    ItemType BRICK = ItemType.of(Key.key("brick"));

    /**
     * The minecraft:brick_slab item type.
     *
     * @since 0.1
     */
    ItemType BRICK_SLAB = ItemType.of(Key.key("brick_slab"));

    /**
     * The minecraft:brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType BRICK_STAIRS = ItemType.of(Key.key("brick_stairs"));

    /**
     * The minecraft:brick_wall item type.
     *
     * @since 0.1
     */
    ItemType BRICK_WALL = ItemType.of(Key.key("brick_wall"));

    /**
     * The minecraft:bricks item type.
     *
     * @since 0.1
     */
    ItemType BRICKS = ItemType.of(Key.key("bricks"));

    /**
     * The minecraft:brown_banner item type.
     *
     * @since 0.1
     */
    ItemType BROWN_BANNER = ItemType.of(Key.key("brown_banner"));

    /**
     * The minecraft:brown_bed item type.
     *
     * @since 0.1
     */
    ItemType BROWN_BED = ItemType.of(Key.key("brown_bed"));

    /**
     * The minecraft:brown_candle item type.
     *
     * @since 0.1
     */
    ItemType BROWN_CANDLE = ItemType.of(Key.key("brown_candle"));

    /**
     * The minecraft:brown_carpet item type.
     *
     * @since 0.1
     */
    ItemType BROWN_CARPET = ItemType.of(Key.key("brown_carpet"));

    /**
     * The minecraft:brown_concrete item type.
     *
     * @since 0.1
     */
    ItemType BROWN_CONCRETE = ItemType.of(Key.key("brown_concrete"));

    /**
     * The minecraft:brown_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType BROWN_CONCRETE_POWDER = ItemType.of(Key.key("brown_concrete_powder"));

    /**
     * The minecraft:brown_dye item type.
     *
     * @since 0.1
     */
    ItemType BROWN_DYE = ItemType.of(Key.key("brown_dye"));

    /**
     * The minecraft:brown_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType BROWN_GLAZED_TERRACOTTA = ItemType.of(Key.key("brown_glazed_terracotta"));

    /**
     * The minecraft:brown_mushroom item type.
     *
     * @since 0.1
     */
    ItemType BROWN_MUSHROOM = ItemType.of(Key.key("brown_mushroom"));

    /**
     * The minecraft:brown_mushroom_block item type.
     *
     * @since 0.1
     */
    ItemType BROWN_MUSHROOM_BLOCK = ItemType.of(Key.key("brown_mushroom_block"));

    /**
     * The minecraft:brown_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType BROWN_SHULKER_BOX = ItemType.of(Key.key("brown_shulker_box"));

    /**
     * The minecraft:brown_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType BROWN_STAINED_GLASS = ItemType.of(Key.key("brown_stained_glass"));

    /**
     * The minecraft:brown_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType BROWN_STAINED_GLASS_PANE = ItemType.of(Key.key("brown_stained_glass_pane"));

    /**
     * The minecraft:brown_terracotta item type.
     *
     * @since 0.1
     */
    ItemType BROWN_TERRACOTTA = ItemType.of(Key.key("brown_terracotta"));

    /**
     * The minecraft:brown_wool item type.
     *
     * @since 0.1
     */
    ItemType BROWN_WOOL = ItemType.of(Key.key("brown_wool"));

    /**
     * The minecraft:bubble_coral item type.
     *
     * @since 0.1
     */
    ItemType BUBBLE_CORAL = ItemType.of(Key.key("bubble_coral"));

    /**
     * The minecraft:bubble_coral_block item type.
     *
     * @since 0.1
     */
    ItemType BUBBLE_CORAL_BLOCK = ItemType.of(Key.key("bubble_coral_block"));

    /**
     * The minecraft:bubble_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType BUBBLE_CORAL_FAN = ItemType.of(Key.key("bubble_coral_fan"));

    /**
     * The minecraft:bucket item type.
     *
     * @since 0.1
     */
    ItemType BUCKET = ItemType.of(Key.key("bucket"));

    /**
     * The minecraft:budding_amethyst item type.
     *
     * @since 0.1
     */
    ItemType BUDDING_AMETHYST = ItemType.of(Key.key("budding_amethyst"));

    /**
     * The minecraft:bundle item type.
     *
     * @since 0.1
     */
    ItemType BUNDLE = ItemType.of(Key.key("bundle"));

    /**
     * The minecraft:cactus item type.
     *
     * @since 0.1
     */
    ItemType CACTUS = ItemType.of(Key.key("cactus"));

    /**
     * The minecraft:cake item type.
     *
     * @since 0.1
     */
    ItemType CAKE = ItemType.of(Key.key("cake"));

    /**
     * The minecraft:calcite item type.
     *
     * @since 0.1
     */
    ItemType CALCITE = ItemType.of(Key.key("calcite"));

    /**
     * The minecraft:campfire item type.
     *
     * @since 0.1
     */
    ItemType CAMPFIRE = ItemType.of(Key.key("campfire"));

    /**
     * The minecraft:candle item type.
     *
     * @since 0.1
     */
    ItemType CANDLE = ItemType.of(Key.key("candle"));

    /**
     * The minecraft:carrot item type.
     *
     * @since 0.1
     */
    ItemType CARROT = ItemType.of(Key.key("carrot"));

    /**
     * The minecraft:carrot_on_a_stick item type.
     *
     * @since 0.1
     */
    ItemType CARROT_ON_A_STICK = ItemType.of(Key.key("carrot_on_a_stick"));

    /**
     * The minecraft:cartography_table item type.
     *
     * @since 0.1
     */
    ItemType CARTOGRAPHY_TABLE = ItemType.of(Key.key("cartography_table"));

    /**
     * The minecraft:carved_pumpkin item type.
     *
     * @since 0.1
     */
    ItemType CARVED_PUMPKIN = ItemType.of(Key.key("carved_pumpkin"));

    /**
     * The minecraft:cat_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType CAT_SPAWN_EGG = ItemType.of(Key.key("cat_spawn_egg"));

    /**
     * The minecraft:cauldron item type.
     *
     * @since 0.1
     */
    ItemType CAULDRON = ItemType.of(Key.key("cauldron"));

    /**
     * The minecraft:cave_spider_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType CAVE_SPIDER_SPAWN_EGG = ItemType.of(Key.key("cave_spider_spawn_egg"));

    /**
     * The minecraft:chain item type.
     *
     * @since 0.1
     */
    ItemType CHAIN = ItemType.of(Key.key("chain"));

    /**
     * The minecraft:chain_command_block item type.
     *
     * @since 0.1
     */
    ItemType CHAIN_COMMAND_BLOCK = ItemType.of(Key.key("chain_command_block"));

    /**
     * The minecraft:chainmail_boots item type.
     *
     * @since 0.1
     */
    ItemType CHAINMAIL_BOOTS = ItemType.of(Key.key("chainmail_boots"));

    /**
     * The minecraft:chainmail_chestplate item type.
     *
     * @since 0.1
     */
    ItemType CHAINMAIL_CHESTPLATE = ItemType.of(Key.key("chainmail_chestplate"));

    /**
     * The minecraft:chainmail_helmet item type.
     *
     * @since 0.1
     */
    ItemType CHAINMAIL_HELMET = ItemType.of(Key.key("chainmail_helmet"));

    /**
     * The minecraft:chainmail_leggings item type.
     *
     * @since 0.1
     */
    ItemType CHAINMAIL_LEGGINGS = ItemType.of(Key.key("chainmail_leggings"));

    /**
     * The minecraft:charcoal item type.
     *
     * @since 0.1
     */
    ItemType CHARCOAL = ItemType.of(Key.key("charcoal"));

    /**
     * The minecraft:chest item type.
     *
     * @since 0.1
     */
    ItemType CHEST = ItemType.of(Key.key("chest"));

    /**
     * The minecraft:chest_minecart item type.
     *
     * @since 0.1
     */
    ItemType CHEST_MINECART = ItemType.of(Key.key("chest_minecart"));

    /**
     * The minecraft:chicken item type.
     *
     * @since 0.1
     */
    ItemType CHICKEN = ItemType.of(Key.key("chicken"));

    /**
     * The minecraft:chicken_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType CHICKEN_SPAWN_EGG = ItemType.of(Key.key("chicken_spawn_egg"));

    /**
     * The minecraft:chipped_anvil item type.
     *
     * @since 0.1
     */
    ItemType CHIPPED_ANVIL = ItemType.of(Key.key("chipped_anvil"));

    /**
     * The minecraft:chiseled_deepslate item type.
     *
     * @since 0.1
     */
    ItemType CHISELED_DEEPSLATE = ItemType.of(Key.key("chiseled_deepslate"));

    /**
     * The minecraft:chiseled_nether_bricks item type.
     *
     * @since 0.1
     */
    ItemType CHISELED_NETHER_BRICKS = ItemType.of(Key.key("chiseled_nether_bricks"));

    /**
     * The minecraft:chiseled_polished_blackstone item type.
     *
     * @since 0.1
     */
    ItemType CHISELED_POLISHED_BLACKSTONE = ItemType.of(Key.key("chiseled_polished_blackstone"));

    /**
     * The minecraft:chiseled_quartz_block item type.
     *
     * @since 0.1
     */
    ItemType CHISELED_QUARTZ_BLOCK = ItemType.of(Key.key("chiseled_quartz_block"));

    /**
     * The minecraft:chiseled_red_sandstone item type.
     *
     * @since 0.1
     */
    ItemType CHISELED_RED_SANDSTONE = ItemType.of(Key.key("chiseled_red_sandstone"));

    /**
     * The minecraft:chiseled_sandstone item type.
     *
     * @since 0.1
     */
    ItemType CHISELED_SANDSTONE = ItemType.of(Key.key("chiseled_sandstone"));

    /**
     * The minecraft:chiseled_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType CHISELED_STONE_BRICKS = ItemType.of(Key.key("chiseled_stone_bricks"));

    /**
     * The minecraft:chorus_flower item type.
     *
     * @since 0.1
     */
    ItemType CHORUS_FLOWER = ItemType.of(Key.key("chorus_flower"));

    /**
     * The minecraft:chorus_fruit item type.
     *
     * @since 0.1
     */
    ItemType CHORUS_FRUIT = ItemType.of(Key.key("chorus_fruit"));

    /**
     * The minecraft:chorus_plant item type.
     *
     * @since 0.1
     */
    ItemType CHORUS_PLANT = ItemType.of(Key.key("chorus_plant"));

    /**
     * The minecraft:clay item type.
     *
     * @since 0.1
     */
    ItemType CLAY = ItemType.of(Key.key("clay"));

    /**
     * The minecraft:clay_ball item type.
     *
     * @since 0.1
     */
    ItemType CLAY_BALL = ItemType.of(Key.key("clay_ball"));

    /**
     * The minecraft:clock item type.
     *
     * @since 0.1
     */
    ItemType CLOCK = ItemType.of(Key.key("clock"));

    /**
     * The minecraft:coal item type.
     *
     * @since 0.1
     */
    ItemType COAL = ItemType.of(Key.key("coal"));

    /**
     * The minecraft:coal_block item type.
     *
     * @since 0.1
     */
    ItemType COAL_BLOCK = ItemType.of(Key.key("coal_block"));

    /**
     * The minecraft:coal_ore item type.
     *
     * @since 0.1
     */
    ItemType COAL_ORE = ItemType.of(Key.key("coal_ore"));

    /**
     * The minecraft:coarse_dirt item type.
     *
     * @since 0.1
     */
    ItemType COARSE_DIRT = ItemType.of(Key.key("coarse_dirt"));

    /**
     * The minecraft:cobbled_deepslate item type.
     *
     * @since 0.1
     */
    ItemType COBBLED_DEEPSLATE = ItemType.of(Key.key("cobbled_deepslate"));

    /**
     * The minecraft:cobbled_deepslate_slab item type.
     *
     * @since 0.1
     */
    ItemType COBBLED_DEEPSLATE_SLAB = ItemType.of(Key.key("cobbled_deepslate_slab"));

    /**
     * The minecraft:cobbled_deepslate_stairs item type.
     *
     * @since 0.1
     */
    ItemType COBBLED_DEEPSLATE_STAIRS = ItemType.of(Key.key("cobbled_deepslate_stairs"));

    /**
     * The minecraft:cobbled_deepslate_wall item type.
     *
     * @since 0.1
     */
    ItemType COBBLED_DEEPSLATE_WALL = ItemType.of(Key.key("cobbled_deepslate_wall"));

    /**
     * The minecraft:cobblestone item type.
     *
     * @since 0.1
     */
    ItemType COBBLESTONE = ItemType.of(Key.key("cobblestone"));

    /**
     * The minecraft:cobblestone_slab item type.
     *
     * @since 0.1
     */
    ItemType COBBLESTONE_SLAB = ItemType.of(Key.key("cobblestone_slab"));

    /**
     * The minecraft:cobblestone_stairs item type.
     *
     * @since 0.1
     */
    ItemType COBBLESTONE_STAIRS = ItemType.of(Key.key("cobblestone_stairs"));

    /**
     * The minecraft:cobblestone_wall item type.
     *
     * @since 0.1
     */
    ItemType COBBLESTONE_WALL = ItemType.of(Key.key("cobblestone_wall"));

    /**
     * The minecraft:cobweb item type.
     *
     * @since 0.1
     */
    ItemType COBWEB = ItemType.of(Key.key("cobweb"));

    /**
     * The minecraft:cocoa_beans item type.
     *
     * @since 0.1
     */
    ItemType COCOA_BEANS = ItemType.of(Key.key("cocoa_beans"));

    /**
     * The minecraft:cod item type.
     *
     * @since 0.1
     */
    ItemType COD = ItemType.of(Key.key("cod"));

    /**
     * The minecraft:cod_bucket item type.
     *
     * @since 0.1
     */
    ItemType COD_BUCKET = ItemType.of(Key.key("cod_bucket"));

    /**
     * The minecraft:cod_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType COD_SPAWN_EGG = ItemType.of(Key.key("cod_spawn_egg"));

    /**
     * The minecraft:command_block item type.
     *
     * @since 0.1
     */
    ItemType COMMAND_BLOCK = ItemType.of(Key.key("command_block"));

    /**
     * The minecraft:command_block_minecart item type.
     *
     * @since 0.1
     */
    ItemType COMMAND_BLOCK_MINECART = ItemType.of(Key.key("command_block_minecart"));

    /**
     * The minecraft:comparator item type.
     *
     * @since 0.1
     */
    ItemType COMPARATOR = ItemType.of(Key.key("comparator"));

    /**
     * The minecraft:compass item type.
     *
     * @since 0.1
     */
    ItemType COMPASS = ItemType.of(Key.key("compass"));

    /**
     * The minecraft:composter item type.
     *
     * @since 0.1
     */
    ItemType COMPOSTER = ItemType.of(Key.key("composter"));

    /**
     * The minecraft:conduit item type.
     *
     * @since 0.1
     */
    ItemType CONDUIT = ItemType.of(Key.key("conduit"));

    /**
     * The minecraft:cooked_beef item type.
     *
     * @since 0.1
     */
    ItemType COOKED_BEEF = ItemType.of(Key.key("cooked_beef"));

    /**
     * The minecraft:cooked_chicken item type.
     *
     * @since 0.1
     */
    ItemType COOKED_CHICKEN = ItemType.of(Key.key("cooked_chicken"));

    /**
     * The minecraft:cooked_cod item type.
     *
     * @since 0.1
     */
    ItemType COOKED_COD = ItemType.of(Key.key("cooked_cod"));

    /**
     * The minecraft:cooked_mutton item type.
     *
     * @since 0.1
     */
    ItemType COOKED_MUTTON = ItemType.of(Key.key("cooked_mutton"));

    /**
     * The minecraft:cooked_porkchop item type.
     *
     * @since 0.1
     */
    ItemType COOKED_PORKCHOP = ItemType.of(Key.key("cooked_porkchop"));

    /**
     * The minecraft:cooked_rabbit item type.
     *
     * @since 0.1
     */
    ItemType COOKED_RABBIT = ItemType.of(Key.key("cooked_rabbit"));

    /**
     * The minecraft:cooked_salmon item type.
     *
     * @since 0.1
     */
    ItemType COOKED_SALMON = ItemType.of(Key.key("cooked_salmon"));

    /**
     * The minecraft:cookie item type.
     *
     * @since 0.1
     */
    ItemType COOKIE = ItemType.of(Key.key("cookie"));

    /**
     * The minecraft:copper_block item type.
     *
     * @since 0.1
     */
    ItemType COPPER_BLOCK = ItemType.of(Key.key("copper_block"));

    /**
     * The minecraft:copper_ingot item type.
     *
     * @since 0.1
     */
    ItemType COPPER_INGOT = ItemType.of(Key.key("copper_ingot"));

    /**
     * The minecraft:copper_ore item type.
     *
     * @since 0.1
     */
    ItemType COPPER_ORE = ItemType.of(Key.key("copper_ore"));

    /**
     * The minecraft:cornflower item type.
     *
     * @since 0.1
     */
    ItemType CORNFLOWER = ItemType.of(Key.key("cornflower"));

    /**
     * The minecraft:cow_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType COW_SPAWN_EGG = ItemType.of(Key.key("cow_spawn_egg"));

    /**
     * The minecraft:cracked_deepslate_bricks item type.
     *
     * @since 0.1
     */
    ItemType CRACKED_DEEPSLATE_BRICKS = ItemType.of(Key.key("cracked_deepslate_bricks"));

    /**
     * The minecraft:cracked_deepslate_tiles item type.
     *
     * @since 0.1
     */
    ItemType CRACKED_DEEPSLATE_TILES = ItemType.of(Key.key("cracked_deepslate_tiles"));

    /**
     * The minecraft:cracked_nether_bricks item type.
     *
     * @since 0.1
     */
    ItemType CRACKED_NETHER_BRICKS = ItemType.of(Key.key("cracked_nether_bricks"));

    /**
     * The minecraft:cracked_polished_blackstone_bricks item type.
     *
     * @since 0.1
     */
    ItemType CRACKED_POLISHED_BLACKSTONE_BRICKS = ItemType.of(Key.key("cracked_polished_blackstone_bricks"));

    /**
     * The minecraft:cracked_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType CRACKED_STONE_BRICKS = ItemType.of(Key.key("cracked_stone_bricks"));

    /**
     * The minecraft:crafting_table item type.
     *
     * @since 0.1
     */
    ItemType CRAFTING_TABLE = ItemType.of(Key.key("crafting_table"));

    /**
     * The minecraft:creeper_banner_pattern item type.
     *
     * @since 0.1
     */
    ItemType CREEPER_BANNER_PATTERN = ItemType.of(Key.key("creeper_banner_pattern"));

    /**
     * The minecraft:creeper_head item type.
     *
     * @since 0.1
     */
    ItemType CREEPER_HEAD = ItemType.of(Key.key("creeper_head"));

    /**
     * The minecraft:creeper_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType CREEPER_SPAWN_EGG = ItemType.of(Key.key("creeper_spawn_egg"));

    /**
     * The minecraft:crimson_button item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_BUTTON = ItemType.of(Key.key("crimson_button"));

    /**
     * The minecraft:crimson_door item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_DOOR = ItemType.of(Key.key("crimson_door"));

    /**
     * The minecraft:crimson_fence item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_FENCE = ItemType.of(Key.key("crimson_fence"));

    /**
     * The minecraft:crimson_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_FENCE_GATE = ItemType.of(Key.key("crimson_fence_gate"));

    /**
     * The minecraft:crimson_fungus item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_FUNGUS = ItemType.of(Key.key("crimson_fungus"));

    /**
     * The minecraft:crimson_hyphae item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_HYPHAE = ItemType.of(Key.key("crimson_hyphae"));

    /**
     * The minecraft:crimson_nylium item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_NYLIUM = ItemType.of(Key.key("crimson_nylium"));

    /**
     * The minecraft:crimson_planks item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_PLANKS = ItemType.of(Key.key("crimson_planks"));

    /**
     * The minecraft:crimson_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_PRESSURE_PLATE = ItemType.of(Key.key("crimson_pressure_plate"));

    /**
     * The minecraft:crimson_roots item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_ROOTS = ItemType.of(Key.key("crimson_roots"));

    /**
     * The minecraft:crimson_sign item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_SIGN = ItemType.of(Key.key("crimson_sign"));

    /**
     * The minecraft:crimson_slab item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_SLAB = ItemType.of(Key.key("crimson_slab"));

    /**
     * The minecraft:crimson_stairs item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_STAIRS = ItemType.of(Key.key("crimson_stairs"));

    /**
     * The minecraft:crimson_stem item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_STEM = ItemType.of(Key.key("crimson_stem"));

    /**
     * The minecraft:crimson_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType CRIMSON_TRAPDOOR = ItemType.of(Key.key("crimson_trapdoor"));

    /**
     * The minecraft:crossbow item type.
     *
     * @since 0.1
     */
    ItemType CROSSBOW = ItemType.of(Key.key("crossbow"));

    /**
     * The minecraft:crying_obsidian item type.
     *
     * @since 0.1
     */
    ItemType CRYING_OBSIDIAN = ItemType.of(Key.key("crying_obsidian"));

    /**
     * The minecraft:cut_copper item type.
     *
     * @since 0.1
     */
    ItemType CUT_COPPER = ItemType.of(Key.key("cut_copper"));

    /**
     * The minecraft:cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType CUT_COPPER_SLAB = ItemType.of(Key.key("cut_copper_slab"));

    /**
     * The minecraft:cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType CUT_COPPER_STAIRS = ItemType.of(Key.key("cut_copper_stairs"));

    /**
     * The minecraft:cut_red_sandstone item type.
     *
     * @since 0.1
     */
    ItemType CUT_RED_SANDSTONE = ItemType.of(Key.key("cut_red_sandstone"));

    /**
     * The minecraft:cut_red_sandstone_slab item type.
     *
     * @since 0.1
     */
    ItemType CUT_RED_SANDSTONE_SLAB = ItemType.of(Key.key("cut_red_sandstone_slab"));

    /**
     * The minecraft:cut_sandstone item type.
     *
     * @since 0.1
     */
    ItemType CUT_SANDSTONE = ItemType.of(Key.key("cut_sandstone"));

    /**
     * The minecraft:cut_sandstone_slab item type.
     *
     * @since 0.1
     */
    ItemType CUT_SANDSTONE_SLAB = ItemType.of(Key.key("cut_sandstone_slab"));

    /**
     * The minecraft:cyan_banner item type.
     *
     * @since 0.1
     */
    ItemType CYAN_BANNER = ItemType.of(Key.key("cyan_banner"));

    /**
     * The minecraft:cyan_bed item type.
     *
     * @since 0.1
     */
    ItemType CYAN_BED = ItemType.of(Key.key("cyan_bed"));

    /**
     * The minecraft:cyan_candle item type.
     *
     * @since 0.1
     */
    ItemType CYAN_CANDLE = ItemType.of(Key.key("cyan_candle"));

    /**
     * The minecraft:cyan_carpet item type.
     *
     * @since 0.1
     */
    ItemType CYAN_CARPET = ItemType.of(Key.key("cyan_carpet"));

    /**
     * The minecraft:cyan_concrete item type.
     *
     * @since 0.1
     */
    ItemType CYAN_CONCRETE = ItemType.of(Key.key("cyan_concrete"));

    /**
     * The minecraft:cyan_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType CYAN_CONCRETE_POWDER = ItemType.of(Key.key("cyan_concrete_powder"));

    /**
     * The minecraft:cyan_dye item type.
     *
     * @since 0.1
     */
    ItemType CYAN_DYE = ItemType.of(Key.key("cyan_dye"));

    /**
     * The minecraft:cyan_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType CYAN_GLAZED_TERRACOTTA = ItemType.of(Key.key("cyan_glazed_terracotta"));

    /**
     * The minecraft:cyan_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType CYAN_SHULKER_BOX = ItemType.of(Key.key("cyan_shulker_box"));

    /**
     * The minecraft:cyan_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType CYAN_STAINED_GLASS = ItemType.of(Key.key("cyan_stained_glass"));

    /**
     * The minecraft:cyan_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType CYAN_STAINED_GLASS_PANE = ItemType.of(Key.key("cyan_stained_glass_pane"));

    /**
     * The minecraft:cyan_terracotta item type.
     *
     * @since 0.1
     */
    ItemType CYAN_TERRACOTTA = ItemType.of(Key.key("cyan_terracotta"));

    /**
     * The minecraft:cyan_wool item type.
     *
     * @since 0.1
     */
    ItemType CYAN_WOOL = ItemType.of(Key.key("cyan_wool"));

    /**
     * The minecraft:damaged_anvil item type.
     *
     * @since 0.1
     */
    ItemType DAMAGED_ANVIL = ItemType.of(Key.key("damaged_anvil"));

    /**
     * The minecraft:dandelion item type.
     *
     * @since 0.1
     */
    ItemType DANDELION = ItemType.of(Key.key("dandelion"));

    /**
     * The minecraft:dark_oak_boat item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_BOAT = ItemType.of(Key.key("dark_oak_boat"));

    /**
     * The minecraft:dark_oak_button item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_BUTTON = ItemType.of(Key.key("dark_oak_button"));

    /**
     * The minecraft:dark_oak_door item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_DOOR = ItemType.of(Key.key("dark_oak_door"));

    /**
     * The minecraft:dark_oak_fence item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_FENCE = ItemType.of(Key.key("dark_oak_fence"));

    /**
     * The minecraft:dark_oak_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_FENCE_GATE = ItemType.of(Key.key("dark_oak_fence_gate"));

    /**
     * The minecraft:dark_oak_leaves item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_LEAVES = ItemType.of(Key.key("dark_oak_leaves"));

    /**
     * The minecraft:dark_oak_log item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_LOG = ItemType.of(Key.key("dark_oak_log"));

    /**
     * The minecraft:dark_oak_planks item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_PLANKS = ItemType.of(Key.key("dark_oak_planks"));

    /**
     * The minecraft:dark_oak_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_PRESSURE_PLATE = ItemType.of(Key.key("dark_oak_pressure_plate"));

    /**
     * The minecraft:dark_oak_sapling item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_SAPLING = ItemType.of(Key.key("dark_oak_sapling"));

    /**
     * The minecraft:dark_oak_sign item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_SIGN = ItemType.of(Key.key("dark_oak_sign"));

    /**
     * The minecraft:dark_oak_slab item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_SLAB = ItemType.of(Key.key("dark_oak_slab"));

    /**
     * The minecraft:dark_oak_stairs item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_STAIRS = ItemType.of(Key.key("dark_oak_stairs"));

    /**
     * The minecraft:dark_oak_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_TRAPDOOR = ItemType.of(Key.key("dark_oak_trapdoor"));

    /**
     * The minecraft:dark_oak_wood item type.
     *
     * @since 0.1
     */
    ItemType DARK_OAK_WOOD = ItemType.of(Key.key("dark_oak_wood"));

    /**
     * The minecraft:dark_prismarine item type.
     *
     * @since 0.1
     */
    ItemType DARK_PRISMARINE = ItemType.of(Key.key("dark_prismarine"));

    /**
     * The minecraft:dark_prismarine_slab item type.
     *
     * @since 0.1
     */
    ItemType DARK_PRISMARINE_SLAB = ItemType.of(Key.key("dark_prismarine_slab"));

    /**
     * The minecraft:dark_prismarine_stairs item type.
     *
     * @since 0.1
     */
    ItemType DARK_PRISMARINE_STAIRS = ItemType.of(Key.key("dark_prismarine_stairs"));

    /**
     * The minecraft:daylight_detector item type.
     *
     * @since 0.1
     */
    ItemType DAYLIGHT_DETECTOR = ItemType.of(Key.key("daylight_detector"));

    /**
     * The minecraft:dead_brain_coral item type.
     *
     * @since 0.1
     */
    ItemType DEAD_BRAIN_CORAL = ItemType.of(Key.key("dead_brain_coral"));

    /**
     * The minecraft:dead_brain_coral_block item type.
     *
     * @since 0.1
     */
    ItemType DEAD_BRAIN_CORAL_BLOCK = ItemType.of(Key.key("dead_brain_coral_block"));

    /**
     * The minecraft:dead_brain_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType DEAD_BRAIN_CORAL_FAN = ItemType.of(Key.key("dead_brain_coral_fan"));

    /**
     * The minecraft:dead_bubble_coral item type.
     *
     * @since 0.1
     */
    ItemType DEAD_BUBBLE_CORAL = ItemType.of(Key.key("dead_bubble_coral"));

    /**
     * The minecraft:dead_bubble_coral_block item type.
     *
     * @since 0.1
     */
    ItemType DEAD_BUBBLE_CORAL_BLOCK = ItemType.of(Key.key("dead_bubble_coral_block"));

    /**
     * The minecraft:dead_bubble_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType DEAD_BUBBLE_CORAL_FAN = ItemType.of(Key.key("dead_bubble_coral_fan"));

    /**
     * The minecraft:dead_bush item type.
     *
     * @since 0.1
     */
    ItemType DEAD_BUSH = ItemType.of(Key.key("dead_bush"));

    /**
     * The minecraft:dead_fire_coral item type.
     *
     * @since 0.1
     */
    ItemType DEAD_FIRE_CORAL = ItemType.of(Key.key("dead_fire_coral"));

    /**
     * The minecraft:dead_fire_coral_block item type.
     *
     * @since 0.1
     */
    ItemType DEAD_FIRE_CORAL_BLOCK = ItemType.of(Key.key("dead_fire_coral_block"));

    /**
     * The minecraft:dead_fire_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType DEAD_FIRE_CORAL_FAN = ItemType.of(Key.key("dead_fire_coral_fan"));

    /**
     * The minecraft:dead_horn_coral item type.
     *
     * @since 0.1
     */
    ItemType DEAD_HORN_CORAL = ItemType.of(Key.key("dead_horn_coral"));

    /**
     * The minecraft:dead_horn_coral_block item type.
     *
     * @since 0.1
     */
    ItemType DEAD_HORN_CORAL_BLOCK = ItemType.of(Key.key("dead_horn_coral_block"));

    /**
     * The minecraft:dead_horn_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType DEAD_HORN_CORAL_FAN = ItemType.of(Key.key("dead_horn_coral_fan"));

    /**
     * The minecraft:dead_tube_coral item type.
     *
     * @since 0.1
     */
    ItemType DEAD_TUBE_CORAL = ItemType.of(Key.key("dead_tube_coral"));

    /**
     * The minecraft:dead_tube_coral_block item type.
     *
     * @since 0.1
     */
    ItemType DEAD_TUBE_CORAL_BLOCK = ItemType.of(Key.key("dead_tube_coral_block"));

    /**
     * The minecraft:dead_tube_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType DEAD_TUBE_CORAL_FAN = ItemType.of(Key.key("dead_tube_coral_fan"));

    /**
     * The minecraft:debug_stick item type.
     *
     * @since 0.1
     */
    ItemType DEBUG_STICK = ItemType.of(Key.key("debug_stick"));

    /**
     * The minecraft:deepslate item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE = ItemType.of(Key.key("deepslate"));

    /**
     * The minecraft:deepslate_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_BRICK_SLAB = ItemType.of(Key.key("deepslate_brick_slab"));

    /**
     * The minecraft:deepslate_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_BRICK_STAIRS = ItemType.of(Key.key("deepslate_brick_stairs"));

    /**
     * The minecraft:deepslate_brick_wall item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_BRICK_WALL = ItemType.of(Key.key("deepslate_brick_wall"));

    /**
     * The minecraft:deepslate_bricks item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_BRICKS = ItemType.of(Key.key("deepslate_bricks"));

    /**
     * The minecraft:deepslate_coal_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_COAL_ORE = ItemType.of(Key.key("deepslate_coal_ore"));

    /**
     * The minecraft:deepslate_copper_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_COPPER_ORE = ItemType.of(Key.key("deepslate_copper_ore"));

    /**
     * The minecraft:deepslate_diamond_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_DIAMOND_ORE = ItemType.of(Key.key("deepslate_diamond_ore"));

    /**
     * The minecraft:deepslate_emerald_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_EMERALD_ORE = ItemType.of(Key.key("deepslate_emerald_ore"));

    /**
     * The minecraft:deepslate_gold_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_GOLD_ORE = ItemType.of(Key.key("deepslate_gold_ore"));

    /**
     * The minecraft:deepslate_iron_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_IRON_ORE = ItemType.of(Key.key("deepslate_iron_ore"));

    /**
     * The minecraft:deepslate_lapis_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_LAPIS_ORE = ItemType.of(Key.key("deepslate_lapis_ore"));

    /**
     * The minecraft:deepslate_redstone_ore item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_REDSTONE_ORE = ItemType.of(Key.key("deepslate_redstone_ore"));

    /**
     * The minecraft:deepslate_tile_slab item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_TILE_SLAB = ItemType.of(Key.key("deepslate_tile_slab"));

    /**
     * The minecraft:deepslate_tile_stairs item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_TILE_STAIRS = ItemType.of(Key.key("deepslate_tile_stairs"));

    /**
     * The minecraft:deepslate_tile_wall item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_TILE_WALL = ItemType.of(Key.key("deepslate_tile_wall"));

    /**
     * The minecraft:deepslate_tiles item type.
     *
     * @since 0.1
     */
    ItemType DEEPSLATE_TILES = ItemType.of(Key.key("deepslate_tiles"));

    /**
     * The minecraft:detector_rail item type.
     *
     * @since 0.1
     */
    ItemType DETECTOR_RAIL = ItemType.of(Key.key("detector_rail"));

    /**
     * The minecraft:diamond item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND = ItemType.of(Key.key("diamond"));

    /**
     * The minecraft:diamond_axe item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_AXE = ItemType.of(Key.key("diamond_axe"));

    /**
     * The minecraft:diamond_block item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_BLOCK = ItemType.of(Key.key("diamond_block"));

    /**
     * The minecraft:diamond_boots item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_BOOTS = ItemType.of(Key.key("diamond_boots"));

    /**
     * The minecraft:diamond_chestplate item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_CHESTPLATE = ItemType.of(Key.key("diamond_chestplate"));

    /**
     * The minecraft:diamond_helmet item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_HELMET = ItemType.of(Key.key("diamond_helmet"));

    /**
     * The minecraft:diamond_hoe item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_HOE = ItemType.of(Key.key("diamond_hoe"));

    /**
     * The minecraft:diamond_horse_armor item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_HORSE_ARMOR = ItemType.of(Key.key("diamond_horse_armor"));

    /**
     * The minecraft:diamond_leggings item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_LEGGINGS = ItemType.of(Key.key("diamond_leggings"));

    /**
     * The minecraft:diamond_ore item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_ORE = ItemType.of(Key.key("diamond_ore"));

    /**
     * The minecraft:diamond_pickaxe item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_PICKAXE = ItemType.of(Key.key("diamond_pickaxe"));

    /**
     * The minecraft:diamond_shovel item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_SHOVEL = ItemType.of(Key.key("diamond_shovel"));

    /**
     * The minecraft:diamond_sword item type.
     *
     * @since 0.1
     */
    ItemType DIAMOND_SWORD = ItemType.of(Key.key("diamond_sword"));

    /**
     * The minecraft:diorite item type.
     *
     * @since 0.1
     */
    ItemType DIORITE = ItemType.of(Key.key("diorite"));

    /**
     * The minecraft:diorite_slab item type.
     *
     * @since 0.1
     */
    ItemType DIORITE_SLAB = ItemType.of(Key.key("diorite_slab"));

    /**
     * The minecraft:diorite_stairs item type.
     *
     * @since 0.1
     */
    ItemType DIORITE_STAIRS = ItemType.of(Key.key("diorite_stairs"));

    /**
     * The minecraft:diorite_wall item type.
     *
     * @since 0.1
     */
    ItemType DIORITE_WALL = ItemType.of(Key.key("diorite_wall"));

    /**
     * The minecraft:dirt item type.
     *
     * @since 0.1
     */
    ItemType DIRT = ItemType.of(Key.key("dirt"));

    /**
     * The minecraft:dirt_path item type.
     *
     * @since 0.1
     */
    ItemType DIRT_PATH = ItemType.of(Key.key("dirt_path"));

    /**
     * The minecraft:dispenser item type.
     *
     * @since 0.1
     */
    ItemType DISPENSER = ItemType.of(Key.key("dispenser"));

    /**
     * The minecraft:dolphin_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType DOLPHIN_SPAWN_EGG = ItemType.of(Key.key("dolphin_spawn_egg"));

    /**
     * The minecraft:donkey_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType DONKEY_SPAWN_EGG = ItemType.of(Key.key("donkey_spawn_egg"));

    /**
     * The minecraft:dragon_breath item type.
     *
     * @since 0.1
     */
    ItemType DRAGON_BREATH = ItemType.of(Key.key("dragon_breath"));

    /**
     * The minecraft:dragon_egg item type.
     *
     * @since 0.1
     */
    ItemType DRAGON_EGG = ItemType.of(Key.key("dragon_egg"));

    /**
     * The minecraft:dragon_head item type.
     *
     * @since 0.1
     */
    ItemType DRAGON_HEAD = ItemType.of(Key.key("dragon_head"));

    /**
     * The minecraft:dried_kelp item type.
     *
     * @since 0.1
     */
    ItemType DRIED_KELP = ItemType.of(Key.key("dried_kelp"));

    /**
     * The minecraft:dried_kelp_block item type.
     *
     * @since 0.1
     */
    ItemType DRIED_KELP_BLOCK = ItemType.of(Key.key("dried_kelp_block"));

    /**
     * The minecraft:dripstone_block item type.
     *
     * @since 0.1
     */
    ItemType DRIPSTONE_BLOCK = ItemType.of(Key.key("dripstone_block"));

    /**
     * The minecraft:dropper item type.
     *
     * @since 0.1
     */
    ItemType DROPPER = ItemType.of(Key.key("dropper"));

    /**
     * The minecraft:drowned_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType DROWNED_SPAWN_EGG = ItemType.of(Key.key("drowned_spawn_egg"));

    /**
     * The minecraft:egg item type.
     *
     * @since 0.1
     */
    ItemType EGG = ItemType.of(Key.key("egg"));

    /**
     * The minecraft:elder_guardian_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ELDER_GUARDIAN_SPAWN_EGG = ItemType.of(Key.key("elder_guardian_spawn_egg"));

    /**
     * The minecraft:elytra item type.
     *
     * @since 0.1
     */
    ItemType ELYTRA = ItemType.of(Key.key("elytra"));

    /**
     * The minecraft:emerald item type.
     *
     * @since 0.1
     */
    ItemType EMERALD = ItemType.of(Key.key("emerald"));

    /**
     * The minecraft:emerald_block item type.
     *
     * @since 0.1
     */
    ItemType EMERALD_BLOCK = ItemType.of(Key.key("emerald_block"));

    /**
     * The minecraft:emerald_ore item type.
     *
     * @since 0.1
     */
    ItemType EMERALD_ORE = ItemType.of(Key.key("emerald_ore"));

    /**
     * The minecraft:enchanted_book item type.
     *
     * @since 0.1
     */
    ItemType ENCHANTED_BOOK = ItemType.of(Key.key("enchanted_book"));

    /**
     * The minecraft:enchanted_golden_apple item type.
     *
     * @since 0.1
     */
    ItemType ENCHANTED_GOLDEN_APPLE = ItemType.of(Key.key("enchanted_golden_apple"));

    /**
     * The minecraft:enchanting_table item type.
     *
     * @since 0.1
     */
    ItemType ENCHANTING_TABLE = ItemType.of(Key.key("enchanting_table"));

    /**
     * The minecraft:end_crystal item type.
     *
     * @since 0.1
     */
    ItemType END_CRYSTAL = ItemType.of(Key.key("end_crystal"));

    /**
     * The minecraft:end_portal_frame item type.
     *
     * @since 0.1
     */
    ItemType END_PORTAL_FRAME = ItemType.of(Key.key("end_portal_frame"));

    /**
     * The minecraft:end_rod item type.
     *
     * @since 0.1
     */
    ItemType END_ROD = ItemType.of(Key.key("end_rod"));

    /**
     * The minecraft:end_stone item type.
     *
     * @since 0.1
     */
    ItemType END_STONE = ItemType.of(Key.key("end_stone"));

    /**
     * The minecraft:end_stone_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType END_STONE_BRICK_SLAB = ItemType.of(Key.key("end_stone_brick_slab"));

    /**
     * The minecraft:end_stone_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType END_STONE_BRICK_STAIRS = ItemType.of(Key.key("end_stone_brick_stairs"));

    /**
     * The minecraft:end_stone_brick_wall item type.
     *
     * @since 0.1
     */
    ItemType END_STONE_BRICK_WALL = ItemType.of(Key.key("end_stone_brick_wall"));

    /**
     * The minecraft:end_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType END_STONE_BRICKS = ItemType.of(Key.key("end_stone_bricks"));

    /**
     * The minecraft:ender_chest item type.
     *
     * @since 0.1
     */
    ItemType ENDER_CHEST = ItemType.of(Key.key("ender_chest"));

    /**
     * The minecraft:ender_eye item type.
     *
     * @since 0.1
     */
    ItemType ENDER_EYE = ItemType.of(Key.key("ender_eye"));

    /**
     * The minecraft:ender_pearl item type.
     *
     * @since 0.1
     */
    ItemType ENDER_PEARL = ItemType.of(Key.key("ender_pearl"));

    /**
     * The minecraft:enderman_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ENDERMAN_SPAWN_EGG = ItemType.of(Key.key("enderman_spawn_egg"));

    /**
     * The minecraft:endermite_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ENDERMITE_SPAWN_EGG = ItemType.of(Key.key("endermite_spawn_egg"));

    /**
     * The minecraft:evoker_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType EVOKER_SPAWN_EGG = ItemType.of(Key.key("evoker_spawn_egg"));

    /**
     * The minecraft:experience_bottle item type.
     *
     * @since 0.1
     */
    ItemType EXPERIENCE_BOTTLE = ItemType.of(Key.key("experience_bottle"));

    /**
     * The minecraft:exposed_copper item type.
     *
     * @since 0.1
     */
    ItemType EXPOSED_COPPER = ItemType.of(Key.key("exposed_copper"));

    /**
     * The minecraft:exposed_cut_copper item type.
     *
     * @since 0.1
     */
    ItemType EXPOSED_CUT_COPPER = ItemType.of(Key.key("exposed_cut_copper"));

    /**
     * The minecraft:exposed_cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType EXPOSED_CUT_COPPER_SLAB = ItemType.of(Key.key("exposed_cut_copper_slab"));

    /**
     * The minecraft:exposed_cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType EXPOSED_CUT_COPPER_STAIRS = ItemType.of(Key.key("exposed_cut_copper_stairs"));

    /**
     * The minecraft:farmland item type.
     *
     * @since 0.1
     */
    ItemType FARMLAND = ItemType.of(Key.key("farmland"));

    /**
     * The minecraft:feather item type.
     *
     * @since 0.1
     */
    ItemType FEATHER = ItemType.of(Key.key("feather"));

    /**
     * The minecraft:fermented_spider_eye item type.
     *
     * @since 0.1
     */
    ItemType FERMENTED_SPIDER_EYE = ItemType.of(Key.key("fermented_spider_eye"));

    /**
     * The minecraft:fern item type.
     *
     * @since 0.1
     */
    ItemType FERN = ItemType.of(Key.key("fern"));

    /**
     * The minecraft:filled_map item type.
     *
     * @since 0.1
     */
    ItemType FILLED_MAP = ItemType.of(Key.key("filled_map"));

    /**
     * The minecraft:fire_charge item type.
     *
     * @since 0.1
     */
    ItemType FIRE_CHARGE = ItemType.of(Key.key("fire_charge"));

    /**
     * The minecraft:fire_coral item type.
     *
     * @since 0.1
     */
    ItemType FIRE_CORAL = ItemType.of(Key.key("fire_coral"));

    /**
     * The minecraft:fire_coral_block item type.
     *
     * @since 0.1
     */
    ItemType FIRE_CORAL_BLOCK = ItemType.of(Key.key("fire_coral_block"));

    /**
     * The minecraft:fire_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType FIRE_CORAL_FAN = ItemType.of(Key.key("fire_coral_fan"));

    /**
     * The minecraft:firework_rocket item type.
     *
     * @since 0.1
     */
    ItemType FIREWORK_ROCKET = ItemType.of(Key.key("firework_rocket"));

    /**
     * The minecraft:firework_star item type.
     *
     * @since 0.1
     */
    ItemType FIREWORK_STAR = ItemType.of(Key.key("firework_star"));

    /**
     * The minecraft:fishing_rod item type.
     *
     * @since 0.1
     */
    ItemType FISHING_ROD = ItemType.of(Key.key("fishing_rod"));

    /**
     * The minecraft:fletching_table item type.
     *
     * @since 0.1
     */
    ItemType FLETCHING_TABLE = ItemType.of(Key.key("fletching_table"));

    /**
     * The minecraft:flint item type.
     *
     * @since 0.1
     */
    ItemType FLINT = ItemType.of(Key.key("flint"));

    /**
     * The minecraft:flint_and_steel item type.
     *
     * @since 0.1
     */
    ItemType FLINT_AND_STEEL = ItemType.of(Key.key("flint_and_steel"));

    /**
     * The minecraft:flower_banner_pattern item type.
     *
     * @since 0.1
     */
    ItemType FLOWER_BANNER_PATTERN = ItemType.of(Key.key("flower_banner_pattern"));

    /**
     * The minecraft:flower_pot item type.
     *
     * @since 0.1
     */
    ItemType FLOWER_POT = ItemType.of(Key.key("flower_pot"));

    /**
     * The minecraft:flowering_azalea item type.
     *
     * @since 0.1
     */
    ItemType FLOWERING_AZALEA = ItemType.of(Key.key("flowering_azalea"));

    /**
     * The minecraft:flowering_azalea_leaves item type.
     *
     * @since 0.1
     */
    ItemType FLOWERING_AZALEA_LEAVES = ItemType.of(Key.key("flowering_azalea_leaves"));

    /**
     * The minecraft:fox_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType FOX_SPAWN_EGG = ItemType.of(Key.key("fox_spawn_egg"));

    /**
     * The minecraft:furnace item type.
     *
     * @since 0.1
     */
    ItemType FURNACE = ItemType.of(Key.key("furnace"));

    /**
     * The minecraft:furnace_minecart item type.
     *
     * @since 0.1
     */
    ItemType FURNACE_MINECART = ItemType.of(Key.key("furnace_minecart"));

    /**
     * The minecraft:ghast_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType GHAST_SPAWN_EGG = ItemType.of(Key.key("ghast_spawn_egg"));

    /**
     * The minecraft:ghast_tear item type.
     *
     * @since 0.1
     */
    ItemType GHAST_TEAR = ItemType.of(Key.key("ghast_tear"));

    /**
     * The minecraft:gilded_blackstone item type.
     *
     * @since 0.1
     */
    ItemType GILDED_BLACKSTONE = ItemType.of(Key.key("gilded_blackstone"));

    /**
     * The minecraft:glass item type.
     *
     * @since 0.1
     */
    ItemType GLASS = ItemType.of(Key.key("glass"));

    /**
     * The minecraft:glass_bottle item type.
     *
     * @since 0.1
     */
    ItemType GLASS_BOTTLE = ItemType.of(Key.key("glass_bottle"));

    /**
     * The minecraft:glass_pane item type.
     *
     * @since 0.1
     */
    ItemType GLASS_PANE = ItemType.of(Key.key("glass_pane"));

    /**
     * The minecraft:glistering_melon_slice item type.
     *
     * @since 0.1
     */
    ItemType GLISTERING_MELON_SLICE = ItemType.of(Key.key("glistering_melon_slice"));

    /**
     * The minecraft:globe_banner_pattern item type.
     *
     * @since 0.1
     */
    ItemType GLOBE_BANNER_PATTERN = ItemType.of(Key.key("globe_banner_pattern"));

    /**
     * The minecraft:glow_berries item type.
     *
     * @since 0.1
     */
    ItemType GLOW_BERRIES = ItemType.of(Key.key("glow_berries"));

    /**
     * The minecraft:glow_ink_sac item type.
     *
     * @since 0.1
     */
    ItemType GLOW_INK_SAC = ItemType.of(Key.key("glow_ink_sac"));

    /**
     * The minecraft:glow_item_frame item type.
     *
     * @since 0.1
     */
    ItemType GLOW_ITEM_FRAME = ItemType.of(Key.key("glow_item_frame"));

    /**
     * The minecraft:glow_lichen item type.
     *
     * @since 0.1
     */
    ItemType GLOW_LICHEN = ItemType.of(Key.key("glow_lichen"));

    /**
     * The minecraft:glow_squid_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType GLOW_SQUID_SPAWN_EGG = ItemType.of(Key.key("glow_squid_spawn_egg"));

    /**
     * The minecraft:glowstone item type.
     *
     * @since 0.1
     */
    ItemType GLOWSTONE = ItemType.of(Key.key("glowstone"));

    /**
     * The minecraft:glowstone_dust item type.
     *
     * @since 0.1
     */
    ItemType GLOWSTONE_DUST = ItemType.of(Key.key("glowstone_dust"));

    /**
     * The minecraft:goat_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType GOAT_SPAWN_EGG = ItemType.of(Key.key("goat_spawn_egg"));

    /**
     * The minecraft:gold_block item type.
     *
     * @since 0.1
     */
    ItemType GOLD_BLOCK = ItemType.of(Key.key("gold_block"));

    /**
     * The minecraft:gold_ingot item type.
     *
     * @since 0.1
     */
    ItemType GOLD_INGOT = ItemType.of(Key.key("gold_ingot"));

    /**
     * The minecraft:gold_nugget item type.
     *
     * @since 0.1
     */
    ItemType GOLD_NUGGET = ItemType.of(Key.key("gold_nugget"));

    /**
     * The minecraft:gold_ore item type.
     *
     * @since 0.1
     */
    ItemType GOLD_ORE = ItemType.of(Key.key("gold_ore"));

    /**
     * The minecraft:golden_apple item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_APPLE = ItemType.of(Key.key("golden_apple"));

    /**
     * The minecraft:golden_axe item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_AXE = ItemType.of(Key.key("golden_axe"));

    /**
     * The minecraft:golden_boots item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_BOOTS = ItemType.of(Key.key("golden_boots"));

    /**
     * The minecraft:golden_carrot item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_CARROT = ItemType.of(Key.key("golden_carrot"));

    /**
     * The minecraft:golden_chestplate item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_CHESTPLATE = ItemType.of(Key.key("golden_chestplate"));

    /**
     * The minecraft:golden_helmet item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_HELMET = ItemType.of(Key.key("golden_helmet"));

    /**
     * The minecraft:golden_hoe item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_HOE = ItemType.of(Key.key("golden_hoe"));

    /**
     * The minecraft:golden_horse_armor item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_HORSE_ARMOR = ItemType.of(Key.key("golden_horse_armor"));

    /**
     * The minecraft:golden_leggings item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_LEGGINGS = ItemType.of(Key.key("golden_leggings"));

    /**
     * The minecraft:golden_pickaxe item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_PICKAXE = ItemType.of(Key.key("golden_pickaxe"));

    /**
     * The minecraft:golden_shovel item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_SHOVEL = ItemType.of(Key.key("golden_shovel"));

    /**
     * The minecraft:golden_sword item type.
     *
     * @since 0.1
     */
    ItemType GOLDEN_SWORD = ItemType.of(Key.key("golden_sword"));

    /**
     * The minecraft:granite item type.
     *
     * @since 0.1
     */
    ItemType GRANITE = ItemType.of(Key.key("granite"));

    /**
     * The minecraft:granite_slab item type.
     *
     * @since 0.1
     */
    ItemType GRANITE_SLAB = ItemType.of(Key.key("granite_slab"));

    /**
     * The minecraft:granite_stairs item type.
     *
     * @since 0.1
     */
    ItemType GRANITE_STAIRS = ItemType.of(Key.key("granite_stairs"));

    /**
     * The minecraft:granite_wall item type.
     *
     * @since 0.1
     */
    ItemType GRANITE_WALL = ItemType.of(Key.key("granite_wall"));

    /**
     * The minecraft:grass item type.
     *
     * @since 0.1
     */
    ItemType GRASS = ItemType.of(Key.key("grass"));

    /**
     * The minecraft:grass_block item type.
     *
     * @since 0.1
     */
    ItemType GRASS_BLOCK = ItemType.of(Key.key("grass_block"));

    /**
     * The minecraft:gravel item type.
     *
     * @since 0.1
     */
    ItemType GRAVEL = ItemType.of(Key.key("gravel"));

    /**
     * The minecraft:gray_banner item type.
     *
     * @since 0.1
     */
    ItemType GRAY_BANNER = ItemType.of(Key.key("gray_banner"));

    /**
     * The minecraft:gray_bed item type.
     *
     * @since 0.1
     */
    ItemType GRAY_BED = ItemType.of(Key.key("gray_bed"));

    /**
     * The minecraft:gray_candle item type.
     *
     * @since 0.1
     */
    ItemType GRAY_CANDLE = ItemType.of(Key.key("gray_candle"));

    /**
     * The minecraft:gray_carpet item type.
     *
     * @since 0.1
     */
    ItemType GRAY_CARPET = ItemType.of(Key.key("gray_carpet"));

    /**
     * The minecraft:gray_concrete item type.
     *
     * @since 0.1
     */
    ItemType GRAY_CONCRETE = ItemType.of(Key.key("gray_concrete"));

    /**
     * The minecraft:gray_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType GRAY_CONCRETE_POWDER = ItemType.of(Key.key("gray_concrete_powder"));

    /**
     * The minecraft:gray_dye item type.
     *
     * @since 0.1
     */
    ItemType GRAY_DYE = ItemType.of(Key.key("gray_dye"));

    /**
     * The minecraft:gray_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType GRAY_GLAZED_TERRACOTTA = ItemType.of(Key.key("gray_glazed_terracotta"));

    /**
     * The minecraft:gray_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType GRAY_SHULKER_BOX = ItemType.of(Key.key("gray_shulker_box"));

    /**
     * The minecraft:gray_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType GRAY_STAINED_GLASS = ItemType.of(Key.key("gray_stained_glass"));

    /**
     * The minecraft:gray_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType GRAY_STAINED_GLASS_PANE = ItemType.of(Key.key("gray_stained_glass_pane"));

    /**
     * The minecraft:gray_terracotta item type.
     *
     * @since 0.1
     */
    ItemType GRAY_TERRACOTTA = ItemType.of(Key.key("gray_terracotta"));

    /**
     * The minecraft:gray_wool item type.
     *
     * @since 0.1
     */
    ItemType GRAY_WOOL = ItemType.of(Key.key("gray_wool"));

    /**
     * The minecraft:green_banner item type.
     *
     * @since 0.1
     */
    ItemType GREEN_BANNER = ItemType.of(Key.key("green_banner"));

    /**
     * The minecraft:green_bed item type.
     *
     * @since 0.1
     */
    ItemType GREEN_BED = ItemType.of(Key.key("green_bed"));

    /**
     * The minecraft:green_candle item type.
     *
     * @since 0.1
     */
    ItemType GREEN_CANDLE = ItemType.of(Key.key("green_candle"));

    /**
     * The minecraft:green_carpet item type.
     *
     * @since 0.1
     */
    ItemType GREEN_CARPET = ItemType.of(Key.key("green_carpet"));

    /**
     * The minecraft:green_concrete item type.
     *
     * @since 0.1
     */
    ItemType GREEN_CONCRETE = ItemType.of(Key.key("green_concrete"));

    /**
     * The minecraft:green_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType GREEN_CONCRETE_POWDER = ItemType.of(Key.key("green_concrete_powder"));

    /**
     * The minecraft:green_dye item type.
     *
     * @since 0.1
     */
    ItemType GREEN_DYE = ItemType.of(Key.key("green_dye"));

    /**
     * The minecraft:green_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType GREEN_GLAZED_TERRACOTTA = ItemType.of(Key.key("green_glazed_terracotta"));

    /**
     * The minecraft:green_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType GREEN_SHULKER_BOX = ItemType.of(Key.key("green_shulker_box"));

    /**
     * The minecraft:green_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType GREEN_STAINED_GLASS = ItemType.of(Key.key("green_stained_glass"));

    /**
     * The minecraft:green_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType GREEN_STAINED_GLASS_PANE = ItemType.of(Key.key("green_stained_glass_pane"));

    /**
     * The minecraft:green_terracotta item type.
     *
     * @since 0.1
     */
    ItemType GREEN_TERRACOTTA = ItemType.of(Key.key("green_terracotta"));

    /**
     * The minecraft:green_wool item type.
     *
     * @since 0.1
     */
    ItemType GREEN_WOOL = ItemType.of(Key.key("green_wool"));

    /**
     * The minecraft:grindstone item type.
     *
     * @since 0.1
     */
    ItemType GRINDSTONE = ItemType.of(Key.key("grindstone"));

    /**
     * The minecraft:guardian_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType GUARDIAN_SPAWN_EGG = ItemType.of(Key.key("guardian_spawn_egg"));

    /**
     * The minecraft:gunpowder item type.
     *
     * @since 0.1
     */
    ItemType GUNPOWDER = ItemType.of(Key.key("gunpowder"));

    /**
     * The minecraft:hanging_roots item type.
     *
     * @since 0.1
     */
    ItemType HANGING_ROOTS = ItemType.of(Key.key("hanging_roots"));

    /**
     * The minecraft:hay_block item type.
     *
     * @since 0.1
     */
    ItemType HAY_BLOCK = ItemType.of(Key.key("hay_block"));

    /**
     * The minecraft:heart_of_the_sea item type.
     *
     * @since 0.1
     */
    ItemType HEART_OF_THE_SEA = ItemType.of(Key.key("heart_of_the_sea"));

    /**
     * The minecraft:heavy_weighted_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType HEAVY_WEIGHTED_PRESSURE_PLATE = ItemType.of(Key.key("heavy_weighted_pressure_plate"));

    /**
     * The minecraft:hoglin_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType HOGLIN_SPAWN_EGG = ItemType.of(Key.key("hoglin_spawn_egg"));

    /**
     * The minecraft:honey_block item type.
     *
     * @since 0.1
     */
    ItemType HONEY_BLOCK = ItemType.of(Key.key("honey_block"));

    /**
     * The minecraft:honey_bottle item type.
     *
     * @since 0.1
     */
    ItemType HONEY_BOTTLE = ItemType.of(Key.key("honey_bottle"));

    /**
     * The minecraft:honeycomb item type.
     *
     * @since 0.1
     */
    ItemType HONEYCOMB = ItemType.of(Key.key("honeycomb"));

    /**
     * The minecraft:honeycomb_block item type.
     *
     * @since 0.1
     */
    ItemType HONEYCOMB_BLOCK = ItemType.of(Key.key("honeycomb_block"));

    /**
     * The minecraft:hopper item type.
     *
     * @since 0.1
     */
    ItemType HOPPER = ItemType.of(Key.key("hopper"));

    /**
     * The minecraft:hopper_minecart item type.
     *
     * @since 0.1
     */
    ItemType HOPPER_MINECART = ItemType.of(Key.key("hopper_minecart"));

    /**
     * The minecraft:horn_coral item type.
     *
     * @since 0.1
     */
    ItemType HORN_CORAL = ItemType.of(Key.key("horn_coral"));

    /**
     * The minecraft:horn_coral_block item type.
     *
     * @since 0.1
     */
    ItemType HORN_CORAL_BLOCK = ItemType.of(Key.key("horn_coral_block"));

    /**
     * The minecraft:horn_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType HORN_CORAL_FAN = ItemType.of(Key.key("horn_coral_fan"));

    /**
     * The minecraft:horse_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType HORSE_SPAWN_EGG = ItemType.of(Key.key("horse_spawn_egg"));

    /**
     * The minecraft:husk_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType HUSK_SPAWN_EGG = ItemType.of(Key.key("husk_spawn_egg"));

    /**
     * The minecraft:ice item type.
     *
     * @since 0.1
     */
    ItemType ICE = ItemType.of(Key.key("ice"));

    /**
     * The minecraft:infested_chiseled_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType INFESTED_CHISELED_STONE_BRICKS = ItemType.of(Key.key("infested_chiseled_stone_bricks"));

    /**
     * The minecraft:infested_cobblestone item type.
     *
     * @since 0.1
     */
    ItemType INFESTED_COBBLESTONE = ItemType.of(Key.key("infested_cobblestone"));

    /**
     * The minecraft:infested_cracked_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType INFESTED_CRACKED_STONE_BRICKS = ItemType.of(Key.key("infested_cracked_stone_bricks"));

    /**
     * The minecraft:infested_deepslate item type.
     *
     * @since 0.1
     */
    ItemType INFESTED_DEEPSLATE = ItemType.of(Key.key("infested_deepslate"));

    /**
     * The minecraft:infested_mossy_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType INFESTED_MOSSY_STONE_BRICKS = ItemType.of(Key.key("infested_mossy_stone_bricks"));

    /**
     * The minecraft:infested_stone item type.
     *
     * @since 0.1
     */
    ItemType INFESTED_STONE = ItemType.of(Key.key("infested_stone"));

    /**
     * The minecraft:infested_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType INFESTED_STONE_BRICKS = ItemType.of(Key.key("infested_stone_bricks"));

    /**
     * The minecraft:ink_sac item type.
     *
     * @since 0.1
     */
    ItemType INK_SAC = ItemType.of(Key.key("ink_sac"));

    /**
     * The minecraft:iron_axe item type.
     *
     * @since 0.1
     */
    ItemType IRON_AXE = ItemType.of(Key.key("iron_axe"));

    /**
     * The minecraft:iron_bars item type.
     *
     * @since 0.1
     */
    ItemType IRON_BARS = ItemType.of(Key.key("iron_bars"));

    /**
     * The minecraft:iron_block item type.
     *
     * @since 0.1
     */
    ItemType IRON_BLOCK = ItemType.of(Key.key("iron_block"));

    /**
     * The minecraft:iron_boots item type.
     *
     * @since 0.1
     */
    ItemType IRON_BOOTS = ItemType.of(Key.key("iron_boots"));

    /**
     * The minecraft:iron_chestplate item type.
     *
     * @since 0.1
     */
    ItemType IRON_CHESTPLATE = ItemType.of(Key.key("iron_chestplate"));

    /**
     * The minecraft:iron_door item type.
     *
     * @since 0.1
     */
    ItemType IRON_DOOR = ItemType.of(Key.key("iron_door"));

    /**
     * The minecraft:iron_helmet item type.
     *
     * @since 0.1
     */
    ItemType IRON_HELMET = ItemType.of(Key.key("iron_helmet"));

    /**
     * The minecraft:iron_hoe item type.
     *
     * @since 0.1
     */
    ItemType IRON_HOE = ItemType.of(Key.key("iron_hoe"));

    /**
     * The minecraft:iron_horse_armor item type.
     *
     * @since 0.1
     */
    ItemType IRON_HORSE_ARMOR = ItemType.of(Key.key("iron_horse_armor"));

    /**
     * The minecraft:iron_ingot item type.
     *
     * @since 0.1
     */
    ItemType IRON_INGOT = ItemType.of(Key.key("iron_ingot"));

    /**
     * The minecraft:iron_leggings item type.
     *
     * @since 0.1
     */
    ItemType IRON_LEGGINGS = ItemType.of(Key.key("iron_leggings"));

    /**
     * The minecraft:iron_nugget item type.
     *
     * @since 0.1
     */
    ItemType IRON_NUGGET = ItemType.of(Key.key("iron_nugget"));

    /**
     * The minecraft:iron_ore item type.
     *
     * @since 0.1
     */
    ItemType IRON_ORE = ItemType.of(Key.key("iron_ore"));

    /**
     * The minecraft:iron_pickaxe item type.
     *
     * @since 0.1
     */
    ItemType IRON_PICKAXE = ItemType.of(Key.key("iron_pickaxe"));

    /**
     * The minecraft:iron_shovel item type.
     *
     * @since 0.1
     */
    ItemType IRON_SHOVEL = ItemType.of(Key.key("iron_shovel"));

    /**
     * The minecraft:iron_sword item type.
     *
     * @since 0.1
     */
    ItemType IRON_SWORD = ItemType.of(Key.key("iron_sword"));

    /**
     * The minecraft:iron_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType IRON_TRAPDOOR = ItemType.of(Key.key("iron_trapdoor"));

    /**
     * The minecraft:item_frame item type.
     *
     * @since 0.1
     */
    ItemType ITEM_FRAME = ItemType.of(Key.key("item_frame"));

    /**
     * The minecraft:jack_o_lantern item type.
     *
     * @since 0.1
     */
    ItemType JACK_O_LANTERN = ItemType.of(Key.key("jack_o_lantern"));

    /**
     * The minecraft:jigsaw item type.
     *
     * @since 0.1
     */
    ItemType JIGSAW = ItemType.of(Key.key("jigsaw"));

    /**
     * The minecraft:jukebox item type.
     *
     * @since 0.1
     */
    ItemType JUKEBOX = ItemType.of(Key.key("jukebox"));

    /**
     * The minecraft:jungle_boat item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_BOAT = ItemType.of(Key.key("jungle_boat"));

    /**
     * The minecraft:jungle_button item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_BUTTON = ItemType.of(Key.key("jungle_button"));

    /**
     * The minecraft:jungle_door item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_DOOR = ItemType.of(Key.key("jungle_door"));

    /**
     * The minecraft:jungle_fence item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_FENCE = ItemType.of(Key.key("jungle_fence"));

    /**
     * The minecraft:jungle_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_FENCE_GATE = ItemType.of(Key.key("jungle_fence_gate"));

    /**
     * The minecraft:jungle_leaves item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_LEAVES = ItemType.of(Key.key("jungle_leaves"));

    /**
     * The minecraft:jungle_log item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_LOG = ItemType.of(Key.key("jungle_log"));

    /**
     * The minecraft:jungle_planks item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_PLANKS = ItemType.of(Key.key("jungle_planks"));

    /**
     * The minecraft:jungle_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_PRESSURE_PLATE = ItemType.of(Key.key("jungle_pressure_plate"));

    /**
     * The minecraft:jungle_sapling item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_SAPLING = ItemType.of(Key.key("jungle_sapling"));

    /**
     * The minecraft:jungle_sign item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_SIGN = ItemType.of(Key.key("jungle_sign"));

    /**
     * The minecraft:jungle_slab item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_SLAB = ItemType.of(Key.key("jungle_slab"));

    /**
     * The minecraft:jungle_stairs item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_STAIRS = ItemType.of(Key.key("jungle_stairs"));

    /**
     * The minecraft:jungle_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_TRAPDOOR = ItemType.of(Key.key("jungle_trapdoor"));

    /**
     * The minecraft:jungle_wood item type.
     *
     * @since 0.1
     */
    ItemType JUNGLE_WOOD = ItemType.of(Key.key("jungle_wood"));

    /**
     * The minecraft:kelp item type.
     *
     * @since 0.1
     */
    ItemType KELP = ItemType.of(Key.key("kelp"));

    /**
     * The minecraft:knowledge_book item type.
     *
     * @since 0.1
     */
    ItemType KNOWLEDGE_BOOK = ItemType.of(Key.key("knowledge_book"));

    /**
     * The minecraft:ladder item type.
     *
     * @since 0.1
     */
    ItemType LADDER = ItemType.of(Key.key("ladder"));

    /**
     * The minecraft:lantern item type.
     *
     * @since 0.1
     */
    ItemType LANTERN = ItemType.of(Key.key("lantern"));

    /**
     * The minecraft:lapis_block item type.
     *
     * @since 0.1
     */
    ItemType LAPIS_BLOCK = ItemType.of(Key.key("lapis_block"));

    /**
     * The minecraft:lapis_lazuli item type.
     *
     * @since 0.1
     */
    ItemType LAPIS_LAZULI = ItemType.of(Key.key("lapis_lazuli"));

    /**
     * The minecraft:lapis_ore item type.
     *
     * @since 0.1
     */
    ItemType LAPIS_ORE = ItemType.of(Key.key("lapis_ore"));

    /**
     * The minecraft:large_amethyst_bud item type.
     *
     * @since 0.1
     */
    ItemType LARGE_AMETHYST_BUD = ItemType.of(Key.key("large_amethyst_bud"));

    /**
     * The minecraft:large_fern item type.
     *
     * @since 0.1
     */
    ItemType LARGE_FERN = ItemType.of(Key.key("large_fern"));

    /**
     * The minecraft:lava_bucket item type.
     *
     * @since 0.1
     */
    ItemType LAVA_BUCKET = ItemType.of(Key.key("lava_bucket"));

    /**
     * The minecraft:lead item type.
     *
     * @since 0.1
     */
    ItemType LEAD = ItemType.of(Key.key("lead"));

    /**
     * The minecraft:leather item type.
     *
     * @since 0.1
     */
    ItemType LEATHER = ItemType.of(Key.key("leather"));

    /**
     * The minecraft:leather_boots item type.
     *
     * @since 0.1
     */
    ItemType LEATHER_BOOTS = ItemType.of(Key.key("leather_boots"));

    /**
     * The minecraft:leather_chestplate item type.
     *
     * @since 0.1
     */
    ItemType LEATHER_CHESTPLATE = ItemType.of(Key.key("leather_chestplate"));

    /**
     * The minecraft:leather_helmet item type.
     *
     * @since 0.1
     */
    ItemType LEATHER_HELMET = ItemType.of(Key.key("leather_helmet"));

    /**
     * The minecraft:leather_horse_armor item type.
     *
     * @since 0.1
     */
    ItemType LEATHER_HORSE_ARMOR = ItemType.of(Key.key("leather_horse_armor"));

    /**
     * The minecraft:leather_leggings item type.
     *
     * @since 0.1
     */
    ItemType LEATHER_LEGGINGS = ItemType.of(Key.key("leather_leggings"));

    /**
     * The minecraft:lectern item type.
     *
     * @since 0.1
     */
    ItemType LECTERN = ItemType.of(Key.key("lectern"));

    /**
     * The minecraft:lever item type.
     *
     * @since 0.1
     */
    ItemType LEVER = ItemType.of(Key.key("lever"));

    /**
     * The minecraft:light item type.
     *
     * @since 0.1
     */
    ItemType LIGHT = ItemType.of(Key.key("light"));

    /**
     * The minecraft:light_blue_banner item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_BANNER = ItemType.of(Key.key("light_blue_banner"));

    /**
     * The minecraft:light_blue_bed item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_BED = ItemType.of(Key.key("light_blue_bed"));

    /**
     * The minecraft:light_blue_candle item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_CANDLE = ItemType.of(Key.key("light_blue_candle"));

    /**
     * The minecraft:light_blue_carpet item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_CARPET = ItemType.of(Key.key("light_blue_carpet"));

    /**
     * The minecraft:light_blue_concrete item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_CONCRETE = ItemType.of(Key.key("light_blue_concrete"));

    /**
     * The minecraft:light_blue_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_CONCRETE_POWDER = ItemType.of(Key.key("light_blue_concrete_powder"));

    /**
     * The minecraft:light_blue_dye item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_DYE = ItemType.of(Key.key("light_blue_dye"));

    /**
     * The minecraft:light_blue_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_GLAZED_TERRACOTTA = ItemType.of(Key.key("light_blue_glazed_terracotta"));

    /**
     * The minecraft:light_blue_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_SHULKER_BOX = ItemType.of(Key.key("light_blue_shulker_box"));

    /**
     * The minecraft:light_blue_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_STAINED_GLASS = ItemType.of(Key.key("light_blue_stained_glass"));

    /**
     * The minecraft:light_blue_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_STAINED_GLASS_PANE = ItemType.of(Key.key("light_blue_stained_glass_pane"));

    /**
     * The minecraft:light_blue_terracotta item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_TERRACOTTA = ItemType.of(Key.key("light_blue_terracotta"));

    /**
     * The minecraft:light_blue_wool item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_BLUE_WOOL = ItemType.of(Key.key("light_blue_wool"));

    /**
     * The minecraft:light_gray_banner item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_BANNER = ItemType.of(Key.key("light_gray_banner"));

    /**
     * The minecraft:light_gray_bed item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_BED = ItemType.of(Key.key("light_gray_bed"));

    /**
     * The minecraft:light_gray_candle item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_CANDLE = ItemType.of(Key.key("light_gray_candle"));

    /**
     * The minecraft:light_gray_carpet item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_CARPET = ItemType.of(Key.key("light_gray_carpet"));

    /**
     * The minecraft:light_gray_concrete item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_CONCRETE = ItemType.of(Key.key("light_gray_concrete"));

    /**
     * The minecraft:light_gray_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_CONCRETE_POWDER = ItemType.of(Key.key("light_gray_concrete_powder"));

    /**
     * The minecraft:light_gray_dye item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_DYE = ItemType.of(Key.key("light_gray_dye"));

    /**
     * The minecraft:light_gray_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_GLAZED_TERRACOTTA = ItemType.of(Key.key("light_gray_glazed_terracotta"));

    /**
     * The minecraft:light_gray_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_SHULKER_BOX = ItemType.of(Key.key("light_gray_shulker_box"));

    /**
     * The minecraft:light_gray_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_STAINED_GLASS = ItemType.of(Key.key("light_gray_stained_glass"));

    /**
     * The minecraft:light_gray_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_STAINED_GLASS_PANE = ItemType.of(Key.key("light_gray_stained_glass_pane"));

    /**
     * The minecraft:light_gray_terracotta item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_TERRACOTTA = ItemType.of(Key.key("light_gray_terracotta"));

    /**
     * The minecraft:light_gray_wool item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_GRAY_WOOL = ItemType.of(Key.key("light_gray_wool"));

    /**
     * The minecraft:light_weighted_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType LIGHT_WEIGHTED_PRESSURE_PLATE = ItemType.of(Key.key("light_weighted_pressure_plate"));

    /**
     * The minecraft:lightning_rod item type.
     *
     * @since 0.1
     */
    ItemType LIGHTNING_ROD = ItemType.of(Key.key("lightning_rod"));

    /**
     * The minecraft:lilac item type.
     *
     * @since 0.1
     */
    ItemType LILAC = ItemType.of(Key.key("lilac"));

    /**
     * The minecraft:lily_of_the_valley item type.
     *
     * @since 0.1
     */
    ItemType LILY_OF_THE_VALLEY = ItemType.of(Key.key("lily_of_the_valley"));

    /**
     * The minecraft:lily_pad item type.
     *
     * @since 0.1
     */
    ItemType LILY_PAD = ItemType.of(Key.key("lily_pad"));

    /**
     * The minecraft:lime_banner item type.
     *
     * @since 0.1
     */
    ItemType LIME_BANNER = ItemType.of(Key.key("lime_banner"));

    /**
     * The minecraft:lime_bed item type.
     *
     * @since 0.1
     */
    ItemType LIME_BED = ItemType.of(Key.key("lime_bed"));

    /**
     * The minecraft:lime_candle item type.
     *
     * @since 0.1
     */
    ItemType LIME_CANDLE = ItemType.of(Key.key("lime_candle"));

    /**
     * The minecraft:lime_carpet item type.
     *
     * @since 0.1
     */
    ItemType LIME_CARPET = ItemType.of(Key.key("lime_carpet"));

    /**
     * The minecraft:lime_concrete item type.
     *
     * @since 0.1
     */
    ItemType LIME_CONCRETE = ItemType.of(Key.key("lime_concrete"));

    /**
     * The minecraft:lime_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType LIME_CONCRETE_POWDER = ItemType.of(Key.key("lime_concrete_powder"));

    /**
     * The minecraft:lime_dye item type.
     *
     * @since 0.1
     */
    ItemType LIME_DYE = ItemType.of(Key.key("lime_dye"));

    /**
     * The minecraft:lime_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType LIME_GLAZED_TERRACOTTA = ItemType.of(Key.key("lime_glazed_terracotta"));

    /**
     * The minecraft:lime_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType LIME_SHULKER_BOX = ItemType.of(Key.key("lime_shulker_box"));

    /**
     * The minecraft:lime_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType LIME_STAINED_GLASS = ItemType.of(Key.key("lime_stained_glass"));

    /**
     * The minecraft:lime_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType LIME_STAINED_GLASS_PANE = ItemType.of(Key.key("lime_stained_glass_pane"));

    /**
     * The minecraft:lime_terracotta item type.
     *
     * @since 0.1
     */
    ItemType LIME_TERRACOTTA = ItemType.of(Key.key("lime_terracotta"));

    /**
     * The minecraft:lime_wool item type.
     *
     * @since 0.1
     */
    ItemType LIME_WOOL = ItemType.of(Key.key("lime_wool"));

    /**
     * The minecraft:lingering_potion item type.
     *
     * @since 0.1
     */
    ItemType LINGERING_POTION = ItemType.of(Key.key("lingering_potion"));

    /**
     * The minecraft:llama_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType LLAMA_SPAWN_EGG = ItemType.of(Key.key("llama_spawn_egg"));

    /**
     * The minecraft:lodestone item type.
     *
     * @since 0.1
     */
    ItemType LODESTONE = ItemType.of(Key.key("lodestone"));

    /**
     * The minecraft:loom item type.
     *
     * @since 0.1
     */
    ItemType LOOM = ItemType.of(Key.key("loom"));

    /**
     * The minecraft:magenta_banner item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_BANNER = ItemType.of(Key.key("magenta_banner"));

    /**
     * The minecraft:magenta_bed item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_BED = ItemType.of(Key.key("magenta_bed"));

    /**
     * The minecraft:magenta_candle item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_CANDLE = ItemType.of(Key.key("magenta_candle"));

    /**
     * The minecraft:magenta_carpet item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_CARPET = ItemType.of(Key.key("magenta_carpet"));

    /**
     * The minecraft:magenta_concrete item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_CONCRETE = ItemType.of(Key.key("magenta_concrete"));

    /**
     * The minecraft:magenta_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_CONCRETE_POWDER = ItemType.of(Key.key("magenta_concrete_powder"));

    /**
     * The minecraft:magenta_dye item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_DYE = ItemType.of(Key.key("magenta_dye"));

    /**
     * The minecraft:magenta_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_GLAZED_TERRACOTTA = ItemType.of(Key.key("magenta_glazed_terracotta"));

    /**
     * The minecraft:magenta_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_SHULKER_BOX = ItemType.of(Key.key("magenta_shulker_box"));

    /**
     * The minecraft:magenta_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_STAINED_GLASS = ItemType.of(Key.key("magenta_stained_glass"));

    /**
     * The minecraft:magenta_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_STAINED_GLASS_PANE = ItemType.of(Key.key("magenta_stained_glass_pane"));

    /**
     * The minecraft:magenta_terracotta item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_TERRACOTTA = ItemType.of(Key.key("magenta_terracotta"));

    /**
     * The minecraft:magenta_wool item type.
     *
     * @since 0.1
     */
    ItemType MAGENTA_WOOL = ItemType.of(Key.key("magenta_wool"));

    /**
     * The minecraft:magma_block item type.
     *
     * @since 0.1
     */
    ItemType MAGMA_BLOCK = ItemType.of(Key.key("magma_block"));

    /**
     * The minecraft:magma_cream item type.
     *
     * @since 0.1
     */
    ItemType MAGMA_CREAM = ItemType.of(Key.key("magma_cream"));

    /**
     * The minecraft:magma_cube_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType MAGMA_CUBE_SPAWN_EGG = ItemType.of(Key.key("magma_cube_spawn_egg"));

    /**
     * The minecraft:map item type.
     *
     * @since 0.1
     */
    ItemType MAP = ItemType.of(Key.key("map"));

    /**
     * The minecraft:medium_amethyst_bud item type.
     *
     * @since 0.1
     */
    ItemType MEDIUM_AMETHYST_BUD = ItemType.of(Key.key("medium_amethyst_bud"));

    /**
     * The minecraft:melon item type.
     *
     * @since 0.1
     */
    ItemType MELON = ItemType.of(Key.key("melon"));

    /**
     * The minecraft:melon_seeds item type.
     *
     * @since 0.1
     */
    ItemType MELON_SEEDS = ItemType.of(Key.key("melon_seeds"));

    /**
     * The minecraft:melon_slice item type.
     *
     * @since 0.1
     */
    ItemType MELON_SLICE = ItemType.of(Key.key("melon_slice"));

    /**
     * The minecraft:milk_bucket item type.
     *
     * @since 0.1
     */
    ItemType MILK_BUCKET = ItemType.of(Key.key("milk_bucket"));

    /**
     * The minecraft:minecart item type.
     *
     * @since 0.1
     */
    ItemType MINECART = ItemType.of(Key.key("minecart"));

    /**
     * The minecraft:mojang_banner_pattern item type.
     *
     * @since 0.1
     */
    ItemType MOJANG_BANNER_PATTERN = ItemType.of(Key.key("mojang_banner_pattern"));

    /**
     * The minecraft:mooshroom_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType MOOSHROOM_SPAWN_EGG = ItemType.of(Key.key("mooshroom_spawn_egg"));

    /**
     * The minecraft:moss_block item type.
     *
     * @since 0.1
     */
    ItemType MOSS_BLOCK = ItemType.of(Key.key("moss_block"));

    /**
     * The minecraft:moss_carpet item type.
     *
     * @since 0.1
     */
    ItemType MOSS_CARPET = ItemType.of(Key.key("moss_carpet"));

    /**
     * The minecraft:mossy_cobblestone item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_COBBLESTONE = ItemType.of(Key.key("mossy_cobblestone"));

    /**
     * The minecraft:mossy_cobblestone_slab item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_COBBLESTONE_SLAB = ItemType.of(Key.key("mossy_cobblestone_slab"));

    /**
     * The minecraft:mossy_cobblestone_stairs item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_COBBLESTONE_STAIRS = ItemType.of(Key.key("mossy_cobblestone_stairs"));

    /**
     * The minecraft:mossy_cobblestone_wall item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_COBBLESTONE_WALL = ItemType.of(Key.key("mossy_cobblestone_wall"));

    /**
     * The minecraft:mossy_stone_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_STONE_BRICK_SLAB = ItemType.of(Key.key("mossy_stone_brick_slab"));

    /**
     * The minecraft:mossy_stone_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_STONE_BRICK_STAIRS = ItemType.of(Key.key("mossy_stone_brick_stairs"));

    /**
     * The minecraft:mossy_stone_brick_wall item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_STONE_BRICK_WALL = ItemType.of(Key.key("mossy_stone_brick_wall"));

    /**
     * The minecraft:mossy_stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType MOSSY_STONE_BRICKS = ItemType.of(Key.key("mossy_stone_bricks"));

    /**
     * The minecraft:mule_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType MULE_SPAWN_EGG = ItemType.of(Key.key("mule_spawn_egg"));

    /**
     * The minecraft:mushroom_stem item type.
     *
     * @since 0.1
     */
    ItemType MUSHROOM_STEM = ItemType.of(Key.key("mushroom_stem"));

    /**
     * The minecraft:mushroom_stew item type.
     *
     * @since 0.1
     */
    ItemType MUSHROOM_STEW = ItemType.of(Key.key("mushroom_stew"));

    /**
     * The minecraft:music_disc_11 item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_11 = ItemType.of(Key.key("music_disc_11"));

    /**
     * The minecraft:music_disc_13 item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_13 = ItemType.of(Key.key("music_disc_13"));

    /**
     * The minecraft:music_disc_blocks item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_BLOCKS = ItemType.of(Key.key("music_disc_blocks"));

    /**
     * The minecraft:music_disc_cat item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_CAT = ItemType.of(Key.key("music_disc_cat"));

    /**
     * The minecraft:music_disc_chirp item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_CHIRP = ItemType.of(Key.key("music_disc_chirp"));

    /**
     * The minecraft:music_disc_far item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_FAR = ItemType.of(Key.key("music_disc_far"));

    /**
     * The minecraft:music_disc_mall item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_MALL = ItemType.of(Key.key("music_disc_mall"));

    /**
     * The minecraft:music_disc_mellohi item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_MELLOHI = ItemType.of(Key.key("music_disc_mellohi"));

    /**
     * The minecraft:music_disc_otherside item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_OTHERSIDE = ItemType.of(Key.key("music_disc_otherside"));

    /**
     * The minecraft:music_disc_pigstep item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_PIGSTEP = ItemType.of(Key.key("music_disc_pigstep"));

    /**
     * The minecraft:music_disc_stal item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_STAL = ItemType.of(Key.key("music_disc_stal"));

    /**
     * The minecraft:music_disc_strad item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_STRAD = ItemType.of(Key.key("music_disc_strad"));

    /**
     * The minecraft:music_disc_wait item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_WAIT = ItemType.of(Key.key("music_disc_wait"));

    /**
     * The minecraft:music_disc_ward item type.
     *
     * @since 0.1
     */
    ItemType MUSIC_DISC_WARD = ItemType.of(Key.key("music_disc_ward"));

    /**
     * The minecraft:mutton item type.
     *
     * @since 0.1
     */
    ItemType MUTTON = ItemType.of(Key.key("mutton"));

    /**
     * The minecraft:mycelium item type.
     *
     * @since 0.1
     */
    ItemType MYCELIUM = ItemType.of(Key.key("mycelium"));

    /**
     * The minecraft:name_tag item type.
     *
     * @since 0.1
     */
    ItemType NAME_TAG = ItemType.of(Key.key("name_tag"));

    /**
     * The minecraft:nautilus_shell item type.
     *
     * @since 0.1
     */
    ItemType NAUTILUS_SHELL = ItemType.of(Key.key("nautilus_shell"));

    /**
     * The minecraft:nether_brick item type.
     *
     * @since 0.1
     */
    ItemType NETHER_BRICK = ItemType.of(Key.key("nether_brick"));

    /**
     * The minecraft:nether_brick_fence item type.
     *
     * @since 0.1
     */
    ItemType NETHER_BRICK_FENCE = ItemType.of(Key.key("nether_brick_fence"));

    /**
     * The minecraft:nether_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType NETHER_BRICK_SLAB = ItemType.of(Key.key("nether_brick_slab"));

    /**
     * The minecraft:nether_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType NETHER_BRICK_STAIRS = ItemType.of(Key.key("nether_brick_stairs"));

    /**
     * The minecraft:nether_brick_wall item type.
     *
     * @since 0.1
     */
    ItemType NETHER_BRICK_WALL = ItemType.of(Key.key("nether_brick_wall"));

    /**
     * The minecraft:nether_bricks item type.
     *
     * @since 0.1
     */
    ItemType NETHER_BRICKS = ItemType.of(Key.key("nether_bricks"));

    /**
     * The minecraft:nether_gold_ore item type.
     *
     * @since 0.1
     */
    ItemType NETHER_GOLD_ORE = ItemType.of(Key.key("nether_gold_ore"));

    /**
     * The minecraft:nether_quartz_ore item type.
     *
     * @since 0.1
     */
    ItemType NETHER_QUARTZ_ORE = ItemType.of(Key.key("nether_quartz_ore"));

    /**
     * The minecraft:nether_sprouts item type.
     *
     * @since 0.1
     */
    ItemType NETHER_SPROUTS = ItemType.of(Key.key("nether_sprouts"));

    /**
     * The minecraft:nether_star item type.
     *
     * @since 0.1
     */
    ItemType NETHER_STAR = ItemType.of(Key.key("nether_star"));

    /**
     * The minecraft:nether_wart item type.
     *
     * @since 0.1
     */
    ItemType NETHER_WART = ItemType.of(Key.key("nether_wart"));

    /**
     * The minecraft:nether_wart_block item type.
     *
     * @since 0.1
     */
    ItemType NETHER_WART_BLOCK = ItemType.of(Key.key("nether_wart_block"));

    /**
     * The minecraft:netherite_axe item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_AXE = ItemType.of(Key.key("netherite_axe"));

    /**
     * The minecraft:netherite_block item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_BLOCK = ItemType.of(Key.key("netherite_block"));

    /**
     * The minecraft:netherite_boots item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_BOOTS = ItemType.of(Key.key("netherite_boots"));

    /**
     * The minecraft:netherite_chestplate item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_CHESTPLATE = ItemType.of(Key.key("netherite_chestplate"));

    /**
     * The minecraft:netherite_helmet item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_HELMET = ItemType.of(Key.key("netherite_helmet"));

    /**
     * The minecraft:netherite_hoe item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_HOE = ItemType.of(Key.key("netherite_hoe"));

    /**
     * The minecraft:netherite_ingot item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_INGOT = ItemType.of(Key.key("netherite_ingot"));

    /**
     * The minecraft:netherite_leggings item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_LEGGINGS = ItemType.of(Key.key("netherite_leggings"));

    /**
     * The minecraft:netherite_pickaxe item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_PICKAXE = ItemType.of(Key.key("netherite_pickaxe"));

    /**
     * The minecraft:netherite_scrap item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_SCRAP = ItemType.of(Key.key("netherite_scrap"));

    /**
     * The minecraft:netherite_shovel item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_SHOVEL = ItemType.of(Key.key("netherite_shovel"));

    /**
     * The minecraft:netherite_sword item type.
     *
     * @since 0.1
     */
    ItemType NETHERITE_SWORD = ItemType.of(Key.key("netherite_sword"));

    /**
     * The minecraft:netherrack item type.
     *
     * @since 0.1
     */
    ItemType NETHERRACK = ItemType.of(Key.key("netherrack"));

    /**
     * The minecraft:note_block item type.
     *
     * @since 0.1
     */
    ItemType NOTE_BLOCK = ItemType.of(Key.key("note_block"));

    /**
     * The minecraft:oak_boat item type.
     *
     * @since 0.1
     */
    ItemType OAK_BOAT = ItemType.of(Key.key("oak_boat"));

    /**
     * The minecraft:oak_button item type.
     *
     * @since 0.1
     */
    ItemType OAK_BUTTON = ItemType.of(Key.key("oak_button"));

    /**
     * The minecraft:oak_door item type.
     *
     * @since 0.1
     */
    ItemType OAK_DOOR = ItemType.of(Key.key("oak_door"));

    /**
     * The minecraft:oak_fence item type.
     *
     * @since 0.1
     */
    ItemType OAK_FENCE = ItemType.of(Key.key("oak_fence"));

    /**
     * The minecraft:oak_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType OAK_FENCE_GATE = ItemType.of(Key.key("oak_fence_gate"));

    /**
     * The minecraft:oak_leaves item type.
     *
     * @since 0.1
     */
    ItemType OAK_LEAVES = ItemType.of(Key.key("oak_leaves"));

    /**
     * The minecraft:oak_log item type.
     *
     * @since 0.1
     */
    ItemType OAK_LOG = ItemType.of(Key.key("oak_log"));

    /**
     * The minecraft:oak_planks item type.
     *
     * @since 0.1
     */
    ItemType OAK_PLANKS = ItemType.of(Key.key("oak_planks"));

    /**
     * The minecraft:oak_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType OAK_PRESSURE_PLATE = ItemType.of(Key.key("oak_pressure_plate"));

    /**
     * The minecraft:oak_sapling item type.
     *
     * @since 0.1
     */
    ItemType OAK_SAPLING = ItemType.of(Key.key("oak_sapling"));

    /**
     * The minecraft:oak_sign item type.
     *
     * @since 0.1
     */
    ItemType OAK_SIGN = ItemType.of(Key.key("oak_sign"));

    /**
     * The minecraft:oak_slab item type.
     *
     * @since 0.1
     */
    ItemType OAK_SLAB = ItemType.of(Key.key("oak_slab"));

    /**
     * The minecraft:oak_stairs item type.
     *
     * @since 0.1
     */
    ItemType OAK_STAIRS = ItemType.of(Key.key("oak_stairs"));

    /**
     * The minecraft:oak_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType OAK_TRAPDOOR = ItemType.of(Key.key("oak_trapdoor"));

    /**
     * The minecraft:oak_wood item type.
     *
     * @since 0.1
     */
    ItemType OAK_WOOD = ItemType.of(Key.key("oak_wood"));

    /**
     * The minecraft:observer item type.
     *
     * @since 0.1
     */
    ItemType OBSERVER = ItemType.of(Key.key("observer"));

    /**
     * The minecraft:obsidian item type.
     *
     * @since 0.1
     */
    ItemType OBSIDIAN = ItemType.of(Key.key("obsidian"));

    /**
     * The minecraft:ocelot_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType OCELOT_SPAWN_EGG = ItemType.of(Key.key("ocelot_spawn_egg"));

    /**
     * The minecraft:orange_banner item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_BANNER = ItemType.of(Key.key("orange_banner"));

    /**
     * The minecraft:orange_bed item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_BED = ItemType.of(Key.key("orange_bed"));

    /**
     * The minecraft:orange_candle item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_CANDLE = ItemType.of(Key.key("orange_candle"));

    /**
     * The minecraft:orange_carpet item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_CARPET = ItemType.of(Key.key("orange_carpet"));

    /**
     * The minecraft:orange_concrete item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_CONCRETE = ItemType.of(Key.key("orange_concrete"));

    /**
     * The minecraft:orange_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_CONCRETE_POWDER = ItemType.of(Key.key("orange_concrete_powder"));

    /**
     * The minecraft:orange_dye item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_DYE = ItemType.of(Key.key("orange_dye"));

    /**
     * The minecraft:orange_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_GLAZED_TERRACOTTA = ItemType.of(Key.key("orange_glazed_terracotta"));

    /**
     * The minecraft:orange_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_SHULKER_BOX = ItemType.of(Key.key("orange_shulker_box"));

    /**
     * The minecraft:orange_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_STAINED_GLASS = ItemType.of(Key.key("orange_stained_glass"));

    /**
     * The minecraft:orange_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_STAINED_GLASS_PANE = ItemType.of(Key.key("orange_stained_glass_pane"));

    /**
     * The minecraft:orange_terracotta item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_TERRACOTTA = ItemType.of(Key.key("orange_terracotta"));

    /**
     * The minecraft:orange_tulip item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_TULIP = ItemType.of(Key.key("orange_tulip"));

    /**
     * The minecraft:orange_wool item type.
     *
     * @since 0.1
     */
    ItemType ORANGE_WOOL = ItemType.of(Key.key("orange_wool"));

    /**
     * The minecraft:oxeye_daisy item type.
     *
     * @since 0.1
     */
    ItemType OXEYE_DAISY = ItemType.of(Key.key("oxeye_daisy"));

    /**
     * The minecraft:oxidized_copper item type.
     *
     * @since 0.1
     */
    ItemType OXIDIZED_COPPER = ItemType.of(Key.key("oxidized_copper"));

    /**
     * The minecraft:oxidized_cut_copper item type.
     *
     * @since 0.1
     */
    ItemType OXIDIZED_CUT_COPPER = ItemType.of(Key.key("oxidized_cut_copper"));

    /**
     * The minecraft:oxidized_cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType OXIDIZED_CUT_COPPER_SLAB = ItemType.of(Key.key("oxidized_cut_copper_slab"));

    /**
     * The minecraft:oxidized_cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType OXIDIZED_CUT_COPPER_STAIRS = ItemType.of(Key.key("oxidized_cut_copper_stairs"));

    /**
     * The minecraft:packed_ice item type.
     *
     * @since 0.1
     */
    ItemType PACKED_ICE = ItemType.of(Key.key("packed_ice"));

    /**
     * The minecraft:painting item type.
     *
     * @since 0.1
     */
    ItemType PAINTING = ItemType.of(Key.key("painting"));

    /**
     * The minecraft:panda_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PANDA_SPAWN_EGG = ItemType.of(Key.key("panda_spawn_egg"));

    /**
     * The minecraft:paper item type.
     *
     * @since 0.1
     */
    ItemType PAPER = ItemType.of(Key.key("paper"));

    /**
     * The minecraft:parrot_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PARROT_SPAWN_EGG = ItemType.of(Key.key("parrot_spawn_egg"));

    /**
     * The minecraft:peony item type.
     *
     * @since 0.1
     */
    ItemType PEONY = ItemType.of(Key.key("peony"));

    /**
     * The minecraft:petrified_oak_slab item type.
     *
     * @since 0.1
     */
    ItemType PETRIFIED_OAK_SLAB = ItemType.of(Key.key("petrified_oak_slab"));

    /**
     * The minecraft:phantom_membrane item type.
     *
     * @since 0.1
     */
    ItemType PHANTOM_MEMBRANE = ItemType.of(Key.key("phantom_membrane"));

    /**
     * The minecraft:phantom_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PHANTOM_SPAWN_EGG = ItemType.of(Key.key("phantom_spawn_egg"));

    /**
     * The minecraft:pig_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PIG_SPAWN_EGG = ItemType.of(Key.key("pig_spawn_egg"));

    /**
     * The minecraft:piglin_banner_pattern item type.
     *
     * @since 0.1
     */
    ItemType PIGLIN_BANNER_PATTERN = ItemType.of(Key.key("piglin_banner_pattern"));

    /**
     * The minecraft:piglin_brute_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PIGLIN_BRUTE_SPAWN_EGG = ItemType.of(Key.key("piglin_brute_spawn_egg"));

    /**
     * The minecraft:piglin_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PIGLIN_SPAWN_EGG = ItemType.of(Key.key("piglin_spawn_egg"));

    /**
     * The minecraft:pillager_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PILLAGER_SPAWN_EGG = ItemType.of(Key.key("pillager_spawn_egg"));

    /**
     * The minecraft:pink_banner item type.
     *
     * @since 0.1
     */
    ItemType PINK_BANNER = ItemType.of(Key.key("pink_banner"));

    /**
     * The minecraft:pink_bed item type.
     *
     * @since 0.1
     */
    ItemType PINK_BED = ItemType.of(Key.key("pink_bed"));

    /**
     * The minecraft:pink_candle item type.
     *
     * @since 0.1
     */
    ItemType PINK_CANDLE = ItemType.of(Key.key("pink_candle"));

    /**
     * The minecraft:pink_carpet item type.
     *
     * @since 0.1
     */
    ItemType PINK_CARPET = ItemType.of(Key.key("pink_carpet"));

    /**
     * The minecraft:pink_concrete item type.
     *
     * @since 0.1
     */
    ItemType PINK_CONCRETE = ItemType.of(Key.key("pink_concrete"));

    /**
     * The minecraft:pink_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType PINK_CONCRETE_POWDER = ItemType.of(Key.key("pink_concrete_powder"));

    /**
     * The minecraft:pink_dye item type.
     *
     * @since 0.1
     */
    ItemType PINK_DYE = ItemType.of(Key.key("pink_dye"));

    /**
     * The minecraft:pink_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType PINK_GLAZED_TERRACOTTA = ItemType.of(Key.key("pink_glazed_terracotta"));

    /**
     * The minecraft:pink_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType PINK_SHULKER_BOX = ItemType.of(Key.key("pink_shulker_box"));

    /**
     * The minecraft:pink_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType PINK_STAINED_GLASS = ItemType.of(Key.key("pink_stained_glass"));

    /**
     * The minecraft:pink_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType PINK_STAINED_GLASS_PANE = ItemType.of(Key.key("pink_stained_glass_pane"));

    /**
     * The minecraft:pink_terracotta item type.
     *
     * @since 0.1
     */
    ItemType PINK_TERRACOTTA = ItemType.of(Key.key("pink_terracotta"));

    /**
     * The minecraft:pink_tulip item type.
     *
     * @since 0.1
     */
    ItemType PINK_TULIP = ItemType.of(Key.key("pink_tulip"));

    /**
     * The minecraft:pink_wool item type.
     *
     * @since 0.1
     */
    ItemType PINK_WOOL = ItemType.of(Key.key("pink_wool"));

    /**
     * The minecraft:piston item type.
     *
     * @since 0.1
     */
    ItemType PISTON = ItemType.of(Key.key("piston"));

    /**
     * The minecraft:player_head item type.
     *
     * @since 0.1
     */
    ItemType PLAYER_HEAD = ItemType.of(Key.key("player_head"));

    /**
     * The minecraft:podzol item type.
     *
     * @since 0.1
     */
    ItemType PODZOL = ItemType.of(Key.key("podzol"));

    /**
     * The minecraft:pointed_dripstone item type.
     *
     * @since 0.1
     */
    ItemType POINTED_DRIPSTONE = ItemType.of(Key.key("pointed_dripstone"));

    /**
     * The minecraft:poisonous_potato item type.
     *
     * @since 0.1
     */
    ItemType POISONOUS_POTATO = ItemType.of(Key.key("poisonous_potato"));

    /**
     * The minecraft:polar_bear_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType POLAR_BEAR_SPAWN_EGG = ItemType.of(Key.key("polar_bear_spawn_egg"));

    /**
     * The minecraft:polished_andesite item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_ANDESITE = ItemType.of(Key.key("polished_andesite"));

    /**
     * The minecraft:polished_andesite_slab item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_ANDESITE_SLAB = ItemType.of(Key.key("polished_andesite_slab"));

    /**
     * The minecraft:polished_andesite_stairs item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_ANDESITE_STAIRS = ItemType.of(Key.key("polished_andesite_stairs"));

    /**
     * The minecraft:polished_basalt item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BASALT = ItemType.of(Key.key("polished_basalt"));

    /**
     * The minecraft:polished_blackstone item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE = ItemType.of(Key.key("polished_blackstone"));

    /**
     * The minecraft:polished_blackstone_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_BRICK_SLAB = ItemType.of(Key.key("polished_blackstone_brick_slab"));

    /**
     * The minecraft:polished_blackstone_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_BRICK_STAIRS = ItemType.of(Key.key("polished_blackstone_brick_stairs"));

    /**
     * The minecraft:polished_blackstone_brick_wall item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_BRICK_WALL = ItemType.of(Key.key("polished_blackstone_brick_wall"));

    /**
     * The minecraft:polished_blackstone_bricks item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_BRICKS = ItemType.of(Key.key("polished_blackstone_bricks"));

    /**
     * The minecraft:polished_blackstone_button item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_BUTTON = ItemType.of(Key.key("polished_blackstone_button"));

    /**
     * The minecraft:polished_blackstone_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_PRESSURE_PLATE = ItemType.of(Key.key("polished_blackstone_pressure_plate"));

    /**
     * The minecraft:polished_blackstone_slab item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_SLAB = ItemType.of(Key.key("polished_blackstone_slab"));

    /**
     * The minecraft:polished_blackstone_stairs item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_STAIRS = ItemType.of(Key.key("polished_blackstone_stairs"));

    /**
     * The minecraft:polished_blackstone_wall item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_BLACKSTONE_WALL = ItemType.of(Key.key("polished_blackstone_wall"));

    /**
     * The minecraft:polished_deepslate item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_DEEPSLATE = ItemType.of(Key.key("polished_deepslate"));

    /**
     * The minecraft:polished_deepslate_slab item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_DEEPSLATE_SLAB = ItemType.of(Key.key("polished_deepslate_slab"));

    /**
     * The minecraft:polished_deepslate_stairs item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_DEEPSLATE_STAIRS = ItemType.of(Key.key("polished_deepslate_stairs"));

    /**
     * The minecraft:polished_deepslate_wall item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_DEEPSLATE_WALL = ItemType.of(Key.key("polished_deepslate_wall"));

    /**
     * The minecraft:polished_diorite item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_DIORITE = ItemType.of(Key.key("polished_diorite"));

    /**
     * The minecraft:polished_diorite_slab item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_DIORITE_SLAB = ItemType.of(Key.key("polished_diorite_slab"));

    /**
     * The minecraft:polished_diorite_stairs item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_DIORITE_STAIRS = ItemType.of(Key.key("polished_diorite_stairs"));

    /**
     * The minecraft:polished_granite item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_GRANITE = ItemType.of(Key.key("polished_granite"));

    /**
     * The minecraft:polished_granite_slab item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_GRANITE_SLAB = ItemType.of(Key.key("polished_granite_slab"));

    /**
     * The minecraft:polished_granite_stairs item type.
     *
     * @since 0.1
     */
    ItemType POLISHED_GRANITE_STAIRS = ItemType.of(Key.key("polished_granite_stairs"));

    /**
     * The minecraft:popped_chorus_fruit item type.
     *
     * @since 0.1
     */
    ItemType POPPED_CHORUS_FRUIT = ItemType.of(Key.key("popped_chorus_fruit"));

    /**
     * The minecraft:poppy item type.
     *
     * @since 0.1
     */
    ItemType POPPY = ItemType.of(Key.key("poppy"));

    /**
     * The minecraft:porkchop item type.
     *
     * @since 0.1
     */
    ItemType PORKCHOP = ItemType.of(Key.key("porkchop"));

    /**
     * The minecraft:potato item type.
     *
     * @since 0.1
     */
    ItemType POTATO = ItemType.of(Key.key("potato"));

    /**
     * The minecraft:potion item type.
     *
     * @since 0.1
     */
    ItemType POTION = ItemType.of(Key.key("potion"));

    /**
     * The minecraft:powder_snow_bucket item type.
     *
     * @since 0.1
     */
    ItemType POWDER_SNOW_BUCKET = ItemType.of(Key.key("powder_snow_bucket"));

    /**
     * The minecraft:powered_rail item type.
     *
     * @since 0.1
     */
    ItemType POWERED_RAIL = ItemType.of(Key.key("powered_rail"));

    /**
     * The minecraft:prismarine item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE = ItemType.of(Key.key("prismarine"));

    /**
     * The minecraft:prismarine_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_BRICK_SLAB = ItemType.of(Key.key("prismarine_brick_slab"));

    /**
     * The minecraft:prismarine_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_BRICK_STAIRS = ItemType.of(Key.key("prismarine_brick_stairs"));

    /**
     * The minecraft:prismarine_bricks item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_BRICKS = ItemType.of(Key.key("prismarine_bricks"));

    /**
     * The minecraft:prismarine_crystals item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_CRYSTALS = ItemType.of(Key.key("prismarine_crystals"));

    /**
     * The minecraft:prismarine_shard item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_SHARD = ItemType.of(Key.key("prismarine_shard"));

    /**
     * The minecraft:prismarine_slab item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_SLAB = ItemType.of(Key.key("prismarine_slab"));

    /**
     * The minecraft:prismarine_stairs item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_STAIRS = ItemType.of(Key.key("prismarine_stairs"));

    /**
     * The minecraft:prismarine_wall item type.
     *
     * @since 0.1
     */
    ItemType PRISMARINE_WALL = ItemType.of(Key.key("prismarine_wall"));

    /**
     * The minecraft:pufferfish item type.
     *
     * @since 0.1
     */
    ItemType PUFFERFISH = ItemType.of(Key.key("pufferfish"));

    /**
     * The minecraft:pufferfish_bucket item type.
     *
     * @since 0.1
     */
    ItemType PUFFERFISH_BUCKET = ItemType.of(Key.key("pufferfish_bucket"));

    /**
     * The minecraft:pufferfish_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType PUFFERFISH_SPAWN_EGG = ItemType.of(Key.key("pufferfish_spawn_egg"));

    /**
     * The minecraft:pumpkin item type.
     *
     * @since 0.1
     */
    ItemType PUMPKIN = ItemType.of(Key.key("pumpkin"));

    /**
     * The minecraft:pumpkin_pie item type.
     *
     * @since 0.1
     */
    ItemType PUMPKIN_PIE = ItemType.of(Key.key("pumpkin_pie"));

    /**
     * The minecraft:pumpkin_seeds item type.
     *
     * @since 0.1
     */
    ItemType PUMPKIN_SEEDS = ItemType.of(Key.key("pumpkin_seeds"));

    /**
     * The minecraft:purple_banner item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_BANNER = ItemType.of(Key.key("purple_banner"));

    /**
     * The minecraft:purple_bed item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_BED = ItemType.of(Key.key("purple_bed"));

    /**
     * The minecraft:purple_candle item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_CANDLE = ItemType.of(Key.key("purple_candle"));

    /**
     * The minecraft:purple_carpet item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_CARPET = ItemType.of(Key.key("purple_carpet"));

    /**
     * The minecraft:purple_concrete item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_CONCRETE = ItemType.of(Key.key("purple_concrete"));

    /**
     * The minecraft:purple_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_CONCRETE_POWDER = ItemType.of(Key.key("purple_concrete_powder"));

    /**
     * The minecraft:purple_dye item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_DYE = ItemType.of(Key.key("purple_dye"));

    /**
     * The minecraft:purple_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_GLAZED_TERRACOTTA = ItemType.of(Key.key("purple_glazed_terracotta"));

    /**
     * The minecraft:purple_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_SHULKER_BOX = ItemType.of(Key.key("purple_shulker_box"));

    /**
     * The minecraft:purple_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_STAINED_GLASS = ItemType.of(Key.key("purple_stained_glass"));

    /**
     * The minecraft:purple_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_STAINED_GLASS_PANE = ItemType.of(Key.key("purple_stained_glass_pane"));

    /**
     * The minecraft:purple_terracotta item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_TERRACOTTA = ItemType.of(Key.key("purple_terracotta"));

    /**
     * The minecraft:purple_wool item type.
     *
     * @since 0.1
     */
    ItemType PURPLE_WOOL = ItemType.of(Key.key("purple_wool"));

    /**
     * The minecraft:purpur_block item type.
     *
     * @since 0.1
     */
    ItemType PURPUR_BLOCK = ItemType.of(Key.key("purpur_block"));

    /**
     * The minecraft:purpur_pillar item type.
     *
     * @since 0.1
     */
    ItemType PURPUR_PILLAR = ItemType.of(Key.key("purpur_pillar"));

    /**
     * The minecraft:purpur_slab item type.
     *
     * @since 0.1
     */
    ItemType PURPUR_SLAB = ItemType.of(Key.key("purpur_slab"));

    /**
     * The minecraft:purpur_stairs item type.
     *
     * @since 0.1
     */
    ItemType PURPUR_STAIRS = ItemType.of(Key.key("purpur_stairs"));

    /**
     * The minecraft:quartz item type.
     *
     * @since 0.1
     */
    ItemType QUARTZ = ItemType.of(Key.key("quartz"));

    /**
     * The minecraft:quartz_block item type.
     *
     * @since 0.1
     */
    ItemType QUARTZ_BLOCK = ItemType.of(Key.key("quartz_block"));

    /**
     * The minecraft:quartz_bricks item type.
     *
     * @since 0.1
     */
    ItemType QUARTZ_BRICKS = ItemType.of(Key.key("quartz_bricks"));

    /**
     * The minecraft:quartz_pillar item type.
     *
     * @since 0.1
     */
    ItemType QUARTZ_PILLAR = ItemType.of(Key.key("quartz_pillar"));

    /**
     * The minecraft:quartz_slab item type.
     *
     * @since 0.1
     */
    ItemType QUARTZ_SLAB = ItemType.of(Key.key("quartz_slab"));

    /**
     * The minecraft:quartz_stairs item type.
     *
     * @since 0.1
     */
    ItemType QUARTZ_STAIRS = ItemType.of(Key.key("quartz_stairs"));

    /**
     * The minecraft:rabbit item type.
     *
     * @since 0.1
     */
    ItemType RABBIT = ItemType.of(Key.key("rabbit"));

    /**
     * The minecraft:rabbit_foot item type.
     *
     * @since 0.1
     */
    ItemType RABBIT_FOOT = ItemType.of(Key.key("rabbit_foot"));

    /**
     * The minecraft:rabbit_hide item type.
     *
     * @since 0.1
     */
    ItemType RABBIT_HIDE = ItemType.of(Key.key("rabbit_hide"));

    /**
     * The minecraft:rabbit_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType RABBIT_SPAWN_EGG = ItemType.of(Key.key("rabbit_spawn_egg"));

    /**
     * The minecraft:rabbit_stew item type.
     *
     * @since 0.1
     */
    ItemType RABBIT_STEW = ItemType.of(Key.key("rabbit_stew"));

    /**
     * The minecraft:rail item type.
     *
     * @since 0.1
     */
    ItemType RAIL = ItemType.of(Key.key("rail"));

    /**
     * The minecraft:ravager_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType RAVAGER_SPAWN_EGG = ItemType.of(Key.key("ravager_spawn_egg"));

    /**
     * The minecraft:raw_copper item type.
     *
     * @since 0.1
     */
    ItemType RAW_COPPER = ItemType.of(Key.key("raw_copper"));

    /**
     * The minecraft:raw_copper_block item type.
     *
     * @since 0.1
     */
    ItemType RAW_COPPER_BLOCK = ItemType.of(Key.key("raw_copper_block"));

    /**
     * The minecraft:raw_gold item type.
     *
     * @since 0.1
     */
    ItemType RAW_GOLD = ItemType.of(Key.key("raw_gold"));

    /**
     * The minecraft:raw_gold_block item type.
     *
     * @since 0.1
     */
    ItemType RAW_GOLD_BLOCK = ItemType.of(Key.key("raw_gold_block"));

    /**
     * The minecraft:raw_iron item type.
     *
     * @since 0.1
     */
    ItemType RAW_IRON = ItemType.of(Key.key("raw_iron"));

    /**
     * The minecraft:raw_iron_block item type.
     *
     * @since 0.1
     */
    ItemType RAW_IRON_BLOCK = ItemType.of(Key.key("raw_iron_block"));

    /**
     * The minecraft:red_banner item type.
     *
     * @since 0.1
     */
    ItemType RED_BANNER = ItemType.of(Key.key("red_banner"));

    /**
     * The minecraft:red_bed item type.
     *
     * @since 0.1
     */
    ItemType RED_BED = ItemType.of(Key.key("red_bed"));

    /**
     * The minecraft:red_candle item type.
     *
     * @since 0.1
     */
    ItemType RED_CANDLE = ItemType.of(Key.key("red_candle"));

    /**
     * The minecraft:red_carpet item type.
     *
     * @since 0.1
     */
    ItemType RED_CARPET = ItemType.of(Key.key("red_carpet"));

    /**
     * The minecraft:red_concrete item type.
     *
     * @since 0.1
     */
    ItemType RED_CONCRETE = ItemType.of(Key.key("red_concrete"));

    /**
     * The minecraft:red_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType RED_CONCRETE_POWDER = ItemType.of(Key.key("red_concrete_powder"));

    /**
     * The minecraft:red_dye item type.
     *
     * @since 0.1
     */
    ItemType RED_DYE = ItemType.of(Key.key("red_dye"));

    /**
     * The minecraft:red_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType RED_GLAZED_TERRACOTTA = ItemType.of(Key.key("red_glazed_terracotta"));

    /**
     * The minecraft:red_mushroom item type.
     *
     * @since 0.1
     */
    ItemType RED_MUSHROOM = ItemType.of(Key.key("red_mushroom"));

    /**
     * The minecraft:red_mushroom_block item type.
     *
     * @since 0.1
     */
    ItemType RED_MUSHROOM_BLOCK = ItemType.of(Key.key("red_mushroom_block"));

    /**
     * The minecraft:red_nether_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType RED_NETHER_BRICK_SLAB = ItemType.of(Key.key("red_nether_brick_slab"));

    /**
     * The minecraft:red_nether_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType RED_NETHER_BRICK_STAIRS = ItemType.of(Key.key("red_nether_brick_stairs"));

    /**
     * The minecraft:red_nether_brick_wall item type.
     *
     * @since 0.1
     */
    ItemType RED_NETHER_BRICK_WALL = ItemType.of(Key.key("red_nether_brick_wall"));

    /**
     * The minecraft:red_nether_bricks item type.
     *
     * @since 0.1
     */
    ItemType RED_NETHER_BRICKS = ItemType.of(Key.key("red_nether_bricks"));

    /**
     * The minecraft:red_sand item type.
     *
     * @since 0.1
     */
    ItemType RED_SAND = ItemType.of(Key.key("red_sand"));

    /**
     * The minecraft:red_sandstone item type.
     *
     * @since 0.1
     */
    ItemType RED_SANDSTONE = ItemType.of(Key.key("red_sandstone"));

    /**
     * The minecraft:red_sandstone_slab item type.
     *
     * @since 0.1
     */
    ItemType RED_SANDSTONE_SLAB = ItemType.of(Key.key("red_sandstone_slab"));

    /**
     * The minecraft:red_sandstone_stairs item type.
     *
     * @since 0.1
     */
    ItemType RED_SANDSTONE_STAIRS = ItemType.of(Key.key("red_sandstone_stairs"));

    /**
     * The minecraft:red_sandstone_wall item type.
     *
     * @since 0.1
     */
    ItemType RED_SANDSTONE_WALL = ItemType.of(Key.key("red_sandstone_wall"));

    /**
     * The minecraft:red_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType RED_SHULKER_BOX = ItemType.of(Key.key("red_shulker_box"));

    /**
     * The minecraft:red_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType RED_STAINED_GLASS = ItemType.of(Key.key("red_stained_glass"));

    /**
     * The minecraft:red_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType RED_STAINED_GLASS_PANE = ItemType.of(Key.key("red_stained_glass_pane"));

    /**
     * The minecraft:red_terracotta item type.
     *
     * @since 0.1
     */
    ItemType RED_TERRACOTTA = ItemType.of(Key.key("red_terracotta"));

    /**
     * The minecraft:red_tulip item type.
     *
     * @since 0.1
     */
    ItemType RED_TULIP = ItemType.of(Key.key("red_tulip"));

    /**
     * The minecraft:red_wool item type.
     *
     * @since 0.1
     */
    ItemType RED_WOOL = ItemType.of(Key.key("red_wool"));

    /**
     * The minecraft:redstone item type.
     *
     * @since 0.1
     */
    ItemType REDSTONE = ItemType.of(Key.key("redstone"));

    /**
     * The minecraft:redstone_block item type.
     *
     * @since 0.1
     */
    ItemType REDSTONE_BLOCK = ItemType.of(Key.key("redstone_block"));

    /**
     * The minecraft:redstone_lamp item type.
     *
     * @since 0.1
     */
    ItemType REDSTONE_LAMP = ItemType.of(Key.key("redstone_lamp"));

    /**
     * The minecraft:redstone_ore item type.
     *
     * @since 0.1
     */
    ItemType REDSTONE_ORE = ItemType.of(Key.key("redstone_ore"));

    /**
     * The minecraft:redstone_torch item type.
     *
     * @since 0.1
     */
    ItemType REDSTONE_TORCH = ItemType.of(Key.key("redstone_torch"));

    /**
     * The minecraft:repeater item type.
     *
     * @since 0.1
     */
    ItemType REPEATER = ItemType.of(Key.key("repeater"));

    /**
     * The minecraft:repeating_command_block item type.
     *
     * @since 0.1
     */
    ItemType REPEATING_COMMAND_BLOCK = ItemType.of(Key.key("repeating_command_block"));

    /**
     * The minecraft:respawn_anchor item type.
     *
     * @since 0.1
     */
    ItemType RESPAWN_ANCHOR = ItemType.of(Key.key("respawn_anchor"));

    /**
     * The minecraft:rooted_dirt item type.
     *
     * @since 0.1
     */
    ItemType ROOTED_DIRT = ItemType.of(Key.key("rooted_dirt"));

    /**
     * The minecraft:rose_bush item type.
     *
     * @since 0.1
     */
    ItemType ROSE_BUSH = ItemType.of(Key.key("rose_bush"));

    /**
     * The minecraft:rotten_flesh item type.
     *
     * @since 0.1
     */
    ItemType ROTTEN_FLESH = ItemType.of(Key.key("rotten_flesh"));

    /**
     * The minecraft:saddle item type.
     *
     * @since 0.1
     */
    ItemType SADDLE = ItemType.of(Key.key("saddle"));

    /**
     * The minecraft:salmon item type.
     *
     * @since 0.1
     */
    ItemType SALMON = ItemType.of(Key.key("salmon"));

    /**
     * The minecraft:salmon_bucket item type.
     *
     * @since 0.1
     */
    ItemType SALMON_BUCKET = ItemType.of(Key.key("salmon_bucket"));

    /**
     * The minecraft:salmon_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SALMON_SPAWN_EGG = ItemType.of(Key.key("salmon_spawn_egg"));

    /**
     * The minecraft:sand item type.
     *
     * @since 0.1
     */
    ItemType SAND = ItemType.of(Key.key("sand"));

    /**
     * The minecraft:sandstone item type.
     *
     * @since 0.1
     */
    ItemType SANDSTONE = ItemType.of(Key.key("sandstone"));

    /**
     * The minecraft:sandstone_slab item type.
     *
     * @since 0.1
     */
    ItemType SANDSTONE_SLAB = ItemType.of(Key.key("sandstone_slab"));

    /**
     * The minecraft:sandstone_stairs item type.
     *
     * @since 0.1
     */
    ItemType SANDSTONE_STAIRS = ItemType.of(Key.key("sandstone_stairs"));

    /**
     * The minecraft:sandstone_wall item type.
     *
     * @since 0.1
     */
    ItemType SANDSTONE_WALL = ItemType.of(Key.key("sandstone_wall"));

    /**
     * The minecraft:scaffolding item type.
     *
     * @since 0.1
     */
    ItemType SCAFFOLDING = ItemType.of(Key.key("scaffolding"));

    /**
     * The minecraft:sculk_sensor item type.
     *
     * @since 0.1
     */
    ItemType SCULK_SENSOR = ItemType.of(Key.key("sculk_sensor"));

    /**
     * The minecraft:scute item type.
     *
     * @since 0.1
     */
    ItemType SCUTE = ItemType.of(Key.key("scute"));

    /**
     * The minecraft:sea_lantern item type.
     *
     * @since 0.1
     */
    ItemType SEA_LANTERN = ItemType.of(Key.key("sea_lantern"));

    /**
     * The minecraft:sea_pickle item type.
     *
     * @since 0.1
     */
    ItemType SEA_PICKLE = ItemType.of(Key.key("sea_pickle"));

    /**
     * The minecraft:seagrass item type.
     *
     * @since 0.1
     */
    ItemType SEAGRASS = ItemType.of(Key.key("seagrass"));

    /**
     * The minecraft:shears item type.
     *
     * @since 0.1
     */
    ItemType SHEARS = ItemType.of(Key.key("shears"));

    /**
     * The minecraft:sheep_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SHEEP_SPAWN_EGG = ItemType.of(Key.key("sheep_spawn_egg"));

    /**
     * The minecraft:shield item type.
     *
     * @since 0.1
     */
    ItemType SHIELD = ItemType.of(Key.key("shield"));

    /**
     * The minecraft:shroomlight item type.
     *
     * @since 0.1
     */
    ItemType SHROOMLIGHT = ItemType.of(Key.key("shroomlight"));

    /**
     * The minecraft:shulker_box item type.
     *
     * @since 0.1
     */
    ItemType SHULKER_BOX = ItemType.of(Key.key("shulker_box"));

    /**
     * The minecraft:shulker_shell item type.
     *
     * @since 0.1
     */
    ItemType SHULKER_SHELL = ItemType.of(Key.key("shulker_shell"));

    /**
     * The minecraft:shulker_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SHULKER_SPAWN_EGG = ItemType.of(Key.key("shulker_spawn_egg"));

    /**
     * The minecraft:silverfish_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SILVERFISH_SPAWN_EGG = ItemType.of(Key.key("silverfish_spawn_egg"));

    /**
     * The minecraft:skeleton_horse_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SKELETON_HORSE_SPAWN_EGG = ItemType.of(Key.key("skeleton_horse_spawn_egg"));

    /**
     * The minecraft:skeleton_skull item type.
     *
     * @since 0.1
     */
    ItemType SKELETON_SKULL = ItemType.of(Key.key("skeleton_skull"));

    /**
     * The minecraft:skeleton_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SKELETON_SPAWN_EGG = ItemType.of(Key.key("skeleton_spawn_egg"));

    /**
     * The minecraft:skull_banner_pattern item type.
     *
     * @since 0.1
     */
    ItemType SKULL_BANNER_PATTERN = ItemType.of(Key.key("skull_banner_pattern"));

    /**
     * The minecraft:slime_ball item type.
     *
     * @since 0.1
     */
    ItemType SLIME_BALL = ItemType.of(Key.key("slime_ball"));

    /**
     * The minecraft:slime_block item type.
     *
     * @since 0.1
     */
    ItemType SLIME_BLOCK = ItemType.of(Key.key("slime_block"));

    /**
     * The minecraft:slime_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SLIME_SPAWN_EGG = ItemType.of(Key.key("slime_spawn_egg"));

    /**
     * The minecraft:small_amethyst_bud item type.
     *
     * @since 0.1
     */
    ItemType SMALL_AMETHYST_BUD = ItemType.of(Key.key("small_amethyst_bud"));

    /**
     * The minecraft:small_dripleaf item type.
     *
     * @since 0.1
     */
    ItemType SMALL_DRIPLEAF = ItemType.of(Key.key("small_dripleaf"));

    /**
     * The minecraft:smithing_table item type.
     *
     * @since 0.1
     */
    ItemType SMITHING_TABLE = ItemType.of(Key.key("smithing_table"));

    /**
     * The minecraft:smoker item type.
     *
     * @since 0.1
     */
    ItemType SMOKER = ItemType.of(Key.key("smoker"));

    /**
     * The minecraft:smooth_basalt item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_BASALT = ItemType.of(Key.key("smooth_basalt"));

    /**
     * The minecraft:smooth_quartz item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_QUARTZ = ItemType.of(Key.key("smooth_quartz"));

    /**
     * The minecraft:smooth_quartz_slab item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_QUARTZ_SLAB = ItemType.of(Key.key("smooth_quartz_slab"));

    /**
     * The minecraft:smooth_quartz_stairs item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_QUARTZ_STAIRS = ItemType.of(Key.key("smooth_quartz_stairs"));

    /**
     * The minecraft:smooth_red_sandstone item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_RED_SANDSTONE = ItemType.of(Key.key("smooth_red_sandstone"));

    /**
     * The minecraft:smooth_red_sandstone_slab item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_RED_SANDSTONE_SLAB = ItemType.of(Key.key("smooth_red_sandstone_slab"));

    /**
     * The minecraft:smooth_red_sandstone_stairs item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_RED_SANDSTONE_STAIRS = ItemType.of(Key.key("smooth_red_sandstone_stairs"));

    /**
     * The minecraft:smooth_sandstone item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_SANDSTONE = ItemType.of(Key.key("smooth_sandstone"));

    /**
     * The minecraft:smooth_sandstone_slab item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_SANDSTONE_SLAB = ItemType.of(Key.key("smooth_sandstone_slab"));

    /**
     * The minecraft:smooth_sandstone_stairs item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_SANDSTONE_STAIRS = ItemType.of(Key.key("smooth_sandstone_stairs"));

    /**
     * The minecraft:smooth_stone item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_STONE = ItemType.of(Key.key("smooth_stone"));

    /**
     * The minecraft:smooth_stone_slab item type.
     *
     * @since 0.1
     */
    ItemType SMOOTH_STONE_SLAB = ItemType.of(Key.key("smooth_stone_slab"));

    /**
     * The minecraft:snow item type.
     *
     * @since 0.1
     */
    ItemType SNOW = ItemType.of(Key.key("snow"));

    /**
     * The minecraft:snow_block item type.
     *
     * @since 0.1
     */
    ItemType SNOW_BLOCK = ItemType.of(Key.key("snow_block"));

    /**
     * The minecraft:snowball item type.
     *
     * @since 0.1
     */
    ItemType SNOWBALL = ItemType.of(Key.key("snowball"));

    /**
     * The minecraft:soul_campfire item type.
     *
     * @since 0.1
     */
    ItemType SOUL_CAMPFIRE = ItemType.of(Key.key("soul_campfire"));

    /**
     * The minecraft:soul_lantern item type.
     *
     * @since 0.1
     */
    ItemType SOUL_LANTERN = ItemType.of(Key.key("soul_lantern"));

    /**
     * The minecraft:soul_sand item type.
     *
     * @since 0.1
     */
    ItemType SOUL_SAND = ItemType.of(Key.key("soul_sand"));

    /**
     * The minecraft:soul_soil item type.
     *
     * @since 0.1
     */
    ItemType SOUL_SOIL = ItemType.of(Key.key("soul_soil"));

    /**
     * The minecraft:soul_torch item type.
     *
     * @since 0.1
     */
    ItemType SOUL_TORCH = ItemType.of(Key.key("soul_torch"));

    /**
     * The minecraft:spawner item type.
     *
     * @since 0.1
     */
    ItemType SPAWNER = ItemType.of(Key.key("spawner"));

    /**
     * The minecraft:spectral_arrow item type.
     *
     * @since 0.1
     */
    ItemType SPECTRAL_ARROW = ItemType.of(Key.key("spectral_arrow"));

    /**
     * The minecraft:spider_eye item type.
     *
     * @since 0.1
     */
    ItemType SPIDER_EYE = ItemType.of(Key.key("spider_eye"));

    /**
     * The minecraft:spider_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SPIDER_SPAWN_EGG = ItemType.of(Key.key("spider_spawn_egg"));

    /**
     * The minecraft:splash_potion item type.
     *
     * @since 0.1
     */
    ItemType SPLASH_POTION = ItemType.of(Key.key("splash_potion"));

    /**
     * The minecraft:sponge item type.
     *
     * @since 0.1
     */
    ItemType SPONGE = ItemType.of(Key.key("sponge"));

    /**
     * The minecraft:spore_blossom item type.
     *
     * @since 0.1
     */
    ItemType SPORE_BLOSSOM = ItemType.of(Key.key("spore_blossom"));

    /**
     * The minecraft:spruce_boat item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_BOAT = ItemType.of(Key.key("spruce_boat"));

    /**
     * The minecraft:spruce_button item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_BUTTON = ItemType.of(Key.key("spruce_button"));

    /**
     * The minecraft:spruce_door item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_DOOR = ItemType.of(Key.key("spruce_door"));

    /**
     * The minecraft:spruce_fence item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_FENCE = ItemType.of(Key.key("spruce_fence"));

    /**
     * The minecraft:spruce_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_FENCE_GATE = ItemType.of(Key.key("spruce_fence_gate"));

    /**
     * The minecraft:spruce_leaves item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_LEAVES = ItemType.of(Key.key("spruce_leaves"));

    /**
     * The minecraft:spruce_log item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_LOG = ItemType.of(Key.key("spruce_log"));

    /**
     * The minecraft:spruce_planks item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_PLANKS = ItemType.of(Key.key("spruce_planks"));

    /**
     * The minecraft:spruce_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_PRESSURE_PLATE = ItemType.of(Key.key("spruce_pressure_plate"));

    /**
     * The minecraft:spruce_sapling item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_SAPLING = ItemType.of(Key.key("spruce_sapling"));

    /**
     * The minecraft:spruce_sign item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_SIGN = ItemType.of(Key.key("spruce_sign"));

    /**
     * The minecraft:spruce_slab item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_SLAB = ItemType.of(Key.key("spruce_slab"));

    /**
     * The minecraft:spruce_stairs item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_STAIRS = ItemType.of(Key.key("spruce_stairs"));

    /**
     * The minecraft:spruce_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_TRAPDOOR = ItemType.of(Key.key("spruce_trapdoor"));

    /**
     * The minecraft:spruce_wood item type.
     *
     * @since 0.1
     */
    ItemType SPRUCE_WOOD = ItemType.of(Key.key("spruce_wood"));

    /**
     * The minecraft:spyglass item type.
     *
     * @since 0.1
     */
    ItemType SPYGLASS = ItemType.of(Key.key("spyglass"));

    /**
     * The minecraft:squid_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType SQUID_SPAWN_EGG = ItemType.of(Key.key("squid_spawn_egg"));

    /**
     * The minecraft:stick item type.
     *
     * @since 0.1
     */
    ItemType STICK = ItemType.of(Key.key("stick"));

    /**
     * The minecraft:sticky_piston item type.
     *
     * @since 0.1
     */
    ItemType STICKY_PISTON = ItemType.of(Key.key("sticky_piston"));

    /**
     * The minecraft:stone item type.
     *
     * @since 0.1
     */
    ItemType STONE = ItemType.of(Key.key("stone"));

    /**
     * The minecraft:stone_axe item type.
     *
     * @since 0.1
     */
    ItemType STONE_AXE = ItemType.of(Key.key("stone_axe"));

    /**
     * The minecraft:stone_brick_slab item type.
     *
     * @since 0.1
     */
    ItemType STONE_BRICK_SLAB = ItemType.of(Key.key("stone_brick_slab"));

    /**
     * The minecraft:stone_brick_stairs item type.
     *
     * @since 0.1
     */
    ItemType STONE_BRICK_STAIRS = ItemType.of(Key.key("stone_brick_stairs"));

    /**
     * The minecraft:stone_brick_wall item type.
     *
     * @since 0.1
     */
    ItemType STONE_BRICK_WALL = ItemType.of(Key.key("stone_brick_wall"));

    /**
     * The minecraft:stone_bricks item type.
     *
     * @since 0.1
     */
    ItemType STONE_BRICKS = ItemType.of(Key.key("stone_bricks"));

    /**
     * The minecraft:stone_button item type.
     *
     * @since 0.1
     */
    ItemType STONE_BUTTON = ItemType.of(Key.key("stone_button"));

    /**
     * The minecraft:stone_hoe item type.
     *
     * @since 0.1
     */
    ItemType STONE_HOE = ItemType.of(Key.key("stone_hoe"));

    /**
     * The minecraft:stone_pickaxe item type.
     *
     * @since 0.1
     */
    ItemType STONE_PICKAXE = ItemType.of(Key.key("stone_pickaxe"));

    /**
     * The minecraft:stone_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType STONE_PRESSURE_PLATE = ItemType.of(Key.key("stone_pressure_plate"));

    /**
     * The minecraft:stone_shovel item type.
     *
     * @since 0.1
     */
    ItemType STONE_SHOVEL = ItemType.of(Key.key("stone_shovel"));

    /**
     * The minecraft:stone_slab item type.
     *
     * @since 0.1
     */
    ItemType STONE_SLAB = ItemType.of(Key.key("stone_slab"));

    /**
     * The minecraft:stone_stairs item type.
     *
     * @since 0.1
     */
    ItemType STONE_STAIRS = ItemType.of(Key.key("stone_stairs"));

    /**
     * The minecraft:stone_sword item type.
     *
     * @since 0.1
     */
    ItemType STONE_SWORD = ItemType.of(Key.key("stone_sword"));

    /**
     * The minecraft:stonecutter item type.
     *
     * @since 0.1
     */
    ItemType STONECUTTER = ItemType.of(Key.key("stonecutter"));

    /**
     * The minecraft:stray_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType STRAY_SPAWN_EGG = ItemType.of(Key.key("stray_spawn_egg"));

    /**
     * The minecraft:strider_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType STRIDER_SPAWN_EGG = ItemType.of(Key.key("strider_spawn_egg"));

    /**
     * The minecraft:string item type.
     *
     * @since 0.1
     */
    ItemType STRING = ItemType.of(Key.key("string"));

    /**
     * The minecraft:stripped_acacia_log item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_ACACIA_LOG = ItemType.of(Key.key("stripped_acacia_log"));

    /**
     * The minecraft:stripped_acacia_wood item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_ACACIA_WOOD = ItemType.of(Key.key("stripped_acacia_wood"));

    /**
     * The minecraft:stripped_birch_log item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_BIRCH_LOG = ItemType.of(Key.key("stripped_birch_log"));

    /**
     * The minecraft:stripped_birch_wood item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_BIRCH_WOOD = ItemType.of(Key.key("stripped_birch_wood"));

    /**
     * The minecraft:stripped_crimson_hyphae item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_CRIMSON_HYPHAE = ItemType.of(Key.key("stripped_crimson_hyphae"));

    /**
     * The minecraft:stripped_crimson_stem item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_CRIMSON_STEM = ItemType.of(Key.key("stripped_crimson_stem"));

    /**
     * The minecraft:stripped_dark_oak_log item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_DARK_OAK_LOG = ItemType.of(Key.key("stripped_dark_oak_log"));

    /**
     * The minecraft:stripped_dark_oak_wood item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_DARK_OAK_WOOD = ItemType.of(Key.key("stripped_dark_oak_wood"));

    /**
     * The minecraft:stripped_jungle_log item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_JUNGLE_LOG = ItemType.of(Key.key("stripped_jungle_log"));

    /**
     * The minecraft:stripped_jungle_wood item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_JUNGLE_WOOD = ItemType.of(Key.key("stripped_jungle_wood"));

    /**
     * The minecraft:stripped_oak_log item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_OAK_LOG = ItemType.of(Key.key("stripped_oak_log"));

    /**
     * The minecraft:stripped_oak_wood item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_OAK_WOOD = ItemType.of(Key.key("stripped_oak_wood"));

    /**
     * The minecraft:stripped_spruce_log item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_SPRUCE_LOG = ItemType.of(Key.key("stripped_spruce_log"));

    /**
     * The minecraft:stripped_spruce_wood item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_SPRUCE_WOOD = ItemType.of(Key.key("stripped_spruce_wood"));

    /**
     * The minecraft:stripped_warped_hyphae item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_WARPED_HYPHAE = ItemType.of(Key.key("stripped_warped_hyphae"));

    /**
     * The minecraft:stripped_warped_stem item type.
     *
     * @since 0.1
     */
    ItemType STRIPPED_WARPED_STEM = ItemType.of(Key.key("stripped_warped_stem"));

    /**
     * The minecraft:structure_block item type.
     *
     * @since 0.1
     */
    ItemType STRUCTURE_BLOCK = ItemType.of(Key.key("structure_block"));

    /**
     * The minecraft:structure_void item type.
     *
     * @since 0.1
     */
    ItemType STRUCTURE_VOID = ItemType.of(Key.key("structure_void"));

    /**
     * The minecraft:sugar item type.
     *
     * @since 0.1
     */
    ItemType SUGAR = ItemType.of(Key.key("sugar"));

    /**
     * The minecraft:sugar_cane item type.
     *
     * @since 0.1
     */
    ItemType SUGAR_CANE = ItemType.of(Key.key("sugar_cane"));

    /**
     * The minecraft:sunflower item type.
     *
     * @since 0.1
     */
    ItemType SUNFLOWER = ItemType.of(Key.key("sunflower"));

    /**
     * The minecraft:suspicious_stew item type.
     *
     * @since 0.1
     */
    ItemType SUSPICIOUS_STEW = ItemType.of(Key.key("suspicious_stew"));

    /**
     * The minecraft:sweet_berries item type.
     *
     * @since 0.1
     */
    ItemType SWEET_BERRIES = ItemType.of(Key.key("sweet_berries"));

    /**
     * The minecraft:tall_grass item type.
     *
     * @since 0.1
     */
    ItemType TALL_GRASS = ItemType.of(Key.key("tall_grass"));

    /**
     * The minecraft:target item type.
     *
     * @since 0.1
     */
    ItemType TARGET = ItemType.of(Key.key("target"));

    /**
     * The minecraft:terracotta item type.
     *
     * @since 0.1
     */
    ItemType TERRACOTTA = ItemType.of(Key.key("terracotta"));

    /**
     * The minecraft:tinted_glass item type.
     *
     * @since 0.1
     */
    ItemType TINTED_GLASS = ItemType.of(Key.key("tinted_glass"));

    /**
     * The minecraft:tipped_arrow item type.
     *
     * @since 0.1
     */
    ItemType TIPPED_ARROW = ItemType.of(Key.key("tipped_arrow"));

    /**
     * The minecraft:tnt item type.
     *
     * @since 0.1
     */
    ItemType TNT = ItemType.of(Key.key("tnt"));

    /**
     * The minecraft:tnt_minecart item type.
     *
     * @since 0.1
     */
    ItemType TNT_MINECART = ItemType.of(Key.key("tnt_minecart"));

    /**
     * The minecraft:torch item type.
     *
     * @since 0.1
     */
    ItemType TORCH = ItemType.of(Key.key("torch"));

    /**
     * The minecraft:totem_of_undying item type.
     *
     * @since 0.1
     */
    ItemType TOTEM_OF_UNDYING = ItemType.of(Key.key("totem_of_undying"));

    /**
     * The minecraft:trader_llama_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType TRADER_LLAMA_SPAWN_EGG = ItemType.of(Key.key("trader_llama_spawn_egg"));

    /**
     * The minecraft:trapped_chest item type.
     *
     * @since 0.1
     */
    ItemType TRAPPED_CHEST = ItemType.of(Key.key("trapped_chest"));

    /**
     * The minecraft:trident item type.
     *
     * @since 0.1
     */
    ItemType TRIDENT = ItemType.of(Key.key("trident"));

    /**
     * The minecraft:tripwire_hook item type.
     *
     * @since 0.1
     */
    ItemType TRIPWIRE_HOOK = ItemType.of(Key.key("tripwire_hook"));

    /**
     * The minecraft:tropical_fish item type.
     *
     * @since 0.1
     */
    ItemType TROPICAL_FISH = ItemType.of(Key.key("tropical_fish"));

    /**
     * The minecraft:tropical_fish_bucket item type.
     *
     * @since 0.1
     */
    ItemType TROPICAL_FISH_BUCKET = ItemType.of(Key.key("tropical_fish_bucket"));

    /**
     * The minecraft:tropical_fish_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType TROPICAL_FISH_SPAWN_EGG = ItemType.of(Key.key("tropical_fish_spawn_egg"));

    /**
     * The minecraft:tube_coral item type.
     *
     * @since 0.1
     */
    ItemType TUBE_CORAL = ItemType.of(Key.key("tube_coral"));

    /**
     * The minecraft:tube_coral_block item type.
     *
     * @since 0.1
     */
    ItemType TUBE_CORAL_BLOCK = ItemType.of(Key.key("tube_coral_block"));

    /**
     * The minecraft:tube_coral_fan item type.
     *
     * @since 0.1
     */
    ItemType TUBE_CORAL_FAN = ItemType.of(Key.key("tube_coral_fan"));

    /**
     * The minecraft:tuff item type.
     *
     * @since 0.1
     */
    ItemType TUFF = ItemType.of(Key.key("tuff"));

    /**
     * The minecraft:turtle_egg item type.
     *
     * @since 0.1
     */
    ItemType TURTLE_EGG = ItemType.of(Key.key("turtle_egg"));

    /**
     * The minecraft:turtle_helmet item type.
     *
     * @since 0.1
     */
    ItemType TURTLE_HELMET = ItemType.of(Key.key("turtle_helmet"));

    /**
     * The minecraft:turtle_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType TURTLE_SPAWN_EGG = ItemType.of(Key.key("turtle_spawn_egg"));

    /**
     * The minecraft:twisting_vines item type.
     *
     * @since 0.1
     */
    ItemType TWISTING_VINES = ItemType.of(Key.key("twisting_vines"));

    /**
     * The minecraft:vex_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType VEX_SPAWN_EGG = ItemType.of(Key.key("vex_spawn_egg"));

    /**
     * The minecraft:villager_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType VILLAGER_SPAWN_EGG = ItemType.of(Key.key("villager_spawn_egg"));

    /**
     * The minecraft:vindicator_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType VINDICATOR_SPAWN_EGG = ItemType.of(Key.key("vindicator_spawn_egg"));

    /**
     * The minecraft:vine item type.
     *
     * @since 0.1
     */
    ItemType VINE = ItemType.of(Key.key("vine"));

    /**
     * The minecraft:wandering_trader_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType WANDERING_TRADER_SPAWN_EGG = ItemType.of(Key.key("wandering_trader_spawn_egg"));

    /**
     * The minecraft:warped_button item type.
     *
     * @since 0.1
     */
    ItemType WARPED_BUTTON = ItemType.of(Key.key("warped_button"));

    /**
     * The minecraft:warped_door item type.
     *
     * @since 0.1
     */
    ItemType WARPED_DOOR = ItemType.of(Key.key("warped_door"));

    /**
     * The minecraft:warped_fence item type.
     *
     * @since 0.1
     */
    ItemType WARPED_FENCE = ItemType.of(Key.key("warped_fence"));

    /**
     * The minecraft:warped_fence_gate item type.
     *
     * @since 0.1
     */
    ItemType WARPED_FENCE_GATE = ItemType.of(Key.key("warped_fence_gate"));

    /**
     * The minecraft:warped_fungus item type.
     *
     * @since 0.1
     */
    ItemType WARPED_FUNGUS = ItemType.of(Key.key("warped_fungus"));

    /**
     * The minecraft:warped_fungus_on_a_stick item type.
     *
     * @since 0.1
     */
    ItemType WARPED_FUNGUS_ON_A_STICK = ItemType.of(Key.key("warped_fungus_on_a_stick"));

    /**
     * The minecraft:warped_hyphae item type.
     *
     * @since 0.1
     */
    ItemType WARPED_HYPHAE = ItemType.of(Key.key("warped_hyphae"));

    /**
     * The minecraft:warped_nylium item type.
     *
     * @since 0.1
     */
    ItemType WARPED_NYLIUM = ItemType.of(Key.key("warped_nylium"));

    /**
     * The minecraft:warped_planks item type.
     *
     * @since 0.1
     */
    ItemType WARPED_PLANKS = ItemType.of(Key.key("warped_planks"));

    /**
     * The minecraft:warped_pressure_plate item type.
     *
     * @since 0.1
     */
    ItemType WARPED_PRESSURE_PLATE = ItemType.of(Key.key("warped_pressure_plate"));

    /**
     * The minecraft:warped_roots item type.
     *
     * @since 0.1
     */
    ItemType WARPED_ROOTS = ItemType.of(Key.key("warped_roots"));

    /**
     * The minecraft:warped_sign item type.
     *
     * @since 0.1
     */
    ItemType WARPED_SIGN = ItemType.of(Key.key("warped_sign"));

    /**
     * The minecraft:warped_slab item type.
     *
     * @since 0.1
     */
    ItemType WARPED_SLAB = ItemType.of(Key.key("warped_slab"));

    /**
     * The minecraft:warped_stairs item type.
     *
     * @since 0.1
     */
    ItemType WARPED_STAIRS = ItemType.of(Key.key("warped_stairs"));

    /**
     * The minecraft:warped_stem item type.
     *
     * @since 0.1
     */
    ItemType WARPED_STEM = ItemType.of(Key.key("warped_stem"));

    /**
     * The minecraft:warped_trapdoor item type.
     *
     * @since 0.1
     */
    ItemType WARPED_TRAPDOOR = ItemType.of(Key.key("warped_trapdoor"));

    /**
     * The minecraft:warped_wart_block item type.
     *
     * @since 0.1
     */
    ItemType WARPED_WART_BLOCK = ItemType.of(Key.key("warped_wart_block"));

    /**
     * The minecraft:water_bucket item type.
     *
     * @since 0.1
     */
    ItemType WATER_BUCKET = ItemType.of(Key.key("water_bucket"));

    /**
     * The minecraft:waxed_copper_block item type.
     *
     * @since 0.1
     */
    ItemType WAXED_COPPER_BLOCK = ItemType.of(Key.key("waxed_copper_block"));

    /**
     * The minecraft:waxed_cut_copper item type.
     *
     * @since 0.1
     */
    ItemType WAXED_CUT_COPPER = ItemType.of(Key.key("waxed_cut_copper"));

    /**
     * The minecraft:waxed_cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType WAXED_CUT_COPPER_SLAB = ItemType.of(Key.key("waxed_cut_copper_slab"));

    /**
     * The minecraft:waxed_cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType WAXED_CUT_COPPER_STAIRS = ItemType.of(Key.key("waxed_cut_copper_stairs"));

    /**
     * The minecraft:waxed_exposed_copper item type.
     *
     * @since 0.1
     */
    ItemType WAXED_EXPOSED_COPPER = ItemType.of(Key.key("waxed_exposed_copper"));

    /**
     * The minecraft:waxed_exposed_cut_copper item type.
     *
     * @since 0.1
     */
    ItemType WAXED_EXPOSED_CUT_COPPER = ItemType.of(Key.key("waxed_exposed_cut_copper"));

    /**
     * The minecraft:waxed_exposed_cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType WAXED_EXPOSED_CUT_COPPER_SLAB = ItemType.of(Key.key("waxed_exposed_cut_copper_slab"));

    /**
     * The minecraft:waxed_exposed_cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType WAXED_EXPOSED_CUT_COPPER_STAIRS = ItemType.of(Key.key("waxed_exposed_cut_copper_stairs"));

    /**
     * The minecraft:waxed_oxidized_copper item type.
     *
     * @since 0.1
     */
    ItemType WAXED_OXIDIZED_COPPER = ItemType.of(Key.key("waxed_oxidized_copper"));

    /**
     * The minecraft:waxed_oxidized_cut_copper item type.
     *
     * @since 0.1
     */
    ItemType WAXED_OXIDIZED_CUT_COPPER = ItemType.of(Key.key("waxed_oxidized_cut_copper"));

    /**
     * The minecraft:waxed_oxidized_cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType WAXED_OXIDIZED_CUT_COPPER_SLAB = ItemType.of(Key.key("waxed_oxidized_cut_copper_slab"));

    /**
     * The minecraft:waxed_oxidized_cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType WAXED_OXIDIZED_CUT_COPPER_STAIRS = ItemType.of(Key.key("waxed_oxidized_cut_copper_stairs"));

    /**
     * The minecraft:waxed_weathered_copper item type.
     *
     * @since 0.1
     */
    ItemType WAXED_WEATHERED_COPPER = ItemType.of(Key.key("waxed_weathered_copper"));

    /**
     * The minecraft:waxed_weathered_cut_copper item type.
     *
     * @since 0.1
     */
    ItemType WAXED_WEATHERED_CUT_COPPER = ItemType.of(Key.key("waxed_weathered_cut_copper"));

    /**
     * The minecraft:waxed_weathered_cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType WAXED_WEATHERED_CUT_COPPER_SLAB = ItemType.of(Key.key("waxed_weathered_cut_copper_slab"));

    /**
     * The minecraft:waxed_weathered_cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType WAXED_WEATHERED_CUT_COPPER_STAIRS = ItemType.of(Key.key("waxed_weathered_cut_copper_stairs"));

    /**
     * The minecraft:weathered_copper item type.
     *
     * @since 0.1
     */
    ItemType WEATHERED_COPPER = ItemType.of(Key.key("weathered_copper"));

    /**
     * The minecraft:weathered_cut_copper item type.
     *
     * @since 0.1
     */
    ItemType WEATHERED_CUT_COPPER = ItemType.of(Key.key("weathered_cut_copper"));

    /**
     * The minecraft:weathered_cut_copper_slab item type.
     *
     * @since 0.1
     */
    ItemType WEATHERED_CUT_COPPER_SLAB = ItemType.of(Key.key("weathered_cut_copper_slab"));

    /**
     * The minecraft:weathered_cut_copper_stairs item type.
     *
     * @since 0.1
     */
    ItemType WEATHERED_CUT_COPPER_STAIRS = ItemType.of(Key.key("weathered_cut_copper_stairs"));

    /**
     * The minecraft:weeping_vines item type.
     *
     * @since 0.1
     */
    ItemType WEEPING_VINES = ItemType.of(Key.key("weeping_vines"));

    /**
     * The minecraft:wet_sponge item type.
     *
     * @since 0.1
     */
    ItemType WET_SPONGE = ItemType.of(Key.key("wet_sponge"));

    /**
     * The minecraft:wheat item type.
     *
     * @since 0.1
     */
    ItemType WHEAT = ItemType.of(Key.key("wheat"));

    /**
     * The minecraft:wheat_seeds item type.
     *
     * @since 0.1
     */
    ItemType WHEAT_SEEDS = ItemType.of(Key.key("wheat_seeds"));

    /**
     * The minecraft:white_banner item type.
     *
     * @since 0.1
     */
    ItemType WHITE_BANNER = ItemType.of(Key.key("white_banner"));

    /**
     * The minecraft:white_bed item type.
     *
     * @since 0.1
     */
    ItemType WHITE_BED = ItemType.of(Key.key("white_bed"));

    /**
     * The minecraft:white_candle item type.
     *
     * @since 0.1
     */
    ItemType WHITE_CANDLE = ItemType.of(Key.key("white_candle"));

    /**
     * The minecraft:white_carpet item type.
     *
     * @since 0.1
     */
    ItemType WHITE_CARPET = ItemType.of(Key.key("white_carpet"));

    /**
     * The minecraft:white_concrete item type.
     *
     * @since 0.1
     */
    ItemType WHITE_CONCRETE = ItemType.of(Key.key("white_concrete"));

    /**
     * The minecraft:white_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType WHITE_CONCRETE_POWDER = ItemType.of(Key.key("white_concrete_powder"));

    /**
     * The minecraft:white_dye item type.
     *
     * @since 0.1
     */
    ItemType WHITE_DYE = ItemType.of(Key.key("white_dye"));

    /**
     * The minecraft:white_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType WHITE_GLAZED_TERRACOTTA = ItemType.of(Key.key("white_glazed_terracotta"));

    /**
     * The minecraft:white_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType WHITE_SHULKER_BOX = ItemType.of(Key.key("white_shulker_box"));

    /**
     * The minecraft:white_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType WHITE_STAINED_GLASS = ItemType.of(Key.key("white_stained_glass"));

    /**
     * The minecraft:white_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType WHITE_STAINED_GLASS_PANE = ItemType.of(Key.key("white_stained_glass_pane"));

    /**
     * The minecraft:white_terracotta item type.
     *
     * @since 0.1
     */
    ItemType WHITE_TERRACOTTA = ItemType.of(Key.key("white_terracotta"));

    /**
     * The minecraft:white_tulip item type.
     *
     * @since 0.1
     */
    ItemType WHITE_TULIP = ItemType.of(Key.key("white_tulip"));

    /**
     * The minecraft:white_wool item type.
     *
     * @since 0.1
     */
    ItemType WHITE_WOOL = ItemType.of(Key.key("white_wool"));

    /**
     * The minecraft:witch_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType WITCH_SPAWN_EGG = ItemType.of(Key.key("witch_spawn_egg"));

    /**
     * The minecraft:wither_rose item type.
     *
     * @since 0.1
     */
    ItemType WITHER_ROSE = ItemType.of(Key.key("wither_rose"));

    /**
     * The minecraft:wither_skeleton_skull item type.
     *
     * @since 0.1
     */
    ItemType WITHER_SKELETON_SKULL = ItemType.of(Key.key("wither_skeleton_skull"));

    /**
     * The minecraft:wither_skeleton_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType WITHER_SKELETON_SPAWN_EGG = ItemType.of(Key.key("wither_skeleton_spawn_egg"));

    /**
     * The minecraft:wolf_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType WOLF_SPAWN_EGG = ItemType.of(Key.key("wolf_spawn_egg"));

    /**
     * The minecraft:wooden_axe item type.
     *
     * @since 0.1
     */
    ItemType WOODEN_AXE = ItemType.of(Key.key("wooden_axe"));

    /**
     * The minecraft:wooden_hoe item type.
     *
     * @since 0.1
     */
    ItemType WOODEN_HOE = ItemType.of(Key.key("wooden_hoe"));

    /**
     * The minecraft:wooden_pickaxe item type.
     *
     * @since 0.1
     */
    ItemType WOODEN_PICKAXE = ItemType.of(Key.key("wooden_pickaxe"));

    /**
     * The minecraft:wooden_shovel item type.
     *
     * @since 0.1
     */
    ItemType WOODEN_SHOVEL = ItemType.of(Key.key("wooden_shovel"));

    /**
     * The minecraft:wooden_sword item type.
     *
     * @since 0.1
     */
    ItemType WOODEN_SWORD = ItemType.of(Key.key("wooden_sword"));

    /**
     * The minecraft:writable_book item type.
     *
     * @since 0.1
     */
    ItemType WRITABLE_BOOK = ItemType.of(Key.key("writable_book"));

    /**
     * The minecraft:written_book item type.
     *
     * @since 0.1
     */
    ItemType WRITTEN_BOOK = ItemType.of(Key.key("written_book"));

    /**
     * The minecraft:yellow_banner item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_BANNER = ItemType.of(Key.key("yellow_banner"));

    /**
     * The minecraft:yellow_bed item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_BED = ItemType.of(Key.key("yellow_bed"));

    /**
     * The minecraft:yellow_candle item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_CANDLE = ItemType.of(Key.key("yellow_candle"));

    /**
     * The minecraft:yellow_carpet item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_CARPET = ItemType.of(Key.key("yellow_carpet"));

    /**
     * The minecraft:yellow_concrete item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_CONCRETE = ItemType.of(Key.key("yellow_concrete"));

    /**
     * The minecraft:yellow_concrete_powder item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_CONCRETE_POWDER = ItemType.of(Key.key("yellow_concrete_powder"));

    /**
     * The minecraft:yellow_dye item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_DYE = ItemType.of(Key.key("yellow_dye"));

    /**
     * The minecraft:yellow_glazed_terracotta item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_GLAZED_TERRACOTTA = ItemType.of(Key.key("yellow_glazed_terracotta"));

    /**
     * The minecraft:yellow_shulker_box item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_SHULKER_BOX = ItemType.of(Key.key("yellow_shulker_box"));

    /**
     * The minecraft:yellow_stained_glass item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_STAINED_GLASS = ItemType.of(Key.key("yellow_stained_glass"));

    /**
     * The minecraft:yellow_stained_glass_pane item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_STAINED_GLASS_PANE = ItemType.of(Key.key("yellow_stained_glass_pane"));

    /**
     * The minecraft:yellow_terracotta item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_TERRACOTTA = ItemType.of(Key.key("yellow_terracotta"));

    /**
     * The minecraft:yellow_wool item type.
     *
     * @since 0.1
     */
    ItemType YELLOW_WOOL = ItemType.of(Key.key("yellow_wool"));

    /**
     * The minecraft:zoglin_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ZOGLIN_SPAWN_EGG = ItemType.of(Key.key("zoglin_spawn_egg"));

    /**
     * The minecraft:zombie_head item type.
     *
     * @since 0.1
     */
    ItemType ZOMBIE_HEAD = ItemType.of(Key.key("zombie_head"));

    /**
     * The minecraft:zombie_horse_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ZOMBIE_HORSE_SPAWN_EGG = ItemType.of(Key.key("zombie_horse_spawn_egg"));

    /**
     * The minecraft:zombie_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ZOMBIE_SPAWN_EGG = ItemType.of(Key.key("zombie_spawn_egg"));

    /**
     * The minecraft:zombie_villager_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ZOMBIE_VILLAGER_SPAWN_EGG = ItemType.of(Key.key("zombie_villager_spawn_egg"));

    /**
     * The minecraft:zombified_piglin_spawn_egg item type.
     *
     * @since 0.1
     */
    ItemType ZOMBIFIED_PIGLIN_SPAWN_EGG = ItemType.of(Key.key("zombified_piglin_spawn_egg"));
    // @formatter:on
    // </editor-fold>

    /**
     * Creates a new {@link ItemType} for the given {@link Key}.
     *
     * @param key the key
     * @return the new item type
     * @throws NullPointerException if the key is {@code null}.
     */
    private static ItemType of(final Key key) {

        return ItemTypeImpl.of(key);
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

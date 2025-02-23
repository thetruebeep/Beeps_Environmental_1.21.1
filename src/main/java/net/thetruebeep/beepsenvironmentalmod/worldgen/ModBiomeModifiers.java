package net.thetruebeep.beepsenvironmentalmod.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.entity.ModEntities;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_CHROMIUM_ORE = registerKey("add_chromium_ore");

    public static final ResourceKey<BiomeModifier> ADD_TREE_ROSE_WOOD = registerKey("add_tree_rose_wood");
    public static final ResourceKey<BiomeModifier> SPAWN_FROGGY = registerKey("spawn_froggy");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_CHROMIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHROMIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_TREE_ROSE_WOOD, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SAVANNA)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ROSE_WOOD_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(SPAWN_FROGGY, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT),
                biomes.getOrThrow(Biomes.SAVANNA_PLATEAU)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.FROGGY.get(), 20, 2, 4))));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID, name));
    }
}

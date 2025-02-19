package net.thetruebeep.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;
import net.thetruebeep.beepsenvironmentalmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CHROMIUM_BLOCK.get());
        dropSelf(ModBlocks.DEACTIVATED_EXCHANGER.get());

        dropSelf(ModBlocks.ROSE_WOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_ROSE_WOOD_LOG.get());
        dropSelf(ModBlocks.STRIPPED_ROSE_WOOD_WOOD.get());
        dropSelf(ModBlocks.ROSE_WOOD_WOOD.get());
        dropSelf(ModBlocks.ROSE_WOOD_PLANKS.get());
        dropSelf(ModBlocks.ROSE_WOOD_SAPLING.get());
        add(ModBlocks.ROSE_WOOD_LEAF.get(), block ->
                createLeavesDrops(block, ModBlocks.ROSE_WOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.INFECTED_ROSE_WOOD_LEAF.get(), block ->
                createLeavesDrops(block, ModBlocks.ROSE_WOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.CHROMIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CHROMIUM_ORE.get(), ModItems.R_CHROMIUM.get()));
        add(ModBlocks.CHROMIUM_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.CHROMIUM_DEEPSLATE_ORE.get(), ModItems.R_CHROMIUM.get()));



    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

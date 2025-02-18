package net.thetruebeep.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BeepsEnvironmentalMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHROMIUM_BLOCK.get())
                .add(ModBlocks.CHROMIUM_ORE.get())
                .add(ModBlocks.CHROMIUM_DEEPSLATE_ORE.get())
                .add(ModBlocks.DEACTIVATED_EXCHANGER.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CHROMIUM_BLOCK.get())
                .add(ModBlocks.CHROMIUM_ORE.get())
                .add(ModBlocks.CHROMIUM_DEEPSLATE_ORE.get());

    }
}

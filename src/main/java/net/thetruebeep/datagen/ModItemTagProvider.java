package net.thetruebeep.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;
import net.thetruebeep.beepsenvironmentalmod.item.ModItems;
import net.thetruebeep.beepsenvironmentalmod.util.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, BeepsEnvironmentalMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.CHROMIUM_ITEMS)
                .add(ModItems.CHROMIUM.get())
                .add(ModItems.R_CHROMIUM.get());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ROSE_WOOD_LOG.get().asItem())
                .add(ModBlocks.ROSE_WOOD_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ROSE_WOOD_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ROSE_WOOD_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.ROSE_WOOD_PLANKS.asItem());


    }}


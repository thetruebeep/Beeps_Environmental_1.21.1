package net.thetruebeep.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BeepsEnvironmentalMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CHROMIUM_BLOCK);

        blockWithItem(ModBlocks.CHROMIUM_ORE);
        blockWithItem(ModBlocks.CHROMIUM_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.ROSE_WOOD_LEAF);
        blockWithItem(ModBlocks.INFECTED_ROSE_WOOD_LEAF);

        blockWithItem(ModBlocks.DEACTIVATED_EXCHANGER);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

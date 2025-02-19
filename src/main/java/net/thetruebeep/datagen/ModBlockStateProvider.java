package net.thetruebeep.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        blockWithItem(ModBlocks.DEACTIVATED_EXCHANGER);

        logBlock(((RotatedPillarBlock) ModBlocks.ROSE_WOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.ROSE_WOOD_WOOD.get()), blockTexture(ModBlocks.ROSE_WOOD_LOG.get()), blockTexture(ModBlocks.ROSE_WOOD_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ROSE_WOOD_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_ROSE_WOOD_WOOD.get()), blockTexture(ModBlocks.STRIPPED_ROSE_WOOD_LOG.get()), blockTexture(ModBlocks.STRIPPED_ROSE_WOOD_LOG.get()));

        blockItem(ModBlocks.ROSE_WOOD_LOG);
        blockItem(ModBlocks.ROSE_WOOD_WOOD);
        blockItem(ModBlocks.STRIPPED_ROSE_WOOD_LOG);
        blockItem(ModBlocks.STRIPPED_ROSE_WOOD_WOOD);

        blockWithItem(ModBlocks.ROSE_WOOD_PLANKS);

        leavesBlock(ModBlocks.ROSE_WOOD_LEAF);
        leavesBlock(ModBlocks.INFECTED_ROSE_WOOD_LEAF);
        saplingBlock(ModBlocks.ROSE_WOOD_SAPLING);

    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("beepsenvironmentalmod:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("beepsenvironmentalmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}

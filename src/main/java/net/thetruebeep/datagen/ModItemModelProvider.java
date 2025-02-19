package net.thetruebeep.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;
import net.thetruebeep.beepsenvironmentalmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BeepsEnvironmentalMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.R_CHROMIUM.get());
        basicItem(ModItems.CHROMIUM.get());

        basicItem(ModItems.INFESTED_STRING.get());


        saplingItem(ModBlocks.ROSE_WOOD_SAPLING);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID,"block/" + item.getId().getPath()));
    }
}

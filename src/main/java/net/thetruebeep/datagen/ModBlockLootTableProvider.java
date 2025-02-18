package net.thetruebeep.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;
import net.thetruebeep.beepsenvironmentalmod.item.ModItems;

import java.util.Set;

import static net.minecraft.world.level.storage.loot.functions.SetItemCountFunction.setCount;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CHROMIUM_BLOCK.get());
        dropSelf(ModBlocks.DEACTIVATED_EXCHANGER.get());

        add(ModBlocks.CHROMIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CHROMIUM_ORE.get(), ModItems.R_CHROMIUM.get()));
        add(ModBlocks.CHROMIUM_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.CHROMIUM_DEEPSLATE_ORE.get(), ModItems.R_CHROMIUM.get()));


        add(ModBlocks.ROSE_WOOD_LEAF.get(),
                block -> createShearsOnlyLootTable(ModBlocks.ROSE_WOOD_LEAF.get()));
        add(ModBlocks.INFECTED_ROSE_WOOD_LEAF.get(),
                block -> createShearsOnlyLootTable(ModBlocks.INFECTED_ROSE_WOOD_LEAF.get()));
    }

    private static LootTable.Builder createShearsOnlyLootTable(Block block) {
        LootItemCondition.Builder shearsCondition = MatchTool.toolMatches(
                ItemPredicate.Builder.item()
                        .of(Items.SHEARS)
        );

        return LootTable.lootTable()
                .withPool(net.minecraft.world.level.storage.loot.LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(block)
                                .when(shearsCondition)
                                .apply(setCount(ConstantValue.exactly(1)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}

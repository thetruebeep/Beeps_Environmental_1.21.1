package net.thetruebeep.beepsenvironmentalmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;

public class ModTags {
    public static class Blocks{

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID, name));
        }

    }

    public static class Items {
        //public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> CHROMIUM_ITEMS = createTag(("chromium_items"));



        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID, name));
        }
    }
}

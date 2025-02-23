package net.thetruebeep.beepsenvironmentalmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BeepsEnvironmentalMod.MOD_ID);

    public static final DeferredItem<Item> R_CHROMIUM = ITEMS.register("rawchromium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHROMIUM = ITEMS.register("chromium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INFESTED_STRING = ITEMS.register("infested_string",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FROGGY_SPAWN_EGG = ITEMS.register("froggy_spawn_egg",
            () -> new SpawnEggItem(ModEntities.FROGGY.get(), 0xD57E36, 0x1D0D00, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

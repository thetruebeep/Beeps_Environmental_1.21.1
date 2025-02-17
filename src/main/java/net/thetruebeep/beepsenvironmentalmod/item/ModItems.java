package net.thetruebeep.beepsenvironmentalmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BeepsEnvironmentalMod.MOD_ID);

    public static final DeferredItem<Item> R_CHROMIUM = ITEMS.register("rawchromium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHROMIUM = ITEMS.register("chromium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INFESTED_STRING = ITEMS.register("infested_string",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

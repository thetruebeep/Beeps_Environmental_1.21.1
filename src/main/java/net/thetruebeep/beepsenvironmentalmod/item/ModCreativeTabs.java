package net.thetruebeep.beepsenvironmentalmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BeepsEnvironmentalMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BEEPS_ENVIRONMENTAL_TAB = CREATIVE_MODE_TAB.register("beeps_environmental_tab",
    () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.INFESTED_STRING.get()))
            .title(Component.translatable("creativetab.beepsenvironmentalmod.beeps_environmental"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.INFESTED_STRING);
                output.accept(ModItems.CHROMIUM);
                output.accept(ModItems.R_CHROMIUM);



                output.accept(ModBlocks.CHROMIUM_BLOCK);

                output.accept(ModBlocks.INFECTED_ROSE_WOOD_LEAF);
                output.accept(ModBlocks.ROSE_WOOD_LEAF);
                output.accept(ModBlocks.ROSE_WOOD_LOG);
                output.accept(ModBlocks.STRIPPED_ROSE_WOOD_LOG);
                output.accept(ModBlocks.STRIPPED_ROSE_WOOD_WOOD);
                output.accept(ModBlocks.ROSE_WOOD_WOOD);

                output.accept(ModBlocks.ROSE_WOOD_PLANKS);
                output.accept(ModBlocks.ROSE_WOOD_SAPLING);

                output.accept(ModBlocks.CHROMIUM_ORE);
                output.accept(ModBlocks.CHROMIUM_DEEPSLATE_ORE);
                output.accept(ModBlocks.DEACTIVATED_EXCHANGER);
            })




            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

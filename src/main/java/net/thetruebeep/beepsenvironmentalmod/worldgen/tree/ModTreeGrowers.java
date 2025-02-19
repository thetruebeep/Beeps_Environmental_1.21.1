package net.thetruebeep.beepsenvironmentalmod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower ROSE_WOOD = new TreeGrower(BeepsEnvironmentalMod.MOD_ID + ":rose_wood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ROSE_WOOD_KEY), Optional.empty());

}

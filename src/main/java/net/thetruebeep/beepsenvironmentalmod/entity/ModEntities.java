package net.thetruebeep.beepsenvironmentalmod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.entity.custom.FroggyEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, BeepsEnvironmentalMod.MOD_ID);

    public static final Supplier<EntityType<FroggyEntity>> FROGGY =
            ENTITY_TYPES.register("froggy", ()-> EntityType.Builder.of(FroggyEntity::new, MobCategory.CREATURE)
                    .sized(0.75f,0.35f).build("froggy"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}

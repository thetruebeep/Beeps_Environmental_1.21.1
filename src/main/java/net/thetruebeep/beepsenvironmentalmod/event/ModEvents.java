package net.thetruebeep.beepsenvironmentalmod.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.entity.ModEntities;
import net.thetruebeep.beepsenvironmentalmod.entity.custom.FroggyEntity;

@EventBusSubscriber(modid = BeepsEnvironmentalMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FROGGY.get(), FroggyEntity.createAttributes().build());
    }
}

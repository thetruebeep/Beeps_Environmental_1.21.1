package net.thetruebeep.beepsenvironmentalmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.entity.custom.FroggyEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FroggyModel extends GeoModel<FroggyEntity> {
    @Override
    public ResourceLocation getModelResource(FroggyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID, "geo/froggy.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FroggyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID, "textures/entity/froggy.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FroggyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID, "animations/froggy.animation.json");
    }

    public void setCustomAnimations(FroggyEntity animatable, long instanceId, AnimationState<FroggyEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
    }
}
}

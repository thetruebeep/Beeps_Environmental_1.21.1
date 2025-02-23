package net.thetruebeep.beepsenvironmentalmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.thetruebeep.beepsenvironmentalmod.BeepsEnvironmentalMod;
import net.thetruebeep.beepsenvironmentalmod.entity.custom.FroggyEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FroggyRenderer extends GeoEntityRenderer<FroggyEntity> {

    public FroggyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FroggyModel());
    }

    @Override
    public ResourceLocation getTextureLocation(FroggyEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(BeepsEnvironmentalMod.MOD_ID, "textures/entity/froggy.png");
    }

    @Override
    public void render(FroggyEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(0.4f,0.4f,0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}

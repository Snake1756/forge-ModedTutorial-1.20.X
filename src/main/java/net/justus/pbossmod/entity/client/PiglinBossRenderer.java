package net.justus.pbossmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.justus.pbossmod.ExampleMod;
import net.justus.pbossmod.entity.client.PiglinBoss;
import net.justus.pbossmod.entity.custom.PiglinBossEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PiglinBossRenderer extends MobRenderer<PiglinBossEntity, PiglinBoss<PiglinBossEntity>> {
    public PiglinBossRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PiglinBoss<>(pContext.bakeLayer(ModModelLayers.PIGLINBOSS_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(PiglinBossEntity pEntity) {
        return new ResourceLocation(ExampleMod.MOD_ID, "textures/entity/piglin_boss.png");
    }

    @Override
    protected void setupRotations(PiglinBossEntity entity, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick) {
        super.setupRotations(entity, poseStack, ageInTicks, rotationYaw, partialTick);
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(180.0F));
    }

    @Override
    public void render(PiglinBossEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
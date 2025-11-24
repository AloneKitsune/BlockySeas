package com.alone.blocky_seas.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.alone.blocky_seas.entity.GameAbility1WhiteEntity;
import com.alone.blocky_seas.client.model.Modelgameabil1_white;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GameAbility1WhiteRenderer extends EntityRenderer<GameAbility1WhiteEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("blocky_seas:textures/entities/gameabil1_white.png");
	private final Modelgameabil1_white model;

	public GameAbility1WhiteRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelgameabil1_white(context.bakeLayer(Modelgameabil1_white.LAYER_LOCATION));
	}

	@Override
	public void render(GameAbility1WhiteEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(GameAbility1WhiteEntity entity) {
		return texture;
	}
}
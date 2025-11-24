package com.alone.blocky_seas.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelgameabil1_green<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("blockyseas", "modelgamefruitabil_1_converted"), "main");
	public final ModelPart group2;
	public final ModelPart group;
	public final ModelPart group3;
	public final ModelPart bone;

	public Modelgameabil1_green(ModelPart root) {
		this.group2 = root.getChild("group2");
		this.group = this.group2.getChild("group");
		this.group3 = this.group2.getChild("group3");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition group2 = partdefinition.addOrReplaceChild("group2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 17.0F, -4.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition group = group2.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(0, 4).addBox(-8.0F, -24.5F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-8.0F, -24.5F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-10.0F, -24.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-10.0F, -24.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-10.0F, -24.5F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-10.0F, -24.5F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-10.0F, -24.5F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 0).addBox(-8.0F, -24.5F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 0)
						.addBox(-12.0F, -24.5F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-8.0F, -24.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-8.0F, -24.5F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-8.0F, -24.5F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-6.0F, -24.5F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-6.0F, -24.5F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-6.0F, -24.5F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-6.0F, -24.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-6.0F, -24.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-6.0F, -24.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-3.0F, -24.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-3.0F, -24.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-4.0F, -24.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-4.0F, -24.5F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 7.0F, 0.0F));
		PartDefinition group3 = group2.addOrReplaceChild("group3",
				CubeListBuilder.create().texOffs(0, 4).addBox(-4.0F, -10.5F, 8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-2.0F, -10.5F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -10.5F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-2.0F, -10.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -10.5F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-4.0F, -10.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-4.0F, -10.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-4.0F, -10.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-4.0F, -10.5F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-4.0F, -10.5F, 4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-6.0F, -10.5F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-6.0F, -10.5F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-7.0F, -10.5F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-7.0F, -10.5F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, -7.0F, 0.0F));
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 4).addBox(-6.0F, -24.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-6.0F, -24.5F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-6.0F, -24.5F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-6.0F, -24.5F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-4.0F, -24.5F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-4.0F, -24.5F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -24.5F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-2.0F, -24.5F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -24.5F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-2.0F, -24.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -24.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-2.0F, -24.5F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -24.5F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(0.0F, -24.5F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(0.0F, -24.5F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-2.0F, -24.5F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-4.0F, -24.5F, -11.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(0.0F, -24.5F, 9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -24.5F, 9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(-4.0F, -24.5F, 9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(0.0F, -24.5F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(0.0F, -24.5F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(0.0F, -24.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(0.0F, -24.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(0.0F, -24.5F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(0.0F, -24.5F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(2.0F, -24.5F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(2.0F, -24.5F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(2.0F, -24.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(2.0F, -24.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 0)
						.addBox(2.0F, -24.5F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 0).addBox(2.0F, -24.5F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(2.0F, -24.5F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(2.0F, -24.5F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(0.0F, -24.5F, 7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(2.0F, -24.5F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(0.0F, -24.5F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(4.0F, -24.5F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(4.0F, -24.5F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(4.0F, -24.5F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(4.0F, -24.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(4.0F, -24.5F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(4.0F, -24.5F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(6.0F, -24.5F, 3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(8.0F, -24.5F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(8.0F, -24.5F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(6.0F, -24.5F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4).addBox(4.0F, -24.5F, 5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		group2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
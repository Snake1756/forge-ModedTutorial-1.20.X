package net.justus.pbossmod.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.justus.pbossmod.entity.animations.ModAnimationsDefinitions;
import net.justus.pbossmod.entity.custom.PiglinBossEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;


public class PiglinBoss<T extends Entity> extends HierarchicalModel<T>{
	private final ModelPart piglinboss;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart head;
	private final ModelPart skull;
	private final ModelPart left_tooth;
	private final ModelPart right_tooth;
	private final ModelPart crown;
	private final ModelPart Kamm;
	private final ModelPart bone3;
	private final ModelPart bone2;
	private final ModelPart right_ear;
	private final ModelPart left_ear;
	private final ModelPart guertel_schnalle;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart right_toe;
	private final ModelPart left_toe;
	private final ModelPart left_leg;
	private final ModelPart right_leg;

	public PiglinBoss(ModelPart root) {
		this.piglinboss = root.getChild("piglinboss");
		this.body = this.piglinboss.getChild("body");
		this.torso = this.body.getChild("torso");
		this.head = this.torso.getChild("head");
		this.skull = this.head.getChild("skull");
		this.left_tooth = this.skull.getChild("left_tooth");
		this.right_tooth = this.skull.getChild("right_tooth");
		this.crown = this.skull.getChild("crown");
		this.Kamm = this.crown.getChild("Kamm");
		this.bone3 = this.Kamm.getChild("bone3");
		this.bone2 = this.Kamm.getChild("bone2");
		this.right_ear = this.skull.getChild("right_ear");
		this.left_ear = this.skull.getChild("left_ear");
		this.guertel_schnalle = this.torso.getChild("guertel_schnalle");
		this.left_arm = this.body.getChild("left_arm");
		this.right_arm = this.body.getChild("right_arm");
		this.right_toe = this.body.getChild("right_toe");
		this.left_toe = this.body.getChild("left_toe");
		this.left_leg = this.body.getChild("left_leg");
		this.right_leg = this.body.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition piglinboss = partdefinition.addOrReplaceChild("piglinboss", CubeListBuilder.create(), PartPose.offset(-7.0F, 24.0F, 0.0F));

		PartDefinition body = piglinboss.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(7.0F, -37.0F, 5.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 1.0F, -11.0F, 18.0F, 23.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 35).addBox(-6.0F, -9.0F, -10.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nose_r1 = skull.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(28, 55).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition left_tooth = skull.addOrReplaceChild("left_tooth", CubeListBuilder.create().texOffs(28, 61).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.19F))
		.texOffs(80, 26).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.0F, 1.0F, 1.0F, -0.2182F, 0.1745F, -0.0873F));

		PartDefinition right_tooth = skull.addOrReplaceChild("right_tooth", CubeListBuilder.create().texOffs(36, 61).addBox(0.0F, -2.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.19F))
		.texOffs(82, 59).addBox(0.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 1.0F, -0.2182F, -0.1745F, 0.0873F));

		PartDefinition crown = skull.addOrReplaceChild("crown", CubeListBuilder.create().texOffs(74, 47).addBox(1.0F, -1.0F, 4.8F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.001F))
		.texOffs(74, 52).addBox(-3.0F, -1.0F, 4.8F, 2.0F, 4.0F, 1.0F, new CubeDeformation(-0.001F))
		.texOffs(56, 66).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -5.0F));

		PartDefinition Kamm = crown.addOrReplaceChild("Kamm", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.0F, 5.0F));

		PartDefinition bone3 = Kamm.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(80, 51).addBox(1.0F, -2.0F, -5.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(74, 57).addBox(1.0F, -4.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(78, 57).addBox(1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition bone2 = Kamm.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(82, 55).addBox(1.0F, -2.0F, -5.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(76, 21).addBox(1.0F, -4.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(80, 21).addBox(1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_ear = skull.addOrReplaceChild("right_ear", CubeListBuilder.create(), PartPose.offset(-8.0F, -6.0F, -5.0F));

		PartDefinition RechtesOhr_r1 = right_ear.addOrReplaceChild("RechtesOhr_r1", CubeListBuilder.create().texOffs(74, 38).addBox(0.3F, -3.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition left_ear = skull.addOrReplaceChild("left_ear", CubeListBuilder.create(), PartPose.offset(8.0F, -6.0F, -5.0F));

		PartDefinition LinkesOhr_r1 = left_ear.addOrReplaceChild("LinkesOhr_r1", CubeListBuilder.create().texOffs(74, 29).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition guertel_schnalle = torso.addOrReplaceChild("guertel_schnalle", CubeListBuilder.create().texOffs(60, 29).addBox(-3.0F, -4.0F, -0.7F, 6.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
		.texOffs(78, 62).addBox(-3.0F, -3.0F, -0.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F))
		.texOffs(60, 33).addBox(0.0F, -2.0F, -0.7F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
		.texOffs(80, 47).addBox(2.0F, -3.0F, -0.7F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F))
		.texOffs(60, 31).addBox(-3.0F, 0.0F, -0.7F, 6.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 23.0F, 1.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 55).addBox(-5.0F, -10.0F, -4.0F, 6.0F, 21.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 10.0F, -5.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(44, 35).addBox(-1.0F, -12.0F, -4.0F, 7.0F, 23.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 10.0F, -5.0F));

		PartDefinition right_toe = body.addOrReplaceChild("right_toe", CubeListBuilder.create().texOffs(60, 25).addBox(-5.0F, -2.0F, -2.65F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(8.0F, 37.0F, 0.0F));

		PartDefinition left_toe = body.addOrReplaceChild("left_toe", CubeListBuilder.create().texOffs(60, 21).addBox(-1.0F, -2.0F, -2.65F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(-8.0F, 37.0F, 0.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(28, 66).addBox(-2.0F, -13.0F, -4.0F, 6.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 37.0F, -5.0F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(60, 0).addBox(-4.0F, -13.0F, -4.0F, 6.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 37.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animateWalk(ModAnimationsDefinitions.WALK, limbSwing, limbSwingAmount, 2f,2.5f);
		this.animate(((PiglinBossEntity) entity).attackAnimationState, ModAnimationsDefinitions.ATTACK, ageInTicks, 1f);

	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		piglinboss.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}


	@Override
	public ModelPart root() {
		return piglinboss;
	}
}
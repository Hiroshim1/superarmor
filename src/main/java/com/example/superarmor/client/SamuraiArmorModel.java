package com.example.superarmor.client;

import com.example.superarmor.SuperArmor;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

/** Armadura samurai en 3D (generada). Cada pieza solo muestra su parte segun la ranura. */
public class SamuraiArmorModel extends HumanoidModel<LivingEntity> {
    public static final ModelLayerLocation LAYER =
            new ModelLayerLocation(new ResourceLocation(SuperArmor.MODID, "samurai_armor"), "main");

    public SamuraiArmorModel(ModelPart root, EquipmentSlot slot) {
        super(root);
        this.head.getChild("h_dome").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_bowl").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_rim").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_crest").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_hornr").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_hornl").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_sk1").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_sk2").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_sk3").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_skr").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_skl").visible = slot == EquipmentSlot.HEAD;
        this.head.getChild("h_mask").visible = slot == EquipmentSlot.HEAD;
        this.body.getChild("c_dou").visible = slot == EquipmentSlot.CHEST;
        this.body.getChild("c_mune").visible = slot == EquipmentSlot.CHEST;
        this.body.getChild("c_back").visible = slot == EquipmentSlot.CHEST;
        this.body.getChild("c_obi").visible = slot == EquipmentSlot.CHEST;
        this.rightArm.getChild("c_s1").visible = slot == EquipmentSlot.CHEST;
        this.rightArm.getChild("c_s2").visible = slot == EquipmentSlot.CHEST;
        this.rightArm.getChild("c_s3").visible = slot == EquipmentSlot.CHEST;
        this.rightArm.getChild("c_kote").visible = slot == EquipmentSlot.CHEST;
        this.rightArm.getChild("c_cuff").visible = slot == EquipmentSlot.CHEST;
        this.leftArm.getChild("c_s1").visible = slot == EquipmentSlot.CHEST;
        this.leftArm.getChild("c_s2").visible = slot == EquipmentSlot.CHEST;
        this.leftArm.getChild("c_s3").visible = slot == EquipmentSlot.CHEST;
        this.leftArm.getChild("c_kote").visible = slot == EquipmentSlot.CHEST;
        this.leftArm.getChild("c_cuff").visible = slot == EquipmentSlot.CHEST;
        this.body.getChild("l_kf0").visible = slot == EquipmentSlot.LEGS;
        this.body.getChild("l_kb0").visible = slot == EquipmentSlot.LEGS;
        this.body.getChild("l_kf1").visible = slot == EquipmentSlot.LEGS;
        this.body.getChild("l_kb1").visible = slot == EquipmentSlot.LEGS;
        this.body.getChild("l_kf2").visible = slot == EquipmentSlot.LEGS;
        this.body.getChild("l_kb2").visible = slot == EquipmentSlot.LEGS;
        this.body.getChild("l_ksr").visible = slot == EquipmentSlot.LEGS;
        this.body.getChild("l_ksl").visible = slot == EquipmentSlot.LEGS;
        this.rightLeg.getChild("l_thigh").visible = slot == EquipmentSlot.LEGS;
        this.rightLeg.getChild("l_band").visible = slot == EquipmentSlot.LEGS;
        this.leftLeg.getChild("l_thigh").visible = slot == EquipmentSlot.LEGS;
        this.leftLeg.getChild("l_band").visible = slot == EquipmentSlot.LEGS;
        this.rightLeg.getChild("b_shin").visible = slot == EquipmentSlot.FEET;
        this.rightLeg.getChild("b_cuff").visible = slot == EquipmentSlot.FEET;
        this.rightLeg.getChild("b_strap").visible = slot == EquipmentSlot.FEET;
        this.rightLeg.getChild("b_sole").visible = slot == EquipmentSlot.FEET;
        this.leftLeg.getChild("b_shin").visible = slot == EquipmentSlot.FEET;
        this.leftLeg.getChild("b_cuff").visible = slot == EquipmentSlot.FEET;
        this.leftLeg.getChild("b_strap").visible = slot == EquipmentSlot.FEET;
        this.leftLeg.getChild("b_sole").visible = slot == EquipmentSlot.FEET;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition rightArm = root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
        PartDefinition leftArm = root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
        PartDefinition rightLeg = root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
        PartDefinition leftLeg = root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));

        head.addOrReplaceChild("h_dome", CubeListBuilder.create().texOffs(0, 26).addBox(-3.0F, -11.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.ZERO);
        head.addOrReplaceChild("h_bowl", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.65F)), PartPose.ZERO);
        head.addOrReplaceChild("h_rim", CubeListBuilder.create().texOffs(68, 16).addBox(-4.0F, -5.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.85F)), PartPose.ZERO);
        head.addOrReplaceChild("h_crest", CubeListBuilder.create().texOffs(116, 34).addBox(-1.5F, -11.0F, -5.2F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        head.addOrReplaceChild("h_hornr", CubeListBuilder.create().texOffs(104, 0).addBox(-0.5F, -8.0F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -9.5F, -4.4F, 0.0F, 0.0F, -0.55F));
        head.addOrReplaceChild("h_hornl", CubeListBuilder.create().texOffs(104, 0).addBox(-0.5F, -8.0F, -1.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -9.5F, -4.4F, 0.0F, 0.0F, 0.55F));
        head.addOrReplaceChild("h_sk1", CubeListBuilder.create().texOffs(74, 34).addBox(-5.0F, -5.0F, 3.3F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        head.addOrReplaceChild("h_sk2", CubeListBuilder.create().texOffs(0, 34).addBox(-5.5F, -3.0F, 3.5F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        head.addOrReplaceChild("h_sk3", CubeListBuilder.create().texOffs(28, 34).addBox(-6.0F, -1.0F, 3.7F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        head.addOrReplaceChild("h_skr", CubeListBuilder.create().texOffs(88, 0).addBox(-6.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        head.addOrReplaceChild("h_skl", CubeListBuilder.create().texOffs(88, 0).addBox(4.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        head.addOrReplaceChild("h_mask", CubeListBuilder.create().texOffs(98, 34).addBox(-4.0F, -3.5F, -4.8F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.ZERO);
        body.addOrReplaceChild("c_dou", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.ZERO);
        body.addOrReplaceChild("c_mune", CubeListBuilder.create().texOffs(66, 26).addBox(-3.0F, 1.0F, -3.3F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("c_back", CubeListBuilder.create().texOffs(52, 26).addBox(-3.0F, 1.0F, 2.3F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("c_obi", CubeListBuilder.create().texOffs(80, 26).addBox(-4.0F, 10.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.ZERO);
        rightArm.addOrReplaceChild("c_s1", CubeListBuilder.create().texOffs(40, 16).addBox(-5.5F, -3.5F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        rightArm.addOrReplaceChild("c_s2", CubeListBuilder.create().texOffs(10, 16).addBox(-6.0F, -1.5F, -4.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        rightArm.addOrReplaceChild("c_s3", CubeListBuilder.create().texOffs(56, 0).addBox(-6.5F, 0.5F, -4.5F, 7.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        rightArm.addOrReplaceChild("c_kote", CubeListBuilder.create().texOffs(110, 0).addBox(-3.0F, 3.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.ZERO);
        rightArm.addOrReplaceChild("c_cuff", CubeListBuilder.create().texOffs(58, 34).addBox(-3.0F, 8.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.65F)), PartPose.ZERO);
        leftArm.addOrReplaceChild("c_s1", CubeListBuilder.create().texOffs(40, 16).addBox(-1.5F, -3.5F, -3.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        leftArm.addOrReplaceChild("c_s2", CubeListBuilder.create().texOffs(10, 16).addBox(-1.0F, -1.5F, -4.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        leftArm.addOrReplaceChild("c_s3", CubeListBuilder.create().texOffs(56, 0).addBox(-0.5F, 0.5F, -4.5F, 7.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        leftArm.addOrReplaceChild("c_kote", CubeListBuilder.create().texOffs(110, 0).addBox(-1.0F, 3.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.ZERO);
        leftArm.addOrReplaceChild("c_cuff", CubeListBuilder.create().texOffs(58, 34).addBox(-1.0F, 8.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.65F)), PartPose.ZERO);
        body.addOrReplaceChild("l_kf0", CubeListBuilder.create().texOffs(24, 26).addBox(-4.5F, 11.0F, -3.2F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("l_kb0", CubeListBuilder.create().texOffs(24, 26).addBox(-4.5F, 11.0F, 2.2F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("l_kf1", CubeListBuilder.create().texOffs(24, 26).addBox(-1.5F, 11.0F, -3.2F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("l_kb1", CubeListBuilder.create().texOffs(24, 26).addBox(-1.5F, 11.0F, 2.2F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("l_kf2", CubeListBuilder.create().texOffs(24, 26).addBox(1.5F, 11.0F, -3.2F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("l_kb2", CubeListBuilder.create().texOffs(24, 26).addBox(1.5F, 11.0F, 2.2F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("l_ksr", CubeListBuilder.create().texOffs(0, 16).addBox(-5.2F, 11.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        body.addOrReplaceChild("l_ksl", CubeListBuilder.create().texOffs(0, 16).addBox(4.2F, 11.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.ZERO);
        rightLeg.addOrReplaceChild("l_thigh", CubeListBuilder.create().texOffs(110, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.ZERO);
        rightLeg.addOrReplaceChild("l_band", CubeListBuilder.create().texOffs(58, 34).addBox(-2.0F, 5.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.ZERO);
        leftLeg.addOrReplaceChild("l_thigh", CubeListBuilder.create().texOffs(110, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.ZERO);
        leftLeg.addOrReplaceChild("l_band", CubeListBuilder.create().texOffs(58, 34).addBox(-2.0F, 5.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.ZERO);
        rightLeg.addOrReplaceChild("b_shin", CubeListBuilder.create().texOffs(100, 16).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.ZERO);
        rightLeg.addOrReplaceChild("b_cuff", CubeListBuilder.create().texOffs(58, 34).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.65F)), PartPose.ZERO);
        rightLeg.addOrReplaceChild("b_strap", CubeListBuilder.create().texOffs(104, 26).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.ZERO);
        rightLeg.addOrReplaceChild("b_sole", CubeListBuilder.create().texOffs(32, 26).addBox(-2.0F, 11.2F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.ZERO);
        leftLeg.addOrReplaceChild("b_shin", CubeListBuilder.create().texOffs(100, 16).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.55F)), PartPose.ZERO);
        leftLeg.addOrReplaceChild("b_cuff", CubeListBuilder.create().texOffs(58, 34).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.65F)), PartPose.ZERO);
        leftLeg.addOrReplaceChild("b_strap", CubeListBuilder.create().texOffs(104, 26).addBox(-2.0F, 10.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.ZERO);
        leftLeg.addOrReplaceChild("b_sole", CubeListBuilder.create().texOffs(32, 26).addBox(-2.0F, 11.2F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.ZERO);

        return LayerDefinition.create(mesh, 128, 128);
    }
}

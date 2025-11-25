package com.alone.blocky_seas.client.screens;

import com.alone.blocky_seas.abilitydisplaydata.DisplayData;
import com.alone.blocky_seas.procedures.HelperMethods;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import com.alone.blocky_seas.abilitydisplaydata.FruitAbilities;

import java.util.concurrent.atomic.AtomicReference;
import java.util.ArrayList;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class AbilitiesOverlay {

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		Player entity = Minecraft.getInstance().player;
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);

		
		// display icons
		if (HelperMethods.hasFruit(entity) || HelperMethods.holdingAbilityWeapon(entity) && entity != null)
        {
            int textureWidth = 16;
            int textureHeight = 16;

            // Padding from screen edges
            int paddingX = 10;   // distance from left edge
            int paddingY = 10;   // distance from bottom edge

            // Compute position so the texture sits above bottom-left
            int _x = paddingX;
            int _y = h - textureHeight - paddingY;


			// old
//            for (int i =0; i < DisplayData.getAbilityAssets(entity).size(); i++) {
//                event.getGuiGraphics().blit(ResourceLocation.parse(DisplayData.getAbilityTexture(DisplayData.getAbilityAssets(entity),i)), _x+i*(16), _y, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
//            }

			// new
			for (int i = 0; i < 5; i++) {
				event.getGuiGraphics().blit(ResourceLocation.parse(DisplayData.getFruitAbilityIcon(entity,i)), _x+i*(16), _y, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
			}

			ArrayList<AtomicReference<Double>> abilityRefs = new ArrayList<>();
			
			abilityRefs.add(new AtomicReference<Double>());
			abilityRefs.add(new AtomicReference<Double>());
			abilityRefs.add(new AtomicReference<Double>());
			abilityRefs.add(new AtomicReference<Double>());
			abilityRefs.add(new AtomicReference<Double>());
			
			

			entity.getCapability(com.alone.blocky_seas.network.BlockySeasModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(cap ->
			{
			    abilityRefs.get(0).set(cap.ability1);
			    abilityRefs.get(1).set(cap.ability2);
			    abilityRefs.get(2).set(cap.ability3);
			    abilityRefs.get(3).set(cap.ability4);
			    abilityRefs.get(4).set(cap.ability5);
			});
	
			// must not have cd
			for (int i = 0; i < abilityRefs.size(); i++) {
				if(abilityRefs.get(i).get() != 0){
                event.getGuiGraphics().blit(ResourceLocation.parse("blocky_seas:textures/screens/cooldown_icon.png"), _x+i*(16), _y, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight);
				}
            }
            
            
        }

        
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}
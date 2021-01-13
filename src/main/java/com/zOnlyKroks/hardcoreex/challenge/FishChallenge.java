package com.zOnlyKroks.hardcoreex.challenge;

import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import com.zOnlyKroks.hardcoreex.render.LayerModel;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class FishChallenge extends Challenge{

    public FishChallenge() {
        super(ConfigBuilder.only_fish_challange);
    }

    @Override
    protected void tick() {
    }


    @SubscribeEvent
    public static void doClientStuff(FMLClientSetupEvent event) {
        Minecraft.getInstance().getRenderManager().getSkinMap().forEach((s, playerRenderer) -> {
            playerRenderer.addLayer(new LayerModel(playerRenderer));
        });
    }


    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Pre event) {
        event.getRenderer().getEntityModel().setVisible(false);
    }


    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Post event) {
        event.getRenderer().getEntityModel().setVisible(true);
    }


    @SubscribeEvent
    public static void onPlayerChangeSeize(EntityEvent.Size event) {
        if(event.getEntity() instanceof PlayerEntity) {
            event.setNewSize(EntitySize.flexible(1.0F, 0.5F));
            event.setNewEyeHeight(0.4F);
        }
    }


    @SubscribeEvent
    public static void entityTick(TickEvent.PlayerTickEvent event) {
        EntitySize size = event.player.getSize(Pose.STANDING);
        if(event.player.getSize(Pose.STANDING).equals(size)) {
            event.player.recalculateSize();
        }
    }


    @SubscribeEvent
    public static void waterCheck(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        if(player.isInWater()) {
            event.player.setAir(300);
        }else if(!player.isInWater()) {
            player.attackEntityFrom(DamageSource.DROWN, 0.5F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
        // Cancel event, we don't want the player to die.
        event.setCanceled(true);

        // Check if there's a client player.
        if (Minecraft.getInstance().player != null) {
            // Check if the entity is the client player.
            if (event.getEntityLiving().getEntityId() == Minecraft.getInstance().player.getEntityId()) {
                // Fail challenge.
                this.failChallenge();
            }
        }
    }
}

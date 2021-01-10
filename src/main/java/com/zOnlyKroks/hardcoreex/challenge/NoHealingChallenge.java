package com.zOnlyKroks.hardcoreex.challenge;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NoHealingChallenge extends Challenge{
    public NoHealingChallenge() {
        super(ConfigBuilder.no_healing_challange);
    }

    @Override
    protected void tick() {

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void playerRegen(LivingHealEvent event) {
        if (ConfigBuilder.no_healing_challange.get()) {
            if (event.getEntity() instanceof PlayerEntity) {
                event.setCanceled(true);
            }
        }else{
            HardcoreExtended.LOGGER.debug("No Healing Challange not activated. Activate it in the config if this is not intentional");
        }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void playerJump(LivingEvent.LivingJumpEvent event) {
        if (ConfigBuilder.no_jumping_challange.get()) {
            Entity player = event.getEntity();

            double x = player.getMotion().x;
            double z = player.getMotion().z;

            player.setMotion(x,0,z);
        } else{
            HardcoreExtended.LOGGER.debug("No Jumping Challange not activated. Activate it in the config if this is not intentional");
        }
    }
}

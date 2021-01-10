package com.zOnlyKroks.hardcoreex.challenge;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class NoSleepChallenge extends Challenge{

    public NoSleepChallenge() {
        super(ConfigBuilder.no_sleep_challange);
    }

    @Override
    protected void tick() {
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

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void blockBreakEvent(PlayerSleepInBedEvent event) {
        if(ConfigBuilder.no_sleep_challange.get()) {
            if (event.getPlayer() != null) {
                event.setCanceled(true);
            }
        }else{
            HardcoreExtended.LOGGER.debug("No Sleep Challange not activated. Activate it in the config if this is not intentional");
        }
    }
}
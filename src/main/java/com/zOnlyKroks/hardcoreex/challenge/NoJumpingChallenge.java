package com.zOnlyKroks.hardcoreex.challenge;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * No jumping challenge
 * Stops the player able to jump.
 *
 * @author zOnlyKroks, Qboi123
 */
public class NoJumpingChallenge extends Challenge{

    public NoJumpingChallenge() {
        super(ConfigBuilder.no_jumping_challange);
    }

    @Override
    protected void tick() {
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void playerJump(LivingEvent.LivingJumpEvent event) {
        Entity player = event.getEntity();

        double x = player.getMotion().x;
        double z = player.getMotion().z;

        player.setMotion(x,-0.1,z); // Set motion downwards if already was in air.
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

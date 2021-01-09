package com.zOnlyKroks.Hardcoreex.challenge;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

/**
 * The no-damage challenge!
 * When you take damage, the challenge is failed.
 *
 * @author Qboi123
 */
public class NoDamageChallenge extends Challenge {
    public NoDamageChallenge() {
        super();
    }

    /**
     * An example tick event.
     * Used to do things like in the no-day challenge.
     *
     * Not needed to use it for this challenge, so it's empty.
     */
    public void tick() {

    }

    /**
     * An example event.
     * This event checks for damage by the player.
     * 
     * @param event the event used for the no-damage challenge.
     */
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onDamage(LivingDamageEvent event) {
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

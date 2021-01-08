package com.zOnlyKroks.Hardcoreex.event;

import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.config.ConfigBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class JumpEvent {

    @SubscribeEvent
    public void playerJump(LivingEvent.LivingJumpEvent event) {
        if (ConfigBuilder.no_jumping_challange.get()) {
                Entity player = event.getEntity();

                double x = player.getMotion().x;
                double z = player.getMotion().z;

                player.setMotion(x,0,z);
            } else{
            Hardcore.LOGGER.debug("No Jumping Challange not activated. Activate it in the config if this is not intentional");
        }
    }
}

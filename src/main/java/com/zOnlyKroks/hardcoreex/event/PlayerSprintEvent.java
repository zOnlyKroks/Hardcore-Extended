package com.zOnlyKroks.hardcoreex.event;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class PlayerSprintEvent {

    @SubscribeEvent
    public static void blockBreakEvent(TickEvent.PlayerTickEvent event) {
        if(ConfigBuilder.no_sprinting_challange.get()) {
            if (event.player != null) {
                if (event.player.isSprinting()) {
                    event.player.setSprinting(false);
                }
            }
        }else{
            HardcoreExtended.LOGGER.debug("No Sprinting Challange not activated. Activate it in the config if this is not intentional");
        }
    }
}

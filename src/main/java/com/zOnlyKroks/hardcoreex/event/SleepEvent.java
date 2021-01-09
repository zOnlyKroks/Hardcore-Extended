package com.zOnlyKroks.hardcoreex.event;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class SleepEvent {

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

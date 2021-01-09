package com.zOnlyKroks.hardcoreex.event;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class BlockBreakEvent {
    @SubscribeEvent
    public static void blockBreakEvent(BlockEvent.BreakEvent event) {
        if(ConfigBuilder.no_block_breaking_challange.get()) {
            if(event.getPlayer() != null) {
                event.setCanceled(true);
            }
        }else{
            HardcoreExtended.LOGGER.debug("No Block Breaking Challenge not activated. Activate it in the config if this is not intentional");
        }
    }
}

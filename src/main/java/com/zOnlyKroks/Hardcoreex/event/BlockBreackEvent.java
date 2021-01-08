package com.zOnlyKroks.Hardcoreex.event;

import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.config.ConfigBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class BlockBreackEvent {

    @SubscribeEvent
    public void blockBreakEvent(BlockEvent.BreakEvent event) {
        if(ConfigBuilder.no_block_breaking_challange.get()) {
            if(event.getPlayer() instanceof PlayerEntity) {
                event.setCanceled(true);
            }
        }else{
            Hardcore.LOGGER.debug("No Block Breacking Challange not activated. Activate it in the config if this is not intentional");
        }
    }
}

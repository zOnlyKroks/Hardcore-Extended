package com.zOnlyKroks.Hardcoreex.event;

import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.config.ConfigBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class PlayerSprintEvent {

    @SubscribeEvent
    public void blockBreakEvent(TickEvent.PlayerTickEvent event) {
        if(ConfigBuilder.no_sprinting_challange.get()) {
            if (event.player instanceof PlayerEntity) {
                if (event.player.isSprinting()) {
                    event.player.setSprinting(false);
                }
            }
        }else{
            Hardcore.LOGGER.debug("No Sprinting Challange not activated. Activate it in the config if this is not intentional");
        }
    }
}

package com.zOnlyKroks.Hardcoreex.event;

import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.config.ConfigBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class HealingEvent {

    @SubscribeEvent
    public void playerRegen(LivingHealEvent event) {
        if (ConfigBuilder.no_healing_challange.get()) {
            if (event.getEntity() instanceof PlayerEntity) {
                event.setCanceled(true);
            }
        }else{
            Hardcore.LOGGER.debug("No Healing Challange not activated. Activate it in the config if this is not intentional");
        }
    }
}

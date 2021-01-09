package com.zOnlyKroks.hardcoreex.event;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.config.ConfigBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.storage.IServerWorldInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class NoDayEvent{

    @SubscribeEvent
    public static void respawnEvent(PlayerEvent.PlayerRespawnEvent event) {

        if (ConfigBuilder.no_day_challange.get()) {
            PlayerEntity player = event.getPlayer();
            GameRules.BooleanValue gamerule = player.world.getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE);
            gamerule.set(false, event.getPlayer().getServer());
            HardcoreExtended.LOGGER.debug(gamerule + "(doDaylightCycle)");
            IServerWorldInfo worldInfo = (IServerWorldInfo) (player.world.getWorldInfo());
            worldInfo.setDayTime(18000);
        }else{
            HardcoreExtended.LOGGER.debug("No Day Challange not activated. Activate it in the config if this is not intentional");
        }
    }

    @SubscribeEvent
    public static void joinEvent(EntityJoinWorldEvent event) {
        if (ConfigBuilder.no_day_challange.get()) {
            if(event.getEntity() instanceof  PlayerEntity) {
                ((PlayerEntity) event.getEntity()).setHealth(0);
            }
        }
    }

}

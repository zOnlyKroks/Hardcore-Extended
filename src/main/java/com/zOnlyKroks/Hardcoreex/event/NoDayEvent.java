package com.zOnlyKroks.Hardcoreex.event;

import com.mojang.authlib.GameProfile;
import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.config.ConfigBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftGame;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.command.CommandSource;
import net.minecraft.command.impl.GameRuleCommand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.IServerWorldInfo;
import net.minecraft.world.storage.IWorldInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.codec.language.bm.Rule;

import java.security.Provider;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class NoDayEvent{

    @SubscribeEvent
    public void  respawnEvent(PlayerEvent.PlayerRespawnEvent event) {

        if (ConfigBuilder.no_day_challange.get()) {
            PlayerEntity player = event.getPlayer();
            GameRules.BooleanValue gamerule = player.world.getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE);
            gamerule.set(false, event.getPlayer().getServer());
            Hardcore.LOGGER.debug(gamerule + "(doDaylightCycle)");
            IServerWorldInfo worldInfo = (IServerWorldInfo) (player.world.getWorldInfo());
            worldInfo.setDayTime(18000);
        }else{
            Hardcore.LOGGER.debug("No Day Challange not activated. Activate it in the config if this is not intentional");
        }
    }

    @SubscribeEvent
    public void  joinEvent(EntityJoinWorldEvent event) {
        if (ConfigBuilder.no_day_challange.get()) {
            if(event.getEntity() instanceof  PlayerEntity) {
                ((PlayerEntity) event.getEntity()).setHealth(0);
            }
        }
    }

}

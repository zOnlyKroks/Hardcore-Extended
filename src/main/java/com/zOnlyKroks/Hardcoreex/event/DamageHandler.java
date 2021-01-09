package com.zOnlyKroks.Hardcoreex.event;

import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.client.gui.ChallengeFailedScreen;
import com.zOnlyKroks.Hardcoreex.config.ConfigBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//@Mod.EventBusSubscriber(Dist.CLIENT)
public class DamageHandler {
    @SubscribeEvent
    public void playerDamageEvent(LivingDamageEvent event) {
//        if (ConfigBuilder.no_damage_challange.get()) {
//            Entity entity = event.getEntity();
//            if (event.getEntity() instanceof PlayerEntity) {
//                Hardcore.LOGGER.debug("Worked?");
//                Minecraft.getInstance().displayGuiScreen(new ChallengeFailedScreen(event.getSource().getDeathMessage(event.getEntityLiving())));
//                PlayerEntity player = (PlayerEntity) entity;
//                player.setGameType(GameType.SPECTATOR);
//            }
//        }else{
//            Hardcore.LOGGER.debug("No Damage Challange not activated. Activate it in the config if this is not intentional");
//        }
    }
}

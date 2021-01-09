package com.zOnlyKroks.hardcoreex.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @deprecated Used in challenge object (registrable).
 */
@Deprecated
@Mod.EventBusSubscriber(Dist.CLIENT)
public class DamageHandler {
    @SubscribeEvent
    public static void playerDamageEvent(LivingDamageEvent event) {
//        if (ConfigBuilder.no_damage_challange.get()) {
//            Entity entity = event.getEntity();
//            if (event.getEntity() instanceof PlayerEntity) {
//                HardcoreExtended.LOGGER.debug("Worked?");
//                Minecraft.getInstance().displayGuiScreen(new ChallengeFailedScreen(event.getSource().getDeathMessage(event.getEntityLiving())));
//                PlayerEntity player = (PlayerEntity) entity;
//                player.setGameType(GameType.SPECTATOR);
//            }
//        }else{
//            HardcoreExtended.LOGGER.debug("No Damage Challange not activated. Activate it in the config if this is not intentional");
//        }
    }
}

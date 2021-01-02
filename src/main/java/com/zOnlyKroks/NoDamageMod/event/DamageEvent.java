package com.zOnlyKroks.NoDamageMod.event;

import com.zOnlyKroks.NoDamageMod.NoDamageMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.storage.SaveFormat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class DamageEvent {


    @SubscribeEvent
    public void playerDamageEvent(LivingDamageEvent event){
        if(event.getEntity() instanceof PlayerEntity) {
            NoDamageMod.LOGGER.debug("Worked?");
        }
    }

}

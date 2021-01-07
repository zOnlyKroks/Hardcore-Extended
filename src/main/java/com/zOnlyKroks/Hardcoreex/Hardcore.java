package com.zOnlyKroks.Hardcoreex;

import com.zOnlyKroks.Hardcoreex.event.DamageHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("hardcoreex")
public class Hardcore
{

    public static final String MOD_ID = "hardcoreex";
    public static final Logger LOGGER = LogManager.getLogger();

    public Hardcore() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);


        MinecraftForge.EVENT_BUS.register(new DamageHandler());

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onFingerprintViolation(final FMLFingerprintViolationEvent event)
    {
        LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName()
                + " may have been tampered with. This version will NOT be supported by the author!");
        LOGGER.warn("Expected " + event.getExpectedFingerprint() + " found " + event.getFingerprints().toString());
    }




}

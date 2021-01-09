package com.zOnlyKroks.Hardcoreex;

import com.zOnlyKroks.Hardcoreex.challenge.Challenge;
import com.zOnlyKroks.Hardcoreex.config.Config;
import com.zOnlyKroks.Hardcoreex.event.*;
import com.zOnlyKroks.Hardcoreex.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.http.config.RegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("hardcoreex")
public class Hardcore
{

    public static final String MOD_ID = "hardcoreex";
    public static final Logger LOGGER = LogManager.getLogger();

    public Hardcore() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);


//        MinecraftForge.EVENT_BUS.register(new DamageHandler());
        MinecraftForge.EVENT_BUS.register(new JumpEvent());
        MinecraftForge.EVENT_BUS.register(new HealingEvent());
        MinecraftForge.EVENT_BUS.register(new BlockBreackEvent());
        MinecraftForge.EVENT_BUS.register(new SleepEvent());
//        MinecraftForge.EVENT_BUS.register(new NoDayEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerSprintEvent());

        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("hardcoreex-client.toml").toString());
        Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("hardcoreex-server.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onFingerprintViolation(final FMLFingerprintViolationEvent event) {
        LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName()
                + " may have been tampered with. This version will NOT be supported by the author!");
        LOGGER.warn("Expected " + event.getExpectedFingerprint() + " found " + event.getFingerprints().toString());
    }

    @SubscribeEvent
    public void onRegistryNew(RegistryEvent.NewRegistry event) {
        RegistryBuilder<Challenge> challengeRegistry = RegistryBuilder.create();
        challengeRegistry.build();
    }

    public static final ItemGroup TAB = new ItemGroup("HardcoreExtendedItemGroup ") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CONFIG_ITEM.get());
        }
    };
}

package com.zOnlyKroks.NoDamageMod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;


@Mod("nodamod")
public class NoDamageMod
{

    public static final String MOD_ID = "nodamod";
    public static final Logger LOGGER = LogManager.getLogger();

    public NoDamageMod() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);


        //MinecraftForge.EVENT_BUS.register(new WindowCloseEvent());

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event)
    {

    }




}

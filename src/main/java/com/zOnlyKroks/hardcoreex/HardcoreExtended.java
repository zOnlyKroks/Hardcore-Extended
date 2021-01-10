package com.zOnlyKroks.hardcoreex;

import com.zOnlyKroks.hardcoreex.challenge.Challenge;
import com.zOnlyKroks.hardcoreex.config.Config;
import com.zOnlyKroks.hardcoreex.event.PlayerJoinWorldEvent;
import com.zOnlyKroks.hardcoreex.init.ModChallenges;
import com.zOnlyKroks.hardcoreex.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * HardcoreExtended Extended Mod class.
 * In this class the mod will be initialized.
 *
 * @author zOnlyKroks, Qboi123
 * @since 0.1
 */
@Mod("hardcoreex")
public class HardcoreExtended {
    public static final String MOD_ID = "hardcoreex";
    public static final Logger LOGGER = LogManager.getLogger();
    private static DeferredRegister<Challenge> CHALLENGES_REGISTRY;

    public static DeferredRegister<Challenge> getChallengesRegistry() {
        return CHALLENGES_REGISTRY;
    }

    /**
     * HardcoreExtended constructor.
     */
    public HardcoreExtended() {

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        modEventBus.addListener(this::setup);


        Config.init();

        MinecraftForge.EVENT_BUS.register(PlayerJoinWorldEvent.class);


        ModItems.ITEMS.register(modEventBus);
        ModChallenges.CHALLENGES.register(modEventBus);


        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Common setup event.
     *
     * @param event ...
     */
    public void setup(final FMLCommonSetupEvent event) {

    }


    /**
     * Main item group for the Hardcore Extended Mod.
     * 
     * Todo: need this to be a standalone class.
     */
    public static final ItemGroup TAB = new ItemGroup("HardcoreExtendedItemGroup ") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.CONFIG_ITEM.get());
        }
    };
}

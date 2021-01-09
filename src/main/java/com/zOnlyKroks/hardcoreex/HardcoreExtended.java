package com.zOnlyKroks.hardcoreex;

import com.zOnlyKroks.hardcoreex.challenge.Challenge;
import com.zOnlyKroks.hardcoreex.config.Config;
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
        // Get mod event bus.
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Add listener for common setup.
        modEventBus.addListener(this::setup);

        // Load configurations.
        Config.loadConfig(Config.CLIENT, FMLPaths.CONFIGDIR.get().resolve("hardcoreex-client.toml").toString());
        Config.loadConfig(Config.SERVER, FMLPaths.CONFIGDIR.get().resolve("hardcoreex-server.toml").toString());

        // Create registry for challenges.
        DeferredRegister<Challenge> registry = DeferredRegister.create(Challenge.class, HardcoreExtended.MOD_ID);
        registry.makeRegistry("challenges", RegistryBuilder::new);
        CHALLENGES_REGISTRY = registry;
        registry.register(modEventBus);

        // Register event bus to item deferred register, so the items will be registered.
        ModItems.ITEMS.register(modEventBus);

        // Register HardcoreExtended mod to the forge event bus.
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
     * Note: this uses deprecated API. Don't know why...
     *
     * @param event the {@link FMLFingerprintViolationEvent FML Fingerprint Violation Event}.
     */
    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public void onFingerprintViolation(final FMLFingerprintViolationEvent event) {
        LOGGER.warn("Invalid fingerprint detected! The file " + event.getSource().getName()
                + " may have been tampered with. This version will NOT be supported by the author!");
        LOGGER.warn("Expected " + event.getExpectedFingerprint() + " found " + event.getFingerprints().toString());
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

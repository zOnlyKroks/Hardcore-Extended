package com.zOnlyKroks.hardcoreex.challenge;

import com.zOnlyKroks.hardcoreex.client.gui.ChallengeFailedScreen;
import com.zOnlyKroks.hardcoreex.client.gui.widgets.ChallengeCompatibility;
import com.zOnlyKroks.hardcoreex.common.IChallengeProvider;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author Qboi123
 */
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public abstract class Challenge implements IChallengeProvider, IForgeRegistryEntry<Challenge> {
    private boolean enabled = false;
    private ForgeConfigSpec.BooleanValue configSpec;

    private ResourceLocation registryName;

    public Challenge(ForgeConfigSpec.BooleanValue configSpec) {
        setConfigSpec(configSpec);
        if (getConfigSpec().get() && !this.enabled) {
            enable();
        }
        if (!getConfigSpec().get() && this.enabled) {
            disable();
        }
    }

    @Override
    public Challenge getChallenge() {
        return this;
    }

    public final void enable() {
        MinecraftForge.EVENT_BUS.register(this);
        this.enabled = true;
        this.configSpec.set(true);
        this.configSpec.save();
    }

    public final void disable() {
        MinecraftForge.EVENT_BUS.unregister(this);
        this.enabled = false;
        this.configSpec.set(false);
        this.configSpec.save();
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    /**
     * Get and return the config specification.
     *
     * @return the config specification.
     */
    public ForgeConfigSpec.BooleanValue getConfigSpec() {
        return this.configSpec;
    }

    /**
     * Set the config specification.
     *
     * @param configSpec the config specification.
     */
    protected void setConfigSpec(ForgeConfigSpec.BooleanValue configSpec) {
        this.configSpec = configSpec;
    }

    /**
     * Set the challenge's registry name.
     *
     * @param name the registry name to set to.
     * @return the challenge object where this method called from.
     */
    @Override
    public Challenge setRegistryName(ResourceLocation name) {
        this.registryName = name;
        return this;
    }

    /**
     * This is used for ticking the challenge.
     *
     * @param event the client tick event needed.
     */
    @SubscribeEvent
    public final void onClientTick(TickEvent.ClientTickEvent event) {
        tick();
    }

    /**
     * Tick the challenge, in fact a client-tick event.
     */
    protected abstract void tick();

    @Nullable
    @Override
    public ResourceLocation getRegistryName() {
        return this.registryName;
    }

    @Override
    public Class<Challenge> getRegistryType() {
        return Challenge.class;
    }

    public TranslationTextComponent getLocalizedName() {
        if (getRegistryName() != null) {
            return new TranslationTextComponent("challenge." + 
                    getRegistryName().getNamespace() + "." + 
                    getRegistryName().getPath().replaceAll("/", "."));
        } else {
            throw new NullPointerException("Registry name is null.");
        }
    }

    /**
     * <h1>Get the Texture Location</h1>
     * In this method the texture will be located using the registry name.<br>
     * A registry name is a resource location that contains the Mod ID and a path.<br>
     * <br>
     * <!--Get texture location, it's relative to "assets/mod-id/"-->
     * <!--Replacing mod-id with the mod's id given in the resource location.-->
     *
     * <h2>Info:</h2>
     * @return the texture location/
     */
    public ResourceLocation getTextureLocation() {
        assert getRegistryName() != null;
        return new ResourceLocation(getRegistryName().getNamespace(), "textures/gui/challenges/" + getRegistryName().getPath() + ".png");
    }

    /**
     * @return if the challenge is enabled.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @return if the challenge is disabled.
     */
    public boolean isDisabled() {
        return !enabled;
    }

    /**
     * @return the challenge compatibility.
     */
    public ChallengeCompatibility getCompatibility() {
        return new ChallengeCompatibility(true, new StringTextComponent("TEST"));
    }

    /**
     * Let the player know that the challenge was failed.
     */
    protected final void failChallenge() {
        Minecraft.getInstance().displayGuiScreen(new ChallengeFailedScreen(this));
    }
}

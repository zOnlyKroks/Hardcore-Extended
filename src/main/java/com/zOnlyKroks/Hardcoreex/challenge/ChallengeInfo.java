package com.zOnlyKroks.Hardcoreex.challenge;

import net.minecraft.resources.IResourcePack;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.jetbrains.annotations.NotNull;

public class ChallengeInfo implements INameable {
    private final Challenge challenge;

    public ChallengeInfo(Challenge challenge) {
        this.challenge = challenge;
    }

    @Override
    public @NotNull ITextComponent getName() {
        return challenge.getLocalizedName();
    }

    public Challenge getChallenge() {
        return challenge;
    }
}

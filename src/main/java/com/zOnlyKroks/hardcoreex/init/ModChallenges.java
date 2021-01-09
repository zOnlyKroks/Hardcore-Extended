package com.zOnlyKroks.hardcoreex.init;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.challenge.Challenge;
import com.zOnlyKroks.hardcoreex.challenge.NoDamageChallenge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryBuilder;

@SuppressWarnings("unused")
public class ModChallenges {
    public static final DeferredRegister<Challenge> CHALLENGES = DeferredRegister.create(Challenge.class, HardcoreExtended.MOD_ID);;
    static {
        // Allow the registry to be registered.
        CHALLENGES.makeRegistry("challenges", RegistryBuilder::new);
    }

    public static final RegistryObject<NoDamageChallenge> NO_DAMAGE = CHALLENGES.register("no_damage", NoDamageChallenge::new);
}

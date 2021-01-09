package com.zOnlyKroks.hardcoreex.init;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.challenge.Challenge;
import com.zOnlyKroks.hardcoreex.challenge.NoDamageChallenge;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.DeferredRegister;

public class ModChallenges {
    public static final DeferredRegister<Challenge> CHALLENGES = HardcoreExtended.getChallengesRegistry();

    public static final RegistryObject<Challenge> NO_DAMAGE = CHALLENGES.register("no_damage", NoDamageChallenge::new);
}

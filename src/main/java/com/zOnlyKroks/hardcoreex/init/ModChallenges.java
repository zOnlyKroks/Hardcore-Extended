package com.zOnlyKroks.hardcoreex.init;

import com.zOnlyKroks.hardcoreex.HardcoreExtended;
import com.zOnlyKroks.hardcoreex.challenge.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryBuilder;

@SuppressWarnings("unused")
public class ModChallenges {
    public static final DeferredRegister<Challenge> CHALLENGES = DeferredRegister.create(Challenge.class, HardcoreExtended.MOD_ID);;
    static {
        // Allow the registry to be registered.
        CHALLENGES.makeRegistry("challenges", RegistryBuilder::new);
    }

    public static final RegistryObject<NoAttackingChallenge> NO_ATTACK = CHALLENGES.register("no_attack", NoAttackingChallenge::new);
    public static final RegistryObject<NoDamageChallenge> NO_DAMAGE = CHALLENGES.register("no_damage", NoDamageChallenge::new);
    public static final RegistryObject<NoDayChallenge> NO_DAY = CHALLENGES.register("no_day", NoDayChallenge::new);
    public static final RegistryObject<NoJumpingChallenge> NO_JUMPING = CHALLENGES.register("no_jumping", NoJumpingChallenge::new);
    public static final RegistryObject<NoBlockBreakingChallenge> NO_BLOCK_BREAKING = CHALLENGES.register("no_block_breaking", NoBlockBreakingChallenge::new);
    public static final RegistryObject<NoHealingChallenge> NO_HEALING = CHALLENGES.register("no_healing", NoHealingChallenge::new);
    public static final RegistryObject<NoSprintChallenge> NO_SPRINT = CHALLENGES.register("no_sprint", NoSprintChallenge::new);
    public static final RegistryObject<NoSleepChallenge> NO_SLEEP = CHALLENGES.register("no_sleep", NoSleepChallenge::new);
    //public static final RegistryObject<FishChallenge> ONLY_FISH = CHALLENGES.register("only_fish", FishChallenge::new);
}

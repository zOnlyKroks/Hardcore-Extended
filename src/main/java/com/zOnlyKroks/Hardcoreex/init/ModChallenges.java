package com.zOnlyKroks.Hardcoreex.init;

import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.challenge.Challenge;
import com.zOnlyKroks.Hardcoreex.challenge.NoDamageChallenge;
import com.zOnlyKroks.Hardcoreex.items.ConfigItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModChallenges {

    public static final DeferredRegister<Challenge> CHALLENGES = DeferredRegister.create(GameRegistry.findRegistry(Challenge.class), Hardcore.MOD_ID);

    public static final RegistryObject<Challenge> NO_DAMAGE = CHALLENGES.register("no_damage", NoDamageChallenge::new);
}

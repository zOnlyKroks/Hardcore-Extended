package com.zOnlyKroks.hardcoreex.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigBuilder {

    public static ForgeConfigSpec.BooleanValue no_damage_challange;
    public static ForgeConfigSpec.BooleanValue no_jumping_challange;
    public static ForgeConfigSpec.BooleanValue no_healing_challange;
    public static ForgeConfigSpec.BooleanValue no_block_breaking_challange;
    public static ForgeConfigSpec.BooleanValue no_sleep_challange;
    public static ForgeConfigSpec.BooleanValue no_day_challange;
    public static ForgeConfigSpec.BooleanValue no_sprinting_challange;
    public static ForgeConfigSpec.BooleanValue no_walking_challange;
    public static ForgeConfigSpec.BooleanValue only_fish_challange;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {

        server.comment("HardcoreExtended Extended Challange Config");

        no_damage_challange = server
                .comment("Decide if you want the No Damage Challenge")
                .define("challanges.no_damage_challenge", false);

        no_jumping_challange = server
                .comment("Decide if you want the No Jumping Challenge")
                .define("challanges.no_jumping_challenge", false);

        no_healing_challange = server
                .comment("Decide if you want the No Healing Challenge")
                .define("challanges.no_healing_challenge", false);

        no_block_breaking_challange = server
                .comment("Decide if you want the No Block Breacking Challenge")
                .define("challanges.no_block_breaking_challenge", false);

        no_sleep_challange = server
                .comment("Decide if you want the No Sleep Challenge")
                .define("challanges.no_sleep_challenge", false);

        no_day_challange = server
                .comment("Decide if you want the No Day Challenge")
                .define("challanges.no_day_challenge", false);

        no_sprinting_challange = server
                .comment("Decide if you want the No Sprinting Challenge")
                .define("challanges.no_sprinting_challenge", false);

        only_fish_challange = server
                .comment("Decide if you want the Fish Challenge")
                .define("challanges.only_fish_challange", false);

    }

}

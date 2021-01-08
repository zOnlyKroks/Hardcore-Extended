package com.zOnlyKroks.Hardcoreex.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigBuilder {

    public static ForgeConfigSpec.BooleanValue no_damage_challange;
    public static ForgeConfigSpec.BooleanValue no_jumping_challange;
    public static ForgeConfigSpec.BooleanValue no_healing_challange;
    public static ForgeConfigSpec.BooleanValue no_block_breaking_challange;
    public static ForgeConfigSpec.BooleanValue no_sleep_challange;
    public static ForgeConfigSpec.BooleanValue no_day_challange;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {

        server.comment("Hardcore Extended Challange Config");

        no_damage_challange = server
                .comment("Decide if you want the No Damage Challange")
                .define("challanges.no_damage_challange", false);

        no_jumping_challange = server
                .comment("Decide if you want the No Jumping Challange")
                .define("challanges.no_jumping_challange", false);

        no_healing_challange = server
                .comment("Decide if you want the No Healing Challange")
                .define("challanges.no_healing_challange", false);

        no_block_breaking_challange = server
                .comment("Decide if you want the No Block Breacking Challange")
                .define("challanges.no_block_breaking_challange", false);

        no_sleep_challange = server
                .comment("Decide if you want the No Sleep Challange")
                .define("challanges.no_sleep_challange", false);

        no_day_challange = server
                .comment("Decide if you want the No Day Challange")
                .define("challanges.no_day_challange", false);

    }

}

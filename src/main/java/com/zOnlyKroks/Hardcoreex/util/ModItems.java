package com.zOnlyKroks.Hardcoreex.util;

import com.zOnlyKroks.Hardcoreex.Hardcore;
import com.zOnlyKroks.Hardcoreex.config.Config;
import com.zOnlyKroks.Hardcoreex.items.ConfigItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Hardcore.MOD_ID);

    public static final RegistryObject<Item> CONFIG_ITEM = ITEMS.register("config_item",
            () -> new ConfigItem(new Item.Properties().group(Hardcore.TAB).maxStackSize(1)));
}

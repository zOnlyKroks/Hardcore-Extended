package com.zOnlyKroks.NoDamageMod.event;
import com.zOnlyKroks.NoDamageMod.NoDamageMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Cancelable
@Mod.EventBusSubscriber(Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class WindowCloseEvent extends Event {
    /**
     * Event handler
     */
    @SubscribeEvent
    public static void onOptionsScreenInit(GuiScreenEvent.InitGuiEvent.Post event) {
        // Get minecraft instance.
        Minecraft mc = Minecraft.getInstance();

        // Get screen gui that is intialized.
        Screen gui = event.getGui();

        // Check that the gui is an instance of the main menu.
        if (gui instanceof MainMenuScreen) {
            // Cast the gui.
            MainMenuScreen mainMenu = (MainMenuScreen) gui;

            // Get the buttons.
            List<Widget> buttons = mainMenu.buttons;

            // Get the correct button.
            Button widget = (Button) buttons.get(1);

            // Change the onPress value to override the press event.
            widget.onPress = (button) -> {
                System.out.println("Quit button pressed!");
            };
        }
    }
}

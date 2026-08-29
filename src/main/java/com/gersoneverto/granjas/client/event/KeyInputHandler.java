package com.gersoneverto.granjas.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.Minecraft;
import com.gersoneverto.granjas.client.screen.LanguageSelectionScreen;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = "granjas", bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class KeyInputHandler {
    
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        
        // Verificar si se presionó la tecla T (GLFW.GLFW_KEY_T = 84)
        if (event.getKey() == GLFW.GLFW_KEY_T && event.getAction() == GLFW.GLFW_PRESS) {
            // Asegurarse de que estamos en el juego (no en menú principal)
            if (minecraft.level != null && minecraft.player != null) {
                // Abrir la pantalla de selección de idiomas
                minecraft.setScreen(new LanguageSelectionScreen(minecraft.screen));
            }
        }
    }
}

package com.gersoneverto.granjas.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import com.gersoneverto.granjas.language.LanguageManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LanguageSelectionScreen extends Screen {
    
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 20;
    private static final int BUTTON_SPACING = 5;
    
    private List<Button> languageButtons = new ArrayList<>();
    private Button backButton;
    private Screen previousScreen;
    private boolean showingConfirmation = false;
    private String selectedLanguage = null;
    private Button confirmButton;
    private Button cancelButton;
    
    public LanguageSelectionScreen(Screen previousScreen) {
        super(Component.literal("Seleccionar Idioma"));
        this.previousScreen = previousScreen;
    }
    
    @Override
    protected void init() {
        this.clearWidgets();
        
        if (!showingConfirmation) {
            // Pantalla de selección de idiomas
            int centerX = this.width / 2;
            int startY = 40;
            
            // Título
            this.addRenderableWidget(new Button.Builder(
                    Component.literal("📚 " + LanguageManager.getTranslation("select_language")),
                    button -> {}
            ).bounds(centerX - 100, 15, 200, 20).build());
            
            // Crear botones para cada idioma
            Map<String, String> languages = LanguageManager.getAvailableLanguages();
            int yOffset = startY;
            
            for (Map.Entry<String, String> entry : languages.entrySet()) {
                String langCode = entry.getKey();
                String langName = entry.getValue();
                
                Button langButton = new Button.Builder(
                        Component.literal(langName),
                        button -> onLanguageSelected(langCode)
                ).bounds(centerX - BUTTON_WIDTH / 2, yOffset, BUTTON_WIDTH, BUTTON_HEIGHT).build();
                
                this.addRenderableWidget(langButton);
                languageButtons.add(langButton);
                yOffset += BUTTON_HEIGHT + BUTTON_SPACING;
            }
            
            // Botón de regreso
            backButton = new Button.Builder(
                    Component.literal("Atrás"),
                    button -> this.onClose()
            ).bounds(centerX - 50, this.height - 30, 100, 20).build();
            
            this.addRenderableWidget(backButton);
        } else {
            // Pantalla de confirmación
            int centerX = this.width / 2;
            int centerY = this.height / 2;
            
            // Mensaje de confirmación
            String message = "¿Confirmar cambio a " + LanguageManager.getLanguageName(selectedLanguage) + "?";
            
            // Botón de confirmación (SÍ)
            confirmButton = new Button.Builder(
                    Component.literal("✓ SÍ"),
                    button -> confirmLanguageChange()
            ).bounds(centerX - 60, centerY, 50, 20).build();
            
            // Botón de cancelación (NO)
            cancelButton = new Button.Builder(
                    Component.literal("✗ NO"),
                    button -> showingConfirmation = false
            ).bounds(centerX + 10, centerY, 50, 20).build();
            
            this.addRenderableWidget(confirmButton);
            this.addRenderableWidget(cancelButton);
        }
    }
    
    private void onLanguageSelected(String langCode) {
        selectedLanguage = langCode;
        showingConfirmation = true;
        this.init(); // Reinicializar pantalla para mostrar confirmación
    }
    
    private void confirmLanguageChange() {
        if (selectedLanguage != null) {
            LanguageManager.setLanguage(selectedLanguage);
            // Aquí se puede guardar en archivo de configuración
            this.onClose();
        }
    }
    
    @Override
    public void render(GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(guiGraphics);
        
        if (showingConfirmation) {
            // Dibujar fondo oscuro para el diálogo de confirmación
            int centerX = this.width / 2;
            int centerY = this.height / 2;
            
            guiGraphics.fill(centerX - 120, centerY - 40, centerX + 120, centerY + 40, 0xFF000000);
            guiGraphics.fill(centerX - 115, centerY - 35, centerX + 115, centerY + 35, 0xFF1F1F1F);
            
            // Dibujar texto de confirmación
            String message = "¿Confirmar cambio a " + LanguageManager.getLanguageName(selectedLanguage) + "?";
            guiGraphics.drawCenteredString(this.font, message, centerX, centerY - 15, 0xFFFFFF);
        } else {
            // Dibujar título
            guiGraphics.drawCenteredString(this.font, "📚 Seleccionar Idioma", this.width / 2, 20, 0xFFFFFF);
        }
        
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
    }
    
    @Override
    public void onClose() {
        this.minecraft.setScreen(previousScreen);
    }
    
    @Override
    public boolean isPauseScreen() {
        return false;
    }
}

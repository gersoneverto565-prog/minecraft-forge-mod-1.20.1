package com.gersoneverto.granjas.client.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import com.gersoneverto.granjas.farm.FarmDesign;

import java.util.Map;

public class FarmMaterialsScreen extends Screen {
    
    private FarmDesign.FarmMaterials farmMaterials;
    private Button createButton;
    private int progress = 0;
    private boolean isConstructing = false;
    
    public FarmMaterialsScreen(FarmDesign.FarmMaterials farmMaterials) {
        super(Component.literal("Materiales"));
        this.farmMaterials = farmMaterials;
    }
    
    @Override
    protected void init() {
        super.init();
        
        // Botón CREAR
        this.createButton = this.addRenderableWidget(new Button(
            this.width / 2 - 50, 
            this.height - 40, 
            100, 
            20, 
            Component.literal("CREAR"),
            (button) -> this.createFarm()
        ));
    }
    
    private void createFarm() {
        // Aquí se iniciaría la construcción
        isConstructing = true;
        progress = 0;
    }
    
    @Override
    public void render(PoseStack poseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(poseStack);
        
        // Título
        drawCenteredString(poseStack, this.font, this.title, this.width / 2, 15, 0xFFFFFF);
        
        // Nombre de la granja
        drawCenteredString(poseStack, this.font, 
            Component.literal(farmMaterials.farmName), 
            this.width / 2, 35, 0xFFD700);
        
        // Lista de materiales
        int yOffset = 60;
        int itemHeight = 25;
        
        for (Map.Entry<String, Integer> entry : farmMaterials.materials.entrySet()) {
            String materialName = entry.getKey();
            int quantity = entry.getValue();
            
            // Fondo del item
            fill(poseStack, 30, yOffset - 5, this.width - 30, yOffset + 20, 0xFF3F3F3F);
            
            // Texto del material
            drawString(poseStack, this.font, 
                materialName + " x" + quantity, 
                50, yOffset, 0xFFFFFF);
            
            // Checkbox (simplificado)
            fill(poseStack, this.width - 60, yOffset, this.width - 40, yOffset + 15, 0xFF808080);
            drawCenteredString(poseStack, this.font, "✓", this.width - 50, yOffset, 0x00FF00);
            
            yOffset += itemHeight;
        }
        
        // Barra de progreso si está construyendo
        if (isConstructing) {
            int barWidth = this.width - 60;
            int barHeight = 15;
            int barX = 30;
            int barY = this.height - 80;
            
            // Fondo de la barra
            fill(poseStack, barX, barY, barX + barWidth, barY + barHeight, 0xFF2F2F2F);
            
            // Barra de progreso
            int progressWidth = (int) ((barWidth * progress) / 100);
            fill(poseStack, barX, barY, barX + progressWidth, barY + barHeight, 0xFF00FF00);
            
            // Texto de progreso
            drawCenteredString(poseStack, this.font, 
                progress + "%", 
                this.width / 2, barY + 2, 0xFFFFFF);
            
            progress += 2; // Simular progreso
            if (progress > 100) {
                isConstructing = false;
                progress = 0;
            }
        }
        
        super.render(poseStack, pMouseX, pMouseY, pPartialTick);
    }
    
    @Override
    public boolean shouldCloseOnEsc() {
        return !isConstructing; // No cerrar mientras se construye
    }
}

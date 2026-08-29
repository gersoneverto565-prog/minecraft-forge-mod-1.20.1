package com.gersoneverto.granjas.farm;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.Map;

public class FarmDesign {
    
    public static class FarmMaterials {
        public String farmName;
        public Map<String, Integer> materials;
        
        public FarmMaterials(String farmName) {
            this.farmName = farmName;
            this.materials = new HashMap<>();
        }
        
        public void addMaterial(String blockName, int quantity) {
            materials.put(blockName, quantity);
        }
    }
    
    // Materiales para Granja de Trigo (9x9)
    public static FarmMaterials getWheatFarmMaterials() {
        FarmMaterials materials = new FarmMaterials("Wheat Farm");
        materials.addMaterial("Dirt", 81);
        materials.addMaterial("Water Bucket", 1);
        materials.addMaterial("Composter", 1);
        materials.addMaterial("Hopper", 4);
        materials.addMaterial("Chest", 2);
        materials.addMaterial("Oak Wood Block", 40);
        materials.addMaterial("Villager Egg", 1);
        return materials;
    }
    
    // Materiales para Granja de Zanahorias (9x9)
    public static FarmMaterials getCarrotFarmMaterials() {
        FarmMaterials materials = new FarmMaterials("Carrot Farm");
        materials.addMaterial("Dirt", 81);
        materials.addMaterial("Water Bucket", 1);
        materials.addMaterial("Composter", 1);
        materials.addMaterial("Trapdoor", 1);
        materials.addMaterial("Hopper", 4);
        materials.addMaterial("Chest", 2);
        materials.addMaterial("Oak Wood Block", 40);
        materials.addMaterial("Villager Egg", 2);
        return materials;
    }
    
    // Materiales para Granja de Patatas (9x9)
    public static FarmMaterials getPotatoFarmMaterials() {
        FarmMaterials materials = new FarmMaterials("Potato Farm");
        materials.addMaterial("Dirt", 81);
        materials.addMaterial("Water Bucket", 1);
        materials.addMaterial("Composter", 1);
        materials.addMaterial("Hopper", 4);
        materials.addMaterial("Chest", 2);
        materials.addMaterial("Oak Wood Block", 40);
        materials.addMaterial("Villager Egg", 1);
        return materials;
    }
    
    // Materiales para Granja de Caña de Azúcar (9x9)
    public static FarmMaterials getSugarcaneFarmMaterials() {
        FarmMaterials materials = new FarmMaterials("Sugarcane Farm");
        materials.addMaterial("Sugar Cane", 7);
        materials.addMaterial("Sand", 7);
        materials.addMaterial("Piston", 7);
        materials.addMaterial("Observer", 7);
        materials.addMaterial("Redstone Dust", 7);
        materials.addMaterial("Water Bucket", 1);
        materials.addMaterial("Minecart with Hopper", 1);
        materials.addMaterial("Hopper", 4);
        materials.addMaterial("Chest", 1);
        materials.addMaterial("Oak Wood Block", 20);
        return materials;
    }
    
    // Materiales para Granja de Bambú (9x9)
    public static FarmMaterials getBambooFarmMaterials() {
        FarmMaterials materials = new FarmMaterials("Bamboo Farm");
        materials.addMaterial("Bamboo", 5);
        materials.addMaterial("Dirt", 5);
        materials.addMaterial("Piston", 5);
        materials.addMaterial("Observer", 5);
        materials.addMaterial("Redstone Dust", 5);
        materials.addMaterial("Hopper", 4);
        materials.addMaterial("Chest", 1);
        materials.addMaterial("Oak Wood Block", 30);
        return materials;
    }
    
    // Construir la granja - Método que será llamado cuando se presiona "CREAR"
    public static void buildWheatFarm(Level level, BlockPos startPos, int progress) {
        // progress va de 0 a 100
        // Diseño 9x9 de granja de trigo
        
        int totalBlocks = 81 + 40 + 4 + 2; // tierra + construcción + hoppers + cofres
        int blocksPerProgress = totalBlocks / 100;
        int blocksToPlace = blocksPerProgress * progress;
        int placed = 0;
        
        // Base: Tierra (81 bloques en patrón 9x9)
        if (placed < blocksToPlace) {
            for (int x = 0; x < 9 && placed < blocksToPlace; x++) {
                for (int z = 0; z < 9 && placed < blocksToPlace; z++) {
                    BlockPos pos = startPos.offset(x, 0, z);
                    if (level.getBlockState(pos).getMaterial().isReplaceable()) {
                        level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
                        placed++;
                    }
                }
            }
        }
    }
    
    public static void buildCarrotFarm(Level level, BlockPos startPos, int progress) {
        // Similar a wheat pero con variaciones
    }
    
    public static void buildPotatoFarm(Level level, BlockPos startPos, int progress) {
        // Similar a wheat
    }
    
    public static void buildSugarcaneFarm(Level level, BlockPos startPos, int progress) {
        // Diseño con pistones y observadores
    }
    
    public static void buildBambooFarm(Level level, BlockPos startPos, int progress) {
        // Diseño con pistones y observadores
    }
}

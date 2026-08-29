package com.gersoneverto.granjas.farm;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.nbt.CompoundTag;

public class FarmConstructor {
    
    private static final int CONSTRUCTION_TIME_TICKS = 1200; // 1 minuto = 60 segundos * 20 ticks
    
    public static class ConstructionTask {
        public BlockPos startPos;
        public String farmType;
        public int progressTicks;
        public boolean isComplete;
        
        public ConstructionTask(BlockPos startPos, String farmType) {
            this.startPos = startPos;
            this.farmType = farmType;
            this.progressTicks = 0;
            this.isComplete = false;
        }
        
        public int getProgressPercent() {
            return (progressTicks * 100) / CONSTRUCTION_TIME_TICKS;
        }
        
        public void tick() {
            if (progressTicks < CONSTRUCTION_TIME_TICKS) {
                progressTicks++;
            } else {
                isComplete = true;
            }
        }
    }
    
    // Validar si hay espacio para construir
    public static boolean validateSpace(Level level, BlockPos startPos, int width, int height, int depth) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (int z = 0; z < depth; z++) {
                    BlockPos checkPos = startPos.offset(x, y, z);
                    if (!level.getBlockState(checkPos).getMaterial().isReplaceable()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // Construir con progreso visual
    public static void buildFarm(Level level, BlockPos startPos, String farmType, int progress) {
        switch(farmType) {
            case "wheat":
                buildWheatFarmProgressive(level, startPos, progress);
                break;
            case "carrot":
                buildCarrotFarmProgressive(level, startPos, progress);
                break;
            case "potato":
                buildPotatoFarmProgressive(level, startPos, progress);
                break;
            case "sugarcane":
                buildSugarcaneFarmProgressive(level, startPos, progress);
                break;
            case "bamboo":
                buildBambooFarmProgressive(level, startPos, progress);
                break;
        }
    }
    
    private static void buildWheatFarmProgressive(Level level, BlockPos startPos, int progress) {
        int maxBlocks = 127; // 81 tierra + 40 construcción + 4 hoppers + 2 cofres
        int blocksToPlace = (maxBlocks * progress) / 100;
        int placed = 0;
        
        // Fase 1: Base de tierra (81 bloques)
        if (placed < blocksToPlace) {
            for (int x = 0; x < 9 && placed < blocksToPlace; x++) {
                for (int z = 0; z < 9 && placed < blocksToPlace; z++) {
                    BlockPos pos = startPos.offset(x, 0, z);
                    level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 3);
                    placed++;
                }
            }
        }
        
        // Fase 2: Paredes (40 bloques)
        if (placed < blocksToPlace) {
            for (int x = 0; x < 9 && placed < blocksToPlace; x++) {
                BlockPos posNorth = startPos.offset(x, 1, 0);
                BlockPos posSouth = startPos.offset(x, 1, 8);
                level.setBlock(posNorth, Blocks.OAK_WOOD.defaultBlockState(), 3);
                level.setBlock(posSouth, Blocks.OAK_WOOD.defaultBlockState(), 3);
                placed += 2;
            }
            for (int z = 1; z < 8 && placed < blocksToPlace; z++) {
                BlockPos posEast = startPos.offset(0, 1, z);
                BlockPos posWest = startPos.offset(8, 1, z);
                level.setBlock(posEast, Blocks.OAK_WOOD.defaultBlockState(), 3);
                level.setBlock(posWest, Blocks.OAK_WOOD.defaultBlockState(), 3);
                placed += 2;
            }
        }
        
        // Fase 3: Hoppers (4 bloques)
        if (placed < blocksToPlace) {
            level.setBlock(startPos.offset(2, 0, 8), Blocks.HOPPER.defaultBlockState(), 3);
            level.setBlock(startPos.offset(4, 0, 8), Blocks.HOPPER.defaultBlockState(), 3);
            level.setBlock(startPos.offset(6, 0, 8), Blocks.HOPPER.defaultBlockState(), 3);
            placed += 3;
        }
        
        // Fase 4: Cofres (2 bloques)
        if (placed < blocksToPlace) {
            level.setBlock(startPos.offset(2, 0, -1), Blocks.CHEST.defaultBlockState(), 3);
            placed += 1;
        }
    }
    
    private static void buildCarrotFarmProgressive(Level level, BlockPos startPos, int progress) {
        // Similar a wheat
        buildWheatFarmProgressive(level, startPos, progress);
    }
    
    private static void buildPotatoFarmProgressive(Level level, BlockPos startPos, int progress) {
        // Similar a wheat
        buildWheatFarmProgressive(level, startPos, progress);
    }
    
    private static void buildSugarcaneFarmProgressive(Level level, BlockPos startPos, int progress) {
        int maxBlocks = 51; // 7 caña + 7 arena + 7 pistones + 7 observadores + 7 redstone + 1 agua + 1 minecart + 4 hoppers + 1 cofre + 20 construcción
        int blocksToPlace = (maxBlocks * progress) / 100;
        int placed = 0;
        
        // Arena para caña
        if (placed < blocksToPlace) {
            for (int i = 0; i < 7 && placed < blocksToPlace; i++) {
                BlockPos pos = startPos.offset(i, 0, 0);
                level.setBlock(pos, Blocks.SAND.defaultBlockState(), 3);
                placed++;
            }
        }
    }
    
    private static void buildBambooFarmProgressive(Level level, BlockPos startPos, int progress) {
        // Diseño similar a sugarcane
        buildSugarcaneFarmProgressive(level, startPos, progress);
    }
}

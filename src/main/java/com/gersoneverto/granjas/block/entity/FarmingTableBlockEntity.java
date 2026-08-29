package com.gersoneverto.granjas.block.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import com.gersoneverto.granjas.farm.FarmConstructor;

public class FarmingTableBlockEntity extends BlockEntity {
    
    private FarmConstructor.ConstructionTask currentTask;
    
    public FarmingTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FARMING_TABLE_ENTITY.get(), pos, state);
    }
    
    public void startConstruction(BlockPos farmPos, String farmType) {
        this.currentTask = new FarmConstructor.ConstructionTask(farmPos, farmType);
    }
    
    public FarmConstructor.ConstructionTask getCurrentTask() {
        return currentTask;
    }
    
    public boolean isConstructing() {
        return currentTask != null && !currentTask.isComplete;
    }
    
    public int getConstructionProgress() {
        return currentTask != null ? currentTask.getProgressPercent() : 0;
    }
    
    public void tick() {
        if (currentTask != null && !currentTask.isComplete) {
            currentTask.tick();
            
            // Construir con progreso
            FarmConstructor.buildFarm(
                this.level,
                currentTask.startPos,
                currentTask.farmType,
                currentTask.getProgressPercent()
            );
            
            this.setChanged();
        }
    }
    
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }
    
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
    }
}

package com.gersoneverto.granjas.block;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import com.gersoneverto.granjas.farm.FarmDesign;
import com.gersoneverto.granjas.block.entity.FarmingTableBlockEntity;

public class FarmingCraftingTableBlock extends Block implements EntityBlock {
    
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);
    
    public FarmingCraftingTableBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
    
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
    
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, 
                                  com.minecraft.world.InteractionHand pHand, BlockHitResult pHit) {
        
        if (!pLevel.isClientSide && pPlayer.isShiftKeyDown()) {
            // Click derecho + Shift = Mostrar GUI
            // Por ahora es un placeholder
            pPlayer.displayClientMessage(
                net.minecraft.network.chat.Component.literal("§6Mesa de Construcción de Granjas"), 
                true
            );
            return InteractionResult.SUCCESS;
        }
        
        return InteractionResult.PASS;
    }
    
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FarmingTableBlockEntity(pPos, pState);
    }
}

package com.gersoneverto.granjas.block.entity;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Blocks;
import com.gersoneverto.granjas.GrajasEvolutivas;
import com.gersoneverto.granjas.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GrajasEvolutivas.MOD_ID);
    
    public static final RegistryObject<BlockEntityType<FarmingTableBlockEntity>> FARMING_TABLE_ENTITY =
        BLOCK_ENTITIES.register("farming_table",
            () -> BlockEntityType.Builder.of(FarmingTableBlockEntity::new, ModBlocks.FARMING_CRAFTING_TABLE.get())
                .build(null));
}

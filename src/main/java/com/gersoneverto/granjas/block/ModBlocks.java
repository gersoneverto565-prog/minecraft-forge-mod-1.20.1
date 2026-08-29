package com.gersoneverto.granjas.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.gersoneverto.granjas.GrajasEvolutivas;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GrajasEvolutivas.MOD_ID);

    // Mesa de Construcción de Granjas - Bloque principal
    public static final RegistryObject<Block> FARMING_CRAFTING_TABLE = BLOCKS.register("farming_crafting_table",
            () -> new FarmingCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)
                    .strength(2.5f)
                    .requiresCorrectToolForDrops()));

    // Granjas Básicas - Con texturas temáticas
    
    // 🌾 Granja de Trigo - Dorada/Amarilla
    public static final RegistryObject<Block> WHEAT_FARM = BLOCKS.register("wheat_farm",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(0.5f)
                    .color(0xFFD700))); // Oro
    
    // 🥕 Granja de Zanahorias - Naranja
    public static final RegistryObject<Block> CARROT_FARM = BLOCKS.register("carrot_farm",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(0.5f)
                    .color(0xFF8C00))); // Naranja oscuro
    
    // 🥔 Granja de Patatas - Marrón claro
    public static final RegistryObject<Block> POTATO_FARM = BLOCKS.register("potato_farm",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(0.5f)
                    .color(0x8B7355))); // Marrón
    
    // 🍬 Granja de Caña de Azúcar - Azul claro
    public static final RegistryObject<Block> SUGARCANE_FARM = BLOCKS.register("sugarcane_farm",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(0.5f)
                    .color(0x87CEEB))); // Cielo azul
    
    // 🎋 Granja de Bambú - Verde
    public static final RegistryObject<Block> BAMBOO_FARM = BLOCKS.register("bamboo_farm",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(0.5f)
                    .color(0x228B22))); // Verde bosque
}

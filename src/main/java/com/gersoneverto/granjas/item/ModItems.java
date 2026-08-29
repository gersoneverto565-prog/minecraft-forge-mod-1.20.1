package com.gersoneverto.granjas.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.gersoneverto.granjas.GrajasEvolutivas;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GrajasEvolutivas.MOD_ID);
    
    // Por ahora vacío - Se pueden agregar items especiales después
    // Ejemplo para el futuro:
    // public static final RegistryObject<Item> FARM_BLUEPRINT = ITEMS.register("farm_blueprint",
    //         () -> new Item(new Item.Properties()));
}

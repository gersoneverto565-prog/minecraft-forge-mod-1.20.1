package com.gersoneverto.granjas;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLoadingContext;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gersoneverto.granjas.block.ModBlocks;
import com.gersoneverto.granjas.item.ModItems;
import com.gersoneverto.granjas.block.entity.ModBlockEntities;

@Mod(GrajasEvolutivas.MOD_ID)
public class GrajasEvolutivas {
    public static final String MOD_ID = "grajasevo";
    private static final Logger LOGGER = LoggerFactory.getLogger("Granjas Evolutivas");

    public GrajasEvolutivas() {
        IEventBus modEventBus = FXModLoadingContext.getInstance().getModEventBus();
        
        // Registrar bloques, items y block entities
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        
        LOGGER.info("Granjas Evolutivas v1.0.0 inicializando...");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Configuración común del mod iniciada");
    }
    
    @OnlyIn(Dist.CLIENT)
    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Cliente del mod configurado");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEvents {
        @OnlyIn(Dist.CLIENT)
        @net.minecraftforge.api.distmarker.OnlyIn(Dist.CLIENT)
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("Cliente del mod configurado correctamente");
        }
    }
}

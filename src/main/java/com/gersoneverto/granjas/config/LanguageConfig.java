package com.gersoneverto.granjas.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LanguageConfig {
    
    private static final String CONFIG_DIR = "config/granjas";
    private static final String CONFIG_FILE = "language_config.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    private static String currentLanguage = "es_es";
    
    static {
        loadConfig();
    }
    
    /**
     * Cargar la configuración del idioma desde el archivo JSON
     */
    public static void loadConfig() {
        try {
            File configDir = new File(CONFIG_DIR);
            if (!configDir.exists()) {
                configDir.mkdirs();
            }
            
            File configFile = new File(configDir, CONFIG_FILE);
            
            if (configFile.exists()) {
                FileReader reader = new FileReader(configFile);
                JsonObject json = GSON.fromJson(reader, JsonObject.class);
                reader.close();
                
                if (json != null && json.has("language")) {
                    currentLanguage = json.get("language").getAsString();
                }
            } else {
                // Si no existe, crear el archivo con configuración por defecto
                saveConfig();
            }
        } catch (IOException e) {
            System.err.println("[Granjas Mod] Error al cargar configuración de idioma: " + e.getMessage());
            currentLanguage = "es_es"; // Fallback a español
        }
    }
    
    /**
     * Guardar la configuración del idioma en el archivo JSON
     */
    public static void saveConfig() {
        try {
            File configDir = new File(CONFIG_DIR);
            if (!configDir.exists()) {
                configDir.mkdirs();
            }
            
            File configFile = new File(configDir, CONFIG_FILE);
            
            JsonObject json = new JsonObject();
            json.addProperty("language", currentLanguage);
            json.addProperty("last_updated", System.currentTimeMillis());
            json.addProperty("mod_version", "1.0.0");
            
            FileWriter writer = new FileWriter(configFile);
            GSON.toJson(json, writer);
            writer.close();
            
            System.out.println("[Granjas Mod] Configuración de idioma guardada: " + currentLanguage);
        } catch (IOException e) {
            System.err.println("[Granjas Mod] Error al guardar configuración de idioma: " + e.getMessage());
        }
    }
    
    /**
     * Obtener el idioma configurado
     */
    public static String getLanguage() {
        return currentLanguage;
    }
    
    /**
     * Establecer un nuevo idioma y guardarlo
     */
    public static void setLanguage(String language) {
        currentLanguage = language;
        saveConfig();
    }
    
    /**
     * Restablecer a idioma por defecto (Español)
     */
    public static void resetToDefault() {
        currentLanguage = "es_es";
        saveConfig();
    }
}

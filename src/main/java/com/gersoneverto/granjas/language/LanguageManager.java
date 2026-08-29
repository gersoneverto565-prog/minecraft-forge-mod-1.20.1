package com.gersoneverto.granjas.language;

import java.util.HashMap;
import java.util.Map;

public class LanguageManager {
    
    private static String currentLanguage = "es_es"; // Español por defecto
    
    public static final Map<String, String> LANGUAGES = new HashMap<>();
    
    static {
        LANGUAGES.put("es_es", "Español");
        LANGUAGES.put("en_us", "English");
        LANGUAGES.put("fr_fr", "Français");
        LANGUAGES.put("de_de", "Deutsch");
        LANGUAGES.put("pt_pt", "Português");
        LANGUAGES.put("it_it", "Italiano");
        LANGUAGES.put("ja_jp", "日本語");
        LANGUAGES.put("zh_cn", "中文");
    }
    
    public static void setLanguage(String language) {
        if (LANGUAGES.containsKey(language)) {
            currentLanguage = language;
        }
    }
    
    public static String getCurrentLanguage() {
        return currentLanguage;
    }
    
    public static String getLanguageName(String langCode) {
        return LANGUAGES.getOrDefault(langCode, "Unknown");
    }
    
    public static Map<String, String> getAvailableLanguages() {
        return new HashMap<>(LANGUAGES);
    }
    
    // Traducciones para la GUI
    public static String getTranslation(String key) {
        switch(currentLanguage) {
            case "es_es":
                return getSpanishTranslation(key);
            case "en_us":
                return getEnglishTranslation(key);
            case "fr_fr":
                return getFrenchTranslation(key);
            case "de_de":
                return getGermanTranslation(key);
            case "pt_pt":
                return getPortugueseTranslation(key);
            case "it_it":
                return getItalianTranslation(key);
            case "ja_jp":
                return getJapaneseTranslation(key);
            case "zh_cn":
                return getChineseTranslation(key);
            default:
                return key;
        }
    }
    
    // Traducciones en Español
    private static String getSpanishTranslation(String key) {
        switch(key) {
            case "select_language":
                return "Seleccionar Idioma";
            case "wheat_farm":
                return "Granja de Trigo";
            case "carrot_farm":
                return "Granja de Zanahorias";
            case "potato_farm":
                return "Granja de Patatas";
            case "sugarcane_farm":
                return "Granja de Caña de Azúcar";
            case "bamboo_farm":
                return "Granja de Bambú";
            case "materials":
                return "Materiales";
            case "create":
                return "CREAR";
            case "farming_table":
                return "Mesa de Construcción de Granjas";
            default:
                return key;
        }
    }
    
    // Traducciones en Inglés
    private static String getEnglishTranslation(String key) {
        switch(key) {
            case "select_language":
                return "Select Language";
            case "wheat_farm":
                return "Wheat Farm";
            case "carrot_farm":
                return "Carrot Farm";
            case "potato_farm":
                return "Potato Farm";
            case "sugarcane_farm":
                return "Sugarcane Farm";
            case "bamboo_farm":
                return "Bamboo Farm";
            case "materials":
                return "Materials";
            case "create":
                return "CREATE";
            case "farming_table":
                return "Farm Crafting Table";
            default:
                return key;
        }
    }
    
    // Traducciones en Francés
    private static String getFrenchTranslation(String key) {
        switch(key) {
            case "select_language":
                return "Sélectionner la Langue";
            case "wheat_farm":
                return "Ferme de Blé";
            case "carrot_farm":
                return "Ferme de Carottes";
            case "potato_farm":
                return "Ferme de Pommes de Terre";
            case "sugarcane_farm":
                return "Ferme de Canne à Sucre";
            case "bamboo_farm":
                return "Ferme de Bambou";
            case "materials":
                return "Matériaux";
            case "create":
                return "CRÉER";
            case "farming_table":
                return "Table d'Artisanat Agricole";
            default:
                return key;
        }
    }
    
    // Traducciones en Alemán
    private static String getGermanTranslation(String key) {
        switch(key) {
            case "select_language":
                return "Sprache Wählen";
            case "wheat_farm":
                return "Weizenfarm";
            case "carrot_farm":
                return "Möhrenfarm";
            case "potato_farm":
                return "Kartoffelfarm";
            case "sugarcane_farm":
                return "Zuckerrohrfarm";
            case "bamboo_farm":
                return "Bambusfarm";
            case "materials":
                return "Materialien";
            case "create":
                return "ERSTELLEN";
            case "farming_table":
                return "Bauernhof-Handwerkstisch";
            default:
                return key;
        }
    }
    
    // Traducciones en Portugués
    private static String getPortugueseTranslation(String key) {
        switch(key) {
            case "select_language":
                return "Selecionar Idioma";
            case "wheat_farm":
                return "Fazenda de Trigo";
            case "carrot_farm":
                return "Fazenda de Cenoura";
            case "potato_farm":
                return "Fazenda de Batata";
            case "sugarcane_farm":
                return "Fazenda de Cana de Açúcar";
            case "bamboo_farm":
                return "Fazenda de Bambu";
            case "materials":
                return "Materiais";
            case "create":
                return "CRIAR";
            case "farming_table":
                return "Mesa de Trabalho Agrícola";
            default:
                return key;
        }
    }
    
    // Traducciones en Italiano
    private static String getItalianTranslation(String key) {
        switch(key) {
            case "select_language":
                return "Seleziona Lingua";
            case "wheat_farm":
                return "Fattoria di Grano";
            case "carrot_farm":
                return "Fattoria di Carote";
            case "potato_farm":
                return "Fattoria di Patate";
            case "sugarcane_farm":
                return "Fattoria di Canna da Zucchero";
            case "bamboo_farm":
                return "Fattoria di Bambù";
            case "materials":
                return "Materiali";
            case "create":
                return "CREA";
            case "farming_table":
                return "Banco da Lavoro Agricolo";
            default:
                return key;
        }
    }
    
    // Traducciones en Japonés
    private static String getJapaneseTranslation(String key) {
        switch(key) {
            case "select_language":
                return "言語を選択";
            case "wheat_farm":
                return "小麦農場";
            case "carrot_farm":
                return "人参農場";
            case "potato_farm":
                return "じゃがいも農場";
            case "sugarcane_farm":
                return "サトウキビ農場";
            case "bamboo_farm":
                return "竹農場";
            case "materials":
                return "材料";
            case "create":
                return "作成";
            case "farming_table":
                return "農業工芸テーブル";
            default:
                return key;
        }
    }
    
    // Traducciones en Chino Simplificado
    private static String getChineseTranslation(String key) {
        switch(key) {
            case "select_language":
                return "选择语言";
            case "wheat_farm":
                return "小麦农场";
            case "carrot_farm":
                return "胡萝卜农场";
            case "potato_farm":
                return "土豆农场";
            case "sugarcane_farm":
                return "甘蔗农场";
            case "bamboo_farm":
                return "竹子农场";
            case "materials":
                return "材料";
            case "create":
                return "创建";
            case "farming_table":
                return "农业制作台";
            default:
                return key;
        }
    }
}

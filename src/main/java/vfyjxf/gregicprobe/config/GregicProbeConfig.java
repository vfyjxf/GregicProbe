package vfyjxf.gregicprobe.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vfyjxf.gregicprobe.GregicProbe;

import java.io.File;

@Mod.EventBusSubscriber
public class GregicProbeConfig {

    public static Configuration config;

    public static boolean displayItemOutputs = true;
    public static boolean displayFluidOutputs = true;
    public static boolean displayBukkit = true;
    public static boolean displayRecipeEut = true;
    public static boolean displaySecondProgress = true;
    public static boolean displayEnergyThousandths = true;
    public static boolean displayItemName = true;
    public static boolean displayFluidName = true;

    public static int borderColorProgress = 0x00000000;
    public static int backgroundColorProgress = 0;
    public static int filledColorProgress = 0xFF000099;
    public static int alternateFilledColorProgress = 0xFF000099;
    public static int borderColorEnergy = 0x00000000;
    public static int backgroundColorEnergy = 0;
    public static int filledColorEnergy = 0xFFFFE000;
    public static int alternateFilledColorEnergy = 0xFFFFE000;

    public static void initConfig(File configFile) {
        config = new Configuration(configFile);

        config.load();
        //general
        {
            displayItemOutputs = config.getBoolean("DisplayItemOutputs", "general", true, "If true, the item outputs of the current recipe will be displayed");
            displayFluidOutputs = config.getBoolean("DisplayFluidOutputs", "general", true, "If true, the fluid outputs of the current recipe will be displayed");
            displayRecipeEut = config.getBoolean("DisplayRecipeEut", "general", true, "If true, the EUt of the current recipe will be displayed");
            displaySecondProgress = config.getBoolean("DisplaySecondProgress", "general", true, "If true, the work progress will be replaced in the form of seconds");
            displayEnergyThousandths = config.getBoolean("DisplayEnergyThousandths", "general", true, "If true, only thousandths of digits are displayed");
            displayItemName = config.getBoolean("ShowItemName", "general", true, "If true, the name of the item will be displayed");
            displayFluidName = config.getBoolean("ShowFluidName", "general", true, "If true, the name of the fluid will be displayed");
        }
        //colour settings
        {
            borderColorProgress = Integer.parseUnsignedInt(config.getString("BorderColorProgress", "colour", "0", "The color that is used for the border of the progress bar"), 16);
            backgroundColorProgress = Integer.parseUnsignedInt(config.getString("BackgroundColorProgress", "colour", "0", "The color that is used for the background of the progress bar"), 16);
            filledColorProgress = Integer.parseUnsignedInt(config.getString("FilledColorProgress", "colour", "FF000099", "The color that is used for the filled part of the progress bar"), 16);
            alternateFilledColorProgress = Integer.parseUnsignedInt(config.getString("AlternateFilledColorProgress", "colour", "FF000099", "If this is different from the filledColor then the fill color will alternate"), 16);

            borderColorEnergy = Integer.parseUnsignedInt(config.getString("BorderColorEnergy", "colour", "0", "The color that is used for the border of the energy bar"), 16);
            backgroundColorEnergy = Integer.parseUnsignedInt(config.getString("BackgroundColorEnergy", "colour", "0", "The color that is used for the background of the energy bar"), 16);
            filledColorEnergy = Integer.parseUnsignedInt(config.getString("FilledColorEnergy", "colour", "FFFFE000", "The color that is used for the filled part of the energy bar"), 16);
            alternateFilledColorEnergy = Integer.parseUnsignedInt(config.getString("AlternateFilledColorEnergy", "colour", "FFFFE000", "If this is different from the filledColor then the fill color will alternate"), 16);
        }

        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (GregicProbe.MODID.equals(event.getModID())) {
            ConfigManager.sync(GregicProbe.MODID, Config.Type.INSTANCE);
        }
    }

}

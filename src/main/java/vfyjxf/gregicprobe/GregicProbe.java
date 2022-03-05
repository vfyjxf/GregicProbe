package vfyjxf.gregicprobe;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vfyjxf.gregicprobe.config.GregicProbeConfig;
import vfyjxf.gregicprobe.integration.GregicProbeCompatibility;

import java.io.File;


@Mod(
        modid = GregicProbe.MODID,
        name = GregicProbe.NAME,
        version = GregicProbe.VERSION,
        dependencies = "required-after:gregtech;required-after:theoneprobe",
        useMetadata = true
)
public class GregicProbe {
    public static final String MODID = "gregicprobe";
    public static final String NAME = "Gregic Probe";
    public static final String VERSION = "1.0";

    public static Logger logger = LogManager.getLogger("Gregic");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        GregicProbeConfig.initConfig(new File(event.getModConfigurationDirectory().getPath(), "gregicprobe.cfg"));
    }

    @EventHandler
    public void onInit(FMLInitializationEvent event) {
        logger.info("GregTech support loading");
        GregicProbeCompatibility.registerCompatibility();
    }
}

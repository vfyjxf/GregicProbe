package vfyjxf.gregicprobe.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import vfyjxf.gregicprobe.GregicProbe;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GregicProbeGuiFactory implements IModGuiFactory {

    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new GuiConfig(parentScreen, getConfigElements(), GregicProbe.MODID, false, false, GregicProbe.NAME);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();
        for (String name : GregicProbeConfig.config.getCategoryNames()) {
            list.add(new ConfigElement(GregicProbeConfig.config.getCategory(name)));
        }
        return list;
    }

}

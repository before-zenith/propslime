package net.zenith.propslime.item.custom;

import net.fabricmc.api.ModInitializer;

public class
PropDevSlimeModItems implements ModInitializer {
    @Override
    public void onInitialize() {
        // Initializing our items to minecraft, so it will appear in.. minecraft
        ModItems.initialize();
    }
}

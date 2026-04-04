package net.zenith.propslime.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.zenith.propslime.block.ModBlocks;

public class PropDevSlimeClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.putBlock(ModBlocks.PROP_SLIME_BLOCK, ChunkSectionLayer.TRANSLUCENT);
	}
}
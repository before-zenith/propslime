package net.zenith.propslime.event;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.zenith.propslime.item.custom.ModItems;

public class PropDevSlimeModEvents implements ModInitializer {
    private static final ResourceKey<LootTable> OAK_LEAVES_LOOT_TABLE_ID = Blocks.OAK_LEAVES.getLootTable().orElseThrow();

    @Override
    public void onInitialize() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin() && OAK_LEAVES_LOOT_TABLE_ID.equals(key)) {
                HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = registries.lookupOrThrow(Registries.ENCHANTMENT);
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.MANGO)
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                        enchantmentLookup.getOrThrow(Enchantments.FORTUNE),
                                        0.005F,  // No Fortune
                                        0.0055F,     // Fortune I
                                        0.00625F,    // Fortune II
                                        0.008F,      // Fortune III
                                        0.025F       // Fortune IV (fortune only goes up to 3?)
                                ))
                        );

                tableBuilder.withPool(poolBuilder);
            }
        });
    }
}

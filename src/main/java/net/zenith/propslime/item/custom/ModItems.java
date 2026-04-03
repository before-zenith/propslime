package net.zenith.propslime.item.custom;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.zenith.propslime.PropDevSlime;

import java.util.function.Function;

public class ModItems {
    public static final Item MANGO = register("mango",  Item::new, new Item.Properties()
            // saying to minecraft "hey, this is a food"
            .food(new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(1.6F)
            .build()));

    public static final Item PROP_SLIME_BALL = register("prop_slime_ball", Item::new, new Item.Properties());


    // some weird ahh function i found on fabric documentation
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PropDevSlime.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        // adding mango to the creative tabs, specifically Food and Drinks
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((itemGroup) -> itemGroup.accept(ModItems.MANGO));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register((itemGroup) -> itemGroup.accept(ModItems.PROP_SLIME_BALL));
    }
}

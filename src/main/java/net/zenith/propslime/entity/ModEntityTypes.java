package net.zenith.propslime.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.zenith.propslime.PropDevSlime;

public class ModEntityTypes {
    public static final EntityType<PropSlimeEntity> PROP_SLIME = register(
            "prop_slime",
            EntityType.Builder.<PropSlimeEntity>of(PropSlimeEntity::new, MobCategory.MISC)
                    .sized(0.51f, 0.51f)
    );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(PropDevSlime.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void registerModEntityTypes() {
        PropDevSlime.LOGGER.info("Registering EntityTypes for " + PropDevSlime.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(PROP_SLIME, PropSlimeEntity.createCubeAttributes());
    }
}
// UNFINISHED
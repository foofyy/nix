package net.foof.nix.worldgen

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.foof.nix.register.Blocks
import net.minecraft.util.Identifier
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.decorator.Decorator
import net.minecraft.world.gen.decorator.RangeDecoratorConfig
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.OreFeatureConfig

object Ores {
    val ORE_ADAMANTITE_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                Blocks.ADAMANTITE_ORE.getDefaultState(),
                3
            )
        ) // vein size
        .decorate(
            Decorator.RANGE.configure(
                RangeDecoratorConfig(
                    0,
                    0,
                    64
                )
            )
        )
        .spreadHorizontally()
        .repeat(5) // number of veins per chunk

    val ORE_TITANIUM_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                Blocks.TITANIUM_ORE.getDefaultState(),
                3
            )
        ) // vein size
        .decorate(
            Decorator.RANGE.configure(
                RangeDecoratorConfig(
                    0,
                    0,
                    64
                )
            )
        )
        .spreadHorizontally()
        .repeat(5) // number of veins per chunk

    val ORE_MYTHRIL_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
        .configure(
            OreFeatureConfig(
                OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                Blocks.MYTHRIL_ORE.getDefaultState(),
                5
            )
        ) // vein size
        .decorate(
            Decorator.RANGE.configure(
                RangeDecoratorConfig(
                    0,
                    0,
                    64
                )
            )
        )
        .spreadHorizontally()
        .repeat(6) // number of veins per chunk

    val ORE_COBALT_OVERWORLD: ConfiguredFeature<*, *> = Feature.ORE
            .configure(
                    OreFeatureConfig(
                            OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                            Blocks.COBALT_ORE.getDefaultState(),
                            5
                    )
            ) // vein size
            .decorate(
                    Decorator.RANGE.configure(
                            RangeDecoratorConfig(
                                    0,
                                    0,
                                    64
                            )
                    )
            )
            .spreadHorizontally()
            .repeat(6) // number of veins per chunk

    fun onInitialize() {

        val oreAdamantiteOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_WORLDGEN,
            Identifier("nix", "ore_adamantite_overworld")
        )
        val oreTitaniumOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_WORLDGEN,
            Identifier("nix", "ore_titanium_overworld")
        )
        val oreMythrilOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
            Registry.CONFIGURED_FEATURE_WORLDGEN,
            Identifier("nix", "ore_mythril_overworld")
        )

        val oreCobaltOverworld: RegistryKey<ConfiguredFeature<*, *>> = RegistryKey.of(
                Registry.CONFIGURED_FEATURE_WORLDGEN,
                Identifier("nix", "ore_cobalt_overworld")
        )

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreAdamantiteOverworld.value, ORE_ADAMANTITE_OVERWORLD)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            oreAdamantiteOverworld
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreTitaniumOverworld.value, ORE_TITANIUM_OVERWORLD)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            oreTitaniumOverworld
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreMythrilOverworld.value, ORE_MYTHRIL_OVERWORLD)
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            oreMythrilOverworld
        )
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCobaltOverworld.value, ORE_COBALT_OVERWORLD)
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                oreCobaltOverworld
        )

    }

}
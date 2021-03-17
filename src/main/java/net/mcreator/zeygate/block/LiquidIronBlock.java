
package net.mcreator.zeygate.block;

import net.minecraft.block.material.Material;

@ZeygateModElements.ModElement.Tag
public class LiquidIronBlock extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:liquid_iron")
	public static final FlowingFluidBlock block = null;

	@ObjectHolder("zeygate:liquid_iron_bucket")
	public static final Item bucket = null;

	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;

	private ForgeFlowingFluid.Properties fluidproperties = null;

	public LiquidIronBlock(ZeygateModElements instance) {
		super(instance, 42);

		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());

		MinecraftForge.EVENT_BUS.register(this);
	}

	private static class FluidRegisterHandler {

		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}

	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("zeygate:blocks/copper_block"), new ResourceLocation("zeygate:blocks/cut_copper"))
						.luminosity(10).density(1000).viscosity(1000))

								.block(() -> block);

		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("liquid_iron");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("liquid_iron_flowing");

		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.LAVA)) {

		}.setRegistryName("liquid_iron"));

	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {

		event.getGeneration().getFeatures(GenerationStage.Decoration.LOCAL_MODIFICATIONS)
				.add(() -> new LakesFeature(BlockStateFeatureConfig.field_236455_a_) {
					@Override
					public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, BlockStateFeatureConfig config) {
						RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
						boolean dimensionCriteria = false;

						if (dimensionType == World.THE_NETHER)
							dimensionCriteria = true;

						if (!dimensionCriteria)
							return false;

						return super.generate(world, generator, rand, pos, config);
					}
				}.withConfiguration(new BlockStateFeatureConfig(block.getDefaultState()))
						.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(1))));
	}

}


package net.mcreator.zeygate.block;

import net.minecraft.block.material.Material;

@ZeygateModElements.ModElement.Tag
public class NetherroughBlock extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:netherrough")
	public static final Block block = null;

	public NetherroughBlock(ZeygateModElements instance) {
		super(instance, 26);

		MinecraftForge.EVENT_BUS.register(this);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.NETHERRACK).hardnessAndResistance(0.8f, 0.8f).setLightLevel(s -> 0)
							.harvestLevel(0).harvestTool(ToolType.PICKAXE));

			this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

			setRegistryName("netherrough");
		}

		@Override
		protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
			builder.add(FACING);
		}

		public BlockState rotate(BlockState state, Rotation rot) {
			return state.with(FACING, rot.rotate(state.get(FACING)));
		}

		public BlockState mirror(BlockState state, Mirror mirrorIn) {
			return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		}

		@Override
		public BlockState getStateForPlacement(BlockItemUseContext context) {
			;
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> new OreFeature(OreFeatureConfig.CODEC) {
			@Override
			public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
				RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
				boolean dimensionCriteria = false;

				if (dimensionType == World.THE_NETHER)
					dimensionCriteria = true;

				if (!dimensionCriteria)
					return false;

				return super.generate(world, generator, rand, pos, config);
			}
		}.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.NETHERRACK.getDefaultState().getBlock()) {
			public boolean test(BlockState blockAt, Random random) {
				boolean blockCriteria = false;
				if (blockAt.getBlock() == Blocks.NETHERRACK.getDefaultState().getBlock())
					blockCriteria = true;
				return blockCriteria;
			}

			protected IRuleTestType<?> getType() {
				return IRuleTestType.BLOCK_MATCH;
			}
		}, block.getDefaultState(), 50)).range(28).square().func_242731_b(40));
	}

}

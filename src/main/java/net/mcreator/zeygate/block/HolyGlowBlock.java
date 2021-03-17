
package net.mcreator.zeygate.block;

import net.minecraft.block.material.Material;

@ZeygateModElements.ModElement.Tag
public class HolyGlowBlock extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:holy_glow")
	public static final Block block = null;

	public HolyGlowBlock(ZeygateModElements instance) {
		super(instance, 51);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.GLASS).sound(SoundType.GLASS).hardnessAndResistance(0.6f, 0.6f).setLightLevel(s -> 15)
							.harvestLevel(2).harvestTool(ToolType.PICKAXE).setNeedsPostProcessing((bs, br, bp) -> true)
							.setEmmisiveRendering((bs, br, bp) -> true));

			setRegistryName("holy_glow");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(Items.DIAMOND, (int) (2)));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			super.animateTick(state, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (true)
				for (int l = 0; l < 4; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 0.5D;
					double d4 = (random.nextFloat() - 0.5D) * 0.5D;
					double d5 = (random.nextFloat() - 0.5D) * 0.5D;
					world.addParticle(ParticleTypes.FALLING_WATER, d0, d1, d2, d3, d4, d5);
				}
		}

	}

}

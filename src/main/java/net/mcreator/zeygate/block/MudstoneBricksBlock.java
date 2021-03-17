
package net.mcreator.zeygate.block;

import net.minecraft.block.material.Material;

@ZeygateModElements.ModElement.Tag
public class MudstoneBricksBlock extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:mudstone_bricks")
	public static final Block block = null;

	public MudstoneBricksBlock(ZeygateModElements instance) {
		super(instance, 53);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1.35f, 6f).setLightLevel(s -> 0)
							.harvestLevel(0).harvestTool(ToolType.PICKAXE));

			setRegistryName("mudstone_bricks");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}

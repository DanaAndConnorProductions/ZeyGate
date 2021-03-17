
package net.mcreator.zeygate.item;

@ZeygateModElements.ModElement.Tag
public class RosegoldAxeItem extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:rosegold_axe")
	public static final Item block = null;

	public RosegoldAxeItem(ZeygateModElements instance) {
		super(instance, 22);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CopperIngotItem.block, (int) (1)), new ItemStack(Items.GOLD_INGOT, (int) (1)));
			}
		}, 1, -2.7999999999999998f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("rosegold_axe"));
	}

}

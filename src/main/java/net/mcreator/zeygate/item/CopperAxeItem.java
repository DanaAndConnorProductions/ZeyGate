
package net.mcreator.zeygate.item;

@ZeygateModElements.ModElement.Tag
public class CopperAxeItem extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:copper_axe")
	public static final Item block = null;

	public CopperAxeItem(ZeygateModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CopperIngotItem.block, (int) (1)));
			}
		}, 1, -3.2f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("copper_axe"));
	}

}

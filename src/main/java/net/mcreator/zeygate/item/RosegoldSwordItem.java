
package net.mcreator.zeygate.item;

@ZeygateModElements.ModElement.Tag
public class RosegoldSwordItem extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:rosegold_sword")
	public static final Item block = null;

	public RosegoldSwordItem(ZeygateModElements instance) {
		super(instance, 23);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 1.9999999999999996f;
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
		}, 3, -2.2f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("rosegold_sword"));
	}

}

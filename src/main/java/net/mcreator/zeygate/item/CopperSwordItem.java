
package net.mcreator.zeygate.item;

@ZeygateModElements.ModElement.Tag
public class CopperSwordItem extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:copper_sword")
	public static final Item block = null;

	public CopperSwordItem(ZeygateModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CopperIngotItem.block, (int) (1)));
			}
		}, 3, -2.2f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("copper_sword"));
	}

}

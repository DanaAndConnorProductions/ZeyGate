
package net.mcreator.zeygate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.zeygate.ZeygateModElements;

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
				return 150;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 6f;
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
		}, 1, -2.9000000000000001f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("copper_axe"));
	}
}

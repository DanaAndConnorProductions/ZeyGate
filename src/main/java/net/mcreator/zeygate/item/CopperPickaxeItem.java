
package net.mcreator.zeygate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.zeygate.ZeygateModElements;

@ZeygateModElements.ModElement.Tag
public class CopperPickaxeItem extends ZeygateModElements.ModElement {
	@ObjectHolder("zeygate:copper_pickaxe")
	public static final Item block = null;
	public CopperPickaxeItem(ZeygateModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 150;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 1f;
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
		}, 1, -2.7f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("copper_pickaxe"));
	}
}

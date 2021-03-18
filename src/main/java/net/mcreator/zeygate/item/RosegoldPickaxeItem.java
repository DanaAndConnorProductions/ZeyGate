
package net.mcreator.zeygate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.zeygate.ZeygateModElements;

@ZeygateModElements.ModElement.Tag
public class RosegoldPickaxeItem extends ZeygateModElements.ModElement {
	@ObjectHolder("zeygate:rosegold_pickaxe")
	public static final Item block = null;
	public RosegoldPickaxeItem(ZeygateModElements instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 14f;
			}

			public float getAttackDamage() {
				return 2f;
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
		}, 1, -2.5999999999999999f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("rosegold_pickaxe"));
	}
}

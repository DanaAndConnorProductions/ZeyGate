
package net.mcreator.zeygate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.zeygate.ZeygateModElements;

@ZeygateModElements.ModElement.Tag
public class GrassBladeItem extends ZeygateModElements.ModElement {
	@ObjectHolder("zeygate:grass_blade")
	public static final Item block = null;
	public GrassBladeItem(ZeygateModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -1.8000000000000003f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("grass_blade"));
	}
}

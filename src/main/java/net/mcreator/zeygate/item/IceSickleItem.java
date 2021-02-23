
package net.mcreator.zeygate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;
import net.minecraft.entity.LivingEntity;

import net.mcreator.zeygate.procedures.IceSickleLivingEntityIsHitWithToolProcedure;
import net.mcreator.zeygate.ZeygateModElements;

import java.util.Map;
import java.util.HashMap;

@ZeygateModElements.ModElement.Tag
public class IceSickleItem extends ZeygateModElements.ModElement {
	@ObjectHolder("zeygate:ice_sickle")
	public static final Item block = null;
	public IceSickleItem(ZeygateModElements instance) {
		super(instance, 44);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 1f;
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
		}, 0, -3.2000000000000001f, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					IceSickleLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("ice_sickle"));
	}
}

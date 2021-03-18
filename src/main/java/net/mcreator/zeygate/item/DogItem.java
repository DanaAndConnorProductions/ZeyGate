
package net.mcreator.zeygate.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.zeygate.ZeygateModElements;

@ZeygateModElements.ModElement.Tag
public class DogItem extends ZeygateModElements.ModElement {
	@ObjectHolder("zeygate:dog")
	public static final Item block = null;
	public DogItem(ZeygateModElements instance) {
		super(instance, 62);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, ZeygateModElements.sounds.get(new ResourceLocation("zeygate:discdog")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("dog");
		}
	}
}

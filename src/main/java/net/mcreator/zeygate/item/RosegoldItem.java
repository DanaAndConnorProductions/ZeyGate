
package net.mcreator.zeygate.item;

@ZeygateModElements.ModElement.Tag
public class RosegoldItem extends ZeygateModElements.ModElement {

	@ObjectHolder("zeygate:rosegold_helmet")
	public static final Item helmet = null;

	@ObjectHolder("zeygate:rosegold_chestplate")
	public static final Item body = null;

	@ObjectHolder("zeygate:rosegold_leggings")
	public static final Item legs = null;

	@ObjectHolder("zeygate:rosegold_boots")
	public static final Item boots = null;

	public RosegoldItem(ZeygateModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 17;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 6, 7, 3}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 22;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_gold"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CopperIngotItem.block, (int) (1)), new ItemStack(CopperIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "rosegold";
			}

			@Override
			public float getToughness() {
				return 0.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zeygate:textures/models/armor/rosegold__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("rosegold_helmet"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zeygate:textures/models/armor/rosegold__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("rosegold_chestplate"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zeygate:textures/models/armor/rosegold__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("rosegold_leggings"));

		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "zeygate:textures/models/armor/rosegold__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

		}.setRegistryName("rosegold_boots"));
	}

}
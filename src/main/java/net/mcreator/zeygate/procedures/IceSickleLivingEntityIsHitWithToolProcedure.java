package net.mcreator.zeygate.procedures;

@ZeygateModElements.ModElement.Tag
public class IceSickleLivingEntityIsHitWithToolProcedure extends ZeygateModElements.ModElement {

	public IceSickleLivingEntityIsHitWithToolProcedure(ZeygateModElements instance) {
		super(instance, 44);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZeygateMod.LOGGER.warn("Failed to load dependency entity for procedure IceSickleLivingEntityIsHitWithTool!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		entity.extinguish();
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 100, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 100, (int) 1));

	}

}

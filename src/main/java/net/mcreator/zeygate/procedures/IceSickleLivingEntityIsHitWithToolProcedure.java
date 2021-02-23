package net.mcreator.zeygate.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zeygate.ZeygateModElements;
import net.mcreator.zeygate.ZeygateMod;

import java.util.Map;

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
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 80, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 80, (int) 1));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 80, (int) 1));
	}
}

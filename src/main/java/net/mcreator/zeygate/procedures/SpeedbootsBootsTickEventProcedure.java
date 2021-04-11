package net.mcreator.zeygate.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.zeygate.ZeygateModElements;
import net.mcreator.zeygate.ZeygateMod;

import java.util.Map;

@ZeygateModElements.ModElement.Tag
public class SpeedbootsBootsTickEventProcedure extends ZeygateModElements.ModElement {
	public SpeedbootsBootsTickEventProcedure(ZeygateModElements instance) {
		super(instance, 81);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ZeygateMod.LOGGER.warn("Failed to load dependency entity for procedure SpeedbootsBootsTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 10, (int) 1, (false), (false)));
	}
}

package net.mcreator.zeygate.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;

import net.mcreator.zeygate.ZeygateModElements;
import net.mcreator.zeygate.ZeygateMod;

import java.util.Map;

@ZeygateModElements.ModElement.Tag
public class BlaststoneBlockDestroyedByPlayerProcedure extends ZeygateModElements.ModElement {
	public BlaststoneBlockDestroyedByPlayerProcedure(ZeygateModElements instance) {
		super(instance, 101);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZeygateMod.LOGGER.warn("Failed to load dependency x for procedure BlaststoneBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZeygateMod.LOGGER.warn("Failed to load dependency y for procedure BlaststoneBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZeygateMod.LOGGER.warn("Failed to load dependency z for procedure BlaststoneBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZeygateMod.LOGGER.warn("Failed to load dependency world for procedure BlaststoneBlockDestroyedByPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !((World) world).isRemote) {
			((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
		}
	}
}

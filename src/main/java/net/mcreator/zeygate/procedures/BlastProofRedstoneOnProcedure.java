package net.mcreator.zeygate.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

import net.mcreator.zeygate.block.BlastProofActivatedBlock;
import net.mcreator.zeygate.ZeygateModElements;
import net.mcreator.zeygate.ZeygateMod;

import java.util.Map;

@ZeygateModElements.ModElement.Tag
public class BlastProofRedstoneOnProcedure extends ZeygateModElements.ModElement {
	public BlastProofRedstoneOnProcedure(ZeygateModElements instance) {
		super(instance, 86);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ZeygateMod.LOGGER.warn("Failed to load dependency x for procedure BlastProofRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ZeygateMod.LOGGER.warn("Failed to load dependency y for procedure BlastProofRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ZeygateMod.LOGGER.warn("Failed to load dependency z for procedure BlastProofRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ZeygateMod.LOGGER.warn("Failed to load dependency world for procedure BlastProofRedstoneOn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			BlockState _bs = BlastProofActivatedBlock.block.getDefaultState();
			world.setBlockState(_bp, _bs, 3);
		}
	}
}

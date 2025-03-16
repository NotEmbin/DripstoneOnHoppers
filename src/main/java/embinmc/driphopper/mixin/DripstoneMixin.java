package embinmc.driphopper.mixin;

import embinmc.driphopper.DripstoneOnHoppers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PointedDripstoneBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(PointedDripstoneBlock.class)
public class DripstoneMixin {
	/**
	 * @author Embin
	 * @reason Take a guess.
	 */
	@Overwrite
	private static boolean canPlaceAtWithDirection(WorldView world, BlockPos pos, Direction direction) {
		BlockPos blockPos = pos.offset(direction.getOpposite());
		BlockState blockState = world.getBlockState(blockPos);
		if (blockState.isIn(DripstoneOnHoppers.CANNOT_PLACE_ON)) return false;
		return blockState.isSideSolidFullSquare(world, blockPos, direction) ||
				isPointedDripstoneFacingDirection(blockState, direction) ||
				blockState.isIn(DripstoneOnHoppers.CAN_PLACE_ON);
	}

	private static boolean isPointedDripstoneFacingDirection(BlockState state, Direction direction) {
		return state.isOf(Blocks.POINTED_DRIPSTONE) && state.get(PointedDripstoneBlock.VERTICAL_DIRECTION) == direction;
	}
}
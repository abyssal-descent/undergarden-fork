package quek.undergarden.entity.stoneborn.goals;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import quek.undergarden.entity.stoneborn.Stoneborn;

import java.util.EnumSet;

public class StonebornTradeWithPlayerGoal extends Goal {

	private final Stoneborn stoneborn;

	public StonebornTradeWithPlayerGoal(Stoneborn stoneborn) {
		this.stoneborn = stoneborn;
		this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
	}

	@Override
	public boolean canUse() {
		var sb = this.stoneborn;
		if (!sb.isAlive() || sb.isInWater() || !sb.onGround() || sb.hurtMarked)
			return false;

		Player player = this.stoneborn.getTradingPlayer();
		if (player == null || sb.distanceToSqr(player) > 16.0D)
			return false;

		return player.containerMenu != null;
	}

	@Override
	public void start() {
		this.stoneborn.getNavigation().stop();
	}

	@Override
	public void stop() {
		this.stoneborn.setTradingPlayer(null);
	}
}

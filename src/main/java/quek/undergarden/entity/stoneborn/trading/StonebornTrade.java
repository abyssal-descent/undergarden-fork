package quek.undergarden.entity.stoneborn.trading;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import quek.undergarden.registry.UGItems;

import java.util.Optional;

public class StonebornTrade implements VillagerTrades.ItemListing {
	private final Pair<ItemStack, Optional<ItemStack>> inputs;
	private final ItemStack output;
	private final int uses;

	public StonebornTrade(ItemStack input, ItemStack output, int uses) {
		this(Pair.of(input, Optional.empty()), output, uses);
	}

	public StonebornTrade(ItemStack input_a, ItemStack input_b, ItemStack output, int uses) {
		this(Pair.of(input_a, Optional.of(input_b)), output, uses);
	}

	public StonebornTrade(Pair<ItemStack, Optional<ItemStack>> inputs, ItemStack output, int uses) {
		this.inputs = inputs;
		this.output = output;
		this.uses = uses;
	}

	@Override
	public MerchantOffer getOffer(Entity entity, RandomSource random) {
		return this.inputs.b
			.map(b -> new MerchantOffer(this.inputs.a, b, this.output, this.uses, 0, 0))
			.orElseGet(() -> new MerchantOffer(this.inputs.a, this.output, this.uses, 0, 0));
	}
}

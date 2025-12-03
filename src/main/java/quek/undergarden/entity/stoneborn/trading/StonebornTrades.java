package quek.undergarden.entity.stoneborn.trading;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import quek.undergarden.registry.UGBlocks;
import quek.undergarden.registry.UGItems;

public class StonebornTrades {
	public static Int2ObjectMap<VillagerTrades.ItemListing[]> TRADES = null;

	public static void maybe_init() {
		if (StonebornTrades.TRADES == null) new StonebornTrades();
	}

	private StonebornTrades() {
		var regalium = UGItems.REGALIUM_CRYSTAL.get();

		StonebornTrades.TRADES = new Int2ObjectOpenHashMap<>(ImmutableMap.of(1, new VillagerTrades.ItemListing[] {
			new StonebornTrade(new ItemStack(regalium, 32), new ItemStack(UGItems.LIMAX_MAXIMUS_DISC.get(), 1), 1),
			new StonebornTrade(new ItemStack(regalium, 32), new ItemStack(UGItems.GLOOMPER_ANTHEM_DISC.get(), 1), 1),
			new StonebornTrade(new ItemStack(regalium, 32), new ItemStack(UGItems.MAMMOTH_DISC.get(), 1), 1),
			new StonebornTrade(new ItemStack(regalium, 32), new ItemStack(UGItems.RELICT_DISC.get(), 1), 1),
			new StonebornTrade(new ItemStack(regalium, 16), new ItemStack(UGItems.BLISTERBOMB.get(), 8), 24),
			new StonebornTrade(new ItemStack(regalium, 1), new ItemStack(UGItems.GLOOMGOURD_SEEDS.get(), 6), 6),
			new StonebornTrade(new ItemStack(regalium, 1), new ItemStack(UGBlocks.SHARD_TORCH.get().asItem(), 4), 10),
			new StonebornTrade(new ItemStack(Items.DIAMOND, 1), new ItemStack(regalium, 12), 5),
			new StonebornTrade(new ItemStack(Items.IRON_INGOT, 1), new ItemStack(regalium, 4), 5),
			new StonebornTrade(new ItemStack(Items.GOLD_INGOT, 1), new ItemStack(regalium, 2), 5),
			new StonebornTrade(new ItemStack(UGBlocks.UTHERIUM_BLOCK.get().asItem(), 1), new ItemStack(regalium, 48), 2),

			new StonebornTrade(
				new ItemStack(UGItems.CLOGGRUM_PICKAXE.get(), 1),
				new ItemStack(UGItems.FORGOTTEN_INGOT.get(), 1),
				new ItemStack(UGItems.FORGOTTEN_PICKAXE.get(), 1), 1),

			new StonebornTrade(
				new ItemStack(get_item("adresources", "empty_forgotten_bottle"), 1),
				new ItemStack(get_item("bosses_of_mass_destruction", "crystal_fruit"), 1),
				new ItemStack(get_item("adresources", "acid_bottle"), 1), 4)
		}));
	}

	private Item get_item(String ns, String path) {
		return BuiltInRegistries.ITEM.get(new ResourceLocation(ns, path));
	}

	// private ItemStack get_item(String id, int count) {
	// 	return new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(id)), count);
	// }
}

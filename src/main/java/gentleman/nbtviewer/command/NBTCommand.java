package gentleman.nbtviewer.command;

import org.rusherhack.client.api.feature.command.Command;
import org.rusherhack.core.command.annotations.CommandExecutor;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.client.MinecraftClient;

/**
 * Command to view NBT tags of an item held in hand
 */
public class NBTCommand extends Command {

	public NBTCommand() {
		super("nbt", "View NBT tags of the item held in your hand.");
	}

	@CommandExecutor
	private String viewNBT() {
		MinecraftClient mc = MinecraftClient.getInstance();
		if (mc != null) {
			ItemStack heldItem = mc.player.getMainHandStack();

			if (!heldItem.isEmpty()) {
				NbtCompound itemNBT = heldItem.getNbt();

				if (itemNBT != null) {
					return "NBT Tags for the held item: " + itemNBT.toString();
				} else {
					return "The held item has no NBT tags.";
				}
			} else {
				return "You are not holding an item in your hand.";
			}
		}

		return "Failed to retrieve NBT data.";
	}
}

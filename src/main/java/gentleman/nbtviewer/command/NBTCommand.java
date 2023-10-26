package gentleman.nbtviewer.command;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.rusherhack.client.api.feature.command.Command;
import org.rusherhack.core.command.annotations.CommandExecutor;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;
import net.minecraft.client.MinecraftClient;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class NBTCommand extends Command {

	public NBTCommand() {
		super("nbt", "View or copy NBT tags of the item held in your hand.");
	}

	@CommandExecutor(subCommand = "view")
	private String viewNBT() {
		MinecraftClient mc = MinecraftClient.getInstance();
		if (mc != null) {
			ItemStack heldItem = mc.player.getMainHandStack();

			if (!heldItem.isEmpty()) {
				NbtCompound itemNBT = heldItem.getNbt();

				if (itemNBT != null) {
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					String formattedNBT = gson.toJson(itemNBT);

					return "NBT Tags for the held item:\n" + formattedNBT;
				} else {
					return "The held item has no NBT tags.";
				}
			} else {
				return "You are not holding an item in your hand.";
			}
		}
		return "Failed to retrieve NBT data.";
	}

	@CommandExecutor(subCommand = "copy")
	private String copyNBT() {
		MinecraftClient mc = MinecraftClient.getInstance();
		if (mc != null) {
			ItemStack heldItem = mc.player.getMainHandStack();

			if (!heldItem.isEmpty()) {
				NbtCompound itemNBT = heldItem.getNbt();

				if (itemNBT != null) {
					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					String formattedNBT = gson.toJson(itemNBT);

					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(formattedNBT), null);
					return "NBT Tags for the held item copied to clipboard.";
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

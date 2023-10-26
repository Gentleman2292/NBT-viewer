package gentleman.nbtviewer;

import gentleman.nbtviewer.command.NBTCommand;
import org.rusherhack.client.api.RusherHackAPI;

/**
 * Example rusherhack plugin
 *
 * @author John200410
 */
public class Plugin extends org.rusherhack.client.api.plugin.Plugin {
	
	@Override
	public void onLoad() {
		
		this.getLogger().info(this.getName() + " loaded!");

		final NBTCommand nbtCommand = new NBTCommand();
		RusherHackAPI.getCommandManager().registerFeature(nbtCommand);
	}
	
	@Override
	public void onUnload() {
		this.getLogger().info(this.getName() + " unloaded!");
	}
	
	@Override
	public String getName() {
		return "NBTViewer";
	}
	
	@Override
	public String getVersion() {
		return "v1.0";
	}
	
	@Override
	public String getDescription() {
		return "nbt viewer command plugin";
	}
	
	@Override
	public String[] getAuthors() {
		return new String[]{"Gentleman"};
	}
}

package DerpSong.proxies;

import net.minecraftforge.common.MinecraftForge;
import DerpSong.events.soundManager;
import DerpSong.util.tickHandlerServer;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class ClientProxy extends CommonProxy {
	
	@SideOnly(Side.CLIENT)
	public static void soundHandler() {
	    MinecraftForge.EVENT_BUS.register(new soundManager());
	}
	@SideOnly(Side.CLIENT)
	public static void tickHandler() {
		tickHandlerServer = new tickHandlerServer();
	    TickRegistry.registerTickHandler(tickHandlerServer, Side.CLIENT);

	}
}

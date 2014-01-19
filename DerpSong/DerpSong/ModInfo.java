package DerpSong;

import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class ModInfo {
	public static final String MOD_ID = "DerpSong";
	public static final String MOD_NAME = "Derp Song Mod";
	public static final String MOD_VERSION = "1";
	public static final String MOD_CHANNEL = "DerpMod_Mex";
	public static Logger logger = Logger.getLogger("DerpSong");
	
	static{
		logger.setParent(FMLLog.getLogger());
	}
}

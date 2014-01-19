package DerpSong.util;

import java.io.File;

import net.minecraftforge.common.Configuration;
import DerpSong.Main;
import DerpSong.ModInfo;

public class config {
	
	public static int recordCrispy_ID;
	public static final String recordCrispy_KEY = "Record ID";
	public static final int recordCrispy_DEFAULT = 5000;
	
	public static int crispyPop_ID;
	public static final String crispyPop_KEY = "Crispy Pops";
	public static final int crispyPop_DEFAULT = 5001;
	
	public static void createConfig(File file){
	    ModInfo.logger.info("More Records ModConfiguration Detected!");
	    Configuration config = new Configuration(file);
	    config.load();
	  
	    recordCrispy_ID = config.getItem(recordCrispy_KEY, recordCrispy_DEFAULT).getInt() - 256;
	    crispyPop_ID = config.getItem(crispyPop_KEY, crispyPop_DEFAULT).getInt() - 256;
	  
	    Main.configPlayTime = config.get(Configuration.CATEGORY_GENERAL, "Play time of song", 24).getInt();
	    
	    config.save();
	    ModInfo.logger.info("More Records ModConfig Loaded!");
	}

}

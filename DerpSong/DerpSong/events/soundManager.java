package DerpSong.events;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import DerpSong.ModInfo;

public class soundManager {
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event){
		try{
			event.manager.soundPoolStreaming.addSound("derpsong:crispy.ogg");
		    ModInfo.logger.info("Loaded Sounds.");
		}
		catch(Exception e){
		      ModInfo.logger.warning("Looks like there was a problem loading the sounds with Derpy Songs");
		}
	}

}

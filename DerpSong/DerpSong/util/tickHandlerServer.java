package DerpSong.util;

import java.util.Calendar;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import DerpSong.Main;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;

public class tickHandlerServer implements ITickHandler{
	Set playingSounds = ReflectionHelper.getPrivateValue(SoundManager.class, Minecraft.getMinecraft().sndManager, "playingSounds", "field_82470_g");
	static boolean isPlaying;
	
	public void playerTick(World world, EntityPlayerMP player){
		if(getTime() == Main.configPlayTime){
			
			if(/*playingSounds.contains("streaming") != true*/ isPlaying == false){
				isPlaying = true;
				Minecraft.getMinecraft().sndManager.playStreaming("derpsong:crispy", (float)player.posX, (float)player.posY, (float)player.posZ);
				//isPlaying = false;
			}
			Minecraft.getMinecraft().sndManager.sndSystem.setPosition("streaming", (float)player.posX, (float)player.posY, (float)player.posZ);			
			// world.playAuxSFXAtEntity((EntityPlayer)null, 1005, (int)player.posX, (int)player.posY, (int)player.posZ, Main.record_ID);
		}
	}
	  
	  public static int getTime(){
		  
		  Calendar calendar = new GregorianCalendar();
		 
		  int hour = calendar.get(Calendar.MINUTE);
		  
		  Main.hourTime = hour;
		  return Main.hourTime;
	  }

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {	
	}
/*
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	      if (type.equals(EnumSet.of(TickType.PLAYER))) {
	    	  playerTick(((EntityPlayer)tickData[0]).worldObj, (EntityPlayerMP)tickData[0]);
	      }
	}
*/
	@Override
	public EnumSet<TickType> ticks() {
	    return EnumSet.of(TickType.WORLD, TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "TickHandlerServerDerpSong";
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

}

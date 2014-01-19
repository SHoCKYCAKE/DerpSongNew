package DerpSong.items;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class itemRecordCore extends ItemRecord{
	
	private static final Map records = new HashMap();
	public final String recordSound;
	public final String recordName;

	public itemRecordCore(int id, String sound, String name) {
		super(id, sound);
		this.recordSound = sound;
		this.recordName = name;
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabs.tabMisc);
		records.put(sound, this);
	}
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.getBlockId(par4, par5, par6) == Block.jukebox.blockID && par3World.getBlockMetadata(par4, par5, par6) == 0)
        {
            if (par3World.isRemote)
            {
                return true;
            }
            else
            {
                ((BlockJukeBox)Block.jukebox).insertRecord(par3World, par4, par5, par6, par1ItemStack);
                par3World.playAuxSFXAtEntity((EntityPlayer)null, 1005, par4, par5, par6, this.itemID);
                --par1ItemStack.stackSize;
                return true;
            }
        }
        else
        {
            return false;
        }
    }
	
    @SideOnly(Side.CLIENT)
    public static itemRecordCore getRecord(String par0Str){
    	return (itemRecordCore)records.get(par0Str);
    }
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int par1){
    	return this.itemIcon;
    }
    
    

}

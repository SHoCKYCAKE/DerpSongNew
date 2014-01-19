package DerpSong.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class itemCrispyPops extends ItemFood{
	String texture_LOC = "derpsong";
	String crispyPops_ICON = "crispy_pops";

	public itemCrispyPops(int id, int healAmount, float saturation, boolean isWolfFood) {
		super(id, healAmount, saturation, isWolfFood);
		setCreativeTab(CreativeTabs.tabFood);
		setMaxStackSize(64);
		setUnlocalizedName("crispyPops");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		itemIcon = register.registerIcon(texture_LOC + ":" + crispyPops_ICON)
;	}
}

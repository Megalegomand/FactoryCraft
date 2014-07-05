package me.MnomisC.FactoryCraft.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TEWoodMultiblock extends TEMultiBlock implements IInventory {

	private ItemStack[] inventory;
	
	public TEWoodMultiblock() {
		super();
		inventory = new ItemStack[1];
	}
	
	public void updateEntity() {
		super.updateEntity();
	}
	
	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return inventory[1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) {
		ItemStack is = getStackInSlot(var1);
		if (is != null) {
			if (is.stackSize <= var2) {
				setInventorySlotContents(var1, null);
			} else {
				is = is.splitStack(var2);
				onInventoryChanged();
			}
		}
		return is;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		ItemStack is = getStackInSlot(var1);
		setInventorySlotContents(var1, null);
		
		return is;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) {
		inventory[var1] = var2;
		
		if (var2 != null && var2.stackSize > getInventoryStackLimit()) {
			var2.stackSize = getInventoryStackLimit();
		}
		onInventoryChanged();
	}

	@Override
	public String getInventoryName() {
		return "Wood Multiblock";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		if (var1.getDistanceSq(xCoord - (int) 0.5D, yCoord - (int) 0.5D, zCoord - (int) 0.5D) <= 64) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}
	
	public void onInventoryChanged() {
		
	}

	@Override
	public void markDirty() {
	}

	@Override
	public boolean checkBlock(TileEntity te) {
		if (te != null) {
			if (te instanceof TEWoodMultiblock) {
				return true;
			}
		}
		
		return false;
	}
}

package me.MnomisC.FactoryCraft.TileEntity;

import java.util.ArrayList;

import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public abstract class TEMultiBlock extends TileEntity implements IInventory {
	
	public boolean isMainBlock = true;
	public boolean canBeMainBlock = true;
	
	public TileEntity mainBlock;
	
	public int xHeight;
	public int yHeight;
	public int zHeight;
	
	public Object extension;
	
	public ArrayList<TileEntity> blocks = new ArrayList<TileEntity>();
	public TileEntity[] corners = new TileEntity[8];
	public ArrayList<TileEntity[]> edges = new ArrayList<TileEntity[]>();
	
	@Deprecated
	public ArrayList<TileEntity> frame = new ArrayList<TileEntity>();
	
	public TEMultiBlock() {
	}
	
	@Override
	public void updateEntity() {
		if (isMainBlock) {
			canBeMainBlock = true;
			mainBlock = null;
		}
		if (canBeMainBlock) {
			if (getXPlus() != null) {
				xHeight = 2;
				boolean r = true;
				TEMultiBlock current = getXPlus();
				if (current != null) {
					while (r) {
						if (current.getXPlus() == null) {
							r = false;
						} else {
							xHeight++;
							current = current.getXPlus();
						}
					}
				}
			}
			if (xHeight < 3) {
				isMainBlock = false;
				return;
			}
			
			if (getYPlus() != null) {
				yHeight = 2;
				boolean r = true;
				TEMultiBlock current = getYPlus();
				if (current != null) {
					while (r) {
						if (current.getYPlus() == null) {
							r = false;
						} else {
							yHeight++;
							current = current.getYPlus();
						}
					}
				}
			}
			if (yHeight < 3) {
				isMainBlock = false;
				return;
			}
			
			if (getZPlus() != null) {
				zHeight = 2;
				boolean r = true;
				TEMultiBlock current = getZPlus();
				if (current != null) {
					while (r) {
						if (current.getZPlus() == null) {
							r = false;
						} else {
							zHeight++;
							current = current.getZPlus();
						}
					}
				}
			}
			if (zHeight < 3) {
				isMainBlock = false;
				return;
			}
			
			for (int i = 0; i < corners.length; i++) {
				int x = (i == 0 || i == 2 || i == 4 || i == 6 ? xCoord : xCoord + xHeight - 1);
				int y = (i == 0 || i == 1 || i == 2 || i == 3 ? yCoord : yCoord + yHeight - 1);
				int z = (i == 0 || i == 1 || i == 4 || i == 5 ? zCoord : zCoord + zHeight - 1);
				TileEntity te = worldObj.getTileEntity(x, y, z);
				if (checkBlock(te)) {
					corners[i] = te;
					((TEMultiBlock) te).canBeMainBlock = false;
					((TEMultiBlock) te).mainBlock = this;
				} else {
					isMainBlock = false;
					return;
				}
			}
			
			if (!registerEdges(corners[0], corners[2]) || !registerEdges(corners[0], corners[1]) || !registerEdges(corners[1], corners[3]) || !registerEdges(corners[2], corners[3])) {
				return;
			}
			
			if (!registerEdges(corners[0], corners[4]) || !registerEdges(corners[1], corners[5]) || !registerEdges(corners[2], corners[6]) || !registerEdges(corners[3], corners[7])) {
				return;
			}
			
			if (!registerEdges(corners[4], corners[5]) || !registerEdges(corners[4], corners[6]) || !registerEdges(corners[6], corners[7]) || !registerEdges(corners[5], corners[7])) {
				return;
			}
			
			registerEdgesMetadata(0, 5);
			registerEdgesMetadata(1, 6);
			registerEdgesMetadata(2, 7);
			registerEdgesMetadata(3, 8);
			
			registerEdgesMetadata(4, 9);
			registerEdgesMetadata(5, 10);
			registerEdgesMetadata(6, 10);
			registerEdgesMetadata(7, 9);
			
			registerEdgesMetadata(8, 8);
			registerEdgesMetadata(9, 7);
			registerEdgesMetadata(10, 6);
			registerEdgesMetadata(11, 5);
			
			for (int i = 0; i < corners.length; i++) {
				TileEntity te = corners[i];
				worldObj.setBlockMetadataWithNotify(te.xCoord, te.yCoord, te.zCoord, (i == 0 || i == 7 ? 1 : (i == 1 || i == 6 ? 2 : (i == 2 || i == 5 ? 3 : (i == 3 || i == 4 ? 4 : 0)))), 2);
			}
			
			blocks.clear();
			for (int x = this.xCoord; x < this.xCoord + this.xHeight; x++) {
				for (int y = this.yCoord; y < this.yCoord + this.yHeight; y++) {
					for (int z = this.zCoord; x < this.zCoord + this.zHeight; z++) {
						if (checkBlock(this.worldObj.getTileEntity(x, y, z))) {
							this.blocks.add(this.worldObj.getTileEntity(x, y, z));
						}
					}
				}
			}
		} else {
			if (!isMainBlock) {
				if (mainBlock != null) {
					if (checkBlock(mainBlock.xCoord, mainBlock.yCoord, mainBlock.zCoord)) {
						TEMultiBlock te = (TEMultiBlock) worldObj.getTileEntity(mainBlock.xCoord, mainBlock.yCoord, mainBlock.zCoord);
						if (te.isMainBlock) {
							canBeMainBlock = false;
						} else {
							canBeMainBlock = true;
							worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 2);
						}
					} else {
						canBeMainBlock = true;
						worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 2);
					}
				} else {
					canBeMainBlock = true;
					worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 2);
				}
			}
		}
	}
	
	public boolean registerEdges(TileEntity p1, TileEntity p2) {
		boolean ux = p1.yCoord == p2.yCoord && p1.zCoord == p2.zCoord;
		boolean uy = p1.xCoord == p2.xCoord && p1.zCoord == p2.zCoord;
		boolean uz = p1.yCoord == p2.yCoord && p1.xCoord == p2.xCoord;
		
		int height = (ux ? p2.xCoord - p1.xCoord : (uy ? p2.yCoord - p1.yCoord : p2.zCoord - p1.zCoord)) - 1;
		
		TileEntity[] tes = new TileEntity[Math.abs(height)];
		for (int i = 1; i <= height; i++) {
			TileEntity te = worldObj.getTileEntity((ux ? i + p1.xCoord : p1.xCoord), (uy ? i + p1.yCoord : p1.yCoord), (uz ? i + p1.zCoord : p1.zCoord));
			if (checkBlock(te)) {
				tes[i - 1] = te;
				((TEMultiBlock) te).mainBlock = this;
			} else {
				isMainBlock = false;
				return false;
			}
		}
		edges.add(tes);
		return true;
	}
	
	public void registerEdgesMetadata(int index, int metadata) {
		for (TileEntity te : edges.get(index)) {
			worldObj.setBlockMetadataWithNotify(te.xCoord, te.yCoord, te.zCoord, metadata, 2);
		}
	}
	
	public boolean checkBlock(int x, int y, int z) {
		TileEntity te = worldObj.getTileEntity(x, y, z);
		
		if (checkBlock(te)) {
			return true;
		}
		
		return false;
	}
	
	public abstract boolean checkBlock(TileEntity te);
	/*public boolean checkBlock(TileEntity te) {
		if (te != null) {
			if (te instanceof TEMultiBlock) {
				return true;
			}
		}
		
		return false;
	}*/
	
	public TEMultiBlock getYMinus() {
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord - 1, zCoord);
		
		if (checkBlock(te)) {
			return (TEMultiBlock) te;
		}
		
		return null;
	}
	
	public TEMultiBlock getYPlus() {
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord + 1, zCoord);
		
		if (checkBlock(te)) {
			return (TEMultiBlock) te;
		}
		
		return null;
	}
	
	public TEMultiBlock getXMinus() {
		TileEntity te = worldObj.getTileEntity(xCoord - 1, yCoord, zCoord);
		
		if (checkBlock(te)) {
			return (TEMultiBlock) te;
		}
		
		return null;
	}
	
	public TEMultiBlock getXPlus() {
		TileEntity te = worldObj.getTileEntity(xCoord + 1, yCoord, zCoord);
		
		if (checkBlock(te)) {
			return (TEMultiBlock) te;
		}
		
		return null;
	}
	
	public TEMultiBlock getZMinus() {
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord - 1);
		
		if (checkBlock(te)) {
			return (TEMultiBlock) te;
		}
		
		return null;
	}
	
	public TEMultiBlock getZPlus() {
		TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord + 1);
		
		if (checkBlock(te)) {
			return (TEMultiBlock) te;
		}
		
		return null;
	}
}

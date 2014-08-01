package de.kaenganxt.aquarium.tileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class Generator extends TileEntity
{
    int storedPowerLevel = 0;
    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("storedPowerLevel", storedPowerLevel);
        super.writeToNBT(nbt);
    }
    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        storedPowerLevel = nbt.getInteger("storedPowerLevel");
        super.readFromNBT(nbt);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(xCoord,yCoord,zCoord,1,nbt);
    }

    
}

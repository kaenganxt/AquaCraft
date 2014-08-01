package de.kaenganxt.aquarium.blocks;

import de.kaenganxt.aquarium.tileEntities.Generator;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GeneratorBlock extends BlockContainer
{
    public GeneratorBlock(Material mat)
    {
        super(mat);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new Generator();
    }
}

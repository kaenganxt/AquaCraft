package de.kaenganxt.aquarium.world;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class SeaWorldGen implements IWorldGenerator
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if(b.biomeName.equals("Ocean")) 
        {
            if(random.nextInt(15) == 1)
            {
                int x = chunkX*16 + 2 + random.nextInt(12);
                int z = chunkZ*16 + 2 + random.nextInt(12);
                for(int i = x-2; i < x+2; i++)
                {
                    for(int j = z-2; j < z+2; j++)
                    {
                        if(random.nextInt(4) != 3)
                        {
                            
                        }
                    }
                }
            }
        }
    }   
}
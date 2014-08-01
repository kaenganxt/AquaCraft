package de.kaenganxt.aquarium;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import de.kaenganxt.aquarium.blocks.CoverLampBlock;
import de.kaenganxt.aquarium.blocks.EdgeBlock;
import de.kaenganxt.aquarium.blocks.GeneratorBlock;
import de.kaenganxt.aquarium.blocks.GlassBlock;
import de.kaenganxt.aquarium.tileEntities.Generator;
import de.kaenganxt.aquarium.world.SeaWorldGen;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@Mod(modid = AquariumMod.MODID, version = AquariumMod.VERSION)
public class AquariumMod
{
    public static final String MODID = "aquariumMod";
    public static final String VERSION = "0.1";
    
    @Instance(value = MODID)
    public static AquariumMod instance;
    
    @SidedProxy(clientSide="de.kaenganxt.aquarium.ClientProxy", serverSide="de.kaenganxt.aquarium.ServerProxy")
    public static ServerProxy proxy;
    
    
    
    public final static CreativeTabs aquaCraftTab = new CreativeTabs("aquaCraft") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.water_bucket;
        }
    };
    public final static CreativeTabs aquaCraftAnimalsTab = new CreativeTabs("aquaCraftAnimals") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.fish;
        }
    };
    //Items
    public static Item fishFood;
    public static Item fisherNet;
    //End Items
    
    //Blocks           
    public static final Block coverLampBlock = new CoverLampBlock(Material.glass)
        .setHardness(0.05F).setStepSound(Block.soundTypeGlass)
        .setBlockName("aquaCoverLampBlock").setCreativeTab(aquaCraftTab)
        .setLightLevel(5).setBlockTextureName("aquariummod:coverLamp");
    public final static Block edgeBlock = new EdgeBlock(Material.ground)
        .setHardness(0.2F).setStepSound(Block.soundTypeStone)
        .setBlockName("aquaEdgeBlock").setCreativeTab(aquaCraftTab)
        .setBlockTextureName("aquariummod:edgeBlock");
    public final static Block glassBlock = new GlassBlock(Material.glass)
        .setHardness(0.05F).setStepSound(Block.soundTypeGlass)
        .setBlockName("aquaGlassBlock").setCreativeTab(aquaCraftTab)
        .setBlockTextureName("aquariummod:glassBlock");
    public final static Block generator = new GeneratorBlock(Material.ground)
        .setHardness(0.05F).setStepSound(Block.soundTypeGlass)
        .setBlockName("aquaGeneratorBlock").setCreativeTab(aquaCraftTab)
        .setBlockTextureName("aquariummod:generatorBlock");
    //End Blocks
    
    //World Generator
    public static SeaWorldGen seaGenerator = new SeaWorldGen();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenderers();
        GameRegistry.registerBlock(coverLampBlock, "aquaCoverLampBlock");
        GameRegistry.registerBlock(edgeBlock, "aquaEdgeBlock");
        GameRegistry.registerBlock(glassBlock, "aquaGlassBlock");
        GameRegistry.registerBlock(generator, "aquaGeneratorBlock");
        GameRegistry.registerTileEntity(Generator.class, "aquaGeneratorTile");
        GameRegistry.registerWorldGenerator(seaGenerator, 10);
    }
}

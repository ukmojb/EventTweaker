package com.wdcftgg.eventtweaker.common.api.Methods;

import crafttweaker.annotations.ZenRegister;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureStart;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ZenRegister
@ZenClass("mods.eventtweaker.Structure")
public class Structure {
    private boolean isPlayerInAnyStructure(World world, BlockPos pos) {
        List<MapGenStructure> structures = getAllStructures(world);

        for (MapGenStructure structure : structures) {
            Map<Long, StructureStart> structureMap = getStructureMap(structure);
            if (structureMap != null) {
                for (StructureStart start : structureMap.values()) {
                    StructureBoundingBox box = start.getBoundingBox();
                    if (box != null && box.isVecInside(pos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @ZenMethod
    public static List<MapGenStructure> getAllStructures(World world) {
        List<MapGenStructure> structures = new ArrayList<>();

        if (world.getChunkProvider() instanceof ChunkProviderServer) {
            ChunkProviderServer chunkProviderServer = (ChunkProviderServer) world.getChunkProvider();
            Object chunkGenerator = chunkProviderServer.chunkGenerator;

            if (chunkGenerator instanceof ChunkGeneratorOverworld) {
                ChunkGeneratorOverworld generator = (ChunkGeneratorOverworld) chunkGenerator;
                structures.add(getField(generator, "mineshaftGenerator"));
                structures.add(getField(generator, "villageGenerator"));
                structures.add(getField(generator, "strongholdGenerator"));
                structures.add(getField(generator, "scatteredFeatureGenerator"));
            } else if (chunkGenerator instanceof ChunkGeneratorEnd) {
                ChunkGeneratorEnd generator = (ChunkGeneratorEnd) chunkGenerator;
                structures.add(getField(generator, "endCityGenerator"));
            } else if (chunkGenerator instanceof ChunkGeneratorHell) {
                ChunkGeneratorHell generator = (ChunkGeneratorHell) chunkGenerator;
                structures.add(getField(generator, "netherBridgeGenerator"));
            }
        }

        return structures;
    }

    private Map<Long, StructureStart> getStructureMap(MapGenStructure structure) {
        try {
            Field structureMapField = MapGenStructure.class.getDeclaredField("structureMap");
            structureMapField.setAccessible(true);
            return (Map<Long, StructureStart>) structureMapField.get(structure);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static MapGenStructure getField(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (MapGenStructure) field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.wdcftgg.eventtweaker.common.api.expand;


import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.DataList;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ZenExpansion("any[]")
@ZenRegister
public class ExpandArray {

    @ZenMethod
    public static <T> T[] add(T[] array, T any) {
        List<T> list = new ArrayList<>(Arrays.asList(array));
        list.add(any);
        return list.toArray(Arrays.copyOf(array, list.size()));
    }
}


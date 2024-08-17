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
    public <T> T[] add(T[] array, T any) {
        List<T> list = Arrays.asList(array);
        list.add(any);
        array = list.toArray(array);
        return array;
    }
}

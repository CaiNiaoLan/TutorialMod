package com.github.cainaiolan.item;

import com.github.cainaiolan.TutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    //延迟注册
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(TutorialMod.MODID);
    //bismuth是物品在代码这的字段
    public static final DeferredItem<Item> BISMUTH=ITEMS.register("bismuth",()->new Item(new Item.Properties()));
    //raw_bismuth是物品在代码这的字段
    public static final DeferredItem<Item> RAW_BISMUTH=ITEMS.register("raw_bismuth",()->new Item(new Item.Properties()));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}

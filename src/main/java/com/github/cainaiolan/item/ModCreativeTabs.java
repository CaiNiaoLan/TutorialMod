package com.github.cainaiolan.item;

import com.github.cainaiolan.TutorialMod;
import com.github.cainaiolan.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB= DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MODID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB=CREATIVE_MODE_TAB.register("bismuth_items_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.tutorialmod.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //放入要展示的物品
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB=CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            ()-> CreativeModeTab.builder().icon(()->new ItemStack(ModBlocks.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MODID,"bismuth_items_tab"))
                    .title(Component.translatable("creativetab.tutorialmod.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //放入要展示的方块
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

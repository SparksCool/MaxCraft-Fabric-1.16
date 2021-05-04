package net.sparks.maxcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sparks.maxcraft.potions.genericPotion;

public class MaxCraft implements ModInitializer {

	public static final Block MONEY = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5f));
	public static final Item DOLLAR = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final genericPotion SKOOMA = new genericPotion(new FabricItemSettings().group(ItemGroup.MISC));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		System.out.println("Maxcraft is initializing!");
		Registry.register(Registry.BLOCK, new Identifier("maxcraft","money_block"), MONEY);
		Registry.register(Registry.ITEM, new Identifier("maxcraft","money_block"), new BlockItem(MONEY, new FabricItemSettings().group(ItemGroup.MISC)));
		Registry.register(Registry.ITEM, new Identifier("maxcraft","money_item"), DOLLAR);
		Registry.register(Registry.ITEM, new Identifier("maxcraft","skooma_potion"), SKOOMA);


		System.out.println("Maxcraft has intialized!");
	}
}

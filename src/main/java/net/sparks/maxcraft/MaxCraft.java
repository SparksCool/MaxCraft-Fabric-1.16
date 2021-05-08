package net.sparks.maxcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sparks.maxcraft.potions.genericPotion;
import net.sparks.maxcraft.block.*;

public class MaxCraft implements ModInitializer {


	//registering blocks
	public static final Block MONEY = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5f).sounds(BlockSoundGroup.WOOL));
	public static final Block SCRATE = new Block(FabricBlockSettings.of(Material.WOOL).strength(0.5f).sounds(BlockSoundGroup.SCAFFOLDING));
	public static final machineBlock DISTIL = (machineBlock) new Block(FabricBlockSettings.of(Material.WOOL).strength(0.7f).sounds(BlockSoundGroup.METAL));
	//registering items
	public static final Item DOLLAR = new Item(new FabricItemSettings());
	public static final Item MSUGAR = new Item(new FabricItemSettings());
	//registering potions
	public static final genericPotion SKOOMA = new genericPotion(new Item.Settings().group(ItemGroup.FOOD).maxCount(128).food(new FoodComponent.Builder()
																.saturationModifier(1.0f).hunger(8).alwaysEdible()
																.statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*30, 2), 1).build()));
	
	// making a cool menu and tea
	public static final ItemGroup MAX_CRAFT = FabricItemGroupBuilder.create(new Identifier("maxcraft","menu")).icon(() -> new ItemStack(MONEY))
																			.appendItems(stacks -> {
																				stacks.add(new ItemStack(MONEY));
																				stacks.add(new ItemStack(SCRATE));
																				stacks.add(new ItemStack(DISTIL));
																				stacks.add(new ItemStack(DOLLAR));
																				stacks.add(new ItemStack(MSUGAR));
																				stacks.add(new ItemStack(SKOOMA));

																			}).build();


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		System.out.println("Maxcraft is initializing!");
		System.out.println("Maxcraft is initializing Blocks!");
		Registry.register(Registry.BLOCK, new Identifier("maxcraft","money_block"), MONEY);
		Registry.register(Registry.BLOCK, new Identifier("maxcraft","skooma_block"), SCRATE);
		Registry.register(Registry.BLOCK, new Identifier("maxcraft","distil_block"), DISTIL);
		System.out.println("Maxcraft is initializing items!");
		Registry.register(Registry.ITEM, new Identifier("maxcraft","money_block"), new BlockItem(MONEY, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("maxcraft","skooma_block"), new BlockItem(SCRATE, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("maxcraft","distil_block"), new BlockItem(DISTIL, new FabricItemSettings()));
		Registry.register(Registry.ITEM, new Identifier("maxcraft","money_item"), DOLLAR);
		Registry.register(Registry.ITEM, new Identifier("maxcraft","skooma_potion"), SKOOMA);
		Registry.register(Registry.ITEM, new Identifier("maxcraft","skooma_sugar"), MSUGAR);


		System.out.println("Maxcraft has intialized!");
	}
}

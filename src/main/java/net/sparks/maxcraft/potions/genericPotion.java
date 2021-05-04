package net.sparks.maxcraft.potions;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class genericPotion extends Item {
    public StatusEffect Effect;
    public genericPotion(Settings settings, StatusEffect SEI){
        super(settings);
        Effect = SEI;
        
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
    @Override
    public SoundEvent getEatSound() {
        return getDrinkSound();
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        user.addStatusEffect(new StatusEffectInstance(Effect, 200, 3));
        playerEntity.addExperience(2);

        return stack;
    }
}
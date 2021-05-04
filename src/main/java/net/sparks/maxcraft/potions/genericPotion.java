package net.sparks.maxcraft.potions;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.UseAction;

public class genericPotion extends Item {
    public StatusEffect Effect;
    public genericPotion(Settings settings){
        super(settings);
        
    }
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
    @Override
    public SoundEvent getEatSound() {
        return getDrinkSound();
    }

}
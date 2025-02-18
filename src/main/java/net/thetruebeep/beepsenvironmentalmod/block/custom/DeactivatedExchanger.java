package net.thetruebeep.beepsenvironmentalmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.thetruebeep.beepsenvironmentalmod.block.ModBlocks;
import net.thetruebeep.beepsenvironmentalmod.item.ModItems;

import java.util.List;

public class DeactivatedExchanger extends Block {
    public DeactivatedExchanger(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1f,0.5f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity){
            if(itemEntity.getItem().getItem() == ModBlocks.INFECTED_ROSE_WOOD_LEAF.get().asItem()) {
                level.playSound(entity, pos, SoundEvents.PLAYER_TELEPORT, SoundSource.BLOCKS, 1f,0.5f);
                itemEntity.setItem(new ItemStack(ModItems.INFESTED_STRING.get(), itemEntity.getItem().getCount()*2));
            }
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.beepsenvironmentalmod.deactivated_exchanger.tooltip"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}

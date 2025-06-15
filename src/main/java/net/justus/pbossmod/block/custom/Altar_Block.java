package net.justus.pbossmod.block.custom;

import net.justus.pbossmod.entity.ModEntities;
import net.justus.pbossmod.entity.client.PiglinBoss;
import net.justus.pbossmod.entity.custom.PiglinBossEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Altar_Block extends Block {
    public Altar_Block(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide) {
            PiglinBossEntity piglinBoss = ModEntities.PIGLINBOSS.get().create(pLevel);
            if (piglinBoss != null) {
                piglinBoss.moveTo(pPos.getX() + 0.5, pPos.getY() + 1, pPos.getZ() + 0.5, 0, 0);
                pLevel.addFreshEntity(piglinBoss);
                pLevel.removeBlock(pPos, false);
            }
        }

        return InteractionResult.SUCCESS;
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.pbossmod.altar_block.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
package net.pl3x.fabric.purpurclient.mixin.seat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.world.World;
import net.pl3x.fabric.purpurclient.PurpurClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CatEntity.class)
public abstract class MixinCat extends LivingEntity {
    public MixinCat(EntityType<? extends CatEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public double getMountedHeightOffset() {
        return (double) getHeight() * PurpurClient.CONFIG.seatOffsets.cat.y;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        PurpurClient.updatePassengerPosition2(this, passenger, PurpurClient.CONFIG.seatOffsets.cat, bodyYaw);
    }
}

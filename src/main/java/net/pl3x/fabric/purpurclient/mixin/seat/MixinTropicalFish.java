package net.pl3x.fabric.purpurclient.mixin.seat;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.world.World;
import net.pl3x.fabric.purpurclient.PurpurClient;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TropicalFishEntity.class)
public abstract class MixinTropicalFish extends LivingEntity {
    public MixinTropicalFish(EntityType<? extends TropicalFishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public double getMountedHeightOffset() {
        return (double) getHeight() * 0.7D;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        double x = -0.1D;
        double y = getMountedHeightOffset() + passenger.getHeightOffset();
        PurpurClient.updatePassengerPosition(this, passenger, x, y, 0.0D, bodyYaw);
    }
}

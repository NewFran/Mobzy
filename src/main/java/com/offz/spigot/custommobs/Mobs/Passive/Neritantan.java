package com.offz.spigot.custommobs.Mobs.Passive;

import com.offz.spigot.custommobs.Builders.MobBuilder;
import com.offz.spigot.custommobs.Mobs.Behaviours.HitBehaviour;
import com.offz.spigot.custommobs.Mobs.Types.PassiveMob;
import com.offz.spigot.custommobs.Pathfinders.PathfinderGoalTemptPitchLock;
import com.offz.spigot.custommobs.Pathfinders.PathfinderGoalWalkingAnimation;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import net.minecraft.server.v1_13_R2.EntityAgeable;
import net.minecraft.server.v1_13_R2.Item;
import net.minecraft.server.v1_13_R2.Items;
import net.minecraft.server.v1_13_R2.World;

public class Neritantan extends PassiveMob implements HitBehaviour {
    static MobBuilder builder = new MobBuilder("Neritantan", 2)
            .setTemptItems(new Item[]{Items.CARROT, Items.POTATO, Items.BEETROOT})
            .setDisguiseAs(DisguiseType.ARMOR_STAND);

    public Neritantan(World world) {
        super(world, builder);
    }

    @Override
    public void createPathfinders() {
        super.createPathfinders();
        this.goalSelector.a(0, new PathfinderGoalWalkingAnimation(this, builder.getModelID()));
        this.goalSelector.a(4, new PathfinderGoalTemptPitchLock(this, 1.2D, false, builder.getTemptItems()));
    }

    public PassiveMob createChild(EntityAgeable entityageable) {
        return new Neritantan(this.world);
    }
}

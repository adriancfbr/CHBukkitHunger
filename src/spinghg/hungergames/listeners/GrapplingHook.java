package spinghg.hungergames.listeners;

import net.minecraft.server.v1_7_R4.EntityFishingHook;
import net.minecraft.server.v1_7_R4.EntityHuman;
import net.minecraft.server.v1_7_R4.EntitySnowball;
import net.minecraft.server.v1_7_R4.PacketPlayOutEntityDestroy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftSnowball;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;

public class GrapplingHook extends EntityFishingHook
{
  private Snowball sb;
  private EntitySnowball controller;
  public int a;
  public EntityHuman owner;
  public Entity hooked;
  public boolean lastControllerDead;
  public boolean isHooked;

  public GrapplingHook(org.bukkit.World world, EntityHuman entityhuman)
  {
    super(((CraftWorld)world).getHandle(), entityhuman);
    this.owner = entityhuman;
  }

  protected void c() {
  }

  public void h() {
    if ((!this.lastControllerDead) && (this.controller.dead)) {
      ((Player)this.owner.getBukkitEntity()).sendMessage(ChatColor.GREEN + 
        "Grappler Fiscado!");
      if ((this.hooked != null) && 
        ((this.hooked instanceof Player)))
        ((Player)this.hooked).sendMessage("§f§l[§a§lPlanetacraft§f§l_§e§lBR§f§l] §4Um Grappler fisgou em voce!");
    }
    this.lastControllerDead = this.controller.dead;
    for (Entity entity : this.controller.world.getWorld().getEntities()) {
      if (((entity instanceof Firework)) || 
        (entity.getEntityId() == getBukkitEntity().getEntityId()) || 
        (entity.getEntityId() == this.owner.getBukkitEntity()
        .getEntityId())) continue;
      if (entity.getEntityId() == this.controller
        .getBukkitEntity().getEntityId())
        continue;
      if (entity.getLocation().distance(
        this.controller.getBukkitEntity().getLocation()) >= 2.0D) { if (!(entity instanceof Player)) {
          continue;
        }
        if (((Player)entity)
          .getEyeLocation().distance(
          this.controller.getBukkitEntity()
          .getLocation()) >= 2.0D) continue; } else {
        this.controller.die();
        this.hooked = entity;
        this.isHooked = true;
        this.locX = entity.getLocation().getX();
        this.locY = entity.getLocation().getY();
        this.locZ = entity.getLocation().getZ();
        this.motX = 0.0D;
        this.motY = 0.04D;
        this.motZ = 0.0D;
      }
    }
    try {
      this.locX = this.hooked.getLocation().getX();
      this.locY = this.hooked.getLocation().getY();
      this.locZ = this.hooked.getLocation().getZ();
      this.motX = 0.0D;
      this.motY = 0.04D;
      this.motZ = 0.0D;
      this.isHooked = true;
    } catch (Exception e) {
      if (this.controller.dead) {
        this.isHooked = true;
      }
      this.locX = this.controller.locX;
      this.locY = this.controller.locY;
      this.locZ = this.controller.locZ;
    }
  }

  public void die() {
  }

  public void remove() {
    super.die();
  }

  @SuppressWarnings("deprecation")
public void spawn(Location location) {
    this.sb = ((Snowball)this.owner.getBukkitEntity().launchProjectile(
      Snowball.class));
    this.controller = ((CraftSnowball)this.sb).getHandle();

    PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(
      new int[] { this.controller.getId() });
    for (Player p : Bukkit.getOnlinePlayers()) {
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }
    ((CraftWorld)location.getWorld()).getHandle().addEntity(this);
  }

  public boolean isHooked() {
    return this.isHooked;
  }

  public void setHookedEntity(Entity damaged) {
    this.hooked = damaged;
  }
}
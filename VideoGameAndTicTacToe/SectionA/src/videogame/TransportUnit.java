package videogame;

import java.util.HashSet;
import java.util.Set;

public class TransportUnit extends Entity {

  private Set<Entity> containedUnits;
  public static int DAMAGE_ABSORBED = 2;

  public TransportUnit(String name, int lifePoints) {
    super(name, lifePoints);
    containedUnits = new HashSet<>();
  }

  public void add(Entity e) {
    containedUnits.add(e);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    int retVal = damageOccurred(damageAmount);
    for (Entity e : containedUnits) {
      retVal += e.propagateDamage(damageAmount/DAMAGE_ABSORBED);
    }
    return retVal;
  }

  @Override
  public int minimumStrikeToDestroy() {
    int minDamage = lifePoints;
    for (Entity e : containedUnits){
      minDamage = Integer.max(minDamage, e.minimumStrikeToDestroy() * DAMAGE_ABSORBED);
    }
    return minDamage;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    sb.append(" transporting : ");
    sb.append(containedUnits.toString());
    return sb.toString();
  }
}

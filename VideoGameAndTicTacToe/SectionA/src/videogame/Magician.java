package videogame;

public class Magician extends Entity implements SpellCaster {

  public static int MULTIPLE_OF_STRENGTH = 2;
  public Magician(String name, int lifePoints) {
    super(name, lifePoints);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    int retVal = damageOccurred(damageAmount);
    return retVal;
  }

  @Override
  public int minimumStrikeToDestroy() {
    return lifePoints;
  }

  @Override
  public int getStrength() {
    return lifePoints * MULTIPLE_OF_STRENGTH;
  }
}

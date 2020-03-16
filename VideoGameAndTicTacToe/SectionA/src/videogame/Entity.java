package videogame;

public abstract class Entity {
	
	protected String name;
	protected int lifePoints = 0;

	public Entity(String name, int lifePoints) {
		assert(lifePoints >= 0);
		this.name = name;
		this.lifePoints = lifePoints;
	}

	public final boolean isAlive() {
		/* TODO: Implement as part of Section A Question 2 */
		return lifePoints > 0;
	}
	
	public final int applySpell(SpellCaster spellCaster) {
		/* TODO: Implement as part of Section A Question 2 */
		return propagateDamage(spellCaster.getStrength());
	}
	
	protected abstract int propagateDamage(int damageAmount);

	public abstract int minimumStrikeToDestroy();

	protected int damageOccurred(int damage){
		assert damage >= 0;
		int retVal = lifePoints;
		if (lifePoints - damage > 0) {
			retVal = damage;
		}
		lifePoints -= retVal;
		return retVal;

	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append('(');
		sb.append(lifePoints);
		sb.append(')');
		return sb.toString();
	}
}

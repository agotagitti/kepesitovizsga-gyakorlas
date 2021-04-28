package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {

    public AxeWarrior(Point point, Random random) {
        super(point, random);
    }

    private int getActualSecondaryDamage() {
        return getRandom().nextInt(getActualPrimaryDamage() * 2) + 1;
    }

    @Override
    public void secondaryAttack(Character enemy) {
         if (getPosition().distance(enemy.getPosition()) > 2) {
             hit(enemy, getActualSecondaryDamage());
         }
    }

}

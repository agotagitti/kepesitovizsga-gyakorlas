package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {

    private int numberOfArrow;


    public Archer(Point position, Random random) {
        super(position, random);
        numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    private int getActualSecondaryAttack() {
        return getRandom().nextInt(6);
    }

    private void shootingArrow(Character enemy) {
        numberOfArrow--;
        hit(enemy, getActualSecondaryAttack());
    }

    @Override
    public void secondaryAttack(Character enemy) {
        shootingArrow(enemy);
    }
}

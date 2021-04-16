package hu.nive.ujratervezes.kepesitovizsga.trees;

public abstract class Tree {

    protected int leaves;
    protected Fruit fruit;
    private int leafGrowRate;
    private int fruitGrowRate;
    protected int weightOfFruit;
    private final int leavesPerBirdNest = 200;

    protected Tree(int leaves, Fruit fruit, int leafGrowRate, int fruitGrowRate) {
        this.leaves = leaves;
        this.fruit = fruit;
        this.leafGrowRate = leafGrowRate;
        this.fruitGrowRate = fruitGrowRate;
    }

    public int getLeaves() {
        return leaves;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int growLeaves(int numberOfSunnyDays){
        leaves += numberOfSunnyDays * leafGrowRate;
        return leaves;
    }

    public int hostBirdNest() {
        return leaves / leavesPerBirdNest;
    }

    public void ripenFruit(int numberOfSunnyDays) {
        growLeaves(numberOfSunnyDays);
        weightOfFruit = leaves / fruitGrowRate;
    }
}

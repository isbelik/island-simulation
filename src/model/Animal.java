package model;

public abstract class Animal extends Organism {
    private final int speed;
    private double satiety;
    private static final double MIN_SATIETY = 0.0;
    private final double maxSatiety;

    public Animal(EntityType type) {
        super(type, type.getWeight(), type.getMaxPerCell());
        this.speed = type.getSpeed();
        this.satiety = type.getMaxSatiety();
        this.maxSatiety = type.getMaxSatiety();
    }

    public int getSpeed() {
        return speed;
    }

    public double getSatiety() {
        return satiety;
    }

    public double getMaxSatiety() {
        return maxSatiety;
    }

    protected void changeSatiety(double delta) {
        satiety = Math.min(maxSatiety, Math.max(MIN_SATIETY, satiety + delta));
    }

    protected void spendSatiety(double amount) {
        changeSatiety(-amount);
    }

    protected void gainSatiety(double amount) {
        changeSatiety(+amount);
    }

    protected boolean isDead() {
        return getSatiety() <= 0;
    }
}

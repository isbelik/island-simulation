package model;

import factory.OrganismFactories;
import factory.OrganismFactory;
import map.Cell;
import map.Island;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {
    private static final double MIN_SATIETY = 0.0;
    private static final double SATURATION_COST_FACTOR = 0.05;
    private final int speed;
    private volatile double satiety;
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

    protected void decreaseSatietyForAction() {
        spendSatiety(getMaxSatiety() * SATURATION_COST_FACTOR);
    }


    public Cell chooseDirectionOfMovement(Island island, Cell fromCell) {
        int maxStepDistance = getSpeed();

        int stepX = ThreadLocalRandom.current().nextInt(maxStepDistance + 1);
        int stepY = ThreadLocalRandom.current().nextInt(maxStepDistance + 1);

        if (ThreadLocalRandom.current().nextBoolean()) stepX = -stepX;
        if (ThreadLocalRandom.current().nextBoolean()) stepY = -stepY;

        int targetX = fromCell.getX() + stepX;
        int targetY = fromCell.getY() + stepY;

        targetX = Math.max(0, Math.min(island.getWidth() - 1, targetX));
        targetY = Math.max(0, Math.min(island.getHeight() - 1, targetY));

        return island.getCell(targetX, targetY);
    }

    public void eat(Cell cell) {
        for (EntityType preyType : EntityType.values()) {
            int eatingProbability = EatingTable.getEatingProbability(getType(), preyType);

            if (eatingProbability > 0 && cell.getOrganismCount(preyType) > 0) {
                decreaseSatietyForAction();

                if (ThreadLocalRandom.current().nextInt() < eatingProbability) {
                    List<Organism> preyList = cell.getOrganisms(preyType);
                    Organism prey = preyList.get(0);
                    cell.removeOrganism(prey);
                    gainSatiety(prey.getWeight());
                    break;
                }
            }
        }
    }

    public void reproduce(Cell cell) {
        if (cell.canAddOrganism(getType())) {
            int sameTypeCount = cell.getOrganismCount(getType());
            if (sameTypeCount > 2) {
                double reproductionChance = getType().getReproductionProbability();
                if (ThreadLocalRandom.current().nextDouble() < reproductionChance) {
                    OrganismFactory factory = OrganismFactories.getFactoryFor(getType());
                    cell.addOrganism(factory.createOrganism());
                }
            }
        }
    }

    public boolean isDead() {
        return getSatiety() <= 0;
    }
}

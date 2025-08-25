package util;

import factory.OrganismFactories;
import factory.OrganismFactory;
import map.Cell;
import map.Island;
import model.EntityType;
import model.Organism;

import java.util.Random;

public final class PopulationInitializer {
    private static final Random RANDOM = new Random();

    private PopulationInitializer() {
    }

    public static void initializeBasicPopulation(Island island) {
        int islandSize = island.getWidth() * island.getHeight();

        for (EntityType type : EntityType.values()) {
            int count = (int) (islandSize * type.getReproductionProbability() * RANDOM.nextInt(islandSize));

            OrganismFactory factory = OrganismFactories.getFactoryFor(type);
            placeOrganismsRandomly(island, factory, count);
        }
    }


    private static void placeOrganismsRandomly(Island island, OrganismFactory factory, int count) {
        int width = island.getWidth();
        int height = island.getHeight();

        for (int i = 0; i < count; i++) {
            Organism organism = factory.createOrganism();
            EntityType type = organism.getType();

            for (int j = 0; j < count; j++) {
                int x = RANDOM.nextInt(width);
                int y = RANDOM.nextInt(height);
                Cell cell = island.getCell(x, y);
                if (cell.canAddOrganism(type)) {
                    cell.addOrganism(organism);
                    break;
                }
            }
        }
    }
}

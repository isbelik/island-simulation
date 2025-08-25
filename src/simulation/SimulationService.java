package simulation;

import config.IslandConfig;
import map.Cell;
import map.Island;
import model.Animal;
import model.EntityType;
import model.Organism;
import model.Plant;
import util.PopulationInitializer;
import util.StatisticPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimulationService {
    private final IslandConfig config;
    private final Island island;
    private final ExecutorService cellExecutor;

    public SimulationService(IslandConfig config) {
        this.config = config;
        this.island = new Island(config.getWidth(), config.getHeight());
        this.cellExecutor = Executors.newFixedThreadPool(4);

        PopulationInitializer.initializeBasicPopulation(island);

        System.out.println("=== Initial Population ===");
        StatisticPrinter.printPopulation(island);
        StatisticPrinter.printIslandGrid(island);
    }

    public void moveOrganism() {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Cell currentCell = island.getCell(x, y);

                List<Organism> listLocationOfOrganisms = new ArrayList<>();
                for (EntityType type : EntityType.values()) {
                    listLocationOfOrganisms.addAll(currentCell.getOrganisms(type));
                }

                for (Organism organism : listLocationOfOrganisms) {
                    if (organism instanceof Animal animal) {
                        Cell targetCell = animal.chooseDirectionOfMovement(island, currentCell);
                        if (targetCell.canAddOrganism(animal.getType())) {
                            currentCell.removeOrganism(animal);
                            targetCell.addOrganism(animal);
                        }
                    }
                }
            }
        }
    }

    public void processCell(int x, int y) {
        Cell currentCell = island.getCell(x, y);

        List<Organism> listLocationOfOrganisms = new ArrayList<>();
        for (EntityType type : EntityType.values()) {
            listLocationOfOrganisms.addAll(currentCell.getOrganisms(type));
        }

        for (Organism organism : listLocationOfOrganisms) {
            if (organism instanceof Animal animal) {
                animal.eat(currentCell);
                animal.reproduce(currentCell);

                if (animal.isDead()) {
                    currentCell.removeOrganism(animal);
                }
            } else if (organism instanceof Plant plant) {
                plant.grow(currentCell);
            }

        }
    }

    public void processLifecycle() {
        List<Future<?>> futures = new ArrayList<>();

        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                final int finalX = x;
                final int finalY = y;

                Future<?> future = cellExecutor.submit(() -> {
                    processCell(finalX, finalY);
                });
                futures.add(future);
            }
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        moveOrganism();
    }

    public void shutdown() {
        cellExecutor.shutdown();
    }

    public void printStatistics() {
        System.out.println("=== Statistics ===");
        StatisticPrinter.printPopulation(island);
        StatisticPrinter.printIslandGrid(island);
    }
}

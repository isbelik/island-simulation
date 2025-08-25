package model;

import java.util.HashMap;
import java.util.Map;

public class EatingTable {
    private static final Map<EntityType, Map<EntityType, Integer>> eatingProbabilities = new HashMap<>();

    static {
        Map<EntityType, Integer> eatingProbabilitiesByWolf = new HashMap<>();
        eatingProbabilitiesByWolf.put(EntityType.HORSE, 10);
        eatingProbabilitiesByWolf.put(EntityType.DEER, 15);
        eatingProbabilitiesByWolf.put(EntityType.RABBIT, 60);
        eatingProbabilitiesByWolf.put(EntityType.MOUSE, 80);
        eatingProbabilitiesByWolf.put(EntityType.GOAT, 60);
        eatingProbabilitiesByWolf.put(EntityType.SHEEP, 70);
        eatingProbabilitiesByWolf.put(EntityType.BOAR, 15);
        eatingProbabilitiesByWolf.put(EntityType.BUFFALO, 10);
        eatingProbabilitiesByWolf.put(EntityType.DUCK, 40);
        eatingProbabilities.put(EntityType.WOLF, eatingProbabilitiesByWolf);

        Map<EntityType, Integer> eatingProbabilitiesByBoa = new HashMap<>();
        eatingProbabilitiesByBoa.put(EntityType.FOX, 15);
        eatingProbabilitiesByBoa.put(EntityType.RABBIT, 20);
        eatingProbabilitiesByBoa.put(EntityType.MOUSE, 40);
        eatingProbabilitiesByBoa.put(EntityType.DUCK, 10);
        eatingProbabilities.put(EntityType.BOA, eatingProbabilitiesByBoa);

        Map<EntityType, Integer> eatingProbabilitiesByFox = new HashMap<>();
        eatingProbabilitiesByFox.put(EntityType.RABBIT, 70);
        eatingProbabilitiesByFox.put(EntityType.MOUSE, 90);
        eatingProbabilitiesByFox.put(EntityType.DUCK, 60);
        eatingProbabilitiesByFox.put(EntityType.CATERPILLAR, 40);
        eatingProbabilities.put(EntityType.FOX, eatingProbabilitiesByFox);

        Map<EntityType, Integer> eatingProbabilitiesByBear = new HashMap<>();
        eatingProbabilitiesByBear.put(EntityType.BOA, 80);
        eatingProbabilitiesByBear.put(EntityType.HORSE, 40);
        eatingProbabilitiesByBear.put(EntityType.DEER, 80);
        eatingProbabilitiesByBear.put(EntityType.RABBIT, 80);
        eatingProbabilitiesByBear.put(EntityType.MOUSE, 90);
        eatingProbabilitiesByBear.put(EntityType.GOAT, 70);
        eatingProbabilitiesByBear.put(EntityType.SHEEP, 70);
        eatingProbabilitiesByBear.put(EntityType.BOAR, 50);
        eatingProbabilitiesByBear.put(EntityType.BUFFALO, 20);
        eatingProbabilitiesByBear.put(EntityType.DUCK, 10);
        eatingProbabilities.put(EntityType.BEAR, eatingProbabilitiesByBear);

        Map<EntityType, Integer> eatingProbabilitiesByEagle = new HashMap<>();
        eatingProbabilitiesByEagle.put(EntityType.FOX, 10);
        eatingProbabilitiesByEagle.put(EntityType.RABBIT, 90);
        eatingProbabilitiesByEagle.put(EntityType.MOUSE, 90);
        eatingProbabilitiesByEagle.put(EntityType.DUCK, 80);
        eatingProbabilities.put(EntityType.EAGLE, eatingProbabilitiesByEagle);

        Map<EntityType, Integer> eatingProbabilitiesByHorse = new HashMap<>();
        eatingProbabilitiesByHorse.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.HORSE, eatingProbabilitiesByHorse);

        Map<EntityType, Integer> eatingProbabilitiesByDeer = new HashMap<>();
        eatingProbabilitiesByDeer.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.DEER, eatingProbabilitiesByDeer);

        Map<EntityType, Integer> eatingProbabilitiesByRabbit = new HashMap<>();
        eatingProbabilitiesByRabbit.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.RABBIT, eatingProbabilitiesByRabbit);

        Map<EntityType, Integer> eatingProbabilitiesByMouse = new HashMap<>();
        eatingProbabilitiesByMouse.put(EntityType.GRASS, 100);
        eatingProbabilitiesByMouse.put(EntityType.CATERPILLAR, 90);
        eatingProbabilities.put(EntityType.MOUSE, eatingProbabilitiesByMouse);

        Map<EntityType, Integer> eatingProbabilitiesByGoat = new HashMap<>();
        eatingProbabilitiesByGoat.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.GOAT, eatingProbabilitiesByGoat);

        Map<EntityType, Integer> eatingProbabilitiesBySheep = new HashMap<>();
        eatingProbabilitiesBySheep.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.SHEEP, eatingProbabilitiesBySheep);

        Map<EntityType, Integer> eatingProbabilitiesByBoar = new HashMap<>();
        eatingProbabilitiesByBoar.put(EntityType.MOUSE, 50);
        eatingProbabilitiesByBoar.put(EntityType.CATERPILLAR, 90);
        eatingProbabilitiesByBoar.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.BOAR, eatingProbabilitiesByBoar);

        Map<EntityType, Integer> eatingProbabilitiesByBuffalo = new HashMap<>();
        eatingProbabilitiesByBuffalo.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.BUFFALO, eatingProbabilitiesByBuffalo);

        Map<EntityType, Integer> eatingProbabilitiesByDuck = new HashMap<>();
        eatingProbabilitiesByDuck.put(EntityType.CATERPILLAR, 90);
        eatingProbabilitiesByDuck.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.DUCK, eatingProbabilitiesByDuck);

        Map<EntityType, Integer> eatingProbabilitiesByCaterpillar = new HashMap<>();
        eatingProbabilitiesByCaterpillar.put(EntityType.GRASS, 100);
        eatingProbabilities.put(EntityType.CATERPILLAR, eatingProbabilitiesByCaterpillar);
    }
    
    public static int getEatingProbability(EntityType predator, EntityType prey) {
        Map<EntityType, Integer> foodForPredator = eatingProbabilities.get(predator);
        return foodForPredator.getOrDefault(prey, 0);
    }
}

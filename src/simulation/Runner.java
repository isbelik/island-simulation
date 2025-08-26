package simulation;

import config.IslandConfig;
import map.Island;

public class Runner {
    public static void main(String[] args) {
        IslandConfig config = new IslandConfig(10, 5);
        SimulationService simulationService = new SimulationService(config);

        SimulationScheduler scheduler = new SimulationScheduler(simulationService);
        scheduler.startSimulation();


    }
}

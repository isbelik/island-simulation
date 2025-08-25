package simulation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationScheduler {
    private final ScheduledExecutorService executorService;
    private final SimulationService simulationService;

    public SimulationScheduler(SimulationService simulationService) {
        this.executorService = Executors.newScheduledThreadPool(3);;
        this.simulationService = simulationService;
    }

    public void startSimulation() {
        executorService.scheduleAtFixedRate(
                simulationService::processLifecycle,
                0, 1, TimeUnit.SECONDS
        );

        executorService.scheduleAtFixedRate(
                simulationService::printStatistics,
                0, 3, TimeUnit.SECONDS
        );
    }

    public void stop() {
        executorService.shutdown();
    }
}

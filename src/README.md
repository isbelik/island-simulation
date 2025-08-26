# Island Ecosystem Simulation

A simple, console-based ecosystem simulation written in Java. The island is a 2D grid of cells populated by animals and plants. Each simulation tick processes eating, reproduction, growth, movement, and statistics printing.

### Key Features
- **Discrete-time simulation** with a scheduler running lifecycle and stats at fixed intervals.
- **Configurable grid size** via `IslandConfig`.
- **Multiple organism types** (predators, herbivores, plants) with per-type limits and properties.
- **Eating matrix** that determines predator–prey probabilities.
- **Reproduction and growth** based on probabilistic rules.
- **Concurrent cell processing** using a thread pool for performance.
- **Console statistics** including counts per species and a grid with emojis.

### Tech Stack
- **Language**: Java 17+ (plain Java, no frameworks)
- **Concurrency**: `ExecutorService`, `ScheduledExecutorService`

### How It Works (Architecture)
- `simulation.SimulationScheduler` runs two periodic tasks:
  - `SimulationService.processLifecycle()` every second: per-cell eating, reproduction/growth, then movement.
  - `SimulationService.printStatistics()` every 3 seconds: totals per species and island grid snapshot.
- `simulation.SimulationService` owns the island, initializes population, processes cells in parallel, and moves animals.
- `map.Island` and `map.Cell` model the grid and cell-local organism lists with per-type capacity checks.
- `model.*` defines the domain: `Organism`, `Animal`, `Plant`, `Predator`, `Herbivore`, `EntityType`, `EatingTable`.
- `factory.*` creates organisms per `EntityType` (factory pattern).
- `util.PopulationInitializer` seeds the island; `util.StatisticPrinter` prints counts and the emoji grid.

### Project Structure
```
island/
  Island/
    src/
      config/              # Island configuration (width/height)
      factory/             # Organism factories by type
      map/                 # Island and Cell models
      model/               # Core domain types and behaviors
        animals/           # Concrete animal implementations
        plants/            # Concrete plant implementations
      simulation/          # Runner, scheduler, and simulation service
      util/                # Population seeding and statistics
```

### Configuration
- Grid size is set in `simulation.Runner` via:
```java
IslandConfig config = new IslandConfig(10, 5);
```
Adjust width/height as needed.

### Simulation Loop
- For each tick:
  - Process each cell (in parallel): animals eat and reproduce; plants grow; dead animals are removed.
  - Move animals to neighboring cells within their speed, respecting per-cell capacity by type.

### Extending
- **Add a species**: create a factory in `factory/`, add a concrete class under `model/animals` or `model/plants`, and register in `EntityType` and `OrganismFactories`. Update `EatingTable` if it interacts with others.
- **Change rules**: tweak probabilities, capacities, speeds, and weights in `EntityType`, and probabilities in `EatingTable`.

### Concurrency Notes
- Cells use synchronized `addOrganism`/`removeOrganism` to protect per-cell lists during parallel processing.
- Lifecycle work is fanned out per cell using a fixed-size thread pool, then animals move after all cells are processed.


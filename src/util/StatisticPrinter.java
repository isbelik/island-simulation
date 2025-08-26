package util;

import map.Cell;
import map.Island;
import model.EntityType;

public class StatisticPrinter {
    private StatisticPrinter() {}

    public static void printPopulation(Island island) {
        for (EntityType type : EntityType.values()) {
            int count = 0;
            for (int y = 0; y < island.getHeight(); y++) {
                for (int x = 0; x < island.getWidth(); x++) {
                    Cell cell = island.getCell(x, y);
                    count += cell.getOrganismCount(type);
                }
            }
            System.out.printf("%S: %d%n", type.getName(), count);
        }
        System.out.println("----------------------------");
    }

    public static void printIslandGrid(Island island) {
        for (int y = 0; y < island.getHeight(); y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < island.getWidth(); x++) {
                Cell cell = island.getCell(x, y);

                int wolf = cell.getOrganismCount(EntityType.WOLF);
                int boa = cell.getOrganismCount(EntityType.BOA);
                int fox = cell.getOrganismCount(EntityType.FOX);
                int bear = cell.getOrganismCount(EntityType.BEAR);
                int eagle = cell.getOrganismCount(EntityType.EAGLE);
                int horse = cell.getOrganismCount(EntityType.HORSE);
                int deer = cell.getOrganismCount(EntityType.DEER);
                int rabbit = cell.getOrganismCount(EntityType.RABBIT);
                int mouse = cell.getOrganismCount(EntityType.MOUSE);
                int goat = cell.getOrganismCount(EntityType.GOAT);
                int sheep = cell.getOrganismCount(EntityType.SHEEP);
                int boar = cell.getOrganismCount(EntityType.BOAR);
                int buffalo = cell.getOrganismCount(EntityType.BUFFALO);
                int duck = cell.getOrganismCount(EntityType.DUCK);
                int caterpillar = cell.getOrganismCount(EntityType.CATERPILLAR);
                int grass = cell.getOrganismCount(EntityType.GRASS);

                StringBuilder cellContent = new StringBuilder();

                if (wolf > 0) cellContent.append("🐺").append(wolf);
                if (boa > 0) cellContent.append("🐍").append(boa);
                if (fox > 0) cellContent.append("🦊").append(fox);
                if (bear > 0) cellContent.append("🐻").append(bear);
                if (eagle > 0) cellContent.append("🦅").append(eagle);
                if (horse > 0) cellContent.append("🐎").append(horse);
                if (deer > 0) cellContent.append("🦌").append(deer);
                if (rabbit > 0) cellContent.append("🐇").append(rabbit);
                if (mouse > 0) cellContent.append("🐁").append(mouse);
                if (goat > 0) cellContent.append("🐐").append(goat);
                if (sheep > 0) cellContent.append("🐑").append(sheep);
                if (boar > 0) cellContent.append("🐗").append(boar);
                if (buffalo > 0) cellContent.append("🐃").append(buffalo);
                if (duck > 0) cellContent.append("🦆").append(duck);
                if (caterpillar > 0) cellContent.append("🐛").append(caterpillar);
                if (grass > 0) cellContent.append("🌱").append(grass);

                if (cellContent.isEmpty()){
                    line.append("[   ]");
                } else {
                    line.append(String.format("[%s]", cellContent));
                }
            }
            System.out.println(line);
        }
        System.out.println("---------------------");
    }
}

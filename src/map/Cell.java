package map;

import model.EntityType;
import model.Organism;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Cell {
    private final int x;
    private final int y;

    private final Map<EntityType, List<Organism>> organisms = new EnumMap<>(EntityType.class);

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;

        for (EntityType type : EntityType.values()) {
            organisms.put(type, new ArrayList<>());
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Organism> getOrganisms(EntityType type) {
        return new ArrayList<>(organisms.get(type));
    }

    public int getOrganismCount(EntityType type) {
        return organisms.get(type).size();
    }

    public boolean canAddOrganism(EntityType type) {
        return getOrganismCount(type) < type.getMaxPerCell();
    }

    public boolean addOrganism(Organism organism) {
        EntityType type = organism.getType();
        if (canAddOrganism(type)) {
            organisms.get(type).add(organism);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeOrganism(Organism organism) {
        EntityType type = organism.getType();
        return organisms.get(type).remove(organism);
    }

}

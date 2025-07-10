package map;

import model.IslandEntity;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<IslandEntity> entityList;

    public Cell() {
        this.entityList = new ArrayList<>();
    }

    public List<IslandEntity> getEntities() {
        return new ArrayList<>(entityList);
    }

    public void addEntity(IslandEntity newEntity) {
        entityList.add(newEntity);
    }

    public void removeEntity(IslandEntity entity) {
        entityList.remove(entity);
    }
}

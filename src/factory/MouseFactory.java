package factory;

import model.Organism;
import model.animals.Mouse;

public class MouseFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Mouse();
    }
}

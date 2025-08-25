package factory;

import model.Organism;
import model.animals.Rabbit;

public class RabbitFactory implements OrganismFactory {
    @Override
    public Organism createOrganism() {
        return new Rabbit();
    }
}

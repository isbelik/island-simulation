package factory;

import model.EntityType;

import java.util.EnumMap;
import java.util.Map;

public final class OrganismFactories {
    private final Map<EntityType, OrganismFactory> FACTORIES = new EnumMap<>(EntityType.class);

    {
        FACTORIES.put(EntityType.WOLF, new WolfFactory());
        FACTORIES.put(EntityType.BOA, new BoaFactory());
        FACTORIES.put(EntityType.FOX, new FoxFactory());
        FACTORIES.put(EntityType.BEAR, new BearFactory());
        FACTORIES.put(EntityType.EAGLE, new EagleFactory());
        FACTORIES.put(EntityType.HORSE, new HorseFactory());
        FACTORIES.put(EntityType.DEER, new DeerFactory());
        FACTORIES.put(EntityType.RABBIT, new RabbitFactory());
        FACTORIES.put(EntityType.MOUSE, new MouseFactory());
        FACTORIES.put(EntityType.GOAT, new GoatFactory());
        FACTORIES.put(EntityType.SHEEP, new SheepFactory());
        FACTORIES.put(EntityType.BOAR, new BoarFactory());
        FACTORIES.put(EntityType.BUFFALO, new BuffaloFactory());
        FACTORIES.put(EntityType.CATERPILLAR, new CaterpillarFactory());
        FACTORIES.put(EntityType.GRASS, new GrassFactory());
    }

    private OrganismFactories() {}

    public OrganismFactory getFactoryFor(EntityType type) {
        return FACTORIES.get(type);
    }
}

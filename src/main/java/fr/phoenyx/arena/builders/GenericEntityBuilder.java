package fr.phoenyx.arena.builders;

import java.time.LocalDateTime;

import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.models.Player;

public abstract class GenericEntityBuilder<E extends GenericEntity> {

    protected abstract E getEntity();

    public GenericEntityBuilder<E> id(Long id) {
        getEntity().setId(id);
        return this;
    }

    public GenericEntityBuilder<E> dateCreation(LocalDateTime dateCreation) {
        getEntity().setDateCreation(dateCreation);
        return this;
    }

    public GenericEntityBuilder<E> dateModification(LocalDateTime dateModification) {
        getEntity().setDateModification(dateModification);
        return this;
    }

    public GenericEntityBuilder<E> modifier(Player modifier) {
        getEntity().setModifier(modifier);
        return this;
    }

    public E build() {
        return getEntity();
    }
}

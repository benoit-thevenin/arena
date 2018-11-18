package fr.phoenyx.arena.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "DATE_CREATION")
    protected LocalDateTime dateCreation;

    @Column(name = "DATE_MODIFICATION")
    protected LocalDateTime dateModification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MODIFIER", nullable = false)
    protected Player modifier;

    public void update(Player modifier) {
        this.modifier = modifier;
        dateModification = LocalDateTime.now();
    }
}

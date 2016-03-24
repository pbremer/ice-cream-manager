package io.github.pbremer.icecreammanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.pbremer.icecreammanager.entity.IceCreamInstance;

/**
 * Interface to persist {@link IceCreamInstance} into the database. There is no
 * implementation because Spring automatically generates and injects the logic.
 * 
 * @author Patrick Bremer
 */
@Repository
public interface IceCreamInstanceRepository
        extends JpaRepository<IceCreamInstance, Long> {

}

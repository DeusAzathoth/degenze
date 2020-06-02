package org.cthulhu.azathoth.repositories;

import org.cthulhu.azathoth.domains.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

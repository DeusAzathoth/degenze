package org.cthulhu.azathoth.repositories;

import org.cthulhu.azathoth.domains.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

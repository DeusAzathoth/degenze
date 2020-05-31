package org.cthulhu.azathoth.repositories;

import org.cthulhu.azathoth.domains.Block;
import org.springframework.data.repository.CrudRepository;

public interface BlockRepository extends CrudRepository<Block, Long > {
}

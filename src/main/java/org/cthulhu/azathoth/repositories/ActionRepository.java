package org.cthulhu.azathoth.repositories;

import org.cthulhu.azathoth.domains.Action;
import org.joda.time.LocalDateTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActionRepository extends CrudRepository<Action, Long> {

    List<Action> findByTime(LocalDateTime time);

}

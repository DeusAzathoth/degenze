package org.cthulhu.azathoth.security.repositories;

import com.vaadin.flow.component.crud.Crud;
import org.cthulhu.azathoth.security.domains.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

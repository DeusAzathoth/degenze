package org.cthulhu.azathoth.security.repositories;

import org.cthulhu.azathoth.security.domains.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}

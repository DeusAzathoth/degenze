package org.cthulhu.azathoth.repositories;

import org.cthulhu.azathoth.domains.Folder;
import org.springframework.data.repository.CrudRepository;

public interface FolderRepository extends CrudRepository<Folder, Long> {
}

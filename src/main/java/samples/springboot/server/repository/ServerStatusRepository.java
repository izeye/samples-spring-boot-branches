package samples.springboot.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import samples.springboot.server.domain.ServerStatus;

/**
 * Created by izeye on 15. 3. 23..
 */
public interface ServerStatusRepository extends JpaRepository<ServerStatus, Long> {
}

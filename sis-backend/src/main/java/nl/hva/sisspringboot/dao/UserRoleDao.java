
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.UserRole;
import nl.hva.sisspringboot.model.UserRoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole, Long> {

	public UserRole findByUserRoleName(UserRoleType userRoleType);

}

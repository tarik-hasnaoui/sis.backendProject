
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository<UserProfile, Long>  {
    
}

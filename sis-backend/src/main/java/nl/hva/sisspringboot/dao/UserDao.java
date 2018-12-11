
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    public User findByEmail(String email);

    public User findByToken(String token);
}

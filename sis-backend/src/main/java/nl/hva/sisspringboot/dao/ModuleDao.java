
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleDao extends JpaRepository<Module, Long>{
    
    public Module findByModuleName(String moduleName);
}

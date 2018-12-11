
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.SchoolYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolYearDao extends JpaRepository<SchoolYear, Long>/*, SchoolYearDaoCustom */ {

}

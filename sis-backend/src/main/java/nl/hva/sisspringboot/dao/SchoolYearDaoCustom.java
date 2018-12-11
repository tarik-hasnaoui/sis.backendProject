
package nl.hva.sisspringboot.dao;

import java.util.List;
import nl.hva.sisspringboot.model.Module;

public interface SchoolYearDaoCustom {

	public List<Module> findModulesByYearAndBlock(String srcYear, String srcBlock, String destYear, String destBlock);

}

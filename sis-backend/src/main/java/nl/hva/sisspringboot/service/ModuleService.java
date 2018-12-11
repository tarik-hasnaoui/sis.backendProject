package nl.hva.sisspringboot.service;

import java.util.List;

import nl.hva.sisspringboot.dao.ModuleDao;
import nl.hva.sisspringboot.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    public List<Module> getAllModules(String token) {
        return moduleDao.findAll();
    }

    public void deleteModule(String token, Module module) {
        moduleDao.delete(module);
    }

    public void addModule(String token, Module module) {
        moduleDao.save(module);
    }

    public Module getModule(long id) {
        return moduleDao.getOne(id);
    }

}

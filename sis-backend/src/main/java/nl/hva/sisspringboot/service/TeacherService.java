
package nl.hva.sisspringboot.service;

import java.util.List;
import nl.hva.sisspringboot.dao.StudentProfileDao;
import nl.hva.sisspringboot.model.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    
     @Autowired
    private StudentProfileDao studentProfileDao;

    public List<StudentProfile> getAllUsers(String token, Long id) {
        return studentProfileDao.findAll();
    }
    
}

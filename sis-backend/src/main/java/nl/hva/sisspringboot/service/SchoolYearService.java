
package nl.hva.sisspringboot.service;

import java.util.List;
import nl.hva.sisspringboot.dao.SchoolYearDao;
import nl.hva.sisspringboot.dao.UserDao;
import nl.hva.sisspringboot.error.DataNotFoundExcpetion;
import nl.hva.sisspringboot.model.SchoolYear;
import nl.hva.sisspringboot.model.User;
import nl.hva.sisspringboot.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class SchoolYearService {
    
    @Autowired
    private SchoolYearDao schoolYearDao;
    
    @Autowired
    private UserDao userDao;
    
    public List<SchoolYear> getSchoolYears(@PathVariable String token){
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }
        UserProfile userProfile = user.getUserProfile();

        if (userProfile == null) {
            throw new DataNotFoundExcpetion("this user [" + user.getEmail() + "] has no profile.");
        }
        return schoolYearDao.findAll();
    }
    
}

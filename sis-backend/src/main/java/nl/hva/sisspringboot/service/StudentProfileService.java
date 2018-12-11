
package nl.hva.sisspringboot.service;

import java.util.List;

import nl.hva.sisspringboot.dao.ExamDao;
import nl.hva.sisspringboot.dao.ExamRegistrationDao;
import nl.hva.sisspringboot.dao.StudentProfileDao;
import nl.hva.sisspringboot.dao.UserDao;
import nl.hva.sisspringboot.error.DataNotFoundExcpetion;
import nl.hva.sisspringboot.model.Block;
import nl.hva.sisspringboot.model.ExamRegistration;
import nl.hva.sisspringboot.model.ExamResult;
import nl.hva.sisspringboot.model.StudentProfile;
import nl.hva.sisspringboot.model.User;
import nl.hva.sisspringboot.model.UserProfile;
import nl.hva.sisspringboot.model.UserRoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private StudentProfileDao studentProfileDao;

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ExamRegistrationDao examRegistrationDao;

    public StudentProfile getUserProfile(String token, Long id) {
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }
        StudentProfile studentProfile = user.getUserRole().getUserRoleName() == UserRoleType.STUDENT ? (StudentProfile) user.getUserProfile() : null;

        if (studentProfile == null) {
            throw new DataNotFoundExcpetion("this user [" + user.getEmail() + "] has no profile.");
        }
        return studentProfile;
    }

    public List<ExamResult> getExamResults(String token) {
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }
        StudentProfile userProfile = (StudentProfile) user.getUserProfile();

        if (userProfile == null) {
            throw new DataNotFoundExcpetion("this user [" + user.getEmail() + "] has no profile.");
        }
        return userProfile.getExamResults();
    }

    public List<ExamRegistration> getStudentExams(String token, Block block) {
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }
        StudentProfile userProfile = (StudentProfile) user.getUserProfile();

        if (userProfile == null) {
            throw new DataNotFoundExcpetion("this user [" + user.getEmail() + "] has no profile.");
        }

        return examRegistrationDao.findByBlockAndStudentProfile(block, userProfile);
    }

    public UserProfile getUserProfileById(Long id) {
        User user = userDao.getOne(id);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }
        UserProfile userProfile = user.getUserProfile();

        if (userProfile == null) {
            throw new DataNotFoundExcpetion("this user [" + user.getEmail() + "] has no profile.");
        }
        return userProfile;
    }

    public StudentProfile getStudentProfile(Long id) {
        User user = userDao.findOne(id);
        if (user == null || user.getUserRole().getUserRoleName() != UserRoleType.STUDENT) {
            throw new DataNotFoundExcpetion("Unable to find student");
        }
        return (StudentProfile) user.getUserProfile();
    }

}

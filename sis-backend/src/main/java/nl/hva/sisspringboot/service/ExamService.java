
package nl.hva.sisspringboot.service;

import java.util.List;

import nl.hva.sisspringboot.dao.StudentProfileDao;
import nl.hva.sisspringboot.model.ExamResult;
import nl.hva.sisspringboot.model.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    private StudentProfileDao studentProfileDAO;


    public List<ExamResult> getExams(String token, Long id) {
        StudentProfile profile = studentProfileDAO.findOne(id);
        return profile.getExamResults();
    }
}

package nl.hva.sisspringboot.service;

import nl.hva.sisspringboot.dao.ExamDao;
import nl.hva.sisspringboot.dao.ExamResultDao;
import nl.hva.sisspringboot.model.ExamResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamResultService {

    @Autowired
    private ExamResultDao examResultDAO;

    @Autowired
    private ExamDao examDAO;

    public void save(ExamResult examResult) {
        examDAO.save(examResult.getExam());
        examResultDAO.save(examResult);
    }

    public void delete(ExamResult examResult) {
        examDAO.save(examResult.getExam());
        examResultDAO.delete(examResult);
    }


}

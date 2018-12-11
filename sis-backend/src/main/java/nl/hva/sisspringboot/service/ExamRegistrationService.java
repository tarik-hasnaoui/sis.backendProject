/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.sisspringboot.service;

import nl.hva.sisspringboot.dao.ExamRegistrationBasketDao;
import nl.hva.sisspringboot.dao.UserDao;
import nl.hva.sisspringboot.error.DataNotFoundExcpetion;
import nl.hva.sisspringboot.model.ExamRegistrationBasket;
import nl.hva.sisspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamRegistrationService {

    @Autowired
    private ExamRegistrationBasketDao examRegistrationBasketDao;

    @Autowired
    private UserDao userDao;

    public ExamRegistrationBasket saveBasket(String token, ExamRegistrationBasket examRegistrationBasket) {
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }
        return examRegistrationBasketDao.save(examRegistrationBasket);
    }

    public ExamRegistrationBasket updateBasket(String token, ExamRegistrationBasket examRegistrationBasket) {
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }

        return examRegistrationBasketDao.save(examRegistrationBasket);
    }

    public void deleteBasket(String token, ExamRegistrationBasket examRegistrationBasket) {
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }

        examRegistrationBasketDao.delete(examRegistrationBasket);
    }

}

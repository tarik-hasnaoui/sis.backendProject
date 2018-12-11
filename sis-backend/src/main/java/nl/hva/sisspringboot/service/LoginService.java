
package nl.hva.sisspringboot.service;

import java.util.Date;

import nl.hva.sisspringboot.error.DataNotFoundExcpetion;
import nl.hva.sisspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nl.hva.sisspringboot.dao.UserDao;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    public User login(User user) {
        User resultUser = userDao.findByEmail(user.getEmail());

        if (resultUser == null) {
            throw new DataNotFoundExcpetion("User [" + user.getEmail() + "] doesn't exist");
        }

        if (user.getEmail().equals(resultUser.getEmail()) && user.getPassword().equals(resultUser.getPassword())) {
            resultUser.setLastLogin(new Date());
            userDao.save(resultUser);
            return resultUser;
        }

        throw new DataNotFoundExcpetion("username or password doesn match");
    }

    public String resetUser(User user) {
        User resultUser = userDao.findByEmail(user.getEmail());

        if (resultUser == null) {
            throw new DataNotFoundExcpetion("User [" + user.getEmail() + "] doesn't exist");
        }

        resultUser.setPassword("Welkom01");
        userDao.save(resultUser);

        return "Password reset for [" + resultUser.getEmail() + "]";
    }

}

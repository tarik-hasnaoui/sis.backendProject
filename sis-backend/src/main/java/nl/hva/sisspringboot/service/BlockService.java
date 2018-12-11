
package nl.hva.sisspringboot.service;

import java.util.Date;

import nl.hva.sisspringboot.dao.BlockDao;
import nl.hva.sisspringboot.dao.UserDao;
import nl.hva.sisspringboot.error.DataNotFoundExcpetion;
import nl.hva.sisspringboot.model.Block;
import nl.hva.sisspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

    @Autowired
    private BlockDao blockDao;

    @Autowired
    private UserDao userDao;

    public Block getBlockByDate(String token, Date date) {
        User user = userDao.findByToken(token);

        if (user == null) {
            throw new DataNotFoundExcpetion("user does not exist");
        }

        return blockDao.findBlockByDateBetween(date);
    }
}

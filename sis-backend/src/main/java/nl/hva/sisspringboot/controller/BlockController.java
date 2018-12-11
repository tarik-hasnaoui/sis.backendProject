
package nl.hva.sisspringboot.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import nl.hva.sisspringboot.model.Block;
import nl.hva.sisspringboot.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author edgar
 */
@RestController
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping("user/{token}/block/{dateString}")
    public Block getBlockByDate(@PathVariable String token, @PathVariable String dateString) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cl = Calendar.getInstance();
        Date date = df.parse(dateString);
        cl.setTime(date);
        return blockService.getBlockByDate(token, cl.getTime());
    }
}

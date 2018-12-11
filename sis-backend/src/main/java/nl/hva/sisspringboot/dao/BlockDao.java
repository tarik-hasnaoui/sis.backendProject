
package nl.hva.sisspringboot.dao;

import java.util.Date;
import java.util.List;
import nl.hva.sisspringboot.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BlockDao extends JpaRepository<Block, Long>{
    
    public List<Block> findBlockByBlockNumber(Integer blockNumber);
    
    @Query("Select b from Block b where b.startDate <= ?1 and b.endDate >= ?1")
    public Block findBlockByDateBetween(Date date);
}

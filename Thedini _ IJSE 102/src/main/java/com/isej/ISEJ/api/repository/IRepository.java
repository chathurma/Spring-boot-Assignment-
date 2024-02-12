package  com.isej.ISEJ.api.repository;

import com.isej.ISEJ.api.Entitiy.stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<stock, Integer> {

}
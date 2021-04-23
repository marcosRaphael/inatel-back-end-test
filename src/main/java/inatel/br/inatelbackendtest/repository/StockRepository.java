package inatel.br.inatelbackendtest.repository;

import inatel.br.inatelbackendtest.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByName(String name);
    boolean existsByName(String name);
}

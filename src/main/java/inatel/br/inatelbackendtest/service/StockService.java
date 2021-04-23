package inatel.br.inatelbackendtest.service;

import inatel.br.inatelbackendtest.Exception.NotUniqueException;
import inatel.br.inatelbackendtest.Exception.ResourceNotFoundException;
import inatel.br.inatelbackendtest.domain.Stock;
import inatel.br.inatelbackendtest.dto.StockDTO;
import inatel.br.inatelbackendtest.dto.UpdateStockDTO;
import inatel.br.inatelbackendtest.repository.StockRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public StockDTO create(StockDTO stockDTO) {

        stockDTO.setName(stockDTO.getName().toLowerCase(Locale.ROOT));

        if (stockRepository.existsByName(stockDTO.getName())) {
            throw new NotUniqueException("name", "A Ação já está cadastrada.");
        }
        Stock stockToBeSaved = Stock.builder().name(stockDTO.getName()).quotes(stockDTO.getQuotes()).build();

        Stock savedStock = stockRepository.save(stockToBeSaved);

        return StockDTO.builder().name(savedStock.getName()).quotes(savedStock.getQuotes()).build();
    }

    public StockDTO update(UpdateStockDTO updateStockDTO, String stockName) {
        stockName = stockName.toLowerCase(Locale.ROOT);

        Stock stock = stockRepository.findByName(stockName);

        if (stock == null) {
            throw new ResourceNotFoundException("A ação não foi encontrada.");
        }

        stock.getQuotes().addAll(updateStockDTO.getQuotes());

        Stock updatedStock = stockRepository.save(stock);

        return StockDTO.builder().name(updatedStock.getName()).quotes(updatedStock.getQuotes()).build();
    }

    public StockDTO read(String stockName) {
        Stock stock = stockRepository.findByName(stockName);

        if (stock == null) {
            throw new ResourceNotFoundException("A ação não foi encontrada.");
        }

        return StockDTO.builder().name(stock.getName()).quotes(stock.getQuotes()).build();
    }

    public List<StockDTO> readAll() {

        List<StockDTO> stockDTOList = stockRepository.findAll().stream()
                .map((stock) ->  StockDTO.builder().name(stock.getName()).quotes(stock.getQuotes()).build())
                .collect(Collectors.toList());
        return stockDTOList;
    }

    public void delete(String stockName) {
        Stock stock = stockRepository.findByName(stockName);

        if (stock == null) {
            throw new ResourceNotFoundException("A ação não foi encontrada.");
        }

        stockRepository.delete(stock);
    }
}

package inatel.br.inatelbackendtest.controller;

import inatel.br.inatelbackendtest.domain.Stock;
import inatel.br.inatelbackendtest.dto.StockDTO;
import inatel.br.inatelbackendtest.dto.UpdateStockDTO;
import inatel.br.inatelbackendtest.service.StockService;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestControllerAdvice
@RequestMapping("stock")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping
    public ResponseEntity<StockDTO> createStock(@RequestBody @Valid StockDTO stockDTO) {
        return new ResponseEntity<>(stockService.create(stockDTO), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{stockName}")
    public ResponseEntity<StockDTO> updateStock(@RequestBody @Valid UpdateStockDTO updateStockDTO, @PathVariable String stockName) {
        return new ResponseEntity<>(stockService.update(updateStockDTO, stockName), HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<StockDTO> readStock(@RequestParam("name") String name) {
        return new ResponseEntity<>(stockService.read(name), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<StockDTO>> readAllStocks() {
        return new ResponseEntity<>(stockService.readAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{stockName}")
    public ResponseEntity<Void> deleteStock(@PathVariable String stockName) {
        stockService.delete(stockName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

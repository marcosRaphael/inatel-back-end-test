package inatel.br.inatelbackendtest.util;

import inatel.br.inatelbackendtest.domain.Stock;
import inatel.br.inatelbackendtest.dto.StockDTO;
import inatel.br.inatelbackendtest.dto.UpdateStockDTO;

import java.util.ArrayList;
import java.util.List;

public class StockCreator {

    public static StockDTO createValidStockDTO() {

        List<Double> quotesList = new ArrayList<>();

        quotesList.add(1.1);

        return StockDTO.builder().name("teste").quotes(quotesList).build();
    }

    public static Stock createValidStock() {

        List<Double> quotesList = new ArrayList<>();

        quotesList.add(1.1);

        return Stock.builder().name("teste").id(1L).quotes(quotesList).build();
    }

    public static UpdateStockDTO createValidUpdateStockDTO() {

        List<Double> quotesList = new ArrayList<>();

        quotesList.add(1.1);

        return UpdateStockDTO.builder().quotes(quotesList).build();
    }

    public static List<StockDTO> createValidStockDTOList() {

        List<StockDTO> stockDTOList = new ArrayList<>();

        stockDTOList.add(createValidStockDTO());

         return stockDTOList;
    }

    public static List<Stock> createValidStockList() {

        List<Stock> stockList = new ArrayList<>();

        stockList.add(createValidStock());

        return stockList;
    }
}

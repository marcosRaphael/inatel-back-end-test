package inatel.br.inatelbackendtest.service;

import inatel.br.inatelbackendtest.Exception.NotUniqueException;
import inatel.br.inatelbackendtest.Exception.ResourceNotFoundException;
import inatel.br.inatelbackendtest.domain.Stock;
import inatel.br.inatelbackendtest.dto.StockDTO;
import inatel.br.inatelbackendtest.repository.StockRepository;
import inatel.br.inatelbackendtest.util.StockCreator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class StockServiceTest {

    @InjectMocks
    private StockService stockService;

    @Mock
    private StockRepository stockRepositoryMock;

    @BeforeEach
    void setUp() {

        BDDMockito.when(stockRepositoryMock.save(ArgumentMatchers.any(Stock.class)))
                .thenReturn(StockCreator.createValidStock());

        BDDMockito.when(stockRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(StockCreator.createValidStock());

        BDDMockito.when(stockRepositoryMock.findAll())
                .thenReturn(StockCreator.createValidStockList());

        BDDMockito.when(stockRepositoryMock.existsByName(ArgumentMatchers.anyString()))
                .thenReturn(false);

    }

    @Test
    @DisplayName("Save returns StockDTO when successful")
    void save_returnStockDTO_whenSuccessful() {

        StockDTO stockDTO  = stockService.create(StockCreator.createValidStockDTO());

        Assertions.assertEquals(StockCreator.createValidStockDTO(), stockDTO);
    }

    @Test
    @DisplayName("Save returns NotUniqueException when the stock already exists")
    void save_returnsNotUniqueException_whenTheStockAlreadyExists() {

        BDDMockito.when(stockRepositoryMock.existsByName(ArgumentMatchers.anyString()))
                .thenReturn(true);



        Assertions.assertThrows(NotUniqueException.class, () ->stockService.create(StockCreator.createValidStockDTO()));
    }

    @Test
    @DisplayName("Update returns StockDTO when successful")
    void update_returnStockDTO_whenSuccessful() {

        StockDTO stockDTO  = stockService.update(StockCreator.createValidUpdateStockDTO(), "teste");

        Assertions.assertEquals(StockCreator.createValidStockDTO(), stockDTO);
    }

    @Test
    @DisplayName("Update returns ResourceNotFoundException when user does not exist")
    void update_returnsResourceNotFoundException_whenUserDoesNotExist() {

        BDDMockito.when(stockRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(null);

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> stockService.update(StockCreator.createValidUpdateStockDTO(), "teste"));
    }


    @Test
    @DisplayName("Read returns StockDTO when successful")
    void read_returnStockDTO_whenSuccessful() {
        StockDTO stockDTO  = stockService.read("teste");

        Assertions.assertEquals(StockCreator.createValidStockDTO(), stockDTO);
    }

    @Test
    @DisplayName("Read returns ResourceNotFoundException when user does not exist")
    void read_returnsResourceNotFoundException_whenUserDoesNotExist() {

        BDDMockito.when(stockRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(null);

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> stockService.read("teste"));
    }

    @Test
    @DisplayName("ReadAll returns StockDTO List when successful")
    void readAll_returnStockDTO_whenSuccessful() {
        List<StockDTO> stockDTOList  = stockService.readAll();

        Assertions.assertEquals(StockCreator.createValidStockDTOList(), stockDTOList);
    }

    @Test
    @DisplayName("Delete returns nothing when successful")
    void delete_returvoid_whenSuccessful() {
        Assertions.assertDoesNotThrow(() -> stockService.delete("teste"));
    }

    @Test
    @DisplayName("Read returns ResourceNotFoundException when user does not exist")
    void delete_returnsResourceNotFoundException_whenUserDoesNotExist() {

        BDDMockito.when(stockRepositoryMock.findByName(ArgumentMatchers.anyString()))
                .thenReturn(null);

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> stockService.delete("teste"));
    }

}
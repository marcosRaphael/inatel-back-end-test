package inatel.br.inatelbackendtest.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UpdateStockDTO {

    private List<Double> quotes = new ArrayList<>();
}

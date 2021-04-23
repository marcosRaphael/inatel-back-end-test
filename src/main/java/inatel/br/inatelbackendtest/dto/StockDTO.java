package inatel.br.inatelbackendtest.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class StockDTO {

    @Column(unique = true)
    @NotBlank(message = "É necessário inserir um nome.")
    private String name;

    private List<Double> quotes = new ArrayList<>();
}

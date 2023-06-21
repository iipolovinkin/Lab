package ru.github.iipolovinkin.opencsv.sbpReestr;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class SbpBean {
    @CsvBindByName(column = "Номер карты")
    private String cardNumber;
    @CsvBindByName(column = "Номер операции")
    private String operationReference;
}

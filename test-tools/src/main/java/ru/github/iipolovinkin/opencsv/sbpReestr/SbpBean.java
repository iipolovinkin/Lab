package ru.github.iipolovinkin.opencsv.sbpReestr;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class SbpBean {
    @CsvBindByName(column = "Номер карты")
    private String cardNumber;
    @CsvBindByName(column = "Номер операции")
    private String operationReference;

    boolean isFullFilled() {
        return isNotBlank(cardNumber) && isNotBlank(operationReference);
    }
}

package lk.ijse.dep11.pos.dto.response;

import lk.ijse.dep11.pos.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double sellingPrice;
}

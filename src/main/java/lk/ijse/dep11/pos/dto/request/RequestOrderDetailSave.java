package lk.ijse.dep11.pos.dto.request;

import lk.ijse.dep11.pos.entity.Item;
import lk.ijse.dep11.pos.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderDetailSave {
    private String itemName;
    private double qty;
    private Double amount;
    private int orderId;
    private int itemId;
}

package lk.ijse.dep11.pos.dto.request;

import lk.ijse.dep11.pos.entity.Customer;
import lk.ijse.dep11.pos.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderSaveDTO {
    private int customerId;
    private Date date;
    private Double totalPrice;
    private List<RequestOrderDetailSave> orderDetails;
}

package lk.ijse.dep11.pos.service;

import lk.ijse.dep11.pos.dto.request.RequestOrderSaveDTO;
import org.springframework.stereotype.Service;


public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}

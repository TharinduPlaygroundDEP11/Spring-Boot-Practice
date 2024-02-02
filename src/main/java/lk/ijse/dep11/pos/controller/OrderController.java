package lk.ijse.dep11.pos.controller;

import lk.ijse.dep11.pos.dto.ItemDTO;
import lk.ijse.dep11.pos.dto.request.RequestOrderSaveDTO;
import lk.ijse.dep11.pos.service.OrderService;
import lk.ijse.dep11.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {

        String id = orderService.addOrder(requestOrderSaveDTO);

        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,
                        "Order Saved",
                        requestOrderSaveDTO),
                HttpStatus.OK
        );
        return responseEntity;
    }
}

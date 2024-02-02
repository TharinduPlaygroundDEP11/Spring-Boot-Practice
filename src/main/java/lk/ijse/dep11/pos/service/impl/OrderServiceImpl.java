package lk.ijse.dep11.pos.service.impl;

import lk.ijse.dep11.pos.dto.request.RequestOrderSaveDTO;
import lk.ijse.dep11.pos.entity.Order;
import lk.ijse.dep11.pos.entity.OrderDetails;
import lk.ijse.dep11.pos.repository.CustomerRepo;
import lk.ijse.dep11.pos.repository.ItemRepo;
import lk.ijse.dep11.pos.repository.OrderDetailRepo;
import lk.ijse.dep11.pos.repository.OrderRepo;
import lk.ijse.dep11.pos.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;
    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomerId()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotalPrice()
        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetailsList = modelMapper
                    .map(requestOrderSaveDTO.getOrderDetails(), new TypeToken<List<OrderDetails>>(){}
                            .getType());
            for (int i = 0; i < orderDetailsList.size(); i++) {
                orderDetailsList.get(i).setOrder(order);
                orderDetailsList.get(i).setItem(itemRepo.getReferenceById
                        (requestOrderSaveDTO.getOrderDetails().get(i).getItemId()));
            }
            if (!orderDetailsList.isEmpty()) {
                orderDetailRepo.saveAll(orderDetailsList);
            }
            return "Successful";
        }
        return "Failed";
    }
}

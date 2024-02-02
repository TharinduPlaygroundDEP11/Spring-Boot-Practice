package lk.ijse.dep11.pos.controller;

import lk.ijse.dep11.pos.dto.ItemDTO;
import lk.ijse.dep11.pos.dto.paginated.PaginatedResponseItemDTO;
import lk.ijse.dep11.pos.dto.response.ItemGetResponseDTO;
import lk.ijse.dep11.pos.service.ItemService;
import lk.ijse.dep11.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemDTO itemDTO) {
        itemService.saveItem(itemDTO);
        return "Item Saved";
    }

    @GetMapping(path = "/get-items-by-balance-and-status",
    params = {"qty", "status"})
    public List<ItemGetResponseDTO> getItemByQtyAndStatus(@RequestParam(value = "qty") double qty,
                                                          @RequestParam(value = "status") boolean status) {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByQtyAndStatus(qty, status);
        return itemGetResponseDTOS;
    }

    @GetMapping(path = "/get-items-by-balance-and-status-by-mapstruct",
            params = {"qty", "status"})
    public List<ItemGetResponseDTO> getItemByQtyAndStatusByMapStruct(@RequestParam(value = "qty") double qty,
                                                          @RequestParam(value = "status") boolean status) {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByQtyAndStatusByMapStruct(qty, status);
        return itemGetResponseDTOS;
    }

    @GetMapping(path = "/get-all-item-by-status",
    params = {"activeStatus", "page", "size"})
    public ResponseEntity<StandardResponse> getItemByActiveStatus(
            @RequestParam(value = "activeStatus") boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {
        PaginatedResponseItemDTO paginatedResponseItemDTO =
                itemService.getItemByActiveStatusWithPagination(activeStatus, page, size);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,
                        "Data Comes",
                        paginatedResponseItemDTO),
                HttpStatus.OK
        );
        return responseEntity;
    }
}

package lk.ijse.dep11.pos.service;

import lk.ijse.dep11.pos.dto.ItemDTO;
import lk.ijse.dep11.pos.dto.paginated.PaginatedResponseItemDTO;
import lk.ijse.dep11.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    public String saveItem(ItemDTO itemDTO);

    public List<ItemGetResponseDTO> getItemByQtyAndStatus(double qty, boolean status);

    public List<ItemGetResponseDTO> getItemByQtyAndStatusByMapStruct(double qty, boolean status);

    public PaginatedResponseItemDTO getItemByActiveStatusWithPagination(boolean activeStatus, int page, int size);
}

package lk.ijse.dep11.pos.service.impl;

import lk.ijse.dep11.pos.dto.ItemDTO;
import lk.ijse.dep11.pos.dto.paginated.PaginatedResponseItemDTO;
import lk.ijse.dep11.pos.dto.response.ItemGetResponseDTO;
import lk.ijse.dep11.pos.entity.Item;
import lk.ijse.dep11.pos.exeception.NotFoundException;
import lk.ijse.dep11.pos.repository.ItemRepo;
import lk.ijse.dep11.pos.service.ItemService;
import lk.ijse.dep11.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemDTO itemDTO) {
        Item item = modelMapper.map(itemDTO, Item.class);
        itemRepo.save(item);
        return item.getItemName() + " Saved";
    }

    @Override
    public List<ItemGetResponseDTO> getItemByQtyAndStatus(double qty, boolean status) {
        List<Item> itemList = itemRepo.findAllByBalanceQtyEqualsAndActiveStatusEquals(qty, status);
        if (!itemList.isEmpty()) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(
                    itemList,
                    new TypeToken<List<ItemGetResponseDTO>>(){}.getType());

            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("No Items matches");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByQtyAndStatusByMapStruct(double qty, boolean status) {
        List<Item> itemList = itemRepo.findAllByBalanceQtyEqualsAndActiveStatusEquals(qty, status);
        if (!itemList.isEmpty()) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper
                    .entityListToResponseDTOList(itemList);
            return itemGetResponseDTOS;
        } else {
            throw new RuntimeException("No Items matches");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemByActiveStatusWithPagination(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStatusEquals(activeStatus, PageRequest.of(page, size));
        if (items.isEmpty()) {
            throw new NotFoundException("No Data!");
        }

        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemMapper.pageToListDTO(items) , itemRepo.countAllByActiveStatusEquals(activeStatus)
        );
        return paginatedResponseItemDTO;
    }
}

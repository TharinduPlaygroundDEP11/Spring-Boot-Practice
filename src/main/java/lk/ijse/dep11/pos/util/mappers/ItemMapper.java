package lk.ijse.dep11.pos.util.mappers;

import lk.ijse.dep11.pos.dto.ItemDTO;
import lk.ijse.dep11.pos.dto.response.ItemGetResponseDTO;
import lk.ijse.dep11.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToResponseDTOList(List<Item> items);

    List<ItemDTO> pageToListDTO(Page<Item> items);
}

package lk.ijse.dep11.pos.dto.paginated;

import lk.ijse.dep11.pos.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponseItemDTO {
    private List<ItemDTO> list;
    private long count;
}

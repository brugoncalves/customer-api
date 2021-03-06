package unifacef.costumerapi.gateways.inputs.http.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ListResponse<T> implements Serializable {

    private static final long serialVersionUID = -2844945645137312108L;
    private List<T> items;
    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Long totalElements;

    public ListResponse(final Page<T> page) {
        items = page.getContent();
        this.page = page.getPageable().getPageNumber();
        size = page.getPageable().getPageSize();
        totalElements = page.getTotalElements();
        totalPages = page.getTotalPages();

    }
}

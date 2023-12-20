package homework23.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ShoppingCartResponseDTO {
        @JsonProperty("book")
        private BookDataDTO book;
        private int quantity;
}

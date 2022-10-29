package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
// @ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000")
public class Item {

    // @NotNull(groups = UpdateCheck.class)
    private Long id;

    // @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    private String itemName;

    // @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    // @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class})
    private Integer price; // 문자를 넣는다면, typeMismatch 오류가 생긴다.

    // @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    // @Max(9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
// @ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000")
//  @ScriptAssert 는 기능이 약해서 필요하다면, 그 부분만 자바코드로 작성할 것을 실무에서는 권장한다.
public class Item {

    // @NotNull(groups = UpdateCheck.class)
    // null 허용 x
    private Long id;

    // @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
    // 빈값 + 공백만 있는 경우 허용 x
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

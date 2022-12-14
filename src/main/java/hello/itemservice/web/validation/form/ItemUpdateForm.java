package hello.itemservice.web.validation.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


// 아이템 수정용 폼 클래스
@Data
public class ItemUpdateForm {

    // id 가 있어야 지정한 객체를 수정할 수 있기 때문에
    @NotNull
    private Long id;

    @NotBlank
    private String itemName;


    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;

    //수정에서는 수량은 자유롭게 변경할 수 있다.
    private Integer quantity;

}

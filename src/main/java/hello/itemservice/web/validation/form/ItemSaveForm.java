package hello.itemservice.web.validation.form;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


// 아이템 저장용 폼 클래스
// 저장할때는 id 가 필요없으므로 필드에 추가하지 않음
@Data
public class ItemSaveForm {

    @NotBlank
    private String itemName;

    @NotNull
    @Range(min = 1000, max = 1000000)
    private Integer price;


    @NotNull
    @Max(value = 9999)
    private Integer quantity;
}

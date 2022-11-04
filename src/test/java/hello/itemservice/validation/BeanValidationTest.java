package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {
    

    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory(); // 검증기 공장
        Validator validator = factory.getValidator(); // 검증기 공장에서 검증기 빼서 사용

        Item item = new Item(); // 아이템 생성
        item.setItemName(" "); //공백
        item.setPrice(0); // 가격 0
        item.setQuantity(10000); // 재고 9999이상 오류

        // 검증기에 아이템을 담아서 리스트형으로 반환
        Set<ConstraintViolation<Item>> violations = validator.validate(item);

        for (ConstraintViolation<Item> violation : violations) {
            System.out.println("violation=" + violation);
            System.out.println("violation.message=" + violation.getMessage());
            System.out.println("sdfdsfdsfsfds");
        }
    }
}

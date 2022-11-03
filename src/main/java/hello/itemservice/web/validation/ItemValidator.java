package hello.itemservice.web.validation;


import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// 복잡한 검증을 하는 로직을 따로 만들어준 클래스
@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        // isAssignableFrom = item 과 clazz 의 타입이 같은지 확인(자식클래스여도 통과)

        return Item.class.isAssignableFrom(clazz);
    }


    // 검증할 객체(타겟) 과 에러를 매개변수로 담는다.
    @Override
    public void validate(Object target, Errors errors) {

        Item item = (Item) target;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "required");
        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            errors.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
            if (item.getQuantity() == null || item.getQuantity() > 10000) {
                errors.rejectValue("quantity", "max", new Object[]{9999}, null);
            }

            //특정 필드 예외가 아닌 전체 예외
            if (item.getPrice() != null && item.getQuantity() != null) {
                int resultPrice = item.getPrice() * item.getQuantity();
                if (resultPrice < 10000) {errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
                }
            }
        }
    }
}
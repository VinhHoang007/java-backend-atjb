package demo.spring.mvc.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoSpringValidationEmbedDTO {
    @NotEmpty(message = "item1 @NotEmpty")
    @Size(min = 5, message = "@Size")
    private String item1;

    @NotEmpty(message = "item2 @NotEmpty")
    @Size(min = 5, message = "@Size")
    private String item2;

}
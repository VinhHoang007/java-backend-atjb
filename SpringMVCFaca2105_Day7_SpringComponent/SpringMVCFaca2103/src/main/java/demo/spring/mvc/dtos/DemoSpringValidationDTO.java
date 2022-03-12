package demo.spring.mvc.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

// Lombok
@Getter
@Setter
public class DemoSpringValidationDTO {

    @Valid
    private DemoSpringValidationEmbedDTO embed;

    @NotEmpty(message = "name1 @NotEmpty")
    @Size(min = 5, message = "@Size")
    private String name1;
    @NotEmpty(message = "name2 @NotEmpty")
    @Size(min = 5, message = "@Size")
    private String name2;
}

package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("home"),
    MOBILE("Mobile"),
    COMMERCIAL("Comercial");

    private String description;
}

package Enum;

/**
 * Created by RXC8414 on 1/22/2017.
 */
public enum PropertiesEnum {
    URL("http://www.homedepot.com"),
    BROWSER("Chrome"),
    HEADER_SEARCH_BAR(".//input[@id='headerSearch']"),
    HEADER_SEARCH_BAR_BUTTON(".//button[@id='headerSearchButton']"),
    DEPARTMENT_MAIN_MENU(".//a[text()='All Departments']");

    private String value;
    private PropertiesEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}

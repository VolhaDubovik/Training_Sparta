package by.issoft.files;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Employee {
    String id;
    String employee_name;
    String employee_salary;
    String employee_age;
    String profile_image;

}

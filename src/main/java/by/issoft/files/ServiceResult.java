
package by.issoft.files;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ServiceResult {

    String status;
    List<Employee> data;



}

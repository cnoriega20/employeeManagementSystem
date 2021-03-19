package karate.employee;

import com.intuit.karate.junit5.Karate;

public class EmployeeRunner {

    @Karate.Test
    Karate testAll(){
        return Karate.run().relativeTo(getClass());
    }
}

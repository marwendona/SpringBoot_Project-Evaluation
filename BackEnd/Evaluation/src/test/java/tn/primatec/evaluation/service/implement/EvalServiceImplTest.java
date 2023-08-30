package tn.primatec.evaluation.service.implement;

import org.junit.jupiter.api.Test;
import tn.primatec.evaluation.model.employee.Employee;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvalServiceImplTest {

    private final EvalServiceImpl evalService = new EvalServiceImpl();
    @Test
    void loadEmployeesFromExcel() throws Exception {
        var employees = evalService.loadEmployeesFromExcel("C:/DataOnly.xlsm");

    }
}
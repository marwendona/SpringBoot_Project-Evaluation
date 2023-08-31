package tn.primatec.evaluation.service.implement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.primatec.evaluation.dao.EmployeeRepository;
import tn.primatec.evaluation.dao.SatisfactionRepository;
import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.model.Employee;
import static org.mockito.Mockito.verify;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class EvalServiceImplTest {

    private static final String FILE_PATH = "C:\\Users\\MSI\\Documents\\IIT\\2GLID\\Summer Internship\\EvaluationProcessTestIntership - DataOnly.xlsm";

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private SatisfactionRepository satisfactionRepository;

    private EvalServiceImpl evalService;

    @BeforeEach
    void setUp() {
        evalService = new EvalServiceImpl(employeeRepository, satisfactionRepository);
    }

    @Test
    void loadEmployeesFromExcel() throws Exception {
        var employees = evalService.loadEmployeesFromExcel(FILE_PATH);

        var expectedEmployees = List.of(Employee.builder().department("").build());
//        assertEquals(expectedEmployees, employees);
//        verify(employeeRepository).save(new EmployeeDto());
    }
}
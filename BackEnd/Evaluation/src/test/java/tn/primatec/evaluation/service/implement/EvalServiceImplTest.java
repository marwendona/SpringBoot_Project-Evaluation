package tn.primatec.evaluation.service.implement;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EvalServiceImplTest {
//    private static final String FILE_PATH = "C:\\Users\\MSI\\Documents\\IIT\\2GLID\\Summer Internship\\EvaluationProcessTestIntership - DataOnly.xlsm";
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//    @Mock
//    private SatisfactionRepository satisfactionRepository;
//    @Mock
//    private StabilityRepository stabilityRepository;
//    @Mock
//    private TechnicalEvaluationRepository technicalEvaluationRepository;
//    @Mock
//    private ObjectivesAndProactivityRepository objectivesAndProactivityRepository;
//    @Mock
//    private CareerAndTrainingsRepository careerAndTrainingsRepository;
//    @Mock
//    private YearlyEvaluationRepository yearlyEvaluationRepository;
//
//    private EvalServiceImpl evalService;
//
//    @BeforeEach
//    void setUp() {
//        evalService = new EvalServiceImpl(employeeRepository, satisfactionRepository, stabilityRepository, technicalEvaluationRepository, objectivesAndProactivityRepository, careerAndTrainingsRepository, yearlyEvaluationRepository);
//    }
//
//    @Test
//    void loadEmployeesFromExcel() throws Exception {
//        var employees = evalService.loadEmployeesFromExcel(FILE_PATH);
//
//        var expectedEmployees = List.of(Employee.builder().department("").build());
////        assertEquals(expectedEmployees, employees);
////        verify(employeeRepository).save(new EmployeeDto());
//    }
}
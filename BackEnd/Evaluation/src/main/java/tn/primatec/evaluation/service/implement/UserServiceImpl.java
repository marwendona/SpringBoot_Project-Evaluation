package tn.primatec.evaluation.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.primatec.evaluation.dao.EmployeeRepository;
import tn.primatec.evaluation.dao.UserRepository;
import tn.primatec.evaluation.dto.EmployeeDto;
import tn.primatec.evaluation.dto.UserDto;
import tn.primatec.evaluation.exception.ResourceNotFoundException;
import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.user.User;
import tn.primatec.evaluation.service.UserService;

import java.net.URI;

import static tn.primatec.evaluation.application.ApplicationProperties.BASE_URL;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<Long> createUser(User user) {
        var userDto = new UserDto();
        fillUserDto(userDto, user);
        userDto = userRepository.save(userDto);
        return ResponseEntity.created(URI.create(BASE_URL + "/users/" + userDto.getId())).body(userDto.getId());
    }

    private static void fillUserDto(UserDto userDto, User user) {
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Override
    public ResponseEntity<?> addEmployee(long userId, Employee employee) {
        var userDto = findUserById(userId);

        var employeeDto = new EmployeeDto();

        employeeDto.setUserDto(userDto);
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDepartment(employee.getDepartment());
        employeeDto.setTeam(employee.getTeam());
        employeeDto.setJobTitle(employee.getJobTitle());
        employeeDto = employeeRepository.save(employeeDto);

        return ResponseEntity.created(URI.create(BASE_URL + "/users/" + userDto.getId()
                + "/employees/" + employeeDto.getId())).body(employeeDto.getId());
    }

    private UserDto findUserById(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}

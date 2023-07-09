package tn.primatec.evaluation.service;

import org.springframework.http.ResponseEntity;
import tn.primatec.evaluation.model.employee.Employee;
import tn.primatec.evaluation.model.user.User;

public interface UserService {
    ResponseEntity<Long> createUser(User user);
    ResponseEntity<?> addEmployee(long userId, Employee employee);
}

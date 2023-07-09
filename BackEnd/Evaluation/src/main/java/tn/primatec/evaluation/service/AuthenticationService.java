package tn.primatec.evaluation.service;

import org.springframework.web.bind.annotation.RequestBody;
import tn.primatec.evaluation.model.user.Login;

public interface AuthenticationService {
    long login(@RequestBody Login login);
}

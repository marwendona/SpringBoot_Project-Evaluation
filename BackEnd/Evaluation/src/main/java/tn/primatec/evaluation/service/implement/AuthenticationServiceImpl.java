package tn.primatec.evaluation.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.primatec.evaluation.dao.UserRepository;
import tn.primatec.evaluation.dto.UserDto;
import tn.primatec.evaluation.exception.InvalidPasswordException;
import tn.primatec.evaluation.model.user.Login;
import tn.primatec.evaluation.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public long login(Login login) {
        UserDto userDto = userRepository.findByEmail(login.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email not found"));
        String encodedPassword = userDto.getPassword();
        boolean isPwdRight = passwordEncoder.matches(login.getPassword(), encodedPassword);

        if (!isPwdRight) {
            throw new InvalidPasswordException("Password does not match");
        }

        return userDto.getId();
    }
}

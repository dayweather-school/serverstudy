package com.example.ttt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // final로 적어둔 필드를 보고 그걸 넣는 생성자를 만들어줌
public class PrintService {
    private final UserRepository userRepository;

    public String printHelloWorld() {
        User user = User.builder()
                .username("최수아")
                .password("Qwer1234!")
                .build();

        userRepository.save(user);

        return "Hello World!";
    }
}
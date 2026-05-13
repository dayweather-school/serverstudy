package com.example.exampleclass1.ttt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 이 클래스는 비즈니스 로직을 담당하는 서비스 계층임. Spring이 자동으로 Bean으로 등록해 관리함.
@RequiredArgsConstructor //lombok에서 옴. final로 적어둔 필드를 보고 그걸 넣는 생성자를 만들어줌 == this.userRepository = userRepository;
public class PrintService
{
    private final UserRepository userRepository; // final = 반드시 생성자 초기, 불변. DB접근(JPA Repository)

    public String printHelloWorld()
    {
        User user = User.builder() // lombok의 builder. User user = new User("이름", "Qwer1234!");
                .username("이름")
                .password("Qwer1234!")
                .build();

        userRepository.save(user); // save는 Spring Data JAP 가본 메서드, Insert, Update 수행. user을 DB에 저장.

        return "Hello World!"; // 반환값.
    }

    public void singup(CreateUserRequest request)
    {
        User user = User.builder()
                .username(request.username())
                .password(request.password())
                .build();
        userRepository.save(user);
    }

    //유저 전체 조회
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
}
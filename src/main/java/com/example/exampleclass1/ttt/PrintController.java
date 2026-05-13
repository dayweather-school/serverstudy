package com.example.exampleclass1.ttt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 화면이 아닌 json을 반환하기 위해 사용
@RequestMapping("/print")
@RequiredArgsConstructor

public class PrintController {
    private final PrintService printService;

    @GetMapping()
    public String printHelloWorld() {return printService.printHelloWorld();}

    // 유저 전체 조회
    @GetMapping("/users")
    public List<User> getUsers()
    {
        return printService.findAllUsers();
    }

    @PostMapping
    public void signup(@RequestBody CreateUserRequest request)
    {
        printService.singup(request);
    }
}
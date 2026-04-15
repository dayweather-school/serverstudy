package com.example.ttt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 화면이 아닌 json을 반환하기 위해 사용
@RequestMapping("/print")
@RequiredArgsConstructor

public class PrintController {
    private final PrintService printService;

    @GetMapping()
    public String printHelloWorld() {
        return printService.printHelloWorld();
    }
}
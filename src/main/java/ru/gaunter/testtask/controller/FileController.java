package ru.gaunter.testtask.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gaunter.testtask.service.FileService;

@Controller
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;


    @Operation(summary = "Получает N-ое минимальное число из файла")
    @GetMapping("/min")
    public ResponseEntity<Integer> getMin(
            @RequestParam String path,
            @RequestParam int n) {

        return ResponseEntity.ok(fileService.readFile(path, n));
    }

}

package exercise.contoller;

import exercise.service.CalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CalculationController {

    private final CalculationService calculationService;

    @GetMapping("/")
    @ResponseBody
    public Double calculate(){
        return calculationService.calculate();
    }
}

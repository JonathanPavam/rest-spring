package rest_springboot.rest_spring.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest_springboot.rest_spring.service.MathService;

@RestController
@RequestMapping("/math")
public class MathController {

    MathService mathService = new MathService();
    @RequestMapping(value="/sum/{n1}/{n2}", method = RequestMethod.GET)
    public Double sum(@PathVariable String n1, @PathVariable String n2){
        return mathService.sum(n1,n2);
    }

    @RequestMapping(value="/mult/{n1}/{n2}", method = RequestMethod.GET)
    public Double mult (@PathVariable String n1, @PathVariable String n2){
        return mathService.mult(n1,n2);
    }

    @RequestMapping(value="/div/{n1}/{n2}", method = RequestMethod.GET)
    public Double div (@PathVariable String n1, @PathVariable String n2){
        return mathService.div(n1,n2);
    }

    @RequestMapping(value="/raiz/{n1}", method = RequestMethod.GET)
    public Double sub (@PathVariable String n1, @PathVariable String n2){
        return mathService.sub(n1,n2);
    }
}

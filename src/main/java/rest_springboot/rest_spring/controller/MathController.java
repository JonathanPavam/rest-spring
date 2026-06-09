package rest_springboot.rest_spring.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest_springboot.rest_spring.exception.UnsuportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping(value="/sum/{n1}/{n2}", method = RequestMethod.GET)
    public Double sum (@PathVariable("n1") String n1, @PathVariable("n2") String n2){
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) + convertToDouble(n2);
    }

    @RequestMapping(value="/sub/{n1}/{n2}", method = RequestMethod.GET)
    public Double sub (@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if (!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) - convertToDouble(n2);
    }

    @RequestMapping(value="/mult/{n1}/{n2}", method = RequestMethod.GET)
    public Double mult (@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if (!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) * convertToDouble(n2);
    }

    @RequestMapping(value="/div/{n1}/{n2}", method = RequestMethod.GET)
    public Double div (@PathVariable("n1") String n1, @PathVariable("n2") String n2) {
        if (!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) / convertToDouble(n2);
    }

    @RequestMapping(value="/raiz/{n1}", method = RequestMethod.GET)
    public Double raiz (@PathVariable("n1") String n1){
        if (!isNumeric(n1))throw new UnsuportedMathOperationException("Please set a numeric value");
        Double raiz = convertToDouble(n1);
        return Math.sqrt(raiz);
    }


    private Double convertToDouble(String strN) throws IllegalArgumentException{
        if(strN == null || strN.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value");
        String number = strN.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }




}

package rest_springboot.rest_spring.service;
import rest_springboot.rest_spring.exception.UnsuportedMathOperationException;

public class MathService {

    //sum
    public Double sum (String n1, String n2){
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) + convertToDouble(n2);
    }

    //sub
    public Double sub (String n1, String n2) {
        if (!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) - convertToDouble(n2);
    }

    //mult
    public Double mult (String n1, String n2) {
        if (!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) * convertToDouble(n2);
    }


    //div
    public Double div (String n1, String n2) {
        if (!isNumeric(n1) || !isNumeric(n2)) throw new UnsuportedMathOperationException("Please set a numeric value");
        return convertToDouble(n1) / convertToDouble(n2);
    }


    //raiz
    public Double raiz (String n1){
        if (!isNumeric(n1))throw new UnsuportedMathOperationException("Please set a numeric value");
        Double raiz = convertToDouble(n1);
        return Math.sqrt(raiz);
    }



    //Functions
    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String strN) throws IllegalArgumentException{
        if(strN == null || strN.isEmpty()) throw new UnsuportedMathOperationException("Please set a numeric value");
        String number = strN.replace(",", ".");
        return Double.parseDouble(number);
    }
}
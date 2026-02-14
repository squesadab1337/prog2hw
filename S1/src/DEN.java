// implementar una funcion recursiva que cuente cuantas veces aparece un digito en un numero

package src;


public class DEN {

    public static void main(String[] args) {
        int numero = 100;
        int digito = 0;
        int indice = 0;
        int contador = 0;
        int apariciones = digitoEnNumero(numero, digito, indice, contador);
        System.out.println("Digito (" + digito + ") " + "aparence en el numero (" + numero + ") ("+ apariciones + ") veces");
    }

    public static int digitoEnNumero(int numero, int digito, int indice, int contador) {
        
        String numberString = ("" + numero); 

        if (indice >= numberString.length()) {
            return contador;
        }
        
        int digitInNumber = Integer.parseInt(numberString.charAt(indice) + "");

        if (digitInNumber == digito) {
            return digitoEnNumero(numero, digito, (indice + 1), (contador + 1));
        } else {
            return digitoEnNumero(numero, digito, (indice + 1), contador);
        }


    }
}


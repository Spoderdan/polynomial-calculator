public class PolynomialMultiplication {

    public static Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        Polynomial aux = new Polynomial();
        Monomial monomial1, monomial2;
        int i = 0, j = 0;

        while(i < polynomial1.getNumberOfMonomials())
            while(j < polynomial2.getNumberOfMonomials()){
                monomial1 = polynomial1.getMonomial(i);
                monomial2 = polynomial2.getMonomial(j);
                aux.addMonomial(new Monomial(monomial1.getCoefficient() * monomial1.getCoefficient(),
                                            monomial1.getPower() + monomial2.getPower()));
            }

        return result;
    }

}

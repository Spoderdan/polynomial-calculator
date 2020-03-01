public class PolynomialAddition {

    /**
     * Performs addition between 2 polynomials
     * @param polynomial1
     * @param polynomial2
     * @return the result of the polynomial addition
     */
    public static Polynomial add(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        Monomial monomial1, monomial2;
        int monomialNumber1 = polynomial1.getNumberOfMonomials();
        int monomialNumber2 = polynomial2.getNumberOfMonomials();
        int powerOfFirstMonomial, powerOfSecondMonomial ;
        int i = 0, j = 0;

        while(i < monomialNumber1 || j < monomialNumber2){
            monomial1 = polynomial1.getMonomial(i);
            monomial2 = polynomial2.getMonomial(j);
            powerOfFirstMonomial = monomial1.getPower();
            powerOfSecondMonomial = monomial2.getPower();

            if(powerOfFirstMonomial > powerOfSecondMonomial) {
                result.addMonomial(monomial1);
                i++;
            }
            else if(powerOfFirstMonomial < powerOfSecondMonomial) {
                result.addMonomial(monomial2);
                j++;
            }
            else {
                if(monomial1.getCoefficient() + monomial2.getCoefficient() != 0)
                    result.addMonomial(new Monomial(monomial1.getCoefficient() + monomial2.getCoefficient(), monomial1.getPower()));
                i++;
                j++;
            }
        }
        return result;
    }

    /*public static void main(String[] args){
        Polynomial poly1 = new Polynomial("2x^3+40x^1+2x^0");
        Polynomial poly2 = new Polynomial("3x^2+3x^1+10x^0");
        Polynomial res = add(poly1, poly2);
        System.out.println(res);
    }*/

}

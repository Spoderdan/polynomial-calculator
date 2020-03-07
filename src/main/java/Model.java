public class Model {

    private Polynomial polynomial1;
    private Polynomial polynomial2;
    public Polynomial result;

    Model(){

    }

    public void add(){
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
        this.result = result;
    }

    public void subtract(){
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
                result.addMonomial(new Monomial(-monomial2.getCoefficient(), monomial2.getPower()));
                j++;
            }
            else {
                if(monomial1.getCoefficient() - monomial2.getCoefficient() != 0)
                    result.addMonomial(new Monomial(monomial1.getCoefficient() - monomial2.getCoefficient(), monomial1.getPower()));
                i++;
                j++;
            }
        }
        this.result = result;
    }

    public void setPolynomial1(String poly){
        this.polynomial1 = new Polynomial(poly);
    }

    public void setPolynomial2(String poly){
        this.polynomial2 = new Polynomial(poly);
    }

    public void setResult(String poly){
        this.result = new Polynomial(poly);
    }

    public String getResult(){
        return this.result.toString();
    }

    public static void main(String[] args){
        //Polynomial poly1 = new Polynomial("2x^3+1x^0");
        //Polynomial poly2 = new Polynomial("-40x^5+3x^2+1x^1");
        Model m = new Model();
        m.setPolynomial1("2x^3-1x^0");
        m.setPolynomial2("-40x^5+3x^2+1x^1+1x^0");
        m.subtract();
        System.out.println(m.getResult());
        System.out.println(m.result.getMonomial(m.result.getNumberOfMonomials() - 1).getPower());
        System.out.println(m.result.getMonomial(m.result.getNumberOfMonomials() - 1).getCoefficient());
        //System.out.println(new Monomial(1, 0));
    }

}

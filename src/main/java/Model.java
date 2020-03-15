import java.util.ArrayList;
import java.util.List;

public class Model {

    private Polynomial polynomial1;
    private Polynomial polynomial2;
    private Polynomial result;
    private Polynomial rest;

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

    public void multiply(){

        List<Monomial> aux = new ArrayList<>();

        for(Monomial m1 : polynomial1.getMonomialList())
            for(Monomial m2 : polynomial2.getMonomialList())
                aux.add(new Monomial(m1.getCoefficient() * m2.getCoefficient(),
                        m1.getPower() + m2.getPower()));

        result = new Polynomial("0x^0");
        for(Monomial m : aux){
            setPolynomial1(m);
            setPolynomial2(this.result);
            add();
        }
    }

    public void divide(){

        Polynomial q = new Polynomial();
        Polynomial r = polynomial1;
        Polynomial p2 = polynomial2;
        Monomial t;
        Polynomial aux;

        while(r.degree() >= p2.degree()){
            t = Monomial.divideMonomial(r.getMonomial(0), p2.getMonomial(0));
            polynomial1 = q;
            polynomial2 = new Polynomial(t);
            add();
            q = result;
            polynomial1 = p2;
            polynomial2 = new Polynomial(t);
            multiply();
            aux = result;
            polynomial1 = r;
            polynomial2 = aux;
            subtract();
            r = result;
        }

        result = q;
        rest = r;
    }

    public void derivate(){

        List<Monomial> monomialList = polynomial1.getMonomialList();

        for(Monomial m : monomialList){
            if(m.getPower() == 0) {
                monomialList.remove(m);
                break;
            }
            else {
                m.setCoefficient(m.getCoefficient() * m.getPower());
                m.setPower(m.getPower() - 1);
            }
        }
        result = new Polynomial(monomialList);
    }

    public void integrate(){

        List<Monomial> monomialList = polynomial1.getMonomialList();
        StringBuilder result = new StringBuilder();

        for(Monomial m : monomialList){
            if(m.getCoefficient() > 0)
                result.append("+");
            if(m.getCoefficient() != 1 && m.getCoefficient() != -1)
                result.append(m.getCoefficient()).append("*1/");
            else
                result.append("1/");
            result.append(m.getPower()+1).append("x^").append(m.getPower()+1);
        }
        this.result = new Polynomial(String.valueOf(result));
    }

//  Setters and Getters for the instance variables =====================================================================

    public void setPolynomial1(String poly){
        this.polynomial1 = new Polynomial(poly);
    }

    public void setPolynomial1(Monomial monomial){
        this.polynomial1 = new Polynomial(monomial);
    }

    public void setPolynomial2(String poly){
        this.polynomial2 = new Polynomial(poly);
    }

    public void setPolynomial2(Polynomial polynomial){
        this.polynomial2 = polynomial;
    }

    public String getResult(){
        return this.result.toString();
    }

    public String getRest() {
        return this.rest.toString();
    }

}

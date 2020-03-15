import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private List<Monomial> monomialList = new ArrayList<>();
    private int numberOfMonomials = 0;

    public Polynomial(){
        super();
    }

    /**
     * Constructor that takes a String and turns it into a polynomial.
     * @param polynomial String representation of the polynomial
     */
    public Polynomial(String polynomial){
        findMonomials(polynomial);
    }

    /**
     * Constructor that creates a polynomial using a list of monomials.
     * @param monomials List of monomials for the new polynomial
     */
    public Polynomial(List<Monomial> monomials){
        this.monomialList = monomials;
        numberOfMonomials = monomials.size();
    }

    /**
     * Constructor that creates a polynomial containing only one monomial.
     * @param monomial The sole monomial inside the polynomial
     */
    public Polynomial(Monomial monomial){
        addMonomial(monomial);
    }

    /**
     * Adds a monomial to the list that makes up the polynomial
     * @param monomial the monomial to be added to the list
     */
    public void addMonomial(Monomial monomial){
        monomialList.add(monomial);
        numberOfMonomials++;
    }

    /**
     * Finds the coefficients and powers from a polynomial and adds a monomial with those parameters to the list
     * @param polynomial the polynomial to find the coefficients and powers of
     */
    private void findMonomials(String polynomial){
        Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m = p.matcher(polynomial);
        while (m.find())
            addMonomial(new Monomial(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
    }

    /**
     * Returns the degree of the polynomial.
     * @return integer as the degree
     */
    public int degree(){
        return monomialList.get(0).getPower();
    }

    /**
     * Returns a simpler representation of a polynomial without the extra characters of powers 1 and 0
     * @return string representation of the polynomial
     */
    public String toString(){
        StringBuilder polynomial = new StringBuilder();
        String coefficient = "";
        String power = "";

        int i = 0;
        while (i < numberOfMonomials){
            coefficient = Integer.toString(monomialList.get(i).getCoefficient());
            power = Integer.toString(monomialList.get(i).getPower());

            if(coefficient.charAt(0) != '-' && i != 0)
                polynomial.append("+");
            if(!coefficient.equals("1") && !coefficient.equals("-1"))
                polynomial.append(coefficient);
            if(power.equals("1") && coefficient.equals("1"))
                polynomial.append("x");
            else if(power.equals("1") && coefficient.equals("-1"))
                polynomial.append("-x");
            else if(power.equals("1"))
                polynomial.append("x");
            else if(power.equals("0") && coefficient.equals("1"))
                polynomial.append("1");
            else if(power.equals("0") && coefficient.equals("-1"))
                polynomial.append("-1");
            else if(!power.equals("0") && !power.equals("1"))
                polynomial.append("x^").append(power);
            i++;
        }
        return String.valueOf(polynomial);
    }

    /**
     * Returns the monomials of the polynomial as a list.
     * @return List of monomials
     */
    public List<Monomial> getMonomialList(){
        return monomialList;
    }

    /**
     * Returns the monomial at the desired position
     * @param i index of desired monomial
     * @return Monomial
     */
    public Monomial getMonomial(int i){
        Monomial m;
        try{
            m = monomialList.get(i);
        }catch (IndexOutOfBoundsException e){
            return new Monomial(0, 0);
        }
        return m;
    }

    /**
     * Returns the number of monomials in polynomial
     * @return integer
     */
    public int getNumberOfMonomials(){
        return this.numberOfMonomials;
    }

}

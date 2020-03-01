import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    private List<Monomial> monomialList = new ArrayList<Monomial>();
    private int numberOfMonomials = 0;

    public Polynomial(){
        super();
    }

    public Polynomial(String polynomial){
        findMonomials(polynomial);
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
            if(monomialList.get(i).getPower() == 1)
                polynomial.append(coefficient).append("x");
            else if(monomialList.get(i).getPower() == 0)
                polynomial.append(coefficient);
            else
                polynomial.append(coefficient).append("x^").append(power);
            i++;
        }
        return String.valueOf(polynomial);
    }

    /**
     * Returns a list of the powers of the polynomial
     * @return list of integers
     */
    public List<Integer> getPowerlist(){
        List<Integer> powerList = new ArrayList<Integer>();
        for (Monomial m: monomialList)
            powerList.add(m.getPower());
        return powerList;
    }

    /**
     * Returns the monomial at the desired position
     * @param i index of desired monomial
     * @return monomial
     */
    public Monomial getMonomial(int i){
        return monomialList.get(i);
    }

    /**
     * Returns number of monomials in polynomial
     * @return integer
     */
    public int getNumberOfMonomials(){
        return this.numberOfMonomials;
    }

    /**
     * Returns the maximum power of the polynomial
     * @return integer
     */
    public int getMaxPower(){
        return monomialList.get(0).getPower();
    }

    /*public static void main(String[] args){
        String polynomial = "-2x^3+2x^1+42x^0";
        *//*Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m = p.matcher(polynomial);
        while(m.find())
            System.out.println(m.group(1) + " " + m.group(2));*//*
        Polynomial poly = new Polynomial(polynomial);
        System.out.println(poly);
        List<Integer> list = poly.getPowerlist();
        for(Integer i: list)
            System.out.println(i);
        System.out.println(poly.getNumberOfMonomials());
        Monomial test = poly.getMonomial(2);
        System.out.println(test.getPower());
    }*/
}

class Monomial {

    private int coefficient;
    private int power;

    /**
     * Constructor that creates a monomial with the desired coefficient and power.
     * @param coefficient Coefficient of the monomial
     * @param power Power of the monomial
     */
    Monomial(int coefficient, int power){
        setCoefficient(coefficient);
        setPower(power);
    }

    /**
     * Converts the monomial to a nicer string representations.
     * @return A string containing the monomial.
     */
    public String toString(){
        StringBuilder monom = new StringBuilder();
        if(coefficient != 1 && coefficient != -1)
            monom.append(coefficient);
        if(power == 1 && coefficient > 0)
            monom.append("x");
        else if(power == 1 && coefficient < 0)
            monom.append("-x");
        else if(power == 0 && coefficient == 1)
            return String.valueOf(1);
        else if(power == 0 && coefficient == -1)
            return String.valueOf(-1);
        else if(power != 0 && power != 1)
                monom.append("x^").append(power);
        return String.valueOf(monom);
    }

    /**
     * Static method that performs the division between two monomials.
     * @param m1 Dividend
     * @param m2 Divisor
     * @return Result of the monomial division as a new monomial.
     */
    public static Monomial divideMonomial(Monomial m1, Monomial m2){
        Monomial result = new Monomial(0, 0);
        result.setCoefficient(m1.getCoefficient() / m2.getCoefficient());
        result.setPower(m1.getPower() - m2.getPower());
        return result;
    }

//  Getters and Setters for instance variables =========================================================================

    public int getCoefficient(){
        return this.coefficient;
    }

    public void setCoefficient(int coefficient){
        this.coefficient = coefficient;
    }

    public int getPower(){
        return this.power;
    }

    public void setPower(int power){
        this.power = power;
    }

}

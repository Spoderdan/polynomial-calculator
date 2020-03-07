class Monomial {

    private int coefficient;
    private int power;

    Monomial(int coefficient, int power){
        setCoefficient(coefficient);
        setPower(power);
    }

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

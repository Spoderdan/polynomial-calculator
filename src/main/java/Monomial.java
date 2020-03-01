class Monomial {

    private int coefficient;
    private int power;

    Monomial(int coefficient, int power){
        setCoefficient(coefficient);
        setPower(power);
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

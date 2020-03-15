import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestOperations {

    Polynomial p1;
    Polynomial p2;
    Model m = new Model();

    @Test

    public void testPolynomialAdditionTrue() {
        p1 = new Polynomial("3x^2+1x^0");
        p2 = new Polynomial("2x^2+6x^1");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.add();
        assertEquals(new Polynomial("5x^2+6x^1+1x^0").toString(), m.getResult());
    }

    @Test

    public void testPolynomialAdditionFalse() {
        p1 = new Polynomial("3x^2+1x^0");
        p2 = new Polynomial("2x^2+6x^1");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.add();
        assertEquals(new Polynomial("5x^2+6x^1-1x^0").toString(),m.getResult());
    }

    @Test

    public void testPolynomialSubtractionTrue() {
        p1 = new Polynomial("3x^2+1x^0");
        p2 = new Polynomial("2x^2+6x^1");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.subtract();
        assertEquals(new Polynomial("1x^2-6x^1+1x^0").toString(), m.getResult());
    }

    @Test

    public void testPolynomialSubtractionFalse() {
        p1 = new Polynomial("3x^2+1x^0");
        p2 = new Polynomial("2x^2+6x^1");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.subtract();
        assertEquals(new Polynomial("5x^2+6x^1+1x^0").toString(), m.getResult());
    }

    @Test

    public void testPolynomialMultiplicationTrue() {
        p1 = new Polynomial("3x^2+1x^0");
        p2 = new Polynomial("2x^2+6x^1");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.multiply();
        assertEquals(new Polynomial("6x^4+18x^3+2x^2+6x^1").toString(), m.getResult());
    }

    @Test

    public void testPolynomialMultiplicationFalse() {
        p1 = new Polynomial("3x^2+1x^0");
        p2 = new Polynomial("2x^2+6x^1");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.multiply();
        assertEquals(new Polynomial("5x^2+6x^1+1x^0").toString(), m.getResult());
    }

    @Test

    public void testPolynomialDivisionTrue() {
        p1 = new Polynomial("1x^3-2x^2-4x^0");
        p2 = new Polynomial("1x^1-3x^0");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.divide();
        assertEquals(new Polynomial("1x^2+1x^1+3x^0").toString(), m.getResult());
        assertEquals(new Polynomial("5x^0").toString(), m.getRest());
    }

    @Test

    public void testPolynomialDivisionFalse() {
        p1 = new Polynomial("1x^3-2x^2-4x^0");
        p2 = new Polynomial("1x^1-3x^0");
        m.setPolynomial1(p1);
        m.setPolynomial2(p2);
        m.divide();
        assertEquals(new Polynomial("5x^2+6x^1+1x^0").toString(), m.getResult());
        assertEquals(new Polynomial("5x^0").toString(), m.getRest());
    }

    @Test

    public void testPolynomialDerivationTrue() {
        p1 = new Polynomial("3x^2+1x^0");
        m.setPolynomial1(p1);
        m.derivate();
        assertEquals(new Polynomial("6x^1").toString(), m.getResult());
    }

    @Test

    public void testPolynomialDerivationFalse() {
        p1 = new Polynomial("3x^2+1x^0");
        m.setPolynomial1(p1);
        m.derivate();
        assertEquals(new Polynomial("5x^2+6x^1+1x^0").toString(), m.getResult());
    }

    @Test

    public void testPolynomialIntegrationTrue() {
        p1 = new Polynomial("-3x^2-1x^1+1x^0");
        m.setPolynomial1(p1);
        assertEquals("-3*1/3x^3-1/2x^2+1/1x^1", m.integrate());
    }

    @Test

    public void testPolynomialIntegrationFalse() {
        p1 = new Polynomial("3x^2+1x^0");
        m.setPolynomial1(p1);
        assertEquals("5x^2+6x^1+1x^0", m.integrate());
    }

}

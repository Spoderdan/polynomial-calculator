import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Model model;
    private View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;

        this.view.addAdditionListener(new AdditionListener());
        this.view.addSubtractionListener(new SubtractionListener());
    }

    class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String poly1 = "";
            String poly2 = "";
            try {
                poly1 = view.getUserInput1();
                poly2 = view.getUserInput2();
                model.setPolynomial1(poly1);
                model.setPolynomial2(poly2);
                model.add();
                view.showResult(model.getResult());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: '" + poly1 + "'");
                view.showError("Bad input: '" + poly2 + "'");
            }
        }
    }

    class SubtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String poly1 = "";
            String poly2 = "";
            try {
                poly1 = view.getUserInput1();
                poly2 = view.getUserInput2();
                model.setPolynomial1(poly1);
                model.setPolynomial2(poly2);
                model.subtract();
                view.showResult(model.getResult());
            } catch (NumberFormatException nfex) {
                view.showError("Bad input: '" + poly1 + "'");
                view.showError("Bad input: '" + poly2 + "'");
            }
        }
    }

}

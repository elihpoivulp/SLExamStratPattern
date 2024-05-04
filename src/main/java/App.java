import entity.State;

import java.text.NumberFormat;
import java.util.*;

public class App {
    private static final boolean ALLOW_INPUT = false; // toggle to use Scanner

    public static void main(String[] args) {
        // store states in a collection so that we can add more states in the future
        Collection<State> states = new ArrayList<>();
        states.add(new State("MN", 6.78));
        states.add(new State("CA", 6.5));
        states.add(new State("NY", 4));
        states.add(new State("NM", 5.125));
        states.add(new State("TX", 6.25));

        try (Scanner scanner = new Scanner(System.in)) {
            double amount;
            if (ALLOW_INPUT) {
                // allow user to input purchase amount
                System.out.print("Enter purchase amount: $");
                amount = scanner.nextDouble();
            } else {
                amount = 523.76;
            }
            NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);

            // compute single state's tax
            // Optional<State> caState = states.stream().filter(s -> s.stateCode().equals("CA")).findFirst();
            // if (caState.isPresent()) {
            //     State california = caState.get();
            //     System.out.printf("Amount: %s\n", currency.format(amount));
            //     System.out.printf("%s's tax rate: %.2f%%\n", california.stateCode(), california.stateTaxRate());
            //     System.out.printf("%s's sales tax: %s\n", california.stateCode(), currency.format(california.computeStateSalesTax(amount)));
            //     System.out.printf("Total: %s\n", currency.format(amount + california.computeStateSalesTax(amount)));
            // }

             // System.out.println();
             // compute each state's tax in the collection
             for (State state : states) {
                 System.out.printf("[%s] ", state.stateCode());
                 System.out.printf("Amount: %s / ", currency.format(amount));
                 System.out.printf("Sales tax: %s", currency.format(state.computeStateSalesTax(amount)));
                 System.out.println();
             }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}

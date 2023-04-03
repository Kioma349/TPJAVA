package FIFO;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FifoTestRunner {
    public static void main(String[] args) {
        // Exécute les tests définis dans la classe FifoTest
        Result result = JUnitCore.runClasses(FifoTest.class);

        // Affiche les échecs, s'il y en a
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Affiche le résultat global des tests
        if (result.wasSuccessful()) {
            System.out.println("Tous les tests ont réussi");
        } else {
            System.out.println("Il y a eu des échecs");
        }
    }
}

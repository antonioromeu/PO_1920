package m19.app.requests;

@SuppressWarnings("nls")
public interface Message {

    static String requestUserId() {
        return "Introduza o número de utente: ";
    }

    static String requestWorkId() {
        return "Introduza o número da obra: ";
    }

    static String showFine(int idUtente, int euros) {
        return "O utente " + idUtente + " deve pagar uma multa de EUR " + euros + ".";
    }

    static String requestFinePaymentChoice() {
        return "O utente deseja pagar multa (s/n)? ";
    }

    static String requestReturnNotificationPreference() {
        return "Deseja ser avisado quando algum exemplar for devolvido (s/n)? ";
    }

    static String workReturnDay(int idWork, int day) {
        return "A obra " + idWork + " deve ser devolvida no dia " + day + ".";
    }

}

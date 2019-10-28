package m19.app.users;

@SuppressWarnings("nls")
public interface Message {

    static String requestUserId() {
        return "Introduza o número de utente: ";
    }

    static String requestUserName() {
        return "Introduza o nome do utente: ";
    }

    static String requestUserEMail() {
        return "Introduza o endereço de correio do utente: ";
    }

    static String userRegistrationSuccessful(int idUser) {
        return "Novo utente criado com o número " + idUser + ".";
    }

}

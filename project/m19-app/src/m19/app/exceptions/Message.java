package m19.app.exceptions;

@SuppressWarnings("nls")
public interface Message {
    
    static String noSuchWork(int idWork) {
        return "A obra " + idWork + " não existe.";
    }

    static String noSuchUser(int idUser) {
        return "O utente " + idUser + " não existe.";
    }

    static String userAlreadyExists() {
        return "O utente já existe.";
    }

    static String userNotSuspended(int idUser) {
        return "O utente " + idUser + " não se encontra suspenso.";
    }

    static String ruleFailed(int idUser, int idWork, int ixRule) {
        return "O utente " + idUser + " não pode requisitar a obra " + idWork + ". Violação da regra " + ixRule + ".";
    }

    static String workNotBorrowedByUser(int idWork, int idUser) {
        return "A obra " + idWork + " não foi requisitada pelo utente " + idUser + ".";
    }

    static String userRegistrationFailed(String name, String email) {
        return "User registration failed: name '" + name + "', email '" + email + "'.";
    }

    static String fileNotFound() {
        return "O ficheiro não existe.";
    }

    static String fileNotFound(String filename) {
        return "O ficheiro '" + filename + "' não existe.";
    }

}

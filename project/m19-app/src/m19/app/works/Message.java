package m19.app.works;

@SuppressWarnings("nls")
public interface Message {

    static String requestWorkId() {
        return "Introduza o número da obra: ";
    }

    static String semExemplares(int idWork) {
        return "A obra " + idWork + " não pode ser requisitada: não há exemplares disponíveis.";
    }

    static String requestSearchTerm() {
        return "Introduza o termo de pesquisa: ";
    }

}

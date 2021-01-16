package jsp;

public class LoginController {

    private static LoginController INSTANCE = null;

    private LoginController() {}

    public static LoginController getInstance() {
        if(INSTANCE==null) {
            INSTANCE = new LoginController();
        }

        return INSTANCE;
    }

    public LoginBean login(String username, String password) {
        // Esegui accesso al DB per verificare se username e password sono corretti
        // Se sono corretti allora restituisci nome e cognome
        LoginBean loginBean;
        if (Math.random() > 0.5) {
            loginBean = new LoginBean();
            loginBean.setNome("Mario");
            loginBean.setCognome("Rossi");
        } else {
            loginBean = null;
        }
        // Altrimenti restituisci null
        return loginBean;

    }
}

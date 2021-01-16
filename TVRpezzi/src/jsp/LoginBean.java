package jsp;

import sun.rmi.runtime.Log;

public class LoginBean {

    private String username;
    private String password;

    private String nome;
    private String cognome;

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public boolean validate() {
        // controllo sintattico
        if (username == null || username == "" || password == null || password == "") {
            return false;
        }

        LoginBean utenteTrovato = LoginController.getInstance().login(username, password);
        /*if(utenteTrovato==null)
            return false;
        return true;*/
        return utenteTrovato != null;

    }

}

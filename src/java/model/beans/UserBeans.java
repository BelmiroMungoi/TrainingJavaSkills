package model.beans;

/**
 *
 * @author Belmiro-Mungoi
 */
public class UserBeans {

    private Integer iduser;
    private String userName;
    private String password;
    private String image;
    private int idade;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdUser() {
        return iduser;
    }

    public void setIdUser(Integer idUser) {
        this.iduser = idUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}

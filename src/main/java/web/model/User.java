package web.model;

import javax.persistence.*;


@Entity
@Table(name = "users")

public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public User(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, String name, String telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public User(String name, String telephone, String role, String password) {
        this(name, telephone);
        this.role = role;
        this.password = password;
    }

    public User(int id, String name, String telephone, String role, String password) {
        this(id, name, telephone);
        this.role = role;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {

    }
}

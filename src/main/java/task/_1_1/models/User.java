package task._1_1.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    public User(String firstName, String lastName, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public User() {
    }
}

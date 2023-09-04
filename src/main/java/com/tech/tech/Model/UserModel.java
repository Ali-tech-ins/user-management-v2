package com.tech.tech.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


//you can change the constraint name, video:  "amigoscode || springData jpa || 44:30"
@Entity//(name="...")
public class UserModel {

    @Id
    @SequenceGenerator(
       name = "userModel_sequence",
       sequenceName = "userModel_sequence",
       allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userModel_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name ;

    @Column(
            name = "email",
            unique = true
    )
    private String email;

    @Column(
            name = "password"
           // nullable = false
    )
    private String password;


    //add getters and setters
  @OneToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adress adress;

   /**@ManyToOne
   private Adress adress;*/

   /**@ManyToMany(cascade = CascadeType.ALL)
   private List<Adress> adresses;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}

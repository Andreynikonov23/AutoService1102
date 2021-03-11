package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NonNull
    private int id;
    @Column (name = "Firstname")
    @NonNull
    private String firstname;
    @Column (name = "Lastname")
    @NonNull
    private String lastname;
    @Column (name = "Patronymic")
    private String patronymic;
    @Column (name = "Birthday")
    private Date birthday;
    @Column (name = "RegistrationDate")
    @NonNull
    private Date registrationDate;
    @Column (name = "Email")
    private String email;
    @Column (name = "Phone")
    @NonNull
    private String phone;
    @Column (name = "PhotoPath")
    private String photoPath;
    @Column (name = "")



    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "GenderCode")
    private Gender gender;

    @OneToMany (mappedBy = "client")
    Set<ClientService> clientServiceSet;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", gender=" + gender +
                '}';
    }
}

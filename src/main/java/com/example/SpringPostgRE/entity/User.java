package com.example.SpringPostgRE.entity;
import jakarta.persistence.*;
import lombok.*;
<<<<<<< HEAD
import org.hibernate.annotations.CacheConcurrencyStrategy;

=======
>>>>>>> origin/master
import java.util.List;
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
@Data
<<<<<<< HEAD
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
=======
>>>>>>> origin/master
public class User {
    @Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1)
    @GeneratedValue(generator ="seq_kisi",strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(length =100,name = "name")
    private String name;
    @Column(length = 100,name="surName")
    private String surName;

    @OneToMany
    @JoinColumn(name = "user_adress_id")
    private List<Adress> adresses;

}

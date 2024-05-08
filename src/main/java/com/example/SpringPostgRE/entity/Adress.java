package com.example.SpringPostgRE.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user_adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adress implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_adress", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_adress", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name = "adress")
    private String adresses;

    @Enumerated
    private AdresTip adresTip;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_adress_id")
    private User user;

    public enum AdresTip {
        HOM_ADRESS,
        COMPANY_ADRESS,
        OTHER
    }
}
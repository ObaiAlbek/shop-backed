package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String telefon;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id")
    private Adresse anschrift;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kreditkarte_id")
    private Kreditkarteninformation kreditkarte;

    @OneToMany(mappedBy = "kunde")
    private List<Rechnung> rechnungen;
}

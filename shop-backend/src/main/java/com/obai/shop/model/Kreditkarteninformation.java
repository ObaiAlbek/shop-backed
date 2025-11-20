package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kreditkarteninformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nummer;
    private String inhaber;

    @Enumerated(EnumType.STRING)
    private Zahlungsart kartenTyp;
}

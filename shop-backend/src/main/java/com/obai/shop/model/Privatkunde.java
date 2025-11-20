package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Privatkunde extends Kunde {

    private String vorname;
    private String nachname;
}

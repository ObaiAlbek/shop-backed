package com.obai.shop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Geschaeftskunde extends Kunde {

    private String firmenname;
    private String ustId;

    public Geschaeftskunde(String firmenname, String ustId) {
        this.firmenname = firmenname;
        this.ustId = ustId;
    }
}

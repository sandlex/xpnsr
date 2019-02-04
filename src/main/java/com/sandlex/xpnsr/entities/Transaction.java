package com.sandlex.xpnsr.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 *
 */
@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity {

    private LocalDate registered;
    private String hash;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "group")
    private Group group;

    // Other fields

}

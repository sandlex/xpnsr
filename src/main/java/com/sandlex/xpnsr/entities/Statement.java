package com.sandlex.xpnsr.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 *
 */
@Entity
@Table(name = "statements")
public class Statement extends BaseEntity {

    private LocalDate created;

    private byte[] content;
}

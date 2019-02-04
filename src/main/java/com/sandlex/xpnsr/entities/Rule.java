package com.sandlex.xpnsr.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "rules")
public class Rule extends BaseEntity {

    private String rule;
}

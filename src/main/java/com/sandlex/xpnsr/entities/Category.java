package com.sandlex.xpnsr.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    private String name;
}

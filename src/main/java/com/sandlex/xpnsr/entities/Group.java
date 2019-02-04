package com.sandlex.xpnsr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 *
 */
@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    @Column(name = "name")
    private String name;

    @
    private Statement statement;

    @OneToMany
    @JoinColumn(name = "id")
    private Set<Rule> rules;

    @OneToMany
    @JoinColumn(name = "id")
    private Set<Category> categories;
}

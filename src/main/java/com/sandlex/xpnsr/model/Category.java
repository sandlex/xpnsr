package com.sandlex.xpnsr.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Category {

    private String name;
    private List<Rule> rules;

}

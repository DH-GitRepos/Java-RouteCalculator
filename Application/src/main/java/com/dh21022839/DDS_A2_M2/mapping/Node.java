package com.dh21022839.DDS_A2_M2.mapping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Node {

    private String name;
    private Double coordinateX;
    private Double coordinateY;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals(name, node.name);
    }

    // return object name
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // return value rather than reference
    @Override
    public String toString() {
        return name;
    }

}
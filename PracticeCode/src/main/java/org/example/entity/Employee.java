package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Employee {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    private long salary;
    private Department department;
    private Designation designation;
    private String city;

}

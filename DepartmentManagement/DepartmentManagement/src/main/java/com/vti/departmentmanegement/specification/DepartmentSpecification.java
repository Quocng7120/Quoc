package com.vti.departmentmanegement.specification;

import com.vti.departmentmanegement.entity.Department;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

public class DepartmentSpecification implements Specification<Department> {

    private String field;
    private String operator;
    private Object value;

    public DepartmentSpecification(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if(operator.equalsIgnoreCase("LIKE")) {
            if (field.equalsIgnoreCase("author.fullName")) {
                return builder.like(root.get("author").get("fullName"), "%" + value.toString() + "%");
            } else {
                return builder.like(root.get(field), "%" + value.toString() + "%");
            }
        }
        if (operator.equalsIgnoreCase(">=")){
            if (value instanceof Date) {

                return builder.greaterThanOrEqualTo(root.get(field), (Date) value);
            }
        }
        if (operator.equalsIgnoreCase("<=")){
            if (value instanceof Date) {
                Date now = (Date) value;
                now = new Date(now.getTime() + (1000*60*60*24));
                return builder.lessThan(root.get(field), now);
            }
        }
        return null;
    }
}

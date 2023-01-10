package com.explicit.explicit99.Repository;

import com.explicit.explicit99.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}

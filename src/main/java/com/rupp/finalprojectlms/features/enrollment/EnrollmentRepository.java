package com.rupp.finalprojectlms.features.enrollment;

import com.rupp.finalprojectlms.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    Optional<Enrollment> findById(Long id);


}

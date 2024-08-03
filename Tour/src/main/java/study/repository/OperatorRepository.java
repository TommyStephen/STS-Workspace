package study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import study.model.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {

}

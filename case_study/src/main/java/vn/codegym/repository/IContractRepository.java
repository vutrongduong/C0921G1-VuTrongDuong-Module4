package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Contract;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
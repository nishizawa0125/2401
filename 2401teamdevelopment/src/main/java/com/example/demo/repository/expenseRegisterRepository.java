package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.expenseRegisterEntity;
/**
 * ユーザー情報 Repository
 */
@Repository
public interface expenseRegisterRepository extends JpaRepository<expenseRegisterEntity, Long> {

	
}
	
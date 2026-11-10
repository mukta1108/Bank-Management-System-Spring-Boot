package com.app.MyFirstProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.MyFirstProject.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	

}

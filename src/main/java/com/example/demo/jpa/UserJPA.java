package com.example.demo.jpa;

import java.io.Serializable;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserJPA extends JpaRepository<User, Long>,
		JpaSpecificationExecutor<User>,
		Serializable{

	@Query(value = "select * from t_user where t_name = ?",nativeQuery = true)
	User queryByName(String name);

	@Modifying
	@Query(value = "UPDATE  t_user set t_name = 'ym' WHERE t_id = ? ",nativeQuery = true)
	Integer modifyById(Long id);

	User findByName(String name);

	User findByNameAndPwd(String name,String pwd);
}

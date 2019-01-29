package com.consulting.repositories;

import com.consulting.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	/*@Query("select u from UserRoles u where u.user.id=:user")
	List<UserRoles> getAllUsersByUserId(@Param("user") Long user);
	
	@Transactional
	@Modifying
	@Query("delete from UserRoles l where l.user.id =:user")
	void deleteUser(@Param("user") Long user);*/
}

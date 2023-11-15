package com.asma.users.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.asma.users.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	   @Query("select r from Role r where r.role = ?1")
	    Role findByRole(String role);

	    List<Role> findAll();

	    @Query("select r from Role r where r.role_id = ?1")
	    Role findRoleById(Long id);
	    

@Modifying
@Query("DELETE FROM Role u WHERE u.role_id = :roleId")
void deleteByRoleId(@Param("roleId") Long roleId);

}
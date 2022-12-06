/**
 * 
 */
package com.zillionsoftech.org.services;

import java.util.Optional;

import com.zillionsoftech.org.entities.Roles;
import com.zillionsoftech.org.entities.Users;
import javassist.NotFoundException;

/**
 * @author sandeep.rana
 *
 */
public interface UsersService {

	/**
	 * Sign up the users ... 
	 * @param user request payload ... 
	 * @return
	 */
	Users signUp(Users user);

	Optional<Users> findByUserId(String userName);

	Roles getRole(String roleId) throws NotFoundException;

}

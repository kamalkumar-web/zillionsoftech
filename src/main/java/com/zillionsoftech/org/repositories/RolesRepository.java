/**
 * 
 */
package com.zillionsoftech.org.repositories;

import com.zillionsoftech.org.entities.Roles;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
/**
 * @author sandeep.rana
 *
 */
@Repository
public interface RolesRepository extends PagingAndSortingRepository<Roles, String> {

}

package com.dairyapplication.dairyApplication.repository;

import com.dairyapplication.dairyApplication.entity.OwnerRegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRegistrationDetailsRepository extends JpaRepository<OwnerRegistrationDetails,Long> {
    @Query(value = "SELECT * FROM owner_registration_details o WHERE o.owner_unique_Id = ?1",nativeQuery = true)
    OwnerRegistrationDetails findByOwnerUniqueId( String owneruniqueId);

    @Query(value = "SELECT * FROM owner_registration_details WHERE mobile_number = :mobileNumber", nativeQuery = true)
    OwnerRegistrationDetails findByOwnermobileNumber(@Param("mobileNumber") String mobileNumber);

    //@Query(value = "SELECT CASE WHEN EXISTS (SELECT 1 FROM owner_registration_details WHERE email_id = :emailId) THEN TRUE ELSE FALSE END", nativeQuery = true)
    OwnerRegistrationDetails findByEmailId( String emailId);

//    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM owner_registration_details WHERE user_name = :username", nativeQuery = true)
//    boolean existsByUsername(@Param("username") String username);

}

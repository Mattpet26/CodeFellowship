package com.petersen.CodeFellowship.models.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
//     findBy is the key, and Username
//     if i work within the bounds of acceptable requests / straightforward ones,
//     jpa knows how to write something as simple as 'SELECT * FROM codefellowship WHERE username=1'
}

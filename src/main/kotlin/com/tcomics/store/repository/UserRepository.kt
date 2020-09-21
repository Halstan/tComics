package com.tcomics.store.repository

import com.tcomics.store.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long>{

    fun getUserByEmail(email: String): User

}
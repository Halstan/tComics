package com.tcomics.store.service

import com.tcomics.store.entity.User
import com.tcomics.store.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class UserService constructor(
        @Autowired
        val userRepository: UserRepository
    ){

    fun findAll(): List<User>{
        return this.userRepository.findAll()
    }

    fun addUser(user: User): User{
        return this.userRepository.save(user)
    }

    fun updateUser(user: User): User{
        return this.userRepository.save(user)
    }

    fun findUserById(idUser: Long): Optional<User> {
        return this.userRepository.findById(idUser)
    }

    fun deleteUser(idUser: Long){
        this.userRepository.deleteById(idUser)
    }

}
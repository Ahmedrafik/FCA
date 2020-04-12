package org.fca.rsapi.controller

import org.fca.rsapi.helpers.UserHelper
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/posts")
class PostsController (private val userRepository: UserRepository) {

    @GetMapping("/")
    fun getAllPost(): List<Userfca> =
            userRepository.findAll()


    @PostMapping("/")
    fun createNewUser(@Valid @RequestBody user: Userfca): Userfca =
            userRepository.save(user)

    @PutMapping("/validuser/{id}")
    fun validUser(@PathVariable(value = "id") userId: Long): Userfca {
        val userList = userRepository.findAll()
        val user: Userfca = userRepository.findById(userId).get()
        var accessToken = ""
        while(accessToken.isEmpty() || UserHelper.containsAccessToken(userList, accessToken)){
            accessToken = UserHelper.generateRandomToken()
        }
        user.accessToken = accessToken

        return userRepository.save(user)


    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<Userfca> {
        return userRepository.findById(userId).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/getuser")
    fun getUserByLogin(@Valid @RequestBody user: Userfca): Userfca? {
        var resUser : Userfca? = null
        val userList = userRepository.findAll()
        for(crtUser in userList){
            if(user.login == crtUser.login && user.pass == crtUser.pass){
                resUser = crtUser
                resUser.pass = null
                break
            }
        }
        if (resUser == null) {
            throw Exception("Le login/pass entré ne correspondent à aucun utilisateur validé.")
        }
        return resUser
    }

    @PostMapping("/verifyToken")
    fun getUserByToken(@Valid @RequestBody token: String): Userfca? {
        var resUser : Userfca? = null
        val userList = userRepository.findAll()
        for(crtUser in userList){
            if(token == crtUser.accessToken){
                resUser = crtUser
                resUser.pass = null
                break
            }
        }
        if (resUser == null) {
            throw Exception("Le token entré ne correspondent à aucun utilisateur validé.")
        }
        return resUser
    }



    @DeleteMapping("/users/{id}")
    fun deleteUserById(@PathVariable(value = "id") userId: Long): ResponseEntity<Void> {

        return userRepository.findById(userId).map { user  ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
    
}

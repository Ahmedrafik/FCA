package org.fca.rsapi.controller

import org.fca.rsapi.dto.UserfcaDTO
import org.fca.rsapi.exception.NotFoundException
import org.fca.rsapi.helpers.UserHelper
import org.fca.rsapi.model.Userfca
import org.fca.rsapi.repository.UserRepository
import org.fca.rsapi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
class UserController(private val userRepository: UserRepository, private val userService: UserService) {

    @GetMapping("/")
    fun getAll(): List<Userfca> =
            userRepository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable(value = "id") id: Long): ResponseEntity<Userfca> {
        return userRepository.findById(id).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/")
    fun createNew(@Valid @RequestBody userfcaDTO: UserfcaDTO): ResponseEntity<Userfca> {
        return ResponseEntity.ok(userService.save(userfcaDTO))
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long,
                   @Valid @RequestBody new: Userfca): ResponseEntity<Userfca> {
        return userRepository.findById(id).map { existing ->
            val updated: Userfca = existing
                    .copy(login = new.login, email = new.email, pass = new.pass, firstname = new.firstname, lastname = new.lastname)
            ResponseEntity.ok().body(userRepository.save(updated))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> {
        return userRepository.findById(id).map { user  ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/validuser/{id}")
    fun validUser(@PathVariable(value = "id") id: Long): Userfca {
        val userList = userRepository.findAll()
        val user: Userfca = userRepository.findById(id).get()
        var accessToken = ""
        while(accessToken.isEmpty() || UserHelper.containsAccessToken(userList, accessToken)){
            accessToken = UserHelper.generateRandomToken()
        }
        user.accessToken = accessToken
        return userRepository.save(user)
    }

    @PostMapping("/verifyAccess")
    fun getUserByLogin(@Valid @RequestBody user: UserfcaDTO): ResponseEntity<*>? {
        //{"login": "blackWidow","pass": "blackWidow"} in param
        var resUser : Userfca? = null
        var response : ResponseEntity<*>? = null
        val userList = userRepository.findAll()
        for(crtUser in userList){
            if(user.login == crtUser.login && user.pass == crtUser.pass && crtUser.accessToken != null){
                resUser = crtUser
                resUser.pass = null
                response = ResponseEntity.ok(crtUser)
                break
            }
        }
        if (resUser == null) {
            throw NotFoundException("Le login/pass entré ne correspondent à aucun utilisateur validé.")
        }
        return response
    }

    @GetMapping("/verifyToken")
    fun getUserByToken(@Valid @RequestBody token: String): Userfca? {
        //{"token":"0a09b1b18bd4414198c2924049f59f06"} in param
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
            throw NotFoundException("Le token entré ne correspondent à aucun utilisateur validé.")
        }
        return resUser
    }

}

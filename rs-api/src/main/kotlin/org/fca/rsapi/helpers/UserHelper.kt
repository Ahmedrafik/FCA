package org.fca.rsapi.helpers

import org.fca.rsapi.model.Userfca
import java.util.*

class UserHelper {

    companion object{
        fun generateRandomToken(): String{
            return UUID.randomUUID().toString().replace("-", "")
        }

        fun containsAccessToken(userList: List<Userfca>, accessToken: String): Boolean{
            var contain = false
            for(user in userList){
                if(accessToken == user.accessToken){
                    contain = true
                    break
                }
            }
            return contain
        }
    }

}
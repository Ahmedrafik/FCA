package org.fca.rsapi.repository

import org.fca.rsapi.model.Userfca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostsRepository : JpaRepository<Userfca, Long>
package org.fca.rsapi.repository

import org.fca.rsapi.model.Picture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PictureRepository : JpaRepository<Picture, Long>
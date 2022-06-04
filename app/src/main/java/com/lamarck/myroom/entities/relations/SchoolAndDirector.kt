package com.lamarck.myroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lamarck.myroom.entities.Director
import com.lamarck.myroom.entities.School

data class SchoolAndDirector(
    @Embedded  val School: School,
    @Relation(
        parentColumn = "schollName",
        entityColumn = "schoolName"
    )
    val director: Director
)
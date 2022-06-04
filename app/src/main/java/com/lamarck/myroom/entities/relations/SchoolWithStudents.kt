package com.lamarck.myroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lamarck.myroom.entities.School
import com.lamarck.myroom.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val student: List<Student>
)
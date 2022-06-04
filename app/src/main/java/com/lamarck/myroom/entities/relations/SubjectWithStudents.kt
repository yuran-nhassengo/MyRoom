package com.lamarck.myroom.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lamarck.myroom.entities.Student
import com.lamarck.myroom.entities.Subject

data class SubjectWithStudents (

    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Student>
)

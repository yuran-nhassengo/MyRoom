package com.lamarck.myroom

import androidx.room.*
import com.lamarck.myroom.entities.Director
import com.lamarck.myroom.entities.School
import com.lamarck.myroom.entities.Student
import com.lamarck.myroom.entities.Subject
import com.lamarck.myroom.entities.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName : String ): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun  getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName= :subjectName")
    suspend fun getStudentsOfSubject(subjectName : String ): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName= :studentName")
    suspend fun getSubjectsOfStudents(studentName : String ): List<StudentWithSubjects>


}
package com.example.classroommanagement.domain.models

data class BuildingWithClassrooms(
    val buildingName: String,
    val classrooms: List<Classroom>
)

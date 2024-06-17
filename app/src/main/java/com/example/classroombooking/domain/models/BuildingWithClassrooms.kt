package com.example.classroombooking.domain.models

data class BuildingWithClassrooms(
    val buildingName: String,
    val classrooms: List<Classroom>
)

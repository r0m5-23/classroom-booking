package com.example.network.response.dtos

import kotlinx.serialization.Serializable

@Serializable
data class EventDto(
    val id: Int? = null,
    val name: String? = null,
    val code: String? = null,
    val startTime: String? = null,
    val endTime: String? = null,
    val duration: String? = null,
    val day: Int? = null, //Ver Enum
    val eventType: EventTypeDto? = null,
    val numStudents: Int? = null,
    val wlsSectionName: String? = null,
    val wlsSectionConnector: String? = null,
    val annotations: String? = null,
    val isOwner: Boolean? = null,
    val unit: String? = null,
    val weeks: List<WeekDto>? = emptyList(),
    val classrooms: List<ClassroomDto>? = emptyList(),
    val usersEventRole: List<UserEventRoleDto>? = emptyList(),
    val studentGroups: List<StudentGroupDto> ? = emptyList(),
    val teachers: List<TeacherDto> ? = emptyList(),
    val module: ModuleDto? = null,
    val typologies: List<TypologyDto> ? = emptyList(),
    val academicYear: AcademicYearDto? = null,
    val thirdPartyEventClient: ThirdPartyEventClientDto? = null,
    val eventCompensationEvent: List<EventCompensationEventDto> ? = emptyList(),
    val eventUserLocked: EventUserLockedDto? = null,
    val eventBookingTicketEvent: EventBookingTicketEventDto? = null,
    val eventAcademicTicketEvent: EventAcademicTicketEventDto? = null,
    val createdBy: String? = null,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: String? = null,
    val createdAt: String? = null
    )

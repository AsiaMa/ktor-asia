package com.asia.repository.entity

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ResultRow

object UserTable : IntIdTable("users") {
    val coreId: Column<Int> = integer("core_id").default(0)
    val username: Column<String> = varchar("username", 64)
    val email: Column<String> = varchar("email", 64)
    val lastLoginDate: Column<Int> = integer("last_login_date").default(0)
    val firstname: Column<String> = varchar("firstname", 32).default("")
    val firstnamePinyin: Column<String> = varchar("firstname_pinyin", 128).default("")
    val lastname: Column<String> = varchar("lastname", 32).default("")
    val lastnamePinyin: Column<String> = varchar("lastname_pinyin", 128).default("")
    val tel: Column<String> = varchar("tel", 32).default("")
    val sysPerm: Column<Int> = integer("sysperm").default(0)
    val perf: Column<Int> = integer("perf").default(0)
    val enabled: Column<Int> = integer("enabled").default(1)
    val teamId: Column<Int?> = integer("team_id").nullable()
    val businessTeamId: Column<Int?> = integer("business_team_id").nullable()
    val supervisorId: Column<Int?> = integer("supervisor_id").nullable()
    val dateJoined: Column<Int> = integer("date_joined").default(0)
    val dateGraduated: Column<Int> = integer("date_graduated").default(0)
    val dateQuit: Column<Int> = integer("date_quit").default(0)
    val companyId: Column<String> = varchar("company_id", 16).default("")
    val attendanceId: Column<String> = varchar("attendance_id", 16).default("")
    val isInternship: Column<Short> = short("is_internship").default(-1)
    val dateStarted: Column<Int> = integer("date_started").default(0)
    val fullName: Column<String> = varchar("fullname", 64).default("")
    val isGuest: Column<Short> = short("is_guest").default(0)
    val dingTalk: Column<String?> = varchar("dingtalk", 64).nullable()
    val firstSchedule: Column<Int> = integer("first_schedule").default(1)
    val isAbsent: Column<Int> = integer("is_absent").default(-1)
    val fullNameFirstLetter: Column<String> = varchar("fullname_first_letter", 64)
    val createAt: Column<Int> = integer("create_at")
    val avatar: Column<String?> = varchar("avatar", 256).nullable()
    val director: Column<Int> = integer("director").default(0)
    val sex: Column<Short> = short("sex").default(0)
    val jobStatus: Column<Short> = short("job_status").default(-1)
    val employeeStatus: Column<Short> = short("employeeStatus").default(-1)
    val assetStatus: Column<Short> = short("assert_status").default(1)
    val emailStatus: Column<Short> = short("short_status").default(0)
    val itStatus: Column<Short> = short("it_status").default(0)
    val toCompanyTime: Column<Int> = integer("to_company_time").default(0)
    val createdUid: Column<Int> = integer("created_uid").default(0)
    val cancelJoin: Column<Byte> = byte("cancel_join").default(0)
    val hrbpUid: Column<Int> = integer("hrbp_uid").default(0)
    val baseInfo: Column<Int?> = integer("baseInfo").nullable()
    val staffJoinNotice: Column<Int> = integer("staffJoinNotice")
    val sysPermSecond: Column<Int> = integer("sysperm_second").default(0)
    val feishu: Column<String?> = varchar("feishu", 20).nullable()
}

data class UserEntity(
    val coreId: Int,
    val username: String,
    val email: String,
    val lastLoginDate: Int,
    val firstname: String,
    val firstnamePinyin: String,
    val lastname: String,
    val lastnamePinyin: String,
    val tel: String,
    val sysPerm: Int,
    val perf: Int,
    val enabled: Int,
    val teamId: Int?,
    val businessTeamId: Int?,
    val supervisorId: Int?,
    val dateJoined: Int,
    val dateGraduated: Int,
    val dateQuit: Int,
    val companyId: String,
    val attendanceId: String,
    val isInternship: Short,
    val dateStarted: Int,
    val fullName: String,
    val isGuest: Short,
    val dingTalk: String?,
    val firstSchedule: Int,
    val isAbsent: Int,
    val fullNameFirstLetter: String,
    val createAt: Int,
    val avatar: String?,
    val director: Int,
    val sex: Short,
    val jobStatus: Short,
    val employeeStatus: Short,
    val assetStatus: Short,
    val emailStatus: Short,
    val itStatus: Short,
    val toCompanyTime: Int,
    val createdUid: Int,
    val cancelJoin: Byte,
    val hrbpUid: Int,
    val baseInfo: Int?,
    val staffJoinNotice: Int,
    val sysPermSecond: Int,
    val feishu: String?
) {
    companion object {
        fun fromResultRow(resultRow: ResultRow) = UserEntity(
            coreId = resultRow[UserTable.coreId],
            username = resultRow[UserTable.username],
            email = resultRow[UserTable.email],
            lastLoginDate = resultRow[UserTable.lastLoginDate],
            firstname = resultRow[UserTable.firstname],
            firstnamePinyin = resultRow[UserTable.firstnamePinyin],
            lastname = resultRow[UserTable.lastname],
            lastnamePinyin = resultRow[UserTable.lastnamePinyin],
            tel = resultRow[UserTable.tel],
            sysPerm = resultRow[UserTable.sysPerm],
            perf = resultRow[UserTable.perf],
            enabled = resultRow[UserTable.enabled],
            teamId = resultRow.getOrNull(UserTable.teamId),
            businessTeamId = resultRow.getOrNull(UserTable.businessTeamId),
            supervisorId = resultRow.getOrNull(UserTable.supervisorId),
            dateJoined = resultRow[UserTable.dateJoined],
            dateGraduated = resultRow[UserTable.dateGraduated],
            dateQuit = resultRow[UserTable.dateQuit],
            companyId = resultRow[UserTable.companyId],
            attendanceId = resultRow[UserTable.attendanceId],
            isInternship = resultRow[UserTable.isInternship],
            dateStarted = resultRow[UserTable.dateStarted],
            fullName = resultRow[UserTable.fullName],
            isGuest = resultRow[UserTable.isGuest],
            dingTalk = resultRow.getOrNull(UserTable.dingTalk),
            firstSchedule = resultRow[UserTable.firstSchedule],
            isAbsent = resultRow[UserTable.isAbsent],
            fullNameFirstLetter = resultRow[UserTable.fullNameFirstLetter],
            createAt = resultRow[UserTable.createAt],
            avatar = resultRow.getOrNull(UserTable.avatar),
            director = resultRow[UserTable.director],
            sex = resultRow[UserTable.sex],
            jobStatus = resultRow[UserTable.jobStatus],
            employeeStatus = resultRow[UserTable.employeeStatus],
            assetStatus = resultRow[UserTable.assetStatus],
            emailStatus = resultRow[UserTable.emailStatus],
            itStatus = resultRow[UserTable.itStatus],
            toCompanyTime = resultRow[UserTable.toCompanyTime],
            createdUid = resultRow[UserTable.createdUid],
            cancelJoin = resultRow[UserTable.cancelJoin],
            hrbpUid = resultRow[UserTable.hrbpUid],
            baseInfo = resultRow[UserTable.baseInfo],
            staffJoinNotice = resultRow[UserTable.staffJoinNotice],
            sysPermSecond = resultRow[UserTable.sysPermSecond],
            feishu = resultRow.getOrNull(UserTable.feishu),
        )
    }
}
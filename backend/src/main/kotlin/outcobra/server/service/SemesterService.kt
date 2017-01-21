package outcobra.server.service

import outcobra.server.model.Semester
import outcobra.server.model.dto.SemesterDto
import outcobra.server.service.base.BaseService

/**
 * Service which handles the business logic and data for [Semester]s
 *
 * @author Florian Bürgi
 * @since 1.0.0
 */
interface SemesterService : BaseService<SemesterDto> {

    /**
     * Reads all semesters that are associated with a specific SchoolYear
     * @param schoolYearId The id of the SchoolYear of which to retrieve all semesters
     * @return All semesters that are associated with the given SchoolYear
     */
    fun readAllSemestersBySchoolYear(schoolYearId: Long): List<SemesterDto>

    /**
     * Updates an existing semester
     * @param semesterDto The SemesterDto to update the existing semester with
     * @return The updated Semester from the database
     */

    fun getCurrentSemester(): List<SemesterDto>
}
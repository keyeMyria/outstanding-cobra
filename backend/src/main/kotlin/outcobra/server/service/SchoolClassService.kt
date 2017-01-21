package outcobra.server.service

import outcobra.server.model.Institution
import outcobra.server.model.SchoolClass
import outcobra.server.model.dto.SchoolClassDto
import outcobra.server.service.base.BaseService

/**
 * This interface defines all functions for a SchoolClass service
 * @author Florian Bürgi
 * @since 1.0.0
 */
interface SchoolClassService : BaseService<SchoolClassDto> {

    /**
     * Reads all [SchoolClass]es that are associated with a specific [Institution]
     * @param institutionId The id of the [Institution] of which the [SchoolClass]es should be read
     * @return a list of [SchoolClassDto]s
     */
    fun readAllSchoolClassesByInstitution(institutionId: Long): List<SchoolClassDto>

    /**
     * This function deletes a [SchoolClass]
     * @param id the id of the SchoolClass you want to delete
     */

    fun readAllSchoolClassesByUser(): List<SchoolClassDto>
}
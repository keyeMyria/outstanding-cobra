package outcobra.server.service.internal

/**
 * Created by Florian on 27.11.2016.
 */

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import outcobra.server.model.QInstitution
import outcobra.server.model.dto.manage.ManageDto
import outcobra.server.model.mapper.manage.ManageDtoMapper
import outcobra.server.model.repository.InstitutionRepository
import outcobra.server.service.ManageService
import outcobra.server.service.UserService
import javax.inject.Inject

@Primary
@Service
open class DataManageService @Inject constructor(val institutionRepository: InstitutionRepository,
                                                 val userService: UserService,
                                                 val manageDtoMapper: ManageDtoMapper) : ManageService {
    override fun getManageData(): ManageDto {
        val institutions = institutionRepository.findAll(QInstitution.institution.user.id.eq(userService.getCurrentUser().id)).toList()
        return manageDtoMapper.toDto(institutions)
    }

}

package outcobra.server.model.dto

import outcobra.server.model.mapper.MappableDto
import outcobra.server.model.Teacher
import outcobra.server.model.mapper.Mapper

/**
 * Created by Florian on 04.11.2016.
 */
class TeacherDto : MappableDto<TeacherDto, Teacher> {
    override fun getMapper(): Mapper<TeacherDto, Teacher> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun toEntity(): Teacher {
        throw UnsupportedOperationException("not implemented")
    }
//TODO Implement
}
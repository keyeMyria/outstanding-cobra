package outcobra.server.model.dto

import outcobra.server.model.mapper.MappableDto
import outcobra.server.model.MarkReport
import outcobra.server.model.mapper.Mapper

/**
 * Created by Florian on 04.11.2016.
 */
class MarkReportDto : MappableDto<MarkReportDto, MarkReport> {
    override fun getMapper(): Mapper<MarkReportDto, MarkReport> {
        throw UnsupportedOperationException("not implemented")
    }

    override fun toEntity(): MarkReport {
        throw UnsupportedOperationException("not implemented")
    }
//TODO Implement
}
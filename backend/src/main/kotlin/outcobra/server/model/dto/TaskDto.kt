package outcobra.server.model.dto

import outcobra.server.model.Subject
import outcobra.server.model.interfaces.OutcobraDto
import outcobra.server.model.interfaces.ParentLink
import java.time.LocalDate

/**
 * @author Vincent Perret
 */
data class TaskDto(
        val id: Long = 0,
        val subject: SubjectDto = SubjectDto(),
        val name: String = "",
        val description: String,
        val todoDate: LocalDate,
        val dueDate: LocalDate,
        val effort: Int,
        val progress: Int) : OutcobraDto {

    override fun getIdentifier(): Long = id

    override fun getParentLink(): ParentLink = ParentLink.make(subject.id, Subject::class.java)

}
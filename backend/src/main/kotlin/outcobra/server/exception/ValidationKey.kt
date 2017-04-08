package outcobra.server.exception

/**
 * Contains errors and their i18n-Key for the client
 * mostly validation errors or things like "not found" etc.
 *
 * @author Florian Bürgi
 * @since <since>
 */
enum class ValidationKey(val i18nMessage: String = "i18n.error.http.500.message",
                         val i18nTitle: String = "i18n.error.http.500.title") : ValidationExceptionThrower {


    SERVER_ERROR(),
    SCHOOL_YEAR_OVERLAP("i18n.modules.manage.schoolYear.error.overlap", "i18n.error.http.400.title"),
    ID_NOT_FOUND("i18n.error.http.404.message", "i18n.error.http.404.title"),
    INVALID_DTO("i18n.error.http.400.message", "i18n.error.http.400.title"),
    START_BIGGER_THAN_END("i18n.common.form.error.dateToIsBeforeDateFrom", "i18n.error.http.400.title"),
    FORBIDDEN("i18n.error.http.403.message", "i18n.error.http.403.title"),
    SEMESTER_OVERLAP("i18n.modules.manage.semester.error.overlap", "i18n.error.http.400.title"),
    OUTSIDE_PARENT("i18n.error.outsideParent.message", "i18n.error.outsideParent.title");


    override fun throwException() {
        throw(makeException(this.i18nMessage, this.i18nTitle, null, null))
    }

    override fun makeException(message: String, title: String, messageLevel: MessageLevel?,
                               nestedCause: Throwable?): ValidationException {

        val e = ValidationException(message = message, title = title)
        if (messageLevel != null) {
            e.messageLevel = messageLevel
        }
        if (nestedCause != null) {
            e.cause = nestedCause
        }
        return e
    }

    fun makeException(): ValidationException {
        return makeException(i18nMessage, i18nTitle, null, null)
    }

}

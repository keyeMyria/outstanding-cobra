package outcobra.server.exception


/**
 * This interface defines all functions that are used to throw our ValidationExceptions
 * @author Florian Bürgi
 * @since <since>
 */
interface ValidationExceptionThrower {
    fun throwException(): Unit
    fun makeException(message: String,
                      title: String,
                      messageLevel: MessageLevel?,
                      nestedCause: Throwable?): ValidationException
}
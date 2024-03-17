package sh.christian.ozone.api.response

import kotlinx.serialization.Serializable

/**
 * Description of an unsuccessful response.
 *
 * The error type should map to an error name defined in the endpoint's Lexicon schema. This enables more specific
 * error-handling by client software. This is particularly encouraged on `400`, `500`, and `502` status codes, where
 * further information will be useful.
 */
@Serializable
data class AtpErrorDescription(
  /**
   * Type name of the error (generic ASCII constant, no whitespace).
   */
  val error: String,
  /**
   * Description of the error, appropriate for display to humans.
   */
  val message: String?,
)

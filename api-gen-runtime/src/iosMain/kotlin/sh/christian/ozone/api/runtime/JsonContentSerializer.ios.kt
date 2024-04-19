@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package sh.christian.ozone.api.runtime

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonUnquotedLiteral
import sh.christian.ozone.api.model.JsonContent

actual object JsonContentSerializer : KSerializer<JsonContent> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("JsonContent", PrimitiveKind.STRING)

  override fun deserialize(decoder: Decoder): JsonContent {
    decoder as JsonDecoder
    return JsonContent(decoder.decodeJsonElement().toString())
  }

  @OptIn(ExperimentalSerializationApi::class)
  override fun serialize(encoder: Encoder, value: JsonContent) {
    encoder as JsonEncoder
    encoder.encodeJsonElement(JsonUnquotedLiteral(value.value))
  }
}

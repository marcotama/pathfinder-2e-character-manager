package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ancestry_language", schema = "public", catalog = "charactermanager")
@IdClass(AncestryLanguageEntityPK::class)
class AncestryLanguageEntity {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ancestry_id")
    lateinit var ancestry: AncestryEntity

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    lateinit var language: LanguageEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AncestryLanguageEntity
        return ancestry == that.ancestry &&
                language == that.language
    }

    override fun hashCode(): Int {
        return Objects.hash(ancestry, language)
    }
}
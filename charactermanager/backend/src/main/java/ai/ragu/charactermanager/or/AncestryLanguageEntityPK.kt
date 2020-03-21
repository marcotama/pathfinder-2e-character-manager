package ai.ragu.charactermanager.or

import java.io.Serializable
import java.util.*
import javax.persistence.*

class AncestryLanguageEntityPK : Serializable {
    @Id
    @Column(name = "ancestry_id", nullable = false, length = -1)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ancestry_id")
    lateinit var ancestry: AncestryEntity

    @Id
    @Column(name = "language_id", nullable = false, length = -1)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    lateinit var language: LanguageEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AncestryLanguageEntityPK
        return ancestry == that.ancestry &&
                language == that.language
    }

    override fun hashCode(): Int {
        return Objects.hash(ancestry, language)
    }
}
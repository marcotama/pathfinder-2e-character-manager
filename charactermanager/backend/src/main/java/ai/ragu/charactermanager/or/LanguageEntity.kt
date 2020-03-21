package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "language", schema = "public", catalog = "charactermanager")
class LanguageEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @Column(name = "spoken_by", nullable = false, length = -1)
    lateinit var spokenBy: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    lateinit var category: LanguageCategoryEntity

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as LanguageEntity
        return id == that.id &&
                name == that.name &&
                spokenBy == that.spokenBy &&
                category == that.category
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, spokenBy, category)
    }
}
package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "language_category", schema = "public", catalog = "charactermanager")
class LanguageCategoryEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @OneToMany(
            mappedBy = "category",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<LanguageEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as LanguageCategoryEntity
        return id == that.id &&
                name == that.name
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name)
    }
}
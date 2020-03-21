package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "language_category", schema = "public", catalog = "charactermanager")
class LanguageCategoryEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

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
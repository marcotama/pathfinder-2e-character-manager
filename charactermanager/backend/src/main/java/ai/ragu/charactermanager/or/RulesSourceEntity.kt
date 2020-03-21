package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "rules_source", schema = "public", catalog = "charactermanager")
class RulesSourceEntity {
    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @Column(name = "url", nullable = false, length = -1)
    lateinit var url: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as RulesSourceEntity
        return id == that.id &&
                name == that.name &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, url)
    }
}
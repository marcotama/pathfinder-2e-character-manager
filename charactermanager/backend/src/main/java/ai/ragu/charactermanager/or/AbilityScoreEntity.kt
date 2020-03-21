package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ability_score", schema = "public", catalog = "charactermanager")
class AbilityScoreEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @Column(name = "description", nullable = false, length = -1)
    lateinit var description: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AbilityScoreEntity
        return id == that.id &&
                name == that.name &&
                description == that.description
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, description)
    }
}
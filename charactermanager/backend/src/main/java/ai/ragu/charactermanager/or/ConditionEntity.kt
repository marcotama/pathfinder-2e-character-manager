package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "condition", schema = "public", catalog = "charactermanager")
class ConditionEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "value", nullable = true, length = -1)
    lateinit var value: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as ConditionEntity
        return id == that.id &&
                name == that.name &&
                value == that.value &&
                description == that.description
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, value, description)
    }
}
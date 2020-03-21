package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "training_level", schema = "public", catalog = "charactermanager")
class TrainingLevelEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @Column(name = "level_bonus", nullable = false)
    var isLevelBonus: Boolean = false

    @Column(name = "flat_bonus", nullable = false)
    var flatBonus: Short = 0

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as TrainingLevelEntity
        return isLevelBonus == that.isLevelBonus && flatBonus == that.flatBonus &&
                id == that.id &&
                name == that.name
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, isLevelBonus, flatBonus)
    }
}
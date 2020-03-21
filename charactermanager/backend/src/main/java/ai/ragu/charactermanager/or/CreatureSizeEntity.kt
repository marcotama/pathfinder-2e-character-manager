package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "creature_size", schema = "public", catalog = "charactermanager")
class CreatureSizeEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @Column(name = "space", nullable = false, length = -1)
    lateinit var space: String

    @Column(name = "reach_tall", nullable = false, length = -1)
    lateinit var reachTall: String

    @Column(name = "reach_long", nullable = false, length = -1)
    lateinit var reachLong: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as CreatureSizeEntity
        return id == that.id &&
                name == that.name &&
                space == that.space &&
                reachTall == that.reachTall &&
                reachLong == that.reachLong
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, space, reachTall, reachLong)
    }
}
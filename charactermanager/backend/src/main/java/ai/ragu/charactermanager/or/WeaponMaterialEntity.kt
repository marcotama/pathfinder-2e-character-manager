package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "weapon_material", schema = "public", catalog = "charactermanager")
class WeaponMaterialEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "level", nullable = true)
    var level: Int = 0

    @Column(name = "reduces_bulk", nullable = true, length = -1)
    lateinit var reducesBulk: String

    @Column(name = "base", nullable = true)
    var base: Int = 0

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as WeaponMaterialEntity
        return id == that.id &&
                name == that.name &&
                level == that.level &&
                reducesBulk == that.reducesBulk &&
                base == that.base &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, level, reducesBulk, base, description, src, url)
    }
}
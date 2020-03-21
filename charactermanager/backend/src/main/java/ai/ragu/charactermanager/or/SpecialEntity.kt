package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "special", schema = "public", catalog = "charactermanager")
class SpecialEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "category", nullable = true, length = -1)
    lateinit var category: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @Column(name = "description", nullable = false, length = -1)
    lateinit var description: String

    @Column(name = "level", nullable = true)
    var level: Short = 0

    @Column(name = "actions", nullable = true, length = -1)
    lateinit var actions: String

    @Column(name = "requirements", nullable = true, length = -1)
    lateinit var requirements: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpecialEntity
        return id == that.id &&
                category == that.category &&
                name == that.name &&
                description == that.description &&
                level == that.level &&
                actions == that.actions &&
                requirements == that.requirements &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, category, name, description, level, actions, requirements, src, url)
    }
}
package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "class", schema = "public", catalog = "charactermanager")
class ClazzEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

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
        val that = other as ClazzEntity
        return id == that.id &&
                name == that.name &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, description, src, url)
    }
}
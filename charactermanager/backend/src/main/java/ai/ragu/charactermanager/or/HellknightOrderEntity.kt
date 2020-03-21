package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "hellknight_order", schema = "public", catalog = "charactermanager")
class HellknightOrderEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "lesser_name", nullable = true, length = -1)
    lateinit var lesserName: String

    @Column(name = "lesser_action", nullable = true, length = -1)
    lateinit var lesserAction: String

    @Column(name = "lesser_traits", nullable = true, length = -1)
    lateinit var lesserTraits: String

    @Column(name = "lesser_description", nullable = true, length = -1)
    lateinit var lesserDescription: String

    @Column(name = "greater_name", nullable = true, length = -1)
    lateinit var greaterName: String

    @Column(name = "greater_action", nullable = true, length = -1)
    lateinit var greaterAction: String

    @Column(name = "greater_traits", nullable = true, length = -1)
    lateinit var greaterTraits: String

    @Column(name = "greater_description", nullable = true, length = -1)
    lateinit var greaterDescription: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @Column(name = "weapon", nullable = true, length = -1)
    lateinit var weapon: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as HellknightOrderEntity
        return id == that.id &&
                name == that.name &&
                lesserName == that.lesserName &&
                lesserAction == that.lesserAction &&
                lesserTraits == that.lesserTraits &&
                lesserDescription == that.lesserDescription &&
                greaterName == that.greaterName &&
                greaterAction == that.greaterAction &&
                greaterTraits == that.greaterTraits &&
                greaterDescription == that.greaterDescription &&
                description == that.description &&
                weapon == that.weapon &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, lesserName, lesserAction, lesserTraits, lesserDescription, greaterName, greaterAction, greaterTraits, greaterDescription, description, weapon, src, url)
    }
}
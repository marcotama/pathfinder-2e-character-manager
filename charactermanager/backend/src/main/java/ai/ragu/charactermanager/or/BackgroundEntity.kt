package ai.ragu.charactermanager.or

import ai.ragu.charactermanager.pojo.AbilityScore
import ai.ragu.charactermanager.pojo.Feat
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "background", schema = "public", catalog = "charactermanager")
class BackgroundEntity {
    
    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boost_ref_1")
    lateinit var boostRef1: AbilityScore

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boost_ref_2")
    lateinit var boostRef2: AbilityScore

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "free_feat_id")
    lateinit var freeFeat: Feat

    @Column(name = "free_feat_detail", nullable = true, length = -1)
    lateinit var freeFeatDetail: String

    @Column(name = "lore", nullable = true, length = -1)
    lateinit var lore: String

    @Column(name = "skill", nullable = true, length = -1)
    lateinit var skill: String

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
        val that = other as BackgroundEntity
        return id == that.id &&
                name == that.name &&
                boostRef1 == that.boostRef1 &&
                boostRef2 == that.boostRef2 &&
                freeFeat == that.freeFeat &&
                freeFeatDetail == that.freeFeatDetail &&
                lore == that.lore &&
                skill == that.skill &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, boostRef1, boostRef2, freeFeat, freeFeatDetail, lore, skill, description, src, url)
    }
}
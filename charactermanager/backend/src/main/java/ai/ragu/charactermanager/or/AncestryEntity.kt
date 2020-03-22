package ai.ragu.charactermanager.or

import ai.ragu.charactermanager.pojo.AbilityScore
import ai.ragu.charactermanager.pojo.Language
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "ancestry", schema = "public", catalog = "charactermanager")
class AncestryEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "base_hit_points", nullable = false)
    var baseHitPoints: Short = 0

    @Column(name = "num_free_ability_boosts", nullable = false)
    var numFreeAbilityBoosts: Short = 0

    @Column(name = "ancestry_feat_levels", nullable = false)
    var ancestryFeatLevels: Short = 0

    @Column(name = "description", nullable = false, length = -1)
    lateinit var description: String

    @Column(name = "num_free_languages", nullable = false)
    var numFreeLanguages: Short = 0

    @Column(name = "size", nullable = false, length = -1)
    lateinit var size: String

    @Column(name = "speed", nullable = false)
    var speed: Short = 0

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = false, length = -1)
    lateinit var url: String

    @ManyToMany(
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "ancestry_ability_boosts",
            joinColumns = [JoinColumn(name = "ancestry_id")],
            inverseJoinColumns = [JoinColumn(name = "ability_score_id")]
    )
    lateinit var abilityBoosts: Set<AbilityScore>

    @ManyToMany(
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "ancestry_ability_flaws",
            joinColumns = [JoinColumn(name = "ancestry_id")],
            inverseJoinColumns = [JoinColumn(name = "ability_score_id")]
    )
    lateinit var abilityFlaws: Set<AbilityScore>

    @ManyToMany(
            cascade = [CascadeType.ALL]
    )
    @JoinTable(
            name = "ancestry_language",
            joinColumns = [JoinColumn(name = "ancestry_id")],
            inverseJoinColumns = [JoinColumn(name = "language_id")]
    )
    lateinit var languages: Set<Language>

    @OneToMany(
            mappedBy = "ancestry",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<AncestryTraitEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as AncestryEntity
        return baseHitPoints == that.baseHitPoints &&
                numFreeAbilityBoosts == that.numFreeAbilityBoosts &&
                numFreeLanguages == that.numFreeLanguages &&
                speed == that.speed &&
                id == that.id &&
                name == that.name &&
                ancestryFeatLevels == that.ancestryFeatLevels &&
                description == that.description &&
                size == that.size &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, baseHitPoints, numFreeAbilityBoosts, ancestryFeatLevels, description, numFreeLanguages, size, speed, src, url)
    }
}
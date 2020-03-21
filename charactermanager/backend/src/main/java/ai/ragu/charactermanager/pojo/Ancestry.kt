package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "ancestry")
class Ancestry : AbstractJpaPersistable<Long>() {

    @Id
    @Column(nullable = false)
    lateinit var id: String

    @Column(nullable = false)
    lateinit var name: String

    @Column(nullable = false)
    lateinit var description: String

    @Column(nullable = false)
    var baseHitPoints: Long = 0

    @Column(nullable = false)
    var numFreeAbilityBoosts: Long = 0

    @Column(nullable = false)
    var ancestryFeatLevels: Long = 0

    @Column(nullable = false)
    var numFreeLanguages: Long = 0

    @Column(nullable = false)
    var speed: Long = 0

    @Column(nullable = false)
    lateinit var size: String

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSource

    @Column(nullable = false)
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
            mappedBy = "ancestryId",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<AncestryTrait>
}
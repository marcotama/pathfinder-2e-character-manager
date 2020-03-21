package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "ancestry")
class Ancestry : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var description: String

    @Column
    var baseHitPoints: Long = 0

    @Column
    var numFreeAbilityBoosts: Long = 0

    @Column
    var ancestryFeatLevels: Long = 0

    @Column
    var numFreeLanguages: Long = 0

    @Column
    var speed: Long = 0

    @Column
    lateinit var size: String

    @Column
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSource

    @Column
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
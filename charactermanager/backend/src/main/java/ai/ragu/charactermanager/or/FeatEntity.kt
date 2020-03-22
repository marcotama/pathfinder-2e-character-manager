package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feat", schema = "public", catalog = "charactermanager")
class FeatEntity {
    @Column(name = "id", nullable = false, length = -1)
    @Id
    lateinit var id: String

    @Column(name = "category", nullable = true, length = -1)
    lateinit var category: String

    @Column(name = "name", nullable = false, length = -1)
    lateinit var name: String

    @Column(name = "level", nullable = true)
    var level: Short = 0

    @Column(name = "actions", nullable = true, length = -1)
    lateinit var actions: String

    @Column(name = "description", nullable = false, length = -1)
    lateinit var description: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var abilityScoreRequirements: Set<FeatAbilityScoreRequirementEntity>

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var animalCompanionRequirements: Set<FeatAnimalCompanionRequirementEntity>

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var familiarRequirements: Set<FeatFamiliarRequirementEntity>

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var featRequirements: Set<FeatFeatRequirementEntity>

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var magicRequirements: Set<FeatMagicRequirementEntity>

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var skillRequirements: Set<FeatSkillRequirementEntity>

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var specialRequirements: Set<FeatSpecialRequirementEntity>

    @OneToMany(
            mappedBy = "feat",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<FeatTraitEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as FeatEntity
        return id == that.id &&
                category == that.category &&
                name == that.name &&
                level == that.level &&
                actions == that.actions &&
                description == that.description &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, category, name, level, actions, description, src, url)
    }
}
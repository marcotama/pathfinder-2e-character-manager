package ai.ragu.charactermanager.or

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "spell", schema = "public", catalog = "charactermanager")
class SpellEntity {

    @Id
    @Column(name = "id", nullable = false, length = -1)
    lateinit var id: String

    @Column(name = "name", nullable = true, length = -1)
    lateinit var name: String

    @Column(name = "type", nullable = true, length = -1)
    lateinit var type: String

    @Column(name = "level", nullable = true)
    var level: Int = 0

    @Column(name = "traditions", nullable = true, length = -1)
    lateinit var traditions: String

    @Column(name = "actions", nullable = true, length = -1)
    lateinit var actions: String

    @Column(name = "cast", nullable = true, length = -1)
    lateinit var cast: String

    @Column(name = "description", nullable = true, length = -1)
    lateinit var description: String

    @Column(name = "short_description", nullable = true, length = -1)
    lateinit var shortDescription: String

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "src")
    lateinit var src: RulesSourceEntity

    @Column(name = "url", nullable = true, length = -1)
    lateinit var url: String

    @ManyToMany(
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "spell_list_item",
            joinColumns = [JoinColumn(name = "spell_list_id")],
            inverseJoinColumns = [JoinColumn(name = "spell_id")]
    )
    lateinit var spellLists: Set<SpellListEntity>

    @OneToMany(
            mappedBy = "spell",
            cascade = [CascadeType.ALL],
            fetch = FetchType.EAGER
    )
    lateinit var traits: Set<SpellTraitEntity>

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SpellEntity
        return id == that.id &&
                name == that.name &&
                type == that.type &&
                level == that.level &&
                traditions == that.traditions &&
                actions == that.actions &&
                cast == that.cast &&
                description == that.description &&
                shortDescription == that.shortDescription &&
                src == that.src &&
                url == that.url
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, type, level, traditions, actions, cast, description, shortDescription, src, url)
    }
}
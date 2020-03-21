package ai.ragu.charactermanager.pojo

import AbstractJpaPersistable
import javax.persistence.*

@Entity
@Table(name = "spell")
class Spell : AbstractJpaPersistable<Long>() {

    @Id
    @Column
    lateinit var id: String

    @Column
    lateinit var name: String

    @Column
    lateinit var type: String

    @Column
    var level: Long = 0

    @Column
    lateinit var traditions: String

    @Column
    lateinit var actions: String

    @Column
    lateinit var cast: String

    @Column
    lateinit var description: String

    @Column
    lateinit var shortDescription: String

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
            name = "spell_list_item",
            joinColumns = [JoinColumn(name = "spell_id")],
            inverseJoinColumns = [JoinColumn(name = "spell_list_id")]
    )
    lateinit var spellLists: Set<SpellList>
}